package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:15
 */
@Entity
@Table(
  name    = "TwilioOperation",
  indexes =
    @Index(
      name = "idx_TwilioOperation_operationName",
      columnList = "operationName"
    )
)
public class TwilioOperation extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8326975536066743188L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique = true,
    length = 32
  )
  protected String operationName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "reasonId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioNotReadyReason reason;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getCreateDate()
   */
  @Override public Date getCreateDate() {
    return createDate;
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
   * getter method for operation name.
   *
   * @return  String
   */
  public String getOperationName() {
    return operationName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason.
   *
   * @return  TwilioNotReadyReason
   */
  public TwilioNotReadyReason getReason() {
    return reason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#setCreateDate(java.util.Date)
   */
  @Override public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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
   * setter method for operation name.
   *
   * @param  operationName  String
   */
  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason.
   *
   * @param  reason  TwilioNotReadyReason
   */
  public void setReason(TwilioNotReadyReason reason) {
    this.reason = reason;
  }
} // end class TwilioOperation
