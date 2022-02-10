package com.cmc.credagility.core.domain.agency;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:23
 */
@Entity
@Table(name = "AgencyTeam")
public class AgencyTeam extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 981566972429438001L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name   = "description",
    length = 128
  )
  private String description;
  @Column(
    name   = "name",
    length = 256
  )
  private String name;
  @JoinColumn(
    name       = "agencyId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Agency agency = new Agency();

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agencyTeam",
    cascade  = CascadeType.ALL
  )
  @OrderBy("queueCriteriaType asc, priority asc")
  private Set<AgencyTeamQueue> agencyTeamQueues = new LinkedHashSet<AgencyTeamQueue>();

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "teamId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long teamId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addQueue.
   *
   * @param   agencyTeamQueue  AgencyTeamQueue
   *
   * @return  boolean
   */
  public boolean addQueue(AgencyTeamQueue agencyTeamQueue) {
    agencyTeamQueue.setAgencyTeam(this);
    agencyTeamQueue.setAgency(getAgency());
    agencyTeamQueue.setAssignDate(new Date());

    return agencyTeamQueues.add(agencyTeamQueue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * businessEquals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AgencyTeam other = (AgencyTeam) obj;

    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }

    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    final AgencyTeam other = (AgencyTeam) obj;

    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }

    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency.
   *
   * @return  Agency
   */
  public Agency getAgency() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency team queues.
   *
   * @return  Set
   */
  public Set<AgencyTeamQueue> getAgencyTeamQueues() {
    return agencyTeamQueues;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for team id.
   *
   * @return  Long
   */
  public Long getTeamId() {
    return teamId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Has Active or scheduled queue.
   *
   * @return  has Active or scheduled queue.
   */
  public Boolean hasActiveQueue() {
    for (AgencyTeamQueue teamQueue : agencyTeamQueues) {
      if (teamQueue.hasActiveSchedule()) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((description == null) ? 0 : description.hashCode());
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove all queue from team.
   */
  public void removeAllQueues() {
    Iterator<AgencyTeamQueue> it = agencyTeamQueues.iterator();

    while (it.hasNext()) {
      AgencyTeamQueue teamQueue = it.next();
      it.remove();
      teamQueue.setAgency(null);
      teamQueue.setAgencyTeam(null);
      teamQueue.setAssignDate(null);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * remove queue from agency team.
   *
   * @param   agencyTeamQueue  DOCUMENT ME!
   *
   * @return  remove queue from agency team.
   */
  public boolean removeQueue(AgencyTeamQueue agencyTeamQueue) {
    boolean ret = agencyTeamQueues.remove(agencyTeamQueue);
    agencyTeamQueue.setAgency(null);
    agencyTeamQueue.setAgencyTeam(null);
    agencyTeamQueue.setAssignDate(null);

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Agency
   */
  public void setAgency(Agency agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency team queues.
   *
   * @param  agencyTeamQueues  Set
   */
  public void setAgencyTeamQueues(Set<AgencyTeamQueue> agencyTeamQueues) {
    this.agencyTeamQueues = agencyTeamQueues;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for team id.
   *
   * @param  teamId  Long
   */
  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AgencyTeam ( " + TAB + "teamId = " + this.teamId + TAB
      + "name = " + this.name + TAB + "description = " + this.description
      + TAB + " )";

    return retValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAgencyTeam.
   *
   * @param   other  AgencyTeam
   *
   * @return  boolean
   */
  public boolean updateAgencyTeam(AgencyTeam other) {
    if (!this.businessEquals(other)) {
      // update
      this.name           = other.getName();
      this.description    = other.getDescription();
      this.lastUpdateDate = new Date();

      return true;
    } else {
      // no updates
      return false;
    }
  }

} // end class AgencyTeam
