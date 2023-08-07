package com.techelevator.dao;

import com.techelevator.exception.ResourceNotFoundException;
import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    List<Brewery> getBreweries();

    Brewery getBreweryById(Integer id) throws ResourceNotFoundException;

}
