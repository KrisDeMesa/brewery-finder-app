package com.techelevator.service;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import exception.DaoException;
import exception.ResourceNotFoundException;
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
        try {
            return breweryDao.getBreweryById(id);
        } catch (DaoException ex) {
            throw new ResourceNotFoundException("No brewery found for the ID provided");
        }
    }
}
