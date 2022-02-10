package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is Role Function information.
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:17
 */
@Entity public class Feature extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2420476664718126860L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean cmcOnly;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isCMS;

  @Column(
    nullable = false,
    length   = 16
  )
  private String application;

  @Column(
    nullable = true,
    length   = 512
  )
  private String description;
  @Column(
    nullable = false,
    length   = 256
  )
  private String displayName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long featureId;

  @Column(
    nullable = false,
    unique   = true,
    length   = 64
  )
  private String featureName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Feature)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    Feature feature = (Feature) o;

    if ((application != null) ? (!application.equals(feature.application)) : (feature.application != null)) {
      return false;
    }

    if ((cmcOnly != null) ? (!cmcOnly.equals(feature.cmcOnly)) : (feature.cmcOnly != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(feature.description)) : (feature.description != null)) {
      return false;
    }

    if ((displayName != null) ? (!displayName.equals(feature.displayName)) : (feature.displayName != null)) {
      return false;
    }

    if ((featureId != null) ? (!featureId.equals(feature.featureId)) : (feature.featureId != null)) {
      return false;
    }

    if ((featureName != null) ? (!featureName.equals(feature.featureName)) : (feature.featureName != null)) {
      return false;
    }

    if ((isCMS != null) ? (!isCMS.equals(feature.isCMS)) : (feature.isCMS != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for application.
   *
   * @return  String
   */
  public String getApplication() {
    return application;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc only.
   *
   * @return  Boolean
   */
  public Boolean getCmcOnly() {
    return cmcOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for feature id.
   *
   * @return  Long
   */
  public Long getFeatureId() {
    return featureId;
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
   * getter method for is CMS.
   *
   * @return  Boolean
   */
  public Boolean getIsCMS() {
    return isCMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((cmcOnly != null) ? cmcOnly.hashCode() : 0);
    result = (31 * result) + ((isCMS != null) ? isCMS.hashCode() : 0);
    result = (31 * result) + ((application != null) ? application.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((displayName != null) ? displayName.hashCode() : 0);
    result = (31 * result) + ((featureId != null) ? featureId.hashCode() : 0);
    result = (31 * result) + ((featureName != null) ? featureName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for application.
   *
   * @param  application  String
   */
  public void setApplication(String application) {
    this.application = application;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc only.
   *
   * @param  cmcOnly  Boolean
   */
  public void setCmcOnly(Boolean cmcOnly) {
    this.cmcOnly = cmcOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for feature id.
   *
   * @param  featureId  Long
   */
  public void setFeatureId(Long featureId) {
    this.featureId = featureId;
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
   * setter method for is CMS.
   *
   * @param  isCMS  Boolean
   */
  public void setIsCMS(Boolean isCMS) {
    this.isCMS = isCMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Feature");
    sb.append("{application='").append(application).append('\'');
    sb.append(", cmcOnly='").append(cmcOnly).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", featureId=").append(featureId);
    sb.append(", featureName='").append(featureName).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class Feature
