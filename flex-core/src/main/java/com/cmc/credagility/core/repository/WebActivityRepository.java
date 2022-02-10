package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.webactivity.WebActivity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/31/2014 17:20
 */
@Repository public interface WebActivityRepository extends JpaRepository<WebActivity, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   httpSessionId  DOCUMENT ME!
   * @param   activityName   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("SELECT distinct w from WebActivity w where w.session.sessionId = ?1 and w.name = ?2")
  List<WebActivity> getActivitiesByHttpSessionAndName(Long httpSessionId, String activityName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   httpSessionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "SELECT r.userLogon FROM Responsible r , WebActivity w, Session s where r = w.responsible and w.name = 'a_LoginSuccess' and w.session = s and s.httpSession = ?1 "
  )
  String getLogonByHttpSession(String httpSessionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   httpSessionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "SELECT r.responsibleId FROM Responsible r , WebActivity w, Session s where r = w.responsible and w.name = 'a_LoginSuccess' and w.session = s and s.httpSession = ?1 "
  )
  List<Long> getResponsibleIdListByHttpSession(String httpSessionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   httpSessionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "SELECT r.userLogon FROM Responsible r , WebActivity w, Session s where r = w.responsible and w.name = 'a_LoginSuccess' and w.session = s and s.httpSession = ?1 "
  )
  List<String> getUserLogonLisyByHttpSession(String httpSessionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id by http session.
   *
   * @param   httpSessionId  String
   *
   * @return  Long
   */
  @Query(
    "SELECT r.responsibleId FROM Responsible r , WebActivity w, Session s where r = w.responsible and w.name = 'a_LoginSuccess' and w.session = s and s.httpSession = ?1 "
  )
  Long getWebActivityByHttpSession(String httpSessionId);

} // end interface WebActivityRepository
