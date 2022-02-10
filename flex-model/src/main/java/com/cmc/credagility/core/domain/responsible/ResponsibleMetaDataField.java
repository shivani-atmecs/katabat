package com.cmc.credagility.core.domain.responsible;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.metadata.MetaDataField;


/**
 * This class is used to store ResponsibleMetaDataField information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:41
 */
@Entity
@Table(
  name              = "ResponsibleMetaDataField",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "name",
      columnNames   = { "name" }
    )
  }
)
public class ResponsibleMetaDataField extends MetaDataField {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleMetaDataFieldId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleMetaDataFieldId;

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
   * getter method for responsible meta data field id.
   *
   * @return  Long
   */
  public Long getResponsibleMetaDataFieldId() {
    return responsibleMetaDataFieldId;
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
   * setter method for responsible meta data field id.
   *
   * @param  responsibleMetaDataFieldId  Long
   */
  public void setResponsibleMetaDataFieldId(Long responsibleMetaDataFieldId) {
    this.responsibleMetaDataFieldId = responsibleMetaDataFieldId;
  }
} // end class ResponsibleMetaDataField
