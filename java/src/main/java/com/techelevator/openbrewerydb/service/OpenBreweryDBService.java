package com.techelevator.openbrewerydb.service;

import com.techelevator.model.Brewery;
import com.techelevator.openbrewerydb.OpenBreweryDTO;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OpenBreweryDBService {

    private static final String OPEN_BREWERY_DB_BASE_URL = "https://api.openbrewerydb.org/v1/breweries";

    private final RestTemplate restTemplate = new RestTemplate();

    public OpenBreweryDTO[] getOpenBreweryList () {
        OpenBreweryDTO[] breweries = restTemplate.getForObject(OPEN_BREWERY_DB_BASE_URL, OpenBreweryDTO[].class);
        return breweries;
    }

}
