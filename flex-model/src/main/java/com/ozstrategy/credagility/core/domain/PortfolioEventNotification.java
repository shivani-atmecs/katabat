package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:47
 */
@Entity public class PortfolioEventNotification extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = true;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "emailBCC",
    length = 255
  )
  protected String emailBCC;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "emailCC",
    length = 255
  )
  protected String emailCC;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "emailTemplate",
    length   = 10000,
    nullable = false
  )
  protected String emailTemplate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "emailTo",
    nullable = false,
    length   = 255
  )
  protected String emailTo;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "eventName",
    nullable = false,
    length   = 255
  )
  protected String eventName;

  /** The portfolio which Event belong to. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioNotificationId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.FALSE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getEmailBCC() {
    return emailBCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getEmailCC() {
    return emailCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getEmailTemplate() {
    return emailTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getEmailTo() {
    return emailTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getEventName() {
    return eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Portfolio.
   *
   * @return  Portfolio.
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getPortfolioNotificationId() {
    return portfolioNotificationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setActive.
   *
   * @param  active  $param.type$
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmailBCC.
   *
   * @param  emailBCC  $param.type$
   */
  public void setEmailBCC(String emailBCC) {
    this.emailBCC = emailBCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmailCC.
   *
   * @param  emailCC  $param.type$
   */
  public void setEmailCC(String emailCC) {
    this.emailCC = emailCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmailTemplate.
   *
   * @param  emailTemplate  $param.type$
   */
  public void setEmailTemplate(String emailTemplate) {
    this.emailTemplate = emailTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmailTo.
   *
   * @param  emailTo  $param.type$
   */
  public void setEmailTo(String emailTo) {
    this.emailTo = emailTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEventName.
   *
   * @param  eventName  $param.type$
   */
  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPortfolio.
   *
   * @param  portfolio  $param.type$
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPortfolioNotificationId.
   *
   * @param  portfolioNotificationId  $param.type$
   */
  public void setPortfolioNotificationId(Long portfolioNotificationId) {
    this.portfolioNotificationId = portfolioNotificationId;
  }

} // end class PortfolioEventNotification
