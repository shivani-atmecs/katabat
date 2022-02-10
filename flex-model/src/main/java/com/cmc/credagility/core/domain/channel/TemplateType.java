package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Letter templateType Type information.
 *
 * <p><a href="TemplateType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:07
 */
@Entity
@Table(name = "TemplateType")
public class TemplateType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4091679648479968288L;
  // npelleti, 07/30, USBank, Removed unique constraint

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Template Type Name. */
  @Column(
    name   = "name",
    length = 40
  )
  protected String name;

  /** Template Type PK. */
  @Column(
    name     = "templateId", /*unique = true*,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long templateId;

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

    final TemplateType other = (TemplateType) obj;

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
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "false" length = "40"</p>
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * type code.
   *
   * @return  type code.
   */
  public String getTemplateCode() {
    return getClass().getSimpleName() + this.templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The templateId.
   *
   * @return  the templateId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getTemplateId() {
    return this.templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
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
   * setter method for template id.
   *
   * @param  typeId  Long
   */
  public void setTemplateId(Long typeId) {
    this.templateId = typeId;
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

    retValue.append("OutcomeType ( ").append(super.toString()).append(TAB).append("name = ").append(this.name).append(
      TAB).append("templateId = ").append(this.templateId).append(TAB).append(
      " )");

    return retValue.toString();
  }
} // end class TemplateType
