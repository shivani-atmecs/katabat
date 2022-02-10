package com.ozstrategy.credagility.core.domain.audit;


import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.StatusAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 16:36
 */
@Entity public class StatusActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StatusActionAudit object.
   */
  public StatusActionAudit() { }

  /**
   * Creates a new StatusActionAudit object.
   *
   * @param  action  $param.type$
   * @param  type    $param.type$
   */
  public StatusActionAudit(StatusAction action, AuditType type) {
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
} // end class StatusActionAudit
