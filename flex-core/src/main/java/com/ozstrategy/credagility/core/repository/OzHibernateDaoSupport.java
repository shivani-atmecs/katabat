package com.ozstrategy.credagility.core.repository;

import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by liuqian on 4/3/15.
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  04/03/2015 14:17
 */
public class OzHibernateDaoSupport extends HibernateDaoSupport {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * saveHibernate.
   *
   * @param  o  Object
   */
  public void saveHibernate(Object o) {
    getSession().saveOrUpdate(o);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for em.
   *
   * @param  em  EntityManager
   */
  @PersistenceContext public void setEm(EntityManager em) {
    this.em = em;
    logger.info("init EntityManager");

    HibernateEntityManagerFactory emFactory = (HibernateEntityManagerFactory) em.getEntityManagerFactory();
    super.setSessionFactory(emFactory.getSessionFactory());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  protected Session getSession() {
    Session session = null;

    if (!this.isManaged()) {
      session = (Session) em.getDelegate();

    } else {
      HibernateEntityManager hibernateImpl = (HibernateEntityManager) em.getDelegate();
      session = hibernateImpl.getSession();
    }

    return session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean isManaged() {
    return false;
  }
} // end class OzHibernateDaoSupport
