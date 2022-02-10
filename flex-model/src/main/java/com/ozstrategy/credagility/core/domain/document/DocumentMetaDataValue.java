package com.ozstrategy.credagility.core.domain.document;

import com.ozstrategy.credagility.core.domain.BasicMetaData;

import javax.persistence.*;


/**
 * This class is used to store DocumentMetaDataValue information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:12
 */
@MappedSuperclass public abstract class DocumentMetaDataValue extends BasicMetaData {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** if the meta data is dropDown store the answer option display name. */
  @Column(nullable = true)
  protected String displayValue;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentVersionMetaDataId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionMetaData metaData;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String name;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instance.
   *
   * @return  BasicDocumentInstance
   */
  public abstract BasicDocumentInstance getDocumentInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for owner.
   *
   * @return  Object
   */
  public abstract Object getOwner();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  obj  Object
   */
  public abstract void setBusinessObject(Object obj);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element for meta data.
   *
   * @param  obj  Object
   */
  public abstract void setElementForMetaData(Object obj);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BasicMetaData#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    DocumentMetaDataValue that = (DocumentMetaDataValue) o;

    if ((metaData != null) ? (!metaData.equals(that.metaData)) : (that.metaData != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display value.
   *
   * @return  String
   */
  public String getDisplayValue() {
    return displayValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public EnterpriseDocumentVersionMetaData getMetaData() {
    return metaData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BasicMetaData#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((metaData != null) ? metaData.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display value.
   *
   * @param  displayValue  String
   */
  public void setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
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
   * @param  metaData  EnterpriseDocumentVersionMetaData
   */
  public void setMetaData(EnterpriseDocumentVersionMetaData metaData) {
    this.metaData = metaData;
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
} // end class DocumentMetaDataValue
