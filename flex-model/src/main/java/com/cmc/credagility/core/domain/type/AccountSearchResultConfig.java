package com.cmc.credagility.core.domain.type;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:12
 */
public class AccountSearchResultConfig {
  //~ Enums ------------------------------------------------------------------------------------------------------------

  /**
   * TODO: DOCUMENT ME!
   *
   * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
   * @version  10/16/2014 14:12
   */
  public enum AccountSearchType {
    //~ Enum constants -------------------------------------------------------------------------------------------------

    SSN, RefNum, OAN, PhoneNum, LF, LZ, LO, LS, Mixed;

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * toType.
     *
     * @param   strValue  String
     *
     * @return  AccountSearchType
     */
    public static AccountSearchType toType(String strValue) {
      try {
        return valueOf(strValue.toUpperCase());
      } catch (Exception e) {
        return null;
      }

    }
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Integer           resultCount;
  private AccountSearchType searchType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountSearchResultConfig object.
   */
  public AccountSearchResultConfig() { }

  /**
   * Creates a new AccountSearchResultConfig object.
   *
   * @param  resultCount  DOCUMENT ME!
   * @param  searchType   DOCUMENT ME!
   */
  public AccountSearchResultConfig(Integer resultCount, AccountSearchType searchType) {
    this.resultCount = resultCount;
    this.searchType  = searchType;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for result count.
   *
   * @return  Integer
   */
  public Integer getResultCount() {
    return resultCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search type.
   *
   * @return  AccountSearchType
   */
  public AccountSearchType getSearchType() {
    return searchType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result count.
   *
   * @param  resultCount  Integer
   */
  public void setResultCount(Integer resultCount) {
    this.resultCount = resultCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search type.
   *
   * @param  searchType  AccountSearchType
   */
  public void setSearchType(AccountSearchType searchType) {
    this.searchType = searchType;
  }
} // end class AccountSearchResultConfig
