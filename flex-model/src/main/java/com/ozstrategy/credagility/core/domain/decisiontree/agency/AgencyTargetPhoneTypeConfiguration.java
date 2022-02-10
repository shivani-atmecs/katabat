package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration;
import com.ozstrategy.credagility.core.domain.decisiontree.BaseTargetPhoneTypeConfiguration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * This class is used to store AgencyTargetPhoneTypeConfiguration information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:36
 */
@Entity public class AgencyTargetPhoneTypeConfiguration extends BaseTargetPhoneTypeConfiguration
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5683959214003577321L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "channelActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyChannelAction channelAction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param   configuration  TargetBaseTypeConfiguration
   *
   * @return  TargetBaseTypeConfiguration
   */
  @Override public TargetBaseTypeConfiguration copy(TargetBaseTypeConfiguration configuration) {
    super.copy(configuration);
    this.phoneType = ((AgencyTargetPhoneTypeConfiguration) configuration).getPhoneType();

    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  AgencyTargetPhoneTypeConfiguration
   */
  public AgencyTargetPhoneTypeConfiguration duplicate() {
    AgencyTargetPhoneTypeConfiguration configuration = new AgencyTargetPhoneTypeConfiguration();
    configuration.copy(this);

    return configuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action.
   *
   * @return  AgencyChannelAction
   */
  public AgencyChannelAction getChannelAction() {
    return channelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel action.
   *
   * @param  channelAction  AgencyChannelAction
   */
  public void setChannelAction(AgencyChannelAction channelAction) {
    this.channelAction = channelAction;
  }

} // end class AgencyTargetPhoneTypeConfiguration
