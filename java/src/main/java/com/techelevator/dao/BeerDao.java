package com.techelevator.dao;

import com.techelevator.exception.ResourceNotFoundException;
import com.techelevator.model.Beer;
import com.techelevator.model.BeerRating;
import com.techelevator.model.BeerReview;

import java.util.List;

public interface BeerDao {

    List<Beer> getBeers(int breweryId);

    Beer addBeer(Beer newBeer);

    void linkBreweryBeer(int breweryId, int beerId);

    List<BeerRating> getRatingsByUser(int userId);

    List<BeerRating> getRatingsByBeer(int beerId, int breweryId) throws ResourceNotFoundException;

    BeerRating addBeerRating(BeerRating rating);

    List<BeerReview> getReviewsByUser(int userId);

    List<BeerReview> getReviewsByBeer(int beerId, int breweryId) throws ResourceNotFoundException;

    BeerReview addBeerReview(BeerReview review);

}
