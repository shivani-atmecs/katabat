package com.cmc.credagility.core.domain.score;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.ScoreSource;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.domain.util.DateUtil;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:12
 */
@MappedSuperclass public class BaseScore extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2098750046299574252L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "scoreDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date        scoreDate;
  @Column(
    name   = "scoreSource",
    length = 10
  )
  @Enumerated(value = EnumType.STRING)
  private ScoreSource scoreSource;
  @JoinColumn(
    name      = "scoreTypeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private ScoreType   scoreType;
  @Column(
    name     = "scoreValue",
    nullable = false
  )
  private Integer     scoreValue;

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

    final BaseScore other = (BaseScore) obj;

    if (scoreDate == null) {
      if (other.scoreDate != null) {
        return false;
      }
    } else if (!CompareUtil.isDateEqual(scoreDate, other.scoreDate)) {
      // Only compare the Date part, not time part
      return false;
    }

    if (scoreType == null) {
      if (other.scoreType != null) {
        return false;
      }
    } else if (!scoreType.equals(other.scoreType)) {
      return false;
    }

    if (scoreValue == null) {
      if (other.scoreValue != null) {
        return false;
      }
    } else if (!scoreValue.equals(other.scoreValue)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score date.
   *
   * @return  Date
   */
  public Date getScoreDate() {
    return this.scoreDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score source.
   *
   * @return  ScoreSource
   */
  public ScoreSource getScoreSource() {
    return scoreSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type.
   *
   * @return  ScoreType
   */
  public ScoreType getScoreType() {
    return scoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score value.
   *
   * @return  Integer
   */
  public Integer getScoreValue() {
    return scoreValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((scoreDate == null) ? 0 : scoreDate.hashCode());
    result = (prime * result) + ((scoreType == null) ? 0 : scoreType.hashCode());
    result = (prime * result)
      + ((scoreValue == null) ? 0 : scoreValue.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set Date only. Do not set the time period.
   *
   * @param  scoreDate  DOCUMENT ME!
   */
  public void setScoreDate(Date scoreDate) {
    if (scoreDate != null) {
      this.scoreDate = DateUtil.toDateOnly(scoreDate);
    } else {
      this.scoreDate = null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score source.
   *
   * @param  scoreSource  ScoreSource
   */
  public void setScoreSource(ScoreSource scoreSource) {
    this.scoreSource = scoreSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score type.
   *
   * @param  scoreType  ScoreType
   */
  public void setScoreType(ScoreType scoreType) {
    this.scoreType = scoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score value.
   *
   * @param  scoreValue  Integer
   */
  public void setScoreValue(Integer scoreValue) {
    this.scoreValue = scoreValue;
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

    retValue = "BaseScore ( " + super.toString() + TAB + "scoreDate = "
      + this.scoreDate + TAB + "scoreDetail = " + this.scoreType + TAB
      + "scoreSource = " + this.scoreSource + TAB + "scoreValue = "
      + this.scoreValue + TAB + " )";

    return retValue;
  }

} // end class BaseScore
