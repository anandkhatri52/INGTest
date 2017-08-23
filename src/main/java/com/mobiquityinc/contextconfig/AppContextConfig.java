package com.mobiquityinc.contextconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * Created by anandkhatri on 10/24/16.
 */
@Configuration
@ComponentScan(basePackages = "com.mobiquityinc")
@PropertySource("classpath:application.properties")
@Import({
        WebSecurityConfiguration.class,
        AuthorizationServerConfiguration.class,
        ResourceServerConfiguration.class,
        DSContextConfig.class,
        CamelContextConfig.class
})
public class AppContextConfig {

    @Autowired
    DSContextConfig dsContextConfig;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dsContextConfig.dataSource());
    }
}
