package com.cmc.credagility.core.domain.preview;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;

import com.ozstrategy.credagility.core.domain.Node;


/**
 * Preview request item capture all request detail item of preview.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:01
 */
@Entity public class PreviewRequestItem extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8777913950918523451L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "previewRequestId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PreviewRequest previewRequest;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long previewRequestItemId;

  /** complete rule content. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String ruleCriteria;

  /** TODO: DOCUMENT ME! */
  @Column(length = 4096)
  protected String ruleForceMapping;

  /** TODO: DOCUMENT ME! */
  @Column protected Long ruleId;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer ruleLevel;

  /** TODO: DOCUMENT ME! */
  @Column(length = 80)
  protected String ruleName;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer rulePriority;

  /** TODO: DOCUMENT ME! */
  @Column protected Long strategyId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    PreviewRequestItem that = (PreviewRequestItem) o;

    if ((ruleCriteria != null) ? (!ruleCriteria.equals(that.ruleCriteria)) : (that.ruleCriteria != null)) {
      return false;
    }

    if ((ruleId != null) ? (!ruleId.equals(that.ruleId)) : (that.ruleId != null)) {
      return false;
    }

    if ((ruleName != null) ? (!ruleName.equals(that.ruleName)) : (that.ruleName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for force mapping variable.
   *
   * @return  Map
   */
  public Map<String, BaseVariable> getForceMappingVariable() {
    Map<String, BaseVariable> mapping = new HashMap<String, BaseVariable>();

    for (String entry : this.ruleForceMapping.split(":")) {
      String[] parts = entry.split("->");

      if (parts.length == 2) {
        if ("calculatedFinalInstallmentDueDate".equalsIgnoreCase(parts[0])) {
          BaseVariable baseVariable = new Variable();
          baseVariable.setName("calculatedFinalInstallmentDueDate");
          baseVariable.setDataType("Date");
          baseVariable.setBusinessDataType("Date");
          baseVariable.setBuildType("evel");
          baseVariable.setCategory("forceMapping");
          baseVariable.setExpression(parts[1]);

          mapping.put("calculatedFinalInstallmentDueDate", baseVariable);
        }
      }
    }


    return mapping;
  } // end method getForceMappingVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request.
   *
   * @return  PreviewRequest
   */
  public PreviewRequest getPreviewRequest() {
    return previewRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview request item id.
   *
   * @return  Long
   */
  public Long getPreviewRequestItemId() {
    return previewRequestItemId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule criteria.
   *
   * @return  String
   */
  public String getRuleCriteria() {
    return ruleCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule force mapping.
   *
   * @return  String
   */
  public String getRuleForceMapping() {
    return ruleForceMapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule level.
   *
   * @return  Integer
   */
  public Integer getRuleLevel() {
    return ruleLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule name.
   *
   * @return  String
   */
  public String getRuleName() {
    return ruleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule priority.
   *
   * @return  Integer
   */
  public Integer getRulePriority() {
    return rulePriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy id.
   *
   * @return  Long
   */
  public Long getStrategyId() {
    return strategyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((ruleCriteria != null) ? ruleCriteria.hashCode() : 0);
    result = (31 * result) + ((ruleId != null) ? ruleId.hashCode() : 0);
    result = (31 * result) + ((ruleName != null) ? ruleName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for base rule.
   *
   * @param  baseRule  BaseRule
   */
  public void setBaseRule(BaseRule baseRule) {
    this.ruleId       = baseRule.getRuleId();
    this.ruleName     = baseRule.getRuleName();
    this.ruleCriteria = baseRule.getRuleCriteria();
    this.rulePriority = baseRule.getPriority();

    StringBuilder sb = new StringBuilder();

    for (Map.Entry<String, String> entry : baseRule.getForceMapping().entrySet()) {
      sb.append(":");
      sb.append(entry.getKey());
      sb.append("->");
      sb.append(entry.getValue());
    }

    if (sb.length() > 0) {
      this.ruleForceMapping = sb.substring(1);
    } else {
      this.ruleForceMapping = "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  Node
   */
  public void setNode(Node node) {
    this.ruleId           = node.getId();
    this.ruleName         = node.getName();
    this.ruleLevel        = node.getLevel();
    this.strategyId       = node.getStrategy().getId();
    this.ruleCriteria     = node.getCompleteCriteria();
    this.rulePriority     = node.getPriority();
    this.ruleForceMapping = "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request.
   *
   * @param  previewRequest  PreviewRequest
   */
  public void setPreviewRequest(PreviewRequest previewRequest) {
    this.previewRequest = previewRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview request item id.
   *
   * @param  previewRequestItemId  Long
   */
  public void setPreviewRequestItemId(Long previewRequestItemId) {
    this.previewRequestItemId = previewRequestItemId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule criteria.
   *
   * @param  ruleCriteria  String
   */
  public void setRuleCriteria(String ruleCriteria) {
    this.ruleCriteria = ruleCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule force mapping.
   *
   * @param  ruleForceMapping  String
   */
  public void setRuleForceMapping(String ruleForceMapping) {
    this.ruleForceMapping = ruleForceMapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule level.
   *
   * @param  ruleLevel  Integer
   */
  public void setRuleLevel(Integer ruleLevel) {
    this.ruleLevel = ruleLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule name.
   *
   * @param  ruleName  String
   */
  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule priority.
   *
   * @param  rulePriority  Integer
   */
  public void setRulePriority(Integer rulePriority) {
    this.rulePriority = rulePriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy id.
   *
   * @param  strategyId  Long
   */
  public void setStrategyId(Long strategyId) {
    this.strategyId = strategyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PreviewRequestItem");
    sb.append("{previewRequest=").append(previewRequest);
    sb.append(", previewRequestItemId=").append(previewRequestItemId);
    sb.append(", ruleCriteria='").append(ruleCriteria).append('\'');
    sb.append(", rulePriority=").append(rulePriority);
    sb.append(", ruleId=").append(ruleId);
    sb.append(", ruleName='").append(ruleName).append('\'');
    sb.append('}');

    return sb.toString();
  }


} // end class PreviewRequestItem
