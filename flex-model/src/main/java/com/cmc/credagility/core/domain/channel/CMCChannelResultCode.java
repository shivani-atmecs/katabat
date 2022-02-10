package com.cmc.credagility.core.domain.channel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:30
 */
@Entity
@Table(
  name              = "CMCChannelResultCode",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "code", "channelTypeId" }) }
)
public class CMCChannelResultCode extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelTypeId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected ChannelType channelType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "cmcChannelResultCodeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long cmcChannelResultCodeId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "code",
    length   = 100,
    nullable = false
  )
  protected String code;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type.
   *
   * @return  ChannelType
   */
  public ChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc channel result code id.
   *
   * @return  Long
   */
  public Long getCmcChannelResultCodeId() {
    return cmcChannelResultCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for code.
   *
   * @return  String
   */
  public String getCode() {
    return code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel type.
   *
   * @param  channelType  ChannelType
   */
  public void setChannelType(ChannelType channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc channel result code id.
   *
   * @param  cmcChannelResultCodeId  Long
   */
  public void setCmcChannelResultCodeId(Long cmcChannelResultCodeId) {
    this.cmcChannelResultCodeId = cmcChannelResultCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for code.
   *
   * @param  code  String
   */
  public void setCode(String code) {
    this.code = code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }
} // end class CMCChannelResultCode
