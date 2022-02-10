package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:27
 */
public enum QuestionLayout {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  QA, // Question & Answer
  AQ, // Answer & Question
  QAQ; // Question, Answer & Question

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toQuestionLayoutType.
   *
   * @param   strValue  String
   *
   * @return  QuestionLayout
   */
  public static QuestionLayout toQuestionLayoutType(String strValue) {
    try {
      return QuestionLayout.valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
