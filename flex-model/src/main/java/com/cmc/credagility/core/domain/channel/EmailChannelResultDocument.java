package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:41
 */
@Entity
@Table(name = "EmailChannelResultDocument")
public class EmailChannelResultDocument extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7380233068232627575L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;

  @JoinColumn(
    name     = "emailChannelResultId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  private EmailChannelResult emailChannelResult;
  @Column(
    length           = 65535,
    columnDefinition = "LONGTEXT"
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String             htmlContent;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    length   = 255,
    nullable = true
  )
  private String mailFrom;

  @Column(
    length   = 255,
    nullable = true
  )
  private String mailSubject;

  @Column(
    length   = 500,
    nullable = true
  )
  private String mailTo;

  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;

  @Column(
    length           = 65535,
    columnDefinition = "LONGTEXT"
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String textContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EmailChannelResultDocument)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EmailChannelResultDocument that = (EmailChannelResultDocument) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }


    if ((emailChannelResult != null) ? (!emailChannelResult.equals(that.emailChannelResult))
                                     : (that.emailChannelResult != null)) {
      return false;
    }

    if ((htmlContent != null) ? (!htmlContent.equals(that.htmlContent)) : (that.htmlContent != null)) {
      return false;
    }

    if ((mailFrom != null) ? (!mailFrom.equals(that.mailFrom)) : (that.mailFrom != null)) {
      return false;
    }

    if ((mailSubject != null) ? (!mailSubject.equals(that.mailSubject)) : (that.mailSubject != null)) {
      return false;
    }

    if ((mailTo != null) ? (!mailTo.equals(that.mailTo)) : (that.mailTo != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((textContent != null) ? (!textContent.equals(that.textContent)) : (that.textContent != null)) {
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
   * getter method for email channel result.
   *
   * @return  EmailChannelResult
   */
  public EmailChannelResult getEmailChannelResult() {
    return emailChannelResult;
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
   * getter method for mail from.
   *
   * @return  String
   */
  public String getMailFrom() {
    return mailFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail subject.
   *
   * @return  String
   */
  public String getMailSubject() {
    return mailSubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail to.
   *
   * @return  String
   */
  public String getMailTo() {
    return mailTo;
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
   * getter method for text content.
   *
   * @return  String
   */
  public String getTextContent() {
    return textContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((htmlContent != null) ? htmlContent.hashCode() : 0);
    result = (31 * result) + ((textContent != null) ? textContent.hashCode() : 0);
    result = (31 * result) + ((mailFrom != null) ? mailFrom.hashCode() : 0);
    result = (31 * result) + ((mailSubject != null) ? mailSubject.hashCode() : 0);
    result = (31 * result) + ((mailTo != null) ? mailTo.hashCode() : 0);

    return result;
  }

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
   * setter method for email channel result.
   *
   * @param  emailChannelResult  EmailChannelResult
   */
  public void setEmailChannelResult(EmailChannelResult emailChannelResult) {
    this.emailChannelResult = emailChannelResult;
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
   * setter method for mail from.
   *
   * @param  mailFrom  String
   */
  public void setMailFrom(String mailFrom) {
    this.mailFrom = mailFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail subject.
   *
   * @param  mailSubject  String
   */
  public void setMailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail to.
   *
   * @param  mailTo  String
   */
  public void setMailTo(String mailTo) {
    this.mailTo = mailTo;
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
   * setter method for text content.
   *
   * @param  textContent  String
   */
  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "EmailChannelResultContent{"
      + "id=" + id
      + ", htmlContent='" + htmlContent + '\''
      + ", textContent='" + textContent + '\''
      + ", mailFrom='" + mailFrom + '\''
      + ", mailSubject='" + mailSubject + '\''
      + ", mailTo='" + mailTo + '\''
      + ", template=" + emailChannelResult
      + '}';
  }
} // end class EmailChannelResultDocument
