package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:59
 */
public class UpdateCommunicationPreferenceActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8534758740564038772L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String  communicationName;
  private Boolean newPreference;
  private Boolean oldPreference;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for communication name.
   *
   * @return  String
   */
  public String getCommunicationName() {
    return communicationName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new preference.
   *
   * @return  Boolean
   */
  public Boolean getNewPreference() {
    return newPreference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old preference.
   *
   * @return  Boolean
   */
  public Boolean getOldPreference() {
    return oldPreference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for communication name.
   *
   * @param  communicationName  String
   */
  public void setCommunicationName(String communicationName) {
    this.communicationName = communicationName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new preference.
   *
   * @param  newPreference  Boolean
   */
  public void setNewPreference(Boolean newPreference) {
    this.newPreference = newPreference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old preference.
   *
   * @param  oldPreference  Boolean
   */
  public void setOldPreference(Boolean oldPreference) {
    this.oldPreference = oldPreference;
  }

} // end class UpdateCommunicationPreferenceActivity
