package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.config.LookUpValue;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Yang Wang on 1/20/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/20/2015 15:13 PM
 */
@Repository("lookUpValueRepository")
public class LookUpValueRepositoryImpl implements LookUpValueRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  LookUpValueRepository#findByCategoryAndLocale(String, String,
   *       String[])
   */
  @Override public LookUpValue findByCategoryAndLocale(String category, String locale, String... values) {
    return findByCategoryAndLocale(category, locale, Arrays.asList(values));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  LookUpValueRepository#findByCategoryAndLocale(String, String,
   *       java.util.List)
   */
  @Override public LookUpValue findByCategoryAndLocale(String category, String locale, List<String> values) {
    StringBuffer         ql       = new StringBuffer("select l from LookUpValue l where category=?1 and locale=?2 ");
    Map<Integer, String> params   = new HashMap<Integer, String>();
    List<String>         orderBys = new ArrayList<String>();
    int                  index    = 3;

    concateQuery(ql, orderBys, params, values, index);
    appendOrderBy(ql, orderBys);

    Query query = em.createQuery(ql.toString()).setMaxResults(1);
    query.setParameter(1, category);
    query.setParameter(2, locale);

    for (Integer ind : params.keySet()) {
      query.setParameter(ind, params.get(ind));
    }

    List<LookUpValue> result = query.getResultList();

    if (result.size() > 0) {
      return result.get(0);
    }

    return null;
  } // end method findByCategoryAndLocale

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  LookUpValueRepository#findByNameAndLocale(String, String[])
   */
  @Override public LookUpValue findByNameAndLocale(String locale, String... values) {
    return findByNameAndLocale(locale, Arrays.asList(values));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  LookUpValueRepository#findByNameAndLocale(String, java.util.List)
   */
  @Override public LookUpValue findByNameAndLocale(String locale, List<String> values) {
    StringBuffer         ql       = new StringBuffer("select l from LookUpValue l where  locale=?1 ");
    Map<Integer, String> params   = new HashMap<Integer, String>();
    List<String>         orderBys = new ArrayList<String>();
    int                  index    = 2;

    concateQuery(ql, orderBys, params, values, index);
    appendOrderBy(ql, orderBys);

    Query query = em.createQuery(ql.toString()).setMaxResults(1);
    query.setParameter(1, locale);

    for (Integer ind : params.keySet()) {
      query.setParameter(ind, params.get(ind));
    }

    List<LookUpValue> result = query.getResultList();

    if (result.size() > 0) {
      return result.get(0);
    }

    return null;
  } // end method findByNameAndLocale

  //~ ------------------------------------------------------------------------------------------------------------------

  private void appendOrderBy(StringBuffer ql, List<String> orderBys) {
    ql.append(" ORDER BY (");

    for (int i = 0; i < orderBys.size(); i++) {
      String orderBy = orderBys.get(i);

      if (i != 0) {
        ql.append("+");
      }

      ql.append(orderBy);
    }

    ql.append(") DESC");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void concateQuery(StringBuffer ql, List<String> orderBy, Map<Integer, String> params, List<String> values,
    Integer index) {
    for (int i = 0; i < values.size();) {
      String value = values.get(i);
      i++;

      if (value == null) {
        ql.append(" and (l.key" + i + " is null or l.key" + i + " = '-' or l.key" + i + "='!')");
        orderBy.add(" (case when l.key" + i + " is null then 100 when l.key" + i + "='-' then 10 when l.key" + i
          + "='!' then 1 else 0 end)");
      } else {
        ql.append(" and (l.key" + i + " = ?" + index + " or l.key" + i + " = '*' or l.key" + i + "='!')");
        orderBy.add(" (case when l.key" + i + "=?" + index + " then 100 when l.key" + i + "='*' then 10 when l.key" + i
          + "='!' then 1 else 0 end)");
        params.put(index++, value);
      }
    }
  }
} // end class LookUpValueRepositoryImpl
