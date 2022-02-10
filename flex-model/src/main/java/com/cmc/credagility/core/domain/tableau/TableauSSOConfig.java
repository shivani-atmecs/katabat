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

import com.cmc.credagility.core.domain.client.Client;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:29
 */
@Entity
@Table(name = "TableauSSOConfig")
public class TableauSSOConfig implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 489253142536227350L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @Column(
    name     = "ssoCategory",
    nullable = false,
    length   = 50
  )
  protected String ssoCategory;

// protected Long clientId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "ssoUserName",
    nullable = false,
    unique   = true,
    length   = 50
  )
  protected String ssoUsername;

  /** DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String tableauExternalURL;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String tableauSSOURL;

  @JoinColumn(
    name       = "clientId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Client client;

  @Column(length = 15)
  private String reportType;

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

    TableauSSOConfig that = (TableauSSOConfig) o;

    if ((client != null) ? (!client.equals(that.client)) : (that.client != null)) {
      return false;
    }

    if ((ssoCategory != null) ? (!ssoCategory.equals(that.ssoCategory)) : (that.ssoCategory != null)) {
      return false;
    }

    if ((ssoUsername != null) ? (!ssoUsername.equals(that.ssoUsername)) : (that.ssoUsername != null)) {
      return false;
    }

    if ((tableauSSOURL != null) ? (!tableauSSOURL.equals(that.tableauSSOURL)) : (that.tableauSSOURL != null)) {
      return false;
    }

    if ((tableauExternalURL != null) ? (!tableauExternalURL.equals(that.tableauExternalURL))
                                     : (that.tableauExternalURL != null)) {
      return false;
    }

    if ((reportType != null) ? (!reportType.equals(that.reportType)) : (that.reportType != null)) {
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
   * getter method for report type.
   *
   * @return  String
   */
  public String getReportType() {
    return reportType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sso category.
   *
   * @return  String
   */
  public String getSsoCategory() {
    return ssoCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sso username.
   *
   * @return  String
   */
  public String getSsoUsername() {
    return ssoUsername;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tableau external URL.
   *
   * @return  String
   */
  public String getTableauExternalURL() {
    return tableauExternalURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tableau SSOURL.
   *
   * @return  String
   */
  public String getTableauSSOURL() {
    return tableauSSOURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (ssoCategory != null) ? ssoCategory.hashCode() : 0;
    result = (31 * result) + ((ssoUsername != null) ? ssoUsername.hashCode() : 0);
    result = (31 * result) + ((tableauSSOURL != null) ? tableauSSOURL.hashCode() : 0);
    result = (31 * result) + ((tableauExternalURL != null) ? tableauExternalURL.hashCode() : 0);
    result = (31 * result) + ((client != null) ? client.hashCode() : 0);
    result = (31 * result) + ((reportType != null) ? reportType.hashCode() : 0);

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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for report type.
   *
   * @param  reportType  String
   */
  public void setReportType(String reportType) {
    this.reportType = reportType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sso category.
   *
   * @param  ssoCategory  String
   */
  public void setSsoCategory(String ssoCategory) {
    this.ssoCategory = ssoCategory;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sso username.
   *
   * @param  ssoUsername  String
   */
  public void setSsoUsername(String ssoUsername) {
    this.ssoUsername = ssoUsername;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tableau external URL.
   *
   * @param  tableauExternalURL  String
   */
  public void setTableauExternalURL(String tableauExternalURL) {
    this.tableauExternalURL = tableauExternalURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tableau SSOURL.
   *
   * @param  tableauSSOURL  String
   */
  public void setTableauSSOURL(String tableauSSOURL) {
    this.tableauSSOURL = tableauSSOURL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "TableauSSOConfig{"
      + "id=" + id
      + ", ssoCategory='" + ssoCategory + '\''
      + ", ssoUsername='" + ssoUsername + '\''
      + ", tableauSSOURL='" + tableauSSOURL + '\''
      + ", tableauExternalURL='" + tableauExternalURL + '\''
      + ", client=" + client
      + '}';
  }
} // end class TableauSSOConfig
