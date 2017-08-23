package com.mobiquityinc.service;

import com.mobiquityinc.model.INGATMsResponse;

import java.util.List;

/**
 * Created by anandkhatri on 10/24/16.
 */
public interface INGService {

    /**
     * Retrieve ING ATMs by given city name.
     *
     * @param cityName  Name of the city
     * @return          List of {@link INGATMsResponse}
     */
    List<INGATMsResponse> getINGATMsByCity(String cityName);
}
