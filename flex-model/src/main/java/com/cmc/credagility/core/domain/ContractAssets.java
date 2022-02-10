package com.cmc.credagility.core.domain;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  11/20/2015 17:18
 */
@Entity
@Table(name = "ContractAssets")
public class ContractAssets extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -6831174048396380912L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "amountFinanced",
    nullable  = false,
    precision = 20,
    scale     = 4
  )
  protected BigDecimal amountFinanced;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "assetCost",
    nullable  = false,
    precision = 20,
    scale     = 4
  )
  protected BigDecimal assetCost;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "assetId",
    nullable = false,
    length   = 30
  )
  protected Long assetId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "batchId",
    length = 30
  )
  protected Long batchId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "brokerageD",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal brokerageD;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long contractAssetsId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 250
  )
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "finalPayment",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal finalPayment;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "firmTermDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date firmTermDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "fmvEot",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal fmvEot;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "fmvToday",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal fmvToday;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "gstAssetD",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal gstAssetD;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "gstBrokerageD",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal gstBrokerageD;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "noOfPayments",
    nullable = false,
    length   = 30
  )
  protected Integer noOfPayments;

  /** TODO: DOCUMENT ME! */
  @Column(name = "ppsrExpiryDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date ppsrExpiryDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "ppsrLodgementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date ppsrLodgementDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "referenceNo",
    length = 30
  )
  protected String referenceNo;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "residualD",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal residualD;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare10",
    length = 30
  )
  protected Integer spare10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "spare5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date spare5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "spare6",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal spare6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "spare7",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal spare7;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "spare8",
    precision = 20,
    scale     = 4
  )
  protected BigDecimal spare8;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spare9",
    length = 30
  )
  protected Integer spare9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "startDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date startDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 255
  )
  protected String status;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "supplier",
    length = 255
  )
  protected String supplier;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "termInMonths",
    nullable = false,
    length   = 30
  )
  protected Integer termInMonths;

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean epp;

  @Column(
    name     = "equipCategory",
    nullable = false,
    length   = 60
  )
  private String equipCategory;

  @Column(
    name   = "equipMake",
    length = 60
  )
  private String equipMake;

  @Column(
    name   = "equipModel",
    length = 60
  )
  private String equipModel;

  @Column(
    name     = "equipType",
    nullable = false,
    length   = 60
  )
  private String equipType;

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean few;

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean ownInsurance;

  @Column(
    name   = "ppsrRegistrationNo",
    length = 30
  )
  private String ppsrRegistrationNo;


  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean protect;

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean protectPlatinum;

  @Column(
    name   = "serialNumber",
    length = 30
  )
  private String serialNumber;

  @Column(
    name   = "spare1",
    length = 300
  )
  private String spare1;


  @Column(
    name   = "spare2",
    length = 300
  )
  private String spare2;


  @Column(
    name   = "spare3",
    length = 300
  )
  private String spare3;


  @Column(
    name   = "spare4",
    length = 300
  )
  private String spare4;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ContractAssets assets = (ContractAssets) o;

    if (!account.equals(assets.account)) {
      return false;
    }

    if (!amountFinanced.equals(assets.amountFinanced)) {
      return false;
    }

    if (!assetCost.equals(assets.assetCost)) {
      return false;
    }

    if (!assetId.equals(assets.assetId)) {
      return false;
    }

    if ((batchId != null) ? (!batchId.equals(assets.batchId)) : (assets.batchId != null)) {
      return false;
    }

    if ((brokerageD != null) ? (!brokerageD.equals(assets.brokerageD)) : (assets.brokerageD != null)) {
      return false;
    }

    if ((contractAssetsId != null) ? (!contractAssetsId.equals(assets.contractAssetsId))
                                   : (assets.contractAssetsId != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(assets.description)) : (assets.description != null)) {
      return false;
    }

    if ((finalPayment != null) ? (!finalPayment.equals(assets.finalPayment)) : (assets.finalPayment != null)) {
      return false;
    }

    if ((firmTermDate != null) ? (!firmTermDate.equals(assets.firmTermDate)) : (assets.firmTermDate != null)) {
      return false;
    }

    if ((fmvEot != null) ? (!fmvEot.equals(assets.fmvEot)) : (assets.fmvEot != null)) {
      return false;
    }

    if ((fmvToday != null) ? (!fmvToday.equals(assets.fmvToday)) : (assets.fmvToday != null)) {
      return false;
    }

    if ((gstAssetD != null) ? (!gstAssetD.equals(assets.gstAssetD)) : (assets.gstAssetD != null)) {
      return false;
    }

    if ((gstBrokerageD != null) ? (!gstBrokerageD.equals(assets.gstBrokerageD)) : (assets.gstBrokerageD != null)) {
      return false;
    }

    if (!noOfPayments.equals(assets.noOfPayments)) {
      return false;
    }

    if ((ppsrExpiryDate != null) ? (!ppsrExpiryDate.equals(assets.ppsrExpiryDate)) : (assets.ppsrExpiryDate != null)) {
      return false;
    }

    if ((ppsrLodgementDate != null) ? (!ppsrLodgementDate.equals(assets.ppsrLodgementDate))
                                    : (assets.ppsrLodgementDate != null)) {
      return false;
    }

    if ((referenceNo != null) ? (!referenceNo.equals(assets.referenceNo)) : (assets.referenceNo != null)) {
      return false;
    }

    if ((residualD != null) ? (!residualD.equals(assets.residualD)) : (assets.residualD != null)) {
      return false;
    }

    if ((spare10 != null) ? (!spare10.equals(assets.spare10)) : (assets.spare10 != null)) {
      return false;
    }

    if ((spare5 != null) ? (!spare5.equals(assets.spare5)) : (assets.spare5 != null)) {
      return false;
    }

    if ((spare6 != null) ? (!spare6.equals(assets.spare6)) : (assets.spare6 != null)) {
      return false;
    }

    if ((spare7 != null) ? (!spare7.equals(assets.spare7)) : (assets.spare7 != null)) {
      return false;
    }

    if ((spare8 != null) ? (!spare8.equals(assets.spare8)) : (assets.spare8 != null)) {
      return false;
    }

    if ((spare9 != null) ? (!spare9.equals(assets.spare9)) : (assets.spare9 != null)) {
      return false;
    }

    if (!startDate.equals(assets.startDate)) {
      return false;
    }

    if (!status.equals(assets.status)) {
      return false;
    }

    if ((supplier != null) ? (!supplier.equals(assets.supplier)) : (assets.supplier != null)) {
      return false;
    }

    if (!termInMonths.equals(assets.termInMonths)) {
      return false;
    }

    if ((epp != null) ? (!epp.equals(assets.epp)) : (assets.epp != null)) {
      return false;
    }

    if (!equipCategory.equals(assets.equipCategory)) {
      return false;
    }

    if ((equipMake != null) ? (!equipMake.equals(assets.equipMake)) : (assets.equipMake != null)) {
      return false;
    }

    if ((equipModel != null) ? (!equipModel.equals(assets.equipModel)) : (assets.equipModel != null)) {
      return false;
    }

    if (!equipType.equals(assets.equipType)) {
      return false;
    }

    if ((few != null) ? (!few.equals(assets.few)) : (assets.few != null)) {
      return false;
    }

    if ((ownInsurance != null) ? (!ownInsurance.equals(assets.ownInsurance)) : (assets.ownInsurance != null)) {
      return false;
    }

    if ((ppsrRegistrationNo != null) ? (!ppsrRegistrationNo.equals(assets.ppsrRegistrationNo))
                                     : (assets.ppsrRegistrationNo != null)) {
      return false;
    }

    if ((protect != null) ? (!protect.equals(assets.protect)) : (assets.protect != null)) {
      return false;
    }

    if ((protectPlatinum != null) ? (!protectPlatinum.equals(assets.protectPlatinum))
                                  : (assets.protectPlatinum != null)) {
      return false;
    }

    if ((serialNumber != null) ? (!serialNumber.equals(assets.serialNumber)) : (assets.serialNumber != null)) {
      return false;
    }

    if ((spare1 != null) ? (!spare1.equals(assets.spare1)) : (assets.spare1 != null)) {
      return false;
    }

    if ((spare2 != null) ? (!spare2.equals(assets.spare2)) : (assets.spare2 != null)) {
      return false;
    }

    if ((spare3 != null) ? (!spare3.equals(assets.spare3)) : (assets.spare3 != null)) {
      return false;
    }

    return !((spare4 != null) ? (!spare4.equals(assets.spare4)) : (assets.spare4 != null));

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
   * getter method for amount financed.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmountFinanced() {
    return amountFinanced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for asset cost.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAssetCost() {
    return assetCost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for asset id.
   *
   * @return  Long
   */
  public Long getAssetId() {
    return assetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for brokerage d.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBrokerageD() {
    return brokerageD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contract assets id.
   *
   * @return  Long
   */
  public Long getContractAssetsId() {
    return contractAssetsId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for epp.
   *
   * @return  Boolean
   */
  public Boolean getEpp() {
    return epp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for equip category.
   *
   * @return  String
   */
  public String getEquipCategory() {
    return equipCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for equip make.
   *
   * @return  String
   */
  public String getEquipMake() {
    return equipMake;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for equip model.
   *
   * @return  String
   */
  public String getEquipModel() {
    return equipModel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for equip type.
   *
   * @return  String
   */
  public String getEquipType() {
    return equipType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for few.
   *
   * @return  Boolean
   */
  public Boolean getFew() {
    return few;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for final payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFinalPayment() {
    return finalPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for firm term date.
   *
   * @return  Date
   */
  public Date getFirmTermDate() {
    return firmTermDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fmv eot.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFmvEot() {
    return fmvEot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fmv today.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFmvToday() {
    return fmvToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gst asset d.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGstAssetD() {
    return gstAssetD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gst brokerage d.
   *
   * @return  BigDecimal
   */
  public BigDecimal getGstBrokerageD() {
    return gstBrokerageD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for no of payments.
   *
   * @return  Integer
   */
  public Integer getNoOfPayments() {
    return noOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for own insurance.
   *
   * @return  Boolean
   */
  public Boolean getOwnInsurance() {
    return ownInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ppsr expiry date.
   *
   * @return  Date
   */
  public Date getPpsrExpiryDate() {
    return ppsrExpiryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ppsr lodgement date.
   *
   * @return  Date
   */
  public Date getPpsrLodgementDate() {
    return ppsrLodgementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ppsr registration no.
   *
   * @return  String
   */
  public String getPpsrRegistrationNo() {
    return ppsrRegistrationNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for protect.
   *
   * @return  Boolean
   */
  public Boolean getProtect() {
    return protect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for protect platinum.
   *
   * @return  Boolean
   */
  public Boolean getProtectPlatinum() {
    return protectPlatinum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reference no.
   *
   * @return  String
   */
  public String getReferenceNo() {
    return referenceNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for residual d.
   *
   * @return  BigDecimal
   */
  public BigDecimal getResidualD() {
    return residualD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for serial number.
   *
   * @return  String
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare1.
   *
   * @return  String
   */
  public String getSpare1() {
    return spare1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare10.
   *
   * @return  Integer
   */
  public Integer getSpare10() {
    return spare10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare2.
   *
   * @return  String
   */
  public String getSpare2() {
    return spare2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare3.
   *
   * @return  String
   */
  public String getSpare3() {
    return spare3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare4.
   *
   * @return  String
   */
  public String getSpare4() {
    return spare4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare5.
   *
   * @return  Date
   */
  public Date getSpare5() {
    return spare5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSpare6() {
    return spare6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSpare7() {
    return spare7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare8.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSpare8() {
    return spare8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spare9.
   *
   * @return  Integer
   */
  public Integer getSpare9() {
    return spare9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for supplier.
   *
   * @return  String
   */
  public String getSupplier() {
    return supplier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term in months.
   *
   * @return  Integer
   */
  public Integer getTermInMonths() {
    return termInMonths;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.model.BaseObject#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + account.hashCode();
    result = (31 * result) + amountFinanced.hashCode();
    result = (31 * result) + assetCost.hashCode();
    result = (31 * result) + assetId.hashCode();
    result = (31 * result) + ((batchId != null) ? batchId.hashCode() : 0);
    result = (31 * result) + ((brokerageD != null) ? brokerageD.hashCode() : 0);
    result = (31 * result) + ((contractAssetsId != null) ? contractAssetsId.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((finalPayment != null) ? finalPayment.hashCode() : 0);
    result = (31 * result) + ((firmTermDate != null) ? firmTermDate.hashCode() : 0);
    result = (31 * result) + ((fmvEot != null) ? fmvEot.hashCode() : 0);
    result = (31 * result) + ((fmvToday != null) ? fmvToday.hashCode() : 0);
    result = (31 * result) + ((gstAssetD != null) ? gstAssetD.hashCode() : 0);
    result = (31 * result) + ((gstBrokerageD != null) ? gstBrokerageD.hashCode() : 0);
    result = (31 * result) + noOfPayments.hashCode();
    result = (31 * result) + ((ppsrExpiryDate != null) ? ppsrExpiryDate.hashCode() : 0);
    result = (31 * result) + ((ppsrLodgementDate != null) ? ppsrLodgementDate.hashCode() : 0);
    result = (31 * result) + ((referenceNo != null) ? referenceNo.hashCode() : 0);
    result = (31 * result) + ((residualD != null) ? residualD.hashCode() : 0);
    result = (31 * result) + ((spare10 != null) ? spare10.hashCode() : 0);
    result = (31 * result) + ((spare5 != null) ? spare5.hashCode() : 0);
    result = (31 * result) + ((spare6 != null) ? spare6.hashCode() : 0);
    result = (31 * result) + ((spare7 != null) ? spare7.hashCode() : 0);
    result = (31 * result) + ((spare8 != null) ? spare8.hashCode() : 0);
    result = (31 * result) + ((spare9 != null) ? spare9.hashCode() : 0);
    result = (31 * result) + startDate.hashCode();
    result = (31 * result) + status.hashCode();
    result = (31 * result) + ((supplier != null) ? supplier.hashCode() : 0);
    result = (31 * result) + termInMonths.hashCode();
    result = (31 * result) + ((epp != null) ? epp.hashCode() : 0);
    result = (31 * result) + equipCategory.hashCode();
    result = (31 * result) + ((equipMake != null) ? equipMake.hashCode() : 0);
    result = (31 * result) + ((equipModel != null) ? equipModel.hashCode() : 0);
    result = (31 * result) + equipType.hashCode();
    result = (31 * result) + ((few != null) ? few.hashCode() : 0);
    result = (31 * result) + ((ownInsurance != null) ? ownInsurance.hashCode() : 0);
    result = (31 * result) + ((ppsrRegistrationNo != null) ? ppsrRegistrationNo.hashCode() : 0);
    result = (31 * result) + ((protect != null) ? protect.hashCode() : 0);
    result = (31 * result) + ((protectPlatinum != null) ? protectPlatinum.hashCode() : 0);
    result = (31 * result) + ((serialNumber != null) ? serialNumber.hashCode() : 0);
    result = (31 * result) + ((spare1 != null) ? spare1.hashCode() : 0);
    result = (31 * result) + ((spare2 != null) ? spare2.hashCode() : 0);
    result = (31 * result) + ((spare3 != null) ? spare3.hashCode() : 0);
    result = (31 * result) + ((spare4 != null) ? spare4.hashCode() : 0);

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
   * setter method for amount financed.
   *
   * @param  amountFinanced  BigDecimal
   */
  public void setAmountFinanced(BigDecimal amountFinanced) {
    this.amountFinanced = amountFinanced;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for asset cost.
   *
   * @param  assetCost  BigDecimal
   */
  public void setAssetCost(BigDecimal assetCost) {
    this.assetCost = assetCost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for asset id.
   *
   * @param  assetId  Long
   */
  public void setAssetId(Long assetId) {
    this.assetId = assetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for brokerage d.
   *
   * @param  brokerageD  BigDecimal
   */
  public void setBrokerageD(BigDecimal brokerageD) {
    this.brokerageD = brokerageD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contract assets id.
   *
   * @param  contractAssetsId  Long
   */
  public void setContractAssetsId(Long contractAssetsId) {
    this.contractAssetsId = contractAssetsId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for epp.
   *
   * @param  epp  Boolean
   */
  public void setEpp(Boolean epp) {
    this.epp = epp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for equip category.
   *
   * @param  equipCategory  String
   */
  public void setEquipCategory(String equipCategory) {
    this.equipCategory = equipCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for equip make.
   *
   * @param  equipMake  String
   */
  public void setEquipMake(String equipMake) {
    this.equipMake = equipMake;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for equip model.
   *
   * @param  equipModel  String
   */
  public void setEquipModel(String equipModel) {
    this.equipModel = equipModel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for equip type.
   *
   * @param  equipType  String
   */
  public void setEquipType(String equipType) {
    this.equipType = equipType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for few.
   *
   * @param  few  Boolean
   */
  public void setFew(Boolean few) {
    this.few = few;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for final payment.
   *
   * @param  finalPayment  BigDecimal
   */
  public void setFinalPayment(BigDecimal finalPayment) {
    this.finalPayment = finalPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for firm term date.
   *
   * @param  firmTermDate  Date
   */
  public void setFirmTermDate(Date firmTermDate) {
    this.firmTermDate = firmTermDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fmv eot.
   *
   * @param  fmvEot  BigDecimal
   */
  public void setFmvEot(BigDecimal fmvEot) {
    this.fmvEot = fmvEot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fmv today.
   *
   * @param  fmvToday  BigDecimal
   */
  public void setFmvToday(BigDecimal fmvToday) {
    this.fmvToday = fmvToday;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gst asset d.
   *
   * @param  gstAssetD  BigDecimal
   */
  public void setGstAssetD(BigDecimal gstAssetD) {
    this.gstAssetD = gstAssetD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for gst brokerage d.
   *
   * @param  gstBrokerageD  BigDecimal
   */
  public void setGstBrokerageD(BigDecimal gstBrokerageD) {
    this.gstBrokerageD = gstBrokerageD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for no of payments.
   *
   * @param  noOfPayments  Integer
   */
  public void setNoOfPayments(Integer noOfPayments) {
    this.noOfPayments = noOfPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for own insurance.
   *
   * @param  ownInsurance  Boolean
   */
  public void setOwnInsurance(Boolean ownInsurance) {
    this.ownInsurance = ownInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ppsr expiry date.
   *
   * @param  ppsrExpiryDate  Date
   */
  public void setPpsrExpiryDate(Date ppsrExpiryDate) {
    this.ppsrExpiryDate = ppsrExpiryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ppsr lodgement date.
   *
   * @param  ppsrLodgementDate  Date
   */
  public void setPpsrLodgementDate(Date ppsrLodgementDate) {
    this.ppsrLodgementDate = ppsrLodgementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ppsr registration no.
   *
   * @param  ppsrRegistrationNo  String
   */
  public void setPpsrRegistrationNo(String ppsrRegistrationNo) {
    this.ppsrRegistrationNo = ppsrRegistrationNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for protect.
   *
   * @param  protect  Boolean
   */
  public void setProtect(Boolean protect) {
    this.protect = protect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for protect platinum.
   *
   * @param  protectPlatinum  Boolean
   */
  public void setProtectPlatinum(Boolean protectPlatinum) {
    this.protectPlatinum = protectPlatinum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reference no.
   *
   * @param  referenceNo  String
   */
  public void setReferenceNo(String referenceNo) {
    this.referenceNo = referenceNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for residual d.
   *
   * @param  residualD  BigDecimal
   */
  public void setResidualD(BigDecimal residualD) {
    this.residualD = residualD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for serial number.
   *
   * @param  serialNumber  String
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare1.
   *
   * @param  spare1  String
   */
  public void setSpare1(String spare1) {
    this.spare1 = spare1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare10.
   *
   * @param  spare10  Integer
   */
  public void setSpare10(Integer spare10) {
    this.spare10 = spare10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare2.
   *
   * @param  spare2  String
   */
  public void setSpare2(String spare2) {
    this.spare2 = spare2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare3.
   *
   * @param  spare3  String
   */
  public void setSpare3(String spare3) {
    this.spare3 = spare3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare4.
   *
   * @param  spare4  String
   */
  public void setSpare4(String spare4) {
    this.spare4 = spare4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare5.
   *
   * @param  spare5  Date
   */
  public void setSpare5(Date spare5) {
    this.spare5 = spare5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare6.
   *
   * @param  spare6  BigDecimal
   */
  public void setSpare6(BigDecimal spare6) {
    this.spare6 = spare6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare7.
   *
   * @param  spare7  BigDecimal
   */
  public void setSpare7(BigDecimal spare7) {
    this.spare7 = spare7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare8.
   *
   * @param  spare8  BigDecimal
   */
  public void setSpare8(BigDecimal spare8) {
    this.spare8 = spare8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spare9.
   *
   * @param  spare9  Integer
   */
  public void setSpare9(Integer spare9) {
    this.spare9 = spare9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for supplier.
   *
   * @param  supplier  String
   */
  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term in months.
   *
   * @param  termInMonths  Integer
   */
  public void setTermInMonths(Integer termInMonths) {
    this.termInMonths = termInMonths;
  }
} // end class ContractAssets
