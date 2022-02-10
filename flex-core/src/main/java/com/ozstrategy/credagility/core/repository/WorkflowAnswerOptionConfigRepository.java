package com.ozstrategy.credagility.core.repository;

import java.util.List;


/**
 * Created by liuqian on 5/8/15.
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  05/08/2015 15:19
 */
public interface WorkflowAnswerOptionConfigRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer option by hql.
   *
   * @param   hql  String
   *
   * @return  List
   */
  List<Object[]> getAnswerOptionByHql(String hql);
}
