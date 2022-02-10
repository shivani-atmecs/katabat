package com.cmc.credagility.core.domain.businesscontext;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:11
 */
@Entity public class BCIStatusAudit extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1828492450595289021L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent = null;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "businessContextInstanceId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance businessContextInstance;

  /** TODO: DOCUMENT ME! */
  @Column(length = 100)
  protected String fromStatus;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String source;

  /** TODO: DOCUMENT ME! */
  @Column(length = 100)
  protected String toStatus;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCIStatusAudit object.
   */
  public BCIStatusAudit() { }

  /**
   * Creates a new BCIStatusAudit object.
   *
   * @param  fromStatus  String
   * @param  source      String
   * @param  agent       User
   */
  public BCIStatusAudit(String fromStatus, String source, User agent) {
    this.fromStatus  = fromStatus;
    this.source      = source;
    this.agent       = agent;
    this.creator     = agent;
    this.lastUpdater = agent;
  }

  /**
   * Creates a new BCIStatusAudit object.
   *
   * @param  agent       User
   * @param  fromStatus  String
   * @param  source      String
   * @param  toStatus    String
   */
  public BCIStatusAudit(User agent, String fromStatus, String source, String toStatus) {
    this.agent      = agent;
    this.fromStatus = fromStatus;
    this.source     = source;
    this.toStatus   = toStatus;
    this.createDate = new Date();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance.
   *
   * @return  BusinessContextInstance
   */
  public BusinessContextInstance getBusinessContextInstance() {
    return businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from status.
   *
   * @return  String
   */
  public String getFromStatus() {
    return fromStatus;
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
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to status.
   *
   * @return  String
   */
  public String getToStatus() {
    return toStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context instance.
   *
   * @param  businessContextInstance  BusinessContextInstance
   */
  public void setBusinessContextInstance(BusinessContextInstance businessContextInstance) {
    this.businessContextInstance = businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from status.
   *
   * @param  fromStatus  String
   */
  public void setFromStatus(String fromStatus) {
    this.fromStatus = fromStatus;
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
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to status.
   *
   * @param  toStatus  String
   */
  public void setToStatus(String toStatus) {
    this.toStatus = toStatus;
  }
} // end class BCIStatusAudit
