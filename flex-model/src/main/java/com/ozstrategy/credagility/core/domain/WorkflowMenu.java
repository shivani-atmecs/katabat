package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by yongliu on 9/2/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  09/02/2016 15:15
 */
@Entity
@Table(name = "WorkflowMenu")
public class WorkflowMenu extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7453750679777017722L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "hotspotId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private HotSpot  hotSpot;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(length = 255)
  private String menuLinkText;

  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private SurveySchedule schedule;

  @Cascade({ CascadeType.ALL, CascadeType.REMOVE })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowMenu"
  )
  private Set<WorkflowSubMenu> workflowSubMenus = new HashSet<>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    WorkflowMenu that = (WorkflowMenu) o;

    if ((menuLinkText != null) ? (!menuLinkText.equals(that.menuLinkText)) : (that.menuLinkText != null)) {
      return false;
    }

    if ((hotSpot != null) ? (!hotSpot.equals(that.hotSpot)) : (that.hotSpot != null)) {
      return false;
    }

    if ((schedule != null) ? (!schedule.equals(that.schedule)) : (that.schedule != null)) {
      return false;
    }

    return !((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot.
   *
   * @return  HotSpot
   */
  public HotSpot getHotSpot() {
    return hotSpot;
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
   * getter method for menu link text.
   *
   * @return  String
   */
  public String getMenuLinkText() {
    return menuLinkText;
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
   * getter method for schedule.
   *
   * @return  SurveySchedule
   */
  public SurveySchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow sub menus.
   *
   * @return  Set
   */
  public Set<WorkflowSubMenu> getWorkflowSubMenus() {
    return workflowSubMenus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.model.BaseObject#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((menuLinkText != null) ? menuLinkText.hashCode() : 0);
    result = (31 * result) + ((hotSpot != null) ? hotSpot.hashCode() : 0);
    result = (31 * result) + ((schedule != null) ? schedule.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot.
   *
   * @param  hotSpot  HotSpot
   */
  public void setHotSpot(HotSpot hotSpot) {
    this.hotSpot = hotSpot;
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
   * setter method for menu link text.
   *
   * @param  menuLinkText  String
   */
  public void setMenuLinkText(String menuLinkText) {
    this.menuLinkText = menuLinkText;
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
   * setter method for schedule.
   *
   * @param  schedule  SurveySchedule
   */
  public void setSchedule(SurveySchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow sub menus.
   *
   * @param  workflowSubMenus  Set
   */
  public void setWorkflowSubMenus(Set<WorkflowSubMenu> workflowSubMenus) {
    this.workflowSubMenus = workflowSubMenus;
  }
} // end class WorkflowMenu
