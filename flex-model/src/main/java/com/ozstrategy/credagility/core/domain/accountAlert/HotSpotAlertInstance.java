package com.ozstrategy.credagility.core.domain.accountAlert;

import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.user.UserLoadedAccount;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * HotSpotAlert Instance.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:02
 */
@Entity
@Table(name = "HotSpotAlertInstance")
public class HotSpotAlertInstance extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** agent. */
  @JoinColumn(
    name       = "agentId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** contentType. */
  @Column(length = 50)
  protected String contentType;

  /** HotSpotAlert. */
  @JoinColumn(
    name       = "hotSpotAlertId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected HotSpotAlert hotSpotAlert;


  /** html Content. */
  @Column(
    name             = "htmlContent",
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String htmlContent;

  /** PK. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** pdf Content for pdf doc. */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Lob protected byte[] pdfContent;

  /** Responsible. */
  @JoinColumn(
    name       = "responsibleId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column protected long size;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "source",
    length   = 50,
    nullable = false
  )
  protected String source;

  /** current agent rLoadedAccount. */
  @JoinColumn(
    name       = "userLoadedAccountId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected UserLoadedAccount userLoadedAccount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for content type.
   *
   * @return  String
   */
  public String getContentType() {
    return contentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot alert.
   *
   * @return  HotSpotAlert
   */
  public HotSpotAlert getHotSpotAlert() {
    return hotSpotAlert;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for html content.
   *
   * @return  String
   */
  public String getHtmlContent() {
    return htmlContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pdf content.
   *
   * @return  byte[]
   */
  public byte[] getPdfContent() {
    return pdfContent;
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
   * getter method for size.
   *
   * @return  Long
   */
  public Long getSize() {
    return size;
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
   * getter method for user loaded account.
   *
   * @return  UserLoadedAccount
   */
  public UserLoadedAccount getUserLoadedAccount() {
    return userLoadedAccount;
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
   * setter method for content type.
   *
   * @param  contentType  String
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot alert.
   *
   * @param  hotSpotAlert  HotSpotAlert
   */
  public void setHotSpotAlert(HotSpotAlert hotSpotAlert) {
    this.hotSpotAlert = hotSpotAlert;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for html content.
   *
   * @param  htmlContent  String
   */
  public void setHtmlContent(String htmlContent) {
    this.htmlContent = htmlContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pdf content.
   *
   * @param  pdfContent  byte[]
   */
  public void setPdfContent(byte[] pdfContent) {
    this.pdfContent = pdfContent;
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
   * setter method for size.
   *
   * @param  size  long
   */
  public void setSize(long size) {
    this.size = size;
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
   * setter method for user loaded account.
   *
   * @param  userLoadedAccount  UserLoadedAccount
   */
  public void setUserLoadedAccount(UserLoadedAccount userLoadedAccount) {
    this.userLoadedAccount = userLoadedAccount;
  }
} // end class HotSpotAlertInstance
