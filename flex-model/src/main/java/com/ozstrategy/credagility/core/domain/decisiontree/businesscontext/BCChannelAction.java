package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.channel.*;
import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.contact.ContactEmail;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseNodeAction;
import com.ozstrategy.credagility.core.domain.RunType;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;


/**
 * This class is used to store BCChannelAction information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 10:42
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
public class BCChannelAction extends BCBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6468305071221202735L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelAction",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<BCTargetAddressTypeConfiguration> addressTypeConfigurations =
    new LinkedHashSet<BCTargetAddressTypeConfiguration>();


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeChannelActions"
  )
  protected Set<BCNode> channelNodes = new LinkedHashSet<BCNode>();

  /** multiple /single.* */
  @Column(length = 32)
  protected String channelTargetMethod;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelAction",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<BCTargetEmailTypeConfiguration> emailTypeConfigurations =
    new LinkedHashSet<BCTargetEmailTypeConfiguration>();


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
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelAction",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<BCTargetPhoneTypeConfiguration> phoneTypeConfigurations =
    new LinkedHashSet<BCTargetPhoneTypeConfiguration>();


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String startTime;


  /** TODO: DOCUMENT ME! */
  @Transient protected String templateId;


  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  protected String templateType;


  /** TODO: DOCUMENT ME! */
  @Transient protected BCNode triggeredNode;


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
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean visible;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  @Transient private Map<String, ExternalEntity> tempExternalEntityMap = new HashMap<String, ExternalEntity>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ChannelAction object.
   */
  public BCChannelAction() {
    actionType = BaseNodeAction.ActionType_Channel;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addTargetAddressTypeConfiguration.
   *
   * @param  addressTypeConfiguration  BCTargetAddressTypeConfiguration
   */
  public void addTargetAddressTypeConfiguration(
    BCTargetAddressTypeConfiguration addressTypeConfiguration) {
    addressTypeConfiguration.setChannelAction(this);
    this.addressTypeConfigurations.add(addressTypeConfiguration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTargetEmailTypeConfiguration.
   *
   * @param  emailTypeConfiguration  BCTargetEmailTypeConfiguration
   */
  public void addTargetEmailTypeConfiguration(BCTargetEmailTypeConfiguration emailTypeConfiguration) {
    emailTypeConfiguration.setChannelAction(this);
    this.emailTypeConfigurations.add(emailTypeConfiguration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addTargetPhoneTypeConfiguration.
   *
   * @param  phoneTypeConfiguration  BCTargetPhoneTypeConfiguration
   */
  public void addTargetPhoneTypeConfiguration(BCTargetPhoneTypeConfiguration phoneTypeConfiguration) {
    phoneTypeConfiguration.setChannelAction(this);
    this.phoneTypeConfigurations.add(phoneTypeConfiguration);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#beforeExecute()
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
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    // if (this.duplicateCount == null) {
    // this.duplicateCount = 0;
    // }
    //
    // this.duplicateCount++;

    BCChannelAction channelAction = new BCChannelAction();
    channelAction.updateNodeAction(this);
    channelAction.setBusinessContext(channelAction.getBusinessContext());
    channelAction.setName(channelAction.getName());
    channelAction.setTemplateType(this.getTemplateType());

    for (BCTargetAddressTypeConfiguration addressTypeConfiguration : this.addressTypeConfigurations) {
      channelAction.addTargetAddressTypeConfiguration(addressTypeConfiguration.duplicate());
    }

    for (BCTargetEmailTypeConfiguration emailTypeConfiguration : this.emailTypeConfigurations) {
      channelAction.addTargetEmailTypeConfiguration(emailTypeConfiguration.duplicate());
    }

    for (BCTargetPhoneTypeConfiguration phoneTypeConfiguration : this.phoneTypeConfigurations) {
      channelAction.addTargetPhoneTypeConfiguration(phoneTypeConfiguration.duplicate());
    }

    channelAction.setVendor(this.getVendor());
    channelAction.setChannelTargetMethod(this.getChannelTargetMethod());
    channelAction.setVisible(Boolean.TRUE);

    return channelAction;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BCBaseNodeAction#equals(Object)
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

    BCChannelAction that = (BCChannelAction) o;

    if ((endTime != null) ? (!endTime.equals(that.endTime)) : (that.endTime != null)) {
      return false;
    }

    if ((startTime != null) ? (!startTime.equals(that.startTime)) : (that.startTime != null)) {
      return false;
    }

    if ((vendor != null) ? (!vendor.equals(that.vendor)) : (that.vendor != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#evaluate(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    return helper.evaluate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    Map<String, Object> params = executeHelper.getParameters();

    if (evaluate(evaluateHelper)) {
      this.triggered = true;

      BusinessContextInstance bci            = (BusinessContextInstance) params.get("businessContextInstance");
      Account                 account        = bci.getAccount();
      Responsible             responsible    = bci.getResponsible();
      Customer                customer       = bci.getCustomer();
      Payment                 payment        = (Payment) params.get("payment");
      boolean                 deltaBatch     = (Boolean) params.get("deltaBatch");
      ExternalEntity          externalEntity = (ExternalEntity) params.get("externalEntity");

      if (deltaBatch) {
        if (logger.isDebugEnabled()) {
          logger.debug("create channel result from deltaBatch file.");
        }
      }

      if ((account != null) && account.getDoNotContact()) {
        account = null;
      }

      if ((responsible != null) && responsible.getDoNotContact()) {
        responsible = null;
      }

      if ((customer != null) && customer.getDoNotContact()) {
        customer = null;
      }

      Date                          today       = DateUtil.toDateOnly(new Date());
      Long                          batchId     = (params.get("batchId") != null)
        ? Long.parseLong((String) params.get("batchId")) : null;
      RunType                       runType     = (RunType) params.get("runType");
      BCIWorkflowStep               flowStep    = (BCIWorkflowStep) params.get("flowStep");
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

        if ("email".equalsIgnoreCase(templateType)) {
          EmailChannelResult emailChannelResult = createChannelResult(new EmailChannelResult(), batchId, today,
              bci, account, responsible, customer, source);

          emailChannelResult.setBciWorkflowStep(flowStep);
          emailChannelResult.setSurveyFlowMode(triggerType);
          emailChannelResult.setPayment(payment);
          emailChannelResult.setDeltaBatch(deltaBatch);

          if (externalEntity != null) {
            emailChannelResult.setExternalEntity(externalEntity);
          } else if (this.getTriggeredNode() != null) {
            String mapKey = bci.getId() + "-" + this.getTriggeredNode().getId() + "-" + this.getId();
            externalEntity = tempExternalEntityMap.get(mapKey);

            if (externalEntity != null) {
              emailChannelResult.setExternalEntity(externalEntity);
            }
          }

          channelResults.add(emailChannelResult);

          if (logger.isDebugEnabled()) {
            logger.debug("Email Channel Result added.");
          }

        } else if ("letter".equalsIgnoreCase(templateType)) {
          LetterChannelResult letterChannelResult = createChannelResult(new LetterChannelResult(), batchId, today,
              bci, account, responsible, customer, source);

          // letterChannelResult.setContactAddress(contactAddress);
          letterChannelResult.setBciWorkflowStep(flowStep);
          letterChannelResult.setSurveyFlowMode(triggerType);
          letterChannelResult.setPayment(payment);
          letterChannelResult.setDeltaBatch(deltaBatch);

// if (creditProvider != null) {
// letterChannelResult.setCreditProvider(creditProvider);
// }
// if (creditBureau != null) {
// letterChannelResult.setCreditBureau(creditBureau);
// }

          channelResults.add(letterChannelResult);

          if (logger.isDebugEnabled()) {
            logger.debug("Letter Channel Result added.");
          }

        } else if ("sms".equalsIgnoreCase(templateType)) {
          SmsChannelResult smsChannelResult = createChannelResult(new SmsChannelResult(), batchId, today,
              bci, account, responsible, customer, source);

          // smsChannelResult.setContactPhone(contactPhone);
          // smsChannelResult.setPhoneNumber(contactPhone.getPhoneNum());
          smsChannelResult.setStartTime(startTime);
          smsChannelResult.setEndTime(endTime);
          smsChannelResult.setBciWorkflowStep(flowStep);
          smsChannelResult.setSurveyFlowMode(triggerType);
          smsChannelResult.setPayment(payment);
          smsChannelResult.setDeltaBatch(deltaBatch);

// if (creditProvider != null) {
// smsChannelResult.setCreditProvider(creditProvider);
// }
// if (creditBureau != null) {
// smsChannelResult.setCreditBureau(creditBureau);
// }

          channelResults.add(smsChannelResult);

          if (logger.isDebugEnabled()) {
            logger.debug("Sms Channel Result added.");
          }
        } else if ("dialer".equalsIgnoreCase(templateType)) {
          DialerChannelResult dialerChannelResult = createChannelResult(new DialerChannelResult(), batchId, today,
              bci, account, responsible, customer, source);

          // dialerChannelResult.setContactPhone(contactPhone);
          // dialerChannelResult.setPhoneNumber(contactPhone.getPhoneNum());
          dialerChannelResult.setBciWorkflowStep(flowStep);
          dialerChannelResult.setSurveyFlowMode(triggerType);
          dialerChannelResult.setPayment(payment);
          dialerChannelResult.setDeltaBatch(deltaBatch);


          channelResults.add(dialerChannelResult);

          if (logger.isDebugEnabled()) {
            logger.debug("Dialer Channel Result added.");
          }
        } else if ("ivr".equalsIgnoreCase(templateType)) {
          IvrChannelResult ivrChannelResult = createChannelResult(new IvrChannelResult(), batchId, today,
              bci, account, responsible, customer, source);

          // ivrChannelResult.setContactPhone(contactPhone);
          // ivrChannelResult.setPhoneNumber(contactPhone.getPhoneNum());
          ivrChannelResult.setStartTime(startTime);
          ivrChannelResult.setEndTime(endTime);
          ivrChannelResult.setBciWorkflowStep(flowStep);
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
        }
      } // end if
    }   // end if
  }     // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type configurations.
   *
   * @return  Set
   */
  public Set<BCTargetAddressTypeConfiguration> getAddressTypeConfigurations() {
    return addressTypeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel nodes.
   *
   * @return  Set
   */
  public Set<BCNode> getChannelNodes() {
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
// String type = "";

// if (template != null) {
// type = template.getChannelType().getName();
// } else if (enterpriseDocument != null) {
    return templateType;
// }

// return type;
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
   * getter method for duplicate count.
   *
   * @return  Integer
   */
  public Integer getDuplicateCount() {
    return duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type configurations.
   *
   * @return  Set
   */
  public Set<BCTargetEmailTypeConfiguration> getEmailTypeConfigurations() {
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
   * getter method for phone type configurations.
   *
   * @return  Set
   */
  public Set<BCTargetPhoneTypeConfiguration> getPhoneTypeConfigurations() {
    return phoneTypeConfigurations;
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
   * getter method for temp external entity map.
   *
   * @return  Map
   */
  public Map<String, ExternalEntity> getTempExternalEntityMap() {
    return tempExternalEntityMap;
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
   * @return  BCNode
   */
  public BCNode getTriggeredNode() {
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
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((endTime != null) ? endTime.hashCode() : 0);
    result = (31 * result) + ((startTime != null) ? startTime.hashCode() : 0);
    result = (31 * result) + ((vendor != null) ? vendor.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address type configurations.
   *
   * @param  addressTypeConfigurations  Set
   */
  public void setAddressTypeConfigurations(Set<BCTargetAddressTypeConfiguration> addressTypeConfigurations) {
    this.addressTypeConfigurations = addressTypeConfigurations;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel nodes.
   *
   * @param  channelNodes  Set
   */
  public void setChannelNodes(Set<BCNode> channelNodes) {
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
   * setter method for duplicate count.
   *
   * @param  duplicateCount  Integer
   */
  public void setDuplicateCount(Integer duplicateCount) {
    this.duplicateCount = duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email type configurations.
   *
   * @param  emailTypeConfigurations  Set
   */
  public void setEmailTypeConfigurations(Set<BCTargetEmailTypeConfiguration> emailTypeConfigurations) {
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
   * setter method for phone type configurations.
   *
   * @param  phoneTypeConfigurations  Set
   */
  public void setPhoneTypeConfigurations(Set<BCTargetPhoneTypeConfiguration> phoneTypeConfigurations) {
    this.phoneTypeConfigurations = phoneTypeConfigurations;
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
   * setter method for temp external entity map.
   *
   * @param  tempExternalEntityMap  Map
   */
  public void setTempExternalEntityMap(Map<String, ExternalEntity> tempExternalEntityMap) {
    this.tempExternalEntityMap = tempExternalEntityMap;
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
   * @param  triggeredNode  BCNode
   */
  public void setTriggeredNode(BCNode triggeredNode) {
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

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseNodeAction#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ChannelAction");
    sb.append("{endTime='").append(endTime).append('\'');
    sb.append(", startTime='").append(startTime).append('\'');
    sb.append(", vendor=").append(vendor);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private <T extends BaseChannelResult> T createChannelResult(T channelResult, Long batchId, Date strategyDate,
    BusinessContextInstance bci, Account account, Responsible responsible, Customer customer, String source) {
    channelResult.setRuleBatchId(batchId);
    channelResult.setRuleId(this.getId());
    channelResult.setBusinessContextInstance(bci);
    channelResult.setAccount(account);
    channelResult.setResponsible(responsible);
    channelResult.setCustomer(customer);
    channelResult.setStrategyDate(strategyDate);
    channelResult.setExportDate(null);
    channelResult.setExecuteDate(null);
    channelResult.setBcNode(triggeredNode);

    if (enterpriseDocument != null) {
      channelResult.setDocumentId(enterpriseDocument.getId());
    }

    if (account != null) {
      channelResult.setBalance(account.getBalance());
      channelResult.setCurrentDue(account.getCurrentDue());
      channelResult.setPastDue(account.getPastDue());
    }

    channelResult.setStatus(ChannelResultStatus.INIT);
    channelResult.setBcChannelAction(this);

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

    if (responsible != null) {
      boolean singleMode = ("single".equalsIgnoreCase(this.channelTargetMethod));

      if (logger.isDebugEnabled()) {
        logger.debug("Channel Target single mode:" + singleMode);
      }

      for (BCTargetAddressTypeConfiguration addressTypeConfiguration : addressTypeConfigurations) {
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
    }   // end if

    if (logger.isDebugEnabled()) {
      logger.debug(contactAddressList.size() + " addresses found.");
    }

    return contactAddressList;
  } // end method getConfigContactAddressList

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<ContactEmail> getConfigContactEmailList(Responsible responsible) {
    List<ContactEmail> emailList        = new ArrayList<ContactEmail>();
    List<String>       emailAddressList = new ArrayList<String>();

    if (responsible != null) {
      boolean singleMode = ("single".equalsIgnoreCase(this.channelTargetMethod));

      if (logger.isDebugEnabled()) {
        logger.debug("Channel Target single mode:" + singleMode);
      }

      for (BCTargetEmailTypeConfiguration emailTypeConfiguration : emailTypeConfigurations) {
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
    }   // end if

    if (logger.isDebugEnabled()) {
      logger.debug(emailList.size() + " emails found.");
    }

    return emailList;
  } // end method getConfigContactEmailList

  //~ ------------------------------------------------------------------------------------------------------------------

  private List<ContactPhone> getConfigContactPhoneList(Responsible responsible) {
    List<ContactPhone> phoneList       = new ArrayList<ContactPhone>();
    List<String>       phoneNumberList = new ArrayList<String>();

    if (responsible != null) {
      boolean singleMode = ("single".equalsIgnoreCase(this.channelTargetMethod));

      if (logger.isDebugEnabled()) {
        logger.debug("Channel Target single mode:" + singleMode);
      }

      for (BCTargetPhoneTypeConfiguration phoneTypeConfiguration : phoneTypeConfigurations) {
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
    }   // end if

    if (logger.isDebugEnabled()) {
      logger.debug(phoneList.size() + " phones found.");
    }

    return phoneList;
  } // end method getConfigContactPhoneList

} // end class BCChannelAction
