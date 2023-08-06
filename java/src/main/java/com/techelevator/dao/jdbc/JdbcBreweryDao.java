package com.techelevator.dao.jdbc;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import exception.DaoException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Brewery> getBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM brewery";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Brewery newBrewery = mapRowToBrewery(results);
                breweries.add(newBrewery);
            }
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
        return breweries;
    }

    public Brewery getBreweryById(Integer id) {
        Brewery brewery = null;
        String sql = "SELECT * FROM brewery WHERE id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                brewery = mapRowToBrewery(results);
            }
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
        return brewery;
    }

    public Brewery mapRowToBrewery(SqlRowSet rowSet) {
        Brewery brewery = new Brewery();
        brewery.setId(rowSet.getInt("id"));
        brewery.setBrewerId(rowSet.getInt("id"));
        brewery.setName(rowSet.getString("name"));
        brewery.setOpenTime(rowSet.getTime("open_time").toLocalTime()); //ADD ERROR HANDLING
        brewery.setCloseTime(rowSet.getTime("close_time").toLocalTime()); //ADD ERROR HANDLING
        brewery.setAddress(rowSet.getString("address"));
        brewery.setHistory(rowSet.getString("history"));
        brewery.setActive(rowSet.getBoolean("active"));

        return brewery;
    }
}
