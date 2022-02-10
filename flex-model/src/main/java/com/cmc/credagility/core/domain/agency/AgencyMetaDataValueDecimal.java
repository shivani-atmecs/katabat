package com.cmc.credagility.core.domain.agency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.metadata.MetaDataValueDecimal;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:08
 */
@Entity
@Table(
  name    = "AgencyMetaDataValueDecimal",
  indexes = {
    @Index(
      name = "decimal_value_idx",
      columnList = "value"
    )
  }
)
public class AgencyMetaDataValueDecimal extends MetaDataValueDecimal {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2387216885488022857L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name   = "metaDataId",
    unique = true
  )
  @OneToOne private AgencyMetaData metaData;

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
   * getter method for meta data.
   *
   * @return  AgencyMetaData
   */
  public AgencyMetaData getMetaData() {
    return metaData;
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
   * setter method for meta data.
   *
   * @param  metaData  AgencyMetaData
   */
  public void setMetaData(AgencyMetaData metaData) {
    this.metaData = metaData;
  }
} // end class AgencyMetaDataValueDecimal
