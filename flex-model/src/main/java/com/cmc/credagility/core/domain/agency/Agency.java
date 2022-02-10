package com.cmc.credagility.core.domain.agency;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to present the agency information.
 *
 * <p>todo: to be removed</p>
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:13 PM
 */
@Entity
@Table(
  name    = "Agency",
  indexes = {
    @Index(
      name = "FKA7_agencyId",
      columnList = "agencyId"
    ),
    @Index(
      name = "name_2",
      columnList = "name",
      unique = true
    )
  }
)
public class Agency extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7342934416363674442L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PK, identity property. */
  @Column(
    name     = "agencyId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long agencyId;

  /** the queue set which the agency can work on. */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "agency"
  )
  @OrderBy("priority asc")
  protected Set<AgencyQueue> agencyQueues = new LinkedHashSet<AgencyQueue>();

  /** the queue set which the agency can work on. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agency",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  protected Set<AgencyTeam> agencyTeams = new LinkedHashSet<AgencyTeam>();

  /** agency has allowAdmin user. */
  @Column(
    name             = "allowAdmin",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowAdmin;

  /** the current working agencyQueue. */
  @Column(name = "currentQueueId")
  protected Long currentQueueId = null;

  /** agency name. */
  @Column(
    name     = "name",
    unique   = true,
    length   = 80,
    nullable = false
  )
  protected String name;

  /** agency portfolio access, for portfolio management. */
  @JoinTable(
    name               = "AgencyManagedPortfolio",
    indexes            = { @Index(columnList = "agencyId") },
    joinColumns        = {
      @JoinColumn(
        name           = "agencyId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "portfolioId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<Portfolio> agencyManagedPortfolios = new LinkedHashSet<Portfolio>();

  /** DOCUMENT ME! */
  @JoinTable(
    name               = "AgencyViewOnlyPortfolio",
    indexes            = { @Index(columnList = "agencyId") },
    joinColumns        = {
      @JoinColumn(
        name           = "agencyId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "portfolioId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<Portfolio> agencyViewOnlyPortfolios = new LinkedHashSet<Portfolio>();

  /** agency allowed porfolios, for agency working on portfolio. */
  @JoinTable(
    name               = "PortfolioAllowedAgency",
    indexes            = { @Index(columnList = "agencyId") },
    joinColumns        = {
      @JoinColumn(
        name           = "agencyId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "portfolioId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<Portfolio> allowedPortfolios = new LinkedHashSet<Portfolio>();

  /** agency allowed tabs, for agency working on portfolio. */
  @JoinTable(
    name               = "AgencyAllowedTab",
    indexes            = { @Index(columnList = "agencyId") },
    joinColumns        = {
      @JoinColumn(
        name           = "agencyId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "tabId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  @OrderBy("displayOrder asc")
  protected Set<AgencyTab> allowedTabs = new LinkedHashSet<AgencyTab>();

  /** moving account cursor for current working account. */
  @Column(name = "currentAccountNum")
  protected Long currentAccountNum = null;

  /** Agent are not allowed to change password within the window if they changed password in hours. */
  @Column protected Integer passwordChangeWindow = 24;

  /** Agent password history size. */
  @Column protected Integer passwordHistorySize = 13;

  /** Agent Password rotation days. */
  @Column protected Integer passwordRotationDays = 30;

  /** DOCUMENT ME! */
  @Column(
    name             = "seeAllAccount",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean seeAllAccount = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add Allowed Portfolio.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void addAllowedPortfolio(Portfolio portfolio) {
    getAllowedPortfolios().add(portfolio);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add Managed Portfolio.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void addManagedPortfolio(Portfolio portfolio) {
    getAgencyManagedPortfolios().add(portfolio);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add queue to agency.
   *
   * @param   agencyQueue  DOCUMENT ME!
   *
   * @return  add queue to agency.
   */
  public boolean addQueue(AgencyQueue agencyQueue) {
    agencyQueue.setAgency(this);
    agencyQueue.setAssignDate(new Date());

    return agencyQueues.add(agencyQueue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add team to agency.
   *
   * @param   agencyTeam  DOCUMENT ME!
   *
   * @return  add team to agency.
   */
  public boolean addTeam(AgencyTeam agencyTeam) {
    agencyTeam.setAgency(this);

    return agencyTeams.add(agencyTeam);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add view only Portfolio.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void addViewOnlyPortfolio(Portfolio portfolio) {
    getAgencyViewOnlyPortfolios().add(portfolio);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Agency other = (Agency) obj;

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all accessible portfolio map.
   *
   * @return  get all accessible portfolio map.
   */
  public Map<String, Portfolio> getAccessiblePortfolioMap() {
    Map<String, Portfolio> portfolios = new HashMap<String, Portfolio>();

    portfolios.putAll(getAgencyManagedPortfolioMap());
    portfolios.putAll(getAgencyViewOnlyPortfolioMap());

    return portfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all accessible portfolio.
   *
   * @return  get all accessible portfolio.
   */
  public List<Portfolio> getAccessiblePortfolios() {
    List<Portfolio> portfolios = new ArrayList<Portfolio>();

    portfolios.addAll(agencyManagedPortfolios);
    portfolios.addAll(agencyViewOnlyPortfolios);

    return portfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the agencyId
   */
  public Long getAgencyId() {
    return this.agencyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get agency managed portfolio map.
   *
   * @return  get agency managed portfolio map.
   */
  public Map<String, Portfolio> getAgencyManagedPortfolioMap() {
    Map<String, Portfolio> map = new HashMap<String, Portfolio>();

    for (Portfolio portfolio : agencyManagedPortfolios) {
      map.put(portfolio.getPortfolioId().toString(), portfolio);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the agencyManagedPortfolios
   */
  public Set<Portfolio> getAgencyManagedPortfolios() {
    return agencyManagedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the agencyQueues
   */
  public Set<AgencyQueue> getAgencyQueues() {
    return this.agencyQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get agency team map.
   *
   * @return  get agency team map.
   */
  public Map<Long, AgencyTeam> getAgencyTeamMap() {
    Map<Long, AgencyTeam> agencyTeamMap = new HashMap<Long, AgencyTeam>();

    for (AgencyTeam team : agencyTeams) {
      agencyTeamMap.put(team.getTeamId(), team);
    }

    return agencyTeamMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, AgencyTeam> getAgencyTeamNameMap() {
    Map<String, AgencyTeam> agencyTeamNameMap = new HashMap<String, AgencyTeam>();

    for (AgencyTeam team : agencyTeams) {
      agencyTeamNameMap.put(team.getName(), team);
    }

    return agencyTeamNameMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AgencyTeam> getAgencyTeams() {
    return agencyTeams;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get agency view only portfolio map.
   *
   * @return  get agency view only portfolio map.
   */
  public Map<String, Portfolio> getAgencyViewOnlyPortfolioMap() {
    Map<String, Portfolio> map = new LinkedHashMap<String, Portfolio>();

    for (Portfolio portfolio : agencyViewOnlyPortfolios) {
      map.put(portfolio.getPortfolioId().toString(), portfolio);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the agencyViewOnlyPortfolios
   */
  public Set<Portfolio> getAgencyViewOnlyPortfolios() {
    return agencyViewOnlyPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the allowAdmin
   */
  public Boolean getAllowAdmin() {
    return this.allowAdmin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public Map<Long, Portfolio> getAllowedPortfolioMap() {
    Map<Long, Portfolio> map = new HashMap<Long, Portfolio>();

    for (Portfolio portfolio : allowedPortfolios) {
      map.put(portfolio.getPortfolioId(), portfolio);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the allowedPortfolios
   */
  public Set<Portfolio> getAllowedPortfolios() {
    return this.allowedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<AgencyTab> getAllowedTabs() {
    return allowedTabs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the currentAccountId
   */
  public Long getCurrentAccountNum() {
    return this.currentAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the currentQueueId
   */
  public Long getCurrentQueueId() {
    return this.currentQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the name
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPasswordChangeWindow() {
    return passwordChangeWindow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPasswordHistorySize() {
    return passwordHistorySize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPasswordRotationDays() {
    return passwordRotationDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public Boolean getSeeAllAccount() {
    return seeAllAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // /**
  // * @return
  // */
  // public AgencyTeam getDefaultTeam() {
  // for (AgencyTeam agencyTeam : agencyTeams) {
  // if (Boolean.TRUE.equals(agencyTeam.getDefaultTeam())) {
  // return agencyTeam;
  // }
  // }
  //
  // return null;
  // }

  /**
   * Check whether two agency are the same one.
   *
   * @param   other  DOCUMENT ME!
   *
   * @return  check whether two agency are the same one.
   */
  public boolean isSameAgency(Agency other) {
    try {
      return this.getAgencyId().equals(other.getAgencyId());
    } catch (Exception e) {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * remove queue from agency.
   *
   * @param   agencyQueue  DOCUMENT ME!
   *
   * @return  remove queue from agency.
   */
  public boolean removeQueue(AgencyQueue agencyQueue) {
    boolean ret = agencyQueues.remove(agencyQueue);
    agencyQueue.setAgency(null);
    agencyQueue.setAssignDate(null);

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove team from agency.
   *
   * @param   agencyTeam  DOCUMENT ME!
   *
   * @return  remove team from agency.
   */
  public boolean removeTeam(AgencyTeam agencyTeam) {
    // agencyTeam.setAgency(null);
    return agencyTeams.remove(agencyTeam);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyId  the agencyId to set
   */
  public void setAgencyId(Long agencyId) {
    this.agencyId = agencyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyManagedPortfolios  the agencyManagedPortfolios to set
   */
  public void setAgencyManagedPortfolios(Set<Portfolio> agencyManagedPortfolios) {
    this.agencyManagedPortfolios = agencyManagedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyQueues  the agencyQueues to set
   */
  public void setAgencyQueues(Set<AgencyQueue> agencyQueues) {
    this.agencyQueues = agencyQueues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyTeams  DOCUMENT ME!
   */
  public void setAgencyTeams(Set<AgencyTeam> agencyTeams) {
    this.agencyTeams = agencyTeams;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agencyViewOnlyPortfolios  the agencyViewOnlyPortfolios to set
   */
  public void setAgencyViewOnlyPortfolios(Set<Portfolio> agencyViewOnlyPortfolios) {
    this.agencyViewOnlyPortfolios = agencyViewOnlyPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  admin  the allowAdmin to set
   */
  public void setAllowAdmin(Boolean admin) {
    this.allowAdmin = admin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowedPortfolios  the allowedPortfolios to set
   */
  public void setAllowedPortfolios(Set<Portfolio> allowedPortfolios) {
    this.allowedPortfolios = allowedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowedTabs  DOCUMENT ME!
   */
  public void setAllowedTabs(Set<AgencyTab> allowedTabs) {
    this.allowedTabs = allowedTabs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentAccountNum  the currentAccountId to set
   */
  public void setCurrentAccountNum(Long currentAccountNum) {
    this.currentAccountNum = currentAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentQueueId  the currentQueueId to set
   */
  public void setCurrentQueueId(Long currentQueueId) {
    this.currentQueueId = currentQueueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  passwordChangeWindow  DOCUMENT ME!
   */
  public void setPasswordChangeWindow(Integer passwordChangeWindow) {
    this.passwordChangeWindow = passwordChangeWindow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  passwordHistorySize  DOCUMENT ME!
   */
  public void setPasswordHistorySize(Integer passwordHistorySize) {
    this.passwordHistorySize = passwordHistorySize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  passwordRotationDays  DOCUMENT ME!
   */
  public void setPasswordRotationDays(Integer passwordRotationDays) {
    this.passwordRotationDays = passwordRotationDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  seeAllAccount  DOCUMENT ME!
   */
  public void setSeeAllAccount(Boolean seeAllAccount) {
    this.seeAllAccount = seeAllAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("Agency ( ").append(super.toString()).append(TAB).append(
      "agencyId = ").append(this.agencyId).append(TAB).append(
      "currentAccount = ").append(this.currentAccountNum).append(TAB).append(
      "currentQueue = ").append(this.currentQueueId).append(TAB).append(
      "name = ").append(this.name).append(TAB).append(TAB).append(TAB).append(
      " )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update agency teams.
   *
   * @param   teams  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateAgencyTeams(List<AgencyTeam> teams) {
    boolean updated = false;

    if (this.agencyTeams.size() != teams.size()) {
      // size is change, there should be update
      updated = true;
    }

    Set<AgencyTeam> updateTeams = new LinkedHashSet<AgencyTeam>();

    for (AgencyTeam agencyTeam : teams) {
      Long teamId = agencyTeam.getTeamId();

      if (teamId != null) {
        // update existing team
        AgencyTeam curTeam = getAgencyTeamMap().get(teamId);

        if (curTeam.updateAgencyTeam(agencyTeam)) {
          // has updates
          updated = true;
        }

        updateTeams.add(curTeam);
      } else {
        agencyTeam.setAgency(this);

        updateTeams.add(agencyTeam);
        updated = true;
      }
    }

    if (updated) {
      this.agencyTeams.clear();
      this.agencyTeams.addAll(updateTeams);
    }

    return updated;
  } // end method updateAgencyTeams
} // end class Agency
