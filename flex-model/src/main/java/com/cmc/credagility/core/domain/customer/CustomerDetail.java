package com.cmc.credagility.core.domain.customer;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by IntelliJ IDEA. User: adevan Date: Dec 19, 2010 Time: 11:59:23 AM To change this template use File |
 * Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "CustomerDetail",
  indexes = {
    @Index(
      name = "contactValue",
      columnList = "contactValue"
    )
  }
  /*uniqueConstraints = { @UniqueConstraint(columnNames = {}) }*/
)
public class CustomerDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7751174048396380965L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "adminAppointmentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date adminAppointmentDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "adminAppointmentType",
    length = 100
  )
  protected String adminAppointmentType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "adminContactPerson",
    length = 100
  )
  protected String adminContactPerson;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "adminContactPhone",
    length = 100
  )
  protected String adminContactPhone;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "adminEmail",
    length = 100
  )
  protected String adminEmail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "adminName",
    length = 100
  )
  protected String adminName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyCreditorsAmount",
    length = 100
  )
  protected String bankruptcyCreditorsAmount;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyCreditorsNames",
    length = 100
  )
  protected String bankruptcyCreditorsNames;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bankruptcyDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date bankruptcyDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyDividendProspects",
    length = 100
  )
  protected String bankruptcyDividendProspects;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyEmail",
    length = 100
  )
  protected String bankruptcyEmail;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyEmpDetails",
    length = 100
  )
  protected String bankruptcyEmpDetails;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyReference",
    length = 100
  )
  protected String bankruptcyReference;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyTrustee",
    length = 100
  )
  protected String bankruptcyTrustee;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bankruptcyTrusteePhone",
    length = 100
  )
  protected String bankruptcyTrusteePhone;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientContactUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientContactUpdateDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "contactCode",
    length = 30
  )
  protected Integer contactCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "contactValue",
    length = 128
  )
  protected String contactValue;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "customerContact",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean customerContact = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customerDetailId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "deleted",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "fraudFlag",
    length = 1
  )
  protected String fraudFlag;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastClickToDialAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date   lastClickToDialAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastDialerAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastDialerAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastEmailAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastEmailAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLetterAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLetterAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastOutboundIvrAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastOutboundIvrAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastSmsAttemptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastSmsAttemptDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "part9AdministratorName",
    length = 100
  )
  protected String part9AdministratorName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "part9AdministratorPhone",
    length = 100
  )
  protected String part9AdministratorPhone;


  /** TODO: DOCUMENT ME! */
  @Column(name = "part9DeadlineDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date part9DeadlineDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "part9DebtProposalDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date part9DebtProposalDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "part9Email",
    length = 100
  )
  protected String part9Email;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "part9Reference",
    length = 100
  )
  protected String part9Reference;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "skipStatus",
    length = 1
  )
  protected String skipStatus;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "trusteeContactName",
    length = 100
  )
  protected String trusteeContactName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CustomerDetail)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CustomerDetail that = (CustomerDetail) o;

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((adminAppointmentDate != null) ? (!adminAppointmentDate.equals(that.adminAppointmentDate))
                                       : (that.adminAppointmentDate != null)) {
      return false;
    }

    if ((adminAppointmentType != null) ? (!adminAppointmentType.equals(that.adminAppointmentType))
                                       : (that.adminAppointmentType != null)) {
      return false;
    }

    if ((adminContactPerson != null) ? (!adminContactPerson.equals(that.adminContactPerson))
                                     : (that.adminContactPerson != null)) {
      return false;
    }

    if ((adminContactPhone != null) ? (!adminContactPhone.equals(that.adminContactPhone))
                                    : (that.adminContactPhone != null)) {
      return false;
    }

    if ((adminEmail != null) ? (!adminEmail.equals(that.adminEmail)) : (that.adminEmail != null)) {
      return false;
    }

    if ((adminName != null) ? (!adminName.equals(that.adminName)) : (that.adminName != null)) {
      return false;
    }

    if ((bankruptcyCreditorsAmount != null) ? (!bankruptcyCreditorsAmount.equals(that.bankruptcyCreditorsAmount))
                                            : (that.bankruptcyCreditorsAmount != null)) {
      return false;
    }

    if ((bankruptcyCreditorsNames != null) ? (!bankruptcyCreditorsNames.equals(that.bankruptcyCreditorsNames))
                                           : (that.bankruptcyCreditorsNames != null)) {
      return false;
    }

    if ((bankruptcyDate != null) ? (!bankruptcyDate.equals(that.bankruptcyDate)) : (that.bankruptcyDate != null)) {
      return false;
    }

    if ((bankruptcyDividendProspects != null) ? (!bankruptcyDividendProspects.equals(
              that.bankruptcyDividendProspects)) : (that.bankruptcyDividendProspects != null)) {
      return false;
    }

    if ((bankruptcyEmail != null) ? (!bankruptcyEmail.equals(that.bankruptcyEmail)) : (that.bankruptcyEmail != null)) {
      return false;
    }

    if ((bankruptcyEmpDetails != null) ? (!bankruptcyEmpDetails.equals(that.bankruptcyEmpDetails))
                                       : (that.bankruptcyEmpDetails != null)) {
      return false;
    }

    if ((bankruptcyReference != null) ? (!bankruptcyReference.equals(that.bankruptcyReference))
                                      : (that.bankruptcyReference != null)) {
      return false;
    }

    if ((bankruptcyTrustee != null) ? (!bankruptcyTrustee.equals(that.bankruptcyTrustee))
                                    : (that.bankruptcyTrustee != null)) {
      return false;
    }

    if ((bankruptcyTrusteePhone != null) ? (!bankruptcyTrusteePhone.equals(that.bankruptcyTrusteePhone))
                                         : (that.bankruptcyTrusteePhone != null)) {
      return false;
    }

    if ((customerDetailId != null) ? (!customerDetailId.equals(that.customerDetailId))
                                   : (that.customerDetailId != null)) {
      return false;
    }

    if ((fraudFlag != null) ? (!fraudFlag.equals(that.fraudFlag)) : (that.fraudFlag != null)) {
      return false;
    }

    if ((part9AdministratorName != null) ? (!part9AdministratorName.equals(that.part9AdministratorName))
                                         : (that.part9AdministratorName != null)) {
      return false;
    }

    if ((part9AdministratorPhone != null) ? (!part9AdministratorPhone.equals(that.part9AdministratorPhone))
                                          : (that.part9AdministratorPhone != null)) {
      return false;
    }

    if ((part9DeadlineDate != null) ? (!part9DeadlineDate.equals(that.part9DeadlineDate))
                                    : (that.part9DeadlineDate != null)) {
      return false;
    }

    if ((part9DebtProposalDate != null) ? (!part9DebtProposalDate.equals(that.part9DebtProposalDate))
                                        : (that.part9DebtProposalDate != null)) {
      return false;
    }

    if ((part9Email != null) ? (!part9Email.equals(that.part9Email)) : (that.part9Email != null)) {
      return false;
    }

    if ((part9Reference != null) ? (!part9Reference.equals(that.part9Reference)) : (that.part9Reference != null)) {
      return false;
    }

    if ((skipStatus != null) ? (!skipStatus.equals(that.skipStatus)) : (that.skipStatus != null)) {
      return false;
    }

    if ((trusteeContactName != null) ? (!trusteeContactName.equals(that.trusteeContactName))
                                     : (that.trusteeContactName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin appointment date.
   *
   * @return  Date
   */
  public Date getAdminAppointmentDate() {
    return adminAppointmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin appointment type.
   *
   * @return  String
   */
  public String getAdminAppointmentType() {
    return adminAppointmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin contact person.
   *
   * @return  String
   */
  public String getAdminContactPerson() {
    return adminContactPerson;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin contact phone.
   *
   * @return  String
   */
  public String getAdminContactPhone() {
    return adminContactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin email.
   *
   * @return  String
   */
  public String getAdminEmail() {
    return adminEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin name.
   *
   * @return  String
   */
  public String getAdminName() {
    return adminName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy creditors amount.
   *
   * @return  String
   */
  public String getBankruptcyCreditorsAmount() {
    return bankruptcyCreditorsAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy creditors names.
   *
   * @return  String
   */
  public String getBankruptcyCreditorsNames() {
    return bankruptcyCreditorsNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy date.
   *
   * @return  Date
   */
  public Date getBankruptcyDate() {
    return bankruptcyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy dividend prospects.
   *
   * @return  String
   */
  public String getBankruptcyDividendProspects() {
    return bankruptcyDividendProspects;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy email.
   *
   * @return  String
   */
  public String getBankruptcyEmail() {
    return bankruptcyEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy emp details.
   *
   * @return  String
   */
  public String getBankruptcyEmpDetails() {
    return bankruptcyEmpDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy reference.
   *
   * @return  String
   */
  public String getBankruptcyReference() {
    return bankruptcyReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy trustee.
   *
   * @return  String
   */
  public String getBankruptcyTrustee() {
    return bankruptcyTrustee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bankruptcy trustee phone.
   *
   * @return  String
   */
  public String getBankruptcyTrusteePhone() {
    return bankruptcyTrusteePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client contact update date.
   *
   * @return  Date
   */
  public Date getClientContactUpdateDate() {
    return clientContactUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact code.
   *
   * @return  Integer
   */
  public Integer getContactCode() {
    return contactCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact value.
   *
   * @return  String
   */
  public String getContactValue() {
    return contactValue;
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
   * getter method for customer contact.
   *
   * @return  Boolean
   */
  public Boolean getCustomerContact() {
    return customerContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer detail id.
   *
   * @return  Long
   */
  public Long getCustomerDetailId() {
    return customerDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted.
   *
   * @return  Boolean
   */
  public Boolean getDeleted() {
    return deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fraud flag.
   *
   * @return  String
   */
  public String getFraudFlag() {
    return fraudFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last click to dial attempt date.
   *
   * @return  Date
   */
  public Date getLastClickToDialAttemptDate() {
    return lastClickToDialAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last dialer attempt date.
   *
   * @return  Date
   */
  public Date getLastDialerAttemptDate() {
    return lastDialerAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last email attempt date.
   *
   * @return  Date
   */
  public Date getLastEmailAttemptDate() {
    return lastEmailAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last letter attempt date.
   *
   * @return  Date
   */
  public Date getLastLetterAttemptDate() {
    return lastLetterAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last outbound ivr attempt date.
   *
   * @return  Date
   */
  public Date getLastOutboundIvrAttemptDate() {
    return lastOutboundIvrAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last sms attempt date.
   *
   * @return  Date
   */
  public Date getLastSmsAttemptDate() {
    return lastSmsAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for part9 administrator name.
   *
   * @return  String
   */
  public String getPart9AdministratorName() {
    return part9AdministratorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for part9 administrator phone.
   *
   * @return  String
   */
  public String getPart9AdministratorPhone() {
    return part9AdministratorPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for part9 deadline date.
   *
   * @return  Date
   */
  public Date getPart9DeadlineDate() {
    return part9DeadlineDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for part9 debt proposal date.
   *
   * @return  Date
   */
  public Date getPart9DebtProposalDate() {
    return part9DebtProposalDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for part9 email.
   *
   * @return  String
   */
  public String getPart9Email() {
    return part9Email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for part9 reference.
   *
   * @return  String
   */
  public String getPart9Reference() {
    return part9Reference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for skip status.
   *
   * @return  String
   */
  public String getSkipStatus() {
    return skipStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trustee contact name.
   *
   * @return  String
   */
  public String getTrusteeContactName() {
    return trusteeContactName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((adminAppointmentDate != null) ? adminAppointmentDate.hashCode() : 0);
    result = (31 * result) + ((adminAppointmentType != null) ? adminAppointmentType.hashCode() : 0);
    result = (31 * result) + ((adminContactPerson != null) ? adminContactPerson.hashCode() : 0);
    result = (31 * result) + ((adminContactPhone != null) ? adminContactPhone.hashCode() : 0);
    result = (31 * result) + ((adminEmail != null) ? adminEmail.hashCode() : 0);
    result = (31 * result) + ((adminName != null) ? adminName.hashCode() : 0);
    result = (31 * result) + ((bankruptcyCreditorsAmount != null) ? bankruptcyCreditorsAmount.hashCode() : 0);
    result = (31 * result) + ((bankruptcyCreditorsNames != null) ? bankruptcyCreditorsNames.hashCode() : 0);
    result = (31 * result) + ((bankruptcyDate != null) ? bankruptcyDate.hashCode() : 0);
    result = (31 * result) + ((bankruptcyDividendProspects != null) ? bankruptcyDividendProspects.hashCode() : 0);
    result = (31 * result) + ((bankruptcyEmail != null) ? bankruptcyEmail.hashCode() : 0);
    result = (31 * result) + ((bankruptcyEmpDetails != null) ? bankruptcyEmpDetails.hashCode() : 0);
    result = (31 * result) + ((bankruptcyReference != null) ? bankruptcyReference.hashCode() : 0);
    result = (31 * result) + ((bankruptcyTrustee != null) ? bankruptcyTrustee.hashCode() : 0);
    result = (31 * result) + ((bankruptcyTrusteePhone != null) ? bankruptcyTrusteePhone.hashCode() : 0);
    result = (31 * result) + ((customerDetailId != null) ? customerDetailId.hashCode() : 0);
    result = (31 * result) + ((fraudFlag != null) ? fraudFlag.hashCode() : 0);
    result = (31 * result) + ((part9AdministratorName != null) ? part9AdministratorName.hashCode() : 0);
    result = (31 * result) + ((part9AdministratorPhone != null) ? part9AdministratorPhone.hashCode() : 0);
    result = (31 * result) + ((part9DeadlineDate != null) ? part9DeadlineDate.hashCode() : 0);
    result = (31 * result) + ((part9DebtProposalDate != null) ? part9DebtProposalDate.hashCode() : 0);
    result = (31 * result) + ((part9Email != null) ? part9Email.hashCode() : 0);
    result = (31 * result) + ((part9Reference != null) ? part9Reference.hashCode() : 0);
    result = (31 * result) + ((skipStatus != null) ? skipStatus.hashCode() : 0);
    result = (31 * result) + ((trusteeContactName != null) ? trusteeContactName.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin appointment date.
   *
   * @param  adminAppointmentDate  Date
   */
  public void setAdminAppointmentDate(Date adminAppointmentDate) {
    this.adminAppointmentDate = adminAppointmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin appointment type.
   *
   * @param  adminAppointmentType  String
   */
  public void setAdminAppointmentType(String adminAppointmentType) {
    this.adminAppointmentType = adminAppointmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin contact person.
   *
   * @param  adminContactPerson  String
   */
  public void setAdminContactPerson(String adminContactPerson) {
    this.adminContactPerson = adminContactPerson;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin contact phone.
   *
   * @param  adminContactPhone  String
   */
  public void setAdminContactPhone(String adminContactPhone) {
    this.adminContactPhone = adminContactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin email.
   *
   * @param  adminEmail  String
   */
  public void setAdminEmail(String adminEmail) {
    this.adminEmail = adminEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin name.
   *
   * @param  adminName  String
   */
  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy creditors amount.
   *
   * @param  bankruptcyCreditorsAmount  String
   */
  public void setBankruptcyCreditorsAmount(String bankruptcyCreditorsAmount) {
    this.bankruptcyCreditorsAmount = bankruptcyCreditorsAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy creditors names.
   *
   * @param  bankruptcyCreditorsNames  String
   */
  public void setBankruptcyCreditorsNames(String bankruptcyCreditorsNames) {
    this.bankruptcyCreditorsNames = bankruptcyCreditorsNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy date.
   *
   * @param  bankruptcyDate  Date
   */
  public void setBankruptcyDate(Date bankruptcyDate) {
    this.bankruptcyDate = bankruptcyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy dividend prospects.
   *
   * @param  bankruptcyDividendProspects  String
   */
  public void setBankruptcyDividendProspects(String bankruptcyDividendProspects) {
    this.bankruptcyDividendProspects = bankruptcyDividendProspects;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy email.
   *
   * @param  bankruptcyEmail  String
   */
  public void setBankruptcyEmail(String bankruptcyEmail) {
    this.bankruptcyEmail = bankruptcyEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy emp details.
   *
   * @param  bankruptcyEmpDetails  String
   */
  public void setBankruptcyEmpDetails(String bankruptcyEmpDetails) {
    this.bankruptcyEmpDetails = bankruptcyEmpDetails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy reference.
   *
   * @param  bankruptcyReference  String
   */
  public void setBankruptcyReference(String bankruptcyReference) {
    this.bankruptcyReference = bankruptcyReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy trustee.
   *
   * @param  bankruptcyTrustee  String
   */
  public void setBankruptcyTrustee(String bankruptcyTrustee) {
    this.bankruptcyTrustee = bankruptcyTrustee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bankruptcy trustee phone.
   *
   * @param  bankruptcyTrusteePhone  String
   */
  public void setBankruptcyTrusteePhone(String bankruptcyTrusteePhone) {
    this.bankruptcyTrusteePhone = bankruptcyTrusteePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client contact update date.
   *
   * @param  clientContactUpdateDate  Date
   */
  public void setClientContactUpdateDate(Date clientContactUpdateDate) {
    this.clientContactUpdateDate = clientContactUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact code.
   *
   * @param  contactCode  Integer
   */
  public void setContactCode(Integer contactCode) {
    this.contactCode = contactCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact value.
   *
   * @param  contactValue  String
   */
  public void setContactValue(String contactValue) {
    this.contactValue = contactValue;
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
   * setter method for customer contact.
   *
   * @param  customerContact  Boolean
   */
  public void setCustomerContact(Boolean customerContact) {
    this.customerContact = customerContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer detail id.
   *
   * @param  customerDetailId  Long
   */
  public void setCustomerDetailId(Long customerDetailId) {
    this.customerDetailId = customerDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted.
   *
   * @param  deleted  Boolean
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fraud flag.
   *
   * @param  fraudFlag  String
   */
  public void setFraudFlag(String fraudFlag) {
    this.fraudFlag = fraudFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last click to dial attempt date.
   *
   * @param  lastClickToDialAttemptDate  Date
   */
  public void setLastClickToDialAttemptDate(Date lastClickToDialAttemptDate) {
    this.lastClickToDialAttemptDate = lastClickToDialAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last dialer attempt date.
   *
   * @param  lastDialerAttemptDate  Date
   */
  public void setLastDialerAttemptDate(Date lastDialerAttemptDate) {
    this.lastDialerAttemptDate = lastDialerAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last email attempt date.
   *
   * @param  lastEmailAttemptDate  Date
   */
  public void setLastEmailAttemptDate(Date lastEmailAttemptDate) {
    this.lastEmailAttemptDate = lastEmailAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last letter attempt date.
   *
   * @param  lastLetterAttemptDate  Date
   */
  public void setLastLetterAttemptDate(Date lastLetterAttemptDate) {
    this.lastLetterAttemptDate = lastLetterAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last outbound ivr attempt date.
   *
   * @param  lastOutboundIvrAttemptDate  Date
   */
  public void setLastOutboundIvrAttemptDate(Date lastOutboundIvrAttemptDate) {
    this.lastOutboundIvrAttemptDate = lastOutboundIvrAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last sms attempt date.
   *
   * @param  lastSmsAttemptDate  Date
   */
  public void setLastSmsAttemptDate(Date lastSmsAttemptDate) {
    this.lastSmsAttemptDate = lastSmsAttemptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for part9 administrator name.
   *
   * @param  part9AdministratorName  String
   */
  public void setPart9AdministratorName(String part9AdministratorName) {
    this.part9AdministratorName = part9AdministratorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for part9 administrator phone.
   *
   * @param  part9AdministratorPhone  String
   */
  public void setPart9AdministratorPhone(String part9AdministratorPhone) {
    this.part9AdministratorPhone = part9AdministratorPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for part9 deadline date.
   *
   * @param  part9DeadlineDate  Date
   */
  public void setPart9DeadlineDate(Date part9DeadlineDate) {
    this.part9DeadlineDate = part9DeadlineDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for part9 debt proposal date.
   *
   * @param  part9DebtProposalDate  Date
   */
  public void setPart9DebtProposalDate(Date part9DebtProposalDate) {
    this.part9DebtProposalDate = part9DebtProposalDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for part9 email.
   *
   * @param  part9Email  String
   */
  public void setPart9Email(String part9Email) {
    this.part9Email = part9Email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for part9 reference.
   *
   * @param  part9Reference  String
   */
  public void setPart9Reference(String part9Reference) {
    this.part9Reference = part9Reference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for skip status.
   *
   * @param  skipStatus  String
   */
  public void setSkipStatus(String skipStatus) {
    this.skipStatus = skipStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trustee contact name.
   *
   * @param  trusteeContactName  String
   */
  public void setTrusteeContactName(String trusteeContactName) {
    this.trusteeContactName = trusteeContactName;
  }
} // end class CustomerDetail
