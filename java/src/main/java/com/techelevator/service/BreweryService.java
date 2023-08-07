package com.techelevator.service;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryService {

    private BreweryDao breweryDao;

    public BreweryService(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    public List<Brewery> getBreweries() {
        return breweryDao.getBreweries();
    }

    public Brewery getBreweryById(Integer id) throws ResourceNotFoundException {
        return breweryDao.getBreweryById(id);
    }

}
