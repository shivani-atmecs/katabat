package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.CoreAgentDispositionDestinationRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:22
 */
@Component("coreAgentDispositionDestinationRepositoryJdbcImpl")
@Profile("jdbc")
public class CoreAgentDispositionDestinationRepositoryJdbcImpl extends BaseJdbcRepositoryImpl
  implements CoreAgentDispositionDestinationRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public CoreAgentDispositionDestinationRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
