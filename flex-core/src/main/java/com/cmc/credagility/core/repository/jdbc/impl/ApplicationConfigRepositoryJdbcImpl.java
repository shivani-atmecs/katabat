package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.ApplicationConfigRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:42
 */
@Component("applicationConfigRepositoryJdbcImpl")
@Profile("jdbc")
public class ApplicationConfigRepositoryJdbcImpl extends BaseJdbcRepositoryImpl
  implements ApplicationConfigRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public ApplicationConfigRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
