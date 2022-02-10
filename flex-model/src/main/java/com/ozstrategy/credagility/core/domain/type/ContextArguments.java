package com.ozstrategy.credagility.core.domain.type;

import com.ozstrategy.credagility.core.domain.workflow.ContextType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:36
 */
public class ContextArguments {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected ContextType context;

  /** TODO: DOCUMENT ME! */
  protected Long contextId;

  /** TODO: DOCUMENT ME! */
  protected boolean isSystem;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * generateGlobalHQL.
   *
   * @return  StringBuffer
   */
  public StringBuffer generateGlobalHQL() {
    return generateGlobalHQL("");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateGlobalHQL.
   *
   * @param   prefix  String
   *
   * @return  StringBuffer
   */
  public StringBuffer generateGlobalHQL(String prefix) {
    StringBuffer query = new StringBuffer();
    query.append(" and ").append(prefix).append("contextObject.context=\'").append(context.name().toLowerCase()).append(
      '\'');

    if (this.isSystem) {
      query.append(" and ").append(prefix).append("contextObject.contextId IS NULL");
    } else {
      switch (context) {
        case ACCOUNT:
        case RESPONSIBLE:
        case PORTFOLIO:
        case BUSINESS: {
          query.append(" and (").append(prefix).append("contextObject.contextId=\'").append(contextId).append(
            "\' or contextObject.contextId is null)");

          break;
        }

        default: { }
      }
    }

    return query;
  } // end method generateGlobalHQL

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateHQL.
   *
   * @return  StringBuffer
   */
  public StringBuffer generateHQL() {
    return generateHQL("");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateHQL.
   *
   * @param   prefix  String
   *
   * @return  StringBuffer
   */
  public StringBuffer generateHQL(String prefix) {
    StringBuffer query = new StringBuffer();
    query.append(" and ").append(prefix).append("contextObject.context=\'").append(context.name().toLowerCase()).append(
      '\'');

    if (this.isSystem) {
      query.append(" and ").append(prefix).append("contextObject.contextId IS NULL");
    } else {
      switch (context) {
        case ACCOUNT:
        case RESPONSIBLE:
        case PORTFOLIO:
        case BUSINESS: {
          query.append(" and ").append(prefix).append("contextObject.contextId=\'").append(contextId).append('\'');

          break;
        }

        default: { }
      }
    }

    return query;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateRenderOrDataPrHql.
   *
   * @param   prefix  String
   *
   * @return  StringBuffer
   */
  public StringBuffer generateRenderOrDataPrHql(String prefix) {
    StringBuffer query = new StringBuffer();
    query.append(" and ").append(prefix).append("contextObject.context=\'").append(context.name().toLowerCase()).append(
      '\'');

    if (this.isSystem) {
      query.append(" and ").append(prefix).append("contextObject.contextId IS NULL");
    } else {
      switch (context) {
        case ACCOUNT:
        case RESPONSIBLE:
        case PORTFOLIO:
        case BUSINESS: {
          query.append(" and ( ").append(prefix).append("contextObject.contextId=\'").append(contextId).append('\'');
          query.append(" or ").append(prefix).append("contextObject.contextId IS NULL )");

          break;
        }

        default: { }
      }
    }

    return query;
  } // end method generateRenderOrDataPrHql

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateSQL.
   *
   * @return  StringBuffer
   */
  public StringBuffer generateSQL() {
    return generateSQL("");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateSQL.
   *
   * @param   prefix  String
   *
   * @return  StringBuffer
   */
  public StringBuffer generateSQL(String prefix) {
    StringBuffer query = new StringBuffer();
    query.append(" and ").append(prefix).append("context=\'").append(context.name().toLowerCase()).append('\'');

    switch (context) {
      case ACCOUNT:
      case RESPONSIBLE:
      case PORTFOLIO:
      case BUSINESS: {
        query.append(" and ").append(prefix).append("contextId=\'").append(contextId).append('\'');

        break;
      }

      default: { }
    }

    return query;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  ContextType
   */
  public ContextType getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context id.
   *
   * @return  Long
   */
  public Long getContextId() {
    return contextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system.
   *
   * @return  boolean
   */
  public boolean isSystem() {
    return isSystem;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  ContextType
   */
  public void setContext(ContextType context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context id.
   *
   * @param  contextId  Long
   */
  public void setContextId(Long contextId) {
    this.contextId = contextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for system.
   *
   * @param  isSystem  boolean
   */
  public void setSystem(boolean isSystem) {
    this.isSystem = isSystem;
  }
} // end class ContextArguments
