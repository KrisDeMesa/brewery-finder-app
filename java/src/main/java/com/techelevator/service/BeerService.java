package com.techelevator.service;

import com.techelevator.dao.BeerDao;
import com.techelevator.exception.CreationFailureException;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.LinkFailureException;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private BeerDao beerDao;

    public BeerService(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    public List<Beer> getBeers(int breweryId) {
        return beerDao.getBeers(breweryId);
    }

    public Beer addBeer(Beer newBeer, Integer breweryId) {
        Beer savedbeer = null;
        try {
            savedbeer = beerDao.addBeer(newBeer);
        } catch (DaoException ex) {
            throw new CreationFailureException(ex.getMessage());
        }
        linkBreweryBeer(newBeer, breweryId);
        return savedbeer;
    }

    public void linkBreweryBeer(Beer beer, Integer breweryId) {
        try {
            beerDao.linkBreweryBeer(breweryId, beer.getId());
        } catch (DaoException ex) {
            throw new LinkFailureException(ex.getMessage());
        }
    }
}
