package com.cmc.credagility.core.domain.agency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.document.DocumentCategory;
import com.cmc.credagility.core.domain.user.Role;


/**
 * Document record for agency.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:59 PM
 */
@Entity
@Table(
  name              = "AgencyDocument",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "agencyId", "documentCategoryId" }) }
)
public class AgencyDocument extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4414538644894251958L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Which agency this document belonged to. */
  @JoinColumn(
    name     = "agencyId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role agency;

  /** Category Name Path. */
  @Column(length = 1024)
  protected String categoryPath;

  /** Document category. Refers {@link DocumentCategory} */
  @JoinColumn(
    name     = "documentCategoryId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentCategory documentCategory;

  /** The extension of file name. */
  @Column(length = 128)
  protected String extension;

  /** The file name of this document. */
  @Column(length = 1024)
  protected String fileName;

  /** File type. */
  @Column protected String fileType;

  /** PK, identity property. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    AgencyDocument that = (AgencyDocument) o;

    if (!agency.equals(that.agency)) {
      return false;
    }

    if ((categoryPath != null) ? (!categoryPath.equals(that.categoryPath)) : (that.categoryPath != null)) {
      return false;
    }

    if (!documentCategory.equals(that.documentCategory)) {
      return false;
    }

    if ((extension != null) ? (!extension.equals(that.extension)) : (that.extension != null)) {
      return false;
    }

    if ((fileName != null) ? (!fileName.equals(that.fileName)) : (that.fileName != null)) {
      return false;
    }

    if ((fileType != null) ? (!fileType.equals(that.fileType)) : (that.fileType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency.
   *
   * @return  Role
   */
  public Role getAgency() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category path.
   *
   * @return  String
   */
  public String getCategoryPath() {
    return categoryPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document category.
   *
   * @return  DocumentCategory
   */
  public DocumentCategory getDocumentCategory() {
    return documentCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file type.
   *
   * @return  String
   */
  public String getFileType() {
    return fileType;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + documentCategory.hashCode();
    result = (31 * result) + agency.hashCode();
    result = (31 * result) + ((fileType != null) ? fileType.hashCode() : 0);
    result = (31 * result) + ((fileName != null) ? fileName.hashCode() : 0);
    result = (31 * result) + ((categoryPath != null) ? categoryPath.hashCode() : 0);
    result = (31 * result) + ((extension != null) ? extension.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Role
   */
  public void setAgency(Role agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category path.
   *
   * @param  categoryPath  String
   */
  public void setCategoryPath(String categoryPath) {
    this.categoryPath = categoryPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document category.
   *
   * @param  documentCategory  DocumentCategory
   */
  public void setDocumentCategory(DocumentCategory documentCategory) {
    this.documentCategory = documentCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file type.
   *
   * @param  fileType  String
   */
  public void setFileType(String fileType) {
    this.fileType = fileType;
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
} // end class AgencyDocument
