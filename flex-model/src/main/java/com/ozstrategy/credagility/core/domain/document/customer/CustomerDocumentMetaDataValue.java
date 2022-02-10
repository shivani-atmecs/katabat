package com.ozstrategy.credagility.core.domain.document.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTaskElement;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/08/2017 23:08
 */
@Entity
@Table(name = "CustomerDocumentMetaDataValue")
public class CustomerDocumentMetaDataValue extends DocumentMetaDataValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "documentInstanceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerDocumentInstance documentInstance;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "elementId",
    nullable  = true,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement element;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getDocumentInstance()
   */
  @Override public CustomerDocumentInstance getDocumentInstance() {
    return documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element.
   *
   * @return  CustomerWorkflowTaskElement
   */
  public CustomerWorkflowTaskElement getElement() {
    return element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getOwner()
   */
  @Override public Object getOwner() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    if (businessObject instanceof CustomerWorkflowBusinessObject) {
      setCustomer(((CustomerWorkflowBusinessObject) businessObject).getCustomer());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  documentInstance  DOCUMENT ME!
   */
  public void setDocumentInstance(CustomerDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  element  DOCUMENT ME!
   */
  public void setElement(CustomerWorkflowTaskElement element) {
    this.element = element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setElementForMetaData(Object)
   */
  @Override public void setElementForMetaData(Object obj) {
    setElement((CustomerWorkflowTaskElement) obj);
  }
} // end class CustomerDocumentMetaDataValue
