package com.ozstrategy.credagility.core.domain.workflow.customer;


import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.domain.document.customer.CustomerDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.customer.CustomerDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.customer.CustomerUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditStep;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/08/2017 22:30
 */
public class CustomerWorkflowBusinessObject extends WorkflowBusinessObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Customer customer;

  private CustomerWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createDocumentInstance()
   */
  @Override public CustomerDocumentInstance createDocumentInstance() {
    return new CustomerDocumentInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createDocumentMetaDataValue()
   */
  @Override public CustomerDocumentMetaDataValue createDocumentMetaDataValue() {
    CustomerDocumentMetaDataValue metaDataValue = new CustomerDocumentMetaDataValue();
    metaDataValue.setCustomer(this.getCustomer());

    return metaDataValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createUploadDocumentBlob()
   */
  @Override public CustomerUploadDocumentBlob createUploadDocumentBlob() {
    return new CustomerUploadDocumentBlob();
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowAuditInstance()
   */
  @Override public BasicWorkflowAuditInstance createWorkflowAuditInstance() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowAuditStep()
   */
  @Override public BasicWorkflowAuditStep createWorkflowAuditStep() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowInstance()
   */
  @Override public CustomerWorkflowInstance createWorkflowInstance() {
    return new CustomerWorkflowInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowSchedule()
   */
  @Override public CustomerWorkflowSchedule createWorkflowSchedule() {
    return new CustomerWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowStep()
   */
  @Override public CustomerWorkflowStep createWorkflowStep() {
    return new CustomerWorkflowStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowTaskElementAnswer()
   */
  @Override public CustomerWorkflowTaskElementAnswer createWorkflowTaskElementAnswer() {
    return new CustomerWorkflowTaskElementAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowTaskElementTempAnswer()
   */
  @Override public CustomerWorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer() {
    CustomerWorkflowTaskElementTempAnswer tempAnswer = new CustomerWorkflowTaskElementTempAnswer();
    tempAnswer.setCustomer(this.getCustomer());

    return tempAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowVariableValue()
   */
  @Override public CustomerWorkflowVariableValue createWorkflowVariableValue() {
    return new CustomerWorkflowVariableValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  @Override public Object getObject() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#getObjectInfo()
   */
  @Override public String getObjectInfo() {
    if (customer != null) {
      return "Customer#" + customer.getCustomerId();
    }

    return "Customer#NULL";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStep getWorkflowStep() {
    return workflowStep;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#setObject(Object)
   */
  @Override public void setObject(Object obj) {
    setCustomer((Customer) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(CustomerWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class CustomerWorkflowBusinessObject
