package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.domain.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * This class is used to store EnterpriseDocumentAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:23
 */
@Entity public class EnterpriseDocumentAudit extends BasicEnterpriseDocument implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5325284206165498158L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * Action List.
   *
   * <ul>
   *   <li>Create</li>
   *   <li>Update</li>
   *   <li>Delete</li>
   *   <li>Disable</li>
   *   <li>Enable</li>
   *   <li>Publish</li>
   * </ul>
   */
  @Column(length = 255)
  protected String action;


  /** TODO: DOCUMENT ME! */
  @Lob protected String assignedPortfolioIds;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected EnterpriseDocument document;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentVersionId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected EnterpriseDocumentVersion documentVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#addDocumentStatus(com.cmc.credagility.core.domain.document.DocumentStatus,
   *       String, java.util.Date, com.cmc.credagility.core.domain.user.User)
   */
  @Override public void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Date date, User user) {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#addDocumentStatus(com.cmc.credagility.core.domain.document.DocumentStatus,
   *       String, Boolean, java.util.Date, com.cmc.credagility.core.domain.user.User)
   */
  @Override public void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Boolean asDefault,
    Date date, User user) {
    // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#copy()
   */
  @Override public BasicEnterpriseDocument copy() {
    EnterpriseDocumentAudit audit = new EnterpriseDocumentAudit();
    paste(audit);

    return audit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  document  EnterpriseDocument
   */
  public void copyFrom(EnterpriseDocument document) {
    this.setDocument(document);
    this.setAllowLetter(document.getAllowLetter());
    this.setAllowSMS(document.getAllowSMS());
    this.setAllowEmail(document.getAllowEmail());
    this.setAllowDisclosure(document.getAllowDisclosure());
    this.setAllowWorkflow(document.getAllowWorkflow());
    this.setAllowDocumentContent(document.getAllowDocumentContent());
    this.setContentMode(document.getContentMode());
    this.setDescription(document.getDescription());
    this.setName(document.getName());
    this.setHotSpot(document.getHotSpot());
    this.setMailFrom(document.getMailFrom());
    this.setMailSubject(document.getMailSubject());
    this.setVersion(document.getVersion());
    this.setContextType(document.getContextType());
    this.setCategory(document.getCategory());
    this.setAssignedPortfolioIds(document.getAssignedPortfolioIds());
    this.setAllowDialer(document.getAllowDialer());
    this.setAllowIVR(document.getAllowIVR());
    this.setFriendlyName(document.getFriendlyName());
    this.setReplyToEmail(document.getReplyToEmail());
    this.setUniqueId(document.getUniqueId());
    this.setBcMetaDataField(document.getBcMetaDataField());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    EnterpriseDocumentAudit that = (EnterpriseDocumentAudit) o;

    if (!action.equals(that.action)) {
      return false;
    }

    if (!document.equals(that.document)) {
      return false;
    }

    if (!documentVersion.equals(that.documentVersion)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAssignedPortfolioIds() {
    return assignedPortfolioIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#getContent(com.cmc.credagility.core.domain.type.LocaleType)
   */
  @Override public BasicEnterpriseDocumentTemplate getContent(LocaleType localeType) {
    return null; // To change body of implemented methods use File | Settings | File Templates.
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
   * getter method for document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getDocumentVersion() {
    return documentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#getVariable(String)
   */
  @Override public BasicEnterpriseDocumentTemplateVariable getVariable(String variable) {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + document.hashCode();
    result = (31 * result) + documentVersion.hashCode();
    result = (31 * result) + action.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assigned portfolio ids.
   *
   * @param  assignedPortfolioIds  String
   */
  public void setAssignedPortfolioIds(String assignedPortfolioIds) {
    this.assignedPortfolioIds = assignedPortfolioIds;
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
   * setter method for document version.
   *
   * @param  documentVersion  EnterpriseDocumentVersion
   */
  public void setDocumentVersion(EnterpriseDocumentVersion documentVersion) {
    this.documentVersion = documentVersion;
  }
} // end class EnterpriseDocumentAudit
