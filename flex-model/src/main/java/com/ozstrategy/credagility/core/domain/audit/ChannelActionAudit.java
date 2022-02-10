package com.ozstrategy.credagility.core.domain.audit;

import com.cmc.credagility.core.domain.channel.ChannelVendor;
import com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplate;
import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.ChannelAction;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * ChannelAction Audit statistics.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:10
 */
@Entity public class ChannelActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** multiple /single.* */
  @Column(length = 32)
  protected String channelTargetMethod;


  /** duplicate Count. */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;


  /** end Time. */
  @Column(length = 255)
  protected String endTime;

  /** enterprise Document. */
  @JoinColumn(
    name     = "enterpriseDocumentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument enterpriseDocument;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** audit start Time! */
  @Column(length = 255)
  protected String startTime;

  /** Channel Template Type. */
  @JoinColumn(
    name     = "channelTemplateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioChannelTemplate template;

  /** template Type. */
  @Column(length = 50)
  protected String templateType;


  /** Channe lVendor. */
  @JoinColumn(
    name     = "channelVendorId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelVendor vendor = new ChannelVendor();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ChannelActionAudit object.
   */
  public ChannelActionAudit() { }


  /**
   * Creates a new ChannelActionAudit object.
   *
   * @param  action  ChannelAction
   * @param  type    AuditType
   */
  public ChannelActionAudit(ChannelAction action, AuditType type) {
    super(action, type);
    this.channelTargetMethod = action.getChannelTargetMethod();
    this.duplicateCount      = action.getDuplicateCount();
    this.endTime             = action.getEndTime();
    this.startTime           = action.getStartTime();
    this.template            = action.getTemplate();
    this.enterpriseDocument  = action.getEnterpriseDocument();
    this.templateType        = action.getTemplateType();
    this.vendor              = action.getVendor();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel target method.
   *
   * @return  String
   */
  public String getChannelTargetMethod() {
    return channelTargetMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duplicate count.
   *
   * @return  Integer
   */
  public Integer getDuplicateCount() {
    return duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end time.
   *
   * @return  String
   */
  public String getEndTime() {
    return endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enterprise document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getEnterpriseDocument() {
    return enterpriseDocument;
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
   * getter method for start time.
   *
   * @return  String
   */
  public String getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template.
   *
   * @return  PortfolioChannelTemplate
   */
  public PortfolioChannelTemplate getTemplate() {
    return template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template type.
   *
   * @return  String
   */
  public String getTemplateType() {
    return templateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor.
   *
   * @return  ChannelVendor
   */
  public ChannelVendor getVendor() {
    return vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel target method.
   *
   * @param  channelTargetMethod  String
   */
  public void setChannelTargetMethod(String channelTargetMethod) {
    this.channelTargetMethod = channelTargetMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duplicate count.
   *
   * @param  duplicateCount  Integer
   */
  public void setDuplicateCount(Integer duplicateCount) {
    this.duplicateCount = duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end time.
   *
   * @param  endTime  String
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enterprise document.
   *
   * @param  enterpriseDocument  EnterpriseDocument
   */
  public void setEnterpriseDocument(EnterpriseDocument enterpriseDocument) {
    this.enterpriseDocument = enterpriseDocument;
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
   * setter method for start time.
   *
   * @param  startTime  String
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template.
   *
   * @param  template  PortfolioChannelTemplate
   */
  public void setTemplate(PortfolioChannelTemplate template) {
    this.template = template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template type.
   *
   * @param  templateType  String
   */
  public void setTemplateType(String templateType) {
    this.templateType = templateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  ChannelVendor
   */
  public void setVendor(ChannelVendor vendor) {
    this.vendor = vendor;
  }
} // end class ChannelActionAudit
