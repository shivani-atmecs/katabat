package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.AccountActivityRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 14:27
 */
@Component("accountActivityRepositoryJdbcImpl")
@Profile("jdbc")
public class AccountActivityRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements AccountActivityRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountActivityRepositoryJdbcImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public AccountActivityRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
