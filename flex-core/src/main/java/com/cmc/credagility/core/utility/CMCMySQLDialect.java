package com.cmc.credagility.core.utility;

import org.hibernate.dialect.MySQL5Dialect;


/**
 * Created with IntelliJ IDEA. User: knandyala Date: 3/15/15 Time: 4:03 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class CMCMySQLDialect extends MySQL5Dialect {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.hibernate.dialect.Dialect#dropConstraints()
   */
  @Override public boolean dropConstraints() {
    // We don't need to drop constraints before dropping tables, that just
    // leads to error messages about missing tables when we don't have a
    // schema in the database
    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.hibernate.dialect.Dialect#getDropSequenceString(String)
   */
  @Override public String getDropSequenceString(String sequenceName) {
    // Adding the &quot;if exists&quot; clause to avoid warnings
    return "drop sequence if exists " + sequenceName;
  }
}
