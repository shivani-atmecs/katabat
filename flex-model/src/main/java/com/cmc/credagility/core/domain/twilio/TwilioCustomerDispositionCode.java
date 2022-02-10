package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 16:19
 */
@Entity
@Table(
  name    = "TwilioCustomerDispositionCode",
  indexes = {
    @javax.persistence.Index(
      name = "idx_TwilioCustomerDispositionCode_customerCallSid",
      columnList = "customerCallSid"
    ),
    @javax.persistence.Index(
      name = "idx_TwilioCustomerDispositionCode_dispositionCode",
      columnList = "dispositionCode"
    )
  }
)
public class TwilioCustomerDispositionCode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -658029421443102157L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String customerCallSid;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dispositionCode",
    length = 10
  )
  protected String dispositionCode;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer call sid.
   *
   * @return  String
   */
  public String getCustomerCallSid() {
    return customerCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition code.
   *
   * @return  String
   */
  public String getDispositionCode() {
    return dispositionCode;
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
   * setter method for customer call sid.
   *
   * @param  customerCallSid  String
   */
  public void setCustomerCallSid(String customerCallSid) {
    this.customerCallSid = customerCallSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition code.
   *
   * @param  dispositionCode  String
   */
  public void setDispositionCode(String dispositionCode) {
    this.dispositionCode = dispositionCode;
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


} // end class TwilioCustomerDispositionCode
