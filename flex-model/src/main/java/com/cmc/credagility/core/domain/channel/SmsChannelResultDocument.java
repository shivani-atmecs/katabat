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
 * @version  10/14/2014 17:43
 */
@Entity
@Table(name = "SmsChannelResultDocument")
public class SmsChannelResultDocument extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6587199093501428943L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;


  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    length   = 50,
    nullable = true
  )
  private String messageFrom;


  @Column(
    length   = 50,
    nullable = true
  )
  private String messageTo;

  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;

  @JoinColumn(
    name     = "smsChannelResultId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  private SmsChannelResult smsChannelResult;

  @Column(columnDefinition = "LONGTEXT")
  @Convert(converter = StringEncryptionConverter.class)
  private String textContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof SmsChannelResultDocument)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    SmsChannelResultDocument that = (SmsChannelResultDocument) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }


    if ((smsChannelResult != null) ? (!smsChannelResult.equals(that.smsChannelResult))
                                   : (that.smsChannelResult != null)) {
      return false;
    }


    if ((messageFrom != null) ? (!messageFrom.equals(that.messageFrom)) : (that.messageFrom != null)) {
      return false;
    }


    if ((messageTo != null) ? (!messageTo.equals(that.messageTo)) : (that.messageTo != null)) {
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message from.
   *
   * @return  String
   */
  public String getMessageFrom() {
    return messageFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message to.
   *
   * @return  String
   */
  public String getMessageTo() {
    return messageTo;
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
   * getter method for sms channel result.
   *
   * @return  SmsChannelResult
   */
  public SmsChannelResult getSmsChannelResult() {
    return smsChannelResult;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((textContent != null) ? textContent.hashCode() : 0);
    result = (31 * result) + ((messageFrom != null) ? messageFrom.hashCode() : 0);
    result = (31 * result) + ((messageTo != null) ? messageTo.hashCode() : 0);

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
   * setter method for message from.
   *
   * @param  messageFrom  String
   */
  public void setMessageFrom(String messageFrom) {
    this.messageFrom = messageFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message to.
   *
   * @param  messageTo  String
   */
  public void setMessageTo(String messageTo) {
    this.messageTo = messageTo;
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
   * setter method for sms channel result.
   *
   * @param  smsChannelResult  SmsChannelResult
   */
  public void setSmsChannelResult(SmsChannelResult smsChannelResult) {
    this.smsChannelResult = smsChannelResult;
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
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "SmsChannelResultContent{"
      + "id=" + id
      + ", textContent='" + textContent + '\''
      + ", messageFrom='" + messageFrom + '\''
      + ", messageTo='" + messageTo + '\''
      + ", template=" + smsChannelResult
      + '}';
  }
} // end class SmsChannelResultDocument
