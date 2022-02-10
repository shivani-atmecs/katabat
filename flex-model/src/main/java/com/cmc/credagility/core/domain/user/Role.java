package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.hibernate.annotations.Where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.agency.AgencyContactAddress;
import com.cmc.credagility.core.domain.agency.AgencyContactEmail;
import com.cmc.credagility.core.domain.agency.AgencyContactPhone;
import com.cmc.credagility.core.domain.agency.AgencyMetaData;
import com.cmc.credagility.core.domain.agency.AgencyMetaDataField;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.MetaDataValueType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * This class is used to represent available roles in the database.
 *
 * <p><a href="Role.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>Version by Dan Kibler dan@getrolling.com Extended to
 *           implement Acegi GrantedAuthority interface by David Carter david@carter.net
 * @version  10/15/2014 16:37
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "id",
  scope     = Role.class
)
@NamedQueries(
  {
    @NamedQuery(
      name = "findRoleByName",
      query = "select r from Role r where r.name = :name "
    )
  }
)
@Table(
  name              = "role",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = "name"),
    @UniqueConstraint(columnNames = "identityCode")
  },
  indexes           = {
    @Index(
      name          = "idx_clientCode",
      columnList    = "clientCode"
    )
  }
)
public class Role extends AbstractRole implements Serializable, GrantedAuthority {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3128589811300700488L;

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(Role.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean cmcOnly;

  /** TODO: DOCUMENT ME! */
  @Column(length = 150)
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enabled = true;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    cascade  = { CascadeType.REMOVE, CascadeType.ALL },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  protected ExternalEntity externalEntity;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "identityCode",
    length   = 36,
    nullable = true
  )
  protected String identityCode;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "agency"
  )
  protected Set<AgencyMetaData> metaDataSet = new HashSet<AgencyMetaData>();

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 150,
    nullable = false
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "organizationLevelFourId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected OrganizationLevelFour organizationLevelFour;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "organizationLevelOneId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected OrganizationLevelOne organizationLevelOne;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "organizationLevelThreeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected OrganizationLevelThree organizationLevelThree;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "organizationLevelTwoId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected OrganizationLevelTwo organizationLevelTwo;

  /** TODO: DOCUMENT ME! */
  @Column(length = 80)
  protected String primaryContactFirstName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 80)
  protected String primaryContactLastName;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RoleManagedPortfolio",
    indexes            = { @Index(columnList = "roleId") },
    joinColumns        = {
      @JoinColumn(
        name           = "roleId",
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
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<Portfolio> roleManagedPortfolios = new LinkedHashSet<Portfolio>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "roleTypeId")
  @ManyToOne(fetch = FetchType.EAGER)
  protected RoleType roleType;

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  private Set<AgencyContactAddress> agencyContactAddresses = new LinkedHashSet<AgencyContactAddress>();

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  private Set<AgencyContactEmail> agencyContactEmails = new LinkedHashSet<AgencyContactEmail>();

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  private Set<AgencyContactPhone> agencyContactPhones = new LinkedHashSet<AgencyContactPhone>();

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  @OrderBy("functionName asc")
  @Where(clause = "application = 'agent'")
  private Set<RoleFunction> agentFunctions = new LinkedHashSet<RoleFunction>();

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  @OrderBy("functionName asc")
  @Where(clause = "application = 'bcc'")
  private Set<RoleFunction> bccFunctions = new LinkedHashSet<RoleFunction>();

  @Column(nullable = true)
  private Integer clientCode;

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  private Set<RoleContext> contexts = new LinkedHashSet<RoleContext>();

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  private Set<RoleFeature> features = new LinkedHashSet<RoleFeature>();

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "role"
  )
  @OrderBy("application asc")
  private Set<RoleFunction> functions = new LinkedHashSet<RoleFunction>();


  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;


  @Column(length = 255)
  private String webPage;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Default constructor - creates a new instance with no values set.
   */
  public Role() { }

  /**
   * Create a new instance and set the name.
   *
   * @param  name  name of the role.
   */
  public Role(String name) {
    this.name = name;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addContext.
   *
   * @param  context  BusinessContext
   */
  public void addContext(BusinessContext context) {
    RoleContext roleContext = new RoleContext();
    roleContext.setRole(this);
    roleContext.setBusinessContext(context);

    this.contexts.add(roleContext);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addContext.
   *
   * @param  context  String
   */
  public void addContext(String context) {
    RoleContext roleContext = new RoleContext();
    roleContext.setRole(this);
    roleContext.setStaticContext(context);

    this.contexts.add(roleContext);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFeature.
   *
   * @param  feature   Feature
   * @param  criteria  String
   */
  public void addFeature(Feature feature, String criteria) {
    RoleFeature roleFeature = new RoleFeature();
    roleFeature.setCriteria(criteria);
    roleFeature.setRole(this);
    roleFeature.setFeature(feature);

    this.features.add(roleFeature);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addOrUpdateVariableMetaData.
   *
   * @param   field          AgencyMetaDataField
   * @param   metaDataValue  Object
   *
   * @return  AgencyMetaData
   */
  public AgencyMetaData addOrUpdateVariableMetaData(AgencyMetaDataField field, Object metaDataValue) {
    Object targetValue = null;

    if (metaDataValue == null) {
      log.info("Meta data value is null.");
    } else {
      targetValue = MetaDataValueType.convertToMetaType(field.getType(), metaDataValue);

      if (targetValue == null) {
        log.error("Meta data value type is not correct type.");
      }
    }

    AgencyMetaData curMetaData = null;
    Date           now         = new Date();

    for (AgencyMetaData metaData : getMetaDataSet()) {
      AgencyMetaDataField curField = metaData.getMetaDataField();

      if ((curField == field) || (curField.getId().equals(field.getId())) || (curField.equals(field))) {
        curMetaData = metaData;

        break;
      }
    }

    if (curMetaData == null) {
      curMetaData = new AgencyMetaData();
      curMetaData.setAgency(this);
      curMetaData.setMetaDataField(field);

      metaDataSet.add(curMetaData);
    }

    curMetaData.setValue(String.valueOf(targetValue));

    return curMetaData;
  } // end method addOrUpdateVariableMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addPortfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void addPortfolio(Portfolio portfolio) {
    this.roleManagedPortfolios.add(portfolio);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * auditEquals.
   *
   * @param   that  Role
   *
   * @return  boolean
   */
  public boolean auditEquals(Role that) {
    if (this == that) {
      return true;
    }

    if ((that == null) || (getClass() != that.getClass())) {
      return false;
    }

    if ((organizationRole != null) ? (!organizationRole.equals(that.organizationRole))
                                   : (that.organizationRole != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((organizationLevel != null) ? (!organizationLevel.equals(that.organizationLevel))
                                    : (that.organizationLevel != null)) {
      return false;
    }

    return true;
  } // end method auditEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * compareTo.
   *
   * @param   o  GrantedAuthority
   *
   * @return  int
   */
  public int compareTo(GrantedAuthority o) {
    return (equals(o) ? 0 : -1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Role)) {
      return false;
    }

    final Role role = (Role) o;

    return !((name != null) ? (!name.equals(role.name)) : (role.name != null));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFeature.
   *
   * @param   feature  Feature
   *
   * @return  RoleFeature
   */
  public RoleFeature findFeature(Feature feature) {
    for (RoleFeature roleFeature : this.features) {
      if (roleFeature.getFeature().equals(feature)) {
        return roleFeature;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency contact addresses.
   *
   * @return  Set
   */
  public Set<AgencyContactAddress> getAgencyContactAddresses() {
    return agencyContactAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency contact emails.
   *
   * @return  Set
   */
  public Set<AgencyContactEmail> getAgencyContactEmails() {
    return agencyContactEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency contact phones.
   *
   * @return  Set
   */
  public Set<AgencyContactPhone> getAgencyContactPhones() {
    return agencyContactPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent functions.
   *
   * @return  Set
   */
  public Set<RoleFunction> getAgentFunctions() {
    return agentFunctions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name property (getAuthority required by Acegi's GrantedAuthority interface).
   *
   * @return  the name property (getAuthority required by Acegi's GrantedAuthority interface)
   *
   * @see     org.springframework.security.core.GrantedAuthority#getAuthority()
   */
  @Override @Transient public String getAuthority() {
    return getName();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bcc functions.
   *
   * @return  Set
   */
  public Set<RoleFunction> getBccFunctions() {
    return bccFunctions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client code.
   *
   * @return  Integer
   */
  public Integer getClientCode() {
    return clientCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc only.
   *
   * @return  Boolean
   */
  public Boolean getCmcOnly() {
    return cmcOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contexts.
   *
   * @return  Set
   */
  public Set<RoleContext> getContexts() {
    return contexts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email by type.
   *
   * @param   emailType  EmailType
   *
   * @return  AgencyContactEmail
   */
  public AgencyContactEmail getEmailByType(EmailType emailType) {
    if ((agencyContactEmails != null) && !agencyContactEmails.isEmpty()) {
      for (AgencyContactEmail agencyContactEmail : agencyContactEmails) {
        if (agencyContactEmail.getEmailType().getTypeId().equals(emailType.getTypeId())) {
          return agencyContactEmail;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enabled.
   *
   * @return  Boolean
   */
  public Boolean getEnabled() {
    return enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity.
   *
   * @return  ExternalEntity
   */
  public ExternalEntity getExternalEntity() {
    return externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for features.
   *
   * @return  Set
   */
  public Set<RoleFeature> getFeatures() {
    return features;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for functions.
   *
   * @return  Set
   */
  public Set<RoleFunction> getFunctions() {
    return functions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for identity code.
   *
   * @return  String
   */
  public String getIdentityCode() {
    return identityCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data set.
   *
   * @return  Set
   */
  public Set<AgencyMetaData> getMetaDataSet() {
    return metaDataSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for organization level four.
   *
   * @return  OrganizationLevelFour
   */
  public OrganizationLevelFour getOrganizationLevelFour() {
    return organizationLevelFour;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for organization level one.
   *
   * @return  OrganizationLevelOne
   */
  public OrganizationLevelOne getOrganizationLevelOne() {
    return organizationLevelOne;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for organization level three.
   *
   * @return  OrganizationLevelThree
   */
  public OrganizationLevelThree getOrganizationLevelThree() {
    return organizationLevelThree;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for organization level two.
   *
   * @return  OrganizationLevelTwo
   */
  public OrganizationLevelTwo getOrganizationLevelTwo() {
    return organizationLevelTwo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary contact first name.
   *
   * @return  String
   */
  public String getPrimaryContactFirstName() {
    return primaryContactFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for primary contact last name.
   *
   * @return  String
   */
  public String getPrimaryContactLastName() {
    return primaryContactLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role managed portfolios.
   *
   * @return  Set
   */
  public Set<Portfolio> getRoleManagedPortfolios() {
    return roleManagedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role type.
   *
   * @return  RoleType
   */
  public RoleType getRoleType() {
    return roleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web page.
   *
   * @return  String
   */
  public String getWebPage() {
    return webPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasFeature.
   *
   * @param   featureName  String
   *
   * @return  boolean
   */
  public boolean hasFeature(String featureName) {
    if ((features == null) || !StringUtils.hasText(featureName)
          || (features.size() <= 0)) {
      return false;
    }

    for (RoleFeature feature : features) {
      if (featureName.equalsIgnoreCase(
              feature.getFeature().getFeatureName())) {
        return true;
      }
    }

    return false;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return ((name != null) ? name.hashCode() : 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeContext.
   *
   * @param  context  BusinessContext
   */
  public void removeContext(BusinessContext context) {
    for (RoleContext roleContext : this.contexts) {
      if (roleContext.getBusinessContext().getId().equals(
              context.getId())) {
        this.contexts.remove(roleContext);

        break;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeContext.
   *
   * @param  context  String
   */
  public void removeContext(String context) {
    for (RoleContext roleContext : this.contexts) {
      if (roleContext.getStaticContext().equalsIgnoreCase(context)) {
        this.contexts.remove(roleContext);

        break;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeFeature.
   *
   * @param  feature  Feature
   */
  public void removeFeature(Feature feature) {
    for (RoleFeature roleFeature : this.features) {
      if (roleFeature.getFeature().getFeatureId().equals(
              feature.getFeatureId())) {
        this.features.remove(roleFeature);

        break;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removePortfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void removePortfolio(Portfolio portfolio) {
    for (Portfolio p : this.roleManagedPortfolios) {
      if (p.getPortfolioId().equals(portfolio.getPortfolioId())) {
        this.roleManagedPortfolios.remove(portfolio);

        return;
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency contact addresses.
   *
   * @param  agencyContactAddresses  Set
   */
  public void setAgencyContactAddresses(Set<AgencyContactAddress> agencyContactAddresses) {
    this.agencyContactAddresses = agencyContactAddresses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency contact emails.
   *
   * @param  agencyContactEmails  Set
   */
  public void setAgencyContactEmails(Set<AgencyContactEmail> agencyContactEmails) {
    this.agencyContactEmails = agencyContactEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency contact phones.
   *
   * @param  agencyContactPhones  Set
   */
  public void setAgencyContactPhones(Set<AgencyContactPhone> agencyContactPhones) {
    this.agencyContactPhones = agencyContactPhones;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent functions.
   *
   * @param  agentFunctions  Set
   */
  public void setAgentFunctions(Set<RoleFunction> agentFunctions) {
    this.agentFunctions = agentFunctions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bcc functions.
   *
   * @param  bccFunctions  Set
   */
  public void setBccFunctions(Set<RoleFunction> bccFunctions) {
    this.bccFunctions = bccFunctions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client code.
   *
   * @param  clientCode  Integer
   */
  public void setClientCode(Integer clientCode) {
    this.clientCode = clientCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc only.
   *
   * @param  cmcOnly  Boolean
   */
  public void setCmcOnly(Boolean cmcOnly) {
    this.cmcOnly = cmcOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contexts.
   *
   * @param  contexts  Set
   */
  public void setContexts(Set<RoleContext> contexts) {
    this.contexts = contexts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enabled.
   *
   * @param  enabled  Boolean
   */
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity.
   *
   * @param  externalEntity  ExternalEntity
   */
  public void setExternalEntity(ExternalEntity externalEntity) {
    this.externalEntity = externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for features.
   *
   * @param  features  Set
   */
  public void setFeatures(Set<RoleFeature> features) {
    this.features = features;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for functions.
   *
   * @param  functions  Set
   */
  public void setFunctions(Set<RoleFunction> functions) {
    this.functions = functions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for identity code.
   *
   * @param  identityCode  String
   */
  public void setIdentityCode(String identityCode) {
    this.identityCode = identityCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data set.
   *
   * @param  metaDataSet  Set
   */
  public void setMetaDataSet(Set<AgencyMetaData> metaDataSet) {
    this.metaDataSet = metaDataSet;
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
   * setter method for organization level four.
   *
   * @param  organizationLevelFour  OrganizationLevelFour
   */
  public void setOrganizationLevelFour(OrganizationLevelFour organizationLevelFour) {
    this.organizationLevelFour = organizationLevelFour;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for organization level one.
   *
   * @param  organizationLevelOne  OrganizationLevelOne
   */
  public void setOrganizationLevelOne(OrganizationLevelOne organizationLevelOne) {
    this.organizationLevelOne = organizationLevelOne;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for organization level three.
   *
   * @param  organizationLevelThree  OrganizationLevelThree
   */
  public void setOrganizationLevelThree(OrganizationLevelThree organizationLevelThree) {
    this.organizationLevelThree = organizationLevelThree;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for organization level two.
   *
   * @param  organizationLevelTwo  OrganizationLevelTwo
   */
  public void setOrganizationLevelTwo(OrganizationLevelTwo organizationLevelTwo) {
    this.organizationLevelTwo = organizationLevelTwo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary contact first name.
   *
   * @param  primaryContactFirstName  String
   */
  public void setPrimaryContactFirstName(String primaryContactFirstName) {
    this.primaryContactFirstName = primaryContactFirstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary contact last name.
   *
   * @param  primaryContactLastName  String
   */
  public void setPrimaryContactLastName(String primaryContactLastName) {
    this.primaryContactLastName = primaryContactLastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role managed portfolios.
   *
   * @param  roleManagedPortfolios  Set
   */
  public void setRoleManagedPortfolios(Set<Portfolio> roleManagedPortfolios) {
    this.roleManagedPortfolios = roleManagedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role type.
   *
   * @param  roleType  RoleType
   */
  public void setRoleType(RoleType roleType) {
    this.roleType = roleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web page.
   *
   * @param  webPage  String
   */
  public void setWebPage(String webPage) {
    this.webPage = webPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(
        this.name).toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  role  Role
   */
  public void update(Role role) {
    this.name                   = role.getName();
    this.description            = role.getDescription();
    this.organizationRole       = role.getOrganizationRole();
    this.organizationLevel      = role.getOrganizationLevel();
    this.organizationLevelOne   = role.getOrganizationLevelOne();
    this.organizationLevelTwo   = role.getOrganizationLevelTwo();
    this.organizationLevelThree = role.getOrganizationLevelThree();
    this.organizationLevelFour  = this.getOrganizationLevelFour();
    this.roleType               = role.getRoleType();

    this.lastUpdateDate = new Date();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFeature.
   *
   * @param  feature   Feature
   * @param  criteria  String
   */
  public void updateFeature(Feature feature, String criteria) {
    RoleFeature roleFeature = findFeature(feature);

    if (roleFeature != null) {
      roleFeature.setCriteria(criteria);
    }
  }

} // end class Role
