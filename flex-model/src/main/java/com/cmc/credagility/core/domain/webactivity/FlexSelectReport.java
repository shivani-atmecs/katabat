package com.cmc.credagility.core.domain.webactivity;

import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:47
 */
public class FlexSelectReport implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 9143414810213077877L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String Existing_Accounts_Updated;
  private String Existing_Balances_Updated;
  private String New_Accounts;
  private String New_Balances;
  private String Population;
  private String Total_Accounts;
  private String Total_Balances;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    FlexSelectReport that = (FlexSelectReport) o;

    if ((Existing_Accounts_Updated != null) ? (!Existing_Accounts_Updated.equals(that.Existing_Accounts_Updated))
                                            : (that.Existing_Accounts_Updated != null)) {
      return false;
    }

    if ((Existing_Balances_Updated != null) ? (!Existing_Balances_Updated.equals(that.Existing_Balances_Updated))
                                            : (that.Existing_Balances_Updated != null)) {
      return false;
    }

    if ((New_Accounts != null) ? (!New_Accounts.equals(that.New_Accounts)) : (that.New_Accounts != null)) {
      return false;
    }

    if ((New_Balances != null) ? (!New_Balances.equals(that.New_Balances)) : (that.New_Balances != null)) {
      return false;
    }

    if ((Population != null) ? (!Population.equals(that.Population)) : (that.Population != null)) {
      return false;
    }

    if ((Total_Accounts != null) ? (!Total_Accounts.equals(that.Total_Accounts)) : (that.Total_Accounts != null)) {
      return false;
    }

    if ((Total_Balances != null) ? (!Total_Balances.equals(that.Total_Balances)) : (that.Total_Balances != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for existing accounts updated.
   *
   * @return  String
   */
  public String getExisting_Accounts_Updated() {
    return Existing_Accounts_Updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for existing balances updated.
   *
   * @return  String
   */
  public String getExisting_Balances_Updated() {
    return Existing_Balances_Updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new accounts.
   *
   * @return  String
   */
  public String getNew_Accounts() {
    return New_Accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new balances.
   *
   * @return  String
   */
  public String getNew_Balances() {
    return New_Balances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for population.
   *
   * @return  String
   */
  public String getPopulation() {
    return Population;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total accounts.
   *
   * @return  String
   */
  public String getTotal_Accounts() {
    return Total_Accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total balances.
   *
   * @return  String
   */
  public String getTotal_Balances() {
    return Total_Balances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (Existing_Accounts_Updated != null) ? Existing_Accounts_Updated.hashCode() : 0;
    result = (31 * result) + ((Existing_Balances_Updated != null) ? Existing_Balances_Updated.hashCode() : 0);
    result = (31 * result) + ((New_Accounts != null) ? New_Accounts.hashCode() : 0);
    result = (31 * result) + ((New_Balances != null) ? New_Balances.hashCode() : 0);
    result = (31 * result) + ((Population != null) ? Population.hashCode() : 0);
    result = (31 * result) + ((Total_Accounts != null) ? Total_Accounts.hashCode() : 0);
    result = (31 * result) + ((Total_Balances != null) ? Total_Balances.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for existing accounts updated.
   *
   * @param  existing_Accounts_Updated  String
   */
  public void setExisting_Accounts_Updated(String existing_Accounts_Updated) {
    Existing_Accounts_Updated = existing_Accounts_Updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for existing balances updated.
   *
   * @param  existing_Balances_Updated  String
   */
  public void setExisting_Balances_Updated(String existing_Balances_Updated) {
    Existing_Balances_Updated = existing_Balances_Updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new accounts.
   *
   * @param  new_Accounts  String
   */
  public void setNew_Accounts(String new_Accounts) {
    New_Accounts = new_Accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new balances.
   *
   * @param  new_Balances  String
   */
  public void setNew_Balances(String new_Balances) {
    New_Balances = new_Balances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for population.
   *
   * @param  population  String
   */
  public void setPopulation(String population) {
    Population = population;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total accounts.
   *
   * @param  total_Accounts  String
   */
  public void setTotal_Accounts(String total_Accounts) {
    Total_Accounts = total_Accounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total balances.
   *
   * @param  total_Balances  String
   */
  public void setTotal_Balances(String total_Balances) {
    Total_Balances = total_Balances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "FlexSelectReport{"
      + "Existing_Accounts_Updated='" + Existing_Accounts_Updated + '\''
      + ", Existing_Balances_Updated='" + Existing_Balances_Updated + '\''
      + ", New_Accounts='" + New_Accounts + '\''
      + ", New_Balances='" + New_Balances + '\''
      + ", Population='" + Population + '\''
      + ", Total_Accounts='" + Total_Accounts + '\''
      + ", Total_Balances='" + Total_Balances + '\''
      + '}';
  }
} // end class FlexSelectReport
