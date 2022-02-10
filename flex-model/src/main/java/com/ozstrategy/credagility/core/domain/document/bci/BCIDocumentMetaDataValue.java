package com.ozstrategy.credagility.core.domain.document.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskElement;

import javax.persistence.*;


/**
 * This class is used to store BCIDocumentMetaDataValue information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:54
 */
@Entity
@Table(name = "BCIDocumentMetaDataValue")
public class BCIDocumentMetaDataValue extends DocumentMetaDataValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bciId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentInstanceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIDocumentInstance documentInstance;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "elementId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElement element;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci.
   *
   * @return  BusinessContextInstance
   */
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getDocumentInstance()
   */
  @Override public BCIDocumentInstance getDocumentInstance() {
    return documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element.
   *
   * @return  BCWorkflowTaskElement
   */
  public BCWorkflowTaskElement getElement() {
    return element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getOwner()
   */
  @Override public Object getOwner() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci.
   *
   * @param  bci  BusinessContextInstance
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    if (businessObject instanceof BCIWorkflowBusinessObject) {
      setBci(((BCIWorkflowBusinessObject) businessObject).getBci());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instance.
   *
   * @param  documentInstance  BCIDocumentInstance
   */
  public void setDocumentInstance(BCIDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element.
   *
   * @param  element  BCWorkflowTaskElement
   */
  public void setElement(BCWorkflowTaskElement element) {
    this.element = element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setElementForMetaData(Object)
   */
  @Override public void setElementForMetaData(Object obj) {
    setElement((BCWorkflowTaskElement) obj);
  }
} // end class BCIDocumentMetaDataValue
