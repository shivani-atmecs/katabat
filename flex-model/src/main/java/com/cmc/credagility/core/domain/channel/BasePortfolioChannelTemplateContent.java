package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplate;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.jpa.converter.LocaleTypeEnumConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 15:05
 */
@DiscriminatorColumn(
  name              = "contentType",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PortfolioChannelTemplateContent")
public class BasePortfolioChannelTemplateContent extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2627121747032189531L;

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
  @JoinColumn(
    name      = "templateId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected PortfolioChannelTemplate template;


  /** TODO: DOCUMENT ME! */
  @Column protected Long version = 1L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    BasePortfolioChannelTemplateContent that = (BasePortfolioChannelTemplateContent) o;


    if (locale != that.locale) {
      return false;
    }

    if (!template.equals(that.template)) {
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
   * getter method for template.
   *
   * @return  PortfolioChannelTemplate
   */
  public PortfolioChannelTemplate getTemplate() {
    return template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template id.
   *
   * @return  Long
   */
  public Long getTemplateId() {
    if (template != null) {
      return template.getId();
    }

    return null;
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
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = 47;
// result = (31 * result) + (id != null ? id.hashCode() : 0);
    result = (31 * result) + ((locale != null) ? locale.hashCode() : 0);
    result = (31 * result) + ((template != null) ? template.hashCode() : 0);
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

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
   * setter method for template.
   *
   * @param  template  PortfolioChannelTemplate
   */
  public void setTemplate(PortfolioChannelTemplate template) {
    this.template = template;
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
} // end class BasePortfolioChannelTemplateContent
