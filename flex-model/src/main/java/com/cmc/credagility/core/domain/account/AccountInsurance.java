package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Medical insurance information.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 11:15
 */
@Entity
@Table(name = "AccountInsurance")
public class AccountInsurance extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4625222179844901077L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;
  @Column(
    name   = "carrierAddress",
    length = 255
  )
  private String  carrierAddress;

  // npelleti made carrierName not NULL
  @Column(
    name     = "carrierName",
    length   = 128,
    nullable = false
  )
  private String carrierName;
  @Column(
    name   = "carrierPhoneNum",
    length = 20
  )
  private String carrierPhoneNum;

  @Column(
    name   = "employerName",
    length = 50
  )
  private String employerName;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name     = "insuranceAccountId",
    nullable = false,
    length   = 20
  )
  private String insuranceAccountId;

  @Column(
    name   = "insuranceGroupId",
    length = 20
  )
  private String insuranceGroupId;

  // npelleti 08/01 dropped unique key constraint
  @Column(
    name     = "insuranceId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long insuranceId;

  @Column(name = "insuranceOrder")
  private Integer insuranceOrder;

  @Column(
    name   = "planType",
    length = 20
  )
  private String planType = null;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name     = "primaryInsuredFirstName",
    nullable = false,
    length   = 45
  )
  private String primaryInsuredFirstName;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name     = "primaryInsuredLastName",
    nullable = false,
    length   = 55
  )
  private String primaryInsuredLastName;

  @Column(
    name   = "primaryInsuredMiddleName",
    length = 45
  )
  private String primaryInsuredMiddleName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AccountInsurance other = (AccountInsurance) obj;

    if (carrierAddress == null) {
      if (other.carrierAddress != null) {
        return false;
      }
    } else if (!carrierAddress.equals(other.carrierAddress)) {
      return false;
    }

    if (carrierName == null) {
      if (other.carrierName != null) {
        return false;
      }
    } else if (!carrierName.equals(other.carrierName)) {
      return false;
    }

    if (carrierPhoneNum == null) {
      if (other.carrierPhoneNum != null) {
        return false;
      }
    } else if (!carrierPhoneNum.equals(other.carrierPhoneNum)) {
      return false;
    }

    if (employerName == null) {
      if (other.employerName != null) {
        return false;
      }
    } else if (!employerName.equals(other.employerName)) {
      return false;
    }

    if (insuranceAccountId == null) {
      if (other.insuranceAccountId != null) {
        return false;
      }
    } else if (!insuranceAccountId.equals(other.insuranceAccountId)) {
      return false;
    }

    if (insuranceGroupId == null) {
      if (other.insuranceGroupId != null) {
        return false;
      }
    } else if (!insuranceGroupId.equals(other.insuranceGroupId)) {
      return false;
    }

    if (planType == null) {
      if (other.planType != null) {
        return false;
      }
    } else if (!planType.equals(other.planType)) {
      return false;
    }

    if (primaryInsuredFirstName == null) {
      if (other.primaryInsuredFirstName != null) {
        return false;
      }
    } else if (!primaryInsuredFirstName.equals(other.primaryInsuredFirstName)) {
      return false;
    }

    if (primaryInsuredLastName == null) {
      if (other.primaryInsuredLastName != null) {
        return false;
      }
    } else if (!primaryInsuredLastName.equals(other.primaryInsuredLastName)) {
      return false;
    }

    if (primaryInsuredMiddleName == null) {
      if (other.primaryInsuredMiddleName != null) {
        return false;
      }
    } else if (!primaryInsuredMiddleName.equals(other.primaryInsuredMiddleName)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for carrier address.
   *
   * @return  String
   */
  public String getCarrierAddress() {
    return carrierAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for carrier name.
   *
   * @return  String
   */
  public String getCarrierName() {
    return carrierName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for carrier phone num.
   *
   * @return  String
   */
  public String getCarrierPhoneNum() {
    return carrierPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer name.
   *
   * @return  String
   */
  public String getEmployerName() {
    return employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance account id.
   *
   * @return  String
   */
  public String getInsuranceAccountId() {
    return insuranceAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance group id.
   *
   * @return  String
   */
  public String getInsuranceGroupId() {
    return insuranceGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance id.
   *
   * @return  Long
   */
  public Long getInsuranceId() {
    return insuranceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for insurance order.
   *
   * @return  Integer
   */
  public Integer getInsuranceOrder() {
    return insuranceOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan type.
   *
   * @return  String
   */
  public String getPlanType() {
    return planType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary insured first name.
   *
   * @return  String
   */
  public String getPrimaryInsuredFirstName() {
    return primaryInsuredFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary insured last name.
   *
   * @return  String
   */
  public String getPrimaryInsuredLastName() {
    return primaryInsuredLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary insured middle name.
   *
   * @return  String
   */
  public String getPrimaryInsuredMiddleName() {
    return primaryInsuredMiddleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((carrierAddress == null) ? 0 : carrierAddress.hashCode());
    result = (prime * result)
      + ((carrierName == null) ? 0 : carrierName.hashCode());
    result = (prime * result)
      + ((carrierPhoneNum == null) ? 0 : carrierPhoneNum.hashCode());
    result = (prime * result)
      + ((employerName == null) ? 0 : employerName.hashCode());
    result = (prime * result)
      + ((insuranceAccountId == null) ? 0 : insuranceAccountId.hashCode());
    result = (prime * result)
      + ((insuranceGroupId == null) ? 0 : insuranceGroupId.hashCode());
    result = (prime * result) + ((planType == null) ? 0 : planType.hashCode());
    result = (prime
        * result)
      + ((primaryInsuredFirstName == null) ? 0 : primaryInsuredFirstName.hashCode());
    result = (prime
        * result)
      + ((primaryInsuredLastName == null) ? 0 : primaryInsuredLastName.hashCode());
    result = (prime
        * result)
      + ((primaryInsuredMiddleName == null) ? 0 : primaryInsuredMiddleName.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for carrier address.
   *
   * @param  carrierAddress  String
   */
  public void setCarrierAddress(String carrierAddress) {
    this.carrierAddress = carrierAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for carrier name.
   *
   * @param  carrierName  String
   */
  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for carrier phone num.
   *
   * @param  carrierPhoneNum  String
   */
  public void setCarrierPhoneNum(String carrierPhoneNum) {
    this.carrierPhoneNum = carrierPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer name.
   *
   * @param  employerName  String
   */
  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance account id.
   *
   * @param  insuranceAccountId  String
   */
  public void setInsuranceAccountId(String insuranceAccountId) {
    this.insuranceAccountId = insuranceAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance group id.
   *
   * @param  insuranceGroupId  String
   */
  public void setInsuranceGroupId(String insuranceGroupId) {
    this.insuranceGroupId = insuranceGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance id.
   *
   * @param  insuranceId  Long
   */
  public void setInsuranceId(Long insuranceId) {
    this.insuranceId = insuranceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance order.
   *
   * @param  insuranceOrder  Integer
   */
  public void setInsuranceOrder(Integer insuranceOrder) {
    this.insuranceOrder = insuranceOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan type.
   *
   * @param  planType  String
   */
  public void setPlanType(String planType) {
    this.planType = planType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary insured first name.
   *
   * @param  primaryInsuredFirstName  String
   */
  public void setPrimaryInsuredFirstName(String primaryInsuredFirstName) {
    this.primaryInsuredFirstName = primaryInsuredFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary insured last name.
   *
   * @param  primaryInsuredLastName  String
   */
  public void setPrimaryInsuredLastName(String primaryInsuredLastName) {
    this.primaryInsuredLastName = primaryInsuredLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary insured middle name.
   *
   * @param  primaryInsuredMiddleName  String
   */
  public void setPrimaryInsuredMiddleName(String primaryInsuredMiddleName) {
    this.primaryInsuredMiddleName = primaryInsuredMiddleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AccountMedicalInsurance ( " + TAB + "medicalInsuranceId = "
      + this.insuranceId + TAB + "carrierName = " + this.carrierName + TAB
      + "carrierPhoneNum = " + this.carrierPhoneNum + TAB
      + "carrierAddress = " + this.carrierAddress + TAB
      + "insuranceGroupId = " + this.insuranceGroupId + TAB
      + "insuranceAccountId = " + this.insuranceAccountId + TAB
      + "primaryInsuredFirstName = " + this.primaryInsuredFirstName + TAB
      + "primaryInsuredMiddleName = " + this.primaryInsuredMiddleName + TAB
      + "primaryInsuredLastName = " + this.primaryInsuredLastName + TAB
      + "employerName = " + this.employerName + TAB + "planType = "
      + this.planType + TAB + "account = " + this.account + TAB + " )";

    return retValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateInsuranceInfo.
   *
   * @param  insurance  AccountInsurance
   */
  public void updateInsuranceInfo(AccountInsurance insurance) {
    this.setCarrierAddress(insurance.getCarrierAddress());
    this.setCarrierName(insurance.getCarrierName());
    this.setCarrierPhoneNum(insurance.getCarrierPhoneNum());
    this.setEmployerName(insurance.getEmployerName());
    this.setInsuranceAccountId(insurance.getInsuranceAccountId());
    this.setInsuranceGroupId(insurance.getInsuranceGroupId());
    this.setInsuranceOrder(insurance.getInsuranceOrder());
    this.setPlanType(insurance.getPlanType());
    this.setPrimaryInsuredFirstName(insurance.getPrimaryInsuredFirstName());
    this.setPrimaryInsuredLastName(insurance.getPrimaryInsuredLastName());
    this.setPrimaryInsuredMiddleName(insurance.getPrimaryInsuredMiddleName());
  }

} // end class AccountInsurance
