package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.account.AccountExportLayout;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/09/2017 17:27
 */
@Entity
@Table(name = "CustomerWorkflowNodeAccountSelectorAction")
public class CustomerWorkflowNodeAccountSelectorAction extends CustomerWorkflowNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8032129776916100686L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node . */
  @JoinColumn(
    name       = "accountExportLayoutId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountExportLayout accountExportLayout = new AccountExportLayout();

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  CustomerWorkflowNodeAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    CustomerWorkflowNodeAccountSelectorAction that = (CustomerWorkflowNodeAccountSelectorAction) o;

    if ((accountExportLayout != null) ? (!accountExportLayout.equals(that.accountExportLayout))
                                      : (that.accountExportLayout != null)) {
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
  public AccountExportLayout getAccountExportLayout() {
    return accountExportLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.getAccountExportLayout() != null) {
      return this.getAccountExportLayout().getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  CustomerWorkflowNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((accountExportLayout != null) ? accountExportLayout.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account export layout.
   *
   * @param  accountExportLayout  AccountExportLayout
   */
  public void setAccountExportLayout(AccountExportLayout accountExportLayout) {
    this.accountExportLayout = accountExportLayout;
  }
} // end class CustomerWorkflowNodeAccountSelectorAction
