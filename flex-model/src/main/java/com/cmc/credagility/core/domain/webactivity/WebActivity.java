package com.cmc.credagility.core.domain.webactivity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.disclosure.DisclosureAudit;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to log all web activity.
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:12
 */
@Entity
@Table(
  name    = "WebActivity",
  indexes = {
    @Index(
      columnList = "createDate",
      name = "createDateIndex"
    ),
    @Index(
      columnList = "name,createDate",
      name = "nameCreateDateIndex"
    ),
    @Index(
      columnList = "sessionId,name",
      name = "sessionNameIndex"
    )
  }
)
public class WebActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5553879490170922847L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "activityChannel",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected WebActivityChannel activityChannel;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Web Activity PK activityId. */
  @Column(
    name     = "activityId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long activityId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowWeb",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowWeb;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "browserId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Browser browser;

  // RamaKrishna, 09/04, SallieMae ,Column length increased to 750 to fix SM-59
  /** data field 1. */
  @Column(
    name   = "data1",
    length = 750
  )
  protected String data1;

  // RamaKrishna, 09/04, SallieMae ,Column length increased to 750 to fix SM-59
  /** data field 2. */
  @Column(
    name   = "data2",
    length = 750
  )
  protected String data2;

  /** data field 3. */
  @Column(
    name   = "data3",
    length = 750
  )
  protected String data3;

  // Tom Donovan, 08/2014, column length increased to 750 for DCR schedule appointment bug fix
  /** data field 4. */
  @Column(
    name   = "data4",
    length = 750
  )
  protected String data4;

  /** data field 5. */
  @Column(
    name   = "data5",
    length = 150
  )
  protected String data5;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    cascade  = { CascadeType.MERGE, CascadeType.PERSIST },
    fetch    = FetchType.LAZY,
    mappedBy = "webActivity"
  )
  protected DisclosureAudit disclosureAudit;

  /** IP address of the remote machine. */
  @Column(
    name   = "iPAddress",
    length = 40
  )
  protected String iPAddress;

  /** locale used for the user. */
  @Column(
    name   = "locale",
    length = 7
  )
  protected String locale;

  /** activity name. */
  @Column(
    name     = "name",
    nullable = false,
    length   = 80
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "isInternal",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isInternal = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Transient protected Payment payment;

  /** TODO: DOCUMENT ME! */
  @Transient protected PaymentProgram paymentProgram;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "previousUrlId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Url previousUrl;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "refererId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Url referer;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "sessionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Session session;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "source",
    length = 40
  )
  protected String source;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transactionTime",
    nullable = true
  )
  protected Long transactionTime;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "urlId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Url url;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "webActivity",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected WebActivityExtension webActivityExtension = null;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addWebActivityExtension.
   *
   * @param  webActivityExtension  WebActivityExtension
   */
  public void addWebActivityExtension(WebActivityExtension webActivityExtension) {
    webActivityExtension.setWebActivity(this);
    setWebActivityExtension(webActivityExtension);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  other  WebActivity
   */
  public void deepCopy(WebActivity other) {
    this.active          = other.getActive();
    this.activityChannel = other.getActivityChannel();
    this.agent           = other.getAgent();
    this.allowWeb        = other.getAllowWeb();
    this.browser         = other.getBrowser();
    this.data1           = other.getData1();
    this.data2           = other.getData2();
    this.data3           = other.getData3();
    this.data4           = other.getData4();
    this.data5           = other.getData5();
    this.disclosureAudit = other.getDisclosureAudit();
    this.iPAddress       = other.getIPAddress();
    this.locale          = other.getLocale();
    this.name            = other.getName();
    this.isInternal      = other.getIsInternal();
    this.previousUrl     = other.getPreviousUrl();
    this.referer         = other.getReferer();
    this.session         = other.getSession();
    this.source          = other.getSource();
    this.transactionTime = other.getTransactionTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#equals(java.lang.Object)
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

    final WebActivity other = (WebActivity) obj;

    if (this.data1 == null) {
      if (other.getData1() != null) {
        return false;
      }
    } else if (!this.data1.equals(other.getData1())) {
      return false;
    }

    if (this.data2 == null) {
      if (other.getData2() != null) {
        return false;
      }
    } else if (!this.data2.equals(other.getData2())) {
      return false;
    }

    if (this.data3 == null) {
      if (other.getData3() != null) {
        return false;
      }
    } else if (!this.data3.equals(other.getData3())) {
      return false;
    }

    if (this.data4 == null) {
      if (other.getData4() != null) {
        return false;
      }
    } else if (!this.data4.equals(other.getData4())) {
      return false;
    }

    if (this.data5 == null) {
      if (other.getData5() != null) {
        return false;
      }
    } else if (!this.data5.equals(other.getData5())) {
      return false;
    }

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    if (this.createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!this.createDate.equals(other.getCreateDate())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity channel.
   *
   * @return  WebActivityChannel
   */
  public WebActivityChannel getActivityChannel() {
    return activityChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity channel name.
   *
   * @return  String
   */
  public String getActivityChannelName() {
    return activityChannel.name();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity id.
   *
   * @return  Long
   */
  public Long getActivityId() {
    return this.activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow web.
   *
   * @return  Boolean
   */
  public Boolean getAllowWeb() {
    return allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for browser.
   *
   * @return  Browser
   */
  public Browser getBrowser() {
    return browser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return activityChannel.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return this.data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return this.data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return this.data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return this.data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return this.data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disclosure audit.
   *
   * @return  DisclosureAudit
   */
  public DisclosureAudit getDisclosureAudit() {
    return disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for IPAddress.
   *
   * @return  String
   */
  public String getIPAddress() {
    return iPAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is internal.
   *
   * @return  Boolean
   */
  public Boolean getIsInternal() {
    return isInternal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locale.
   *
   * @return  String
   */
  public String getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getName()
   */
  @Override public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getPaymentProgram() {
    return paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous url.
   *
   * @return  Url
   */
  public Url getPreviousUrl() {
    return previousUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for referer.
   *
   * @return  Url
   */
  public Url getReferer() {
    return referer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  public Session getSession() {
    return session;
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
   * getter method for transaction time.
   *
   * @return  Long
   */
  public Long getTransactionTime() {
    return transactionTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for url.
   *
   * @return  Url
   */
  public Url getUrl() {
    return url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web activity extension.
   *
   * @return  WebActivityExtension
   */
  public WebActivityExtension getWebActivityExtension() {
    return webActivityExtension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (PRIME * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (PRIME * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (PRIME * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (PRIME * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity channel.
   *
   * @param  channel  WebActivityChannel
   */
  public void setActivityChannel(WebActivityChannel channel) {
    this.activityChannel = channel;
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
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow web.
   *
   * @param  allowWeb  Boolean
   */
  public void setAllowWeb(Boolean allowWeb) {
    this.allowWeb = allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for browser.
   *
   * @param  browser  Browser
   */
  public void setBrowser(Browser browser) {
    this.browser = browser;
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
   * setter method for disclosure audit.
   *
   * @param  disclosureAudit  DisclosureAudit
   */
  public void setDisclosureAudit(DisclosureAudit disclosureAudit) {
    this.disclosureAudit = disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for IPAddress.
   *
   * @param  address  String
   */
  public void setIPAddress(String address) {
    iPAddress = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is internal.
   *
   * @param  isInternal  Boolean
   */
  public void setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale.
   *
   * @param  locale  String
   */
  public void setLocale(String locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment program.
   *
   * @param  paymentProgram  PaymentProgram
   */
  public void setPaymentProgram(PaymentProgram paymentProgram) {
    this.paymentProgram = paymentProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous url.
   *
   * @param  previousUrl  Url
   */
  public void setPreviousUrl(Url previousUrl) {
    this.previousUrl = previousUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for referer.
   *
   * @param  referer  Url
   */
  public void setReferer(Url referer) {
    this.referer = referer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session.
   *
   * @param  session  Session
   */
  public void setSession(Session session) {
    this.session = session;
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
   * setter method for transaction time.
   *
   * @param  transactionTime  Long
   */
  public void setTransactionTime(Long transactionTime) {
    this.transactionTime = transactionTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for url.
   *
   * @param  url  Url
   */
  public void setUrl(Url url) {
    this.url = url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for valid data1.
   *
   * @param  data1  String
   */
  public void setValidData1(String data1) {
    if (data1 != null) {
      if (data1.length() > 750) {
        data1 = data1.substring(0, 750);
      }
    }

    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for valid data5.
   *
   * @param  data5  String
   */
  public void setValidData5(String data5) {
    if (data5 != null) {
      if (data5.length() > 150) {
        data5 = data5.substring(0, 150);
      }
    }

    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web activity extension.
   *
   * @param  webActivityExtension  WebActivityExtension
   */
  public void setWebActivityExtension(WebActivityExtension webActivityExtension) {
    this.webActivityExtension = webActivityExtension;
  }
} // end class WebActivity
