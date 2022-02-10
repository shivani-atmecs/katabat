package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration;
import com.ozstrategy.credagility.core.domain.decisiontree.BaseTargetAddressTypeConfiguration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * This class is used to store AgencyTargetAddressTypeConfiguration information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:31
 */
@Entity public class AgencyTargetAddressTypeConfiguration extends BaseTargetAddressTypeConfiguration
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6634560873736637689L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelActionId",
    nullable = false
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
    this.addressType = ((AgencyTargetAddressTypeConfiguration) configuration).getAddressType();


    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  AgencyTargetAddressTypeConfiguration
   */
  public AgencyTargetAddressTypeConfiguration duplicate() {
    AgencyTargetAddressTypeConfiguration configuration = new AgencyTargetAddressTypeConfiguration();
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
} // end class AgencyTargetAddressTypeConfiguration
