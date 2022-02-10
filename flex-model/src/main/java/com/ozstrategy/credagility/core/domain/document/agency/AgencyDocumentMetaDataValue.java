package com.ozstrategy.credagility.core.domain.document.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskElement;

import javax.persistence.*;


/**
 * This class is used to store AgencyDocumentMetaDataValue information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:45
 */
@Entity
@Table(name = "AgencyDocumentMetaDataValue")
public class AgencyDocumentMetaDataValue extends DocumentMetaDataValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentInstanceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyDocumentInstance documentInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "elementId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement element;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "agencyId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role owner;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getDocumentInstance()
   */
  @Override public AgencyDocumentInstance getDocumentInstance() {
    return documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element.
   *
   * @return  EnterpriseWorkflowTaskElement
   */
  public EnterpriseWorkflowTaskElement getElement() {
    return element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getOwner()
   */
  @Override public Role getOwner() {
    return owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object obj) {
    setOwner((Role) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instance.
   *
   * @param  documentInstance  AgencyDocumentInstance
   */
  public void setDocumentInstance(AgencyDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element.
   *
   * @param  element  EnterpriseWorkflowTaskElement
   */
  public void setElement(EnterpriseWorkflowTaskElement element) {
    this.element = element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setElementForMetaData(Object)
   */
  @Override public void setElementForMetaData(Object obj) {
    setElement((EnterpriseWorkflowTaskElement) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for owner.
   *
   * @param  owner  Role
   */
  public void setOwner(Role owner) {
    this.owner = owner;
  }
} // end class AgencyDocumentMetaDataValue
