package com.techelevator.dao;

import com.techelevator.model.Beer;

import java.util.List;

public interface BeerDao {

    List<Beer> getBeers(int breweryId);

    Beer addBeer(Beer newBeer);

    void linkBreweryBeer(int breweryId, int beerId);
}
