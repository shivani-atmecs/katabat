package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.repository.jdbc.CoreAgentDispositionChannelCodeRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:20
 */
@Component("coreAgentDispositionChannelRepositoryJdbcImpl")
@Profile("jdbc")
public class CoreAgentDispositionChannelRepositoryJdbcImpl extends BaseJdbcRepositoryImpl
  implements CoreAgentDispositionChannelCodeRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public CoreAgentDispositionChannelRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }
}
