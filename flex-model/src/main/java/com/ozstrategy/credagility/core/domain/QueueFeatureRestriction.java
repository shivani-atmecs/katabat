package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.user.Feature;
import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to Queue Feature Restriction information.
 *
 * <p><a href="QueueFeatureRestriction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:30
 */
@Entity public class QueueFeatureRestriction extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3655766185323016392L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long restrictionId;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "QueueFeatureRole",
    indexes            = {
      @Index(
        name           = "restrictionId",
        columnList     = "restrictionId"
      )
    },
    joinColumns        = {
      @JoinColumn(
        name           = "restrictionId",
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
    fetch   = FetchType.EAGER,
    cascade = { CascadeType.ALL }
  )
  protected Set<Role> roles = new HashSet<Role>();

  @JoinColumn(
    name       = "featureId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Feature feature;

  /** The queue action which this criteria belong to. */
  @JoinColumn(
    name       = "queueActionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private QueueAction queueAction = new QueueAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addRole.
   *
   * @param  role  Role
   */
  public void addRole(Role role) {
    this.roles.add(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    QueueFeatureRestriction that = (QueueFeatureRestriction) o;

    if ((feature != null) ? (!feature.equals(that.feature)) : (that.feature != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for feature.
   *
   * @return  Feature
   */
  public Feature getFeature() {
    return feature;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue action.
   *
   * @return  QueueAction
   */
  public QueueAction getQueueAction() {
    return queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for restriction id.
   *
   * @return  Long
   */
  public Long getRestrictionId() {
    return restrictionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for roles.
   *
   * @return  Set
   */
  public Set<Role> getRoles() {
    return roles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((feature != null) ? feature.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeRole.
   *
   * @param  role  Role
   */
  public void removeRole(Role role) {
    if (role == null) {
      return;
    }

    for (Role curRole : this.roles) {
      if (curRole.getId().equals(role.getId())) {
        this.roles.remove(curRole);

        return;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for feature.
   *
   * @param  feature  Feature
   */
  public void setFeature(Feature feature) {
    this.feature = feature;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue action.
   *
   * @param  queueAction  QueueAction
   */
  public void setQueueAction(QueueAction queueAction) {
    this.queueAction = queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for restriction id.
   *
   * @param  restrictionId  Long
   */
  public void setRestrictionId(Long restrictionId) {
    this.restrictionId = restrictionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for roles.
   *
   * @param  roles  Set
   */
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("QueueFeatureRestriction");
    sb.append("{restrictionId=").append(restrictionId);
    sb.append(", roles=").append(roles);
    sb.append(", feature=").append(feature);
    sb.append(", queueAction=").append(queueAction);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFeatureRestriction.
   *
   * @param   restriction  QueueFeatureRestriction
   *
   * @return  boolean
   */
  public boolean updateFeatureRestriction(QueueFeatureRestriction restriction) {
    if (!this.equals(restriction)) {
      this.feature        = restriction.getFeature();
      this.roles          = restriction.getRoles();
      this.lastUpdateDate = new Date();

      return true;
    }

    return false;
  }

} // end class QueueFeatureRestriction
