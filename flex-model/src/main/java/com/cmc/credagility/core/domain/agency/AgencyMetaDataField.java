package com.cmc.credagility.core.domain.agency;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.metadata.MetaDataField;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:04
 */
@Entity
@Table(
  name              = "AgencyMetaDataField",
  uniqueConstraints = @UniqueConstraint(columnNames = { "name" })
)
public class AgencyMetaDataField extends MetaDataField {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3291972677847803494L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Transient protected String creatorName;

  /** TODO: DOCUMENT ME! */
  @Transient protected String dataType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Transient protected String tag;

  /** TODO: DOCUMENT ME! */
  @Transient protected Long variableId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.metadata.MetaDataField#equals(java.lang.Object)
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

    final MetaDataField other = (MetaDataField) obj;

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
   * getter method for creator name.
   *
   * @return  String
   */
  public String getCreatorName() {
    if ((creatorName == null) || "".equals(creatorName)) {
      return null;
    }

    return creatorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
// return this.type != null && !"".equals(this.type) ? this.type.name() : null;
    return dataType;
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
   * getter method for tag.
   *
   * @return  String
   */
  public String getTag() {
    return tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable id.
   *
   * @return  Long
   */
  public Long getVariableId() {
    return variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.metadata.MetaDataField#hashCode()
   */
  @Override public int hashCode() {
    return super.hashCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator name.
   *
   * @param  creatorName  String
   */
  public void setCreatorName(String creatorName) {
    this.creatorName = creatorName;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tag.
   *
   * @param  tag  String
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable id.
   *
   * @param  variableId  Long
   */
  public void setVariableId(Long variableId) {
    this.variableId = variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "AgencyMetaDataField{"
      + "id=" + id
      + ", creatorName='" + creatorName + '\''
      + ", dataType='" + dataType + '\''
      + ", tag='" + tag + '\''
      + ", variableId=" + variableId
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  AgencyMetaDataField
   */
  public void update(AgencyMetaDataField other) {
    this.name           = other.getName();
    this.expression     = other.getExpression();
    this.type           = other.getType();
    this.lastUpdateDate = new Date();
  }
} // end class AgencyMetaDataField
