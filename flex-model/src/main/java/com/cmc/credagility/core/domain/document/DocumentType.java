package com.cmc.credagility.core.domain.document;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:12
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class DocumentType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5894568991854180897L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document Type Description. */
  @Column(length = 250)
  protected String description;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "templateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DocumentTemplate downloadTemplate;

  /** Document Type PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Document Type Name. */
  @Column(
    length = 45,
    unique = true
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean provideTemplate = false;

  /** Relations DocumentType DocumentTypeStatusType : */
  @OneToMany(
    fetch    = FetchType.EAGER,
    mappedBy = "documentType",
    cascade  = CascadeType.ALL
  )
  protected Set<DocumentTypeStatusType> typeStatusType = new LinkedHashSet<DocumentTypeStatusType>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DocumentType object.
   */
  public DocumentType() {
    super();
  }

  /**
   * Creates a new DocumentType object.
   *
   * @param  id    Long
   * @param  name  String
   */
  public DocumentType(Long id, String name) {
    super();
    this.id   = id;
    this.name = name;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Copy document type information from other document type.
   *
   * @param  type  $param.type$
   */
  public void deepCopy(DocumentType type) {
    if (type != null) {
      this.id          = type.getId();
      this.name        = type.getName();
      this.description = type.getDescription();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
  * (non-Javadoc)
  *
  * @see java.lang.Object#equals(java.lang.Object)
  */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final DocumentType other = (DocumentType) obj;

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document type description.
   *
   * @return  get document type description.
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for download template.
   *
   * @return  DocumentTemplate
   */
  public DocumentTemplate getDownloadTemplate() {
    return downloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document type PK.
   *
   * @return  get document type PK.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for provide template.
   *
   * @return  Boolean
   */
  public Boolean getProvideTemplate() {
    return provideTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document type status types.
   *
   * @return  get document type status types.
   */
  public Set<DocumentTypeStatusType> getTypeStatusType() {
    return typeStatusType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
  * (non-Javadoc)
  *
  * @see java.lang.Object#hashCode()
  */

  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document type description.
   *
   * @param  description  $param.type$
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for download template.
   *
   * @param  downloadTemplate  DocumentTemplate
   */
  public void setDownloadTemplate(DocumentTemplate downloadTemplate) {
    this.downloadTemplate = downloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document type ID.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setName.
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for provide template.
   *
   * @param  provideTemplate  Boolean
   */
  public void setProvideTemplate(Boolean provideTemplate) {
    this.provideTemplate = provideTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document type status types.
   *
   * @param  typeStatusType  $param.type$
   */
  public void setTypeStatusType(Set<DocumentTypeStatusType> typeStatusType) {
    this.typeStatusType = typeStatusType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("AddressType ( ").append(super.toString()).append(TAB).append("name = ").append(this.name).append(
      TAB).append("id = ").append(this.id).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class DocumentType
