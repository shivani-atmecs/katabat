package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.responsible.Responsible;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  12/31/2014 15:37
 */
@Entity
@Table(
  name    = "DialerChannelActualResult",
  indexes = {
    @Index(
      name = "idx_status",
      columnList = "status"
    )
  }
)
public class DialerChannelActualResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** DOCUMENT ME! */
  @Column(
    name     = "dialerActualResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long dialerActualResultId;


  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "dialerChannelResultId",
    nullable  = false,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DialerChannelResult dialerChannelResult;

  /** DOCUMENT ME! */
  @Column(length = 20)
  protected String phoneNum;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneTypeId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PhoneType phoneType;

  /** bucket amount 4. */

  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 30
  )
  protected String status;

  /** DOCUMENT ME! */
  @Column(
    name     = "strategyDate",
    nullable = false
  )
  protected Date strategyDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof DialerChannelActualResult)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    DialerChannelActualResult that = (DialerChannelActualResult) o;

    if ((dialerActualResultId != null) ? (!dialerActualResultId.equals(that.dialerActualResultId))
                                       : (that.dialerActualResultId != null)) {
      return false;
    }

    if ((phoneNum != null) ? (!phoneNum.equals(that.phoneNum)) : (that.phoneNum != null)) {
      return false;
    }

    if ((status != null) ? (!status.equals(that.status)) : (that.status != null)) {
      return false;
    }

    if ((strategyDate != null) ? (!strategyDate.equals(that.strategyDate)) : (that.strategyDate != null)) {
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
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getDialerActualResultId() {
    return dialerActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public DialerChannelResult getDialerChannelResult() {
    return dialerChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((dialerActualResultId != null) ? dialerActualResultId.hashCode() : 0);
    result = (31 * result) + ((phoneNum != null) ? phoneNum.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((strategyDate != null) ? strategyDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dialerActualResultId  DOCUMENT ME!
   */
  public void setDialerActualResultId(Long dialerActualResultId) {
    this.dialerActualResultId = dialerActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dialerChannelResult  DOCUMENT ME!
   */
  public void setDialerChannelResult(DialerChannelResult dialerChannelResult) {
    this.dialerChannelResult = dialerChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  DOCUMENT ME!
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneType  DOCUMENT ME!
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  phoneTypeId DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  DOCUMENT ME!
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  strategyDate  DOCUMENT ME!
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }
} // end class DialerChannelActualResult
