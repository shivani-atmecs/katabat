package com.ozstrategy.credagility.core.query;

/**
 * Created by wangy on 11/29/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/29/2014 10:44 AM
 */
public class SimpleCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private RelationCriteria criteria;
  private Class            entityClass;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SimpleCriteria object.
   *
   * @param  entityClass  Class
   */
  public SimpleCriteria(Class entityClass) {
    this.entityClass = entityClass;
    this.and();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * add.
   *
   * @param  queryCriteria  QueryCriteria
   */
  public void addCriterion(QueryCriteria queryCriteria) {
    criteria.add(queryCriteria);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * and.
   */
  public void and() {
    criteria = new AndCriteria();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  RelationCriteria
   */
  public RelationCriteria getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entity class.
   *
   * @return  Class
   */
  public Class getEntityClass() {
    return entityClass;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * or.
   */
  public void or() {
    criteria = new AndCriteria();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entity class.
   *
   * @param  entityClass  Class
   */
  public void setEntityClass(Class entityClass) {
    this.entityClass = entityClass;
  }
} // end class SimpleCriteria
