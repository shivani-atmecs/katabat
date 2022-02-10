package com.cmc.credagility.core.domain.businesscontext;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.domain.workflow.ContextType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:38
 */
@DiscriminatorValue("BusinessContext")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BCVariable extends BaseVariable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  bcMetaDataField  BCMetaDataField
   */
  public void update(BCMetaDataField bcMetaDataField) {
    this.setCreateDate(new Date());
    this.setBuildType("eval");
    this.setBusinessDataType(bcMetaDataField.getBusinessDataType());
    this.setCategory("bcField");
    this.setContext(ContextType.BUSINESS.name().toLowerCase());
    this.setDataType(bcMetaDataField.getType().getStrValue());
    this.setDescription(bcMetaDataField.getDescription());
    this.setDisplayName(bcMetaDataField.getDisplayName());
    this.setExpression("evalManager.getBCIMetaFieldValue(\"" + bcMetaDataField.getFieldName() + "\")");
    this.setLocked(false);
    this.setName(bcMetaDataField.getFieldName());
    this.setBusinessContext(bcMetaDataField.getBusinessContext());
  }

} // end class BCVariable
