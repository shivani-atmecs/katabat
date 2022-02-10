package com.cmc.credagility.core.domain.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store base rule information.
 *
 * <p><a href="BaseRule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, 10/14/2014 416:05 PM
 */
@MappedSuperclass public abstract class BaseRule extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2535315250007985308L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** rule has compiled content. */
  @Column(
    name             = "complied",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean complied;

  /** creator id. */
  @Column(name = "createAgentId")
  protected Long createAgentId;

  /** rule is deployed. */
  @Column(
    name             = "deployed",
    nullable         = false,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deployed;

  // npelleti 08/11 modified the length to 255
  // npelleti 08/17 Modified length to 256, after ruleName
  /** rule description. */
  @Column(
    name   = "description",
    length = 256
  )
  protected String description;

  /** rule is disabled. */
  @Column(
    name             = "disabled",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean disabled;

  /** rule compile error. */
  @Column(
    name             = "errorMessage",
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String errorMessage;

  /** last update user id. */
  @Column(name = "lastUpdateAgentId")
  protected Long lastUpdateAgentId;

  /** rule name. */
  @Column(
    name     = "permanenceCode",
    nullable = true
  )
  protected Integer permanenceCode;

  /** Portfolio Id. */
  @Column(
    name     = "portfolioId",
    nullable = false
  )
  protected Long portfolioId;

  /** rule priority. */
  @Column(name = "priority")
  protected Integer priority = 1;

  /** complete rule content. */
  @Column(
    name             = "ruleContent",
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String ruleContent;

  /** Rule Content optimized version. */
  @Column(columnDefinition = "LONGBLOB")
  @Lob protected byte[] ruleContent2;

  /** rule criteria. */
  @Column(
    name             = "ruleCriteria",
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String ruleCriteria;

  /** rule name. */
  @Column(
    name     = "ruleName",
    length   = 80,
    nullable = false
  )
  protected String ruleName;

  /** Rule run type (batch/cid). */
  @Column(length = 16)
  protected String runType;

  /** rule is valid. */
  @Column(
    name             = "valid",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean valid;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  public abstract Long getRuleId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule type.
   *
   * @return  String
   */
  public abstract String getRuleType();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy properties from other rule.
   *
   * @param  other  DOCUMENT ME!
   */
  public void deepCopy(BaseRule other) {
    if (other.getPortfolioId() != null) {
      this.portfolioId = other.getPortfolioId().longValue();
    }

    this.ruleName       = other.getRuleName();
    this.permanenceCode = other.getPermanenceCode();
    this.description    = other.getDescription();
    this.ruleCriteria   = other.getRuleCriteria();
    this.ruleContent    = other.getRuleContent();
    this.deployed       = false;
    this.valid          = other.getValid();
    this.complied       = other.getComplied();
    this.runType        = other.getRunType();

    if (other.getLastUpdateAgentId() != null) {
      this.lastUpdateAgentId = new Long(other.getLastUpdateAgentId());
    }

    this.lastUpdateDate = new Date();

    if (other.getPriority() != null) {
      this.priority = other.getPriority().intValue();
    }
  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    BaseRule other = (BaseRule) obj;

    if (portfolioId == null) {
      if (other.portfolioId != null) {
        return false;
      }
    } else if (!portfolioId.equals(other.portfolioId)) {
      return false;
    }

    if (ruleCriteria == null) {
      if (other.ruleCriteria != null) {
        return false;
      }
    } else if (!ruleCriteria.equals(other.ruleCriteria)) {
      return false;
    }

    if (ruleName == null) {
      if (other.ruleName != null) {
        return false;
      }
    } else if (!ruleName.equals(other.ruleName)) {
      return false;
    }

    if (runType == null) {
      if (other.runType != null) {
        return false;
      }
    } else if (!runType.equals(other.runType)) {
      return false;
    }

    if (permanenceCode == null) {
      if (other.permanenceCode != null) {
        return false;
      }
    } else if (!permanenceCode.equals(other.permanenceCode)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complied.
   *
   * @return  Boolean
   */
  public Boolean getComplied() {
    return complied;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create agent id.
   *
   * @return  Long
   */
  public Long getCreateAgentId() {
    return createAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed.
   *
   * @return  Boolean
   */
  public Boolean getDeployed() {
    return deployed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disabled.
   *
   * @return  Boolean
   */
  public Boolean getDisabled() {
    return disabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error message.
   *
   * @return  String
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for force mapping.
   *
   * @return  Map
   */
  public Map<String, String> getForceMapping() {
    return new HashMap<String, String>();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for force mapping variable.
   *
   * @return  Map
   */
  public Map<String, BaseVariable> getForceMappingVariable() {
    return new HashMap<String, BaseVariable>();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update agent id.
   *
   * @return  Long
   */
  public Long getLastUpdateAgentId() {
    return lastUpdateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for permanence code.
   *
   * @return  Integer
   */
  public Integer getPermanenceCode() {
    return permanenceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return this.priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule content.
   *
   * @return  String
   */
  public String getRuleContent() {
    return ruleContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule content2.
   *
   * @return  byte[]
   */
  public byte[] getRuleContent2() {
    return ruleContent2;
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
   * getter method for rule name.
   *
   * @return  String
   */
  public String getRuleName() {
    return ruleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run type.
   *
   * @return  String
   */
  public String getRunType() {
    return runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for valid.
   *
   * @return  Boolean
   */
  public Boolean getValid() {
    return valid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((portfolioId == null) ? 0 : portfolioId.hashCode());
    result = (prime * result)
      + ((ruleCriteria == null) ? 0 : ruleCriteria.hashCode());
    result = (prime * result) + ((ruleName == null) ? 0 : ruleName.hashCode());
    result = (prime * result) + ((permanenceCode == null) ? 0 : permanenceCode.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for complied.
   *
   * @param  complied  Boolean
   */
  public void setComplied(Boolean complied) {
    this.complied = complied;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create agent id.
   *
   * @param  createAgentId  Long
   */
  public void setCreateAgentId(Long createAgentId) {
    this.createAgentId = createAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deployed.
   *
   * @param  deployed  Boolean
   */
  public void setDeployed(Boolean deployed) {
    this.deployed = deployed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disabled.
   *
   * @param  disabled  Boolean
   */
  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error message.
   *
   * @param  errorMessage  String
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update agent id.
   *
   * @param  lastUpdateAgentId  Long
   */
  public void setLastUpdateAgentId(Long lastUpdateAgentId) {
    this.lastUpdateAgentId = lastUpdateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for permanence code.
   *
   * @param  permanenceCode  Integer
   */
  public void setPermanenceCode(Integer permanenceCode) {
    this.permanenceCode = permanenceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule content.
   *
   * @param  ruleContent  String
   */
  public void setRuleContent(String ruleContent) {
    this.ruleContent = ruleContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule content2.
   *
   * @param  ruleContent2  byte[]
   */
  public void setRuleContent2(byte[] ruleContent2) {
    this.ruleContent2 = ruleContent2;
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
   * setter method for rule name.
   *
   * @param  ruleName  String
   */
  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run type.
   *
   * @param  runType  String
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for valid.
   *
   * @param  valid  Boolean
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseRule ( ").append(super.toString()).append(TAB).append(
      "complied = ").append(this.complied).append(TAB).append(
      "createAgentId = ").append(this.createAgentId).append(TAB).append(
      "deployed = ").append(this.deployed).append(TAB).append(
      "description = ").append(this.description).append(TAB).append(
      "lastUpdateAgentId = ").append(this.lastUpdateAgentId).append(TAB).append("ruleContent = ").append(
      this.ruleContent).append(TAB).append(
      "ruleCriteria = ").append(this.ruleCriteria).append(TAB).append(TAB).append("ruleName = ").append(this.ruleName)
      .append(TAB).append("valid = ").append(this.valid).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseRule
