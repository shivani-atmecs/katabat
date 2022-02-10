package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:31
 */
public enum UpdatePasswordCode {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  ACCOUNT_LOCKED, // no error
  NO_CHANGE,      // the new password is the same with the old one
  NO_RIGHT,       // no access to change the other's password
  NOT_ALLOW,      // the old password did not match the one in database
  NOT_MATCH,      // Account locked due to too many failure retry
  NOT_STRONG,     // the password is not strong enough
  SUCCESS,        // not allow to change password within a specific period
  USED_BEFORE     // the new password was used before
}
