package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.PaymentProgramTypeCode;


/**
 * This class is used to store Payment Program Type information.
 *
 * <p><a href="PaymentProgramType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PaymentProgramType"</p>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PaymentProgramType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "actionCode" }) }
)
public class PaymentProgramType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5193428750319469969L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Action Code. */
  @Column(
    name     = "actionCode",
    nullable = false,
    length   = 64
  )
  protected String actionCode;


  /** Program type description. */
  @Column(name = "description")
  protected String description;

  /**
   * Action Code of a payment program type. This code is normally used to specify actions after the payment program is
   * fulfilled. After the payment program is fulfilled, the account should have this action code as the status code so
   * that the batch job can do someth post-fultillment job about it. In theory, we could use the PK as the actionCode
   * but we choose not to due to the following reasons: 1. We want to give some semantic reason for the action; 2. For
   * different type, we may have the same action.
   */

  /** Program type name. */
  // npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name     = "name",
    nullable = false,
    length   = 200
  )
  protected String name;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Payment Program Type PK. */
  @Column(
    name     = "programTypeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long programTypeId;

  /** DOCUMENT ME! */
  @Transient protected String typeCode = "";

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PaymentProgramType object.
   */
  public PaymentProgramType() { }

  /**
   * Creates a new PaymentProgramType object.
   *
   * @param  paymentProgramTypeCode  DOCUMENT ME!
   */
  public PaymentProgramType(PaymentProgramTypeCode paymentProgramTypeCode) {
    this.name          = paymentProgramTypeCode.toString();
    this.programTypeId = paymentProgramTypeCode.getId();
  }

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

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof PaymentProgramType)) {
      return false;
    }

    final PaymentProgramType other = (PaymentProgramType) obj;

    if (name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!name.equals(other.getName())) {
      return false;
    }

    if (actionCode == null) {
      if (other.getActionCode() != null) {
        return false;
      }
    } else if (!actionCode.equals(other.getActionCode())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The action code for this payment program.
   *
   * @return  the action code for this payment program
   *
   *          <p>not-null = "true" length = "64"</p>
   */
  public String getActionCode() {
    return actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "true" length = "50" unique = "true"</p>
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The programTypeId.
   *
   * @return  the programTypeId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getProgramTypeId() {
    return programTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns the type code to locate the localized string for display purpose.
   *
   * @return  the type code to locate the localized string for display purpose.
   */
  public String getTypeCode() {
    return "paymentProgramType" + programTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result)
      + ((actionCode == null) ? 0 : actionCode.hashCode());

    return result;
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
   * @param  description  the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programTypeId  the programTypeId to set
   */
  public void setProgramTypeId(Long programTypeId) {
    this.programTypeId = programTypeId;
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

    retValue.append("PaymentProgramType ( ").append("programTypeId = ").append(
      this.programTypeId).append(TAB).append("name = ").append(this.name).append(TAB).append("description = ").append(
      this.description).append(
      TAB).append("actionCode = ").append(this.actionCode).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class PaymentProgramType
