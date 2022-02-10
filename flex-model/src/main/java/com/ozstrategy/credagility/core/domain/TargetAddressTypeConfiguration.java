package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.decisiontree.BaseTargetAddressTypeConfiguration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * Target AddressType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:01
 */
@Entity public class TargetAddressTypeConfiguration extends BaseTargetAddressTypeConfiguration implements Serializable {
  private static final long serialVersionUID = 3845724609144059522L;
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** ChannelAction. */
  @JoinColumn(
    name     = "channelActionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelAction channelAction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  TargetBaseTypeConfiguration#copy(TargetBaseTypeConfiguration)
   */
  @Override public TargetBaseTypeConfiguration copy(TargetBaseTypeConfiguration configuration) {
    super.copy(configuration);
    this.addressType = ((TargetAddressTypeConfiguration) configuration).getAddressType();


    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  TargetAddressTypeConfiguration
   */
  public TargetAddressTypeConfiguration duplicate() {
    TargetAddressTypeConfiguration configuration = new TargetAddressTypeConfiguration();
    configuration.copy(this);

    return configuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action.
   *
   * @return  ChannelAction
   */
  public ChannelAction getChannelAction() {
    return channelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel action.
   *
   * @param  channelAction  ChannelAction
   */
  public void setChannelAction(ChannelAction channelAction) {
    this.channelAction = channelAction;
  }

} // end class TargetAddressTypeConfiguration
