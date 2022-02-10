package com.ozstrategy.credagility.core.domain.document.enterprise;

import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskElement;

import javax.persistence.*;


/**
 * This class is used to store EnterpriseDocumentMetaDataValue information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 15:00
 */
@Entity
@Table(name = "EnterpriseDocumentMetaDataValue")
public class EnterpriseDocumentMetaDataValue extends DocumentMetaDataValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentInstanceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentInstance documentInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "elementId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement element;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getDocumentInstance()
   */
  @Override public EnterpriseDocumentInstance getDocumentInstance() {
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
  @Override public Object getOwner() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object obj) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instance.
   *
   * @param  documentInstance  EnterpriseDocumentInstance
   */
  public void setDocumentInstance(EnterpriseDocumentInstance documentInstance) {
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
} // end class EnterpriseDocumentMetaDataValue
