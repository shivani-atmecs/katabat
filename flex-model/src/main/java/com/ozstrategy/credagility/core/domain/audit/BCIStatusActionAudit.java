package com.ozstrategy.credagility.core.domain.audit;

import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCIStatusAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:12
 */
@Entity public class BCIStatusActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCIStatusActionAudit object.
   */
  public BCIStatusActionAudit() { }

  /**
   * Creates a new BCIStatusActionAudit object.
   *
   * @param  action  $param.type$
   * @param  type    $param.type$
   */
  public BCIStatusActionAudit(BCIStatusAction action, AuditType type) {
    super(action, type);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }
} // end class BCIStatusActionAudit
