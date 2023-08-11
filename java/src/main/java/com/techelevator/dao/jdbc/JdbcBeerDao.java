package com.techelevator.dao.jdbc;

import com.techelevator.dao.BeerDao;
import com.techelevator.dao.jdbc.mapper.BeerMapper;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao {
    private final JdbcTemplate jdbcTemplate;

    private final BeerMapper beerMapper = new BeerMapper();

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
            int rowAdded= jdbcTemplate.update(sql, breweryId, beerId);
            if (rowAdded == 0) {
                throw new DaoException("No records inserted");
            }
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }
}
