package com.cmc.credagility.core.repository.jdbc.impl;

import com.cmc.credagility.core.repository.jdbc.ResponsibleRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:22
 */
@Component("responsibleRepositoryJdbc")
@Profile("jdbc")
public class ResponsibleRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements ResponsibleRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public ResponsibleRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.repository.jdbc.ResponsibleRepositoryJdbc#listCustomerBorrowers(Long, Long)
   */
  @Override public Map<Long, String> listCustomerBorrowers(Long currentCustomerId, Long loggedInCustomerId) {
    Map<Long, String> result = new LinkedHashMap<Long, String>();
    RowMapper<Long> mapper = new RowMapper<Long>() {
      @Override public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.put(rs.getLong(1), rs.getString(2));

        return rs.getLong(1);
      }
    };

    getJdbcTemplate().query("SELECT DISTINCT r1.responsibleId, r2.responsibleId "
      + "FROM Responsible r1 CROSS JOIN ResponsibleIndex ri1 CROSS JOIN Account a1\n"
      + "LEFT JOIN (select r2.responsibleId, r2.customerType, r2.accountNum, ri2.customerInfoId from Responsible r2 \n"
      + "INNER JOIN ResponsibleIndex ri2 on r2.responsibleId = ri2.responsibleId and ri2.customerInfoId = ? where r2.customerType != 'S') r2 \n"
      + "on r1.accountNum = r2.accountNum WHERE r1.responsibleId = ri1.responsibleId AND r1.accountNum = a1.accountNum \n"
      + "AND r1.customerType = 'P' AND ri1.customerInfoId = ? AND a1.active = 'Y' AND  a1.clientDefinedFlag1 = 'Y' AND a1.allowWeb = 'Y';", mapper,
      loggedInCustomerId, currentCustomerId);

    return result;
  }

  /**
   * @see  com.cmc.credagility.core.repository.jdbc.ResponsibleRepositoryJdbc#listCustomerBorrowers(Long, Long, java.util.List)
   */
  @Override public Map<Long, String> listCustomerBorrowers(Long currentCustomerId, Long loggedInCustomerId, List<Long> portfolioIds) {
    Map<Long, String> result = new LinkedHashMap<Long, String>();
    RowMapper<Long> mapper = new RowMapper<Long>() {
      @Override public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.put(rs.getLong(1), rs.getString(2));

        return rs.getLong(1);
      }
    };

    String portfolioIdsString = portfolioIds.stream ().map (i -> i.toString ()).collect (Collectors.joining (","));

    getJdbcTemplate().query("SELECT DISTINCT r1.responsibleId, r2.responsibleId "
                    + "FROM Responsible r1 CROSS JOIN ResponsibleIndex ri1 CROSS JOIN Account a1\n"
                    + "LEFT JOIN (select r2.responsibleId, r2.customerType, r2.accountNum, ri2.customerInfoId from Responsible r2 \n"
                    + "INNER JOIN ResponsibleIndex ri2 on r2.responsibleId = ri2.responsibleId and ri2.customerInfoId = ? where r2.customerType != 'S') r2 \n"
                    + "on r1.accountNum = r2.accountNum WHERE r1.responsibleId = ri1.responsibleId AND r1.accountNum = a1.accountNum and a1.portfolioId in (?) \n"
                    + "AND r1.customerType = 'P' AND ri1.customerInfoId = ? AND a1.active = 'Y' AND  a1.clientDefinedFlag1 = 'Y' AND a1.allowWeb = 'Y';", mapper,
            loggedInCustomerId, portfolioIdsString, currentCustomerId);

    return result;
  }
} // end class ResponsibleRepositoryJdbcImpl
