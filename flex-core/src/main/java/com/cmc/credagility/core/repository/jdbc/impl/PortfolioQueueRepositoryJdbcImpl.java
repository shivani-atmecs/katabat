package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.PortfolioQueueRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:47
 */
@Component("portfolioQueueRepositoryJdbcImpl")
@Profile("jdbc")
public class PortfolioQueueRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements PortfolioQueueRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public PortfolioQueueRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
