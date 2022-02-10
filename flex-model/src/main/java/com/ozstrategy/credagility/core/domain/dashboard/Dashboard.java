package com.ozstrategy.credagility.core.domain.dashboard;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.StatusType;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.type.DashboardType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Dashboard.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:31
 */
@Entity public class Dashboard extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 9019640784168522667L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** current is active. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;


  /** Dashboard Config. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "dashboard",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  @OrderBy("displayOrder asc")
  protected Set<DashboardConfig> configs = new LinkedHashSet<DashboardConfig>();


  /** context. */
  @Column(length = 45)
  protected String context;


  /** PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** Dashboard name. */
  @Column(length = 45)
  protected String name;


  /** Status Type. */
  @Column(
    name   = "status",
    length = 10
  )
  @Enumerated(EnumType.STRING)
  protected StatusType status;


  /** summary. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean summary;


  /** Dashboard Type:GRID. */
  @Column(length = 45)
  @Enumerated(value = EnumType.STRING)
  protected DashboardType type = DashboardType.GRID;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Dashboard object.
   */
  public Dashboard() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.FALSE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for configs.
   *
   * @return  Set
   */
  public Set<DashboardConfig> getConfigs() {
    return configs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
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
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  StatusType
   */
  public StatusType getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for summary.
   *
   * @return  Boolean
   */
  public Boolean getSummary() {
    if (this.summary == null) {
      return Boolean.FALSE;
    }

    return summary;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  DashboardType
   */
  public DashboardType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for configs.
   *
   * @param  configs  Set
   */
  public void setConfigs(Set<DashboardConfig> configs) {
    this.configs = configs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
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
   * setter method for status.
   *
   * @param  status  StatusType
   */
  public void setStatus(StatusType status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for summary.
   *
   * @param  summary  Boolean
   */
  public void setSummary(Boolean summary) {
    this.summary = summary;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  DashboardType
   */
  public void setType(DashboardType type) {
    this.type = type;
  }
} // end class Dashboard
