package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.webactivity.SynchronousMQCallStatus;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 09:21
 */
@Entity
@Table(name = "TsysEventRequestHistory")
public class TsysEventRequestHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8172430786452886139L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "cacheExpired",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean cacheExpired = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(name = "dateFrom")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateFrom;


  /** TODO: DOCUMENT ME! */
  @Column(name = "dateTo")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dateTo;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "eventType",
    length = 30
  )
  protected String eventType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "historical",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "synchronousMQCallStatusId")
  @OneToOne(fetch = FetchType.LAZY)
  protected SynchronousMQCallStatus synchronousMQCallStatus;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "tsysEventRequestHistoryId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysEventRequestHistoryId;

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

    TsysEventRequestHistory tsysEventRequestHistory = (TsysEventRequestHistory) o;

    if (!dateFrom.equals(tsysEventRequestHistory.getDateFrom())) {
      return false;
    }

    if (!dateTo.equals(tsysEventRequestHistory.getDateFrom())) {
      return false;
    }

    if (!eventType.equals(tsysEventRequestHistory.getEventType())) {
      return false;
    }

    if (!synchronousMQCallStatus.equals(tsysEventRequestHistory.getSynchronousMQCallStatus())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cache expired.
   *
   * @return  Boolean
   */
  public Boolean getCacheExpired() {
    if (cacheExpired == null) {
      return Boolean.FALSE;
    }

    return cacheExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date from.
   *
   * @return  Date
   */
  public Date getDateFrom() {
    return dateFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date to.
   *
   * @return  Date
   */
  public Date getDateTo() {
    return dateTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event type.
   *
   * @return  String
   */
  public String getEventType() {
    return eventType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (historical == null) {
      return Boolean.FALSE;
    }

    return historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for synchronous MQCall status.
   *
   * @return  SynchronousMQCallStatus
   */
  public SynchronousMQCallStatus getSynchronousMQCallStatus() {
    return synchronousMQCallStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys event request history id.
   *
   * @return  Long
   */
  public Long getTsysEventRequestHistoryId() {
    return tsysEventRequestHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((dateFrom != null) ? dateFrom.hashCode() : 0);
    result = (31 * result) + ((dateTo != null) ? dateTo.hashCode() : 0);
    result = (31 * result) + ((eventType != null) ? eventType.hashCode() : 0);
    result = (31 * result) + ((synchronousMQCallStatus != null) ? synchronousMQCallStatus.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cache expired.
   *
   * @param  cacheExpired  Boolean
   */
  public void setCacheExpired(Boolean cacheExpired) {
    this.cacheExpired = cacheExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date from.
   *
   * @param  dateFrom  Date
   */
  public void setDateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date to.
   *
   * @param  dateTo  Date
   */
  public void setDateTo(Date dateTo) {
    this.dateTo = dateTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event type.
   *
   * @param  eventType  String
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for synchronous MQCall status.
   *
   * @param  synchronousMQCallStatus  SynchronousMQCallStatus
   */
  public void setSynchronousMQCallStatus(SynchronousMQCallStatus synchronousMQCallStatus) {
    this.synchronousMQCallStatus = synchronousMQCallStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys event request history id.
   *
   * @param  tsysEventRequestHistoryId  Long
   */
  public void setTsysEventRequestHistoryId(Long tsysEventRequestHistoryId) {
    this.tsysEventRequestHistoryId = tsysEventRequestHistoryId;
  }


} // end class TsysEventRequestHistory
