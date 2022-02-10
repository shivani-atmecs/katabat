package com.cmc.credagility.core.domain.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:54
 */
@Entity public class DocumentCategory {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document Type Description. */
  @Column(length = 250)
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Document Type Name. */
  @Column(
    unique   = true,
    nullable = false,
    length   = 100
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "parentCategoryId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentCategory parentCategory;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    DocumentCategory that = (DocumentCategory) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if (!name.equals(that.name)) {
      return false;
    }

    if (!parentCategory.equals(that.parentCategory)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent category.
   *
   * @return  DocumentCategory
   */
  public DocumentCategory getParentCategory() {
    return parentCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = name.hashCode();
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((parentCategory != null) ? parentCategory.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent category.
   *
   * @param  parentCategory  DocumentCategory
   */
  public void setParentCategory(DocumentCategory parentCategory) {
    this.parentCategory = parentCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    StringBuffer sb = new StringBuffer("DocumentCategory{");
    sb.append("id=").append(id).append(",").append("name=").append(name).append(",").append("description=").append(
      description).append(",").append("}");

    return sb.toString();
  }
} // end class DocumentCategory
