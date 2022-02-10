package com.cmc.credagility.core.domain.message;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:16
 */
@Entity
@Table(name = "MessagePacket")
public class MessagePacket extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5456655931509046653L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "cacheInterval")
  protected Integer cacheInterval = 0;


  /** TODO: DOCUMENT ME! */
  @Column(name = "defaultFetchSize")
  protected Integer defaultFetchSize = 0;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messagePacketId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long messagePacketId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "packetDescription",
    length = 150
  )
  protected String packetDescription;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "packetName",
    length = 255
  )
  protected String packetName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @Column(name = "purgeInterval")
  protected Integer purgeInterval = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for cache interval.
   *
   * @return  Integer
   */
  public Integer getCacheInterval() {
    return cacheInterval;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default fetch size.
   *
   * @return  Integer
   */
  public Integer getDefaultFetchSize() {
    return defaultFetchSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet id.
   *
   * @return  Long
   */
  public Long getMessagePacketId() {
    return messagePacketId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for packet description.
   *
   * @return  String
   */
  public String getPacketDescription() {
    return packetDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for packet name.
   *
   * @return  String
   */
  public String getPacketName() {
    return packetName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for purge interval.
   *
   * @return  Integer
   */
  public Integer getPurgeInterval() {
    return purgeInterval;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cache interval.
   *
   * @param  cacheInterval  Integer
   */
  public void setCacheInterval(Integer cacheInterval) {
    this.cacheInterval = cacheInterval;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default fetch size.
   *
   * @param  defaultFetchSize  Integer
   */
  public void setDefaultFetchSize(Integer defaultFetchSize) {
    this.defaultFetchSize = defaultFetchSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message packet id.
   *
   * @param  messagePacketId  Long
   */
  public void setMessagePacketId(Long messagePacketId) {
    this.messagePacketId = messagePacketId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for packet description.
   *
   * @param  packetDescription  String
   */
  public void setPacketDescription(String packetDescription) {
    this.packetDescription = packetDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for packet name.
   *
   * @param  packetName  String
   */
  public void setPacketName(String packetName) {
    this.packetName = packetName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for purge interval.
   *
   * @param  purgeInterval  Integer
   */
  public void setPurgeInterval(Integer purgeInterval) {
    this.purgeInterval = purgeInterval;
  }
} // end class MessagePacket
