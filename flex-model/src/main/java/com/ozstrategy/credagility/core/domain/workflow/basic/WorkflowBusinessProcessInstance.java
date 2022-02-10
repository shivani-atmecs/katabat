package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcess;

import javax.persistence.*;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-3-27 : PM1:51</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class WorkflowBusinessProcessInstance extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** WorkflowBusinessProcess PK businessProcessId. */
  @JoinColumn(
    name       = "businessProcessId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowBusinessProcess businessProcess;

  /** <code>true</code> this instance is currently execute. */
  @Column(
    name             = "current",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean current;

  /** Update date. */
  @Column(name = "endDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date endDate;

  /** <code>true</code> this instance is execute completely. */
  @Column(
    name             = "finished",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean finished;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** Create date. */
  @Column(
    name      = "startDate",
    nullable  = false,
    updatable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date startDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowBusinessProcess getBusinessProcess() {
    return businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCurrent() {
    if (current == null) {
      return Boolean.FALSE;
    }

    return current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEndDate() {
    return endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getFinished() {
    if (finished == null) {
      return Boolean.FALSE;
    }

    return finished;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessProcess  DOCUMENT ME!
   */
  public void setBusinessProcess(WorkflowBusinessProcess businessProcess) {
    this.businessProcess = businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  current  DOCUMENT ME!
   */
  public void setCurrent(Boolean current) {
    this.current = current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  endDate  DOCUMENT ME!
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  finished  DOCUMENT ME!
   */
  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  startDate  DOCUMENT ME!
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
} // end class WorkflowBusinessProcessInstance
