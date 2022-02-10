package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.IvrResultCode;


/**
 * This class is used to store ivr return result code information.
 *
 * <p><a href="IvrResultCodeType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:05
 */
@Entity
@Table(name = "IvrResultCodeType")
public class IvrResultCodeType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5410321773386884262L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** field code. */
  @Column(
    name     = "code",
    nullable = false,
    length   = 255
  )
  protected String code;

  /** description. */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;

  /** Result Id, PK. */
  @Column(
    name     = "typeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new IvrResultCodeType object.
   */
  public IvrResultCodeType() { }

  /**
   * Creates a new IvrResultCodeType object.
   *
   * @param  ivrResultCode  IvrResultCode
   */
  public IvrResultCodeType(IvrResultCode ivrResultCode) {
    this.typeId      = ivrResultCode.getId();
    this.code        = ivrResultCode.toString();
    this.description = ivrResultCode.getDescription();
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

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    IvrResultCodeType other = (IvrResultCodeType) obj;

    if (code == null) {
      if (other.code != null) {
        return false;
      }
    } else if (!code.equals(other.code)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The code.
   *
   * @return  the code
   *
   *          <p>not-null = "true"</p>
   */
  public String getCode() {
    return code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   *
   *          <p>not-null = "false"</p>
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the Ivr result code enum.
   *
   * @return  get the Ivr result code enum.
   */
  public IvrResultCode getIvrResultCode() {
    return IvrResultCode.toIvrResultCode(code);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The typeId.
   *
   * @return  the typeId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getTypeId() {
    return typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((code == null) ? 0 : code.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCode.
   *
   * @param  code  the code to set
   */
  public void setCode(String code) {
    this.code = code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDescription.
   *
   * @param  description  the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTypeId.
   *
   * @param  typeId  the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
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

    retValue.append("IvrResultCodeType ( ").append(super.toString()).append(TAB).append("code = ").append(this.code)
      .append(TAB).append(
      "description = ").append(this.description).append(TAB).append(
      "typeId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class IvrResultCodeType
