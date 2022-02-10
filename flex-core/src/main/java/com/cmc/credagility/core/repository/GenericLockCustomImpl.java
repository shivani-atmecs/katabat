package com.cmc.credagility.core.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Map;
import java.util.Set;


/**
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  04/01/2015 17:45
 */
@Repository("genericLockCustom")
public class GenericLockCustomImpl implements GenericLockCustom {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static Logger log = LoggerFactory.getLogger(GenericLockCustomImpl.class);

  /** TODO: DOCUMENT ME! */
  public static final String QUERY_TYPE_HQL = "HQL";

  /** TODO: DOCUMENT ME! */
  public static final String QUERY_TYPE_SQL = "SQL";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  GenericLockCustom#executeQuery(String, java.util.Map,
   *       String)
   */
  @Transactional
  @Override public Boolean executeQuery(String queryType, final Map<String, Object> params,
    final String queryStr) {
    Query query = null;
    if (QUERY_TYPE_HQL.equalsIgnoreCase(queryType)) {
      query = em.createQuery(queryStr);


      if ((params != null) && (params.size() > 0)) {
        Set<String> keys = params.keySet();

        for (String key : keys) {
          query.setParameter(key, params.get(key));
        }
      }

      int execute = query.executeUpdate();
      if (execute >= 0) {
        return Boolean.TRUE;
      }

      return Boolean.FALSE;

    } else if (QUERY_TYPE_SQL.equalsIgnoreCase(queryType)) {

      query = em.createNativeQuery(queryStr);

      if ((params != null) && (params.size() > 0)) {
        Set<String> keys = params.keySet();

        for (String key : keys) {
          query.setParameter(key, params.get(key));
        }
      }

      if (query.executeUpdate() >= 0) {
        return Boolean.TRUE;
      }

      return Boolean.FALSE;
    } // end if-else

    return null;
  } // end method executeQuery
} // end class GenericLockCustomImpl
