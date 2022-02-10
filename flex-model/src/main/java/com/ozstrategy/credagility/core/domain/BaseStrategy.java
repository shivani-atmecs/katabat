package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.event.Event;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:27
 */
@MappedSuperclass public class BaseStrategy extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 15,
    nullable = false
  )
  protected String context;

  /** Description for the strategy. */
  @Column(length = 255)
  protected String description;

  /** Event. */
  @JoinColumn(
    name       = "eventId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Event event;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long eventId = null;


  /** TODO: DOCUMENT ME! */
  @Transient protected String eventTypeName;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean exclusiveChild = false;

  /** Name for the strategy. */
  @Column(length = 255)
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Transient protected Boolean onlyGraphDataChange = false;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 0;

  /** Score Card Strategy. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  /** User data 1 . */
  protected Boolean scoreCard = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long scoreTypeId = null;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "strategyRunTypeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected StrategyRunType strategyRunType;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long strategyRunTypeId = null;

  /** Define the type for Strategy,such as ScoreCard, Events. */
  @Column(length = 10)
  protected String type;


  /** TODO: DOCUMENT ME! */
  @Lob protected String userData1;


  /** TODO: DOCUMENT ME! */
  @Column(length = 16)
  protected String zoom = "actual";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseStrategy that = (BaseStrategy) o;

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((eventId != null) ? (!eventId.equals(that.eventId)) : (that.eventId != null)) {
      return false;
    }

    if ((eventTypeName != null) ? (!eventTypeName.equals(that.eventTypeName)) : (that.eventTypeName != null)) {
      return false;
    }

    if ((exclusiveChild != null) ? (!exclusiveChild.equals(that.exclusiveChild)) : (that.exclusiveChild != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((onlyGraphDataChange != null) ? (!onlyGraphDataChange.equals(that.onlyGraphDataChange))
                                      : (that.onlyGraphDataChange != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((scoreCard != null) ? (!scoreCard.equals(that.scoreCard)) : (that.scoreCard != null)) {
      return false;
    }

    if ((scoreTypeId != null) ? (!scoreTypeId.equals(that.scoreTypeId)) : (that.scoreTypeId != null)) {
      return false;
    }

    if ((strategyRunTypeId != null) ? (!strategyRunTypeId.equals(that.strategyRunTypeId))
                                    : (that.strategyRunTypeId != null)) {
      return false;
    }

    if ((type != null) ? (!type.equals(that.type)) : (that.type != null)) {
      return false;
    }

    if ((userData1 != null) ? (!userData1.equals(that.userData1)) : (that.userData1 != null)) {
      return false;
    }

    if ((zoom != null) ? (!zoom.equals(that.zoom)) : (that.zoom != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event.
   *
   * @return  Event
   */
  public Event getEvent() {
    return event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event id.
   *
   * @return  Long
   */
  public Long getEventId() {
    return (event != null) ? event.getEventId() : eventId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event type name.
   *
   * @return  String
   */
  public String getEventTypeName() {
    if (this.getEvent() != null) {
      return this.getEvent().getEventName();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exclusive child.
   *
   * @return  Boolean
   */
  public Boolean getExclusiveChild() {
    if (exclusiveChild == null) {
      return Boolean.FALSE;
    }

    return exclusiveChild;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * schedule name.
   *
   * <p>.@return schedule name</p>
   *
   * @return  schedule name.
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for only graph data change.
   *
   * @return  Boolean
   */
  public Boolean getOnlyGraphDataChange() {
    if (onlyGraphDataChange == null) {
      return Boolean.FALSE;
    }

    return onlyGraphDataChange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score card.
   *
   * @return  Boolean
   */
  public Boolean getScoreCard() {
    if (scoreCard == null) {
      return Boolean.FALSE;
    }

    return scoreCard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type id.
   *
   * @return  Long
   */
  public Long getScoreTypeId() {
    // scoreTypeId = (portfolioScoreType != null) ? portfolioScoreType.getPortfolioScoreTypeId() : null;

    return scoreTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy run type.
   *
   * @return  StrategyRunType
   */
  public StrategyRunType getStrategyRunType() {
    return strategyRunType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy run type id.
   *
   * @return  Long
   */
  public Long getStrategyRunTypeId() {
    return strategyRunTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * User data1 to get.
   *
   * @return  user data1 to get
   */
  public String getUserData1() {
    return userData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zoom.
   *
   * @return  String
   */
  public String getZoom() {
    return zoom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 47;
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((eventId != null) ? eventId.hashCode() : 0);
    result = (31 * result) + ((eventTypeName != null) ? eventTypeName.hashCode() : 0);
    result = (31 * result) + ((exclusiveChild != null) ? exclusiveChild.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((onlyGraphDataChange != null) ? onlyGraphDataChange.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((scoreTypeId != null) ? scoreTypeId.hashCode() : 0);
    result = (31 * result) + ((strategyRunTypeId != null) ? strategyRunTypeId.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((scoreCard != null) ? scoreCard.hashCode() : 0);
    result = (31 * result) + ((userData1 != null) ? userData1.hashCode() : 0);
    result = (31 * result) + ((zoom != null) ? zoom.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event.
   *
   * @param  event  Event
   */
  public void setEvent(Event event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event id.
   *
   * @param  eventId  Long
   */
  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event type name.
   *
   * @param  eventTypeName  String
   */
  public void setEventTypeName(String eventTypeName) {
    this.eventTypeName = eventTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exclusive child.
   *
   * @param  exclusiveChild  Boolean
   */
  public void setExclusiveChild(Boolean exclusiveChild) {
    this.exclusiveChild = exclusiveChild;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;

    if (this.name != null) {
      this.name = this.name.trim();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for only graph data change.
   *
   * @param  onlyGraphDataChange  Boolean
   */
  public void setOnlyGraphDataChange(Boolean onlyGraphDataChange) {
    this.onlyGraphDataChange = onlyGraphDataChange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score card.
   *
   * @param  scoreCard  Boolean
   */
  public void setScoreCard(Boolean scoreCard) {
    this.scoreCard = scoreCard;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score type id.
   *
   * @param  scoreTypeId  Long
   */
  public void setScoreTypeId(Long scoreTypeId) {
    this.scoreTypeId = scoreTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy run type.
   *
   * @param  strategyRunType  StrategyRunType
   */
  public void setStrategyRunType(StrategyRunType strategyRunType) {
    this.strategyRunType = strategyRunType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy run type id.
   *
   * @param  strategyRunTypeId  Long
   */
  public void setStrategyRunTypeId(Long strategyRunTypeId) {
    this.strategyRunTypeId = strategyRunTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * User data1 to set.
   *
   * @param  userData1  to set
   */
  public void setUserData1(String userData1) {
    this.userData1 = userData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zoom.
   *
   * @param  zoom  String
   */
  public void setZoom(String zoom) {
    if ("actual".equalsIgnoreCase(zoom) || "fit".equalsIgnoreCase(zoom)) {
      this.zoom = zoom;
    } else {
      try {
        BigDecimal dec = new BigDecimal(zoom);
        this.zoom = dec.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
      } catch (Exception e) {
        this.zoom = null;
      }
    }
  }
} // end class BaseStrategy
