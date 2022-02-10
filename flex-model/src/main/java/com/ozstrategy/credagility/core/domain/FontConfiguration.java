package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:52
 */
@Entity
@Table(
  name              = "FontConfiguration",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) }
)
public class FontConfiguration {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "BLOB")
  @Lob protected byte[] content;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 10
  )
  protected String format;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Font Name. */
  @Column(
    nullable = false,
    unique   = true,
    length   = 50
  )
  protected String name;

  /** Font css url E.G.: http://fonts.googleapis.com/css?family=Arvo */
  @Column(
    nullable = true,
    length   = 250
  )
  protected String url;

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

    FontConfiguration that = (FontConfiguration) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @return  byte[]
   */
  public byte[] getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for format.
   *
   * @return  String
   */
  public String getFormat() {
    return format;
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
   * getter method for url.
   *
   * @return  String
   */
  public String getUrl() {
    return url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    return (name != null) ? name.hashCode() : 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content.
   *
   * @param  content  byte[]
   */
  public void setContent(byte[] content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for format.
   *
   * @param  format  String
   */
  public void setFormat(String format) {
    this.format = format;
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
   * setter method for url.
   *
   * @param  url  String
   */
  public void setUrl(String url) {
    this.url = url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuffer sb = new StringBuffer("FontConfiguration{");
    sb.append("name='").append(name).append('\'');
    sb.append(", format='").append(format).append('\'');
    sb.append(", url='").append(url).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class FontConfiguration
