package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.businesscontext.BCMetaDataField;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.document.DocumentCategory;
import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * EnterpriseDocument Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:39
 */
@MappedSuperclass public abstract class BasicEnterpriseDocument extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3686082353898234504L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDialer;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDisclosure;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowDocumentContent;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEmail;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowIVR;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowLetter;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSMS;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowWorkflow;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "bcMetaDataFieldId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCMetaDataField bcMetaDataField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "businessContextId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentCategoryId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected DocumentCategory category;

  /** The content mode can be: HTML/PDF. Default is HTML. */
  @Column protected String contentMode;

  /** Account Agency Agent. */
  @Column(
    name   = "contextType",
    length = 32
  )
  protected String contextType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "friendlyName",
    length = 255
  )
  protected String friendlyName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "hotSpotId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseHotSpot hotSpot;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String mailFrom;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String mailSubject;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "name",
    length   = 50,
    nullable = false
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "replyToEmail",
    length = 255
  )
  protected String replyToEmail;

  /** DOCUMENT ME! */
  @Column(
    name   = "uniqueId",
    length = 255
  )
  protected String uniqueId;

  /** TODO: DOCUMENT ME! */
  @Column protected Long version = 0L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addDocumentStatus.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   * @param  date            Date
   * @param  user            User
   */
  public abstract void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Date date, User user);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDocumentStatus.
   *
   * @param  documentStatus  DocumentStatus
   * @param  flowPosition    String
   * @param  asDefault       Boolean
   * @param  date            Date
   * @param  user            User
   */
  public abstract void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Boolean asDefault,
    Date date, User user);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  BasicEnterpriseDocument
   */
  public abstract BasicEnterpriseDocument copy();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @param   localeType  LocaleType
   *
   * @return  BasicEnterpriseDocumentTemplate
   */
  public abstract BasicEnterpriseDocumentTemplate getContent(LocaleType localeType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @param   variable  String
   *
   * @return  BasicEnterpriseDocumentTemplateVariable
   */
  public abstract BasicEnterpriseDocumentTemplateVariable getVariable(String variable);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    BasicEnterpriseDocument that = (BasicEnterpriseDocument) o;

    if ((contentMode != null) ? (!contentMode.equals(that.contentMode)) : (that.contentMode != null)) {
      return false;
    }

    if ((contextType != null) ? (!contextType.equals(that.contextType)) : (that.contextType != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return (uniqueId != null) ? uniqueId.equals(that.uniqueId) : (that.uniqueId == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * generateUniqueId.
   */
  public void generateUniqueId() {
    String uniqueString = this.getName() + "-" + new Date();
    int    uniqueCode   = uniqueString.hashCode();
    uniqueCode = (uniqueCode > 0) ? uniqueCode : (0 - uniqueCode);
    this.setUniqueId("" + uniqueCode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow dialer.
   *
   * @return  Boolean
   */
  public Boolean getAllowDialer() {
    if (allowDialer == null) {
      return Boolean.FALSE;
    }

    return allowDialer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow disclosure.
   *
   * @return  Boolean
   */
  public Boolean getAllowDisclosure() {
    if (allowDisclosure == null) {
      return Boolean.FALSE;
    }

    return allowDisclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow document content.
   *
   * @return  Boolean
   */
  public Boolean getAllowDocumentContent() {
    if (allowDocumentContent == null) {
      return Boolean.FALSE;
    }

    return allowDocumentContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow email.
   *
   * @return  Boolean
   */
  public Boolean getAllowEmail() {
    if (allowEmail == null) {
      return Boolean.FALSE;
    }

    return allowEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow IVR.
   *
   * @return  Boolean
   */
  public Boolean getAllowIVR() {
    if (allowIVR == null) {
      return Boolean.FALSE;
    }

    return allowIVR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow letter.
   *
   * @return  Boolean
   */
  public Boolean getAllowLetter() {
    if (allowLetter == null) {
      return Boolean.FALSE;
    }

    return allowLetter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow SMS.
   *
   * @return  Boolean
   */
  public Boolean getAllowSMS() {
    if (allowSMS == null) {
      return Boolean.FALSE;
    }

    return allowSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow workflow.
   *
   * @return  Boolean
   */
  public Boolean getAllowWorkflow() {
    if (allowWorkflow == null) {
      return Boolean.FALSE;
    }

    return allowWorkflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc meta data field.
   *
   * @return  BCMetaDataField
   */
  public BCMetaDataField getBcMetaDataField() {
    return bcMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  DocumentCategory
   */
  public DocumentCategory getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel name.
   *
   * @return  String
   */
  public String getChannelName() {
    StringBuffer sb = new StringBuffer();

    if (getAllowDialer()) {
      sb.append(",").append("Dialer");
    }

    if (getAllowIVR()) {
      sb.append(",").append("IVR");
    }

    if (getAllowSMS()) {
      sb.append(",").append("SMS");
    }

    if (getAllowLetter()) {
      sb.append(", ").append("Letter");
    }

    if (getAllowEmail()) {
      sb.append(", ").append("Email");
    }

    if (getAllowDisclosure()) {
      sb.append(", ").append("Disclosure");
    }

    if (getAllowWorkflow()) {
      sb.append(", ").append("Workflow");
    }

    return (sb.length() > 1) ? sb.substring(1) : null;
  } // end method getChannelName

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content mode.
   *
   * @return  String
   */
  public String getContentMode() {
    return contentMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context type.
   *
   * @return  String
   */
  public String getContextType() {
    return contextType;
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
   * getter method for friendly name.
   *
   * @return  String
   */
  public String getFriendlyName() {
    return friendlyName;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail from.
   *
   * @return  String
   */
  public String getMailFrom() {
    return mailFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail subject.
   *
   * @return  String
   */
  public String getMailSubject() {
    return mailSubject;
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
   * getter method for reply to email.
   *
   * @return  String
   */
  public String getReplyToEmail() {
    return replyToEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique id.
   *
   * @return  String
   */
  public String getUniqueId() {
    return uniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Long
   */
  public Long getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contentMode != null) ? contentMode.hashCode() : 0);
    result = (31 * result) + ((contextType != null) ? contextType.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((uniqueId != null) ? uniqueId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow dialer.
   *
   * @param  allowDialer  Boolean
   */
  public void setAllowDialer(Boolean allowDialer) {
    this.allowDialer = allowDialer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow disclosure.
   *
   * @param  allowDisclosure  Boolean
   */
  public void setAllowDisclosure(Boolean allowDisclosure) {
    this.allowDisclosure = allowDisclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow document content.
   *
   * @param  allowDocumentContent  Boolean
   */
  public void setAllowDocumentContent(Boolean allowDocumentContent) {
    this.allowDocumentContent = allowDocumentContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow email.
   *
   * @param  allowEmail  Boolean
   */
  public void setAllowEmail(Boolean allowEmail) {
    this.allowEmail = allowEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow IVR.
   *
   * @param  allowIVR  Boolean
   */
  public void setAllowIVR(Boolean allowIVR) {
    this.allowIVR = allowIVR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow letter.
   *
   * @param  allowLetter  Boolean
   */
  public void setAllowLetter(Boolean allowLetter) {
    this.allowLetter = allowLetter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow SMS.
   *
   * @param  allowSMS  Boolean
   */
  public void setAllowSMS(Boolean allowSMS) {
    this.allowSMS = allowSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow workflow.
   *
   * @param  allowWorkflow  Boolean
   */
  public void setAllowWorkflow(Boolean allowWorkflow) {
    this.allowWorkflow = allowWorkflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc meta data field.
   *
   * @param  bcMetaDataField  BCMetaDataField
   */
  public void setBcMetaDataField(BCMetaDataField bcMetaDataField) {
    this.bcMetaDataField = bcMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  DocumentCategory
   */
  public void setCategory(DocumentCategory category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content mode.
   *
   * @param  contentMode  String
   */
  public void setContentMode(String contentMode) {
    this.contentMode = contentMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context type.
   *
   * @param  contextType  String
   */
  public void setContextType(String contextType) {
    if (ContextType.RESPONSIBLE.toString().equalsIgnoreCase(contextType)
          || ContextType.PORTFOLIO.toString().equalsIgnoreCase(contextType)) {
      this.contextType = ContextType.ACCOUNT.toString().toLowerCase();
    } else {
      this.contextType = contextType;
    }
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
   * setter method for friendly name.
   *
   * @param  friendlyName  String
   */
  public void setFriendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail from.
   *
   * @param  mailFrom  String
   */
  public void setMailFrom(String mailFrom) {
    this.mailFrom = mailFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail subject.
   *
   * @param  mailSubject  String
   */
  public void setMailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
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
   * setter method for reply to email.
   *
   * @param  replyToEmail  String
   */
  public void setReplyToEmail(String replyToEmail) {
    this.replyToEmail = replyToEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique id.
   *
   * @param  uniqueId  String
   */
  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Long
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  document  BasicEnterpriseDocument
   */
  protected void paste(BasicEnterpriseDocument document) {
    document.setName(this.name);
    document.setDescription(this.description);
    document.setAllowDocumentContent(this.allowDocumentContent);
    document.setContentMode(this.contentMode);
    document.setHotSpot(hotSpot);
    document.setMailFrom(mailFrom);
    document.setMailSubject(mailSubject);
    document.setAllowSMS(getAllowSMS());
    document.setAllowLetter(getAllowLetter());
    document.setAllowEmail(getAllowEmail());
    document.setAllowDisclosure(getAllowDisclosure());
    document.setAllowWorkflow(getAllowWorkflow());
    document.setContextType(this.contextType);
    document.setAllowDialer(getAllowDialer());
    document.setAllowIVR(getAllowIVR());
    document.setFriendlyName(getFriendlyName());
    document.setReplyToEmail(getReplyToEmail());
    document.setBusinessContext(getBusinessContext());
    document.setBcMetaDataField(this.getBcMetaDataField());
    document.setUniqueId(getUniqueId());
  }
} // end class BasicEnterpriseDocument
