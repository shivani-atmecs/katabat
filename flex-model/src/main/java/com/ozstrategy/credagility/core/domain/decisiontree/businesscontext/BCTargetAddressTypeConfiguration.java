package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration;
import com.ozstrategy.credagility.core.domain.decisiontree.BaseTargetAddressTypeConfiguration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * This class is used to store BCTargetAddressTypeConfiguration information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:13
 */
@Entity public class BCTargetAddressTypeConfiguration extends BaseTargetAddressTypeConfiguration
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6209596431752103842L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelActionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCChannelAction channelAction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration#copy(com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration)
   */
  @Override public TargetBaseTypeConfiguration copy(TargetBaseTypeConfiguration configuration) {
    super.copy(configuration);
    this.addressType = ((BCTargetAddressTypeConfiguration) configuration).getAddressType();


    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BCTargetAddressTypeConfiguration
   */
  public BCTargetAddressTypeConfiguration duplicate() {
    BCTargetAddressTypeConfiguration configuration = new BCTargetAddressTypeConfiguration();
    configuration.copy(this);

    return configuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action.
   *
   * @return  BCChannelAction
   */
  public BCChannelAction getChannelAction() {
    return channelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel action.
   *
   * @param  channelAction  BCChannelAction
   */
  public void setChannelAction(BCChannelAction channelAction) {
    this.channelAction = channelAction;
  }
} // end class BCTargetAddressTypeConfiguration
