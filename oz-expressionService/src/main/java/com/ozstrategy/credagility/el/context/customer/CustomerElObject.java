package com.ozstrategy.credagility.el.context.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.el.ElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class CustomerElObject extends ElObject<CustomerElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Customer customer;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CustomerElContext object.
   */
  public CustomerElObject() { }

  /**
   * Creates a new CustomerElContext object.
   *
   * @param  customer  DOCUMENT ME!
   */
  public CustomerElObject(Customer customer) {
    this.customer = customer;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#createContext()
   */
  @Override public CustomerElContext createContext() {
    CustomerElContext context = new CustomerElContext();
    context.setCustomer(customer);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "customer" + getCustomerId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCustomerId() {
    if (customer != null) {
      return customer.getCustomerId();
    }

    return null;
  }
} // end class CustomerElObject
