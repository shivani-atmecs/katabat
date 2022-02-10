package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.agency.AgencyContactEmail;
import com.cmc.credagility.core.domain.contact.ContactEmail;
import com.cmc.credagility.core.domain.customer.CustomerContactEmail;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 12:55
 */
@Entity
@Table(
  name    = "EmailChannelActualResult",
  indexes = {
    @Index(
      name = "deliveryStatusIndex",
      columnList = "deliveryStatus"
    ), @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class EmailChannelActualResult extends BaseChannelActualResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "balance")
  protected BigDecimal balance;

  /** Import batch job Id. */
  @Column(name = "batchId")
  protected Long batchId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bucketAmount1")
  protected BigDecimal bucketAmount1;

  /** bucket amount 2. */
  @Column(name = "bucketAmount2")
  protected BigDecimal bucketAmount2;

  /** bucket amount 3. */
  @Column(name = "bucketAmount3")
  protected BigDecimal bucketAmount3;

  /** bucket amount 4. */
  @Column(name = "bucketAmount4")
  protected BigDecimal bucketAmount4;

  /** bucket amount 5. */
  @Column(name = "bucketAmount5")
  protected BigDecimal bucketAmount5;

  /** bucket amount 6. */
  @Column(name = "bucketAmount6")
  protected BigDecimal bucketAmount6;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bucketAmount7")
  protected BigDecimal bucketAmount7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clicked",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clicked;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "contactEmailId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactEmail contactEmail;

  /** Account current due. */
  @Column(name = "currentDue")
  protected BigDecimal currentDue;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customerEmailId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerContactEmail customerContactEmail;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data1",
    length = 100
  )
  protected String data1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data10",
    length = 100
  )
  protected String data10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data11",
    length = 100
  )
  protected String data11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data12",
    length = 100
  )
  protected String data12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data13",
    length = 100
  )
  protected String data13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data14",
    length = 100
  )
  protected String data14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data15",
    length = 100
  )
  protected String data15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data2",
    length = 100
  )
  protected String data2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data3",
    length = 100
  )
  protected String data3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data4",
    length = 100
  )
  protected String data4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data5",
    length = 150
  )
  protected String data5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data6",
    length = 2048
  )
  protected String data6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data7",
    length = 2048
  )
  protected String data7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data8",
    length = 2048
  )
  protected String data8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data9",
    length = 100
  )
  protected String data9;


  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyStage")
  protected Integer delinquencyCycle;


  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "deliveryStatus",
    length = 20
  )
  protected String deliveryStatus;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "emailActualResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long emailActualResultId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "emailAddress",
    length = 80
  )
  protected String emailAddress;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "emailCampaignId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EmailCampaign emailCampaign;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "emailResultId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EmailChannelResult emailChannelResult;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "emailChannelActualResult",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EmailOutboundAudit> emailOutboundAudits = new LinkedHashSet<EmailOutboundAudit>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "externalEntityContactEmailId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyContactEmail externalEntityContactEmail;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "firstName",
    length = 45
  )
  protected String firstName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastName",
    length = 45
  )
  protected String lastName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "middleInitial",
    length = 45
  )
  protected String middleInitial;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "opened",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean opened;


  /** TODO: DOCUMENT ME! */
  @Column(name = "pastDue")
  protected BigDecimal pastDue;


  /** TODO: DOCUMENT ME! */
  @Column(name = "paymentCreateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentCreateDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "placementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date placementDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "programAmount")
  protected BigDecimal programAmount;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "programExtra",
    length = 45
  )
  protected String programExtra;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "programName",
    length = 45
  )
  protected String programName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "salutation",
    length = 10
  )
  protected String salutation;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "spamreported",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean spamreported;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "statusDescription",
    length = 250
  )
  protected String statusDescription;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "title",
    length = 10
  )
  protected String title;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "unsubscribed",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean unsubscribed;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addEmailOutboundAudit.
   *
   * @param  emailOutboundAudit  EmailOutboundAudit
   */
  public void addEmailOutboundAudit(EmailOutboundAudit emailOutboundAudit) {
    getEmailOutboundAudits().add(emailOutboundAudit);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final EmailChannelActualResult other = (EmailChannelActualResult) obj;

    if (this.contactEmail == null) {
      if (other.contactEmail != null) {
        return false;
      }
    } else if (!this.contactEmail.equals(other.contactEmail)) {
      return false;
    }

    if (this.customerContactEmail == null) {
      if (other.customerContactEmail != null) {
        return false;
      }
    } else if (!this.customerContactEmail.equals(other.customerContactEmail)) {
      return false;
    }

    if (this.emailAddress == null) {
      if (other.emailAddress != null) {
        return false;
      }
    } else if (!this.emailAddress.equals(other.emailAddress)) {
      return false;
    }

    if (this.template == null) {
      if (other.template != null) {
        return false;
      }
    } else if (!this.template.equals(other.template)) {
      return false;
    }

    if (this.data6 == null) {
      if (other.data6 != null) {
        return false;
      }
    } else if (!this.data6.equals(other.data6)) {
      return false;
    }

    if (this.data5 == null) {
      if (other.data5 != null) {
        return false;
      }
    } else if (!this.data5.equals(other.data5)) {
      return false;
    }

    if (this.data1 == null) {
      if (other.data1 != null) {
        return false;
      }
    } else if (!this.data1.equals(other.data1)) {
      return false;
    }

    if (this.data2 == null) {
      if (other.data2 != null) {
        return false;
      }
    } else if (!this.data2.equals(other.data2)) {
      return false;
    }

    if (this.data7 == null) {
      if (other.data7 != null) {
        return false;
      }
    } else if (!this.data7.equals(other.data7)) {
      return false;
    }

    if (this.data11 == null) {
      if (other.data11 != null) {
        return false;
      }
    } else if (!this.data11.equals(other.data11)) {
      return false;
    }

    if (this.strategyDate == null) {
      if (other.strategyDate != null) {
        return false;
      }
    } else if (!this.strategyDate.equals(other.strategyDate)) {
      return false;
    }

    if (this.paymentCreateDate == null) {
      if (other.paymentCreateDate != null) {
        return false;
      }
    } else if (!this.paymentCreateDate.equals(other.paymentCreateDate)) {
      return false;
    }

    if (this.programAmount == null) {
      if (other.programAmount != null) {
        return false;
      }
    } else if (!this.programAmount.equals(other.programAmount)) {
      return false;
    }

    if (this.emailChannelResult == null) {
      if (other.emailChannelResult != null) {
        return false;
      }
    } else if (!this.emailChannelResult.equals(other.emailChannelResult)) {
      return false;
    }

    if (this.batchId == null) {
      if (other.batchId != null) {
        return false;
      }
    } else if (!this.batchId.equals(other.batchId)) {
      return false;
    }

    if (this.ruleBatchId == null) {
      if (other.ruleBatchId != null) {
        return false;
      }
    } else if (!this.ruleBatchId.equals(other.ruleBatchId)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
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
   * getter method for bucket amount1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount1() {
    return bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount2() {
    return bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount3() {
    return bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount4() {
    return bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount5() {
    return bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount6() {
    return bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount7() {
    return bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for clicked.
   *
   * @return  Boolean
   */
  public Boolean getClicked() {
    return clicked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact email.
   *
   * @return  ContactEmail
   */
  public ContactEmail getContactEmail() {
    return contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentDue() {
    return currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer contact email.
   *
   * @return  CustomerContactEmail
   */
  public CustomerContactEmail getCustomerContactEmail() {
    return customerContactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data10.
   *
   * @return  String
   */
  public String getData10() {
    return data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data11.
   *
   * @return  String
   */
  public String getData11() {
    return data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data12.
   *
   * @return  String
   */
  public String getData12() {
    return data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data13.
   *
   * @return  String
   */
  public String getData13() {
    return data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data14.
   *
   * @return  String
   */
  public String getData14() {
    return data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data15.
   *
   * @return  String
   */
  public String getData15() {
    return data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data6.
   *
   * @return  String
   */
  public String getData6() {
    return data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data7.
   *
   * @return  String
   */
  public String getData7() {
    return data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data8.
   *
   * @return  String
   */
  public String getData8() {
    return data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data9.
   *
   * @return  String
   */
  public String getData9() {
    return data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency cycle.
   *
   * @return  Integer
   */
  public Integer getDelinquencyCycle() {
    return delinquencyCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days.
   *
   * @return  Integer
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delivery status.
   *
   * @return  String
   */
  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email actual result id.
   *
   * @return  Long
   */
  public Long getEmailActualResultId() {
    return emailActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email address.
   *
   * @return  String
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email campaign.
   *
   * @return  EmailCampaign
   */
  public EmailCampaign getEmailCampaign() {
    return emailCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email channel result.
   *
   * @return  EmailChannelResult
   */
  public EmailChannelResult getEmailChannelResult() {
    return emailChannelResult;
  }
/*
  //~ ------------------------------------------------------------------------------------------------------------------

 */

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
  public EmailChannelResultDocument getEmailChannelResultDocument() {
  return emailChannelResultDocument;
  }*/

/*
  //~ ------------------------------------------------------------------------------------------------------------------

 */


  /*
  public EmailChannelResultDocument getEmailChannelResultDocument() {
  return emailChannelResultDocument;
  }*/


  /**
   * getter method for email outbound audits.
   *
   * @return  Set
   */
  public Set<EmailOutboundAudit> getEmailOutboundAudits() {
    return emailOutboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity contact email.
   *
   * @return  AgencyContactEmail
   */
  public AgencyContactEmail getExternalEntityContactEmail() {
    return externalEntityContactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for middle initial.
   *
   * @return  String
   */
  public String getMiddleInitial() {
    return middleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for opened.
   *
   * @return  Boolean
   */
  public Boolean getOpened() {
    return opened;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment create date.
   *
   * @return  Date
   */
  public Date getPaymentCreateDate() {
    return paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for placement date.
   *
   * @return  Date
   */
  public Date getPlacementDate() {
    return placementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProgramAmount() {
    return programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program extra.
   *
   * @return  String
   */
  public String getProgramExtra() {
    return programExtra;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program name.
   *
   * @return  String
   */
  public String getProgramName() {
    return programName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for salutation.
   *
   * @return  String
   */
  public String getSalutation() {
    return salutation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spamreported.
   *
   * @return  Boolean
   */
  public Boolean getSpamreported() {
    return spamreported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status description.
   *
   * @return  String
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for title.
   *
   * @return  String
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unsubscribed.
   *
   * @return  Boolean
   */
  public Boolean getUnsubscribed() {
    return unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();

    result = (prime * result)
      + ((this.emailAddress == null) ? 0 : this.emailAddress.hashCode());
    result = (prime * result)
      + ((this.template == null) ? 0 : this.template.hashCode());
    result = (prime * result)
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (prime * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (prime * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (prime * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (prime * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());
    result = (prime * result)
      + ((this.data6 == null) ? 0 : this.data6.hashCode());
    result = (prime * result)
      + ((this.data7 == null) ? 0 : this.data7.hashCode());
    result = (prime * result)
      + ((this.data8 == null) ? 0 : this.data8.hashCode());
    result = (prime * result)
      + ((this.data9 == null) ? 0 : this.data9.hashCode());
    result = (prime * result)
      + ((this.data10 == null) ? 0 : this.data10.hashCode());
    result = (prime * result)
      + ((this.data11 == null) ? 0 : this.data11.hashCode());
    result = (prime * result)
      + ((this.strategyDate == null) ? 0 : this.strategyDate.hashCode());
    result = (prime * result)
      + ((this.paymentCreateDate == null) ? 0 : this.paymentCreateDate.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
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
   * setter method for bucket amount1.
   *
   * @param  bucketAmount1  BigDecimal
   */
  public void setBucketAmount1(BigDecimal bucketAmount1) {
    this.bucketAmount1 = bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount2.
   *
   * @param  bucketAmount2  BigDecimal
   */
  public void setBucketAmount2(BigDecimal bucketAmount2) {
    this.bucketAmount2 = bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount3.
   *
   * @param  bucketAmount3  BigDecimal
   */
  public void setBucketAmount3(BigDecimal bucketAmount3) {
    this.bucketAmount3 = bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount4.
   *
   * @param  bucketAmount4  BigDecimal
   */
  public void setBucketAmount4(BigDecimal bucketAmount4) {
    this.bucketAmount4 = bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount5.
   *
   * @param  bucketAmount5  BigDecimal
   */
  public void setBucketAmount5(BigDecimal bucketAmount5) {
    this.bucketAmount5 = bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount6.
   *
   * @param  bucketAmount6  BigDecimal
   */
  public void setBucketAmount6(BigDecimal bucketAmount6) {
    this.bucketAmount6 = bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount7.
   *
   * @param  bucketAmount7  BigDecimal
   */
  public void setBucketAmount7(BigDecimal bucketAmount7) {
    this.bucketAmount7 = bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for clicked.
   *
   * @param  clicked  Boolean
   */
  public void setClicked(Boolean clicked) {
    this.clicked = clicked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact email.
   *
   * @param  contactEmail  ContactEmail
   */
  public void setContactEmail(ContactEmail contactEmail) {
    this.contactEmail = contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current due.
   *
   * @param  currentDue  BigDecimal
   */
  public void setCurrentDue(BigDecimal currentDue) {
    this.currentDue = currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer contact email.
   *
   * @param  customerContactEmail  CustomerContactEmail
   */
  public void setCustomerContactEmail(CustomerContactEmail customerContactEmail) {
    this.customerContactEmail = customerContactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data1.
   *
   * @param  data1  String
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data10.
   *
   * @param  data10  String
   */
  public void setData10(String data10) {
    this.data10 = data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data11.
   *
   * @param  data11  String
   */
  public void setData11(String data11) {
    this.data11 = data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data12.
   *
   * @param  data12  String
   */
  public void setData12(String data12) {
    this.data12 = data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data13.
   *
   * @param  data13  String
   */
  public void setData13(String data13) {
    this.data13 = data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data14.
   *
   * @param  data14  String
   */
  public void setData14(String data14) {
    this.data14 = data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data15.
   *
   * @param  data15  String
   */
  public void setData15(String data15) {
    this.data15 = data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data2.
   *
   * @param  data2  String
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data3.
   *
   * @param  data3  String
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data4.
   *
   * @param  data4  String
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data5.
   *
   * @param  data5  String
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data6.
   *
   * @param  data6  String
   */
  public void setData6(String data6) {
    this.data6 = data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data7.
   *
   * @param  data7  String
   */
  public void setData7(String data7) {
    this.data7 = data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data8.
   *
   * @param  data8  String
   */
  public void setData8(String data8) {
    this.data8 = data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data9.
   *
   * @param  data9  String
   */
  public void setData9(String data9) {
    this.data9 = data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency cycle.
   *
   * @param  delinquencyCycle  Integer
   */
  public void setDelinquencyCycle(Integer delinquencyCycle) {
    this.delinquencyCycle = delinquencyCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency days.
   *
   * @param  delinquencyDays  Integer
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delivery status.
   *
   * @param  deliveryStatus  String
   */
  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email actual result id.
   *
   * @param  emailActualResultId  Long
   */
  public void setEmailActualResultId(Long emailActualResultId) {
    this.emailActualResultId = emailActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email address.
   *
   * @param  emailAddress  String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email campaign.
   *
   * @param  emailCampaign  EmailCampaign
   */
  public void setEmailCampaign(EmailCampaign emailCampaign) {
    this.emailCampaign = emailCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email channel result.
   *
   * @param  emailChannelResult  EmailChannelResult
   */
  public void setEmailChannelResult(EmailChannelResult emailChannelResult) {
    this.emailChannelResult = emailChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email outbound audits.
   *
   * @param  emailOutboundAudits  Set
   */
  public void setEmailOutboundAudits(Set<EmailOutboundAudit> emailOutboundAudits) {
    this.emailOutboundAudits = emailOutboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity contact email.
   *
   * @param  externalEntityContactEmail  AgencyContactEmail
   */
  public void setExternalEntityContactEmail(AgencyContactEmail externalEntityContactEmail) {
    this.externalEntityContactEmail = externalEntityContactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first name.
   *
   * @param  firstName  String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last name.
   *
   * @param  lastName  String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for middle initial.
   *
   * @param  middleInitial  String
   */
  public void setMiddleInitial(String middleInitial) {
    this.middleInitial = middleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for opened.
   *
   * @param  opened  Boolean
   */
  public void setOpened(Boolean opened) {
    this.opened = opened;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for past due.
   *
   * @param  pastDue  BigDecimal
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment create date.
   *
   * @param  paymentCreateDate  Date
   */
  public void setPaymentCreateDate(Date paymentCreateDate) {
    this.paymentCreateDate = paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for placement date.
   *
   * @param  placementDate  Date
   */
  public void setPlacementDate(Date placementDate) {
    this.placementDate = placementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program amount.
   *
   * @param  programAmount  BigDecimal
   */
  public void setProgramAmount(BigDecimal programAmount) {
    this.programAmount = programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program extra.
   *
   * @param  programExtra  String
   */
  public void setProgramExtra(String programExtra) {
    this.programExtra = programExtra;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program name.
   *
   * @param  programName  String
   */
  public void setProgramName(String programName) {
    this.programName = programName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for salutation.
   *
   * @param  salutation  String
   */
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spamreported.
   *
   * @param  spamreported  Boolean
   */
  public void setSpamreported(Boolean spamreported) {
    this.spamreported = spamreported;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status description.
   *
   * @param  statusDescription  String
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for title.
   *
   * @param  title  String
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unsubscribed.
   *
   * @param  unsubscribed  Boolean
   */
  public void setUnsubscribed(Boolean unsubscribed) {
    this.unsubscribed = unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "EmailChannelActualResult ( " + super.toString() + TAB
      + "emailActualResultId = " + this.emailActualResultId + TAB + " )";

    return retValue;
  }
} // end class EmailChannelActualResult
