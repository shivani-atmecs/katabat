package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplateVariable;


/**
 * Created by IntelliJ IDEA. User: ysun Date: 7/23/11 Time: 9:27 PM To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class PortfolioChannelTemplateVariableValue extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Value. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob public String value;

  /** EnterpriseDocumentVersionTemplateVariable PK documentVersionTemplateVariableId. */
  @JoinColumn(
    name      = "documentVersionTemplateVariableId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplateVariable enterpriseDocumentVersionTemplateVariable;

  /** PortfolioChannelTemplateVariable PK portfolioChannelTemplateVariableId. */
  @JoinColumn(
    name      = "portfolioChannelTemplateVariableId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioChannelTemplateVariable portfolioChannelTemplateVariable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    PortfolioChannelTemplateVariableValue that = (PortfolioChannelTemplateVariableValue) o;

    if ((enterpriseDocumentVersionTemplateVariable != null)
          ? (!enterpriseDocumentVersionTemplateVariable.equals(that.enterpriseDocumentVersionTemplateVariable))
          : (that.enterpriseDocumentVersionTemplateVariable != null)) {
      return false;
    }

    if ((portfolioChannelTemplateVariable != null)
          ? (!portfolioChannelTemplateVariable.equals(that.portfolioChannelTemplateVariable))
          : (that.portfolioChannelTemplateVariable != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public EnterpriseDocumentVersionTemplateVariable getEnterpriseDocumentVersionTemplateVariable() {
    return enterpriseDocumentVersionTemplateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioChannelTemplateVariable getPortfolioChannelTemplateVariable() {
    return portfolioChannelTemplateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result)
      + ((enterpriseDocumentVersionTemplateVariable != null) ? enterpriseDocumentVersionTemplateVariable.hashCode() : 0);
    result = (31 * result)
      + ((portfolioChannelTemplateVariable != null) ? portfolioChannelTemplateVariable.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enterpriseDocumentVersionTemplateVariable  DOCUMENT ME!
   */
  public void setEnterpriseDocumentVersionTemplateVariable(
    EnterpriseDocumentVersionTemplateVariable enterpriseDocumentVersionTemplateVariable) {
    this.enterpriseDocumentVersionTemplateVariable = enterpriseDocumentVersionTemplateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioChannelTemplateVariable  DOCUMENT ME!
   */
  public void setPortfolioChannelTemplateVariable(PortfolioChannelTemplateVariable portfolioChannelTemplateVariable) {
    this.portfolioChannelTemplateVariable = portfolioChannelTemplateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class PortfolioChannelTemplateVariableValue
