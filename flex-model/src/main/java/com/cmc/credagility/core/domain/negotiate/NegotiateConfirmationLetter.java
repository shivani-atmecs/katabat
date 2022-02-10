package com.cmc.credagility.core.domain.negotiate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.LetterServiceVendor;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;
import com.cmc.credagility.core.domain.user.User;


/**
 * This class is used to store negotiate confirm letter information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 17:28
 */
@Entity
@Table(name = "NegotiateConfirmationLetter")
public class NegotiateConfirmationLetter extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1432363281395351321L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Account account;

  /** Request agent. */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

// npelleti, 07/30, USBank, Removed unique constraint
  /** Result Id, PK. */
  @Column(
    name     = "confirmLetterId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long confirmLetterId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "executeDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date executeDate;

  /** TODO: DOCUMENT ME! */
  @Transient protected String executeResult;


  /** TODO: DOCUMENT ME! */
  @Column(name = "exportDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date exportDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "programId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram program;

  /** Responsible. */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Responsible responsible;

  // npelleti, 08/02, USBank, Added NotNull Annotation
  /** channel result status INIT/ EXPORTED/ EXECUTED. */
  @Column(
    name     = "status",
    nullable = false,
    length   = 10
  )
  @Enumerated(value = EnumType.STRING)
  protected ChannelResultStatus status;

  // npelleti 08/17 USB renamed column to vendorId
  /** DOCUMENT ME! */
  @JoinColumn(name = "vendorId")
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected LetterServiceVendor vendor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
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

    NegotiateConfirmationLetter other = (NegotiateConfirmationLetter) obj;

    if (this.program == null) {
      if (other.program != null) {
        return false;
      }
    } else if (!this.program.equals(other.program)) {
      return false;
    }

    if (this.responsible == null) {
      if (other.responsible != null) {
        return false;
      }
    } else if (!this.responsible.equals(other.responsible)) {
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
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return this.agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for confirm letter id.
   *
   * @return  Long
   */
  public Long getConfirmLetterId() {
    return this.confirmLetterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execute date.
   *
   * @return  Date
   */
  public Date getExecuteDate() {
    return executeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execute result.
   *
   * @return  String
   */
  public String getExecuteResult() {
    return this.executeResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export date.
   *
   * @return  Date
   */
  public Date getExportDate() {
    return exportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getProgram() {
    return this.program;
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
   * getter method for status.
   *
   * @return  ChannelResultStatus
   */
  public ChannelResultStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor.
   *
   * @return  LetterServiceVendor
   */
  public LetterServiceVendor getVendor() {
    return vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.program == null) ? 0 : this.program.hashCode());
    result = (prime * result)
      + ((this.responsible == null) ? 0 : this.responsible.hashCode());

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
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for confirm letter id.
   *
   * @param  confirmLetterId  Long
   */
  public void setConfirmLetterId(Long confirmLetterId) {
    this.confirmLetterId = confirmLetterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execute date.
   *
   * @param  executeDate  Date
   */
  public void setExecuteDate(Date executeDate) {
    this.executeDate = executeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execute result.
   *
   * @param  executeResult  String
   */
  public void setExecuteResult(String executeResult) {
    this.executeResult = executeResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export date.
   *
   * @param  exportDate  Date
   */
  public void setExportDate(Date exportDate) {
    this.exportDate = exportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program.
   *
   * @param  program  PaymentProgram
   */
  public void setProgram(PaymentProgram program) {
    this.program = program;
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
   * setter method for status.
   *
   * @param  status  ChannelResultStatus
   */
  public void setStatus(ChannelResultStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  LetterServiceVendor
   */
  public void setVendor(LetterServiceVendor vendor) {
    this.vendor = vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("NegotiateConfirmationLetter ( ").append(super.toString()).append(TAB).append("account = ").append(
      this.account).append(TAB).append("agent = ").append(this.agent).append(TAB).append(
      "confirmLetterId = ").append(this.confirmLetterId).append(TAB).append("executeDate = ").append(this.executeDate)
      .append(TAB).append(
      "executeResult = ").append(this.executeResult).append(TAB).append(
      "exportDate = ").append(this.exportDate).append(TAB).append(
      "program = ").append(this.program).append(TAB).append(
      "responsible = ").append(this.responsible).append(TAB).append(
      "status = ").append(this.status).append(TAB).append("vendor = ").append(this.vendor).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class NegotiateConfirmationLetter
