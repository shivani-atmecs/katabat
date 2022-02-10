package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store ResponsiblePageVisit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:44
 */
@Entity
@Table(name = "ResponsiblePageVisit")
public class ResponsiblePageVisit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7843668707605040730L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  @Column(name = "makePaymentPageLastVisitedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date makePaymentPageLastVisitedDate;

  @Column(name = "programSummaryPageLastVisitedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date programSummaryPageLastVisitedDate;


  @JoinColumn(
    name   = "responsibleId",
    unique = true
  )
  @ManyToOne private Responsible responsible;

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
   * getter method for make payment page last visited date.
   *
   * @return  Date
   */
  public Date getMakePaymentPageLastVisitedDate() {
    return makePaymentPageLastVisitedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program summary page last visited date.
   *
   * @return  Date
   */
  public Date getProgramSummaryPageLastVisitedDate() {
    return programSummaryPageLastVisitedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for make payment page last visited date.
   *
   * @param  makePaymentPageLastVisitedDate  Date
   */
  public void setMakePaymentPageLastVisitedDate(Date makePaymentPageLastVisitedDate) {
    this.makePaymentPageLastVisitedDate = makePaymentPageLastVisitedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program summary page last visited date.
   *
   * @param  programSummaryPageLastVisitedDate  Date
   */
  public void setProgramSummaryPageLastVisitedDate(Date programSummaryPageLastVisitedDate) {
    this.programSummaryPageLastVisitedDate = programSummaryPageLastVisitedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }
} // end class ResponsiblePageVisit
