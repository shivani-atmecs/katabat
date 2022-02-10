package com.cmc.credagility.core.domain.channel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * the abstract class for base channel actual result.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 15:20
 */
@MappedSuperclass public abstract class BaseChannelActualResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** Refer table 'PortfolioDocument'. */
  @Column protected Long documentId;


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

  /** Responsible. */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(name = "ruleBatchId")
  protected Long ruleBatchId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 30
  )
  protected String status;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "strategyDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date strategyDate;

  /** Using template. */
  @Column(
    name     = "template",
    length   = 255,
    nullable = true
  )
  protected String template;


  /** TODO: DOCUMENT ME! */
  @Column protected Long templateId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "uniqueSessionId",
    length = 50
  )
  protected String uniqueSessionId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    BaseChannelActualResult other = (BaseChannelActualResult) obj;

    if (strategyDate == null) {
      if (other.strategyDate != null) {
        return false;
      }
    } else if (strategyDate.getTime() != (other.strategyDate.getTime())) {
      return false;
    }

    if (template == null) {
      if (other.template != null) {
        return false;
      }
    } else if (!template.equals(other.template)) {
      return false;
    }

    if (uniqueSessionId == null) {
      if (other.uniqueSessionId != null) {
        return false;
      }
    } else if (!uniqueSessionId.equals(other.uniqueSessionId)) {
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
   * getter method for document id.
   *
   * @return  Long
   */
  public Long getDocumentId() {
    return documentId;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule batch id.
   *
   * @return  Long
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy date.
   *
   * @return  Date
   */
  public Date getStrategyDate() {
    return strategyDate;
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
   * getter method for unique session id.
   *
   * @return  String
   */
  public String getUniqueSessionId() {
    return uniqueSessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((strategyDate == null) ? 0 : strategyDate.hashCode());
    result = (prime * result)
      + ((template == null) ? 0 : template.hashCode());
    result = (prime * result)
      + ((uniqueSessionId == null) ? 0 : uniqueSessionId.hashCode());

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
   * setter method for document id.
   *
   * @param  documentId  Long
   */
  public void setDocumentId(Long documentId) {
    this.documentId = documentId;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule batch id.
   *
   * @param  ruleBatchId  Long
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy date.
   *
   * @param  strategyDate  Date
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique session id.
   *
   * @param  uniqueSessionId  String
   */
  public void setUniqueSessionId(String uniqueSessionId) {
    this.uniqueSessionId = uniqueSessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseChannelResult ( ").append(super.toString()).append(
      TAB).append("account = ").append(this.account).append(TAB).append(
      TAB).append(TAB).append("responsible = ").append(this.responsible).append(TAB).append("status = ").append(
      this.status).append(TAB).append("strategyDate = ").append(this.strategyDate).append(TAB).append("template = ")
      .append(this.template).append(TAB).append(
      " )");

    return retValue.toString();
  }
} // end class BaseChannelActualResult
