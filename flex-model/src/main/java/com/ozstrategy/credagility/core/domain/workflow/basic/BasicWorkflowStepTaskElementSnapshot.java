package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.annotations.EvaluateMessageProperty;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/5/13 Time: 11:49 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowStepTaskElementSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5313880386554232641L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> is inactive, transient. */
  @Transient public boolean inactive;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Question text. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String questionText;

  /** Question text 2. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String questionText2;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuestionText() {
    return questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuestionText2() {
    return questionText2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isInactive() {
    return inactive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  inactive  DOCUMENT ME!
   */
  public void setInactive(boolean inactive) {
    this.inactive = inactive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionText  DOCUMENT ME!
   */
  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionText2  DOCUMENT ME!
   */
  public void setQuestionText2(String questionText2) {
    this.questionText2 = questionText2;
  }
} // end class BasicWorkflowStepTaskElementSnapshot
