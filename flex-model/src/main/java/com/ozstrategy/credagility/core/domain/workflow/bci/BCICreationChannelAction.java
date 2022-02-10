package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCChannelAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yongliu on 6/2/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  06/02/2015 12:55
 */
@Entity @Table public class BCICreationChannelAction extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2667700024426650534L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "caseCreationActionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCICreationActionInfo caseCreationAction;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "channelActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCChannelAction channelAction;

  /** DOCUMENT ME! */
  @Type(type = "text")
  protected String criteria;

  /** DOCUMENT ME! */
  @Column protected Integer priority = 1;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

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

    BCICreationChannelAction that = (BCICreationChannelAction) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((channelAction != null) ? (!channelAction.equals(that.channelAction)) : (that.channelAction != null)) {
      return false;
    }

    return !((caseCreationAction != null) ? (!caseCreationAction.equals(that.caseCreationAction))
                                          : (that.caseCreationAction != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for case creation action.
   *
   * @return  BCICreationActionInfo
   */
  public BCICreationActionInfo getCaseCreationAction() {
    return caseCreationAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action.
   *
   * @return  BCChannelAction
   */
  public BCChannelAction getChannelAction() {
    return channelAction;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((channelAction != null) ? channelAction.hashCode() : 0);
    result = (31 * result) + ((caseCreationAction != null) ? caseCreationAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for case creation action.
   *
   * @param  caseCreationAction  BCICreationActionInfo
   */
  public void setCaseCreationAction(BCICreationActionInfo caseCreationAction) {
    this.caseCreationAction = caseCreationAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel action.
   *
   * @param  channelAction  BCChannelAction
   */
  public void setChannelAction(BCChannelAction channelAction) {
    this.channelAction = channelAction;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
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
} // end class BCICreationChannelAction
