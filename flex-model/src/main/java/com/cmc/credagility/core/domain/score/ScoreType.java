package com.cmc.credagility.core.domain.score;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:13
 */
@Entity
@Table(
  name              = "ScoreType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "scoreName") }
)
public class ScoreType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6015781059683076586L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name   = "scoreDescription",
    length = 200
  )
  private String scoreDescription;

  @Column(
    name   = "scoreName",
    unique = true,
    length = 60
  )
  private String scoreName;


// npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "scoreTypeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long scoreTypeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final ScoreType other = (ScoreType) obj;

    if (scoreName == null) {
      if (other.scoreName != null) {
        return false;
      }
    } else if (!scoreName.equals(other.scoreName)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score description.
   *
   * @return  String
   */
  public String getScoreDescription() {
    return scoreDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score name.
   *
   * @return  String
   */
  public String getScoreName() {
    return scoreName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type id.
   *
   * @return  Long
   */
  public Long getScoreTypeId() {
    return scoreTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((scoreName == null) ? 0 : scoreName.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score description.
   *
   * @param  scoreDescription  String
   */
  public void setScoreDescription(String scoreDescription) {
    this.scoreDescription = scoreDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score name.
   *
   * @param  scoreName  String
   */
  public void setScoreName(String scoreName) {
    this.scoreName = scoreName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score type id.
   *
   * @param  scoreTypeId  Long
   */
  public void setScoreTypeId(Long scoreTypeId) {
    this.scoreTypeId = scoreTypeId;
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

    retValue = "ScoreDetail ( " + super.toString() + TAB + "scoreId = "
      + this.scoreTypeId + TAB + "scoreName = " + this.scoreName + TAB
      + "scoreDescription = " + this.scoreDescription + TAB + " )";

    return retValue;
  }

} // end class ScoreType
