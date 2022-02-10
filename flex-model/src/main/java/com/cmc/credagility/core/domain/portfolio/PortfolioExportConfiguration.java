package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.export.BaseExportConfiguration;


/**
 * Created by IntelliJ IDEA. User: ysun Date: Dec 29, 2010 Time: 12:16:45 AM To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PortfolioExportConfiguration")
public class PortfolioExportConfiguration extends BaseExportConfiguration {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6895465384971667286L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Email BCC. */
  protected String emailBCC;

  /** Email CC. */
  protected String emailCC;

  /** Email to. */
  protected String emailTo;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long portfolioExportConfigurationId;

  /** SFTP server folder. */
  @Column(
    name   = "sftpFolder",
    length = 256
  )
  protected String sftpFolder;

  /** SFTP server ip. */
  @Column(
    name   = "sftpIp",
    length = 256
  )
  protected String sftpIp;

  /** SFTP server login password. */
  @Column(
    name   = "sftpPassword",
    length = 256
  )
  protected String sftpPassword;

  /** Connection the SFTP server port. */
  @Column(
    name   = "sftpPort",
    length = 10
  )
  protected String sftpPort;

  /** SFTP server login username. */
  @Column(
    name   = "sftpUserName",
    length = 256
  )
  protected String sftpUserName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PortfolioExportConfiguration object.
   */
  public PortfolioExportConfiguration() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.export.BaseExportConfiguration#equals(java.lang.Object)
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

    PortfolioExportConfiguration that = (PortfolioExportConfiguration) o;

    if ((emailBCC != null) ? (!emailBCC.equals(that.emailBCC)) : (that.emailBCC != null)) {
      return false;
    }

    if ((emailCC != null) ? (!emailCC.equals(that.emailCC)) : (that.emailCC != null)) {
      return false;
    }

    if ((emailTo != null) ? (!emailTo.equals(that.emailTo)) : (that.emailTo != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((sftpFolder != null) ? (!sftpFolder.equals(that.sftpFolder)) : (that.sftpFolder != null)) {
      return false;
    }

    if ((sftpIp != null) ? (!sftpIp.equals(that.sftpIp)) : (that.sftpIp != null)) {
      return false;
    }

    if ((sftpPassword != null) ? (!sftpPassword.equals(that.sftpPassword)) : (that.sftpPassword != null)) {
      return false;
    }

    if ((sftpPort != null) ? (!sftpPort.equals(that.sftpPort)) : (that.sftpPort != null)) {
      return false;
    }

    if ((sftpUserName != null) ? (!sftpUserName.equals(that.sftpUserName)) : (that.sftpUserName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmailBCC() {
    return emailBCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmailCC() {
    return emailCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEmailTo() {
    return emailTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioExportConfigurationId() {
    return portfolioExportConfigurationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSftpFolder() {
    return sftpFolder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSftpIp() {
    return sftpIp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSftpPassword() {
    return sftpPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSftpPort() {
    return sftpPort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSftpUserName() {
    return sftpUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.export.BaseExportConfiguration#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((emailBCC != null) ? emailBCC.hashCode() : 0);
    result = (31 * result) + ((emailCC != null) ? emailCC.hashCode() : 0);
    result = (31 * result) + ((emailTo != null) ? emailTo.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((sftpFolder != null) ? sftpFolder.hashCode() : 0);
    result = (31 * result) + ((sftpIp != null) ? sftpIp.hashCode() : 0);
    result = (31 * result) + ((sftpPassword != null) ? sftpPassword.hashCode() : 0);
    result = (31 * result) + ((sftpPort != null) ? sftpPort.hashCode() : 0);
    result = (31 * result) + ((sftpUserName != null) ? sftpUserName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  emailBCC  DOCUMENT ME!
   */
  public void setEmailBCC(String emailBCC) {
    this.emailBCC = emailBCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  emailCC  DOCUMENT ME!
   */
  public void setEmailCC(String emailCC) {
    this.emailCC = emailCC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  emailTo  DOCUMENT ME!
   */
  public void setEmailTo(String emailTo) {
    this.emailTo = emailTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioExportConfigurationId  DOCUMENT ME!
   */
  public void setPortfolioExportConfigurationId(Long portfolioExportConfigurationId) {
    this.portfolioExportConfigurationId = portfolioExportConfigurationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sftpFolder  DOCUMENT ME!
   */
  public void setSftpFolder(String sftpFolder) {
    this.sftpFolder = sftpFolder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sftpIp  DOCUMENT ME!
   */
  public void setSftpIp(String sftpIp) {
    this.sftpIp = sftpIp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sftpPassword  DOCUMENT ME!
   */
  public void setSftpPassword(String sftpPassword) {
    this.sftpPassword = sftpPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sftpPort  DOCUMENT ME!
   */
  public void setSftpPort(String sftpPort) {
    this.sftpPort = sftpPort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  sftpUserName  DOCUMENT ME!
   */
  public void setSftpUserName(String sftpUserName) {
    this.sftpUserName = sftpUserName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioExportConfiguration");
    sb.append("{emailBCC='").append(emailBCC).append('\'');
    sb.append(", emailCC='").append(emailCC).append('\'');
    sb.append(", emailTo='").append(emailTo).append('\'');
    sb.append(", portfolio=").append(portfolio.getPortfolioId());
    sb.append(", portfolioExportConfigurationId=").append(portfolioExportConfigurationId);
    sb.append(", queueExportDestination='").append(queueExportDestination).append('\'');
    sb.append(", queueExportFileName='").append(queueExportFileName).append('\'');
    sb.append(", queueExportLocation='").append(queueExportLocation).append('\'');
    sb.append(", sftpFolder='").append(sftpFolder).append('\'');
    sb.append(", sftpIp='").append(sftpIp).append('\'');
    sb.append(", sftpPassword='").append(sftpPassword).append('\'');
    sb.append(", sftpPort='").append(sftpPort).append('\'');
    sb.append(", sftpUserName='").append(sftpUserName).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioExportConfiguration
