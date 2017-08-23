package com.mobiquityinc.endpoint;

import com.mobiquityinc.model.INGATMsResponse;
import com.mobiquityinc.service.INGService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anandkhatri on 10/24/16.
 */
@Path("/ing")
@Component
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class INGEndPoint {

    private static final Logger LOGGER = Logger.getLogger(INGEndPoint.class);

    @Autowired
    private INGService ingService;

//    @Autowired
//    DefaultTokenServices defaultTokenServices;

//    @RolesAllowed({"ROLE_USER"})
    @PermitAll
    @GET
    @Path(value = "/{cityName}")
    public List<INGATMsResponse> getINGATMs(@PathParam(value = "cityName") String cityName) throws Exception {

        LOGGER.info("Requested city is :" + cityName);
        return ingService.getINGATMsByCity(cityName);
    }


    /*@PermitAll
    @GET
    @Path(value = "/oauth/token/revoke/{tokenValue}")
    public Boolean revokeToken(@PathParam(value = "tokenValue") String tokenValue) throws Exception {

        return defaultTokenServices.revokeToken(tokenValue);
    }*/
}
