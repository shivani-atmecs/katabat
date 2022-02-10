package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;


/**
 * PersonaAction.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  01/22/2015 12:37
 */
@Entity public class PersonaAction extends PortfolioBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8542606003846798348L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         accountLabeledDate;

  @Column(nullable = true)
  private Integer duplicateCount = 0;

  @Column(length = 255)
  private String endTime;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodePersonaActions"
  )
  private Set<Node> personaNodes = new LinkedHashSet<Node>();

  @Transient private Set<Long> processedAccounts = new HashSet<Long>();

  @Column(length = 255)
  private String startTime;

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean visible;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PersonaAction object.
   */
  public PersonaAction() {
    actionType = BaseNodeAction.ActionType_Persona;
  }

  /**
   * Creates a new PersonaAction object.
   *
   * @param  id  Long
   */
  public PersonaAction(Long id) {
    this.id = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    PersonaAction personaAction = new PersonaAction();
    personaAction.updateNodeAction(this);
    personaAction.setPortfolio(this.getPortfolio());
    personaAction.setName(this.getName());
    personaAction.setVisible(Boolean.TRUE);
    personaAction.setStartTime(this.getStartTime());
    personaAction.setEndTime(this.getEndTime());

    return personaAction;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioBaseNodeAction#equals(Object)
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

    PersonaAction that = (PersonaAction) o;

    if ((duplicateCount != null) ? (!duplicateCount.equals(that.duplicateCount)) : (that.duplicateCount != null)) {
      return false;
    }

    if ((endTime != null) ? (!endTime.equals(that.endTime)) : (that.endTime != null)) {
      return false;
    }

    if ((startTime != null) ? (!startTime.equals(that.startTime)) : (that.startTime != null)) {
      return false;
    }

    if ((visible != null) ? (!visible.equals(that.visible)) : (that.visible != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      RunType runType = (RunType) params.get("runType");

      if (((runType.isBatch()) || (runType.isEvent()))) {
        this.triggered = true;

        Responsible responsible = (Responsible) params.get("responsible");
        Account     account     = (Account) params.get("account");
        boolean     deltaBatch  = (Boolean) params.get("deltaBatch");
        Long        batchId     = Long.parseLong((String) params.get("batchId"));

        if (deltaBatch) {
          if (logger.isDebugEnabled()) {
            logger.debug("create queue result from deltaBatch file.");
          }
        }

        Long accountNum = account.getAccountNum();

        // skip this account if it was processed before
        // since the responsible are sorted by primaryHolder so that we
        // are safe
        if (!processedAccounts.contains(accountNum)) {
          processedAccounts.add(accountNum);

          PersonaAccount personaAccount = new PersonaAccount();
          personaAccount.setAccount(account);
          personaAccount.setResponsible(responsible);
          personaAccount.setPersonaAction(this);
          personaAccount.setDeltaBatch(deltaBatch);
          personaAccount.setMasterBatchId(batchId);

          executeHelper.addSingleObject("PersonaAccount", personaAccount);
          executeHelper.addResult(personaAccount);

          if (accountLabeledDate == null) {
            accountLabeledDate = new Date();
            executeHelper.addSingleObject("PersonaAction", this);
          }
        } // end if
      }   // end if
    }     // end if
  }       // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account labeled date.
   *
   * @return  Date
   */
  public Date getAccountLabeledDate() {
    return accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete criteria.
   *
   * @return  String
   */
  public String getCompleteCriteria() {
    return this.criteria;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duplicate count.
   *
   * @return  Integer
   */
  public Integer getDuplicateCount() {
    return duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end time.
   *
   * @return  String
   */
  public String getEndTime() {
    return endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona nodes.
   *
   * @return  Set
   */
  public Set<Node> getPersonaNodes() {
    return personaNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start time.
   *
   * @return  String
   */
  public String getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visible.
   *
   * @return  Boolean
   */
  public Boolean getVisible() {
    return visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioBaseNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((accountLabeledDate != null) ? accountLabeledDate.hashCode() : 0);
    result = (31 * result) + ((duplicateCount != null) ? duplicateCount.hashCode() : 0);
    result = (31 * result) + ((endTime != null) ? endTime.hashCode() : 0);
    result = (31 * result) + ((logger != null) ? logger.hashCode() : 0);
    result = (31 * result) + ((startTime != null) ? startTime.hashCode() : 0);
    result = (31 * result) + ((visible != null) ? visible.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account labeled date.
   *
   * @param  accountLabeledDate  Date
   */
  public void setAccountLabeledDate(Date accountLabeledDate) {
    this.accountLabeledDate = accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duplicate count.
   *
   * @param  duplicateCount  Integer
   */
  public void setDuplicateCount(Integer duplicateCount) {
    this.duplicateCount = duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end time.
   *
   * @param  endTime  String
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for persona nodes.
   *
   * @param  personaNodes  Set
   */
  public void setPersonaNodes(Set<Node> personaNodes) {
    this.personaNodes = personaNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start time.
   *
   * @param  startTime  String
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visible.
   *
   * @param  visible  Boolean
   */
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#toString()
   */
  @Override public String toString() {
    return "PersonaAction{"
      + "accountLabeledDate=" + accountLabeledDate
      + ", duplicateCount=" + duplicateCount
      + ", endTime='" + endTime + '\''
      + ", personaNodes=" + personaNodes
      + ", processedAccounts=" + processedAccounts
      + ", startTime='" + startTime + '\''
      + ", visible=" + visible
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#updateNodeAction(BaseNodeAction)
   */
  @Override public boolean updateNodeAction(BaseNodeAction queueAction) {
    return super.updateNodeAction(queueAction);
  }
} // end class PersonaAction
