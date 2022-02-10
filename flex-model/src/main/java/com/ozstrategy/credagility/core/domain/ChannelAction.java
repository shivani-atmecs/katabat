package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.channel.*;
import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.contact.ContactEmail;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplate;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.domain.webactivity.Session;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.*;


/**
 * This class is used to store program action information.
 *
 * <p><a href="ProgramAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "actionNameIndex",
      columnList = "name"
    )
  }
)
public class ChannelAction extends PortfolioBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6654386149257868514L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<TargetAddressTypeConfiguration> addressTypeConfigurations =
    new LinkedHashSet<TargetAddressTypeConfiguration>();

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  protected String category;


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeChannelActions"
  )
  protected Set<Node> channelNodes = new LinkedHashSet<Node>();

  /** multiple /single.* */
  @Column(length = 32)
  protected String channelTargetMethod;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer defaultDeliveryPerHour;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String eeVariableName;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<TargetEmailTypeConfiguration> emailTypeConfigurations =
    new LinkedHashSet<TargetEmailTypeConfiguration>();


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String endTime;

  /** Channel Template Type. */
  @JoinColumn(
    name     = "enterpriseDocumentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument enterpriseDocument;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer evenDistributionHours;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<TargetPhoneTypeConfiguration> phoneTypeConfigurations =
    new LinkedHashSet<TargetPhoneTypeConfiguration>();


  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String recipientType;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String startTime;

  /** Channel Template Type. */
  @JoinColumn(
    name     = "channelTemplateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioChannelTemplate template = new PortfolioChannelTemplate();


  /** TODO: DOCUMENT ME! */
  @Transient protected String templateId;


  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  protected String templateType;


  /** TODO: DOCUMENT ME! */
  @Transient protected Node triggeredNode;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelVendorId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelVendor vendor = new ChannelVendor();


  /** TODO: DOCUMENT ME! */
  @Transient protected String vendorId;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean              visible;
  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ChannelAction object.
   */
  public ChannelAction() {
    actionType = BaseNodeAction.ActionType_Channel;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addTargetAddressTypeConfiguration.
   *
   * @param  addressTypeConfiguration  TargetAddressTypeConfiguration
   */
  public void addTargetAddressTypeConfiguration(TargetAddressTypeConfiguration addressTypeConfiguration) {
    addressTypeConfiguration.setChannelAction(this);
    this.addressTypeConfigurations.add(addressTypeConfiguration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTargetEmailTypeConfiguration.
   *
   * @param  emailTypeConfiguration  TargetEmailTypeConfiguration
   */
  public void addTargetEmailTypeConfiguration(TargetEmailTypeConfiguration emailTypeConfiguration) {
    emailTypeConfiguration.setChannelAction(this);
    this.emailTypeConfigurations.add(emailTypeConfiguration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTargetPhoneTypeConfiguration.
   *
   * @param  phoneTypeConfiguration  TargetPhoneTypeConfiguration
   */
  public void addTargetPhoneTypeConfiguration(TargetPhoneTypeConfiguration phoneTypeConfiguration) {
    phoneTypeConfiguration.setChannelAction(this);
    this.phoneTypeConfigurations.add(phoneTypeConfiguration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() {
    // To change body of implemented methods use File | Settings | File
    // Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * clearTargetTypeConfigurations.
   */
  public void clearTargetTypeConfigurations() {
    this.emailTypeConfigurations.clear();
    this.addressTypeConfigurations.clear();
    this.phoneTypeConfigurations.clear();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  @Override public BaseNodeAction duplicate() {
    // if (this.duplicateCount == null) {
    // this.duplicateCount = 0;
    // }
    //
    // this.duplicateCount++;

    ChannelAction channelAction = new ChannelAction();
    channelAction.updateNodeAction(this);
    channelAction.setPortfolio(channelAction.getPortfolio());
    channelAction.setName(channelAction.getName());
    channelAction.setTemplateType(this.getTemplateType());

    for (TargetAddressTypeConfiguration addressTypeConfiguration : this.addressTypeConfigurations) {
      channelAction.addTargetAddressTypeConfiguration(addressTypeConfiguration.duplicate());
    }

    for (TargetEmailTypeConfiguration emailTypeConfiguration : this.emailTypeConfigurations) {
      channelAction.addTargetEmailTypeConfiguration(emailTypeConfiguration.duplicate());
    }

    for (TargetPhoneTypeConfiguration phoneTypeConfiguration : this.phoneTypeConfigurations) {
      channelAction.addTargetPhoneTypeConfiguration(phoneTypeConfiguration.duplicate());
    }

    channelAction.setTemplate(this.getTemplate());
    channelAction.setVendor(this.getVendor());
    channelAction.setChannelTargetMethod(this.getChannelTargetMethod());
    channelAction.setVisible(Boolean.TRUE);

    return channelAction;
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

    ChannelAction that = (ChannelAction) o;

    if ((endTime != null) ? (!endTime.equals(that.endTime)) : (that.endTime != null)) {
      return false;
    }

    if ((startTime != null) ? (!startTime.equals(that.startTime)) : (that.startTime != null)) {
      return false;
    }

    if ((template != null) ? (!template.equals(that.template)) : (that.template != null)) {
      return false;
    }

    if ((vendor != null) ? (!vendor.equals(that.vendor)) : (that.vendor != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  boolean
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    return helper.evaluate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  evaluateHelper  helper toExecute DOCUMENT ME!
   * @param  executeHelper   DOCUMENT ME!
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      Responsible responsible = (Responsible) params.get("responsible");
      Account     account     = (Account) params.get("account");
      Payment     payment     = (Payment) params.get("payment");
      boolean     deltaBatch  = (Boolean) params.get("deltaBatch");
      Session     session     = (Session) params.get("session");

      if (deltaBatch) {
        if (logger.isDebugEnabled()) {
          logger.debug("create channel result from deltaBatch file.");
        }
      }


      if (Boolean.TRUE.equals(account.getDoNotContact())
            || Boolean.TRUE.equals(responsible.getDoNotContact())) {
        this.triggered = false;
      } else {
        // allow this channel result, generate
        this.triggered = true;

        Date                          today       = DateUtil.toDateOnly(new Date());
        Long                          batchId     = Long.parseLong((String) params.get("batchId"));
        RunType                       runType     = (RunType) params.get("runType");
        SurveyFlowStep                flowStep    = (SurveyFlowStep) params.get("flowStep");
        WorkflowNodeActionTriggerType triggerType = (WorkflowNodeActionTriggerType) params.get("triggerType");

        String source = null;

        if (runType.isBatch()) {
          source = "BATCH";
        } else if (runType.isCID()) {
          source = "CID";
        } else if (runType.isEvent()) {
          source = "CID";
        }

        if ((source != null) && (runType.isChannel())) {
          Set<BaseChannelResult> channelResults = new LinkedHashSet<BaseChannelResult>();
          String                 objectName     = "";

          if ("email".equalsIgnoreCase(templateType) && enterpriseDocument.getAllowEmail()) {
            Long externalEntityId = null;

            if (StringUtils.hasText(recipientType) && "ExternalEntity".equalsIgnoreCase(recipientType)) {
              if (StringUtils.hasText(eeVariableName)) {
                externalEntityId = evaluateHelper.evaluateEEVariable(eeVariableName);

                if (null == externalEntityId) {
                  logger.error("External Entity evaluate value is null");

                  return;
                }
                // TODO
              } else {
                logger.error("External Entity variable is null");

                return;
              }
            }

            EmailChannelResult emailChannelResult = createChannelResult(new EmailChannelResult(), batchId, today,
                account, responsible, source, session);
            objectName = "EmailChannelResult";
            emailChannelResult.setSurveyFlowStep(flowStep);
            emailChannelResult.setSurveyFlowMode(triggerType);
            emailChannelResult.setPayment(payment);
            emailChannelResult.setDeltaBatch(deltaBatch);
            emailChannelResult.setEeVariableName(eeVariableName);
            emailChannelResult.setExternalEntityId(externalEntityId);
            emailChannelResult.setRecipientType(recipientType);
            emailChannelResult.setStartTime(startTime);

            channelResults.add(emailChannelResult);

            if (logger.isDebugEnabled()) {
              logger.debug("Email Channel Result added.");
            }

          } else if ("letter".equalsIgnoreCase(templateType) && enterpriseDocument.getAllowLetter()) {
            Long externalEntityId = null;

            if (StringUtils.hasText(recipientType) && "ExternalEntity".equalsIgnoreCase(recipientType)) {
              if (StringUtils.hasText(eeVariableName)) {
                externalEntityId = evaluateHelper.evaluateEEVariable(eeVariableName);

                if (null == externalEntityId) {
                  logger.error("External Entity evaluate value is null");

                  return;
                }
                // TODO
              } else {
                logger.error("External Entity variable is null");

                return;
              }
            }

            LetterChannelResult letterChannelResult = createChannelResult(new LetterChannelResult(), batchId, today,
                account, responsible, source, session);
            objectName = "LetterChannelResult";

            // letterChannelResult.setContactAddress(contactAddress);
            letterChannelResult.setSurveyFlowStep(flowStep);
            letterChannelResult.setSurveyFlowMode(triggerType);
            letterChannelResult.setPayment(payment);
            letterChannelResult.setDeltaBatch(deltaBatch);
            letterChannelResult.setEeVariableName(eeVariableName);
            letterChannelResult.setExternalEntityId(externalEntityId);
            letterChannelResult.setRecipientType(recipientType);

            channelResults.add(letterChannelResult);

            if (logger.isDebugEnabled()) {
              logger.debug("Letter Channel Result added.");
            }

          } else if ("sms".equalsIgnoreCase(templateType) && enterpriseDocument.getAllowSMS()) {
            SmsChannelResult smsChannelResult = createChannelResult(new SmsChannelResult(), batchId, today, account,
                responsible, source, session);
            objectName = "SmsChannelResult";

            // smsChannelResult.setContactPhone(contactPhone);
            // smsChannelResult.setPhoneNumber(contactPhone.getPhoneNum());
            smsChannelResult.setStartTime(startTime);
            smsChannelResult.setEndTime(endTime);
            smsChannelResult.setSurveyFlowStep(flowStep);
            smsChannelResult.setSurveyFlowMode(triggerType);
            smsChannelResult.setPayment(payment);
            smsChannelResult.setDeltaBatch(deltaBatch);

            channelResults.add(smsChannelResult);

            if (logger.isDebugEnabled()) {
              logger.debug("Sms Channel Result added.");
            }
          } else if ("dialer".equalsIgnoreCase(templateType) && enterpriseDocument.getAllowDialer()) {
            DialerChannelResult dialerChannelResult = createChannelResult(new DialerChannelResult(), batchId, today,
                account,
                responsible, source, session);
            objectName = "DialerChannelResult";

            // dialerChannelResult.setContactPhone(contactPhone);
            // dialerChannelResult.setPhoneNumber(contactPhone.getPhoneNum());
            dialerChannelResult.setSurveyFlowStep(flowStep);
            dialerChannelResult.setSurveyFlowMode(triggerType);
            dialerChannelResult.setPayment(payment);
            dialerChannelResult.setDeltaBatch(deltaBatch);

            channelResults.add(dialerChannelResult);

            if (logger.isDebugEnabled()) {
              logger.debug("Dialer Channel Result added.");
            }
          } else if ("ivr".equalsIgnoreCase(templateType) && enterpriseDocument.getAllowIVR()) {
            IvrChannelResult ivrChannelResult = createChannelResult(new IvrChannelResult(), batchId, today, account,
                responsible, source, session);
            objectName = "IvrChannelResult";

            // ivrChannelResult.setContactPhone(contactPhone);
            // ivrChannelResult.setPhoneNumber(contactPhone.getPhoneNum());
            ivrChannelResult.setStartTime(startTime);
            ivrChannelResult.setEndTime(endTime);
            ivrChannelResult.setSurveyFlowStep(flowStep);
            ivrChannelResult.setSurveyFlowMode(triggerType);
            ivrChannelResult.setPayment(payment);
            ivrChannelResult.setDeltaBatch(deltaBatch);

            channelResults.add(ivrChannelResult);

            if (logger.isDebugEnabled()) {
              logger.debug("IVR Channel Result added.");
            }
          } // end if-else

          for (BaseChannelResult channelResult : channelResults) {
            executeHelper.addResult(channelResult);
            executeHelper.addSingleObject(objectName, channelResult);
          }
        } // end if
      }   // end if-else

    } // end if
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type configurations.
   *
   * @return  Set
   */
  public Set<TargetAddressTypeConfiguration> getAddressTypeConfigurations() {
    return addressTypeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel nodes.
   *
   * @return  Set
   */
  public Set<Node> getChannelNodes() {
    return channelNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel target method.
   *
   * @return  String
   */
  public String getChannelTargetMethod() {
    return channelTargetMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type.
   *
   * @return  String
   */
  public String getChannelType() {
    String type = "";

    if (template != null) {
      type = template.getChannelType().getName();
    } else if (enterpriseDocument != null) {
      return templateType;
    }

    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete criteria.
   *
   * @return  String
   */
  public String getCompleteCriteria() {
    return this.criteria;

  } // end method getCompleteCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default delivery per hour.
   *
   * @return  Integer
   */
  public Integer getDefaultDeliveryPerHour() {
    return defaultDeliveryPerHour;
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
   * getter method for ee variable name.
   *
   * @return  String
   */
  public String getEeVariableName() {
    return eeVariableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type configurations.
   *
   * @return  Set
   */
  public Set<TargetEmailTypeConfiguration> getEmailTypeConfigurations() {
    return emailTypeConfigurations;
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
   * getter method for enterprise document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getEnterpriseDocument() {
    return enterpriseDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for even distribution hours.
   *
   * @return  Integer
   */
  public Integer getEvenDistributionHours() {
    return evenDistributionHours;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type configurations.
   *
   * @return  Set
   */
  public Set<TargetPhoneTypeConfiguration> getPhoneTypeConfigurations() {
    return phoneTypeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recipient type.
   *
   * @return  String
   */
  public String getRecipientType() {
    return recipientType;
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
   * getter method for template.
   *
   * @return  PortfolioChannelTemplate
   */
  public PortfolioChannelTemplate getTemplate() {
    return template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template id.
   *
   * @return  String
   */
  public String getTemplateId() {
    return templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template type.
   *
   * @return  String
   */
  public String getTemplateType() {
    return templateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triggered node.
   *
   * @return  Node
   */
  public Node getTriggeredNode() {
    return triggeredNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor.
   *
   * @return  ChannelVendor
   */
  public ChannelVendor getVendor() {
    return vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor id.
   *
   * @return  String
   */
  public String getVendorId() {
    return vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visible.
   *
   * @return  Boolean
   */
  public Boolean getVisible() {
    if (visible == null) {
      return Boolean.TRUE;
    }

    return visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioBaseNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((endTime != null) ? endTime.hashCode() : 0);
    result = (31 * result) + ((startTime != null) ? startTime.hashCode() : 0);
    result = (31 * result) + ((template != null) ? template.hashCode() : 0);
    result = (31 * result) + ((vendor != null) ? vendor.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type configurations.
   *
   * @param  addressTypeConfigurations  Set
   */
  public void setAddressTypeConfigurations(Set<TargetAddressTypeConfiguration> addressTypeConfigurations) {
    this.addressTypeConfigurations = addressTypeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel nodes.
   *
   * @param  channelNodes  Set
   */
  public void setChannelNodes(Set<Node> channelNodes) {
    this.channelNodes = channelNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel target method.
   *
   * @param  channelTargetMethod  String
   */
  public void setChannelTargetMethod(String channelTargetMethod) {
    this.channelTargetMethod = channelTargetMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default delivery per hour.
   *
   * @param  defaultDeliveryPerHour  Integer
   */
  public void setDefaultDeliveryPerHour(Integer defaultDeliveryPerHour) {
    this.defaultDeliveryPerHour = defaultDeliveryPerHour;
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
   * setter method for ee variable name.
   *
   * @param  eeVariableName  String
   */
  public void setEeVariableName(String eeVariableName) {
    this.eeVariableName = eeVariableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email type configurations.
   *
   * @param  emailTypeConfigurations  Set
   */
  public void setEmailTypeConfigurations(Set<TargetEmailTypeConfiguration> emailTypeConfigurations) {
    this.emailTypeConfigurations = emailTypeConfigurations;
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
   * setter method for enterprise document.
   *
   * @param  enterpriseDocument  EnterpriseDocument
   */
  public void setEnterpriseDocument(EnterpriseDocument enterpriseDocument) {
    this.enterpriseDocument = enterpriseDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for even distribution hours.
   *
   * @param  evenDistributionHours  Integer
   */
  public void setEvenDistributionHours(Integer evenDistributionHours) {
    this.evenDistributionHours = evenDistributionHours;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type configurations.
   *
   * @param  phoneTypeConfigurations  Set
   */
  public void setPhoneTypeConfigurations(Set<TargetPhoneTypeConfiguration> phoneTypeConfigurations) {
    this.phoneTypeConfigurations = phoneTypeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recipient type.
   *
   * @param  recipientType  String
   */
  public void setRecipientType(String recipientType) {
    this.recipientType = recipientType;
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
   * setter method for template.
   *
   * @param  template  PortfolioChannelTemplate
   */
  public void setTemplate(PortfolioChannelTemplate template) {
    this.template = template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template id.
   *
   * @param  templateId  String
   */
  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template type.
   *
   * @param  templateType  String
   */
  public void setTemplateType(String templateType) {
    this.templateType = templateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triggered node.
   *
   * @param  triggeredNode  Node
   */
  public void setTriggeredNode(Node triggeredNode) {
    this.triggeredNode = triggeredNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  ChannelVendor
   */
  public void setVendor(ChannelVendor vendor) {
    this.vendor = vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor id.
   *
   * @param  vendorId  String
   */
  public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ChannelAction");
    sb.append("{endTime='").append(endTime).append('\'');
    sb.append(", startTime='").append(startTime).append('\'');
    sb.append(", template=").append(template);
    sb.append(", vendor=").append(vendor);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private <T extends BaseChannelResult> T createChannelResult(T channelResult, Long batchId, Date strategyDate,
    Account account, Responsible responsible, String source, Session session) {
    channelResult.setRuleBatchId(batchId);
    channelResult.setRuleId(this.getId());
    channelResult.setAccount(account);
    channelResult.setResponsible(responsible);
    channelResult.setStrategyDate(strategyDate);
    channelResult.setExportDate(null);
    channelResult.setExecuteDate(null);
    channelResult.setNode(triggeredNode);
    channelResult.setSession(session);

    if (template != null) {
      channelResult.setTemplate(template.getName());
      channelResult.setTemplateId(template.getId());
    } else if (enterpriseDocument != null) {
      channelResult.setDocumentId(enterpriseDocument.getId());
    }

    channelResult.setBalance(account.getBalance());
    channelResult.setCurrentDue(account.getCurrentDue());
    channelResult.setPastDue(account.getPastDue());
    channelResult.setStatus(ChannelResultStatus.INIT);
    channelResult.setChannelAction(this);

    ChannelVendor vendor = new ChannelVendor();
    vendor.setVendorId(this.vendor.getVendorId());

    channelResult.setChannelVendor(vendor);
    channelResult.setSource(source);

    return channelResult;
  } // end method createChannelResult

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<ContactAddress> getConfigContactAddressList(Responsible responsible) {
    List<ContactAddress> contactAddressList = new ArrayList<ContactAddress>();
    List<Address>        addressList        = new ArrayList<Address>();

    boolean singleMode = ("single".equalsIgnoreCase(this.channelTargetMethod));

    if (logger.isDebugEnabled()) {
      logger.debug("Channel Target single mode:" + singleMode);
    }

    for (TargetAddressTypeConfiguration addressTypeConfiguration : addressTypeConfigurations) {
      AddressType    type           = addressTypeConfiguration.getAddressType();
      ContactAddress contactAddress = responsible.getAddressByType(type);

      if (logger.isDebugEnabled()) {
        logger.debug("Check Address type:" + type.getName() + ":" + contactAddress);
      }

      if ((contactAddress != null)) {
        Address address = contactAddress.getAddress();

        if (!(Boolean.TRUE.equals(contactAddress.getDoNotContact())) && (!addressList.contains(address))) {
          if (logger.isDebugEnabled()) {
            logger.debug("Add address to list.");
          }

          contactAddressList.add(contactAddress);
          addressList.add(address);
        }

        if (singleMode && (contactAddressList.size() > 0)) {
          if (logger.isDebugEnabled()) {
            logger.debug("In single mode, one address found, return.");
          }

          break;
        }
      }
    } // end for

    if (logger.isDebugEnabled()) {
      logger.debug(contactAddressList.size() + " addresses found.");
    }

    return contactAddressList;
  } // end method getConfigContactAddressList

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<ContactEmail> getConfigContactEmailList(Responsible responsible) {
    List<ContactEmail> emailList        = new ArrayList<ContactEmail>();
    List<String>       emailAddressList = new ArrayList<String>();

    boolean singleMode = ("single".equalsIgnoreCase(this.channelTargetMethod));

    if (logger.isDebugEnabled()) {
      logger.debug("Channel Target single mode:" + singleMode);
    }

    for (TargetEmailTypeConfiguration emailTypeConfiguration : emailTypeConfigurations) {
      EmailType    type  = emailTypeConfiguration.getEmailType();
      ContactEmail email = responsible.getEmailByType(type);

      if (logger.isDebugEnabled()) {
        logger.debug("Check Email type:" + type.getName() + ":" + email);
      }

      if (email != null) {
        String emailAddress = email.getEmailAddress();

        if (!(Boolean.TRUE.equals(email.getDoNotContact())) && (!emailAddressList.contains(emailAddress))) {
          if (logger.isDebugEnabled()) {
            // email address must be contactable and not duplicate
            logger.debug("Add email to list.");
          }

          emailList.add(email);
          emailAddressList.add(emailAddress);
        }

        if (singleMode && (emailList.size() > 0)) {
          if (logger.isDebugEnabled()) {
            logger.debug("In single mode, one address found, return.");
          }

          break;
        }
      }
    } // end for

    if (logger.isDebugEnabled()) {
      logger.debug(emailList.size() + " emails found.");
    }

    return emailList;
  } // end method getConfigContactEmailList

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<ContactPhone> getConfigContactPhoneList(Responsible responsible) {
    List<ContactPhone> phoneList       = new ArrayList<ContactPhone>();
    List<String>       phoneNumberList = new ArrayList<String>();

    boolean singleMode = ("single".equalsIgnoreCase(this.channelTargetMethod));

    if (logger.isDebugEnabled()) {
      logger.debug("Channel Target single mode:" + singleMode);
    }

    for (TargetPhoneTypeConfiguration phoneTypeConfiguration : phoneTypeConfigurations) {
      PhoneType    type  = phoneTypeConfiguration.getPhoneType();
      ContactPhone phone = responsible.getPhoneByType(type);

      if (logger.isDebugEnabled()) {
        logger.debug("Check Phone type:" + type.getName() + ":" + phone);
      }

      if (phone != null) {
        String phoneNumber = phone.getPhoneNum();

        if ((phone != null) && !(Boolean.TRUE.equals(phone.getDoNotContact()))
              && (!phoneNumberList.contains(phoneNumber))) {
          if (logger.isDebugEnabled()) {
            logger.debug("Add phone to list.");
          }

          phoneList.add(phone);
          phoneNumberList.add(phoneNumber);
        }

        if (singleMode && (phoneList.size() > 0)) {
          if (logger.isDebugEnabled()) {
            logger.debug("In single mode, one address found, return.");
          }

          break;
        }
      }
    } // end for

    return phoneList;
  } // end method getConfigContactPhoneList

} // end class ChannelAction
