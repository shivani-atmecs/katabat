package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.decisiontree.BaseTargetEmailTypeConfiguration;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * Target EmailType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:04
 */
@Entity public class TargetEmailTypeConfiguration extends BaseTargetEmailTypeConfiguration implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7221611293205365338L;

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
    this.emailType = ((TargetEmailTypeConfiguration) configuration).getEmailType();


    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  TargetEmailTypeConfiguration
   */
  public TargetEmailTypeConfiguration duplicate() {
    TargetEmailTypeConfiguration configuration = new TargetEmailTypeConfiguration();
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

} // end class TargetEmailTypeConfiguration
