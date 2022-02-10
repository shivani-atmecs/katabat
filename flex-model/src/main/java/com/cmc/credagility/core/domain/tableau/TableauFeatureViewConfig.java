package com.cmc.credagility.core.domain.tableau;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.client.Client;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:28
 */
@Entity
@Table(name = "TableauFeatureViewConfig")
public class TableauFeatureViewConfig extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2489820289380690788L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "featureName",
    nullable = false,
    unique   = true,
    length   = 50
  )
  protected String featureName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ssoUserName",
    length = 255
  )
  protected String ssoUserName;

  /** Menu text for this report view. */
  @Column(
    name     = "viewLabel",
    nullable = false,
    length   = 255
  )
  protected String viewLabel;

  /** The page title of this report view. */
  @Column(
    name     = "viewTitle",
    nullable = false,
    length   = 255
  )
  protected String viewTitle;

  /** The report url on Tableau server. */
  @Column(
    name     = "viewURL",
    nullable = false,
    length   = 255
  )
  protected String viewURL;

  @JoinColumn(
    name       = "clientId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;

  @Column private Integer refreshFrequency;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    TableauFeatureViewConfig that = (TableauFeatureViewConfig) o;

    if ((featureName != null) ? (!featureName.equals(that.featureName)) : (that.featureName != null)) {
      return false;
    }

    if ((ssoUserName != null) ? (!ssoUserName.equals(that.ssoUserName)) : (that.ssoUserName != null)) {
      return false;
    }

    if ((viewURL != null) ? (!viewURL.equals(that.viewURL)) : (that.viewURL != null)) {
      return false;
    }

    if ((viewTitle != null) ? (!viewTitle.equals(that.viewTitle)) : (that.viewTitle != null)) {
      return false;
    }

    if ((viewLabel != null) ? (!viewLabel.equals(that.viewLabel)) : (that.viewLabel != null)) {
      return false;
    }

    if ((client != null) ? (!client.equals(that.client)) : (that.client != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client.
   *
   * @return  Client
   */
  public Client getClient() {
    return client;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

// protected Long clientId;

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for refresh frequency.
   *
   * @return  Integer
   */
  public Integer getRefreshFrequency() {
    return refreshFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sso user name.
   *
   * @return  String
   */
  public String getSsoUserName() {
    return ssoUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for view label.
   *
   * @return  String
   */
  public String getViewLabel() {
    return viewLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for view title.
   *
   * @return  String
   */
  public String getViewTitle() {
    return viewTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for view URL.
   *
   * @return  String
   */
  public String getViewURL() {
    return viewURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((featureName != null) ? featureName.hashCode() : 0);
    result = (31 * result) + ((ssoUserName != null) ? ssoUserName.hashCode() : 0);
    result = (31 * result) + ((viewURL != null) ? viewURL.hashCode() : 0);
    result = (31 * result) + ((viewTitle != null) ? viewTitle.hashCode() : 0);
    result = (31 * result) + ((viewLabel != null) ? viewLabel.hashCode() : 0);
    result = (31 * result) + ((client != null) ? client.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client.
   *
   * @param  client  Client
   */
  public void setClient(Client client) {
    this.client = client;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for refresh frequency.
   *
   * @param  refreshFrequency  Integer
   */
  public void setRefreshFrequency(Integer refreshFrequency) {
    this.refreshFrequency = refreshFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sso user name.
   *
   * @param  ssoUserName  String
   */
  public void setSsoUserName(String ssoUserName) {
    this.ssoUserName = ssoUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for view label.
   *
   * @param  viewLabel  String
   */
  public void setViewLabel(String viewLabel) {
    this.viewLabel = viewLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for view title.
   *
   * @param  viewTitle  String
   */
  public void setViewTitle(String viewTitle) {
    this.viewTitle = viewTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for view URL.
   *
   * @param  viewURL  String
   */
  public void setViewURL(String viewURL) {
    this.viewURL = viewURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "TableauFeatureViewConfig{"
      + "featureName='" + featureName + '\''
      + ", id=" + id
      + ", ssoUserName='" + ssoUserName + '\''
      + ", viewURL='" + viewURL + '\''
      + ", viewTitle='" + viewTitle + '\''
      + ", viewLabel='" + viewLabel + '\''
      + ", client=" + client
      + '}';
  }
} // end class TableauFeatureViewConfig
