package com.cmc.credagility.core.domain.negotiate;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.program.ProgramTemplate;
import com.cmc.credagility.core.domain.schedule.BaseRule;


/**
 * This class is used to store payment negotiate rule information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 17:42
 */
@Entity @Table public class NegotiateExceptionRule extends BaseRule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5640831664136761796L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "scheduleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected NegotiateExceptionSchedule exceptionSchedule = new NegotiateExceptionSchedule();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "exceptionRule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<ProgramTemplate> programTemplates = new LinkedHashSet<ProgramTemplate>();

  /** Rule Id, PK. */

  @Column(
    name     = "ruleId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ruleId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addProgramTemplate.
   *
   * @param  programTemplate  ProgramTemplate
   */
  public void addProgramTemplate(ProgramTemplate programTemplate) {
    programTemplate.setExceptionRule(this);
    this.programTemplates.add(programTemplate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * businessEquals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (this.equals(obj)) {
      return true;
    }

    NegotiateExceptionRule other = (NegotiateExceptionRule) obj;

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyCriteria.
   *
   * @param  other  NegotiateExceptionRule
   */
  public void copyCriteria(NegotiateExceptionRule other) {
    super.deepCopy(other);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  other  NegotiateExceptionRule
   */
  public void deepCopy(NegotiateExceptionRule other) {
    super.deepCopy(other);

    for (ProgramTemplate programTemplate : other.getProgramTemplates()) {
      addProgramTemplate(programTemplate.duplicate());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  NegotiateExceptionRule
   */
  public NegotiateExceptionRule duplicate() {
    NegotiateExceptionRule newRule = new NegotiateExceptionRule();
    newRule.deepCopy(this);

    return newRule;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  //~ ------------------------------------------------------------------------------------------------------------------

  // @Override public boolean equals(Object o) {
  //
  // if (this == o) {
  // return true;
  // }
  //
  // if (!(o instanceof NegotiateExceptionRule)) {
  // return false;
  // }
  //
  // if (!super.equals(o)) {
  // return false;
  // }
  //
  // NegotiateExceptionRule that = (NegotiateExceptionRule) o;
  //
  // if ((programTemplates != null) ? (!programTemplates.equals(that.programTemplates))
  // : (that.programTemplates != null)) {
  // return false;
  // }
  //
  // return true;
  // }

  /**
   * getter method for exception schedule.
   *
   * @return  NegotiateExceptionSchedule
   */
  public NegotiateExceptionSchedule getExceptionSchedule() {
    return exceptionSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program templates.
   *
   * @return  Set
   */
  public Set<ProgramTemplate> getProgramTemplates() {
    return programTemplates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  @Override public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule type.
   *
   * @return  String
   */
  @Override public String getRuleType() {
    return "NegotiateRule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // /**
  // * @see  com.cmc.credagility.BaseRule#hashCode()
  // */
  // @Override public int hashCode() {
  // int result = super.hashCode();
  // result = (31 * result) + ((programTemplates != null) ? programTemplates.hashCode() : 0);
  //
  // return result;
  // }


  // public PaymentProgramType getType() {
  // return type;
  // }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */


  public ProgramTemplate removeProgramTemplate(Long templateId) {
    for (ProgramTemplate template : this.programTemplates) {
      if (template.getId().equals(templateId)) {
        if (this.programTemplates.remove(template)) {
          template.setExceptionRule(null);

          return template;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exception schedule.
   *
   * @param  exceptionSchedule  NegotiateExceptionSchedule
   */
  public void setExceptionSchedule(NegotiateExceptionSchedule exceptionSchedule) {
    this.exceptionSchedule = exceptionSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program templates.
   *
   * @param  programTemplates  Set
   */
  public void setProgramTemplates(Set<ProgramTemplate> programTemplates) {
    this.programTemplates = programTemplates;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("NegotiateExceptionRule");
    sb.append("{exceptionSchedule=").append(exceptionSchedule);
    sb.append(", programTemplates=").append(programTemplates);
    sb.append(", ruleId=").append(ruleId);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateProgramTemplate.
   *
   * @param  programTemplate  ProgramTemplate
   */
  public void updateProgramTemplate(ProgramTemplate programTemplate) {
    Long templateId = programTemplate.getId();

    for (ProgramTemplate template : this.programTemplates) {
      if (template.getId().equals(templateId)) {
        template.update(programTemplate);

        break;
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update rule form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   negotiateRule  DOCUMENT ME!
   *
   * @return  update rule form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateRule(NegotiateExceptionRule negotiateRule) {
    // if (!businessEquals(negotiateRule) || !(CompareUtil.nullSafeEquals(this.priority, negotiateRule.priority))) {
    //
    // // there are difference, copy form it
    this.deepCopy(negotiateRule);

    return true;
      // }
      //
      // return false;
  }
} // end class NegotiateExceptionRule
