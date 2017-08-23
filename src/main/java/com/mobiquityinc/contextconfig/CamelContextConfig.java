package com.mobiquityinc.contextconfig;

import com.mobiquityinc.processor.INGATMProcessor;
import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.spring.security.SpringSecurityAccessPolicy;
import org.apache.camel.component.spring.security.SpringSecurityAuthorizationPolicy;
import org.apache.camel.spi.Policy;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandkhatri on 10/28/16.
 */
@Configurable
public class CamelContextConfig extends CamelConfiguration{


    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> voterList = new ArrayList<>();
        voterList.add(new RoleVoter());
        AffirmativeBased affirmativeBased = new AffirmativeBased(voterList);
        affirmativeBased.setAllowIfAllAbstainDecisions(true);
        return affirmativeBased;
    }

    @Bean(name = "admin")
    public SpringSecurityAuthorizationPolicy adminPolicy() throws Exception {
        SpringSecurityAuthorizationPolicy authorizationPolicy = new SpringSecurityAuthorizationPolicy();
        authorizationPolicy.setId("admin");
        authorizationPolicy.setSpringSecurityAccessPolicy(new SpringSecurityAccessPolicy("ROLE_ADMIN"));
        authorizationPolicy.setAuthenticationManager(authenticationManager);
        authorizationPolicy.setAccessDecisionManager(accessDecisionManager());
        return authorizationPolicy;
    }

    @Bean(name = "user")
    public SpringSecurityAuthorizationPolicy userPolicy() throws Exception {
        SpringSecurityAuthorizationPolicy authorizationPolicy = new SpringSecurityAuthorizationPolicy();
        authorizationPolicy.setId("user");
        authorizationPolicy.setSpringSecurityAccessPolicy(new SpringSecurityAccessPolicy("ROLE_USER"));
        authorizationPolicy.setAuthenticationManager(authenticationManager);
        authorizationPolicy.setAccessDecisionManager(accessDecisionManager());
        return authorizationPolicy;
    }


    @Bean
    public RouteBuilder userRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                onException(CamelAuthorizationException.class)
                        .handled(true)
                        .transform().simple("{\"error\": \"Access is denied\" }");

                from("servlet:user")
                        .policy(userPolicy())
                        .to("direct:getATMs");


            }
        };

    }

    @Bean
    public RouteBuilder adminRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("servlet:admin")
                        .policy(adminPolicy())
                        .transform(simple("Call the admin operation OK"));
            }
        };

    }


    @Bean
    public RouteBuilder retrieveATMsRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                System.out.println("retrieveATMsRoute is called");
                from("direct:getATMs")
                        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                        .to("https://www.ing.nl/api/locator/atms/?bridgeEndpoint=true");
            }
        };

    }



    @Bean
    /**
     *  currently not in use
     */
    public INGATMProcessor ingatmProcessor(){
        return new INGATMProcessor();
    }


}
