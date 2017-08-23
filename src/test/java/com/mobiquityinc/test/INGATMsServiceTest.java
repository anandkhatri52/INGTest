package com.mobiquityinc.test;

import com.mobiquityinc.contextconfig.AppContextConfig;
import com.mobiquityinc.model.INGATMsResponse;
import com.mobiquityinc.service.INGService;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by anandkhatri on 10/25/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class INGATMsServiceTest {

    @Autowired
    INGService ingService;

    @Test
    public void testGetINGATMs(){

        String cityName = "Ahmedabad";
        List<INGATMsResponse> responseList = ingService.getINGATMsByCity(cityName);
        Assert.assertThat(responseList, not(IsEmptyCollection.empty()));

    }
}


