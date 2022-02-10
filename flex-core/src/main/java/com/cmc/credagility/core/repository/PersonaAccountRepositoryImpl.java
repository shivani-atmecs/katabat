package com.cmc.credagility.core.repository;

import java.time.Duration;
import java.time.Instant;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.CollectionUtils;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class PersonaAccountRepositoryImpl implements PersonaAccountRepositoryCustom {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static Logger log = LoggerFactory.getLogger(PersonaAccountRepositoryImpl.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleIds  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  public List<Long> readPersonaIds(List<Long> responsibleIds) {
    final String     selectSql = "SELECT p.id FROM PersonaAccount p"
      + " WHERE (p.historical is null or p.historical=false) and p.responsible.responsibleId in ?1";
    TypedQuery<Long> query     = em.createQuery(selectSql, Long.class).setParameter(1, responsibleIds);

    return query.getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.repository.PersonaAccountRepositoryCustom#updatePersonaAccountsHistorical(java.util.List, java.util.Date)
   */
  @Override public void updatePersonaAccountsHistorical(List<Long> responsibleIds, Date lastUpdateDate) {
/*
    final String     selectSql  = "SELECT p.id FROM PersonaAccount p"
      + " WHERE (p.historical is null or p.historical=false) and p.responsible.responsibleId in ?1";
    Instant          start      = Instant.now();
    TypedQuery<Long> query      = em.createQuery(selectSql, Long.class).setParameter(1, responsibleIds);
 */
    log.info("Start...");
    log.info("Working on ---------->" + Arrays.toString(responsibleIds.toArray()));

    Instant    start      = Instant.now();
    List<Long> personaIds = readPersonaIds(responsibleIds);

    if (!CollectionUtils.isEmpty(personaIds)) {
      final String updateSql = "UPDATE PersonaAccount p set p.historical = true, p.lastUpdateDate = ?1"
        + " where p.id in ?2";
      em.createQuery(updateSql).setParameter(1, lastUpdateDate).setParameter(2, personaIds).executeUpdate();
    }

    Instant finish      = Instant.now();
    long    timeElapsed = Duration.between(start, finish).toMillis();
    log.info("Curent Time ---------->" + new Date());
    log.info("timeElapsed ---------->" + timeElapsed);
  }
} // end class PersonaAccountRepositoryImpl
