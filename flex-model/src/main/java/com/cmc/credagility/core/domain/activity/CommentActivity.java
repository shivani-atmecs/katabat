package com.cmc.credagility.core.domain.activity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.portfolio.OutcomeType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:52
 */
@Entity
@Table(name = "CommentActivity")
public class CommentActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6350320481569356246L;

  /** activity type. */
  private static String CHANNEL = "Comment";

  /** activity type. */
  private static String NAME = "CommentActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "resultId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected OutcomeType result;

  @Column(
    name     = "activityId",

    // unique   = true, npelleti, 07/30, USBank, Drop key
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long activityId;

  @Column(
    name   = "comment",
    length = 200
  )
  private String comment;

  /** This activity could be imported. So comment date is important. */
  @Column(name = "commentDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date commentDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getActivityDate()
   */
  @Override public Date getActivityDate() {
    return commentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for activity id.
   *
   * @return  Long
   */
  public Long getActivityId() {
    return activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comment.
   *
   * @return  String
   */
  public String getComment() {
    return comment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comment date.
   *
   * @return  Date
   */
  public Date getCommentDate() {
    return commentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getName()
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result.
   *
   * @return  OutcomeType
   */
  public OutcomeType getResult() {
    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for activity id.
   *
   * @param  activityId  Long
   */
  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comment.
   *
   * @param  comment  String
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comment date.
   *
   * @param  commentDate  Date
   */
  public void setCommentDate(Date commentDate) {
    this.commentDate = commentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result.
   *
   * @param  result  OutcomeType
   */
  public void setResult(OutcomeType result) {
    this.result = result;
  }

} // end class CommentActivity
