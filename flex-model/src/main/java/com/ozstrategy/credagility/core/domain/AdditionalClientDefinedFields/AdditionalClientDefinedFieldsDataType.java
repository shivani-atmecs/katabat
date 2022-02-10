package com.ozstrategy.credagility.core.domain.AdditionalClientDefinedFields;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/22/2015 14:51
 */
@Entity
@Table(name = "AdditionalClientDefinedFieldsDataType")
public class AdditionalClientDefinedFieldsDataType extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String dataType;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "dataType",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<AdditionalClientDefinedFieldsDataFormat> formats =
    new LinkedHashSet<AdditionalClientDefinedFieldsDataFormat>();


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AdditionalClientDefinedFieldsDataType object.
   */
  public AdditionalClientDefinedFieldsDataType() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AdditionalClientDefinedFieldsDataType)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AdditionalClientDefinedFieldsDataType that = (AdditionalClientDefinedFieldsDataType) o;

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return !((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null));

  } // end method equals

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
   * DOCUMENT ME!
   *
   * @param   formatId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AdditionalClientDefinedFieldsDataFormat getDataTypeFormat(Long formatId) {
    AdditionalClientDefinedFieldsDataFormat cdFieldsFormat = null;

    for (AdditionalClientDefinedFieldsDataFormat format : formats) {
      if (format.getId().longValue() == formatId.longValue()) {
        cdFieldsFormat = format;

        break;
      }
    }

    return cdFieldsFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for formats.
   *
   * @return  Set
   */
  public Set<AdditionalClientDefinedFieldsDataFormat> getFormats() {
    return formats;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
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
   * setter method for formats.
   *
   * @param  formats  Set
   */
  public void setFormats(Set<AdditionalClientDefinedFieldsDataFormat> formats) {
    this.formats = formats;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }
} // end class AdditionalClientDefinedFieldsDataType
