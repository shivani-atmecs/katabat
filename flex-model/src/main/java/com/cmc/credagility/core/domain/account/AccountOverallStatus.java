package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.AccountStatusCode;
import com.cmc.credagility.core.domain.type.SourceType;
import com.cmc.credagility.core.domain.type.StatusSource;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Account status table maintains a set of account statuses for each account. It supports unlimited number of account
 * codes. Allowed status codes are constrained by the account status detail table.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 10:54
 */
@Entity public class AccountOverallStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -147747212004384647L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Which account this status belong to. */
  @JoinColumn(
    name     = "accountNum",
// unique   = true,
    nullable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "statusId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AccountOverallStatusDetail accountOverallStatusDetail;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "agentId",
    nullable = true
  )
  @ManyToOne protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "historical",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  /** Status id. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "nodeId",
    nullable = true
  )
  protected Long nodeId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "previousStatusCode",
    length   = 255,
    nullable = true
  )
  protected String previousStatusCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "sourceType",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected SourceType sourceType;

  /**
   * Please note that this is different than createDate. createDate is when the DB record is created and this date means
   * when the status is assigned. It is a business concept.
   */
  @Column(name = "statusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date statusDate;

  /** where we get this status. */
  @Column(
    name   = "statusSource",
    length = 20
  )
  @Enumerated(EnumType.STRING)
  protected StatusSource statusSource;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "workflowStepId",
    nullable = true
  )
  protected Long workflowStepId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public AccountOverallStatus() { }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  code  DOCUMENT ME!
   */
  public AccountOverallStatus(AccountStatusCode code) {
    super();
    setAccountOverallStatusDetail(code);
  }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  account  DOCUMENT ME!
   * @param  code     DOCUMENT ME!
   */
  public AccountOverallStatus(Account account, AccountStatusCode code) {
    super();
    setAccountOverallStatusDetail(code);
    this.account = account;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    AccountOverallStatus other = (AccountOverallStatus) obj;

    if (accountOverallStatusDetail == null) {
      if (other.accountOverallStatusDetail != null) {
        return false;
      }
    } else if (accountOverallStatusDetail.getStatusId() == null) {
      if (other.accountOverallStatusDetail.getStatusId() != null) {
        return false;
      }
    } else {
      if (other.accountOverallStatusDetail.getStatusId() == null) {
        return false;
      }

      if (!accountOverallStatusDetail.getStatusId().equals(
              other.accountOverallStatusDetail.getStatusId())) {
        return false;
      }
    }


    if (statusDate == null) {
      if (other.statusDate != null) {
        return false;
      }
    } else if (!statusDate.equals(other.statusDate)) {
      return false;
    }

    if (statusSource == null) {
      if (other.statusSource != null) {
        return false;
      }
    } else if (!statusSource.equals(other.statusSource)) {
      return false;
    }

    if (previousStatusCode == null) {
      if (other.previousStatusCode != null) {
        return false;
      }
    } else if (!previousStatusCode.equals(other.previousStatusCode)) {
      return false;
    }

    if (historical == null) {
      if (other.historical != null) {
        return false;
      }
    } else if (!historical.equals(other.historical)) {
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
   * getter method for account overall status code.
   *
   * @return  AccountStatusCode
   */
  public AccountStatusCode getAccountOverallStatusCode() {
    if (accountOverallStatusDetail == null) {
      return null;
    }

    return accountOverallStatusDetail.getAccountStatusCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account overall status detail.
   *
   * @return  AccountOverallStatusDetail
   */
  public AccountOverallStatusDetail getAccountOverallStatusDetail() {
    return accountOverallStatusDetail;
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
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (historical == null) {
      return Boolean.FALSE;
    }

    return historical;
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
   * getter method for node id.
   *
   * @return  Long
   */
  public Long getNodeId() {
    return nodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for null safe status date.
   *
   * @return  Date
   */
  public Date getNullSafeStatusDate() {
    if (statusDate != null) {
      return statusDate;
    }

    // createDate is required.
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for overall status code.
   *
   * @return  String
   */
  public String getOverallStatusCode() {
    if (accountOverallStatusDetail == null) {
      return null;
    }

    return accountOverallStatusDetail.getStatusCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for overall status id.
   *
   * @return  Long
   */
  public Long getOverallStatusId() {
    if (accountOverallStatusDetail == null) {
      return null;
    }

    return accountOverallStatusDetail.getStatusId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous status code.
   *
   * @return  String
   */
  public String getPreviousStatusCode() {
    return previousStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source type.
   *
   * @return  SourceType
   */
  public SourceType getSourceType() {
    return sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This is the date the status is assigned. It is a business concept.
   *
   * @return  this is the date the status is assigned.
   *
   *          <p>not-null = "false"</p>
   */
  public Date getStatusDate() {
    return statusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status source.
   *
   * @return  StatusSource
   */
  public StatusSource getStatusSource() {
    return statusSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step id.
   *
   * @return  Long
   */
  public Long getWorkflowStepId() {
    return workflowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime
        * result)
      + ((accountOverallStatusDetail == null) ? 0 : accountOverallStatusDetail.getStatusId().hashCode());

    result = (prime * result)
      + ((statusDate == null) ? 0 : statusDate.hashCode());
    result = (prime * result)
      + ((statusSource == null) ? 0 : statusSource.hashCode());

    result = (prime * result) + ((previousStatusCode == null) ? 0 : previousStatusCode.hashCode());
    result = (prime * result) + ((historical == null) ? 0 : historical.hashCode());

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
   * setter method for account overall status detail.
   *
   * @param  code  AccountStatusCode
   */
  public void setAccountOverallStatusDetail(AccountStatusCode code) {
    if (code != null) {
      AccountOverallStatusDetail detail = new AccountOverallStatusDetail();
      detail.setStatusCode(code.toString());
      detail.setStatusId(code.getStatusId());
      this.accountOverallStatusDetail = detail;
    } else {
      this.accountOverallStatusDetail = null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account overall status detail.
   *
   * @param  accountOverallStatusDetail  AccountOverallStatusDetail
   */
  public void setAccountOverallStatusDetail(AccountOverallStatusDetail accountOverallStatusDetail) {
    this.accountOverallStatusDetail = accountOverallStatusDetail;
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
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for node id.
   *
   * @param  nodeId  Long
   */
  public void setNodeId(Long nodeId) {
    this.nodeId = nodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous status code.
   *
   * @param  previousStatusCode  String
   */
  public void setPreviousStatusCode(String previousStatusCode) {
    this.previousStatusCode = previousStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source type.
   *
   * @param  sourceType  SourceType
   */
  public void setSourceType(SourceType sourceType) {
    this.sourceType = sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status date.
   *
   * @param  statusDate  Date
   */
  public void setStatusDate(Date statusDate) {
    this.statusDate = statusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status source.
   *
   * @param  statusSource  StatusSource
   */
  public void setStatusSource(StatusSource statusSource) {
    this.statusSource = statusSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step id.
   *
   * @param  workflowStepId  Long
   */
  public void setWorkflowStepId(Long workflowStepId) {
    this.workflowStepId = workflowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AccountOverallStatus ( " + TAB + "id = "
      + this.id + TAB + "accountOverallStatusDetail = "
      + this.accountOverallStatusDetail + TAB + "accountNum = "
      + this.account.getAccountNum() + TAB + " )";

    return retValue;
  }
} // end class AccountOverallStatus
