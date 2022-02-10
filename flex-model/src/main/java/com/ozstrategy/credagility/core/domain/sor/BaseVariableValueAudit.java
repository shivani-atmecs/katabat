package com.ozstrategy.credagility.core.domain.sor;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by coin on 7/19/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  07/19/2016 09:23
 */
@MappedSuperclass public class BaseVariableValueAudit extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String context;

  /** TODO: DOCUMENT ME! */
  @Column protected String currentValue;

  /** data type, in Java Type. */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "userId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User executor;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  protected String triggerSource;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String variableName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(Object)
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

    BaseVariableValueAudit that = (BaseVariableValueAudit) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((currentValue != null) ? (!currentValue.equals(that.currentValue)) : (that.currentValue != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((executor != null) ? (!executor.equals(that.executor)) : (that.executor != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((triggerSource != null) ? (!triggerSource.equals(that.triggerSource)) : (that.triggerSource != null)) {
      return false;
    }

    return (variableName != null) ? variableName.equals(that.variableName) : (that.variableName == null);

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
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current value.
   *
   * @return  String
   */
  public String getCurrentValue() {
    return currentValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executor.
   *
   * @return  User
   */
  public User getExecutor() {
    return executor;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger source.
   *
   * @return  String
   */
  public String getTriggerSource() {
    return triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable name.
   *
   * @return  String
   */
  public String getVariableName() {
    return variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((currentValue != null) ? currentValue.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((executor != null) ? executor.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((triggerSource != null) ? triggerSource.hashCode() : 0);
    result = (31 * result) + ((variableName != null) ? variableName.hashCode() : 0);

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
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current value.
   *
   * @param  currentValue  String
   */
  public void setCurrentValue(String currentValue) {
    this.currentValue = currentValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type.
   *
   * @param  dataType  String
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for executor.
   *
   * @param  executor  User
   */
  public void setExecutor(User executor) {
    this.executor = executor;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger source.
   *
   * @param  triggerSource  String
   */
  public void setTriggerSource(String triggerSource) {
    this.triggerSource = triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable name.
   *
   * @param  variableName  String
   */
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String  TAB      = "    ";
    StringBuilder retValue = new StringBuilder();

    retValue.append("( ").append(super.toString()).append(TAB).append("accountNum = ").append(
      (account != null) ? this.account.getAccountNum() : "").append(TAB).append("context== ").append(
      (this.context != null) ? this.context : "").append(TAB).append(
      "currentValue== ").append((this.currentValue != null) ? this.currentValue : "").append(TAB).append(
      "responsibleId== ").append((this.responsible != null) ? this.responsible.getResponsibleId() : "").append(TAB)
      .append(
        "triggerSource== ").append((this.triggerSource != null) ? this.triggerSource : "").append(TAB).append(
      "variableName== ").append((this.variableName != null) ? this.variableName : "").append(TAB).append(TAB).append(
      "userName== ").append((this.executor != null) ? this.executor.getFullName() : "").append(TAB).append(TAB).append(
      "dataType== ").append((this.dataType != null) ? this.dataType : "").append(TAB).append(" )");

    return retValue.toString();
  } // end method toString
} // end class BaseVariableValueAudit
