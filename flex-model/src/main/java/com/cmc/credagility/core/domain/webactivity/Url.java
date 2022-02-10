package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.WebActivityChannel;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:03
 */
@Entity
@Table(
  name    = "Url",
  indexes = {
    @Index(
      columnList = "activityChannel",
      name = "urlChannelIndex"
    )
  }
)
public class Url extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -6824283189771995792L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "activityChannel",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected WebActivityChannel activityChannel;

  @Column(
    name   = "baseUrl",
    length = 2048
  )
  private String baseUrl;

  @Column(
    name   = "pageName",
    length = 1024
  )
  private String pageName;

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long urlId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Url object.
   */
  public Url() {
    super();
  }

  /**
   * Creates a new Url object.
   *
   * @param  baseUrl          String
   * @param  pageName         String
   * @param  activityChannel  WebActivityChannel
   */
  public Url(String baseUrl, String pageName, WebActivityChannel activityChannel) {
    this.baseUrl         = baseUrl;
    this.pageName        = pageName;
    this.activityChannel = activityChannel;
  }

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

    if (!super.equals(o)) {
      return false;
    }

    Url url = (Url) o;

    if ((baseUrl != null) ? (!baseUrl.equals(url.baseUrl)) : (url.baseUrl != null)) {
      return false;
    }

    if ((pageName != null) ? (!pageName.equals(url.pageName)) : (url.pageName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity channel.
   *
   * @return  WebActivityChannel
   */
  public WebActivityChannel getActivityChannel() {
    return activityChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for base url.
   *
   * @return  String
   */
  public String getBaseUrl() {
    return baseUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for page name.
   *
   * @return  String
   */
  public String getPageName() {
    return pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for url id.
   *
   * @return  Long
   */
  public Long getUrlId() {
    return urlId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((baseUrl != null) ? baseUrl.hashCode() : 0);
    result = (31 * result) + ((pageName != null) ? pageName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity channel.
   *
   * @param  activityChannel  WebActivityChannel
   */
  public void setActivityChannel(WebActivityChannel activityChannel) {
    this.activityChannel = activityChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for base url.
   *
   * @param  baseUrl  String
   */
  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for page name.
   *
   * @param  pageName  String
   */
  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for url id.
   *
   * @param  urlId  Long
   */
  public void setUrlId(Long urlId) {
    this.urlId = urlId;
  }
} // end class Url
