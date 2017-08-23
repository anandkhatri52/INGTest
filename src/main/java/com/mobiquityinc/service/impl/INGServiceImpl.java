package com.mobiquityinc.service.impl;

import com.mobiquityinc.apigateway.http.PoolableHttpClient;
import com.mobiquityinc.apigateway.http.PoolableHttpRequestBase;
import com.mobiquityinc.apigateway.http.PoolableHttpResponse;
import com.mobiquityinc.model.INGATMsResponse;
import com.mobiquityinc.service.INGService;
import com.mobiquityinc.util.JsonMapper;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anandkhatri on 10/24/16.
 */
@Service("ingService")
public class INGServiceImpl implements INGService{

    private static final Logger LOGGER = Logger.getLogger(INGServiceImpl.class);

    @Autowired
    PoolableHttpClient poolableHttpClient;

    @Value("${ing.atms.base.url}")
    private String baseUrl;

    public List<INGATMsResponse> getINGATMsByCity(String cityName){

        LOGGER.debug("get ING ATMs by city. - BEING");

        try {
            PoolableHttpResponse poolableHttpResponse = poolableHttpClient.doRequest(
                    new PoolableHttpRequestBase(PoolableHttpRequestBase.Type.GET, baseUrl).accept("application/json")
                            .create());

            if (poolableHttpResponse.getResponseCode() == HttpStatus.SC_OK) {
                LOGGER.info("SUCCESS - ING get ATMs api");
                String body = poolableHttpResponse.getBody().substring(poolableHttpResponse.getBody().indexOf(',')+1);
                LOGGER.info("response body > "+body);


                List<INGATMsResponse> ingatMsResponseList = JsonMapper.mapToINGATMsResponse(body);

                //TODO Get ATMs by City
               /* List<INGATMsResponse> returnList = null;
                for(INGATMsResponse ingatMsResponse : ingatMsResponseList){
                    if(ingatMsResponse.getAddress().getCity().equals(cityName)){
                        returnList.add(ingatMsResponse);
                    }
                }
                if(returnList!= null && !returnList.isEmpty()){
                    return returnList;
                }else{
                    return ingatMsResponseList;
                }*/

                return ingatMsResponseList;
            } else {
                LOGGER.debug("Something went wrong while calling ING ATMs apis.");
            }
        } catch (Exception exe) {
            LOGGER.error("Error while calling getINGATMsByCity: ", exe);
        }
        return null;
    }
}
