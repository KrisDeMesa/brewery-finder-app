package com.techelevator.service;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ResourceNotFoundException;
import com.techelevator.openbrewerydb.OpenBreweryDTO;
import com.techelevator.openbrewerydb.service.OpenBreweryDBService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryService {

    private BreweryDao breweryDao;
    private OpenBreweryDBService openBreweryService;

    public BreweryService(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    public List<Brewery> getBreweries() {
        return breweryDao.getBreweries();
    }

    public OpenBreweryDTO[] getOpenDBBreweries() {
        return openBreweryService.getOpenBreweryList();
    }

    public Brewery getBreweryById(Integer id) throws ResourceNotFoundException {
        return breweryDao.getBreweryById(id);
    }

}
