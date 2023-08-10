package com.techelevator.service;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
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
}
