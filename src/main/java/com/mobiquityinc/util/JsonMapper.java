package com.mobiquityinc.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquityinc.model.INGATMsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandkhatri on 10/24/16.
 */
public class JsonMapper {

    public static List<INGATMsResponse> mapToINGATMsResponse(String value) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<INGATMsResponse> responseList = mapper.readValue(value, new TypeReference<ArrayList<INGATMsResponse>>() {});
            return responseList;
        } catch (Exception exc) {
            throw exc;
        }
    }
}
