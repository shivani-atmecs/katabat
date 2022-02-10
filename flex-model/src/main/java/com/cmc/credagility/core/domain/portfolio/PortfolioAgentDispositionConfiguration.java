package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.AddAccountStatus;
import com.cmc.credagility.core.domain.account.RemoveAccountStatus;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionChannel;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionDestination;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionSpokeTo;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.StatusType;


/**
 * Created by IntelliJ IDEA. User: adevan Date: Mar 19, 2010 Time: 2:01:48 PM To change this template use File |
 * Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioAgentDispositionConfiguration",
  uniqueConstraints = {
    @UniqueConstraint(
      columnNames   = {
        "coreAgentDispositionChannelId",
        "coreAgentDispositionDestinationId",
        "coreAgentDispositionSpokeToId",
        "portfolioAgentDispositionCodeId",
        "status"
      }
    )
  },
  indexes           = {
    @Index(
      name          = "FKB5_coreAgentDispositionChannelId",
      columnList    = "coreAgentDispositionChannelId"
    )
  }
)
public class PortfolioAgentDispositionConfiguration extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3443146700879735237L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account update activity name. */
  @Column(
    name     = "accountUpdateActivityName",
    length   = 80,
    nullable = true
  )
  protected String accountUpdateActivityName;

  /** Account update expression. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String accountUpdateExpression;

  /** Account update field expression. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String accountUpdateFieldExpression;


  /** Action code. */
  @Column(
    name     = "actionCode",
    length   = 2,
    nullable = true
  )
  protected String actionCode;


  /** AddAccountStatus. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolioAgentDispositionConfiguration",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<AddAccountStatus> addAccountStatuses;

  /** <code>true</code> allow channel CID, default is <code>false.</code> */
  @Column(
    name             = "channelCID",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean channelCID = Boolean.FALSE;

  /** CoreAgentDispositionChannel PK coreAgentDispositionChannelId. */
  @JoinColumn(
    name      = "coreAgentDispositionChannelId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionChannel coreAgentDispositionChannel = null;

  /** CoreAgentDispositionDestination PK coreAgentDispositionDestinationId. */
  @JoinColumn(
    name      = "coreAgentDispositionDestinationId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionDestination coreAgentDispositionDestination = null;

  /** CoreAgentDispositionSpokeTo PK coreAgentDispositionSpokeToId. */
  @JoinColumn(
    name      = "coreAgentDispositionSpokeToId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo = null;

  /** Default next work date. */
  @Column(name = "defaultNextWorkDate")
  protected Long defaultNextWorkDate;


  /** GUI survey code. */
  @Column(
    name     = "guiSurveyCode",
    length   = 20,
    nullable = true
  )
  protected String guiSurveyCode;

  /** GUI window code. */
  @Column(
    name     = "guiWindowCode",
    length   = 20,
    nullable = true
  )
  protected String guiWindowCode;

  /** Maximum next work date. */
  @Column(name = "maxNextWorkDate")
  protected Long maxNextWorkDate;

  /** Minimum next work date. */
  @Column(name = "minNextWorkDate")
  protected Long minNextWorkDate;

  /** Overall status expression. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String overallStatusExpression;

  /** PortfolioAgentDispositionCode. */
  @JoinColumn(
    name      = "portfolioAgentDispositionCodeId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioAgentDispositionCode portfolioAgentDispositionCode = null;

  /** PortfolioAgentDispositionConfiguration identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioAgentDispositionConfigurationId;

  /** RemoveAccountStatus. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolioAgentDispositionConfiguration",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<RemoveAccountStatus> removeAccountStatuses;

  /** Result code. */
  @Column(
    name     = "resultCode",
    length   = 2,
    nullable = true
  )
  protected String resultCode;

  /** Specify next work date. */
  @Column(name = "specifyNextWorkTime")
  protected String specifyNextWorkTime;

  /**
   * Status type.
   *
   * @see  com.ozstrategy.credagility.core.domain.StatusType
   */
  @Column(
    name     = "status",
    nullable = true,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected StatusType status;

  /** Primary key. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String tsysStatusReasonCodeExpression;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountUpdateActivityName() {
    return accountUpdateActivityName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountUpdateExpression() {
    return accountUpdateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountUpdateFieldExpression() {
    return accountUpdateFieldExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getActionCode() {
    return actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AddAccountStatus> getAddAccountStatuses() {
    return addAccountStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionChannel getCoreAgentDispositionChannel() {
    return coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionDestination getCoreAgentDispositionDestination() {
    return coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionSpokeTo getCoreAgentDispositionSpokeTo() {
    return coreAgentDispositionSpokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getDefaultNextWorkDate() {
    return defaultNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGuiSurveyCode() {
    return guiSurveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGuiWindowCode() {
    return guiWindowCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMaxNextWorkDate() {
    return maxNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMinNextWorkDate() {
    return minNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOverallStatusExpression() {
    return overallStatusExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioAgentDispositionCode getPortfolioAgentDispositionCode() {
    return portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioAgentDispositionConfigurationId() {
    return portfolioAgentDispositionConfigurationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<RemoveAccountStatus> getRemoveAccountStatuses() {
    return removeAccountStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getResultCode() {
    return resultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSpecifyNextWorkTime() {
    return specifyNextWorkTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public StatusType getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTsysStatusReasonCodeExpression() {
    return tsysStatusReasonCodeExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isChannelCID() {
    if (channelCID == null) {
      return Boolean.FALSE;
    }

    return channelCID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountUpdateActivityName  DOCUMENT ME!
   */
  public void setAccountUpdateActivityName(String accountUpdateActivityName) {
    this.accountUpdateActivityName = accountUpdateActivityName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountUpdateExpression  DOCUMENT ME!
   */
  public void setAccountUpdateExpression(String accountUpdateExpression) {
    this.accountUpdateExpression = accountUpdateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountUpdateFieldExpression  DOCUMENT ME!
   */
  public void setAccountUpdateFieldExpression(String accountUpdateFieldExpression) {
    this.accountUpdateFieldExpression = accountUpdateFieldExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionCode  DOCUMENT ME!
   */
  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  addAccountStatuses  DOCUMENT ME!
   */
  public void setAddAccountStatuses(Set<AddAccountStatus> addAccountStatuses) {
    this.addAccountStatuses = addAccountStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelCID  DOCUMENT ME!
   */
  public void setChannelCID(Boolean channelCID) {
    this.channelCID = channelCID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreAgentDispositionChannel  DOCUMENT ME!
   */
  public void setCoreAgentDispositionChannel(CoreAgentDispositionChannel coreAgentDispositionChannel) {
    this.coreAgentDispositionChannel = coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreAgentDispositionDestination  DOCUMENT ME!
   */
  public void setCoreAgentDispositionDestination(CoreAgentDispositionDestination coreAgentDispositionDestination) {
    this.coreAgentDispositionDestination = coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreAgentDispositionSpokeTo  DOCUMENT ME!
   */
  public void setCoreAgentDispositionSpokeTo(CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo) {
    this.coreAgentDispositionSpokeTo = coreAgentDispositionSpokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultNextWorkDate  DOCUMENT ME!
   */
  public void setDefaultNextWorkDate(Long defaultNextWorkDate) {
    this.defaultNextWorkDate = defaultNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  guiSurveyCode  DOCUMENT ME!
   */
  public void setGuiSurveyCode(String guiSurveyCode) {
    this.guiSurveyCode = guiSurveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  guiWindowCode  DOCUMENT ME!
   */
  public void setGuiWindowCode(String guiWindowCode) {
    this.guiWindowCode = guiWindowCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxNextWorkDate  DOCUMENT ME!
   */
  public void setMaxNextWorkDate(Long maxNextWorkDate) {
    this.maxNextWorkDate = maxNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minNextWorkDate  DOCUMENT ME!
   */
  public void setMinNextWorkDate(Long minNextWorkDate) {
    this.minNextWorkDate = minNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  overallStatusExpression  DOCUMENT ME!
   */
  public void setOverallStatusExpression(String overallStatusExpression) {
    this.overallStatusExpression = overallStatusExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAgentDispositionCode  DOCUMENT ME!
   */
  public void setPortfolioAgentDispositionCode(PortfolioAgentDispositionCode portfolioAgentDispositionCode) {
    this.portfolioAgentDispositionCode = portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAgentDispositionConfigurationId  DOCUMENT ME!
   */
  public void setPortfolioAgentDispositionConfigurationId(Long portfolioAgentDispositionConfigurationId) {
    this.portfolioAgentDispositionConfigurationId = portfolioAgentDispositionConfigurationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  removeAccountStatuses  DOCUMENT ME!
   */
  public void setRemoveAccountStatuses(Set<RemoveAccountStatus> removeAccountStatuses) {
    this.removeAccountStatuses = removeAccountStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  resultCode  DOCUMENT ME!
   */
  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  specifyNextWorkTime  DOCUMENT ME!
   */
  public void setSpecifyNextWorkTime(String specifyNextWorkTime) {
    this.specifyNextWorkTime = specifyNextWorkTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(StatusType status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tsysStatusReasonCodeExpression  DOCUMENT ME!
   */
  public void setTsysStatusReasonCodeExpression(String tsysStatusReasonCodeExpression) {
    this.tsysStatusReasonCodeExpression = tsysStatusReasonCodeExpression;
  }
} // end class PortfolioAgentDispositionConfiguration
