package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.account.AccountOverallStatusDetail;
import com.cmc.credagility.core.domain.account.AccountStatusDetail;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.contact.ContactResult;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionCategory;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.StatusType;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by IntelliJ IDEA. User: adevan Date: Mar 19, 2010 Time: 1:21:30 PM To change this template use File |
 * Settings | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "PortfolioAgentDispositionCode",
  indexes = {
    @Index(
      name = "idx_dispositionCode",
      columnList = "dispositionCode"
    )
  }
)
public class PortfolioAgentDispositionCode extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5643335338233995557L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** link to account overall status detail. */
  @JoinColumn(
    name     = "overallId",
    unique   = false,
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountOverallStatusDetail accountOverallStatusDetail;

  /** link to account status detail. */
  @JoinColumn(
    name   = "statusId",
    unique = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountStatusDetail accountStatusDetail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "aCode1",
    length = 2
  )
  protected String aCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "aCode2",
    length = 2
  )
  protected String aCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "aCode3",
    length = 2
  )
  protected String aCode3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "aCode4",
    length = 2
  )
  protected String aCode4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "aCode5",
    length = 2
  )
  protected String aCode5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "aCode6",
    length = 2
  )
  protected String aCode6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "calendarRange",
    length = 3
  )
  protected String calendarRange;

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------
  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDispositionCode",
    length = 10
  )
  protected String clientDispositionCode;

  /** TODO: DOCUMENT ME! */
  @ManyToMany(mappedBy = "dispositionCodes")
  protected Set<ContactResult> contactResults = new HashSet<ContactResult>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "coreAgentDispositionCategoryId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionCategory coreDispositionCategory;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 100
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "dialerReleaseCode",
    nullable = true,
    length   = 10
  )
  protected String dialerReleaseCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dispositionCode",
    length = 10
  )
  protected String dispositionCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "impactNextWorkDate",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean impactNextWorkDate;

  /** portfolio. */
  @JoinColumn(
    name     = "portfolioId",

    /*updatable = false,*/
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** PortfolioAgentDispositionCode identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioAgentDispositionCodeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rCode1",
    length = 2
  )
  protected String rCode1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rCode2",
    length = 2
  )
  protected String rCode2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rCode3",
    length = 2
  )
  protected String rCode3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rCode4",
    length = 2
  )
  protected String rCode4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rCode5",
    length = 2
  )
  protected String rCode5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "rCode6",
    length = 2
  )
  protected String rCode6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = true,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected StatusType status;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "system",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean system;

  @Column(
          name             = "sendDialerKill",
          columnDefinition = "char",
          length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean sendDialerKill;

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

    final PortfolioAgentDispositionCode other = (PortfolioAgentDispositionCode) obj;

    if (this.createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!this.createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (this.portfolioAgentDispositionCodeId == null) {
      if (other.getPortfolioAgentDispositionCodeId() != null) {
        return false;
      }
    } else if (!this.portfolioAgentDispositionCodeId.equals(other.getPortfolioAgentDispositionCodeId())) {
      return false;
    }


    if (this.coreDispositionCategory == null) {
      if (other.getCoreDispositionCategory() != null) {
        return false;
      }
    } else if (!this.coreDispositionCategory.equals(other.getCoreDispositionCategory())) {
      return false;
    }

    if (this.portfolio == null) {
      if (other.getPortfolio() != null) {
        return false;
      }
    } else if (!this.portfolio.equals(other.getPortfolio())) {
      return false;
    }

    if (this.accountOverallStatusDetail == null) {
      if (other.getAccountOverallStatusDetail() != null) {
        return false;
      }
    } else if (!this.accountOverallStatusDetail.equals(other.getAccountOverallStatusDetail())) {
      return false;
    }

    if (this.accountStatusDetail == null) {
      if (other.getAccountStatusDetail() != null) {
        return false;
      }
    } else if (!this.accountStatusDetail.equals(other.getAccountStatusDetail())) {
      return false;
    }

    if (this.status == null) {
      if (other.getStatus() != null) {
        return false;
      }
    } else if (!this.status.equals(other.getStatus())) {
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
  public AccountOverallStatusDetail getAccountOverallStatusDetail() {
    return accountOverallStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AccountStatusDetail getAccountStatusDetail() {
    return accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getaCode1() {
    return aCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getaCode2() {
    return aCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getaCode3() {
    return aCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getaCode4() {
    return aCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getaCode5() {
    return aCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getaCode6() {
    return aCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCalendarRange() {
    return calendarRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client disposition code.
   *
   * @return  String
   */
  public String getClientDispositionCode() {
    return clientDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<ContactResult> getContactResults() {
    return contactResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionCategory getCoreDispositionCategory() {
    return coreDispositionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer release code.
   *
   * @return  String
   */
  public String getDialerReleaseCode() {
    return dialerReleaseCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDispositionCode() {
    return dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for impact next work date.
   *
   * @return  Boolean
   */
  public Boolean getImpactNextWorkDate() {
    return (impactNextWorkDate == null) ? true : impactNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioAgentDispositionCodeId() {
    return portfolioAgentDispositionCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getrCode1() {
    return rCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getrCode2() {
    return rCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getrCode3() {
    return rCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getrCode4() {
    return rCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getrCode5() {
    return rCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getrCode6() {
    return rCode6;
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
  public Boolean getSystem() {
    return system;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.portfolioAgentDispositionCodeId == null) ? 0 : this.portfolioAgentDispositionCodeId.hashCode());
    result = (PRIME * result)
      + ((this.dispositionCode == null) ? 0 : this.dispositionCode.hashCode());
    result = (PRIME * result)
      + ((this.description == null) ? 0 : this.description.hashCode());
    result = (PRIME * result)
      + ((this.coreDispositionCategory == null) ? 0 : this.coreDispositionCategory.hashCode());
    result = (PRIME * result)
      + ((this.portfolio == null) ? 0 : this.portfolio.hashCode());
    result = (PRIME * result)
      + ((this.accountOverallStatusDetail == null) ? 0 : this.accountOverallStatusDetail.hashCode());
    result = (PRIME * result)
      + ((this.accountStatusDetail == null) ? 0 : this.accountStatusDetail.hashCode());
    result = (PRIME * result)
      + ((this.status == null) ? 0 : this.status.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountOverallStatusDetail  DOCUMENT ME!
   */
  public void setAccountOverallStatusDetail(AccountOverallStatusDetail accountOverallStatusDetail) {
    this.accountOverallStatusDetail = accountOverallStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountStatusDetail  DOCUMENT ME!
   */
  public void setAccountStatusDetail(AccountStatusDetail accountStatusDetail) {
    this.accountStatusDetail = accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aCode1  DOCUMENT ME!
   */
  public void setaCode1(String aCode1) {
    this.aCode1 = aCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aCode2  DOCUMENT ME!
   */
  public void setaCode2(String aCode2) {
    this.aCode2 = aCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aCode3  DOCUMENT ME!
   */
  public void setaCode3(String aCode3) {
    this.aCode3 = aCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aCode4  DOCUMENT ME!
   */
  public void setaCode4(String aCode4) {
    this.aCode4 = aCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aCode5  DOCUMENT ME!
   */
  public void setaCode5(String aCode5) {
    this.aCode5 = aCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aCode6  DOCUMENT ME!
   */
  public void setaCode6(String aCode6) {
    this.aCode6 = aCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  calendarRange  DOCUMENT ME!
   */
  public void setCalendarRange(String calendarRange) {
    this.calendarRange = calendarRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client disposition code.
   *
   * @param  clientDispositionCode  String
   */
  public void setClientDispositionCode(String clientDispositionCode) {
    this.clientDispositionCode = clientDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactResults  DOCUMENT ME!
   */
  public void setContactResults(Set<ContactResult> contactResults) {
    this.contactResults = contactResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreDispositionCategory  DOCUMENT ME!
   */
  public void setCoreDispositionCategory(CoreAgentDispositionCategory coreDispositionCategory) {
    this.coreDispositionCategory = coreDispositionCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer release code.
   *
   * @param  dialerReleaseCode  String
   */
  public void setDialerReleaseCode(String dialerReleaseCode) {
    this.dialerReleaseCode = dialerReleaseCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dispositionCode  DOCUMENT ME!
   */
  public void setDispositionCode(String dispositionCode) {
    this.dispositionCode = dispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for impact next work date.
   *
   * @param  impactNextWorkDate  Boolean
   */
  public void setImpactNextWorkDate(Boolean impactNextWorkDate) {
    this.impactNextWorkDate = impactNextWorkDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


    public Boolean getSendDialerKill() {
        return sendDialerKill;
    }

    public void setSendDialerKill(Boolean sendDialerKill) {
        this.sendDialerKill = sendDialerKill;
    }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAgentDispositionCodeId  DOCUMENT ME!
   */
  public void setPortfolioAgentDispositionCodeId(Long portfolioAgentDispositionCodeId) {
    this.portfolioAgentDispositionCodeId = portfolioAgentDispositionCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rCode1  DOCUMENT ME!
   */
  public void setrCode1(String rCode1) {
    this.rCode1 = rCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rCode2  DOCUMENT ME!
   */
  public void setrCode2(String rCode2) {
    this.rCode2 = rCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rCode3  DOCUMENT ME!
   */
  public void setrCode3(String rCode3) {
    this.rCode3 = rCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rCode4  DOCUMENT ME!
   */
  public void setrCode4(String rCode4) {
    this.rCode4 = rCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rCode5  DOCUMENT ME!
   */
  public void setrCode5(String rCode5) {
    this.rCode5 = rCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rCode6  DOCUMENT ME!
   */
  public void setrCode6(String rCode6) {
    this.rCode6 = rCode6;
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
   * @param  system  DOCUMENT ME!
   */
  public void setSystem(Boolean system) {
    this.system = system;
  }
} // end class PortfolioAgentDispositionCode
