package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


/**
 * Created by Yang Wang on 2/5/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  02/05/2015 15:00 PM
 */
public class BaseJdbcRepositoryImpl extends JdbcDaoSupport {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  public BaseJdbcRepositoryImpl(DataSource dataSource) {
    setDataSource(dataSource);
  }
}
