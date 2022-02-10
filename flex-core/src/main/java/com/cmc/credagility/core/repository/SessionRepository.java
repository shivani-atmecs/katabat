package com.cmc.credagility.core.repository;

import java.util.List;

import com.cmc.credagility.core.domain.type.WebActivityChannel;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.webactivity.Session;


/**
 * Created by rojer on 14-10-2.
 *
 * @author   Yang Wang
 * @version  $Revision$, $Date$
 */
@Repository("sessionRepository")
public interface SessionRepository extends CrudRepository<Session, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByHttpSession.
   *
   * @param   httpSession  String
   *
   * @return  List
   */
  List<Session> findByHttpSession(String httpSession);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findBySessionIdAndHttpServerAndActivityChannel.
   *
   * @param   httpSessionId    String
   * @param   httpServer       String
   * @param   activityChannel  String
   *
   * @return  List
   */
  List<Session> findByHttpSessionAndHttpServerAndActivityChannel(String httpSessionId, String httpServer,
    WebActivityChannel activityChannel);
} // end interface SessionRepository
