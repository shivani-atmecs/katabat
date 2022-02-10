package com.ozstrategy.credagility.core.el;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public abstract class ElObject<C extends ElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected Map<String, Object> exposeParams = new HashMap<String, Object>();

  /** DOCUMENT ME! */
  protected Map<String, Object> extParams = new HashMap<String, Object>();

  private WorkflowBusinessObject businessObject;

  private C context;

  public User getExecutor() {
    return executor;
  }

  public void setExecutor(User executor) {
    this.executor = executor;
  }

  private User executor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract String getCacheKey();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name   DOCUMENT ME!
   * @param  value  DOCUMENT ME!
   */
  public void addExtParam(String name, Object value) {
    extParams.put(name, value);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  params  DOCUMENT ME!
   */
  public void exposeParams(Map<String, Object> params) {
    params.putAll(exposeParams);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public C getContext() {
    if (context == null) {
      context = createContext();
      context.setBusinessObject(businessObject);
    }

    context.addExtParams(extParams);

    if (businessObject != null) {
      context.setBusinessObject(businessObject);
    }

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessObject  DOCUMENT ME!
   */
  public void setBusinessObject(WorkflowBusinessObject businessObject) {
    this.businessObject = businessObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected abstract C createContext();
} // end class ElObject
