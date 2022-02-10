package com.cmc.credagility.core.domain.config;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store FlexSelectConfig information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 14:50
 */
@Entity
@Table(
  name    = "FlexSelectConfig",
  indexes = {
    @Index(
      name = "configNameIndex",
      columnList = "name"
    ),
    @Index(
      name = "priorityIndex",
      columnList = "priority"
    )
  }
)
public class FlexSelectConfig extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Trigger criteria. */
  @Lob private String criteria;


  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long         id;


  /** Name. */
  @Column(
    nullable = false,
    length   = 255
  )
  private String name;

  /** If this config is triggered, set account.allowWeb = this value. */
  @Column(
    name             = "allowWeb",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean allowWeb = false;


  /** If allow all roles. */
  @Column(
    name             = "allRoles",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean allRoles = false;


  /** Enabled roles, Refers {@link Role}. */
  @JoinTable(
    name               = "FlexStationTransactionalEnabledRole",
    indexes            = { @Index(columnList = "flexSelectConfigId"), },
    joinColumns        = {
      @JoinColumn(
        name           = "flexSelectConfigId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  private Set<Role> enabledRoles = new HashSet<Role>();


  /** If this config has been deleted. */
  @Column(
    name             = "historical",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean historical = Boolean.FALSE;

  /** If this config is triggered, set Account.AccountIndex.runNonOperationalStrategies = this value. */
  @Column(
    name             = "nonoperational",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean nonoperational = false;

  /** If this config is triggered, set Account.active = this value. */
  @Column(
    name             = "operational",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean operational = false;

  /** If Portfolio is null, this config applies to all portfolio, Refers {@link Portfolio}. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(
    fetch   = FetchType.EAGER,
    cascade = { CascadeType.ALL }
  )
  private Portfolio portfolio;

  /** Priority. */
  @Column private Integer priority = 1;


  /** Now no place use this value. */
  @Column(
    name             = "runCompliance",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean runCompliance = false;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new FlexSelectConfig object.
   */
  public FlexSelectConfig() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    FlexSelectConfig config = (FlexSelectConfig) o;

    if ((allowWeb != null) ? (!allowWeb.equals(config.allowWeb)) : (config.allowWeb != null)) {
      return false;
    }

    if ((allRoles != null) ? (!allRoles.equals(config.allRoles)) : (config.allRoles != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(config.criteria)) : (config.criteria != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(config.historical)) : (config.historical != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(config.id)) : (config.id != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(config.name)) : (config.name != null)) {
      return false;
    }

    if ((nonoperational != null) ? (!nonoperational.equals(config.nonoperational)) : (config.nonoperational != null)) {
      return false;
    }

    if ((operational != null) ? (!operational.equals(config.operational)) : (config.operational != null)) {
      return false;
    }

    if ((runCompliance != null) ? (!runCompliance.equals(config.runCompliance)) : (config.runCompliance != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(config.portfolio)) : (config.portfolio != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(config.priority)) : (config.priority != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow web.
   *
   * @return  Boolean
   */
  public Boolean getAllowWeb() {
    if (allowWeb == null) {
      return false;
    }

    return allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all roles.
   *
   * @return  Boolean
   */
  public Boolean getAllRoles() {
    if (null == allRoles) {
      return Boolean.FALSE;
    }

    return allRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enabled roles.
   *
   * @return  Set
   */
  public Set<Role> getEnabledRoles() {
    return enabledRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (null == historical) {
      return false;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    if (StringUtils.hasText(name)) {
      return name.trim();
    }

    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nonoperational.
   *
   * @return  Boolean
   */
  public Boolean getNonoperational() {
    if (nonoperational == null) {
      return false;
    }

    return nonoperational;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for operational.
   *
   * @return  Boolean
   */
  public Boolean getOperational() {
    if (operational == null) {
      return false;
    }

    return operational;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run compliance.
   *
   * @return  Boolean
   */
  public Boolean getRunCompliance() {
    return runCompliance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((allowWeb != null) ? allowWeb.hashCode() : 0);
    result = (31 * result) + ((allRoles != null) ? allRoles.hashCode() : 0);
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((nonoperational != null) ? nonoperational.hashCode() : 0);
    result = (31 * result) + ((runCompliance != null) ? runCompliance.hashCode() : 0);
    result = (31 * result) + ((operational != null) ? operational.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow web.
   *
   * @param  allowWeb  Boolean
   */
  public void setAllowWeb(Boolean allowWeb) {
    this.allowWeb = allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for all roles.
   *
   * @param  allRoles  Boolean
   */
  public void setAllRoles(Boolean allRoles) {
    this.allRoles = allRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enabled roles.
   *
   * @param  enabledRoles  Set
   */
  public void setEnabledRoles(Set<Role> enabledRoles) {
    this.enabledRoles = enabledRoles;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nonoperational.
   *
   * @param  nonoperational  Boolean
   */
  public void setNonoperational(Boolean nonoperational) {
    this.nonoperational = nonoperational;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for operational.
   *
   * @param  operational  Boolean
   */
  public void setOperational(Boolean operational) {
    this.operational = operational;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run compliance.
   *
   * @param  runCompliance  Boolean
   */
  public void setRunCompliance(Boolean runCompliance) {
    this.runCompliance = runCompliance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "FlexSelectConfig{"
      + "id=" + id
      + ", priority=" + priority
      + ", name='" + name + '\''
      + ", allowWeb=" + allowWeb
      + ", allRoles=" + allRoles
      + ", historical=" + historical
      + ", nonoperational=" + nonoperational
      + ", operational=" + operational
      + ", runCompliance=" + runCompliance
      + '}';
  }
} // end class FlexSelectConfig
