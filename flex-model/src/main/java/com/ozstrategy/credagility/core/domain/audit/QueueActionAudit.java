package com.ozstrategy.credagility.core.domain.audit;

import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.QueueAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * QueueAction Audit.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:23
 */
@Entity public class QueueActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Tduplicate Count. */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueActionAudit object.
   */
  public QueueActionAudit() { }

  /**
   * Creates a new QueueActionAudit object.
   *
   * @param  action  DOCUMENT ME!
   * @param  type    DOCUMENT ME!
   */
  public QueueActionAudit(QueueAction action, AuditType type) {
    super(action, type);
    this.duplicateCount = action.getDuplicateCount();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for duplicate count.
   *
   * @return  Integer
   */
  public Integer getDuplicateCount() {
    return duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * setter method for duplicate count.
   *
   * @param  duplicateCount  Integer
   */
  public void setDuplicateCount(Integer duplicateCount) {
    this.duplicateCount = duplicateCount;
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
} // end class QueueActionAudit
