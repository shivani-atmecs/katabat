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
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.WebActivityChannel;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:53
 */
@Entity
@Table(
  name              = "Session",
  uniqueConstraints = { @UniqueConstraint(columnNames = "httpSession") },
  indexes           = {
    @Index(
      columnList    = "activityChannel,httpSession",
      name          = "sessionComboIndex"
    )
  }
)
public class Session extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3761600096175175296L;

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
    name   = "httpServer",
    length = 256
  )
  private String   httpServer;
  @Column(
    name   = "httpSession",
    length = 128
  )
  private String   httpSession;
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long sessionId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Session object.
   */
  public Session() {
    super();
  }

  /**
   * Creates a new Session object.
   *
   * @param  httpSession      String
   * @param  httpServer       String
   * @param  activityChannel  WebActivityChannel
   */
  public Session(String httpSession, String httpServer, WebActivityChannel activityChannel) {
    this.httpSession     = httpSession;
    this.httpServer      = httpServer;
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

    Session session = (Session) o;

    if ((httpSession != null) ? (!httpSession.equals(session.httpSession)) : (session.httpSession != null)) {
      return false;
    }

    return true;
  }

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
   * getter method for http server.
   *
   * @return  String
   */
  public String getHttpServer() {
    return httpServer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for http session.
   *
   * @return  String
   */
  public String getHttpSession() {
    return httpSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session id.
   *
   * @return  Long
   */
  public Long getSessionId() {
    return sessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((httpSession != null) ? httpSession.hashCode() : 0);

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
   * setter method for http server.
   *
   * @param  httpServer  String
   */
  public void setHttpServer(String httpServer) {
    this.httpServer = httpServer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for http session.
   *
   * @param  httpSession  String
   */
  public void setHttpSession(String httpSession) {
    this.httpSession = httpSession;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session id.
   *
   * @param  sessionId  Long
   */
  public void setSessionId(Long sessionId) {
    this.sessionId = sessionId;
  }
} // end class Session
