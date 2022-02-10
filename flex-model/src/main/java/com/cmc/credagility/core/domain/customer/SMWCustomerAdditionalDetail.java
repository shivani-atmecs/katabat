package com.cmc.credagility.core.domain.customer;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  08/19/2015 11:11
 */
@Entity
@Table(name = "SMWCustomerAdditionalDetail")
public class SMWCustomerAdditionalDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4471815709015673098L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate2;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate3;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate4;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate5;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger1")
  protected Integer clientDefinedInteger1;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger2")
  protected Integer clientDefinedInteger2;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger3")
  protected Integer clientDefinedInteger3;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString1")
  protected String clientDefinedString1;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString10")
  protected String clientDefinedString10;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString11")
  protected String clientDefinedString11;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString12")
  protected String clientDefinedString12;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString13")
  protected String clientDefinedString13;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString14")
  protected String clientDefinedString14;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString15")
  protected String clientDefinedString15;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString16")
  protected String clientDefinedString16;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString17")
  protected String clientDefinedString17;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString18")
  protected String clientDefinedString18;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString19")
  protected String clientDefinedString19;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString2")
  protected String clientDefinedString2;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString20")
  protected String clientDefinedString20;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString21")
  protected String clientDefinedString21;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString22")
  protected String clientDefinedString22;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString23")
  protected String clientDefinedString23;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString24")
  protected String clientDefinedString24;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString25")
  protected String clientDefinedString25;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString26")
  protected String clientDefinedString26;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString27")
  protected String clientDefinedString27;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString28")
  protected String clientDefinedString28;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString29")
  protected String clientDefinedString29;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString3")
  protected String clientDefinedString3;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString30")
  protected String clientDefinedString30;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString31")
  protected String clientDefinedString31;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString32")
  protected String clientDefinedString32;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString33")
  protected String clientDefinedString33;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString34")
  protected String clientDefinedString34;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString35")
  protected String clientDefinedString35;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString36")
  protected String clientDefinedString36;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString37")
  protected String clientDefinedString37;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString38")
  protected String clientDefinedString38;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString39")
  protected String clientDefinedString39;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString4")
  protected String clientDefinedString4;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString40")
  protected String clientDefinedString40;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString41")
  protected String clientDefinedString41;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString42")
  protected String clientDefinedString42;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString43")
  protected String clientDefinedString43;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString44")
  protected String clientDefinedString44;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString45")
  protected String clientDefinedString45;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString46")
  protected String clientDefinedString46;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString47")
  protected String clientDefinedString47;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString48")
  protected String clientDefinedString48;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString49")
  protected String clientDefinedString49;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString5")
  protected String clientDefinedString5;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString50")
  protected String clientDefinedString50;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString51")
  protected String clientDefinedString51;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString52")
  protected String clientDefinedString52;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString53")
  protected String clientDefinedString53;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString54")
  protected String clientDefinedString54;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString55")
  protected String clientDefinedString55;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString56")
  protected String clientDefinedString56;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString57")
  protected String clientDefinedString57;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString58")
  protected String clientDefinedString58;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString59")
  protected String clientDefinedString59;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString6")
  protected String clientDefinedString6;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString60")
  protected String clientDefinedString60;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString61")
  protected String clientDefinedString61;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString62")
  protected String clientDefinedString62;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString63")
  protected String clientDefinedString63;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString64")
  protected String clientDefinedString64;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString65")
  protected String clientDefinedString65;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString66")
  protected String clientDefinedString66;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString67")
  protected String clientDefinedString67;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString68")
  protected String clientDefinedString68;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString69")
  protected String clientDefinedString69;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString7")
  protected String clientDefinedString7;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString70")
  protected String clientDefinedString70;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString71")
  protected String clientDefinedString71;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString72")
  protected String clientDefinedString72;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString73")
  protected String clientDefinedString73;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString74")
  protected String clientDefinedString74;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString75")
  protected String clientDefinedString75;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString8")
  protected String clientDefinedString8;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString9")
  protected String clientDefinedString9;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "closeToEasternTimeZone")
  @ManyToOne protected Timezone closeToEasternTimeZone;

  /** TODO: DOCUMENT ME! */
  @Column(name = "closeToEasternTimeZoneDescription")
  protected String closeToEasternTimeZoneDescription;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @OneToOne protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "customerAdditionalDetailId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customerAdditionalDetailId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "disbursedDays")
  protected Integer disbursedDays;

  /** TODO: DOCUMENT ME! */


  @Column(
    name      = "disbursementAmount1",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal disbursementAmount1;

  /** DOCUMENT ME! */
  @Column(
    name      = "disbursementAmount2",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal disbursementAmount2;

  /** DOCUMENT ME! */
  @Column(
    name      = "disbursementAmount3",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal disbursementAmount3;

  /** DOCUMENT ME! */
  @Column(
    name      = "disbursementAmount4",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal disbursementAmount4;

  /** DOCUMENT ME! */
  @Column(name = "disbursementCode1")
  protected Integer disbursementCode1;


  /** DOCUMENT ME! */
  @Column(name = "disbursementCode2")
  protected Integer disbursementCode2;


  /** DOCUMENT ME! */
  @Column(name = "disbursementCode3")
  protected Integer disbursementCode3;


  /** DOCUMENT ME! */
  @Column(name = "disbursementCode4")
  protected Integer disbursementCode4;

  /** DOCUMENT ME! */
  @Column(name = "disbursementDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date disbursementDate1;

  /** DOCUMENT ME! */
  @Column(name = "disbursementDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date disbursementDate2;

  /** DOCUMENT ME! */
  @Column(name = "disbursementDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date disbursementDate3;

  /** DOCUMENT ME! */
  @Column(name = "disbursementDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date disbursementDate4;

  /** DOCUMENT ME! */
  @Column(name = "disbursementSequenceNumber1")
  protected Integer disbursementSequenceNumber1;

  /** DOCUMENT ME! */
  @Column(name = "disbursementSequenceNumber2")
  protected Integer disbursementSequenceNumber2;

  /** DOCUMENT ME! */
  @Column(name = "disbursementSequenceNumber3")
  protected Integer disbursementSequenceNumber3;

  /** DOCUMENT ME! */
  @Column(name = "disbursementSequenceNumber4")
  protected Integer disbursementSequenceNumber4;

  @Column(
    name     = "customerCitizenshipCode",
    length   = 1,
    nullable = true
  )
  private String customerCitizenshipCode;

  @Column(
    name             = "email1098ETaxLetterFlag",
    columnDefinition = "char",
    length           = 1,
    nullable         = true
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean email1098ETaxLetterFlag;

  @Column(
    name     = "fdrCustomerSolicitationCode",
    length   = 1,
    nullable = true
  )
  private String fdrCustomerSolicitationCode;

  @Column(
    name     = "fdrPersonId",
    length   = 24,
    nullable = true
  )
  private String fdrPersonId;

  @Column(
    name     = "person1098EPermissionLastUpdateDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date person1098EPermissionLastUpdateDate;

  @Column(
    name     = "personEmailMarketingPermissionLastUpdateDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date personEmailMarketingPermissionLastUpdateDate;

  @Column(
    name     = "personMailMarketingPermissionLastUpdateDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date personMailMarketingPermissionLastUpdateDate;

  @Column(
    name     = "personNonRegulatoryLastUpdateDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date personNonRegulatoryLastUpdateDate;

  @Column(
    name     = "personRegulatoryPermissionLastUpdateDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date personRegulatoryPermissionLastUpdateDate;

  @Column(
    name     = "personTelephoneMarketingPermissionLastUpdateDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date personTelephoneMarketingPermissionLastUpdateDate;


  @Column(
    name     = "studentEnrollmentCertificationDate",
    nullable = true
  )
  @Temporal(TemporalType.DATE)
  private Date studentEnrollmentCertificationDate;

  @Column(
    name     = "studentEnrollmentTermBeginDate",
    nullable = true
  )
  @Temporal(TemporalType.DATE)
  private Date studentEnrollmentTermBeginDate;

  @Column(
    name     = "studentEnrollmentTermEndDate",
    nullable = true
  )
  @Temporal(TemporalType.DATE)
  private Date studentEnrollmentTermEndDate;

  @Column(
    name     = "studentSeparationDate",
    nullable = true
  )
  @Temporal(TemporalType.DATE)
  private Date studentSeparationDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * clearDisbursement.
   */
  public void clearDisbursement() {
    this.setDisbursementAmount1(null);
    this.setDisbursementAmount2(null);
    this.setDisbursementAmount3(null);
    this.setDisbursementAmount4(null);
    this.setDisbursementCode1(null);
    this.setDisbursementCode2(null);
    this.setDisbursementCode3(null);
    this.setDisbursementCode4(null);
    this.setDisbursementDate1(null);
    this.setDisbursementDate2(null);
    this.setDisbursementDate3(null);
    this.setDisbursementDate4(null);
    this.setDisbursementSequenceNumber1(null);
    this.setDisbursementSequenceNumber2(null);
    this.setDisbursementSequenceNumber3(null);
    this.setDisbursementSequenceNumber4(null);
    this.setDisbursedDays(null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    SMWCustomerAdditionalDetail that = (SMWCustomerAdditionalDetail) o;

    if (!customer.equals(that.getCustomer())) {
      return false;
    }

    if (!customerAdditionalDetailId.equals(that.getCustomerAdditionalDetailId())) {
      return false;
    }

    if ((customerCitizenshipCode != null) ? (!customerCitizenshipCode.equals(that.getCustomerCitizenshipCode()))
                                          : (that.getCustomerCitizenshipCode() != null)) {
      return false;
    }

    if (!email1098ETaxLetterFlag.equals(that.getEmail1098ETaxLetterFlag())) {
      return false;
    }

    if ((studentSeparationDate != null) ? (!studentSeparationDate.equals(that.getStudentSeparationDate()))
                                        : (that.getStudentSeparationDate() != null)) {
      return false;
    }

    if ((studentEnrollmentCertificationDate != null)
          ? (!studentEnrollmentCertificationDate.equals(that.getStudentEnrollmentCertificationDate()))
          : (that.getStudentEnrollmentCertificationDate() != null)) {
      return false;
    }

    if (!fdrPersonId.equals(that.getFdrPersonId())) {
      return false;
    }

    if (!fdrCustomerSolicitationCode.equals(that.getFdrCustomerSolicitationCode())) {
      return false;
    }

    if (!personEmailMarketingPermissionLastUpdateDate.equals(that.getPersonEmailMarketingPermissionLastUpdateDate())) {
      return false;
    }

    if (!personMailMarketingPermissionLastUpdateDate.equals(that.getPersonMailMarketingPermissionLastUpdateDate())) {
      return false;
    }

    if (
      !personTelephoneMarketingPermissionLastUpdateDate.equals(
            that.getPersonTelephoneMarketingPermissionLastUpdateDate())) {
      return false;
    }

    if (!personRegulatoryPermissionLastUpdateDate.equals(that.getPersonRegulatoryPermissionLastUpdateDate())) {
      return false;
    }

    if (!personNonRegulatoryLastUpdateDate.equals(that.getPersonNonRegulatoryLastUpdateDate())) {
      return false;
    }

    if (!person1098EPermissionLastUpdateDate.equals(that.getPerson1098EPermissionLastUpdateDate())) {
      return false;
    }

    if (!closeToEasternTimeZone.equals(that.getCloseToEasternTimeZone())) {
      return false;
    }

    if (!closeToEasternTimeZoneDescription.equals(that.getCloseToEasternTimeZoneDescription())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString1, that.getClientDefinedString1())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString2, that.getClientDefinedString2())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString3, that.getClientDefinedString3())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString4, that.getClientDefinedString4())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString5, that.getClientDefinedString5())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString6, that.getClientDefinedString6())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString7, that.getClientDefinedString7())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString8, that.getClientDefinedString8())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString9, that.getClientDefinedString9())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString10, that.getClientDefinedString10())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString11, that.getClientDefinedString11())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString12, that.getClientDefinedString12())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString13, that.getClientDefinedString13())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString14, that.getClientDefinedString14())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString15, that.getClientDefinedString15())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString16, that.getClientDefinedString16())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString17, that.getClientDefinedString17())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString18, that.getClientDefinedString18())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString19, that.getClientDefinedString19())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString20, that.getClientDefinedString20())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString21, that.getClientDefinedString21())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString22, that.getClientDefinedString22())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString23, that.getClientDefinedString23())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString24, that.getClientDefinedString24())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString25, that.getClientDefinedString25())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString26, that.getClientDefinedString26())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString27, that.getClientDefinedString27())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString28, that.getClientDefinedString28())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString29, that.getClientDefinedString29())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString30, that.getClientDefinedString30())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString31, that.getClientDefinedString31())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString32, that.getClientDefinedString32())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString33, that.getClientDefinedString33())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString34, that.getClientDefinedString34())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString35, that.getClientDefinedString35())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString36, that.getClientDefinedString36())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString37, that.getClientDefinedString37())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString38, that.getClientDefinedString38())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString39, that.getClientDefinedString39())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString40, that.getClientDefinedString40())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString41, that.getClientDefinedString41())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString42, that.getClientDefinedString42())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString43, that.getClientDefinedString43())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString44, that.getClientDefinedString44())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString45, that.getClientDefinedString45())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString46, that.getClientDefinedString46())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString47, that.getClientDefinedString47())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString48, that.getClientDefinedString48())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString49, that.getClientDefinedString49())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString50, that.getClientDefinedString50())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString51, that.getClientDefinedString51())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString52, that.getClientDefinedString52())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString53, that.getClientDefinedString53())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString54, that.getClientDefinedString54())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString55, that.getClientDefinedString55())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString56, that.getClientDefinedString56())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString57, that.getClientDefinedString57())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString58, that.getClientDefinedString58())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString59, that.getClientDefinedString59())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString60, that.getClientDefinedString60())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString61, that.getClientDefinedString61())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString62, that.getClientDefinedString62())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString63, that.getClientDefinedString63())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString64, that.getClientDefinedString64())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString65, that.getClientDefinedString65())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString66, that.getClientDefinedString66())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString67, that.getClientDefinedString67())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString68, that.getClientDefinedString68())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString69, that.getClientDefinedString69())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString70, that.getClientDefinedString70())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString71, that.getClientDefinedString71())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString72, that.getClientDefinedString72())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString73, that.getClientDefinedString73())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString74, that.getClientDefinedString74())) {
      return false;
    }

    if (!Objects.equals(clientDefinedString75, that.getClientDefinedString75())) {
      return false;
    }

    if (!Objects.equals(clientDefinedInteger1, that.getClientDefinedInteger1())) {
      return false;
    }

    if (!Objects.equals(clientDefinedInteger2, that.getClientDefinedInteger2())) {
      return false;
    }

    if (!Objects.equals(clientDefinedInteger3, that.getClientDefinedInteger3())) {
      return false;
    }

    if (!Objects.equals(clientDefinedDate1, that.getClientDefinedDate1())) {
      return false;
    }

    if (!Objects.equals(clientDefinedDate2, that.getClientDefinedDate2())) {
      return false;
    }

    if (!Objects.equals(clientDefinedDate3, that.getClientDefinedDate3())) {
      return false;
    }

    if (!Objects.equals(clientDefinedDate4, that.getClientDefinedDate4())) {
      return false;
    }

    if (!Objects.equals(clientDefinedDate5, that.getClientDefinedDate5())) {
      return false;
    }

    return true;

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString10() {
    return clientDefinedString10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString11() {
    return clientDefinedString11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString12() {
    return clientDefinedString12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString13() {
    return clientDefinedString13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString14() {
    return clientDefinedString14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString15() {
    return clientDefinedString15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString16() {
    return clientDefinedString16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString17() {
    return clientDefinedString17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString18() {
    return clientDefinedString18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString19() {
    return clientDefinedString19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString20() {
    return clientDefinedString20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString21() {
    return clientDefinedString21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString22() {
    return clientDefinedString22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString23() {
    return clientDefinedString23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString24() {
    return clientDefinedString24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString25() {
    return clientDefinedString25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString26() {
    return clientDefinedString26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString27() {
    return clientDefinedString27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString28() {
    return clientDefinedString28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString29() {
    return clientDefinedString29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString3() {
    return clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString30() {
    return clientDefinedString30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString31() {
    return clientDefinedString31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString32() {
    return clientDefinedString32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString33() {
    return clientDefinedString33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString34() {
    return clientDefinedString34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString35() {
    return clientDefinedString35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString36() {
    return clientDefinedString36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString37() {
    return clientDefinedString37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString38() {
    return clientDefinedString38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString39() {
    return clientDefinedString39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString4() {
    return clientDefinedString4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString40() {
    return clientDefinedString40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString41() {
    return clientDefinedString41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString42() {
    return clientDefinedString42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString43() {
    return clientDefinedString43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString44() {
    return clientDefinedString44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString45() {
    return clientDefinedString45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString46() {
    return clientDefinedString46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString47() {
    return clientDefinedString47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString48() {
    return clientDefinedString48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString49() {
    return clientDefinedString49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString5() {
    return clientDefinedString5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString50() {
    return clientDefinedString50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString51() {
    return clientDefinedString51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString52() {
    return clientDefinedString52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString53() {
    return clientDefinedString53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString54() {
    return clientDefinedString54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString55() {
    return clientDefinedString55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString56() {
    return clientDefinedString56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString57() {
    return clientDefinedString57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString58() {
    return clientDefinedString58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString59() {
    return clientDefinedString59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString6() {
    return clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString60() {
    return clientDefinedString60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString61() {
    return clientDefinedString61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString62() {
    return clientDefinedString62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString63() {
    return clientDefinedString63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString64() {
    return clientDefinedString64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString65() {
    return clientDefinedString65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString66() {
    return clientDefinedString66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString67() {
    return clientDefinedString67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString68() {
    return clientDefinedString68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString69() {
    return clientDefinedString69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString7() {
    return clientDefinedString7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString70() {
    return clientDefinedString70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString71() {
    return clientDefinedString71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString72() {
    return clientDefinedString72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString73() {
    return clientDefinedString73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString74() {
    return clientDefinedString74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString75() {
    return clientDefinedString75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString8() {
    return clientDefinedString8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString9() {
    return clientDefinedString9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for close to eastern time zone.
   *
   * @return  Timezone
   */
  public Timezone getCloseToEasternTimeZone() {
    return closeToEasternTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for close to eastern time zone description.
   *
   * @return  Integer
   */
  public String getCloseToEasternTimeZoneDescription() {
    return closeToEasternTimeZoneDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer additional detail id.
   *
   * @return  Long
   */
  public Long getCustomerAdditionalDetailId() {
    return customerAdditionalDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer citizenship code.
   *
   * @return  String
   */
  public String getCustomerCitizenshipCode() {
    return customerCitizenshipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursed days.
   *
   * @return  Integer
   */
  public Integer getDisbursedDays() {
    return disbursedDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement amount1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDisbursementAmount1() {
    return disbursementAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement amount2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDisbursementAmount2() {
    return disbursementAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement amount3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDisbursementAmount3() {
    return disbursementAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement amount4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDisbursementAmount4() {
    return disbursementAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement code1.
   *
   * @return  Integer
   */
  public Integer getDisbursementCode1() {
    return disbursementCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement code2.
   *
   * @return  Integer
   */
  public Integer getDisbursementCode2() {
    return disbursementCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement code3.
   *
   * @return  Integer
   */
  public Integer getDisbursementCode3() {
    return disbursementCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement code4.
   *
   * @return  Integer
   */
  public Integer getDisbursementCode4() {
    return disbursementCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement date1.
   *
   * @return  Date
   */
  public Date getDisbursementDate1() {
    return disbursementDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement date2.
   *
   * @return  Date
   */
  public Date getDisbursementDate2() {
    return disbursementDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement date3.
   *
   * @return  Date
   */
  public Date getDisbursementDate3() {
    return disbursementDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement date4.
   *
   * @return  Date
   */
  public Date getDisbursementDate4() {
    return disbursementDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement sequence number1.
   *
   * @return  Integer
   */
  public Integer getDisbursementSequenceNumber1() {
    return disbursementSequenceNumber1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement sequence number2.
   *
   * @return  Integer
   */
  public Integer getDisbursementSequenceNumber2() {
    return disbursementSequenceNumber2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement sequence number3.
   *
   * @return  Integer
   */
  public Integer getDisbursementSequenceNumber3() {
    return disbursementSequenceNumber3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disbursement sequence number4.
   *
   * @return  Integer
   */
  public Integer getDisbursementSequenceNumber4() {
    return disbursementSequenceNumber4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email1098 ETax letter flag.
   *
   * @return  Boolean
   */
  public Boolean getEmail1098ETaxLetterFlag() {
    return email1098ETaxLetterFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr customer solicitation code.
   *
   * @return  String
   */
  public String getFdrCustomerSolicitationCode() {
    return fdrCustomerSolicitationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fdr person id.
   *
   * @return  String
   */
  public String getFdrPersonId() {
    return fdrPersonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for person1098 EPermission last update date.
   *
   * @return  Date
   */
  public Date getPerson1098EPermissionLastUpdateDate() {
    return person1098EPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for person email marketing permission last update date.
   *
   * @return  Date
   */
  public Date getPersonEmailMarketingPermissionLastUpdateDate() {
    return personEmailMarketingPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for person mail marketing permission last update date.
   *
   * @return  Date
   */
  public Date getPersonMailMarketingPermissionLastUpdateDate() {
    return personMailMarketingPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for person non regulatory last update date.
   *
   * @return  Date
   */
  public Date getPersonNonRegulatoryLastUpdateDate() {
    return personNonRegulatoryLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for person regulatory permission last update date.
   *
   * @return  Date
   */
  public Date getPersonRegulatoryPermissionLastUpdateDate() {
    return personRegulatoryPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for person telephone marketing permission last update date.
   *
   * @return  Date
   */
  public Date getPersonTelephoneMarketingPermissionLastUpdateDate() {
    return personTelephoneMarketingPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for student enrollment certification date.
   *
   * @return  Date
   */
  public Date getStudentEnrollmentCertificationDate() {
    return studentEnrollmentCertificationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for student enrollment term begin date.
   *
   * @return  Date
   */
  public Date getStudentEnrollmentTermBeginDate() {
    return studentEnrollmentTermBeginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for student enrollment term end date.
   *
   * @return  Date
   */
  public Date getStudentEnrollmentTermEndDate() {
    return studentEnrollmentTermEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for student separation date.
   *
   * @return  Date
   */
  public Date getStudentSeparationDate() {
    return studentSeparationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + customer.hashCode();
    result = (31 * result) + customerAdditionalDetailId.hashCode();
    result = (31 * result) + ((customerCitizenshipCode != null) ? customerCitizenshipCode.hashCode() : 0);
    result = (31 * result) + email1098ETaxLetterFlag.hashCode();
    result = (31 * result) + ((studentSeparationDate != null) ? studentSeparationDate.hashCode() : 0);
    result = (31 * result)
      + ((studentEnrollmentCertificationDate != null) ? studentEnrollmentCertificationDate.hashCode() : 0);
    result = (31 * result) + fdrPersonId.hashCode();
    result = (31 * result) + fdrCustomerSolicitationCode.hashCode();
    result = (31 * result) + personEmailMarketingPermissionLastUpdateDate.hashCode();
    result = (31 * result) + personMailMarketingPermissionLastUpdateDate.hashCode();
    result = (31 * result) + personTelephoneMarketingPermissionLastUpdateDate.hashCode();
    result = (31 * result) + personRegulatoryPermissionLastUpdateDate.hashCode();
    result = (31 * result) + personNonRegulatoryLastUpdateDate.hashCode();
    result = (31 * result) + person1098EPermissionLastUpdateDate.hashCode();
    result = (31 * result) + closeToEasternTimeZoneDescription.hashCode();
    result = (31 * result) + closeToEasternTimeZone.hashCode();
    result = (31 * result) + ((clientDefinedString1 != null) ? clientDefinedString1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString2 != null) ? clientDefinedString2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString3 != null) ? clientDefinedString3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString4 != null) ? clientDefinedString4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString5 != null) ? clientDefinedString5.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString6 != null) ? clientDefinedString6.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString7 != null) ? clientDefinedString7.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString8 != null) ? clientDefinedString8.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString9 != null) ? clientDefinedString9.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString10 != null) ? clientDefinedString10.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString11 != null) ? clientDefinedString11.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString12 != null) ? clientDefinedString12.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString13 != null) ? clientDefinedString13.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString14 != null) ? clientDefinedString14.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString15 != null) ? clientDefinedString15.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString16 != null) ? clientDefinedString16.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString17 != null) ? clientDefinedString17.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString18 != null) ? clientDefinedString18.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString19 != null) ? clientDefinedString19.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString20 != null) ? clientDefinedString20.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString21 != null) ? clientDefinedString21.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString22 != null) ? clientDefinedString22.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString23 != null) ? clientDefinedString23.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString24 != null) ? clientDefinedString24.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString25 != null) ? clientDefinedString25.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString26 != null) ? clientDefinedString26.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString27 != null) ? clientDefinedString27.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString28 != null) ? clientDefinedString28.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString29 != null) ? clientDefinedString29.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString30 != null) ? clientDefinedString30.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString31 != null) ? clientDefinedString31.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString32 != null) ? clientDefinedString32.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString33 != null) ? clientDefinedString33.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString34 != null) ? clientDefinedString34.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString35 != null) ? clientDefinedString35.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString36 != null) ? clientDefinedString36.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString37 != null) ? clientDefinedString37.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString38 != null) ? clientDefinedString38.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString39 != null) ? clientDefinedString39.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString40 != null) ? clientDefinedString40.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString41 != null) ? clientDefinedString41.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString42 != null) ? clientDefinedString42.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString43 != null) ? clientDefinedString43.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString44 != null) ? clientDefinedString44.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString45 != null) ? clientDefinedString45.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString46 != null) ? clientDefinedString46.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString47 != null) ? clientDefinedString47.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString48 != null) ? clientDefinedString48.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString49 != null) ? clientDefinedString49.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString50 != null) ? clientDefinedString50.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString51 != null) ? clientDefinedString51.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString52 != null) ? clientDefinedString52.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString53 != null) ? clientDefinedString53.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString54 != null) ? clientDefinedString54.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString55 != null) ? clientDefinedString55.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString56 != null) ? clientDefinedString56.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString57 != null) ? clientDefinedString57.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString58 != null) ? clientDefinedString58.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString59 != null) ? clientDefinedString59.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString60 != null) ? clientDefinedString60.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString61 != null) ? clientDefinedString61.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString62 != null) ? clientDefinedString62.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString63 != null) ? clientDefinedString63.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString64 != null) ? clientDefinedString64.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString65 != null) ? clientDefinedString65.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString66 != null) ? clientDefinedString66.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString67 != null) ? clientDefinedString67.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString68 != null) ? clientDefinedString68.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString69 != null) ? clientDefinedString69.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString70 != null) ? clientDefinedString70.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString71 != null) ? clientDefinedString71.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString72 != null) ? clientDefinedString72.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString73 != null) ? clientDefinedString73.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString74 != null) ? clientDefinedString74.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString75 != null) ? clientDefinedString75.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger1 != null) ? clientDefinedInteger1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger2 != null) ? clientDefinedInteger2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger3 != null) ? clientDefinedInteger3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate1 != null) ? clientDefinedDate1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate2 != null) ? clientDefinedDate2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate3 != null) ? clientDefinedDate3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate4 != null) ? clientDefinedDate4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate5 != null) ? clientDefinedDate5.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate4  DOCUMENT ME!
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString1  DOCUMENT ME!
   */
  public void setClientDefinedString1(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString10  DOCUMENT ME!
   */
  public void setClientDefinedString10(String clientDefinedString10) {
    this.clientDefinedString10 = clientDefinedString10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString11  DOCUMENT ME!
   */
  public void setClientDefinedString11(String clientDefinedString11) {
    this.clientDefinedString11 = clientDefinedString11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString12  DOCUMENT ME!
   */
  public void setClientDefinedString12(String clientDefinedString12) {
    this.clientDefinedString12 = clientDefinedString12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString13  DOCUMENT ME!
   */
  public void setClientDefinedString13(String clientDefinedString13) {
    this.clientDefinedString13 = clientDefinedString13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString14  DOCUMENT ME!
   */
  public void setClientDefinedString14(String clientDefinedString14) {
    this.clientDefinedString14 = clientDefinedString14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString15  DOCUMENT ME!
   */
  public void setClientDefinedString15(String clientDefinedString15) {
    this.clientDefinedString15 = clientDefinedString15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString16  DOCUMENT ME!
   */
  public void setClientDefinedString16(String clientDefinedString16) {
    this.clientDefinedString16 = clientDefinedString16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString17  DOCUMENT ME!
   */
  public void setClientDefinedString17(String clientDefinedString17) {
    this.clientDefinedString17 = clientDefinedString17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString18  DOCUMENT ME!
   */
  public void setClientDefinedString18(String clientDefinedString18) {
    this.clientDefinedString18 = clientDefinedString18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString19  DOCUMENT ME!
   */
  public void setClientDefinedString19(String clientDefinedString19) {
    this.clientDefinedString19 = clientDefinedString19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString2  DOCUMENT ME!
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString20  DOCUMENT ME!
   */
  public void setClientDefinedString20(String clientDefinedString20) {
    this.clientDefinedString20 = clientDefinedString20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString21  DOCUMENT ME!
   */
  public void setClientDefinedString21(String clientDefinedString21) {
    this.clientDefinedString21 = clientDefinedString21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString22  DOCUMENT ME!
   */
  public void setClientDefinedString22(String clientDefinedString22) {
    this.clientDefinedString22 = clientDefinedString22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString23  DOCUMENT ME!
   */
  public void setClientDefinedString23(String clientDefinedString23) {
    this.clientDefinedString23 = clientDefinedString23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString24  DOCUMENT ME!
   */
  public void setClientDefinedString24(String clientDefinedString24) {
    this.clientDefinedString24 = clientDefinedString24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString25  DOCUMENT ME!
   */
  public void setClientDefinedString25(String clientDefinedString25) {
    this.clientDefinedString25 = clientDefinedString25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString26  DOCUMENT ME!
   */
  public void setClientDefinedString26(String clientDefinedString26) {
    this.clientDefinedString26 = clientDefinedString26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString27  DOCUMENT ME!
   */
  public void setClientDefinedString27(String clientDefinedString27) {
    this.clientDefinedString27 = clientDefinedString27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString28  DOCUMENT ME!
   */
  public void setClientDefinedString28(String clientDefinedString28) {
    this.clientDefinedString28 = clientDefinedString28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString29  DOCUMENT ME!
   */
  public void setClientDefinedString29(String clientDefinedString29) {
    this.clientDefinedString29 = clientDefinedString29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString3  DOCUMENT ME!
   */
  public void setClientDefinedString3(String clientDefinedString3) {
    this.clientDefinedString3 = clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString30  DOCUMENT ME!
   */
  public void setClientDefinedString30(String clientDefinedString30) {
    this.clientDefinedString30 = clientDefinedString30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString31  DOCUMENT ME!
   */
  public void setClientDefinedString31(String clientDefinedString31) {
    this.clientDefinedString31 = clientDefinedString31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString32  DOCUMENT ME!
   */
  public void setClientDefinedString32(String clientDefinedString32) {
    this.clientDefinedString32 = clientDefinedString32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString33  DOCUMENT ME!
   */
  public void setClientDefinedString33(String clientDefinedString33) {
    this.clientDefinedString33 = clientDefinedString33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString34  DOCUMENT ME!
   */
  public void setClientDefinedString34(String clientDefinedString34) {
    this.clientDefinedString34 = clientDefinedString34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString35  DOCUMENT ME!
   */
  public void setClientDefinedString35(String clientDefinedString35) {
    this.clientDefinedString35 = clientDefinedString35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString36  DOCUMENT ME!
   */
  public void setClientDefinedString36(String clientDefinedString36) {
    this.clientDefinedString36 = clientDefinedString36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString37  DOCUMENT ME!
   */
  public void setClientDefinedString37(String clientDefinedString37) {
    this.clientDefinedString37 = clientDefinedString37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString38  DOCUMENT ME!
   */
  public void setClientDefinedString38(String clientDefinedString38) {
    this.clientDefinedString38 = clientDefinedString38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString39  DOCUMENT ME!
   */
  public void setClientDefinedString39(String clientDefinedString39) {
    this.clientDefinedString39 = clientDefinedString39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString4  DOCUMENT ME!
   */
  public void setClientDefinedString4(String clientDefinedString4) {
    this.clientDefinedString4 = clientDefinedString4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString40  DOCUMENT ME!
   */
  public void setClientDefinedString40(String clientDefinedString40) {
    this.clientDefinedString40 = clientDefinedString40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString41  DOCUMENT ME!
   */
  public void setClientDefinedString41(String clientDefinedString41) {
    this.clientDefinedString41 = clientDefinedString41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString42  DOCUMENT ME!
   */
  public void setClientDefinedString42(String clientDefinedString42) {
    this.clientDefinedString42 = clientDefinedString42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString43  DOCUMENT ME!
   */
  public void setClientDefinedString43(String clientDefinedString43) {
    this.clientDefinedString43 = clientDefinedString43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString44  DOCUMENT ME!
   */
  public void setClientDefinedString44(String clientDefinedString44) {
    this.clientDefinedString44 = clientDefinedString44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString45  DOCUMENT ME!
   */
  public void setClientDefinedString45(String clientDefinedString45) {
    this.clientDefinedString45 = clientDefinedString45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString46  DOCUMENT ME!
   */
  public void setClientDefinedString46(String clientDefinedString46) {
    this.clientDefinedString46 = clientDefinedString46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString47  DOCUMENT ME!
   */
  public void setClientDefinedString47(String clientDefinedString47) {
    this.clientDefinedString47 = clientDefinedString47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString48  DOCUMENT ME!
   */
  public void setClientDefinedString48(String clientDefinedString48) {
    this.clientDefinedString48 = clientDefinedString48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString49  DOCUMENT ME!
   */
  public void setClientDefinedString49(String clientDefinedString49) {
    this.clientDefinedString49 = clientDefinedString49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString5  DOCUMENT ME!
   */
  public void setClientDefinedString5(String clientDefinedString5) {
    this.clientDefinedString5 = clientDefinedString5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString50  DOCUMENT ME!
   */
  public void setClientDefinedString50(String clientDefinedString50) {
    this.clientDefinedString50 = clientDefinedString50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString51  DOCUMENT ME!
   */
  public void setClientDefinedString51(String clientDefinedString51) {
    this.clientDefinedString51 = clientDefinedString51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString52  DOCUMENT ME!
   */
  public void setClientDefinedString52(String clientDefinedString52) {
    this.clientDefinedString52 = clientDefinedString52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString53  DOCUMENT ME!
   */
  public void setClientDefinedString53(String clientDefinedString53) {
    this.clientDefinedString53 = clientDefinedString53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString54  DOCUMENT ME!
   */
  public void setClientDefinedString54(String clientDefinedString54) {
    this.clientDefinedString54 = clientDefinedString54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString55  DOCUMENT ME!
   */
  public void setClientDefinedString55(String clientDefinedString55) {
    this.clientDefinedString55 = clientDefinedString55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString56  DOCUMENT ME!
   */
  public void setClientDefinedString56(String clientDefinedString56) {
    this.clientDefinedString56 = clientDefinedString56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString57  DOCUMENT ME!
   */
  public void setClientDefinedString57(String clientDefinedString57) {
    this.clientDefinedString57 = clientDefinedString57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString58  DOCUMENT ME!
   */
  public void setClientDefinedString58(String clientDefinedString58) {
    this.clientDefinedString58 = clientDefinedString58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString59  DOCUMENT ME!
   */
  public void setClientDefinedString59(String clientDefinedString59) {
    this.clientDefinedString59 = clientDefinedString59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString6  DOCUMENT ME!
   */
  public void setClientDefinedString6(String clientDefinedString6) {
    this.clientDefinedString6 = clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString60  DOCUMENT ME!
   */
  public void setClientDefinedString60(String clientDefinedString60) {
    this.clientDefinedString60 = clientDefinedString60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString61  DOCUMENT ME!
   */
  public void setClientDefinedString61(String clientDefinedString61) {
    this.clientDefinedString61 = clientDefinedString61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString62  DOCUMENT ME!
   */
  public void setClientDefinedString62(String clientDefinedString62) {
    this.clientDefinedString62 = clientDefinedString62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString63  DOCUMENT ME!
   */
  public void setClientDefinedString63(String clientDefinedString63) {
    this.clientDefinedString63 = clientDefinedString63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString64  DOCUMENT ME!
   */
  public void setClientDefinedString64(String clientDefinedString64) {
    this.clientDefinedString64 = clientDefinedString64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString65  DOCUMENT ME!
   */
  public void setClientDefinedString65(String clientDefinedString65) {
    this.clientDefinedString65 = clientDefinedString65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString66  DOCUMENT ME!
   */
  public void setClientDefinedString66(String clientDefinedString66) {
    this.clientDefinedString66 = clientDefinedString66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString67  DOCUMENT ME!
   */
  public void setClientDefinedString67(String clientDefinedString67) {
    this.clientDefinedString67 = clientDefinedString67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString68  DOCUMENT ME!
   */
  public void setClientDefinedString68(String clientDefinedString68) {
    this.clientDefinedString68 = clientDefinedString68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString69  DOCUMENT ME!
   */
  public void setClientDefinedString69(String clientDefinedString69) {
    this.clientDefinedString69 = clientDefinedString69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString7  DOCUMENT ME!
   */
  public void setClientDefinedString7(String clientDefinedString7) {
    this.clientDefinedString7 = clientDefinedString7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString70  DOCUMENT ME!
   */
  public void setClientDefinedString70(String clientDefinedString70) {
    this.clientDefinedString70 = clientDefinedString70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString71  DOCUMENT ME!
   */
  public void setClientDefinedString71(String clientDefinedString71) {
    this.clientDefinedString71 = clientDefinedString71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString72  DOCUMENT ME!
   */
  public void setClientDefinedString72(String clientDefinedString72) {
    this.clientDefinedString72 = clientDefinedString72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString73  DOCUMENT ME!
   */
  public void setClientDefinedString73(String clientDefinedString73) {
    this.clientDefinedString73 = clientDefinedString73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString74  DOCUMENT ME!
   */
  public void setClientDefinedString74(String clientDefinedString74) {
    this.clientDefinedString74 = clientDefinedString74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString75  DOCUMENT ME!
   */
  public void setClientDefinedString75(String clientDefinedString75) {
    this.clientDefinedString75 = clientDefinedString75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString8  DOCUMENT ME!
   */
  public void setClientDefinedString8(String clientDefinedString8) {
    this.clientDefinedString8 = clientDefinedString8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString9  DOCUMENT ME!
   */
  public void setClientDefinedString9(String clientDefinedString9) {
    this.clientDefinedString9 = clientDefinedString9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for close to eastern time zone.
   *
   * @param  closeToEasternTimeZone  Timezone
   */
  public void setCloseToEasternTimeZone(Timezone closeToEasternTimeZone) {
    this.closeToEasternTimeZone = closeToEasternTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for close to eastern time zone description.
   *
   * @param  closeToEasternTimeZoneDescription  Integer
   */
  public void setCloseToEasternTimeZoneDescription(String closeToEasternTimeZoneDescription) {
    this.closeToEasternTimeZoneDescription = closeToEasternTimeZoneDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer additional detail id.
   *
   * @param  customerAdditionalDetailId  Long
   */
  public void setCustomerAdditionalDetailId(Long customerAdditionalDetailId) {
    this.customerAdditionalDetailId = customerAdditionalDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer citizenship code.
   *
   * @param  customerCitizenshipCode  String
   */
  public void setCustomerCitizenshipCode(String customerCitizenshipCode) {
    this.customerCitizenshipCode = customerCitizenshipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursed days.
   *
   * @param  disbursedDays  Integer
   */
  public void setDisbursedDays(Integer disbursedDays) {
    this.disbursedDays = disbursedDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement amount1.
   *
   * @param  disbursementAmount1  BigDecimal
   */
  public void setDisbursementAmount1(BigDecimal disbursementAmount1) {
    this.disbursementAmount1 = disbursementAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement amount2.
   *
   * @param  disbursementAmount2  BigDecimal
   */
  public void setDisbursementAmount2(BigDecimal disbursementAmount2) {
    this.disbursementAmount2 = disbursementAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement amount3.
   *
   * @param  disbursementAmount3  BigDecimal
   */
  public void setDisbursementAmount3(BigDecimal disbursementAmount3) {
    this.disbursementAmount3 = disbursementAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement amount4.
   *
   * @param  disbursementAmount4  BigDecimal
   */
  public void setDisbursementAmount4(BigDecimal disbursementAmount4) {
    this.disbursementAmount4 = disbursementAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement code1.
   *
   * @param  disbursementCode1  Integer
   */
  public void setDisbursementCode1(Integer disbursementCode1) {
    this.disbursementCode1 = disbursementCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement code2.
   *
   * @param  disbursementCode2  Integer
   */
  public void setDisbursementCode2(Integer disbursementCode2) {
    this.disbursementCode2 = disbursementCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement code3.
   *
   * @param  disbursementCode3  Integer
   */
  public void setDisbursementCode3(Integer disbursementCode3) {
    this.disbursementCode3 = disbursementCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement code4.
   *
   * @param  disbursementCode4  Integer
   */
  public void setDisbursementCode4(Integer disbursementCode4) {
    this.disbursementCode4 = disbursementCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement date1.
   *
   * @param  disbursementDate1  Date
   */
  public void setDisbursementDate1(Date disbursementDate1) {
    this.disbursementDate1 = disbursementDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement date2.
   *
   * @param  disbursementDate2  Date
   */
  public void setDisbursementDate2(Date disbursementDate2) {
    this.disbursementDate2 = disbursementDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement date3.
   *
   * @param  disbursementDate3  Date
   */
  public void setDisbursementDate3(Date disbursementDate3) {
    this.disbursementDate3 = disbursementDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement date4.
   *
   * @param  disbursementDate4  Date
   */
  public void setDisbursementDate4(Date disbursementDate4) {
    this.disbursementDate4 = disbursementDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement sequence number1.
   *
   * @param  disbursementSequenceNumber1  Integer
   */
  public void setDisbursementSequenceNumber1(Integer disbursementSequenceNumber1) {
    this.disbursementSequenceNumber1 = disbursementSequenceNumber1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement sequence number2.
   *
   * @param  disbursementSequenceNumber2  Integer
   */
  public void setDisbursementSequenceNumber2(Integer disbursementSequenceNumber2) {
    this.disbursementSequenceNumber2 = disbursementSequenceNumber2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement sequence number3.
   *
   * @param  disbursementSequenceNumber3  Integer
   */
  public void setDisbursementSequenceNumber3(Integer disbursementSequenceNumber3) {
    this.disbursementSequenceNumber3 = disbursementSequenceNumber3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disbursement sequence number4.
   *
   * @param  disbursementSequenceNumber4  Integer
   */
  public void setDisbursementSequenceNumber4(Integer disbursementSequenceNumber4) {
    this.disbursementSequenceNumber4 = disbursementSequenceNumber4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email1098 ETax letter flag.
   *
   * @param  email1098ETaxLetterFlag  Boolean
   */
  public void setEmail1098ETaxLetterFlag(Boolean email1098ETaxLetterFlag) {
    this.email1098ETaxLetterFlag = email1098ETaxLetterFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr customer solicitation code.
   *
   * @param  fdrCustomerSolicitationCode  String
   */
  public void setFdrCustomerSolicitationCode(String fdrCustomerSolicitationCode) {
    this.fdrCustomerSolicitationCode = fdrCustomerSolicitationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fdr person id.
   *
   * @param  fdrPersonId  String
   */
  public void setFdrPersonId(String fdrPersonId) {
    this.fdrPersonId = fdrPersonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for person1098 EPermission last update date.
   *
   * @param  person1098EPermissionLastUpdateDate  Date
   */
  public void setPerson1098EPermissionLastUpdateDate(Date person1098EPermissionLastUpdateDate) {
    this.person1098EPermissionLastUpdateDate = person1098EPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for person email marketing permission last update date.
   *
   * @param  personEmailMarketingPermissionLastUpdateDate  Date
   */
  public void setPersonEmailMarketingPermissionLastUpdateDate(Date personEmailMarketingPermissionLastUpdateDate) {
    this.personEmailMarketingPermissionLastUpdateDate = personEmailMarketingPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for person mail marketing permission last update date.
   *
   * @param  personMailMarketingPermissionLastUpdateDate  Date
   */
  public void setPersonMailMarketingPermissionLastUpdateDate(Date personMailMarketingPermissionLastUpdateDate) {
    this.personMailMarketingPermissionLastUpdateDate = personMailMarketingPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for person non regulatory last update date.
   *
   * @param  personNonRegulatoryLastUpdateDate  Date
   */
  public void setPersonNonRegulatoryLastUpdateDate(Date personNonRegulatoryLastUpdateDate) {
    this.personNonRegulatoryLastUpdateDate = personNonRegulatoryLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for person regulatory permission last update date.
   *
   * @param  personRegulatoryPermissionLastUpdateDate  Date
   */
  public void setPersonRegulatoryPermissionLastUpdateDate(Date personRegulatoryPermissionLastUpdateDate) {
    this.personRegulatoryPermissionLastUpdateDate = personRegulatoryPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for person telephone marketing permission last update date.
   *
   * @param  personTelephoneMarketingPermissionLastUpdateDate  Date
   */
  public void setPersonTelephoneMarketingPermissionLastUpdateDate(
    Date personTelephoneMarketingPermissionLastUpdateDate) {
    this.personTelephoneMarketingPermissionLastUpdateDate = personTelephoneMarketingPermissionLastUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student enrollment certification date.
   *
   * @param  studentEnrollmentCertificationDate  Date
   */
  public void setStudentEnrollmentCertificationDate(Date studentEnrollmentCertificationDate) {
    this.studentEnrollmentCertificationDate = studentEnrollmentCertificationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student enrollment term begin date.
   *
   * @param  studentEnrollmentTermBeginDate  Date
   */
  public void setStudentEnrollmentTermBeginDate(Date studentEnrollmentTermBeginDate) {
    this.studentEnrollmentTermBeginDate = studentEnrollmentTermBeginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student enrollment term end date.
   *
   * @param  studentEnrollmentTermEndDate  Date
   */
  public void setStudentEnrollmentTermEndDate(Date studentEnrollmentTermEndDate) {
    this.studentEnrollmentTermEndDate = studentEnrollmentTermEndDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student separation date.
   *
   * @param  studentSeparationDate  Date
   */
  public void setStudentSeparationDate(Date studentSeparationDate) {
    this.studentSeparationDate = studentSeparationDate;
  }
} // end class SMWCustomerAdditionalDetail
