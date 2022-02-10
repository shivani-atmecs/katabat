package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.responsible.Responsible;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:37
 */
@Entity public class ResponsiblePortfolioScore {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioScoreTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioScoreType portfolioScoreType = new PortfolioScoreType();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible = new Responsible();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsiblePortfolioScoreId;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer score;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    ResponsiblePortfolioScore that = (ResponsiblePortfolioScore) o;

    if ((portfolioScoreType != null) ? (!portfolioScoreType.equals(that.portfolioScoreType))
                                     : (that.portfolioScoreType != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score type.
   *
   * @return  PortfolioScoreType
   */
  public PortfolioScoreType getPortfolioScoreType() {
    return portfolioScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible score id.
   *
   * @return  Long
   */
  public Long getResponsibleScoreId() {
    return responsiblePortfolioScoreId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score.
   *
   * @return  Integer
   */
  public Integer getScore() {
    return score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    return (portfolioScoreType != null) ? portfolioScoreType.hashCode() : 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score type.
   *
   * @param  portfolioScoreType  PortfolioScoreType
   */
  public void setPortfolioScoreType(PortfolioScoreType portfolioScoreType) {
    this.portfolioScoreType = portfolioScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible score id.
   *
   * @param  responsibleScoreId  Long
   */
  public void setResponsibleScoreId(Long responsibleScoreId) {
    this.responsiblePortfolioScoreId = responsibleScoreId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score.
   *
   * @param  score  Integer
   */
  public void setScore(Integer score) {
    this.score = score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ResponsibleScore");
    sb.append("{portfolioScoreType=").append(portfolioScoreType);
    sb.append(", responsible=").append(responsible);
    sb.append(", responsibleScoreId=").append(responsiblePortfolioScoreId);
    sb.append(", score=").append(score);
    sb.append('}');

    return sb.toString();
  }
} // end class ResponsiblePortfolioScore
