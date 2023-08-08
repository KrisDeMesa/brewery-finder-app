package com.techelevator.service;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import com.techelevator.exception.ResourceNotFoundException;
import com.techelevator.openbrewerydb.model.OpenBreweryDTO;
import com.techelevator.openbrewerydb.service.OpenBreweryDBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryService {

    private BreweryDao breweryDao;
    private OpenBreweryDBService openBreweryService;

    public BreweryService(BreweryDao breweryDao, OpenBreweryDBService openBreweryDBService) {
        this.breweryDao = breweryDao;
        this.openBreweryService = openBreweryDBService;
    }

    public List<Brewery> getBreweries() {
        return breweryDao.getBreweries();
    }

    public OpenBreweryDTO[] getOpenDBBreweries(String city) {
        if (city == null) {
            return openBreweryService.getOpenBreweryList();
        } else {
            return openBreweryService.getOpenBreweryListByCity(city);
        }
    }

//    public OpenBreweryDTO[] getOpenDBBreweriesByCity(String city) {
//        return openBreweryService.getOpenBreweryListByCity(city);
//    }

    public Brewery getBreweryById(Integer id) throws ResourceNotFoundException {
        return breweryDao.getBreweryById(id);
    }

}
