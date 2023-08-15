package com.techelevator.service;

import com.techelevator.dao.BeerDao;
import com.techelevator.exception.*;
import com.techelevator.model.Beer;
import com.techelevator.model.BeerRating;
import com.techelevator.model.BeerReview;
import com.techelevator.model.Brewery;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Beer getBeerById(Integer id) throws ResourceNotFoundException{
        return beerDao.getBeer(id);
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

    public void updateBeer(Beer updatedBeer, int beerId) {
        beerDao.updateBeer(updatedBeer, beerId);
    }

    public List<BeerRating> getRatingsByUser(int userId) {
        return beerDao.getRatingsByUser(userId);
    }

    public List<BeerRating> getRatingsByBeerAndBrewery(int beerId, int breweryId) throws ResourceNotFoundException {
        return beerDao.getRatingsByBeerAndBrewery(beerId, breweryId);
    }

    public int getAvgRatingByBeerId(int beerId) throws ResourceNotFoundException{
        return beerDao.getAvgRatingByBeerId(beerId);
    }

    public BeerRating addRating(BeerRating newRating) throws DuplicateRatingException {
        try {
            List<BeerRating> existingRatingsForUser = getRatingsByUser(newRating.getUserId());
            for (BeerRating rating : existingRatingsForUser) {
                if (rating.getBeerId() == newRating.getBeerId()) {
                    throw new DuplicateRatingException("You have already rated this beer");
                }
            }
            return beerDao.addBeerRating(newRating);
        } catch (DaoException ex) {
            throw new CreationFailureException(ex.getMessage());
        }
    }

    public List<BeerReview> getReviewsByUser(int userId) {
        return beerDao.getReviewsByUser(userId);
    }

    public List<BeerReview> getReviewsByBeerAndBrewery(int beerId, int breweryId) throws ResourceNotFoundException {
        return beerDao.getReviewsByBeerAndBrewery(beerId, breweryId);
    }

    public List<BeerReview> getReviewsByBeerId(int beerId) throws ResourceNotFoundException{
        return beerDao.getReviewsByBeerId(beerId);
    }


    public BeerReview addReview(BeerReview newReview) throws DuplicateReviewException {
        try {
            List<BeerReview> existingReviewsForUser = getReviewsByUser(newReview.getUserId());
            for (BeerReview review : existingReviewsForUser) {
                if (review.getBeerId() == newReview.getBeerId()) {
                    throw new DuplicateReviewException("You have already reviewed this beer");
                }
            }
            return beerDao.addBeerReview(newReview);
        } catch (DaoException ex) {
            throw new CreationFailureException(ex.getMessage());
        }
    }
}
