package com.ozstrategy.credagility.core.domain.audit;

import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.RecallAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  09/24/2015 09:53
 */
@Entity public class RecallActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RecallActionAudit object.
   */
  public RecallActionAudit() { }

  /**
   * Creates a new RecallActionAudit object.
   *
   * @param  action  RecallAction
   * @param  type    AuditType
   */
  public RecallActionAudit(RecallAction action, AuditType type) {
    super(action, type);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }
} // end class RecallActionAudit
