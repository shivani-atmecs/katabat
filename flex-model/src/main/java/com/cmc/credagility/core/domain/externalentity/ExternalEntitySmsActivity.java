package com.cmc.credagility.core.domain.externalentity;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/09/2015 17:03
 */
@Entity
@Table(
  name    = "ExternalEntitySmsActivity",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "status"
    )
  }
)
public class ExternalEntitySmsActivity extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3456467001196901191L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "activityId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long activityId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "contactPhoneId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customerId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "externalEntityId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ExternalEntity externalEntity;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneNumber",
    length = 20
  )
  protected String phoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneType",
    length = 20
  )
  protected String phoneType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** DOCUMENT ME! */
  @Column(
    name   = "returnCode",
    length = 20
  )
  protected String returnCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "source",
    length = 20
  )
  protected String source;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 10
  )
  @Enumerated(EnumType.STRING)
  protected ChannelResultStatus status;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "template",
    length   = 255,
    nullable = true
  )
  protected String template;

  /** Refer table 'PortfolioChannelTemplate'. */
  @Column protected Long templateId;
  @Column(
    name   = "clientDefined80CharCode1",
    length = 80
  )
  private String         clientDefined80CharCode1;

  @Column(
    name   = "clientDefined80CharCode2",
    length = 80
  )
  private String clientDefined80CharCode2;

  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate1;

  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate2;

  @Column(
    name      = "clientDefinedDecimal1",
    precision = 19,
    scale     = 2
  )
  private BigDecimal clientDefinedDecimal1;

  @Column(
    name      = "clientDefinedDecimal2",
    precision = 19,
    scale     = 2
  )
  private BigDecimal clientDefinedDecimal2;

  @Column(
    name   = "clientDefinedFlag1",
    length = 1
  )
  private String clientDefinedFlag1;

  @Column(
    name   = "clientDefinedFlag2",
    length = 1
  )
  private String clientDefinedFlag2;

  @Column(
    name   = "clientDefinedInteger1",
    length = 11
  )
  private Integer clientDefinedInteger1;

  @Column(
    name   = "clientDefinedInteger2",
    length = 11
  )
  private Integer clientDefinedInteger2;

  @Column(name = "clientDefinedLong1")
  private Long clientDefinedLong1;

  @Column(name = "clientDefinedLong2")
  private Long clientDefinedLong2;

  @Column(
    name   = "clientDefinedString1",
    length = 256
  )
  private String clientDefinedString1;

  @Column(
    name   = "clientDefinedString2",
    length = 256
  )
  private String clientDefinedString2;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(java.lang.Object)
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

    ExternalEntitySmsActivity that = (ExternalEntitySmsActivity) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((activityId != null) ? (!activityId.equals(that.activityId)) : (that.activityId != null)) {
      return false;
    }

    if ((contactPhone != null) ? (!contactPhone.equals(that.contactPhone)) : (that.contactPhone != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((externalEntity != null) ? (!externalEntity.equals(that.externalEntity)) : (that.externalEntity != null)) {
      return false;
    }

    if ((phoneNumber != null) ? (!phoneNumber.equals(that.phoneNumber)) : (that.phoneNumber != null)) {
      return false;
    }

    if ((phoneType != null) ? (!phoneType.equals(that.phoneType)) : (that.phoneType != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((returnCode != null) ? (!returnCode.equals(that.returnCode)) : (that.returnCode != null)) {
      return false;
    }

    if ((source != null) ? (!source.equals(that.source)) : (that.source != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    if ((template != null) ? (!template.equals(that.template)) : (that.template != null)) {
      return false;
    }

    if ((templateId != null) ? (!templateId.equals(that.templateId)) : (that.templateId != null)) {
      return false;
    }

    if ((clientDefined80CharCode1 != null) ? (!clientDefined80CharCode1.equals(that.clientDefined80CharCode1))
                                           : (that.clientDefined80CharCode1 != null)) {
      return false;
    }

    if ((clientDefined80CharCode2 != null) ? (!clientDefined80CharCode2.equals(that.clientDefined80CharCode2))
                                           : (that.clientDefined80CharCode2 != null)) {
      return false;
    }

    if ((clientDefinedDate1 != null) ? (!clientDefinedDate1.equals(that.clientDefinedDate1))
                                     : (that.clientDefinedDate1 != null)) {
      return false;
    }

    if ((clientDefinedDate2 != null) ? (!clientDefinedDate2.equals(that.clientDefinedDate2))
                                     : (that.clientDefinedDate2 != null)) {
      return false;
    }

    if ((clientDefinedDecimal1 != null) ? (!clientDefinedDecimal1.equals(that.clientDefinedDecimal1))
                                        : (that.clientDefinedDecimal1 != null)) {
      return false;
    }

    if ((clientDefinedDecimal2 != null) ? (!clientDefinedDecimal2.equals(that.clientDefinedDecimal2))
                                        : (that.clientDefinedDecimal2 != null)) {
      return false;
    }

    if ((clientDefinedFlag1 != null) ? (!clientDefinedFlag1.equals(that.clientDefinedFlag1))
                                     : (that.clientDefinedFlag1 != null)) {
      return false;
    }

    if ((clientDefinedFlag2 != null) ? (!clientDefinedFlag2.equals(that.clientDefinedFlag2))
                                     : (that.clientDefinedFlag2 != null)) {
      return false;
    }

    if ((clientDefinedInteger1 != null) ? (!clientDefinedInteger1.equals(that.clientDefinedInteger1))
                                        : (that.clientDefinedInteger1 != null)) {
      return false;
    }

    if ((clientDefinedInteger2 != null) ? (!clientDefinedInteger2.equals(that.clientDefinedInteger2))
                                        : (that.clientDefinedInteger2 != null)) {
      return false;
    }

    if ((clientDefinedLong1 != null) ? (!clientDefinedLong1.equals(that.clientDefinedLong1))
                                     : (that.clientDefinedLong1 != null)) {
      return false;
    }

    if ((clientDefinedLong2 != null) ? (!clientDefinedLong2.equals(that.clientDefinedLong2))
                                     : (that.clientDefinedLong2 != null)) {
      return false;
    }

    if ((clientDefinedString1 != null) ? (!clientDefinedString1.equals(that.clientDefinedString1))
                                       : (that.clientDefinedString1 != null)) {
      return false;
    }

    return (clientDefinedString2 != null) ? clientDefinedString2.equals(that.clientDefinedString2)
                                          : (that.clientDefinedString2 == null);

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
   * getter method for activity id.
   *
   * @return  Long
   */
  public Long getActivityId() {
    return activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code1.
   *
   * @return  String
   */
  public String getClientDefined80CharCode1() {
    return clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code2.
   *
   * @return  String
   */
  public String getClientDefined80CharCode2() {
    return clientDefined80CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date2.
   *
   * @return  Date
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  String
   */
  public String getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  String
   */
  public String getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer1.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer2.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long1.
   *
   * @return  Long
   */
  public Long getClientDefinedLong1() {
    return clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long2.
   *
   * @return  Long
   */
  public Long getClientDefinedLong2() {
    return clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string1.
   *
   * @return  String
   */
  public String getClientDefinedString1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string2.
   *
   * @return  String
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
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
   * getter method for external entity.
   *
   * @return  ExternalEntity
   */
  public ExternalEntity getExternalEntity() {
    return externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  String
   */
  public String getPhoneType() {
    return phoneType;
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
   * getter method for return code.
   *
   * @return  String
   */
  public String getReturnCode() {
    return returnCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  ChannelResultStatus
   */
  public ChannelResultStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template.
   *
   * @return  String
   */
  public String getTemplate() {
    return template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template id.
   *
   * @return  Long
   */
  public Long getTemplateId() {
    return templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((activityId != null) ? activityId.hashCode() : 0);
    result = (31 * result) + ((contactPhone != null) ? contactPhone.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((externalEntity != null) ? externalEntity.hashCode() : 0);
    result = (31 * result) + ((phoneNumber != null) ? phoneNumber.hashCode() : 0);
    result = (31 * result) + ((phoneType != null) ? phoneType.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((returnCode != null) ? returnCode.hashCode() : 0);
    result = (31 * result) + ((source != null) ? source.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((template != null) ? template.hashCode() : 0);
    result = (31 * result) + ((templateId != null) ? templateId.hashCode() : 0);
    result = (31 * result) + ((clientDefined80CharCode1 != null) ? clientDefined80CharCode1.hashCode() : 0);
    result = (31 * result) + ((clientDefined80CharCode2 != null) ? clientDefined80CharCode2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate1 != null) ? clientDefinedDate1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate2 != null) ? clientDefinedDate2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal1 != null) ? clientDefinedDecimal1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal2 != null) ? clientDefinedDecimal2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag1 != null) ? clientDefinedFlag1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag2 != null) ? clientDefinedFlag2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger1 != null) ? clientDefinedInteger1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger2 != null) ? clientDefinedInteger2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedLong1 != null) ? clientDefinedLong1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedLong2 != null) ? clientDefinedLong2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString1 != null) ? clientDefinedString1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString2 != null) ? clientDefinedString2.hashCode() : 0);

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
   * setter method for activity id.
   *
   * @param  activityId  Long
   */
  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code1.
   *
   * @param  clientDefined80CharCode1  String
   */
  public void setClientDefined80CharCode1(String clientDefined80CharCode1) {
    this.clientDefined80CharCode1 = clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code2.
   *
   * @param  clientDefined80CharCode2  String
   */
  public void setClientDefined80CharCode2(String clientDefined80CharCode2) {
    this.clientDefined80CharCode2 = clientDefined80CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date2.
   *
   * @param  clientDefinedDate2  Date
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  String
   */
  public void setClientDefinedFlag1(String clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  String
   */
  public void setClientDefinedFlag2(String clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer1.
   *
   * @param  clientDefinedInteger1  Integer
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer2.
   *
   * @param  clientDefinedInteger2  Integer
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long1.
   *
   * @param  clientDefinedLong1  Long
   */
  public void setClientDefinedLong1(Long clientDefinedLong1) {
    this.clientDefinedLong1 = clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long2.
   *
   * @param  clientDefinedLong2  Long
   */
  public void setClientDefinedLong2(Long clientDefinedLong2) {
    this.clientDefinedLong2 = clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string1.
   *
   * @param  clientDefinedString1  String
   */
  public void setClientDefinedString1(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string2.
   *
   * @param  clientDefinedString2  String
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone.
   *
   * @param  contactPhone  ContactPhone
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
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
   * setter method for external entity.
   *
   * @param  externalEntity  ExternalEntity
   */
  public void setExternalEntity(ExternalEntity externalEntity) {
    this.externalEntity = externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  String
   */
  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for return code.
   *
   * @param  returnCode  String
   */
  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  ChannelResultStatus
   */
  public void setStatus(ChannelResultStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template.
   *
   * @param  template  String
   */
  public void setTemplate(String template) {
    this.template = template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template id.
   *
   * @param  templateId  Long
   */
  public void setTemplateId(Long templateId) {
    this.templateId = templateId;
  }
} // end class ExternalEntitySmsActivity
