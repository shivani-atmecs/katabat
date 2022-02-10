package com.ozstrategy.credagility.core.domain.accountAlert;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.dynamicview.ContextObject;
import com.ozstrategy.credagility.core.domain.type.HotSpotAlertStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * HotSpot Alert!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 16:51
 */
@Entity
@Table(name = "HotSpotAlert")
public class HotSpotAlert extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2963935852847297080L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** HotSpot Alert window is always show. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean alwaysShow;

  /** Context Object. */
  @Embedded protected ContextObject contextObject = new ContextObject();

  /** show the HotSpot Alert window criteria. */
  @Column(
    name             = "criteria",
    nullable         = true,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String criteria;

  /** TODO: DOCUMENT ME! */
  @Column(name = "disabledDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date        disabledDate;

  /** the HotSpot Alert window displayTime. */
  @Column protected Long displayTime;


  /** document. */
  @JoinColumn(
    name     = "documentId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;

  /** TODO: DOCUMENT ME! */
  @Column(name = "enabledDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date               enabledDate;


  /** Enterprise HotSpot. */
  @JoinColumn(
    name     = "hotSpotId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseHotSpot              hotSpot;

  /** TODO: DOCUMENT ME! */
  @OneToMany(mappedBy = "notificationMessage")
  protected List<NotificationMessageAudit> hotSpotAudits = new ArrayList<NotificationMessageAudit>();


  /** PK. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** HotSpotAlert name. */
  @Column(
    nullable = false,
    length   = 64
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 1;


  /** HotSpotAlert Status. */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected HotSpotAlertStatus status = HotSpotAlertStatus.ENABLE;


  /** HotSpotAlert Instance. */
  @OneToMany(mappedBy = "hotSpotAlert")
  List<HotSpotAlertInstance> instances = new ArrayList<HotSpotAlertInstance>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for always show.
   *
   * @return  Boolean
   */
  public Boolean getAlwaysShow() {
    if (null == alwaysShow) {
      return Boolean.FALSE;
    }

    return alwaysShow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context object.
   *
   * @return  ContextObject
   */
  public ContextObject getContextObject() {
    return contextObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disabled date.
   *
   * @return  Date
   */
  public Date getDisabledDate() {
    return disabledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display time.
   *
   * @return  Long
   */
  public Long getDisplayTime() {
    return displayTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getDocument() {
    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enabled date.
   *
   * @return  Date
   */
  public Date getEnabledDate() {
    return enabledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot.
   *
   * @return  EnterpriseHotSpot
   */
  public EnterpriseHotSpot getHotSpot() {
    return hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot audits.
   *
   * @return  List
   */
  public List<NotificationMessageAudit> getHotSpotAudits() {
    return hotSpotAudits;
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
   * getter method for instances.
   *
   * @return  List
   */
  public List<HotSpotAlertInstance> getInstances() {
    return instances;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  HotSpotAlertStatus
   */
  public HotSpotAlertStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for always show.
   *
   * @param  alwaysShow  Boolean
   */
  public void setAlwaysShow(Boolean alwaysShow) {
    this.alwaysShow = alwaysShow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context object.
   *
   * @param  contextObject  ContextObject
   */
  public void setContextObject(ContextObject contextObject) {
    this.contextObject = contextObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disabled date.
   *
   * @param  disabledDate  Date
   */
  public void setDisabledDate(Date disabledDate) {
    this.disabledDate = disabledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display time.
   *
   * @param  displayTime  Long
   */
  public void setDisplayTime(Long displayTime) {
    this.displayTime = displayTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document.
   *
   * @param  document  EnterpriseDocument
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enabled date.
   *
   * @param  enabledDate  Date
   */
  public void setEnabledDate(Date enabledDate) {
    this.enabledDate = enabledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot.
   *
   * @param  hotSpot  EnterpriseHotSpot
   */
  public void setHotSpot(EnterpriseHotSpot hotSpot) {
    this.hotSpot = hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot audits.
   *
   * @param  hotSpotAudits  List
   */
  public void setHotSpotAudits(List<NotificationMessageAudit> hotSpotAudits) {
    this.hotSpotAudits = hotSpotAudits;
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
   * setter method for instances.
   *
   * @param  instances  List
   */
  public void setInstances(List<HotSpotAlertInstance> instances) {
    this.instances = instances;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  HotSpotAlertStatus
   */
  public void setStatus(HotSpotAlertStatus status) {
    this.status = status;
  }
} // end class HotSpotAlert
