package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.AccountRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:06
 */
@Component("accountRepositoryJdbcImpl")
@Profile("jdbc")
public class AccountRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements AccountRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountRepositoryJdbcImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public AccountRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
