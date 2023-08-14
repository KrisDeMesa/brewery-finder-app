package com.techelevator.dao.jdbc;

import com.techelevator.dao.BeerDao;
import com.techelevator.dao.jdbc.mapper.BeerMapper;
import com.techelevator.dao.jdbc.mapper.RatingsMapper;
import com.techelevator.dao.jdbc.mapper.ReviewsMapper;
import com.techelevator.exception.DaoException;
import com.techelevator.exception.ResourceNotFoundException;
import com.techelevator.model.Beer;
import com.techelevator.model.BeerRating;
import com.techelevator.model.BeerReview;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao {
    private final JdbcTemplate jdbcTemplate;

    private final BeerMapper beerMapper = new BeerMapper();
    private final RatingsMapper ratingsMapper = new RatingsMapper();
    private final ReviewsMapper reviewsMapper = new ReviewsMapper();

    public JdbcBeerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Beer> getBeers(int breweryId) {
        String sql = "SELECT * FROM beer\n" +
                "WHERE beer_id IN (SELECT beer_id FROM brewery_beer \n" +
                "WHERE brewery_id = ?);";
        try {
            return jdbcTemplate.query(sql, new Object[]{breweryId}, beerMapper);
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    public Beer addBeer(Beer newBeer) {
        String sql = "INSERT INTO beer VALUES (DEFAULT, ?, ?, ?, ?) RETURNING beer_id";
        try {
            Integer newBeerId = jdbcTemplate.queryForObject(sql, Integer.class, newBeer.getName(), newBeer.getDescription(),
                    newBeer.getAbv(), newBeer.getType());
            newBeer.setId(newBeerId);
            return newBeer;
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    public void linkBreweryBeer(int breweryId, int beerId) {
        String sql = "INSERT INTO brewery_beer VALUES (?, ?)";
        try {
            int rowAdded = jdbcTemplate.update(sql, breweryId, beerId);
            if (rowAdded == 0) {
                throw new DaoException("No records inserted");
            }
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    public List<BeerRating> getRatingsByUser(int userId) {
        String sql = "SELECT * FROM rating WHERE user_id = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{userId}, ratingsMapper);
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    public List<BeerRating> getRatingsByBeer(int beerId, int breweryId) throws ResourceNotFoundException {
        String sql = "SELECT * FROM rating r\n" +
                "JOIN beer b ON r.beer_id = b.beer_id\n" +
                "JOIN brewery_beer b_b on b_b.beer_id = b.beer_id\n" +
                "WHERE b.beer_id = ? AND b_b.brewery_id = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{beerId, breweryId}, ratingsMapper);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Couldn't find beer with id " + beerId);
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    public BeerRating addBeerRating(BeerRating newRating) {
        String sql = "INSERT INTO rating VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, newRating.getUserId(), newRating.getBeerId(),
                    newRating.getAmount());
            return newRating;
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    public List<BeerReview> getReviewsByUser(int userId) {
        String sql = "SELECT * FROM review WHERE user_id = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{userId}, reviewsMapper);
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    public List<BeerReview> getReviewsByBeer(int beerId, int breweryId) throws ResourceNotFoundException {
        String sql = "SELECT * FROM review r\n" +
                "JOIN beer b ON r.beer_id = b.beer_id\n" +
                "JOIN brewery_beer b_b on b_b.beer_id = b.beer_id\n" +
                "WHERE b.beer_id = ? AND b_b.brewery_id = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{beerId, breweryId}, reviewsMapper);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Couldn't find beer with id " + beerId);
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    public BeerReview addBeerReview(BeerReview newReview) {
        String sql = "INSERT INTO review VALUES (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, newReview.getUserId(), newReview.getBeerId(),
                    newReview.getTitle(), newReview.getDescription());
            return newReview;
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }
}
