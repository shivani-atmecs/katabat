package com.cmc.credagility.core.repository.jdbc.impl;


import com.cmc.credagility.core.domain.CurrencySymbolPosition;
import com.cmc.credagility.core.repository.jdbc.CustomerPortalPreferredLanguagesJdbc;
import com.cmc.credagility.core.repository.jdbc.ResponsibleRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:22
 */
@Component("CustomerPortalPreferredLanguagesJdbc")
@Profile("jdbc")
public class CustomerPortalPreferredLanguagesJdbcImpl  extends BaseJdbcRepositoryImpl implements CustomerPortalPreferredLanguagesJdbc {

    /**
     * Creates a new BaseJdbcRepositoryImpl object.
     *
     * @param  dataSource  DataSource
     */
    @Autowired
    public CustomerPortalPreferredLanguagesJdbcImpl(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * @see  com.cmc.credagility.core.repository.jdbc.ResponsibleRepositoryJdbc#listCustomerBorrowers(Long, Long)
     */
    @Override public Map<String, String> listPreferredLanguages() {
        Map<String, String> result = new LinkedHashMap<String, String>();
        RowMapper<String> mapper = new RowMapper<String>() {
            @Override public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                result.put(rs.getString(1), rs.getString(2));

                return rs.getString(1);
            }
        };

        getJdbcTemplate().query("SELECT DISTINCT cppl.languageCode, cppl.languageName  "
                        + "FROM CustomerPortalPreferredLanguages cppl;", mapper);

        return result;
    }

    public Map<String, String> getCurrencySymbolMappings() {
        Map<String, String> result = new LinkedHashMap<String, String>();
        RowMapper<String> mapper = new RowMapper<String>() {
            @Override public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                result.put(rs.getString(1), rs.getString(2));

                return rs.getString(1);
            }
        };

        getJdbcTemplate().query("SELECT DISTINCT cppl.languageCode, cppl.currencySymbol  "
                + "FROM CustomerPortalPreferredLanguages cppl;", mapper);

        return result;
    }

    public Map<String, CurrencySymbolPosition> getCurrencySymbolPositionMappings() {
        Map<String, CurrencySymbolPosition> result = new LinkedHashMap<String, CurrencySymbolPosition>();
        RowMapper<String> mapper = new RowMapper<String>() {
            @Override public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                result.put(rs.getString(1), CurrencySymbolPosition.valueOf(rs.getString(2)));

                return rs.getString(1);
            }
        };

        getJdbcTemplate().query("SELECT DISTINCT cppl.languageCode, cppl.currencySymbolPosition  "
                + "FROM CustomerPortalPreferredLanguages cppl;", mapper);

        return result;
    }

}
