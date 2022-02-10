package com.ozstrategy.credagility.core.domain.document.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.bci.BCIUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowStep;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/08/2017 23:06
 */
@Entity
@Table(name = "CustomerDocumentInstance")
public class CustomerDocumentInstance extends BasicDocumentInstance implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "documentInstance"
  )
  protected BCIUploadDocumentBlob bciUploadDocumentBlob;

  /** Use serialVersionUID for interoperability. */

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "documentInstance"
  )
  protected Set<CustomerDocumentMetaDataValue> metaDataValues = new HashSet<CustomerDocumentMetaDataValue>();

  /** ResponsibleDocumentInstance. */
  @JoinColumn(
    name      = "previousInstanceId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerDocumentInstance previousInstance;

  /** Ref WorkflowStep. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   metaDataValue  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean addMetaDataValue(CustomerDocumentMetaDataValue metaDataValue) {
    metaDataValue.setDocumentInstance(this);

    return this.metaDataValues.add(metaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#addMetaDataValue(com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue)
   */
  @Override public boolean addMetaDataValue(DocumentMetaDataValue metaDataValue) {
    CustomerDocumentMetaDataValue agencyMetaDataValue = (CustomerDocumentMetaDataValue) metaDataValue;

    return addMetaDataValue(agencyMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#clearAllMetaDataValue()
   */
  @Override public void clearAllMetaDataValue() {
    for (CustomerDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValue.clearValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci upload document blob.
   *
   * @return  BCIUploadDocumentBlob
   */
  public BCIUploadDocumentBlob getBciUploadDocumentBlob() {
    return bciUploadDocumentBlob;
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

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getDocumentMetaDataValues()
   */
  @Override public Map<Long, DocumentMetaDataValue> getDocumentMetaDataValues() {
    Map<Long, DocumentMetaDataValue> metaDataValueMap = new HashMap<Long, DocumentMetaDataValue>();

    for (CustomerDocumentMetaDataValue metaDataValue : metaDataValues) {
      metaDataValueMap.put(metaDataValue.getMetaData().getId(), metaDataValue);
    }

    return metaDataValueMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Set<CustomerDocumentMetaDataValue> getMetaDataValues() {
    return metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getOwner()
   */
  @Override public Object getOwner() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#getPreviousInstance()
   */
  @Override public CustomerDocumentInstance getPreviousInstance() {
    return previousInstance;
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
   * setter method for bci upload document blob.
   *
   * @param  bciUploadDocumentBlob  BCIUploadDocumentBlob
   */
  public void setBciUploadDocumentBlob(BCIUploadDocumentBlob bciUploadDocumentBlob) {
    this.bciUploadDocumentBlob = bciUploadDocumentBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#setBusinessObject(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject)
   */
  @Override public void setBusinessObject(WorkflowBusinessObject businessObject) {
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
   * @param  metaDataValues  DOCUMENT ME!
   */
  public void setMetaDataValues(Set<CustomerDocumentMetaDataValue> metaDataValues) {
    this.metaDataValues = metaDataValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousInstance  DOCUMENT ME!
   */
  public void setPreviousInstance(CustomerDocumentInstance previousInstance) {
    this.previousInstance = previousInstance;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance#updatePreviousInstance(com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance)
   */
  @Override public void updatePreviousInstance(BasicDocumentInstance currentInstance) {
    setPreviousInstance((CustomerDocumentInstance) currentInstance);
  }
} // end class CustomerDocumentInstance
