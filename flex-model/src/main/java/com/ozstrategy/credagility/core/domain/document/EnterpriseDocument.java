package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.StatusType;
import com.ozstrategy.credagility.core.util.ListUtils;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * This class is used to store EnterpriseDocument information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:22
 */
@Entity public class EnterpriseDocument extends BasicEnterpriseDocument implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6380337725122030715L;


  /** TODO: DOCUMENT ME! */
  public static final String RESPONSIBLE_CONTEXT = "Account";


  /** TODO: DOCUMENT ME! */
  public static final String AGENCY_CONTEXT = "Agency";


  /** TODO: DOCUMENT ME! */
  public static final String AGENT_CONTEXT = "Agent";


  /** TODO: DOCUMENT ME! */
  public static final String BC_CONTEXT = "Business";


  /** TODO: DOCUMENT ME! */
  public static final String PAYMENT_CONTEXT = "Payment";


  /** TODO: DOCUMENT ME! */
  public static final String PROGRAM_CONTEXT = "Program";


  /** TODO: DOCUMENT ME! */
  public static final String PROMISE_CONTEXT = "Promise";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "EnterpriseDocumentMappedPortfolio",
    indexes            = { @Index(columnList = "documentId") },
    joinColumns        = {
      @JoinColumn(
        name           = "documentId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "portfolioId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<Portfolio> assignedPortfolios = new LinkedHashSet<Portfolio>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "document",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EnterpriseDocumentTemplate> contents = new LinkedHashSet<EnterpriseDocumentTemplate>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "document",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EnterpriseDocumentMetaData> documentMetaDatas = new LinkedHashSet<EnterpriseDocumentMetaData>();

  /** Document Status List. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "document",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EnterpriseDocumentStatus> documentStatuses = new LinkedHashSet<EnterpriseDocumentStatus>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "document"
  )
  @Where(clause = "status='ACTIVE'")
  protected Set<EnterpriseDocumentVersion> inUsedVersion = new LinkedHashSet<EnterpriseDocumentVersion>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "lastPublishBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User lastPublishBy;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastPublishDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastPublishDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "status",
    length = 10
  )
  @Enumerated(EnumType.STRING)
  protected StatusType status;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "document",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseDocumentTemplateVariable> variables = new LinkedHashSet<EnterpriseDocumentTemplateVariable>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "document",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate DESC")
  protected Set<EnterpriseDocumentVersion> versions = new LinkedHashSet<EnterpriseDocumentVersion>();

  @Transient private String tempAssignedPortfolioIds;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addDocumentMetaData.
   *
   * @param  metaData  EnterpriseDocumentMetaData
   */
  public void addDocumentMetaData(EnterpriseDocumentMetaData metaData) {
    if (metaData != null) {
      if ((metaData.getId() != null) && !metaData.getId().equals(0L)) {
        if ((documentMetaDatas != null) && !documentMetaDatas.isEmpty()) {
          for (EnterpriseDocumentMetaData documentMetaData : documentMetaDatas) {
            if ((documentMetaData.getId() != null) && documentMetaData.getId().equals(metaData.getId())) {
              documentMetaData.update(metaData);
              documentMetaData.updateAnswerOptions(metaData);
              documentMetaData.setDocument(this);
            }
          }
        } else {
          // create new
          metaData.setId(null);
          metaData.setDocument(this);
          documentMetaDatas.add(metaData);
        }
      } else {
        metaData.setDocument(this);
        documentMetaDatas.add(metaData);
      } // end if-else
    }   // end if
  }     // end method addDocumentMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDocumentMetaData.
   *
   * @param  metaData         EnterpriseDocumentMetaData
   * @param  answerOptionSet  Set
   */
  public void addDocumentMetaData(EnterpriseDocumentMetaData metaData,
    Set<EnterpriseDocumentMetaDataAnswerOption> answerOptionSet) {
    metaData.setDocument(this);

    if ((answerOptionSet != null) && !answerOptionSet.isEmpty()) {
      metaData.getMetaDataAnswerOptions().clear();
      metaData.getMetaDataAnswerOptions().addAll(answerOptionSet);
    }

    documentMetaDatas.add(metaData);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDocumentMetaData.
   *
   * @param  name          String
   * @param  desc          String
   * @param  questionText  String
   * @param  dataType      String
   * @param  required      Boolean
   */
  public void addDocumentMetaData(String name, String desc, String questionText, String dataType, Boolean required) {
    EnterpriseDocumentMetaData metaData = new EnterpriseDocumentMetaData();
    metaData.setName(name);
    metaData.setDescription(desc);
    metaData.setQuestionText(questionText);
    metaData.setDataType(dataType);
    metaData.setRequired(required);
    metaData.setDocument(this);
    documentMetaDatas.add(metaData);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#addDocumentStatus(com.cmc.credagility.core.domain.document.DocumentStatus,
   *       String, java.util.Date, com.cmc.credagility.core.domain.user.User)
   */
  @Override public void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Date date, User user) {
    EnterpriseDocumentStatus docStatus = new EnterpriseDocumentStatus(documentStatus, flowPosition);
    docStatus.setCreateDate(date);
    docStatus.setCreator(user);
    docStatus.setDocument(this);
    documentStatuses.add(docStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#addDocumentStatus(com.cmc.credagility.core.domain.document.DocumentStatus,
   *       String, Boolean, java.util.Date, com.cmc.credagility.core.domain.user.User)
   */
  @Override public void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Boolean asDefault,
    Date date,
    User user) {
    EnterpriseDocumentStatus docStatus = new EnterpriseDocumentStatus(documentStatus, flowPosition);
    docStatus.setCreateDate(date);
    docStatus.setCreator(user);
    docStatus.setAsDefault(asDefault);
    docStatus.setDocument(this);
    documentStatuses.add(docStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * containsPortfolioIdIInAssigned.
   *
   * @param   portfolioId  Long
   *
   * @return  Boolean
   */
  public Boolean containsPortfolioIdIInAssigned(Long portfolioId) {
    for (Portfolio portfolio : assignedPortfolios) {
      if (portfolio.getPortfolioId().longValue() == portfolioId.longValue()) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#copy()
   */
  @Override public BasicEnterpriseDocument copy() {
    EnterpriseDocument document = new EnterpriseDocument();
    paste(document);

    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyDocumentMetaData.
   *
   * @param  metaData  EnterpriseDocumentMetaData
   */
  public void copyDocumentMetaData(EnterpriseDocumentMetaData metaData) {
    if (metaData != null) {
      if ((metaData.getId() != null) && !metaData.getId().equals(0L)) {
        // create new
        metaData.setId(null);
        metaData.setDocument(this);
        documentMetaDatas.add(metaData);
      } else {
        metaData.setDocument(this);
        documentMetaDatas.add(metaData);
      } // end if-else
    }   // end if
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createVersion.
   *
   * @param   date  Date
   * @param   user  User
   * @param   ver   long
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion createVersion(Date date, User user, long ver) {
    EnterpriseDocumentVersion document = new EnterpriseDocumentVersion();
    paste(document);

    for (EnterpriseDocumentStatus documentStatus : documentStatuses) {
      EnterpriseDocumentVersionStatus status = new EnterpriseDocumentVersionStatus();
      documentStatus.paste(status);
      status.setDocumentVersion(document);
      status.setCreator(user);
      status.setCreateDate(date);
      document.getDocumentStatuses().add(status);
    }

    for (EnterpriseDocumentTemplateVariable variable : variables) {
      EnterpriseDocumentVersionTemplateVariable var = new EnterpriseDocumentVersionTemplateVariable();
      variable.paste(var);
      var.setDocumentVersion(document);
      var.setCreator(user);
      var.setCreateDate(date);
      document.getVariables().add(var);
    }

    for (EnterpriseDocumentTemplate content : contents) {
      EnterpriseDocumentVersionTemplate con = content.generateVersionInfo();
      con.setVersion(ver);
      con.setDocumentVersion(document);
      con.setCreator(user);
      con.setCreateDate(date);
      document.getContents().add(con);
    }

    for (Portfolio portfolio : assignedPortfolios) {
      document.getAssignedPortfolios().add(portfolio);
    }

    document.setCreateDate(date);
    document.setCreator(user);

    return document;
  } // end method createVersion

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.FALSE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getActiveDocumentVersion() {
    for (EnterpriseDocumentVersion documentVersion : versions) {
      if (StatusType.ACTIVE.equals(documentVersion.getStatus())) {
        return documentVersion;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assigned portfolio ids.
   *
   * @return  String
   */
  public String getAssignedPortfolioIds() {
    StringBuilder sb = new StringBuilder();

    for (Portfolio portfolio : assignedPortfolios) {
      sb.append(portfolio.getPortfolioId());
      sb.append(",");
    }

    if (sb.length() > 0) {
      sb.deleteCharAt(sb.length() - 1);
    }

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assigned portfolios.
   *
   * @return  Set
   */
  public Set<Portfolio> getAssignedPortfolios() {
    return assignedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#getContent(com.cmc.credagility.core.domain.type.LocaleType)
   */
  @Override public EnterpriseDocumentTemplate getContent(LocaleType localeType) {
    for (EnterpriseDocumentTemplate content : contents) {
      if (content.getLocale().equals(localeType)) {
        return content;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contents.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentTemplate> getContents() {
    return contents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getCurrentDocumentVersion() {
    for (EnterpriseDocumentVersion ver : versions) {
      if (version.equals(ver.getVersion())) {
        return ver;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document meta datas.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentMetaData> getDocumentMetaDatas() {
    return documentMetaDatas;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document statuses.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentStatus> getDocumentStatuses() {
    return documentStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for in used document content.
   *
   * @param   locale  String
   *
   * @return  BasicEnterpriseDocumentTemplate
   */
  public BasicEnterpriseDocumentTemplate getInUsedDocumentContent(String locale) {
    LocaleType localeType = LocaleType.convert(locale);

    if (localeType != null) {
      for (EnterpriseDocumentVersion version : inUsedVersion) {
        for (BasicEnterpriseDocumentTemplate content : version.getContents()) {
          if (content.getLocale().toString().equals(localeType.toString())) {
            return content;
          }
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for in used document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getInUsedDocumentVersion() {
    for (EnterpriseDocumentVersion documentVersion : inUsedVersion) {
      return documentVersion;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for in used version.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersion> getInUsedVersion() {
    return inUsedVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last publish by.
   *
   * @return  User
   */
  public User getLastPublishBy() {
    return lastPublishBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last publish date.
   *
   * @return  Date
   */
  public Date getLastPublishDate() {
    return lastPublishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reference document version.
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion getReferenceDocumentVersion() {
    for (EnterpriseDocumentVersion documentVersion : versions) {
      if (this.version.equals(documentVersion.getVersion())) {
        return documentVersion;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  StatusType
   */
  public StatusType getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp assigned portfolio ids.
   *
   * @return  String
   */
  public String getTempAssignedPortfolioIds() {
    return tempAssignedPortfolioIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#getVariable(String)
   */
  @Override public EnterpriseDocumentTemplateVariable getVariable(String expression) {
    for (EnterpriseDocumentTemplateVariable portfolioDocumentVariable : variables) {
      if (portfolioDocumentVariable.getExpression().equalsIgnoreCase(expression)) {
        return portfolioDocumentVariable;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variables.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentTemplateVariable> getVariables() {
    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for versions.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersion> getVersions() {
    return versions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * orderVariables.
   */
  public void orderVariables() {
    int order = 1;

    for (EnterpriseDocumentTemplateVariable variable : variables) {
      variable.setDisplayOrder(order++);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * publishContent.
   *
   * @param   date  Date
   * @param   user  User
   *
   * @return  EnterpriseDocumentVersion
   */
  public EnterpriseDocumentVersion publishContent(Date date, User user) {
    long ver = this.version + 1;
    this.setVersion(ver);

    if ((this.inUsedVersion != null) && !this.inUsedVersion.isEmpty()) {
      for (EnterpriseDocumentVersion version : this.inUsedVersion) {
        version.setStatus(StatusType.OLD);
        version.setRetireBy(user);
        version.setRetireDate(date);
        version.setLastUpdater(user);
        version.setLastUpdateDate(date);
      }
    }

    EnterpriseDocumentVersion version = createVersion(date, user, ver);
    version.setDocument(this);
    version.setPublishBy(user);
    version.setPublishDate(date);
    version.setStatus(StatusType.ACTIVE);
    version.setVersion(ver);

    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeContents.
   *
   * @param  exceptContents  Set
   */
  public void removeContents(Set<EnterpriseDocumentTemplate> exceptContents) {
    if ((exceptContents != null) && !exceptContents.isEmpty() && (exceptContents.size() < LocaleType.values().length)) {
      List<Long>                            currentContents = new ArrayList<Long>(LocaleType.values().length);
      List<Long>                            existsContents  = new ArrayList<Long>(LocaleType.values().length);
      Map<Long, EnterpriseDocumentTemplate> contentMap      = new HashMap<Long, EnterpriseDocumentTemplate>(
          LocaleType.values().length);

      for (EnterpriseDocumentTemplate exceptContent : exceptContents) {
        if (exceptContent.getId() != null) {
          currentContents.add(exceptContent.getId());
        }
      }

      for (EnterpriseDocumentTemplate content : contents) {
        existsContents.add(content.getId());
        contentMap.put(content.getId(), content);
      }

      List<Long> needRemoveList = ListUtils.getDifferentId(currentContents, existsContents);

      if ((needRemoveList != null) && !needRemoveList.isEmpty()) {
        for (Long contentId : needRemoveList) {
          if ((contentId != null) && !contentId.equals(0L) && (contentMap.get(contentId) != null)) {
            contents.remove(contentMap.get(contentId));
          }
        }
      }
    } // end if
  }   // end method removeContents

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assigned portfolios.
   *
   * @param  assignedPortfolios  Set
   */
  public void setAssignedPortfolios(Set<Portfolio> assignedPortfolios) {
    this.assignedPortfolios = assignedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contents.
   *
   * @param  contents  Set
   */
  public void setContents(Set<EnterpriseDocumentTemplate> contents) {
    this.contents = contents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document meta datas.
   *
   * @param  documentMetaDatas  Set
   */
  public void setDocumentMetaDatas(Set<EnterpriseDocumentMetaData> documentMetaDatas) {
    this.documentMetaDatas = documentMetaDatas;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document statuses.
   *
   * @param  documentStatuses  Set
   */
  public void setDocumentStatuses(Set<EnterpriseDocumentStatus> documentStatuses) {
    this.documentStatuses = documentStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for in used version.
   *
   * @param  inUsedVersion  Set
   */
  public void setInUsedVersion(Set<EnterpriseDocumentVersion> inUsedVersion) {
    this.inUsedVersion = inUsedVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last publish by.
   *
   * @param  lastPublishBy  User
   */
  public void setLastPublishBy(User lastPublishBy) {
    this.lastPublishBy = lastPublishBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last publish date.
   *
   * @param  lastPublishDate  Date
   */
  public void setLastPublishDate(Date lastPublishDate) {
    this.lastPublishDate = lastPublishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  StatusType
   */
  public void setStatus(StatusType status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temp assigned portfolio ids.
   *
   * @param  tempAssignedPortfolioIds  String
   */
  public void setTempAssignedPortfolioIds(String tempAssignedPortfolioIds) {
    this.tempAssignedPortfolioIds = tempAssignedPortfolioIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variables.
   *
   * @param  variables  Set
   */
  public void setVariables(Set<EnterpriseDocumentTemplateVariable> variables) {
    this.variables = variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for versions.
   *
   * @param  versions  Set
   */
  public void setVersions(Set<EnterpriseDocumentVersion> versions) {
    this.versions = versions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * sortVariableByDisplayOrder.
   */
  public void sortVariableByDisplayOrder() {
    List<EnterpriseDocumentTemplateVariable> sortList = new ArrayList<EnterpriseDocumentTemplateVariable>(variables);
    Collections.sort(sortList, new Comparator<EnterpriseDocumentTemplateVariable>() {
        @Override public int compare(EnterpriseDocumentTemplateVariable o1, EnterpriseDocumentTemplateVariable o2) {
          if (o1.getDisplayOrder() == null) {
            return 1;
          } else if (o2.getDisplayOrder() == null) {
            return -1;
          } else {
            return o1.getDisplayOrder().compareTo(o2.getDisplayOrder());
          }
        }
      });
    variables.clear();
    variables.addAll(sortList);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateActive.
   *
   * @param  user  User
   */
  public void updateActive(User user) {
    Date date = new Date();

    if ((this.inUsedVersion != null) && !this.inUsedVersion.isEmpty()) {
      for (EnterpriseDocumentVersion version : this.inUsedVersion) {
        version.setStatus(StatusType.OLD);
        version.setRetireBy(user);
        version.setRetireDate(date);
        version.setLastUpdater(user);
        version.setLastUpdateDate(date);
      }
    }

    this.setLastPublishBy(user);
    this.setLastPublishDate(date);
    this.setActive(Boolean.TRUE);
  }
} // end class EnterpriseDocument
