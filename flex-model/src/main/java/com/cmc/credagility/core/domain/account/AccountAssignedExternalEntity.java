package com.cmc.credagility.core.domain.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 16:45
 */
@Entity
@Table(
  name    = "AccountAssignedExternalEntity",
  indexes = {
    @Index(
      name = "initialAssignmentDateIndex",
      columnList = "initialAssignmentDate"
    )
  }
)
public class AccountAssignedExternalEntity extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4751837131280477359L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long accountAssignedExternalEntityId;

  @Column(name = "initialAssignmentDate")
  private Date initialAssignmentDate;

  @JoinColumn(name = "agencyId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyAccount object.
   */
  public AccountAssignedExternalEntity() { }

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

    if (!(o instanceof AccountAssignedExternalEntity)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AccountAssignedExternalEntity that = (AccountAssignedExternalEntity) o;

    if (!account.equals(that.account)) {
      return false;
    }

    if (!role.equals(that.role)) {
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
   * getter method for account assigned external entity id.
   *
   * @return  Long
   */
  public Long getAccountAssignedExternalEntityId() {
    return accountAssignedExternalEntityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial assignment date.
   *
   * @return  Date
   */
  public Date getInitialAssignmentDate() {
    return initialAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + account.hashCode();
    result = (31 * result) + role.hashCode();

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
   * setter method for account assigned external entity id.
   *
   * @param  accountAssignedExternalEntityId  Long
   */
  public void setAccountAssignedExternalEntityId(Long accountAssignedExternalEntityId) {
    this.accountAssignedExternalEntityId = accountAssignedExternalEntityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for initial assignment date.
   *
   * @param  initialAssignmentDate  Date
   */
  public void setInitialAssignmentDate(Date initialAssignmentDate) {
    this.initialAssignmentDate = initialAssignmentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }
} // end class AccountAssignedExternalEntity
