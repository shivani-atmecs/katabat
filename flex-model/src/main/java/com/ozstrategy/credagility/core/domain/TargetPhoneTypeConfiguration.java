package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.decisiontree.BaseTargetPhoneTypeConfiguration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * Target PhoneType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:06
 */
@Entity public class TargetPhoneTypeConfiguration extends BaseTargetPhoneTypeConfiguration implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2881822934270857451L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** ChannelAction. */
  @JoinColumn(
    name       = "channelActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelAction channelAction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  TargetBaseTypeConfiguration#copy(TargetBaseTypeConfiguration)
   */
  @Override public TargetBaseTypeConfiguration copy(TargetBaseTypeConfiguration configuration) {
    super.copy(configuration);
    this.phoneType = ((TargetPhoneTypeConfiguration) configuration).getPhoneType();

    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  TargetPhoneTypeConfiguration
   */
  public TargetPhoneTypeConfiguration duplicate() {
    TargetPhoneTypeConfiguration configuration = new TargetPhoneTypeConfiguration();
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
} // end class TargetPhoneTypeConfiguration
