package com.cmc.credagility.core.domain.action;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to present the hot action information.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/16/2014 09:56 AM
 */
@Entity
@Table(name = "HotAction")
public class HotAction extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2818004194793930258L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** linking account. */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** Hot action id PK. */
  @Column(
    name     = "actionId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long actionId;

  /** action name. */
  @Column(
    name     = "name",
    nullable = false,
    length   = 80
  )
  protected String name;

  /** the account has been picked. */
  @Column(
    name             = "picked",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean picked;

  /** reference number. */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** action status. */
  /** the account has been showed. */
  @Column(
    name             = "showed",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showed;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    final HotAction other = (HotAction) obj;

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   */
  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The actionId.
   *
   * @return  the actionId
   */
  public Long getActionId() {
    return this.actionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The picked.
   *
   * @return  the picked
   */
  public Boolean getPicked() {
    return this.picked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsible.
   *
   * @return  the responsible
   */
  public Responsible getResponsible() {
    return this.responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsibleId.
   *
   * @return  the responsibleId
   */
  public String getResponsibleId() {
    return this.responsible.getResponsibleId().toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The showed.
   *
   * @return  the showed
   */
  public Boolean getShowed() {
    return this.showed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

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
   * setter method for action id.
   *
   * @param  actionId  Long
   */
  public void setActionId(Long actionId) {
    this.actionId = actionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for picked.
   *
   * @param  picked  Boolean
   */
  public void setPicked(Boolean picked) {
    this.picked = picked;
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
   * setter method for showed.
   *
   * @param  showed  Boolean
   */
  public void setShowed(Boolean showed) {
    this.showed = showed;
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

    retValue.append("HotAction ( ").append(super.toString()).append(TAB).append("account = ").append(this.account)
      .append(TAB).append(
      "actionId = ").append(this.actionId).append(TAB).append("name = ").append(this.name).append(TAB).append(
      "picked = ").append(this.picked).append(TAB).append("responsible = ").append(this.responsible).append(
      TAB).append("showed = ").append(this.showed).append(TAB).append(
      " )");

    return retValue.toString();
  }
} // end class HotAction
