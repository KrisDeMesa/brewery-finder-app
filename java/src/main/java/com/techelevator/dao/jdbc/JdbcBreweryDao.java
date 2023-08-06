package com.techelevator.dao.jdbc;

import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.jdbc.mapper.BreweryMapper;
import com.techelevator.model.Brewery;
import com.techelevator.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    private final JdbcTemplate jdbcTemplate;

    private final BreweryMapper breweryMapper = new BreweryMapper();

    public JdbcBreweryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Brewery> getBreweries() {
        String sql = "SELECT * FROM brewery";
        List<Brewery> breweries = jdbcTemplate.query(sql, breweryMapper);
        return breweries;
    }

    public Brewery getBreweryById(Integer id) {
        String sql = "SELECT * FROM brewery WHERE brewery_id = ?";

        try {
            Brewery brewery = jdbcTemplate.queryForObject(sql, new Object[]{id}, breweryMapper);
            return brewery;
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
    }
}
