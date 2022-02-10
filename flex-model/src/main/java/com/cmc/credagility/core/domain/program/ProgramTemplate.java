package com.cmc.credagility.core.domain.program;

import java.math.BigDecimal;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.negotiate.NegotiateExceptionRule;
import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import com.cmc.credagility.core.domain.portfolio.FrequencyDuration;
import com.cmc.credagility.core.domain.type.RoundType;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:48
 */
@Entity @Table public class ProgramTemplate extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5856585137733554507L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Allowed Payment Date Range. */
  @Column(nullable = false)
  protected Integer allowedPaymentDateRange = 1;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal displayPercentage;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "ruleId")
  @ManyToOne protected NegotiateExceptionRule exceptionRule;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "ProgramTemplateFrequencyDuration",
    indexes            = {
      @Index(
        name           = "templateId",
        columnList     = "templateId"
      )
    },
    joinColumns        = {
      @JoinColumn(
        name           = "templateId",
        nullable       = false,
        updatable      = true
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "frequencyId",
        nullable       = false,
        updatable      = true
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<FrequencyDuration> frequencyDurations = new LinkedHashSet<FrequencyDuration>();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String installmentAmountExpression;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGBLOB")
  @Lob protected byte[] installmentAmountExpression2;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer installmentDateTolerence = 1;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected BigDecimal installmentDollarTolerence = new BigDecimal(
      "1.00");

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "programTypeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgramType paymentProgramType;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 0;

  /** TODO: DOCUMENT ME! */
  @Column(length = 40)
  protected String programTemplateName;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "TemplateRole",
    indexes            = { @Index(columnList = "templateId") },
    joinColumns        = {
      @JoinColumn(
        name           = "templateId",
        nullable       = false,
        updatable      = true
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = true
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<Role> roles = new LinkedHashSet<Role>();

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  @Enumerated(value = EnumType.STRING)
  protected RoundType roundType = RoundType.CENTS_UP;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String totalAmountExpression;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGBLOB")
  @Lob protected byte[] totalAmountExpression2;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer validDays;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean webOffer;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  ProgramTemplate
   */
  public ProgramTemplate duplicate() {
    ProgramTemplate newTemplate = new ProgramTemplate();
    newTemplate.programTemplateName         = this.getProgramTemplateName();
    newTemplate.installmentAmountExpression = this.getInstallmentAmountExpression();
    newTemplate.totalAmountExpression       = this.getTotalAmountExpression();
    newTemplate.frequencyDurations.addAll(this.getFrequencyDurations());
    newTemplate.paymentProgramType = this.getPaymentProgramType();
    newTemplate.roles.addAll(this.getRoles());
    newTemplate.roundType                  = this.getRoundType();
    newTemplate.validDays                  = this.getValidDays();
    newTemplate.priority                   = this.getPriority();
    newTemplate.displayPercentage          = this.getDisplayPercentage();
    newTemplate.webOffer                   = this.getWebOffer();
    newTemplate.installmentDateTolerence   = this.getInstallmentDateTolerence();
    newTemplate.installmentDollarTolerence = this.getInstallmentDollarTolerence();
    newTemplate.allowedPaymentDateRange    = this.getAllowedPaymentDateRange();

    return newTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    ProgramTemplate that = (ProgramTemplate) o;

    if ((programTemplateName != null) ? (!programTemplateName.equals(that.programTemplateName))
                                      : (that.programTemplateName != null)) {
      return false;
    }

    if ((exceptionRule != null) ? (!exceptionRule.equals(that.exceptionRule)) : (that.exceptionRule != null)) {
      return false;
    }

    if ((installmentAmountExpression != null) ? (!installmentAmountExpression.equals(
              that.installmentAmountExpression)) : (that.installmentAmountExpression != null)) {
      return false;
    }

    if ((paymentProgramType != null) ? (!paymentProgramType.equals(that.paymentProgramType))
                                     : (that.paymentProgramType != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((totalAmountExpression != null) ? (!totalAmountExpression.equals(that.totalAmountExpression))
                                        : (that.totalAmountExpression != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAllowedPaymentDateRange() {
    return allowedPaymentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getDisplayPercentage() {
    return displayPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public NegotiateExceptionRule getExceptionRule() {
    return exceptionRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<FrequencyDuration> getFrequencyDurations() {
    return frequencyDurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
  public String getInstallmentAmountExpression() {
    return installmentAmountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public byte[] getInstallmentAmountExpression2() {
    return installmentAmountExpression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getInstallmentDateTolerence() {
    return installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getInstallmentDollarTolerence() {
    return installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentProgramType getPaymentProgramType() {
    return paymentProgramType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProgramTemplateName() {
    return programTemplateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<Role> getRoles() {
    return roles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public RoundType getRoundType() {
    return roundType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTotalAmountExpression() {
    return totalAmountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public byte[] getTotalAmountExpression2() {
    return totalAmountExpression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getValidDays() {
    return validDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getWebOffer() {
    return webOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((programTemplateName != null) ? programTemplateName.hashCode() : 0);
    result = (31 * result) + ((installmentAmountExpression != null) ? installmentAmountExpression.hashCode() : 0);
    result = (31 * result) + ((totalAmountExpression != null) ? totalAmountExpression.hashCode() : 0);
    result = (31 * result) + ((exceptionRule != null) ? exceptionRule.hashCode() : 0);
    result = (31 * result) + ((paymentProgramType != null) ? paymentProgramType.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void removeRole(Role role) {
    if (role == null) {
      return;
    }

    for (Role curRole : this.roles) {
      if (curRole.getId().equals(role.getId())) {
        this.roles.remove(curRole);

        return;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowedPaymentDateRange  DOCUMENT ME!
   */
  public void setAllowedPaymentDateRange(Integer allowedPaymentDateRange) {
    this.allowedPaymentDateRange = allowedPaymentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayPercentage  DOCUMENT ME!
   */
  public void setDisplayPercentage(BigDecimal displayPercentage) {
    this.displayPercentage = displayPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exceptionRule  DOCUMENT ME!
   */
  public void setExceptionRule(NegotiateExceptionRule exceptionRule) {
    this.exceptionRule = exceptionRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequencyDurations  DOCUMENT ME!
   */
  public void setFrequencyDurations(Set<FrequencyDuration> frequencyDurations) {
    this.frequencyDurations = frequencyDurations;
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
   * @param  installmentAmountExpression  DOCUMENT ME!
   */
  public void setInstallmentAmountExpression(String installmentAmountExpression) {
    this.installmentAmountExpression = installmentAmountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentAmountExpression2  DOCUMENT ME!
   */
  public void setInstallmentAmountExpression2(byte[] installmentAmountExpression2) {
    this.installmentAmountExpression2 = installmentAmountExpression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentDateTolerence  DOCUMENT ME!
   */
  public void setInstallmentDateTolerence(Integer installmentDateTolerence) {
    this.installmentDateTolerence = installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  installmentDollarTolerence  DOCUMENT ME!
   */
  public void setInstallmentDollarTolerence(BigDecimal installmentDollarTolerence) {
    this.installmentDollarTolerence = installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentProgramType  DOCUMENT ME!
   */
  public void setPaymentProgramType(PaymentProgramType paymentProgramType) {
    this.paymentProgramType = paymentProgramType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programTemplateName  DOCUMENT ME!
   */
  public void setProgramTemplateName(String programTemplateName) {
    this.programTemplateName = programTemplateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  roles  DOCUMENT ME!
   */
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  roundType  DOCUMENT ME!
   */
  public void setRoundType(RoundType roundType) {
    this.roundType = roundType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalAmountExpression  DOCUMENT ME!
   */
  public void setTotalAmountExpression(String totalAmountExpression) {
    this.totalAmountExpression = totalAmountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalAmountExpression2  DOCUMENT ME!
   */
  public void setTotalAmountExpression2(byte[] totalAmountExpression2) {
    this.totalAmountExpression2 = totalAmountExpression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validDays  DOCUMENT ME!
   */
  public void setValidDays(Integer validDays) {
    this.validDays = validDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webOffer  DOCUMENT ME!
   */
  public void setWebOffer(Boolean webOffer) {
    this.webOffer = webOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ProgramTemplate");
    sb.append("{displayPercentage=").append(displayPercentage);
    sb.append(", exceptionRule=").append(exceptionRule);
    sb.append(", frequencyDurations=").append(frequencyDurations);
    sb.append(", id=").append(id);
    sb.append(", installmentAmountExpression='").append(installmentAmountExpression).append('\'');
    sb.append(", installmentAmountExpression2=").append((installmentAmountExpression2 == null) ? "null" : "");

    for (int i = 0; (installmentAmountExpression2 != null) && (i < installmentAmountExpression2.length); ++i) {
      sb.append((i == 0) ? "" : ", ").append(installmentAmountExpression2[i]);
    }

    sb.append(", paymentProgramType=").append(paymentProgramType);
    sb.append(", priority=").append(priority);
    sb.append(", roles=").append(roles);
    sb.append(", roundType=").append(roundType);
    sb.append(", totalAmountExpression='").append(totalAmountExpression).append('\'');
    sb.append(", totalAmountExpression2=").append((totalAmountExpression2 == null) ? "null" : "");

    for (int i = 0; (totalAmountExpression2 != null) && (i < totalAmountExpression2.length); ++i) {
      sb.append((i == 0) ? "" : ", ").append(totalAmountExpression2[i]);
    }

    sb.append(", validDays=").append(validDays);
    sb.append(", webOffer=").append(webOffer);
    sb.append(", name='").append(programTemplateName).append('\'');
    sb.append('}');

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(ProgramTemplate other) {
    this.programTemplateName         = other.getProgramTemplateName();
    this.installmentAmountExpression = other.getInstallmentAmountExpression();
    this.totalAmountExpression       = other.getTotalAmountExpression();
    this.frequencyDurations          = other.getFrequencyDurations();
    this.paymentProgramType          = other.getPaymentProgramType();
    this.roles                       = other.getRoles();
    this.roundType                   = other.getRoundType();
    this.validDays                   = other.getValidDays();
    this.priority                    = other.getPriority();
    this.displayPercentage           = other.getDisplayPercentage();
    this.webOffer                    = other.getWebOffer();
    this.installmentDateTolerence    = other.getInstallmentDateTolerence();
    this.installmentDollarTolerence  = other.getInstallmentDollarTolerence();
    this.allowedPaymentDateRange     = other.getAllowedPaymentDateRange();
  }
} // end class ProgramTemplate
