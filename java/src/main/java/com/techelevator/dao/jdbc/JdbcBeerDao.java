package com.techelevator.dao.jdbc;

import com.techelevator.dao.BeerDao;
import com.techelevator.dao.jdbc.mapper.BeerMapper;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
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
        try {
            String sql = "SELECT * FROM beer\n" +
                    "WHERE beer_id IN (SELECT beer_id FROM brewery_beer \n" +
                    "WHERE brewery_id = ?);";
            return jdbcTemplate.query(sql, new Object[]{breweryId}, beerMapper);
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
}
