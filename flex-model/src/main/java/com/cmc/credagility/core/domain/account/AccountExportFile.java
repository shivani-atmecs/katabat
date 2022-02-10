package com.cmc.credagility.core.domain.account;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioEncryptionKey;
import com.cmc.credagility.core.domain.portfolio.PortfolioExportConfiguration;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.QueueAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 18:06
 */
@Entity
@Table(name = "AccountExportFile")
public class AccountExportFile extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "exportLayoutId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountExportLayout exportLayout;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "exportLocationId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioExportConfiguration exportLocation;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected String fileName;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioEncryptionKeyId",
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioEncryptionKey portfolioEncryptionKey;

  /** DOCUMENT ME! */
  @JoinTable(
    name               = "AccountExportFileAssignedQueue",
    indexes            = { @Index(columnList = "exportFileId") },
    joinColumns        = {
      @JoinColumn(
        name           = "exportFileId",
        nullable       = false,
        updatable      = true
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "queueActionId",
        nullable       = false,
        updatable      = true
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<QueueAction> queueActions = new LinkedHashSet<QueueAction>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountExportLayout object.
   */
  public AccountExportFile() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    AccountExportFile that = (AccountExportFile) o;

    if ((exportLayout != null) ? (!exportLayout.equals(that.exportLayout)) : (that.exportLayout != null)) {
      return false;
    }

    if ((exportLocation != null) ? (!exportLocation.equals(that.exportLocation)) : (that.exportLocation != null)) {
      return false;
    }

    if ((fileName != null) ? (!fileName.equals(that.fileName)) : (that.fileName != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export layout.
   *
   * @return  AccountExportLayout
   */
  public AccountExportLayout getExportLayout() {
    return exportLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export location.
   *
   * @return  PortfolioExportConfiguration
   */
  public PortfolioExportConfiguration getExportLocation() {
    return exportLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (historical == null) {
      return Boolean.FALSE;
    }

    return historical;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
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
  public PortfolioEncryptionKey getPortfolioEncryptionKey() {
    return portfolioEncryptionKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue actions.
   *
   * @return  Set
   */
  public Set<QueueAction> getQueueActions() {
    return queueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((exportLayout != null) ? exportLayout.hashCode() : 0);
    result = (31 * result) + ((exportLocation != null) ? exportLocation.hashCode() : 0);
    result = (31 * result) + ((fileName != null) ? fileName.hashCode() : 0);
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export layout.
   *
   * @param  exportLayout  AccountExportLayout
   */
  public void setExportLayout(AccountExportLayout exportLayout) {
    this.exportLayout = exportLayout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export location.
   *
   * @param  exportLocation  PortfolioExportConfiguration
   */
  public void setExportLocation(PortfolioExportConfiguration exportLocation) {
    this.exportLocation = exportLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioEncryptionKey  DOCUMENT ME!
   */
  public void setPortfolioEncryptionKey(PortfolioEncryptionKey portfolioEncryptionKey) {
    this.portfolioEncryptionKey = portfolioEncryptionKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue actions.
   *
   * @param  queueActions  Set
   */
  public void setQueueActions(Set<QueueAction> queueActions) {
    this.queueActions = queueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "AccountExportFile{"
      + "exportLayout=" + exportLayout
      + ", exportLocation=" + exportLocation
      + ", fileName='" + fileName + '\''
      + ", historical=" + historical
      + ", id=" + id
      + ", portfolio=" + portfolio
      + ", queueActions=" + queueActions
      + '}';
  }
} // end class AccountExportFile
