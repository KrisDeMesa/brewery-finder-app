package com.techelevator.dao.jdbc.mapper;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BreweryMapper implements RowMapper<Brewery> {
    @Override
    public Brewery mapRow(ResultSet resultSet, int i) throws SQLException  {
        Brewery brewery = new Brewery();
        brewery.setId(resultSet.getInt("brewery_id"));
        brewery.setBrewerId(resultSet.getInt("brewer"));
        brewery.setName(resultSet.getString("brewery_name"));
        brewery.setHours(resultSet.getString("hours"));
        brewery.setContactInfo(resultSet.getString("contact_info"));
        brewery.setAddress(resultSet.getString("address"));
        brewery.setHistory(resultSet.getString("history"));
        brewery.setActive(resultSet.getBoolean("active"));

//        FUTURE IMPLEMENTATION
//        if (rowSet.getTime("open_time") != null) {
//            brewery.setOpenTime(rowSet.getTime("open_time").toLocalTime());
//        }
//        if (rowSet.getTime("close_time") != null) {
//            brewery.setCloseTime(rowSet.getTime("close_time").toLocalTime());
//        }

        return brewery;
    }
}
