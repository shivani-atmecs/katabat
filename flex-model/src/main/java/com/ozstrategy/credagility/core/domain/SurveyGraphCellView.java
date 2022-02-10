package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowLinkDrivenType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowLink;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowNode;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowLink;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowNode;

import java.util.ArrayList;
import java.util.List;


/**
 * SurveyGraphCellView.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:14
 */
public class SurveyGraphCellView {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String NODE_TYPE = "Node";

  /** TODO: DOCUMENT ME! */
  public static final String MAPPING_TYPE = "Link";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String criteria;

  /** TODO: DOCUMENT ME! */
  protected boolean entryNode;

  /** TODO: DOCUMENT ME! */
  protected long from;

  /** TODO: DOCUMENT ME! */
  protected long fromInstanceId;

  /** TODO: DOCUMENT ME! */
  protected String fromInstanceName;

  /** TODO: DOCUMENT ME! */
  protected String fromNodeType;

  /** TODO: DOCUMENT ME! */
  protected long id;

  /** TODO: DOCUMENT ME! */
  protected long instanceId;

  /** TODO: DOCUMENT ME! */
  protected String name;

  /** TODO: DOCUMENT ME! */
  protected String nodeType;

  /** TODO: DOCUMENT ME! */
  protected int priority;

  /** TODO: DOCUMENT ME! */
  protected String sid;

  /** TODO: DOCUMENT ME! */
  protected long to;

  /** TODO: DOCUMENT ME! */
  protected long toInstanceId;

  /** TODO: DOCUMENT ME! */
  protected String toInstanceName;

  /** TODO: DOCUMENT ME! */
  protected String toNodeType;

  /** TODO: DOCUMENT ME! */
  protected String                 type;
  private String                   accessType;
  private Boolean                  allowSPOC;
  private Boolean                  allowWeb;
  private Integer                  channelActionCount;
  private List<NodeActionInfoView> channelActions            = new ArrayList<NodeActionInfoView>();
  private String                   drivenType;
  private Boolean                  endFlow;
  private String                   endFlowUrl;
  private Integer                  flowActionCount;
  private List<NodeActionInfoView> flowActions               = new ArrayList<NodeActionInfoView>();
  private Boolean                  hasChannelAction;
  private Boolean                  hasFlowAction;
  private Boolean                  hasProgramAction;
  private Boolean                  hasReQueueAction;
  private Boolean                  hasStatusAction;
  private Boolean                  hasUpdateVariableAction;
  private Boolean                  hasVariableAction;
  private Boolean                  noRegret;
  private Integer                  programActionCount;
  private List<NodeActionInfoView> programActions            = new ArrayList<NodeActionInfoView>();
  private Long                     progressStepId;
  private String                   progressStepName;
  private Integer                  progressStepNumber;
  private Integer                  reQueueActionCount;
  private List<NodeActionInfoView> statusActions             = new ArrayList<NodeActionInfoView>();
  private String                   taskCode;
  private Integer                  updateVariableActionCount;
  private List<NodeActionInfoView> updateVariableActions     = new ArrayList<NodeActionInfoView>();
  private Integer                  variableActionCount;
  private List<NodeActionInfoView> variableActions           = new ArrayList<NodeActionInfoView>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SurveyGraphCellView object.
   */
  public SurveyGraphCellView() { }


  /**
   * Creates a new SurveyGraphCellView object.
   *
   * @param  instance  SurveyFlowNode
   */
  public SurveyGraphCellView(SurveyFlowNode instance) {
    this.id = instance.getId();

    if (WorkflowNodeType.SURVEY_NODE.equals(instance.getType())) {
      this.instanceId = instance.getSurvey().getId();
      this.name       = instance.getSurvey().getSurveyCode() + " : " + instance.getSurvey().getName();
    } else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(instance.getType())) {
      this.name       = instance.getStaticPage().getPageName();
      this.instanceId = instance.getStaticPage().getStaticPageId();
    } else if (WorkflowNodeType.SUB_FLOW_NODE.equals(instance.getType())) {
      this.name       = instance.getSubFlow().getName();
      this.instanceId = instance.getSubFlow().getId();
    }

    this.type                = NODE_TYPE;
    this.entryNode           = instance.isRoot();
    this.nodeType            = instance.getType().name();
    this.sid                 = this.type + this.nodeType + this.id;
    this.progressStepId      = (instance.getStep() != null) ? instance.getStep().getId() : null;
    this.progressStepName    = (instance.getStep() != null) ? instance.getStep().getDescription() : null;
    this.progressStepNumber  = (instance.getStep() != null) ? instance.getStep().getStepNumber() : null;
    this.noRegret            = instance.getNoRegret();
    this.allowWeb            = instance.getAllowWeb();
    this.allowSPOC           = instance.getAllowSPOC();
    this.hasVariableAction   = (instance.getVariableActions() != null) && (instance.getVariableActions().size() > 0);
    this.hasChannelAction    = (instance.getChannelActions() != null) && (instance.getChannelActions().size() > 0);
    this.hasProgramAction    = (instance.getProgramActions() != null) && (instance.getProgramActions().size() > 0);
    this.hasReQueueAction    = (instance.getReQueueActions() != null) && (instance.getReQueueActions().size() > 0);
    this.hasFlowAction       = (instance.getFlowActions() != null) && (instance.getFlowActions().size() > 0);
    this.hasStatusAction     = (instance.getStatusAction() != null) && (instance.getStatusAction().getId() != null);
    this.channelActionCount  = (instance.getChannelActions() != null) ? instance.getChannelActions().size() : 0;
    this.programActionCount  = (instance.getProgramActions() != null) ? instance.getProgramActions().size() : 0;
    this.variableActionCount = (instance.getVariableActions() != null) ? instance.getVariableActions().size() : 0;
    this.flowActionCount     = (instance.getFlowActions() != null) ? instance.getFlowActions().size() : 0;

    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    if (this.allowSPOC || (instance.assignAgents.size() > 0)) {
      hasUserAccess = true;
    }

    if (this.allowWeb || (instance.assignRoles.size() > 0)) {
      hasRoleAccess = true;
    }

    if (hasUserAccess && hasRoleAccess) {
      accessType = "UR";
    } else if (hasUserAccess) {
      accessType = "U";
    } else if (hasRoleAccess) {
      accessType = "R";
    }
  } // end ctor SurveyGraphCellView


  /**
   * Creates a new SurveyGraphCellView object.
   *
   * @param  link  SurveyFlowLink
   */
  public SurveyGraphCellView(SurveyFlowLink link) {
    this.type = MAPPING_TYPE;
    this.id   = link.getId();
    this.sid  = this.type + this.id;
    this.from = link.getFrom().getId();

    SurveyFlowNode toNode = link.getTo();

    if (WorkflowNodeType.SURVEY_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getSurvey().getId();
      this.fromInstanceName = link.getFrom().getSurvey().getName();
    } else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getStaticPage().getStaticPageId();
      this.fromInstanceName = link.getFrom().getStaticPage().getPageName();
    } else if (WorkflowNodeType.SUB_FLOW_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getSubFlow().getId();
      this.fromInstanceName = link.getFrom().getSubFlow().getName();
    }

    if (toNode != null) {
      this.to = toNode.getId();

      if (WorkflowNodeType.SURVEY_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getSurvey().getId();
        this.toInstanceName = toNode.getSurvey().getName();
      } else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getStaticPage().getStaticPageId();
        this.toInstanceName = toNode.getStaticPage().getPageName();
      } else if (WorkflowNodeType.SUB_FLOW_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getSubFlow().getId();
        this.toInstanceName = toNode.getSubFlow().getName();
      }

      this.toNodeType = toNode.getType().name();
    } else {
      this.toNodeType = WorkflowNodeType.END_NODE.name();
    }

    this.fromNodeType = link.getFrom().getType().name();
    this.criteria     = link.getCriteria();
    this.priority     = link.getPriority();
    this.drivenType   = link.getDrivenType().name();
  } // end ctor SurveyGraphCellView


  /**
   * Creates a new SurveyGraphCellView object.
   *
   * @param  link  EnterpriseWorkflowLink
   */
  public SurveyGraphCellView(EnterpriseWorkflowLink link) {
    this.type = MAPPING_TYPE;
    this.id   = link.getId();
    this.sid  = this.type + this.id;
    this.from = link.getFrom().getId();

    EnterpriseWorkflowNode toNode = link.getTo();

    if (WorkflowNodeType.SURVEY_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getWorkflowTask().getId();
      this.fromInstanceName = link.getFrom().getWorkflowTask().getName();
    }
// else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(link.getFrom().getType())) {
// this.fromInstanceId = link.getFrom().getStaticPage().getStaticPageId();
// this.fromInstanceName = link.getFrom().getStaticPage().getPageName();
// }
    else if (WorkflowNodeType.SUB_FLOW_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getSubFlow().getId();
      this.fromInstanceName = link.getFrom().getSubFlow().getName();
    }

    if (toNode != null) {
      this.to = toNode.getId();

      if (WorkflowNodeType.SURVEY_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getWorkflowTask().getId();
        this.toInstanceName = toNode.getWorkflowTask().getName();
      }
// else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(toNode.getType())) {
// this.toInstanceId = toNode.getStaticPage().getStaticPageId();
// this.toInstanceName = toNode.getStaticPage().getPageName();
// }
      else if (WorkflowNodeType.SUB_FLOW_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getSubFlow().getId();
        this.toInstanceName = toNode.getSubFlow().getName();
      }

      this.toNodeType = toNode.getType().name();
    } else {
      this.toNodeType = WorkflowNodeType.END_NODE.name();
    }

    this.fromNodeType = link.getFrom().getType().name();
    this.criteria     = link.getCriteria();
    this.priority     = link.getPriority();
    this.drivenType   = link.getDrivenType().name();
  } // end ctor SurveyGraphCellView


  /**
   * Creates a new SurveyGraphCellView object.
   *
   * @param  link  BCWorkflowLink
   */
  public SurveyGraphCellView(BCWorkflowLink link) {
    this.type = MAPPING_TYPE;
    this.id   = link.getId();
    this.sid  = this.type + this.id;
    this.from = link.getFrom().getId();

    BCWorkflowNode toNode = link.getTo();

    if (WorkflowNodeType.SURVEY_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getWorkflowTask().getId();
      this.fromInstanceName = link.getFrom().getWorkflowTask().getName();
    } else if (WorkflowNodeType.SUB_FLOW_NODE.equals(link.getFrom().getType())) {
      this.fromInstanceId   = link.getFrom().getSubFlow().getId();
      this.fromInstanceName = link.getFrom().getSubFlow().getName();
    }

    if (toNode != null) {
      this.to = toNode.getId();

      if (WorkflowNodeType.SURVEY_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getWorkflowTask().getId();
        this.toInstanceName = toNode.getWorkflowTask().getName();
      } else if (WorkflowNodeType.SUB_FLOW_NODE.equals(toNode.getType())) {
        this.toInstanceId   = toNode.getSubFlow().getId();
        this.toInstanceName = toNode.getSubFlow().getName();
      }

      this.toNodeType = toNode.getType().name();
    } else {
      this.toNodeType = WorkflowNodeType.END_NODE.name();
    }

    this.fromNodeType = link.getFrom().getType().name();
    this.criteria     = link.getCriteria();
    this.priority     = link.getPriority();
    this.drivenType   = link.getDrivenType().name();
  } // end ctor SurveyGraphCellView


  /**
   * Creates a new SurveyGraphCellView object.
   *
   * @param  instance  EnterpriseWorkflowNode
   */
  public SurveyGraphCellView(EnterpriseWorkflowNode instance) {
    this.id = instance.getId();

    if (WorkflowNodeType.SURVEY_NODE.equals(instance.getType())) {
      this.instanceId = instance.getWorkflowTask().getId();
      this.name       = instance.getWorkflowTask().getTaskCode() + " : " + instance.getWorkflowTask().getName();
    }
// else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(instance.getType())) {
// this.name = instance.getStaticPage().getPageName();
// this.instanceId = instance.getStaticPage().getStaticPageId();
// }
    else if (WorkflowNodeType.SUB_FLOW_NODE.equals(instance.getType())) {
      this.name       = instance.getSubFlow().getName();
      this.instanceId = instance.getSubFlow().getId();
    }

    this.type               = NODE_TYPE;
    this.entryNode          = instance.isRoot();
    this.nodeType           = instance.getType().name();
    this.sid                = this.type + this.nodeType + this.id;
    this.progressStepId     = (instance.getStep() != null) ? instance.getStep().getId() : null;
    this.progressStepName   = (instance.getStep() != null) ? instance.getStep().getDescription() : null;
    this.progressStepNumber = (instance.getStep() != null) ? instance.getStep().getStepNumber() : null;
    this.noRegret           = instance.getNoRegret();
    this.allowWeb           = instance.getAllowWeb();
    this.allowSPOC          = instance.getAllowSPOC();
// this.hasVariableAction = (instance.getVariableActions() != null) && (instance.getVariableActions().size() > 0);
// this.hasChannelAction = (instance.getChannelActions() != null) && (instance.getChannelActions().size() > 0);
// this.hasProgramAction = (instance.getProgramActions() != null) && (instance.getProgramActions().size() > 0);
// this.hasStatusAction = (instance.getStatusAction() != null) && (instance.getStatusAction().getId() != null);
// this.channelActionCount = (instance.getChannelActions() != null) ? instance.getChannelActions().size() : 0;
// this.programActionCount = (instance.getProgramActions() != null) ? instance.getProgramActions().size() : 0;
// this.variableActionCount = (instance.getVariableActions() != null) ? instance.getVariableActions().size() : 0;

    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    // TODO: assignAgent是否需要判断
// if (this.allowSPOC || instance.assignAgents.size() > 0) {
// hasUserAccess = true;
// }
//
// if (this.allowWeb || instance.assignRoles.size() > 0) {
// hasRoleAccess = true;
// }

    if (hasUserAccess && hasRoleAccess) {
      accessType = "UR";
    } else if (hasUserAccess) {
      accessType = "U";
    } else if (hasRoleAccess) {
      accessType = "R";
    }
  } // end ctor SurveyGraphCellView


  /**
   * Creates a new SurveyGraphCellView object.
   *
   * @param  instance  BCWorkflowNode
   */
  public SurveyGraphCellView(BCWorkflowNode instance) {
    this.id = instance.getId();

    if (WorkflowNodeType.SURVEY_NODE.equals(instance.getType())) {
      this.instanceId = instance.getWorkflowTask().getId();
      this.name       = instance.getWorkflowTask().getTaskCode() + " : " + instance.getWorkflowTask().getName();
    }
// else if (WorkflowNodeType.STATIC_PAGE_NODE.equals(instance.getType())) {
// this.name = instance.getStaticPage().getPageName();
// this.instanceId = instance.getStaticPage().getStaticPageId();
// }
    else if (WorkflowNodeType.SUB_FLOW_NODE.equals(instance.getType())) {
      this.name       = instance.getSubFlow().getName();
      this.instanceId = instance.getSubFlow().getId();
    }

    this.type               = NODE_TYPE;
    this.entryNode          = instance.isRoot();
    this.nodeType           = instance.getType().name();
    this.sid                = this.type + this.nodeType + this.id;
    this.progressStepId     = (instance.getProgressStep() != null) ? instance.getProgressStep().getId() : null;
    this.progressStepName   = (instance.getProgressStep() != null) ? instance.getProgressStep().getDescription() : null;
    this.progressStepNumber = (instance.getProgressStep() != null) ? instance.getProgressStep().getStepNumber() : null;
    this.noRegret           = instance.getNoRegret();
    this.allowWeb           = instance.getAllowWeb();
    this.allowSPOC          = instance.getAllowSPOC();
// this.hasVariableAction = (instance.getVariableActions() != null) && (instance.getVariableActions().size() > 0);
// this.hasChannelAction = (instance.getChannelActions() != null) && (instance.getChannelActions().size() > 0);
// this.hasProgramAction = (instance.getProgramActions() != null) && (instance.getProgramActions().size() > 0);
// this.hasStatusAction = (instance.getStatusAction() != null) && (instance.getStatusAction().getId() != null);
// this.channelActionCount = (instance.getChannelActions() != null) ? instance.getChannelActions().size() : 0;
// this.programActionCount = (instance.getProgramActions() != null) ? instance.getProgramActions().size() : 0;
// this.variableActionCount = (instance.getVariableActions() != null) ? instance.getVariableActions().size() : 0;

    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    // TODO: assignAgent是否需要判断
// if (this.allowSPOC || instance.assignAgents.size() > 0) {
// hasUserAccess = true;
// }
//
// if (this.allowWeb || instance.assignRoles.size() > 0) {
// hasRoleAccess = true;
// }

    if (hasUserAccess && hasRoleAccess) {
      accessType = "UR";
    } else if (hasUserAccess) {
      accessType = "U";
    } else if (hasRoleAccess) {
      accessType = "R";
    }
  } // end ctor SurveyGraphCellView

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for y.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  public static boolean isY(Object o) {
    if (o == null) {
      return false;
    }

    if ("Y".equals(o.toString())) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateBCNode.
   *
   * @param   data  Object[]
   *
   * @return  SurveyGraphCellView
   */
  public static SurveyGraphCellView populateBCNode(Object[] data) {
    SurveyGraphCellView view = populateEnterpriseNode(data);

    view.setChannelActionCount(new Integer(data[20].toString()));
    view.setHasChannelAction(view.getChannelActionCount() > 0);

    return view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateEnterpriseLink.
   *
   * @param   data  Object[]
   *
   * @return  SurveyGraphCellView
   */
  public static SurveyGraphCellView populateEnterpriseLink(Object[] data) {
    SurveyGraphCellView view = new SurveyGraphCellView();
    view.setId(Long.parseLong(data[0].toString()));
    view.setCriteria((data[1] != null) ? data[1].toString() : null);
    view.setDrivenType((data[2] != null) ? data[2].toString() : WorkflowLinkDrivenType.MANUALLY.name());
    view.setPriority((data[3] != null) ? new Integer(data[3].toString()) : null);
    view.setFrom((data[4] != null) ? Long.parseLong(data[4].toString()) : null);
    view.setFromInstanceName((data[5] != null) ? data[5].toString() : null);
    view.setFromInstanceId((data[6] != null) ? Long.parseLong(data[6].toString()) : null);
    view.setFromNodeType((data[7] != null) ? data[7].toString() : null);
    view.setTo((data[8] != null) ? Long.parseLong(data[8].toString()) : null);
    view.setToInstanceName((data[9] != null) ? data[9].toString() : null);
    view.setToInstanceId((data[10] != null) ? Long.parseLong(data[10].toString()) : null);
    view.setToNodeType((data[11] != null) ? data[11].toString() : null);
    view.setType(MAPPING_TYPE);
    view.setSid(view.type + view.id);

    return view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateEnterpriseNode.
   *
   * @param   data  Object[]
   *
   * @return  SurveyGraphCellView
   */
  public static SurveyGraphCellView populateEnterpriseNode(Object[] data) {
    SurveyGraphCellView view = new SurveyGraphCellView();
    view.setId(Long.parseLong(data[0].toString()));
    view.setNodeType(data[1].toString());
    view.setEntryNode(isY(data[2]));
    view.setNoRegret(isY(data[3]));
    view.setAllowWeb(isY(data[4]));
    view.setAllowSPOC(isY(data[5]));

// if (data[17] != null && StringUtils.hasText(data[17].toString())) {
// view.setName(data[17].toString());
// } else {
// view.setName(data[6].toString());
// }
    view.setName(data[6].toString());
    view.setInstanceId(Long.parseLong(data[7].toString()));
    view.setProgressStepId((data[8] != null) ? new Long(data[8].toString()) : null);
    view.setProgressStepName((data[9] != null) ? data[9].toString() : null);
    view.setProgressStepNumber((data[10] != null) ? new Integer(data[10].toString()) : null);

// view.setProgramActionCount(new Integer(data[11].toString()));
// view.setChannelActionCount(new Integer(data[12].toString()));
    view.setVariableActionCount(new Integer(data[17].toString()));
    view.setUpdateVariableActionCount(new Integer(data[18].toString()));
    view.setFlowActionCount(new Integer(data[19].toString()));

    Integer agentAccessCount = new Integer(data[11].toString());
    Integer roleAccessCount  = new Integer(data[12].toString());

// Object statusActionId = data[16];

    view.setEndFlow(isY(data[14]));
    view.setEndFlowUrl((data[15] != null) ? data[15].toString() : null);

    view.setTaskCode((data[16] != null) ? data[16].toString() : null);

    view.setType(NODE_TYPE);
    view.setSid(view.getType() + view.getNodeType() + view.getId());

    view.setHasChannelAction(false);
    view.setHasProgramAction(false);
    view.setHasReQueueAction(false);

    view.setHasFlowAction(view.getFlowActionCount() > 0);
    view.setHasVariableAction(view.getVariableActionCount() > 0);
    view.setHasUpdateVariableAction(view.getUpdateVariableActionCount() > 0);

// view.setHasStatusAction(statusActionId!=null);

    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    if (view.allowSPOC || (agentAccessCount > 0)) {
      hasUserAccess = true;
    }

    if (view.allowWeb || (roleAccessCount > 0)) {
      hasRoleAccess = true;
    }

    if (hasUserAccess && hasRoleAccess) {
      view.accessType = "UR";
    } else if (hasUserAccess) {
      view.accessType = "U";
    } else if (hasRoleAccess) {
      view.accessType = "R";
    }

    return view;
  } // end method populateEnterpriseNode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateLink.
   *
   * @param   data  Object[]
   *
   * @return  SurveyGraphCellView
   */
  public static SurveyGraphCellView populateLink(Object[] data) {
    SurveyGraphCellView view = new SurveyGraphCellView();
    view.setId(Long.parseLong(data[0].toString()));
    view.setCriteria((data[1] != null) ? data[1].toString() : null);
    view.setDrivenType((data[2] != null) ? data[2].toString() : WorkflowLinkDrivenType.MANUALLY.name());
    view.setPriority((data[3] != null) ? new Integer(data[3].toString()) : null);
    view.setFrom((data[4] != null) ? Long.parseLong(data[4].toString()) : null);
    view.setFromInstanceName((data[5] != null) ? data[5].toString() : null);
    view.setFromInstanceId((data[6] != null) ? Long.parseLong(data[6].toString()) : null);
    view.setFromNodeType((data[7] != null) ? data[7].toString() : null);
    view.setTo((data[8] != null) ? Long.parseLong(data[8].toString()) : null);
    view.setToInstanceName((data[9] != null) ? data[9].toString() : null);
    view.setToInstanceId((data[10] != null) ? Long.parseLong(data[10].toString()) : null);
    view.setToNodeType((data[11] != null) ? data[11].toString() : null);
    view.setType(MAPPING_TYPE);
    view.setSid(view.type + view.id);

    return view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateNode.
   *
   * @param   data  Object[]
   *
   * @return  SurveyGraphCellView
   */
  public static SurveyGraphCellView populateNode(Object[] data) {
    SurveyGraphCellView view = new SurveyGraphCellView();
    view.setId(Long.parseLong(data[0].toString()));
    view.setNodeType(data[1].toString());
    view.setEntryNode(isY(data[2]));
    view.setNoRegret(isY(data[3]));
    view.setAllowWeb(isY(data[4]));
    view.setAllowSPOC(isY(data[5]));

// if (data[17] != null && StringUtils.hasText(data[17].toString())) {
// view.setName(data[17].toString());
// } else {
// view.setName(data[6].toString());
// }
    view.setName(data[6].toString());
    view.setInstanceId(Long.parseLong(data[7].toString()));
    view.setProgressStepId((data[8] != null) ? new Long(data[8].toString()) : null);
    view.setProgressStepName((data[9] != null) ? data[9].toString() : null);
    view.setProgressStepNumber((data[10] != null) ? new Integer(data[10].toString()) : null);
    view.setProgramActionCount(new Integer(data[11].toString()));
    view.setReQueueActionCount(new Integer(data[23].toString()));
    view.setChannelActionCount(new Integer(data[12].toString()));
    view.setVariableActionCount(new Integer(data[13].toString()));
    view.setUpdateVariableActionCount(new Integer(data[14].toString()));
    view.setFlowActionCount(new Integer(data[15].toString()));

    Integer agentAccessCount = new Integer(data[16].toString());
    Integer roleAccessCount  = new Integer(data[17].toString());
    Object  statusActionId   = data[18];
    view.setEndFlow(isY(data[20]));
    view.setEndFlowUrl((data[21] != null) ? data[21].toString() : null);
    view.setTaskCode((data[22] != null) ? data[22].toString() : null);

    view.setType(NODE_TYPE);
    view.setSid(view.getType() + view.getNodeType() + view.getId());
    view.setHasChannelAction(view.getChannelActionCount() > 0);
    view.setHasProgramAction(view.getProgramActionCount() > 0);
    view.setHasReQueueAction(view.getReQueueActionCount() > 0);
    view.setHasVariableAction(view.getVariableActionCount() > 0);
    view.setHasStatusAction(statusActionId != null);
    view.setHasUpdateVariableAction(view.getUpdateVariableActionCount() > 0);
    view.setHasFlowAction(view.getFlowActionCount() > 0);

    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    if (view.allowSPOC || (agentAccessCount > 0)) {
      hasUserAccess = true;
    }

    if (view.allowWeb || (roleAccessCount > 0)) {
      hasRoleAccess = true;
    }

    if (hasUserAccess && hasRoleAccess) {
      view.accessType = "UR";
    } else if (hasUserAccess) {
      view.accessType = "U";
    } else if (hasRoleAccess) {
      view.accessType = "R";
    }

    return view;
  } // end method populateNode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * appendAction.
   *
   * @param  action  NodeActionInfoView
   */
  public void appendAction(NodeActionInfoView action) {
    List<NodeActionInfoView> actions = null;

    if (NodeActionInfoView.CHANNEL_ACTION.equals(action.getType())) {
      this.getChannelActions().add(action);
    } else if (NodeActionInfoView.PROGRAM_ACTION.equals(action.getType())) {
      this.getProgramActions().add(action);
    } else if (NodeActionInfoView.STATUS_ACTION.equals(action.getType())) {
      this.getStatusActions().add(action);
    } else if (NodeActionInfoView.VARIABLE_ACTION.equals(action.getType())) {
      this.getVariableActions().add(action);
    } else if (NodeActionInfoView.UPDATE_VARIABLE_ACTION.equals(action.getType())) {
      this.getUpdateVariableActions().add(action);
    } else if (NodeActionInfoView.FLOW_ACTION.equals(action.getType())) {
      this.getFlowActions().add(action);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for access type.
   *
   * @return  String
   */
  public String getAccessType() {
    return accessType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action labels.
   *
   * @return  String
   */
  public String getActionLabels() {
    StringBuffer sb = new StringBuffer();

    if (channelActions.size() > 0) {
      sb.append("---- Channel Actions ----\n");

      for (NodeActionInfoView action : channelActions) {
        sb.append(action.getName()).append(" [").append(action.getTriggerType()).append("]\n");
      }

      sb.append("\n");
    }

    if (programActions.size() > 0) {
      sb.append("---- Program Actions ----\n");

      for (NodeActionInfoView action : programActions) {
        sb.append(action.getName()).append(" [").append(action.getTriggerType()).append("]\n");
      }

      sb.append("\n");
    }

    if (variableActions.size() > 0) {
      sb.append("---- Variable Actions ----\n");

      for (NodeActionInfoView action : variableActions) {
        sb.append(action.getName()).append(" [").append(action.getTriggerType()).append("]\n");
      }

      sb.append("\n");
    }

    if (statusActions.size() > 0) {
      sb.append("---- Variable Actions ----\n");

      for (NodeActionInfoView action : statusActions) {
        sb.append(action.getName()).append(" [").append(action.getTriggerType()).append("]\n");
      }

      sb.append("\n");
    }

    if (flowActions.size() > 0) {
      sb.append("---- Flow Actions ----\n");

      for (NodeActionInfoView action : flowActions) {
        sb.append(action.getName()).append(" [").append(action.getTriggerType()).append("]\n");
      }

      sb.append("\n");
    }

    return sb.toString();
  } // end method getActionLabels

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow SPOC.
   *
   * @return  Boolean
   */
  public Boolean getAllowSPOC() {
    if (allowSPOC == null) {
      return Boolean.FALSE;
    }

    return allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow web.
   *
   * @return  Boolean
   */
  public Boolean getAllowWeb() {
    if (allowWeb == null) {
      return Boolean.FALSE;
    }

    return allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action count.
   *
   * @return  Integer
   */
  public Integer getChannelActionCount() {
    return channelActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel actions.
   *
   * @return  List
   */
  public List<NodeActionInfoView> getChannelActions() {
    return channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for driven type.
   *
   * @return  String
   */
  public String getDrivenType() {
    return drivenType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end flow.
   *
   * @return  Boolean
   */
  public Boolean getEndFlow() {
    if (endFlow == null) {
      return Boolean.FALSE;
    }

    return endFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end flow url.
   *
   * @return  String
   */
  public String getEndFlowUrl() {
    return endFlowUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow action count.
   *
   * @return  Integer
   */
  public Integer getFlowActionCount() {
    return flowActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow actions.
   *
   * @return  List
   */
  public List<NodeActionInfoView> getFlowActions() {
    return flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from.
   *
   * @return  long
   */
  public long getFrom() {
    return from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from instance id.
   *
   * @return  long
   */
  public long getFromInstanceId() {
    return fromInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from instance name.
   *
   * @return  String
   */
  public String getFromInstanceName() {
    return fromInstanceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from node type.
   *
   * @return  String
   */
  public String getFromNodeType() {
    return fromNodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has channel action.
   *
   * @return  Boolean
   */
  public Boolean getHasChannelAction() {
    if (hasChannelAction == null) {
      return Boolean.FALSE;
    }

    return hasChannelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has flow action.
   *
   * @return  Boolean
   */
  public Boolean getHasFlowAction() {
    if (hasFlowAction == null) {
      return Boolean.FALSE;
    }

    return hasFlowAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has program action.
   *
   * @return  Boolean
   */
  public Boolean getHasProgramAction() {
    if (hasProgramAction == null) {
      return Boolean.FALSE;
    }

    return hasProgramAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has re queue action.
   *
   * @return  Boolean
   */
  public Boolean getHasReQueueAction() {
    return hasReQueueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has status action.
   *
   * @return  Boolean
   */
  public Boolean getHasStatusAction() {
    if (hasStatusAction == null) {
      return Boolean.FALSE;
    }

    return hasStatusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has update variable action.
   *
   * @return  Boolean
   */
  public Boolean getHasUpdateVariableAction() {
    if (hasUpdateVariableAction == null) {
      return Boolean.FALSE;
    }

    return hasUpdateVariableAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has variable action.
   *
   * @return  Boolean
   */
  public Boolean getHasVariableAction() {
    if (hasVariableAction == null) {
      return Boolean.FALSE;
    }

    return hasVariableAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  long
   */
  public long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance id.
   *
   * @return  long
   */
  public long getInstanceId() {
    return instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node type.
   *
   * @return  String
   */
  public String getNodeType() {
    return nodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for no regret.
   *
   * @return  Boolean
   */
  public Boolean getNoRegret() {
    if (noRegret == null) {
      return Boolean.FALSE;
    }

    return noRegret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  int
   */
  public int getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program action count.
   *
   * @return  Integer
   */
  public Integer getProgramActionCount() {
    return programActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program actions.
   *
   * @return  List
   */
  public List<NodeActionInfoView> getProgramActions() {
    return programActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for progress step id.
   *
   * @return  Long
   */
  public Long getProgressStepId() {
    return progressStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for progress step name.
   *
   * @return  String
   */
  public String getProgressStepName() {
    return progressStepName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for progress step number.
   *
   * @return  Integer
   */
  public Integer getProgressStepNumber() {
    return progressStepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for re queue action count.
   *
   * @return  Integer
   */
  public Integer getReQueueActionCount() {
    return reQueueActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sid.
   *
   * @return  String
   */
  public String getSid() {
    return sid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status actions.
   *
   * @return  List
   */
  public List<NodeActionInfoView> getStatusActions() {
    return statusActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task code.
   *
   * @return  String
   */
  public String getTaskCode() {
    return taskCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to.
   *
   * @return  long
   */
  public long getTo() {
    return to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to instance id.
   *
   * @return  long
   */
  public long getToInstanceId() {
    return toInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to instance name.
   *
   * @return  String
   */
  public String getToInstanceName() {
    return toInstanceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to node type.
   *
   * @return  String
   */
  public String getToNodeType() {
    return toNodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update variable action count.
   *
   * @return  Integer
   */
  public Integer getUpdateVariableActionCount() {
    return updateVariableActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update variable actions.
   *
   * @return  List
   */
  public List<NodeActionInfoView> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable action count.
   *
   * @return  Integer
   */
  public Integer getVariableActionCount() {
    return variableActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable actions.
   *
   * @return  List
   */
  public List<NodeActionInfoView> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry node.
   *
   * @return  boolean
   */
  public boolean isEntryNode() {
    return entryNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for access type.
   *
   * @param  accessType  String
   */
  public void setAccessType(String accessType) {
    this.accessType = accessType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow SPOC.
   *
   * @param  allowSPOC  Boolean
   */
  public void setAllowSPOC(Boolean allowSPOC) {
    this.allowSPOC = allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow web.
   *
   * @param  allowWeb  Boolean
   */
  public void setAllowWeb(Boolean allowWeb) {
    this.allowWeb = allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel action count.
   *
   * @param  channelActionCount  Integer
   */
  public void setChannelActionCount(Integer channelActionCount) {
    this.channelActionCount = channelActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel actions.
   *
   * @param  channelActions  List
   */
  public void setChannelActions(List<NodeActionInfoView> channelActions) {
    this.channelActions = channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for driven type.
   *
   * @param  drivenType  String
   */
  public void setDrivenType(String drivenType) {
    this.drivenType = drivenType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end flow.
   *
   * @param  endFlow  Boolean
   */
  public void setEndFlow(Boolean endFlow) {
    this.endFlow = endFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end flow url.
   *
   * @param  endFlowUrl  String
   */
  public void setEndFlowUrl(String endFlowUrl) {
    this.endFlowUrl = endFlowUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entry node.
   *
   * @param  entryNode  boolean
   */
  public void setEntryNode(boolean entryNode) {
    this.entryNode = entryNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow action count.
   *
   * @param  flowActionCount  Integer
   */
  public void setFlowActionCount(Integer flowActionCount) {
    this.flowActionCount = flowActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow actions.
   *
   * @param  flowActions  List
   */
  public void setFlowActions(List<NodeActionInfoView> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from.
   *
   * @param  from  long
   */
  public void setFrom(long from) {
    this.from = from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from instance id.
   *
   * @param  fromInstanceId  long
   */
  public void setFromInstanceId(long fromInstanceId) {
    this.fromInstanceId = fromInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from instance name.
   *
   * @param  fromInstanceName  String
   */
  public void setFromInstanceName(String fromInstanceName) {
    this.fromInstanceName = fromInstanceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from node type.
   *
   * @param  fromNodeType  String
   */
  public void setFromNodeType(String fromNodeType) {
    this.fromNodeType = fromNodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has channel action.
   *
   * @param  hasChannelAction  Boolean
   */
  public void setHasChannelAction(Boolean hasChannelAction) {
    this.hasChannelAction = hasChannelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has flow action.
   *
   * @param  hasFlowAction  Boolean
   */
  public void setHasFlowAction(Boolean hasFlowAction) {
    this.hasFlowAction = hasFlowAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has program action.
   *
   * @param  hasProgramAction  Boolean
   */
  public void setHasProgramAction(Boolean hasProgramAction) {
    this.hasProgramAction = hasProgramAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has re queue action.
   *
   * @param  hasReQueueAction  Boolean
   */
  public void setHasReQueueAction(Boolean hasReQueueAction) {
    this.hasReQueueAction = hasReQueueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has status action.
   *
   * @param  hasStatusAction  Boolean
   */
  public void setHasStatusAction(Boolean hasStatusAction) {
    this.hasStatusAction = hasStatusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has update variable action.
   *
   * @param  hasUpdateVariableAction  Boolean
   */
  public void setHasUpdateVariableAction(Boolean hasUpdateVariableAction) {
    this.hasUpdateVariableAction = hasUpdateVariableAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for has variable action.
   *
   * @param  hasVariableAction  Boolean
   */
  public void setHasVariableAction(Boolean hasVariableAction) {
    this.hasVariableAction = hasVariableAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  long
   */
  public void setId(long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for instance id.
   *
   * @param  instanceId  long
   */
  public void setInstanceId(long instanceId) {
    this.instanceId = instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node type.
   *
   * @param  nodeType  String
   */
  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for no regret.
   *
   * @param  noRegret  Boolean
   */
  public void setNoRegret(Boolean noRegret) {
    this.noRegret = noRegret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  int
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program action count.
   *
   * @param  programActionCount  Integer
   */
  public void setProgramActionCount(Integer programActionCount) {
    this.programActionCount = programActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program actions.
   *
   * @param  programActions  List
   */
  public void setProgramActions(List<NodeActionInfoView> programActions) {
    this.programActions = programActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for progress step id.
   *
   * @param  progressStepId  Long
   */
  public void setProgressStepId(Long progressStepId) {
    this.progressStepId = progressStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for progress step name.
   *
   * @param  progressStepName  String
   */
  public void setProgressStepName(String progressStepName) {
    this.progressStepName = progressStepName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for progress step number.
   *
   * @param  progressStepNumber  Integer
   */
  public void setProgressStepNumber(Integer progressStepNumber) {
    this.progressStepNumber = progressStepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for re queue action count.
   *
   * @param  reQueueActionCount  Integer
   */
  public void setReQueueActionCount(Integer reQueueActionCount) {
    this.reQueueActionCount = reQueueActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sid.
   *
   * @param  sid  String
   */
  public void setSid(String sid) {
    this.sid = sid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status actions.
   *
   * @param  statusActions  List
   */
  public void setStatusActions(List<NodeActionInfoView> statusActions) {
    this.statusActions = statusActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task code.
   *
   * @param  taskCode  String
   */
  public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to.
   *
   * @param  to  long
   */
  public void setTo(long to) {
    this.to = to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to instance id.
   *
   * @param  toInstanceId  long
   */
  public void setToInstanceId(long toInstanceId) {
    this.toInstanceId = toInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to instance name.
   *
   * @param  toInstanceName  String
   */
  public void setToInstanceName(String toInstanceName) {
    this.toInstanceName = toInstanceName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to node type.
   *
   * @param  toNodeType  String
   */
  public void setToNodeType(String toNodeType) {
    this.toNodeType = toNodeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update variable action count.
   *
   * @param  updateVariableActionCount  Integer
   */
  public void setUpdateVariableActionCount(Integer updateVariableActionCount) {
    this.updateVariableActionCount = updateVariableActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update variable actions.
   *
   * @param  updateVariableActions  List
   */
  public void setUpdateVariableActions(List<NodeActionInfoView> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable action count.
   *
   * @param  variableActionCount  Integer
   */
  public void setVariableActionCount(Integer variableActionCount) {
    this.variableActionCount = variableActionCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable actions.
   *
   * @param  variableActions  List
   */
  public void setVariableActions(List<NodeActionInfoView> variableActions) {
    this.variableActions = variableActions;
  }
} // end class SurveyGraphCellView
