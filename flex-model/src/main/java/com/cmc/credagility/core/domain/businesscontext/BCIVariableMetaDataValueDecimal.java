package com.cmc.credagility.core.domain.businesscontext;

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
 * @version  10/15/2014 11:25
 */
@Entity
@Table(
  name    = "BCIVariableMetaDataValueDecimal",
  indexes = {
    @Index(
      name = "decimal_value_idx",
      columnList = "value"
    )
  }
)
public class BCIVariableMetaDataValueDecimal extends MetaDataValueDecimal {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name   = "bciVariableMetaDataId",
    unique = true
  )
  @OneToOne private BCIVariableMetaData bciVariableMetaData;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci variable meta data.
   *
   * @return  BCIVariableMetaData
   */
  public BCIVariableMetaData getBciVariableMetaData() {
    return bciVariableMetaData;
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
   * setter method for bci variable meta data.
   *
   * @param  bciVariableMetaData  BCIVariableMetaData
   */
  public void setBciVariableMetaData(BCIVariableMetaData bciVariableMetaData) {
    this.bciVariableMetaData = bciVariableMetaData;
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
} // end class BCIVariableMetaDataValueDecimal
