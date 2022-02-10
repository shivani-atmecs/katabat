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
 * @version  10/16/2014 09:44
 */
@Entity
@Table(
  name    = "Browser",
  indexes = {
    @Index(
      columnList = "activityChannel",
      name = "channelIndex"
    )
  }
)
public class Browser extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7456744763863446712L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "activityChannel",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected WebActivityChannel activityChannel;

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long browserId;

  @Column(
    name   = "name",
    length = 128
  )
  private String name;

  @Column(
    name   = "userAgent",
    length = 512
  )
  private String userAgent;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Browser object.
   */
  public Browser() {
    super();
  }

  /**
   * Creates a new Browser object.
   *
   * @param  userAgent        String
   * @param  activityChannel  WebActivityChannel
   */
  public Browser(String userAgent, WebActivityChannel activityChannel) {
    this.userAgent       = userAgent;
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

    Browser browser = (Browser) o;

    if ((name != null) ? (!name.equals(browser.name)) : (browser.name != null)) {
      return false;
    }

    if ((userAgent != null) ? (!userAgent.equals(browser.userAgent)) : (browser.userAgent != null)) {
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
   * getter method for browser id.
   *
   * @return  Long
   */
  public Long getBrowserId() {
    return browserId;
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
   * getter method for user agent.
   *
   * @return  String
   */
  public String getUserAgent() {
    return userAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((userAgent != null) ? userAgent.hashCode() : 0);

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
   * setter method for browser id.
   *
   * @param  browserId  Long
   */
  public void setBrowserId(Long browserId) {
    this.browserId = browserId;
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
   * setter method for user agent.
   *
   * @param  userAgent  String
   */
  public void setUserAgent(String userAgent) {
    if (userAgent != null) {
      this.userAgent = userAgent.substring(0, 512);
    } else {
      this.userAgent = null;
    }
  }
} // end class Browser
