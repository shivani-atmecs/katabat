package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.type.LocaleType;
import com.ozstrategy.credagility.core.converter.LocaleTypeEnumConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * EnterpriseDocumentTemplate Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:44
 */
@MappedSuperclass public abstract class BasicEnterpriseDocumentTemplate extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1020029521130702752L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  /*HTML & PDF*/
  protected String contentType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected EnterpriseDocument document;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "locale",
    length = 5
  )
  @Convert(converter = LocaleTypeEnumConverter.class)
  protected LocaleType locale = LocaleType.ENGLISH;


  /** TODO: DOCUMENT ME! */
  @Column protected Long version = 0L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  BasicEnterpriseDocumentTemplate
   */
  public abstract BasicEnterpriseDocumentTemplate copy();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    BasicEnterpriseDocumentTemplate that = (BasicEnterpriseDocumentTemplate) o;

    if (!contentType.equals(that.contentType)) {
      return false;
    }

    if (!document.equals(that.document)) {
      return false;
    }

    if (locale != that.locale) {
      return false;
    }

    if (!version.equals(that.version)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content type.
   *
   * @return  String
   */
  public String getContentType() {
    return contentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getDocument() {
    return document;
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
   * getter method for locale.
   *
   * @return  LocaleType
   */
  public LocaleType getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Long
   */
  public Long getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + locale.hashCode();
    result = (31 * result) + document.hashCode();
    result = (31 * result) + contentType.hashCode();
    result = (31 * result) + version.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content type.
   *
   * @param  contentType  String
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document.
   *
   * @param  document  EnterpriseDocument
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
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
   * setter method for locale.
   *
   * @param  locale  LocaleType
   */
  public void setLocale(LocaleType locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Long
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  content  BasicEnterpriseDocumentTemplate
   */
  protected void paste(BasicEnterpriseDocumentTemplate content) {
    content.setLocale(this.getLocale());
    content.setContentType(this.getContentType());
    content.setDocument(this.getDocument());
  }
} // end class BasicEnterpriseDocumentTemplate
