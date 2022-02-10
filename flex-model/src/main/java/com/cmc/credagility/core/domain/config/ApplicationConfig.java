package com.cmc.credagility.core.domain.config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Config app env.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 16:39
 */
@Entity
@Table(
  name    = "ApplicationConfig",
  indexes = {
    @Index(
      name = "featureNameIndex",
      columnList = "featureName",
      unique = true
    )
  }
)
public class ApplicationConfig implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3718982798460934451L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Feature name. */
  @Column(
    name     = "featureName",
    nullable = false,
    unique   = true,
    length   = 50
  )
  @Id protected String featureName;


  /** Feature value. */
  @Column(
    name     = "featureValue",
    nullable = false,
    length   = 512
  )
  protected String featureValue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for feature boolean value.
   *
   * @return  Boolean
   */
  public Boolean getFeatureBooleanValue() {
    if (("true".equalsIgnoreCase(featureValue))
          || ("t".equalsIgnoreCase(featureValue))
          || ("yes".equalsIgnoreCase(featureValue))
          || ("y".equalsIgnoreCase(featureValue))) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for feature name.
   *
   * @return  String
   */
  public String getFeatureName() {
    return featureName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for feature value.
   *
   * @return  String
   */
  public String getFeatureValue() {
    return featureValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for feature name.
   *
   * @param  featureName  String
   */
  public void setFeatureName(String featureName) {
    this.featureName = featureName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for feature value.
   *
   * @param  featureValue  String
   */
  public void setFeatureValue(String featureValue) {
    this.featureValue = featureValue;
  }
} // end class ApplicationConfig
