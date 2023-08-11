package com.techelevator.controller;

import com.techelevator.exception.CreationFailureException;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.LinkFailureException;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.openbrewerydb.exception.OpenBreweryDBException;
import com.techelevator.openbrewerydb.model.OpenBreweryDTO;
import com.techelevator.service.BeerService;
import com.techelevator.service.BreweryService;
import com.techelevator.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
public class BreweryController {

    private final BreweryService breweryService;

    private final BeerService beerService;

    public BreweryController(BreweryService breweryService, BeerService beerService) {
        this.breweryService = breweryService;
        this.beerService = beerService;
    }

    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        return breweryService.getBreweries();
    }

    @GetMapping("/breweries/open")
    public List<Brewery> getBreweriesOpen(@RequestParam(required = false) String city) {
        try {
            return breweryService.getOpenDBBreweries(city);
        } catch (OpenBreweryDBException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @GetMapping("/breweries/{id}")
    public Brewery getBreweryById(@PathVariable Integer id) {
        try {
            return breweryService.getBreweryById(id);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PutMapping("/breweries/{id}")
    public void updateBrewery(@RequestBody Brewery brewery, @PathVariable Integer id) {
        if (id != brewery.getId()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id in URL did not match Id in Brewery object");
        }
        try {
            breweryService.updateBrewery(brewery, id);
        } catch (DaoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    @GetMapping("/breweries/{id}/beers")
    public List<Beer> getBeers(@PathVariable int id) {
        return beerService.getBeers(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/breweries/{id}/beers")
    public Beer addBeer(@RequestBody Beer newBeer, @PathVariable Integer id) {
        try {
            return beerService.addBeer(newBeer, id);
        } catch (CreationFailureException | LinkFailureException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


}

