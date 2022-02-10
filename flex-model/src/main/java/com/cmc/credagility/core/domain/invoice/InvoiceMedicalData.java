package com.cmc.credagility.core.domain.invoice;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 10:48
 */
@Entity
@Table(name = "InvoiceMedicalData")
public class InvoiceMedicalData extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3104834525780031916L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name   = "docName",
    length = 160
  )
  private String docName;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "medDataId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long medDataId;

  @Column(name = "originalAmount")
  private BigDecimal originalAmount;

  @Column(
    name   = "patientName",
    length = 160
  )
  private String patientName;

  @Column(name = "remainingAmount")
  private BigDecimal remainingAmount;

  @Column(
    name   = "serviceCode",
    length = 255
  )
  private String serviceCode;

  @Column(name = "serviceDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date serviceDate;

  @Column(
    name   = "serviceLocation",
    length = 255
  )
  private String serviceLocation;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final InvoiceMedicalData other = (InvoiceMedicalData) obj;

    if (docName == null) {
      if (other.docName != null) {
        return false;
      }
    } else if (!docName.equals(other.docName)) {
      return false;
    }

    if (originalAmount == null) {
      if (other.originalAmount != null) {
        return false;
      }
    } else if (!originalAmount.equals(other.originalAmount)) {
      return false;
    }

    if (patientName == null) {
      if (other.patientName != null) {
        return false;
      }
    } else if (!patientName.equals(other.patientName)) {
      return false;
    }

    if (serviceCode == null) {
      if (other.serviceCode != null) {
        return false;
      }
    } else if (!serviceCode.equals(other.serviceCode)) {
      return false;
    }

    if (serviceDate == null) {
      if (other.serviceDate != null) {
        return false;
      }
    } else if (!serviceDate.equals(other.serviceDate)) {
      return false;
    }

    if (serviceLocation == null) {
      if (other.serviceLocation != null) {
        return false;
      }
    } else if (!serviceLocation.equals(other.serviceLocation)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc name.
   *
   * @return  String
   */
  public String getDocName() {
    return docName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for med data id.
   *
   * @return  Long
   */
  public Long getMedDataId() {
    return medDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOriginalAmount() {
    return originalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for patient name.
   *
   * @return  String
   */
  public String getPatientName() {
    return patientName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remaining amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRemainingAmount() {
    return remainingAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for service code.
   *
   * @return  String
   */
  public String getServiceCode() {
    return serviceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for service date.
   *
   * @return  Date
   */
  public Date getServiceDate() {
    return serviceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for service location.
   *
   * @return  String
   */
  public String getServiceLocation() {
    return serviceLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((docName == null) ? 0 : docName.hashCode());
    result = (prime * result)
      + ((originalAmount == null) ? 0 : originalAmount.hashCode());
    result = (prime * result)
      + ((patientName == null) ? 0 : patientName.hashCode());
    result = (prime * result)
      + ((serviceCode == null) ? 0 : serviceCode.hashCode());
    result = (prime * result)
      + ((serviceDate == null) ? 0 : serviceDate.hashCode());
    result = (prime * result)
      + ((serviceLocation == null) ? 0 : serviceLocation.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for doc name.
   *
   * @param  docName  String
   */
  public void setDocName(String docName) {
    this.docName = docName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for med data id.
   *
   * @param  medDataId  Long
   */
  public void setMedDataId(Long medDataId) {
    this.medDataId = medDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original amount.
   *
   * @param  originalAmount  BigDecimal
   */
  public void setOriginalAmount(BigDecimal originalAmount) {
    this.originalAmount = originalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for patient name.
   *
   * @param  patientName  String
   */
  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remaining amount.
   *
   * @param  remainingAmount  BigDecimal
   */
  public void setRemainingAmount(BigDecimal remainingAmount) {
    this.remainingAmount = remainingAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for service code.
   *
   * @param  serviceCode  String
   */
  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for service date.
   *
   * @param  serviceDate  Date
   */
  public void setServiceDate(Date serviceDate) {
    this.serviceDate = serviceDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for service location.
   *
   * @param  serviceLocation  String
   */
  public void setServiceLocation(String serviceLocation) {
    this.serviceLocation = serviceLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "InvoiceMedicalData ( " + "medDataId = " + this.medDataId + TAB
      + "docName = " + this.docName + TAB + "patientName = "
      + this.patientName + TAB + "serviceLocation = " + this.serviceLocation
      + TAB + "serviceCode = " + this.serviceCode + TAB + "serviceDate = "
      + this.serviceDate + TAB + "originalAmount = " + this.originalAmount
      + TAB + " )";

    return retValue;
  }

} // end class InvoiceMedicalData
