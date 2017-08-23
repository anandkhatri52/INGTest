package com.mobiquityinc.contextconfig;

import com.mobiquityinc.endpoint.INGEndPoint;
import com.mobiquityinc.service.INGService;
import com.mobiquityinc.service.impl.INGServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.springframework.web.filter.RequestContextFilter;

/**
 * Created by anandkhatri on 10/24/16.
 */
public class INGApplication extends ResourceConfig {

    public INGApplication() {
        register(RequestContextFilter.class);
        register(RolesAllowedDynamicFeature.class);
        register(INGEndPoint.class);
    }
}
