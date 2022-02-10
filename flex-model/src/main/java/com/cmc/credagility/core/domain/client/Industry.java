package com.cmc.credagility.core.domain.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Industry information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:37
 */
@Entity
@Table(name = "Industry")
public class Industry extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6173035943480398028L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** comments. */
  @Column(
    name   = "comments",
    length = 1024
  )
  protected String comments;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** industry PK industryId. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         industryId;

  /** industry industryName. */
  @Column(
    name     = "industryName",
    nullable = false,
    length   = 80
  )
  protected String industryName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Industry other = (Industry) obj;

    if (industryName == null) {
      if (other.getIndustryName() != null) {
        return false;
      }
    } else if (!industryName.equals(other.getIndustryName())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comments.
   *
   * @return  String
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for industry id.
   *
   * @return  Long
   */
  public Long getIndustryId() {
    return industryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for industry name.
   *
   * @return  String
   */
  public String getIndustryName() {
    return industryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((industryName == null) ? 0 : industryName.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comments.
   *
   * @param  comments  String
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for industry id.
   *
   * @param  industryId  Long
   */
  public void setIndustryId(Long industryId) {
    this.industryId = industryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for industry name.
   *
   * @param  industryName  String
   */
  public void setIndustryName(String industryName) {
    this.industryName = industryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in industryName = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("Industry ( ").append("comments = ").append(this.comments).append(TAB).append("industryId = ")
      .append(this.industryId).append(TAB).append("industryName = ").append(this.industryName).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class Industry
