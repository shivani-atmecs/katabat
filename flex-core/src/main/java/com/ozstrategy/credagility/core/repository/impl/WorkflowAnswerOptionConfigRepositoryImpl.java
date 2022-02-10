package com.ozstrategy.credagility.core.repository.impl;

import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;
import com.ozstrategy.credagility.core.repository.WorkflowAnswerOptionConfigRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by liuqian on 5/8/15.
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  05/08/2015 15:25
 */
@Repository
public class WorkflowAnswerOptionConfigRepositoryImpl extends OzHibernateDaoSupport
  implements WorkflowAnswerOptionConfigRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.WorkflowAnswerOptionConfigRepository#getAnswerOptionByHql(String)
   */
  @Override public List<Object[]> getAnswerOptionByHql(String hql) {
    return  getSession().createQuery(hql).list();
  }
}
