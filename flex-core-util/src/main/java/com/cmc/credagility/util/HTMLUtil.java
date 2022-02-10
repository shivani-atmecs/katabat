package com.cmc.credagility.util;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 16:55
 */
public class HTMLUtil {
  //~ Enums ------------------------------------------------------------------------------------------------------------

  /**
   * TODO: DOCUMENT ME!
   *
   * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
   * @version  10/23/2014 16:55
   */
  public enum HtmlSymbol {
    //~ Enum constants -------------------------------------------------------------------------------------------------

    SINGLE_QUOTE(1, "'", "&#39;"), DOUBLE_QUOTE(2, "\"", "&#34;"), BACKSLASH(4, "\\\\", "&#92;"),
    LESS_THAN_SIGN(8, "<", "&#60;"), GREATER_THAN_SIGN(16, ">", "&#62;");

    //~ Instance fields ------------------------------------------------------------------------------------------------

    /** TODO: DOCUMENT ME! */
    public int     code;
    private String htmlNumber;
    private String symbol;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new HtmlSymbol object.
     *
     * @param  code        int
     * @param  symbol      String
     * @param  htmlNumber  String
     */
    HtmlSymbol(int code, String symbol, String htmlNumber) {
      this.code       = code;
      this.symbol     = symbol;
      this.htmlNumber = htmlNumber;
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * getter method for code.
     *
     * @return  int
     */
    public int getCode() {
      return code;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    /**
     * getter method for html number.
     *
     * @return  String
     */
    public String getHtmlNumber() {
      return htmlNumber;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    /**
     * getter method for symbol.
     *
     * @return  String
     */
    public String getSymbol() {
      return symbol;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    /**
     * setter method for code.
     *
     * @param  code  int
     */
    public void setCode(int code) {
      this.code = code;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    /**
     * setter method for html number.
     *
     * @param  htmlNumber  String
     */
    public void setHtmlNumber(String htmlNumber) {
      this.htmlNumber = htmlNumber;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    /**
     * setter method for symbol.
     *
     * @param  symbol  String
     */
    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * escape.
   *
   * @param   str  String
   *
   * @return  String
   */
  public static String escape(String str) {
    int type = 0;

    for (HtmlSymbol htmlSymbol : HtmlSymbol.values()) {
      type += htmlSymbol.code;
    }

    return escape(str, type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * escape.
   *
   * @param   str    String
   * @param   types  int
   *
   * @return  String
   */
  public static String escape(String str, int types) {
    for (HtmlSymbol htmlSymbol : HtmlSymbol.values()) {
      if ((types & htmlSymbol.code) == htmlSymbol.code) {
        str = str.replaceAll(htmlSymbol.getSymbol(), htmlSymbol.getHtmlNumber());
      }
    }

    return str;
  }
} // end class HTMLUtil
