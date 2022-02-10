package com.cmc.credagility.core.domain.responsible;

import com.cmc.credagility.core.domain.account.AccountPolicy;
import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  02/27/2015 11:03
 */
@Entity
@Table(name = "ResponsiblePolicy")
public class ResponsiblePolicy extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7861042323231433674L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountPolicyId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountPolicy accountPolicy;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partyIdentifier",
    length = 32
  )
  protected String partyIdentifier;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long responsiblePolicyId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ResponsiblePolicy that = (ResponsiblePolicy) o;

    if (!accountPolicy.equals(that.accountPolicy)) {
      return false;
    }

    if ((partyIdentifier != null) ? (!partyIdentifier.equals(that.partyIdentifier)) : (that.partyIdentifier != null)) {
      return false;
    }

    if (!responsible.equals(that.responsible)) {
      return false;
    }

    if ((responsiblePolicyId != null) ? (!responsiblePolicyId.equals(that.responsiblePolicyId))
                                      : (that.responsiblePolicyId != null)) {
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
  public AccountPolicy getAccountPolicy() {
    return accountPolicy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPartyIdentifier() {
    return partyIdentifier;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
  public Long getResponsiblePolicyId() {
    return responsiblePolicyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + accountPolicy.hashCode();
    result = (31 * result) + ((partyIdentifier != null) ? partyIdentifier.hashCode() : 0);
    result = (31 * result) + responsible.hashCode();
    result = (31 * result) + ((responsiblePolicyId != null) ? responsiblePolicyId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountPolicy  DOCUMENT ME!
   */
  public void setAccountPolicy(AccountPolicy accountPolicy) {
    this.accountPolicy = accountPolicy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  partyIdentifier  DOCUMENT ME!
   */
  public void setPartyIdentifier(String partyIdentifier) {
    this.partyIdentifier = partyIdentifier;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * @param  responsiblePolicyId  DOCUMENT ME!
   */
  public void setResponsiblePolicyId(Long responsiblePolicyId) {
    this.responsiblePolicyId = responsiblePolicyId;
  }
} // end class ResponsiblePolicy
