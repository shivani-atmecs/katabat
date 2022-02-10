package com.cmc.credagility.core.domain.responsible;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.score.BaseScore;


/**
 * This class is used to store ResponsibleScore information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:44
 */
@Entity
@Table(name = "ResponsibleScore")
public class ResponsibleScore extends BaseScore {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8140047392522309895L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;


  @Column(
    name     = "responsibleScoreLinkId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long responsibleScoreLinkId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    return super.equals(obj);
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
   * getter method for responsible score link id.
   *
   * @return  Long
   */
  public Long getResponsibleScoreLinkId() {
    return responsibleScoreLinkId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#hashCode()
   */
  @Override public int hashCode() {
    return super.hashCode();
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
   * setter method for responsible score link id.
   *
   * @param  responsibleScoreLinkId  Long
   */
  public void setResponsibleScoreLinkId(Long responsibleScoreLinkId) {
    this.responsibleScoreLinkId = responsibleScoreLinkId;
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

    retValue = "ResponsibleScore ( " + super.toString() + TAB
      + "responsibleScoreLinkId = " + this.responsibleScoreLinkId + TAB
      + "responsibleId = " + this.responsible.getResponsibleId() + TAB + " )";

    return retValue;
  }

} // end class ResponsibleScore
