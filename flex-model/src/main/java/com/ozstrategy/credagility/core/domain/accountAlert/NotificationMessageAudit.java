package com.ozstrategy.credagility.core.domain.accountAlert;

import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  04/16/2015 14:27
 */
@Entity
@Table(name = "NotificationMessageAudit")
public class NotificationMessageAudit extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String action;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "notificationMessageId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected HotSpotAlert notificationMessage;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * HotSpotAlert.
   *
   * @return  HotSpotAlert.
   */
  public HotSpotAlert getNotificationMessage() {
    return notificationMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setAction.
   *
   * @param  action  $param.type$
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setNotificationMessage.
   *
   * @param  notificationMessage  $param.type$
   */
  public void setNotificationMessage(HotSpotAlert notificationMessage) {
    this.notificationMessage = notificationMessage;
  }
} // end class NotificationMessageAudit
