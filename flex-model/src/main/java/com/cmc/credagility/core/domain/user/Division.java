package com.cmc.credagility.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Division is the sub-unit of Portfolio. From collections business perspective, we may want just one portfolio, using
 * the same strategy, etc. However, within the same portfolio, we may have different divisions which can have its own
 * brand (not required). If division-specific brand does not exist, we can simply use portfolio brand.
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:14
 */
@Entity
@Table(
  name    = "Division",
  indexes = {
    @Index(
      columnList = "clientDivisionCode",
      name = "clientDivisionCodeIndex"
    )
  }
)
public class Division extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1762466778360451193L;

  /** DOCUMENT ME! */
  protected static final transient Logger logger = LoggerFactory.getLogger(Division.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowACH",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowACH = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowCredit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowCredit = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowDebit",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDebit = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "contactPhoneNumber",
    length = 20
  )
  protected String contactPhoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "currencySymbol",
    length = 4
  )
  protected String currencySymbol;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "redirectUrl",
    length = 150
  )
  protected String redirectUrl;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "webSiteUrl",
    length = 150
  )
  protected String webSiteUrl;
  @Column(
    name   = "clientDivisionCode",
    length = 20
  )
  private String   clientDivisionCode;


  @Column(
    name   = "description",
    length = 200
  )
  private String description;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "divisionId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long divisionId;
  @Column(
    name   = "divisionName",
    length = 50
  )
  private String   divisionName;
  @Column(
    name   = "emailPassword",
    length = 50
  )
  private String   emailPassword;
  @Column(
    name   = "emailUserName",
    length = 50
  )
  private String   emailUserName;

  @Column(
    name             = "enableFLAMessage",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enableFLAMessage = false;

  @Column(
    name   = "image",
    length = 200
  )
  private String image;

  @Column(
    name   = "merchantAccount",
    length = 80
  )
  private String merchantAccount;
  @Column(
    name   = "merchantAccountAccessCode",
    length = 80
  )
  private String merchantAccountAccessCode;
  @Column(
    name   = "merchantAccountPassword",
    length = 80
  )
  private String merchantAccountPassword;
  @Column(
    name   = "merchantZid",
    length = 80
  )
  private String merchantZid;

  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @Column(
    name   = "redirectCode",
    length = 45
  )
  private String redirectCode;
  @Column(
    name   = "theme",
    length = 30
  )
  private String theme;

  @Column(
    name   = "twilioAuthToken",
    length = 100
  )
  private String twilioAuthToken;

  @Column(
    name   = "twilioFromNumber",
    length = 50
  )
  private String twilioFromNumber;

  @Column(
    name   = "twilioSid",
    length = 100
  )
  private String twilioSid;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Division other = (Division) obj;

    if (divisionId == null) {
      if (other.getDivisionId() != null) {
        return false;
      }
    } else if (!divisionId.equals(other.getDivisionId())) {
      return false;
    }

    if (divisionName == null) {
      if (other.getDivisionName() != null) {
        return false;
      }
    } else if (!divisionName.equals(other.getDivisionName())) {
      return false;
    }

    if (clientDivisionCode == null) {
      if (other.getClientDivisionCode() != null) {
        return false;
      }
    } else if (!clientDivisionCode.equals(other.getClientDivisionCode())) {
      return false;
    }


    if (theme == null) {
      if (other.getTheme() != null) {
        return false;
      }
    } else if (!theme.equals(other.getTheme())) {
      return false;
    }

    if (description == null) {
      if (other.getDescription() != null) {
        return false;
      }
    } else if (!description.equals(other.getDescription())) {
      return false;
    }

    if (redirectUrl == null) {
      if (other.getRedirectUrl() != null) {
        return false;
      }
    } else if (!redirectUrl.equals(other.getRedirectUrl())) {
      return false;
    }

    if (webSiteUrl == null) {
      if (other.getWebSiteUrl() != null) {
        return false;
      }
    } else if (!webSiteUrl.equals(other.getWebSiteUrl())) {
      return false;
    }


    if (image == null) {
      if (other.getImage() != null) {
        return false;
      }
    } else if (!image.equals(other.getImage())) {
      return false;
    }

    if (merchantAccount == null) {
      if (other.getMerchantAccount() != null) {
        return false;
      }
    } else if (!merchantAccount.equals(other.getMerchantAccount())) {
      return false;
    }


    if (merchantAccountAccessCode == null) {
      if (other.getMerchantAccountAccessCode() != null) {
        return false;
      }
    } else if (!merchantAccountAccessCode.equals(other.getMerchantAccountAccessCode())) {
      return false;
    }

    if (merchantAccountPassword == null) {
      if (other.getMerchantAccountPassword() != null) {
        return false;
      }
    } else if (!merchantAccountPassword.equals(other.getMerchantAccountPassword())) {
      return false;
    }

    if (portfolio == null) {
      if (other.getPortfolio() != null) {
        return false;
      }
    } else if (!portfolio.equals(other.getPortfolio())) {
      return false;
    }

    if (redirectCode == null) {
      if (other.getRedirectCode() != null) {
        return false;
      }
    } else if (!redirectCode.equals(other.getRedirectCode())) {
      return false;
    }


    if (allowACH == null) {
      if (other.getAllowACH() != null) {
        return false;
      }
    } else if (!allowACH.equals(other.getAllowACH())) {
      return false;
    }

    if (allowCredit == null) {
      if (other.getAllowCredit() != null) {
        return false;
      }
    } else if (!allowCredit.equals(other.getAllowCredit())) {
      return false;
    }

    if (allowDebit == null) {
      if (other.getAllowDebit() != null) {
        return false;
      }
    } else if (!allowDebit.equals(other.getAllowDebit())) {
      return false;
    }

    if (contactPhoneNumber == null) {
      if (other.getContactPhoneNumber() != null) {
        return false;
      }
    } else if (!contactPhoneNumber.equals(other.getContactPhoneNumber())) {
      return false;
    }

    if (currencySymbol == null) {
      if (other.getCurrencySymbol() != null) {
        return false;
      }
    } else if (!currencySymbol.equals(other.getCurrencySymbol())) {
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
  public Boolean getAllowACH() {
    logger.info("DIVISION -->allowCredit-->" + allowACH);


    if (null == allowACH) {
      return null;
    } else if (allowACH.toString().trim().length() == 0) {
      return Boolean.TRUE;
    }

    return allowACH;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow credit.
   *
   * @return  Boolean
   */
  public Boolean getAllowCredit() {
    return allowCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow debit.
   *
   * @return  Boolean
   */
  public Boolean getAllowDebit() {
    logger.info("DIVISION -->allowDebit-->" + allowDebit);

    if (null == allowDebit) {
      return null;
    } else if (allowDebit.toString().trim().length() == 0) {
      return Boolean.TRUE;
    }

    return allowDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client division code.
   *
   * @return  String
   */
  public String getClientDivisionCode() {
    return clientDivisionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone number.
   *
   * @return  String
   */
  public String getContactPhoneNumber() {
    return contactPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for currency symbol.
   *
   * @return  String
   */
  public String getCurrencySymbol() {
    return currencySymbol;
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
   * getter method for division id.
   *
   * @return  Long
   */
  public Long getDivisionId() {
    return divisionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for division name.
   *
   * @return  String
   */
  public String getDivisionName() {
    return divisionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email password.
   *
   * @return  String
   */
  public String getEmailPassword() {
    return emailPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email user name.
   *
   * @return  String
   */
  public String getEmailUserName() {
    return emailUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable FLAMessage.
   *
   * @return  Boolean
   */
  public Boolean getEnableFLAMessage() {
    return enableFLAMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for image.
   *
   * @return  String
   */
  public String getImage() {
    return image;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for merchant account.
   *
   * @return  String
   */
  public String getMerchantAccount() {
    return merchantAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for merchant account access code.
   *
   * @return  String
   */
  public String getMerchantAccountAccessCode() {
    return merchantAccountAccessCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for merchant account password.
   *
   * @return  String
   */
  public String getMerchantAccountPassword() {
    return merchantAccountPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMerchantZid() {
    return merchantZid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for redirect code.
   *
   * @return  String
   */
  public String getRedirectCode() {
    return redirectCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for redirect url.
   *
   * @return  String
   */
  public String getRedirectUrl() {
    return redirectUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for theme.
   *
   * @return  String
   */
  public String getTheme() {
    return theme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio auth token.
   *
   * @return  String
   */
  public String getTwilioAuthToken() {
    return twilioAuthToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio from number.
   *
   * @return  String
   */
  public String getTwilioFromNumber() {
    return twilioFromNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio sid.
   *
   * @return  String
   */
  public String getTwilioSid() {
    return twilioSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web site url.
   *
   * @return  String
   */
  public String getWebSiteUrl() {
    return webSiteUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((divisionId == null) ? 0 : divisionId.hashCode());
    result = (prime * result) + ((portfolio == null) ? 0 : portfolio.hashCode());
    result = (prime * result) + ((divisionName == null) ? 0 : divisionName.hashCode());
    result = (prime * result) + ((theme == null) ? 0 : theme.hashCode());
    result = (prime * result) + ((clientDivisionCode == null) ? 0 : clientDivisionCode.hashCode());
    result = (prime * result) + ((description == null) ? 0 : description.hashCode());
    result = (prime * result) + ((allowACH == null) ? 0 : allowACH.hashCode());
    result = (prime * result) + ((allowCredit == null) ? 0 : allowCredit.hashCode());
    result = (prime * result) + ((allowDebit == null) ? 0 : allowDebit.hashCode());
    result = (prime * result) + ((contactPhoneNumber == null) ? 0 : contactPhoneNumber.hashCode());
    result = (prime * result) + ((currencySymbol == null) ? 0 : currencySymbol.hashCode());
    result = (prime * result) + ((redirectUrl == null) ? 0 : redirectUrl.hashCode());
    result = (prime * result) + ((webSiteUrl == null) ? 0 : webSiteUrl.hashCode());
    result = (prime * result) + ((image == null) ? 0 : image.hashCode());
    result = (prime * result) + ((merchantAccount == null) ? 0 : merchantAccount.hashCode());
    result = (prime * result) + ((merchantAccountAccessCode == null) ? 0 : merchantAccountAccessCode.hashCode());
    result = (prime * result) + ((merchantAccountPassword == null) ? 0 : merchantAccountPassword.hashCode());

    result = (prime * result) + ((redirectCode == null) ? 0 : redirectCode.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow credit.
   *
   * @param  allowCredit  Boolean
   */
  public void setAllowCredit(Boolean allowCredit) {
    this.allowCredit = allowCredit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow debit.
   *
   * @param  allowDebit  Boolean
   */
  public void setAllowDebit(Boolean allowDebit) {
    this.allowDebit = allowDebit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client division code.
   *
   * @param  clientDivisionCode  String
   */
  public void setClientDivisionCode(String clientDivisionCode) {
    this.clientDivisionCode = clientDivisionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone number.
   *
   * @param  contactPhoneNumber  String
   */
  public void setContactPhoneNumber(String contactPhoneNumber) {
    this.contactPhoneNumber = contactPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for currency symbol.
   *
   * @param  currencySymbol  String
   */
  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
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
   * setter method for division id.
   *
   * @param  divisionId  Long
   */
  public void setDivisionId(Long divisionId) {
    this.divisionId = divisionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for division name.
   *
   * @param  divisionName  String
   */
  public void setDivisionName(String divisionName) {
    this.divisionName = divisionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email password.
   *
   * @param  emailPassword  String
   */
  public void setEmailPassword(String emailPassword) {
    this.emailPassword = emailPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email user name.
   *
   * @param  emailUserName  String
   */
  public void setEmailUserName(String emailUserName) {
    this.emailUserName = emailUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable FLAMessage.
   *
   * @param  enableFLAMessage  Boolean
   */
  public void setEnableFLAMessage(Boolean enableFLAMessage) {
    this.enableFLAMessage = enableFLAMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for image.
   *
   * @param  image  String
   */
  public void setImage(String image) {
    this.image = image;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for merchant account.
   *
   * @param  merchantAccount  String
   */
  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for merchant account access code.
   *
   * @param  merchantAccountAccessCode  String
   */
  public void setMerchantAccountAccessCode(String merchantAccountAccessCode) {
    this.merchantAccountAccessCode = merchantAccountAccessCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for merchant account password.
   *
   * @param  merchantAccountPassword  String
   */
  public void setMerchantAccountPassword(String merchantAccountPassword) {
    this.merchantAccountPassword = merchantAccountPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  merchantZid  DOCUMENT ME!
   */
  public void setMerchantZid(String merchantZid) {
    this.merchantZid = merchantZid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for redirect code.
   *
   * @param  redirectCode  String
   */
  public void setRedirectCode(String redirectCode) {
    this.redirectCode = redirectCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for redirect url.
   *
   * @param  redirectUrl  String
   */
  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for theme.
   *
   * @param  theme  String
   */
  public void setTheme(String theme) {
    this.theme = theme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio auth token.
   *
   * @param  twilioAuthToken  String
   */
  public void setTwilioAuthToken(String twilioAuthToken) {
    this.twilioAuthToken = twilioAuthToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio from number.
   *
   * @param  twilioFromNumber  String
   */
  public void setTwilioFromNumber(String twilioFromNumber) {
    this.twilioFromNumber = twilioFromNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio sid.
   *
   * @param  twilioSid  String
   */
  public void setTwilioSid(String twilioSid) {
    this.twilioSid = twilioSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web site url.
   *
   * @param  webSiteUrl  String
   */
  public void setWebSiteUrl(String webSiteUrl) {
    this.webSiteUrl = webSiteUrl;
  }

} // end class Division
