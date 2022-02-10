package com.cmc.credagility.core.domain.responsible;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.metadata.MetaDataValueBoolean;


/**
 * This class is used to store ResponsibleMetaDataValueBoolean information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:42
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "boolean_value_idx",
      columnList = "value"
    )
  }
)
public class ResponsibleMetaDataValueBoolean extends MetaDataValueBoolean {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -6758726579327931094L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name   = "responsibleMetaDataId",
    unique = true
  )
  @ManyToOne private ResponsibleMetaData responsibleMetaData;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for responsible meta data.
   *
   * @return  ResponsibleMetaData
   */
  public ResponsibleMetaData getResponsibleMetaData() {
    return responsibleMetaData;
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
   * setter method for responsible meta data.
   *
   * @param  responsibleMetaData  ResponsibleMetaData
   */
  public void setResponsibleMetaData(ResponsibleMetaData responsibleMetaData) {
    this.responsibleMetaData = responsibleMetaData;
  }
} // end class ResponsibleMetaDataValueBoolean
