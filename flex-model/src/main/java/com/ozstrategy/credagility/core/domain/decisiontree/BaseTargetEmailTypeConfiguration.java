package com.ozstrategy.credagility.core.domain.decisiontree;

import com.cmc.credagility.core.domain.channel.EmailType;
import com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Used for storage Base Target EmailType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:48
 */
@MappedSuperclass public class BaseTargetEmailTypeConfiguration extends TargetBaseTypeConfiguration {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Email Type. */
  @JoinColumn(
    name       = "emailTypeId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EmailType emailType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BaseTargetEmailTypeConfiguration that = (BaseTargetEmailTypeConfiguration) o;

    if ((emailType != null) ? (!emailType.equals(that.emailType)) : (that.emailType != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type.
   *
   * @return  EmailType
   */
  public EmailType getEmailType() {
    return emailType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.TargetBaseTypeConfiguration#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((emailType != null) ? emailType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email type.
   *
   * @param  emailType  EmailType
   */
  public void setEmailType(EmailType emailType) {
    this.emailType = emailType;
  }
} // end class BaseTargetEmailTypeConfiguration
