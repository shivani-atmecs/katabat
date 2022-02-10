package com.cmc.credagility.core.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.RoutingNumber;


/**
 * Created with IntelliJ IDEA. User: sujy Date: 15/3/31 To change this template use File | Settings | File Templates.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  03/31/2015 15:39
 */
@Repository("routingNumberRepository")
public class RoutingNumberRepositoryImpl implements RoutingNumberRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  RoutingNumberRepository#findByRoutingNumber(String)
   */
  @Override public RoutingNumber findByRoutingNumber(String routingNumber) {
    StringBuffer ql = new StringBuffer("select r from RoutingNumber r where  r.routingNumber=? ");

    Query query = em.createQuery(ql.toString()).setMaxResults(1);
    query.setParameter(1, routingNumber);

    List<RoutingNumber> result = query.getResultList();

    if (result.size() > 0) {
      return result.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  RoutingNumberRepository#getRoutingNumberCount()
   */
  @Override public Long getRoutingNumberCount() {
    String hql = "SELECT COUNT(r.routingNumberId) FROM RoutingNumber r ";

    return (Long) em.createQuery(hql).getSingleResult();
  }
} // end class RoutingNumberRepositoryImpl
