package com.cmc.credagility.core.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * Created by wangy on 12/12/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  12/12/2014 00:48 AM
 */
public class LoginResponsible extends User {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String displayName;
  private String password;
  private Long   responsibleId;
  private String userLogon;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new LoginResponsible object.
   *
   * @param  responsible  Responsible
   */
  public LoginResponsible(Responsible responsible) {
    super(responsible.getUserLogon(), responsible.getPassword(), true, true, true, true, Collections.emptySet());
    this.responsibleId = responsible.getResponsibleId();
    this.userLogon     = responsible.getUserLogon();
    this.password      = responsible.getPassword();
    this.displayName   = responsible.getFullName();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#getPassword()
   */
  @Override public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id.
   *
   * @return  Long
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user logon.
   *
   * @return  String
   */
  public String getUserLogon() {
    return userLogon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible id.
   *
   * @param  responsibleId  Long
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user logon.
   *
   * @param  userLogon  String
   */
  public void setUserLogon(String userLogon) {
    this.userLogon = userLogon;
  }
} // end class LoginResponsible
