package com.infoshareacademy.finances.service.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infoshareacademy.finances.model.dto.AssetsSumDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ReportMaxSellClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportMaxSellClient.class);

    public List<AssetsSumDTO> returnMostOftenSoldAssets(){

        Response response = ClientBuilder.newClient()
                .target("http://localhost:8082/api/report/retrieve/"
                        + ReportName.MOST_SOLD_ASSETS).request().get();
        String jsonEntity = response.readEntity(String.class);
        LOGGER.info("{}", jsonEntity);

        Gson gson = new Gson();
        List<AssetsSumDTO> report = gson.fromJson(jsonEntity, new TypeToken<List<AssetsSumDTO>>() {
        }.getType());

        return report;
    }



}
