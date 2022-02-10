package com.cmc.credagility.core.domain.account;

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
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/17/2014 09:53
 */
@Entity
@Table(
  name              = "AccountMetaDataField",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) }
)
public class AccountMetaDataField extends MetaDataField {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountMetaDataFieldId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountMetaDataFieldId;


  /** TODO: DOCUMENT ME! */
  @Transient protected String creatorName;


  /** TODO: DOCUMENT ME! */
  @Transient protected String dataType;


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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAccountMetaDataFieldId() {
    return accountMetaDataFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCreatorName() {
    if ((creatorName == null) || "".equals(creatorName)) {
      return null;
    }

    return creatorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataType() {
// return this.type != null && !"".equals(this.type) ? this.type.name() : null;
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTag() {
    return tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @param  accountMetaDataFieldId  DOCUMENT ME!
   */
  public void setAccountMetaDataFieldId(Long accountMetaDataFieldId) {
    this.accountMetaDataFieldId = accountMetaDataFieldId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  creatorName  DOCUMENT ME!
   */
  public void setCreatorName(String creatorName) {
    this.creatorName = creatorName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dataType  DOCUMENT ME!
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  tag  DOCUMENT ME!
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableId  DOCUMENT ME!
   */
  public void setVariableId(Long variableId) {
    this.variableId = variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "AccountMetaDataField{"
      + "accountMetaDataFieldId=" + accountMetaDataFieldId
      + ", variableId=" + variableId
      + ", dataType='" + dataType + '\''
      + ", tag='" + tag + '\''
      + ", creatorName='" + creatorName + '\''
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(AccountMetaDataField other) {
    this.name           = other.getName();
    this.expression     = other.getExpression();
    this.type           = other.getType();
    this.lastUpdateDate = new Date();
  }
} // end class AccountMetaDataField
