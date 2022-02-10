package com.ozstrategy.credagility.core.domain.audit;


import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.ChargeOffAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by david on 8/7/15.
 *
 * @author   <a href="mailto:wei.dai@ozstrategy.com">Wei Dai</a>
 * @version  08/07/2015 16:05
 */

@Entity public class ChargeOffActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StatusActionAudit object.
   */
  public ChargeOffActionAudit() { }


  /**
   * Creates a new ChargeOffActionAudit object.
   *
   * @param  action  ChargeOffAction
   * @param  type    AuditType
   */
  public ChargeOffActionAudit(ChargeOffAction action, AuditType type) {
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
} // end class ChargeOffActionAudit
