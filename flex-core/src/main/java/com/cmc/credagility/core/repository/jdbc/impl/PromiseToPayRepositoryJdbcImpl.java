package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.PromiseToPayRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:11
 */
@Component("promiseToPayRepositoryJdbcImpl")
@Profile("jdbc")
public class PromiseToPayRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements PromiseToPayRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public PromiseToPayRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
