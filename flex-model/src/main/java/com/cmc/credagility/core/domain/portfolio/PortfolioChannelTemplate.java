package com.cmc.credagility.core.domain.portfolio;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.channel.BasePortfolioChannelTemplateContent;
import com.cmc.credagility.core.domain.channel.ChannelType;
import com.cmc.credagility.core.domain.disclosure.DisclosureEvent;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Portfolio Channel Type Template information.
 *
 * <p><a href="PortfolioChannelType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioChannelTemplate extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8201309487529703431L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> active. */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;

  /** ChannelType PK channelTypeId. */
  @JoinColumn(
    name      = "channelTypeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelType channelType;

  /** script associated with template. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String content;

  /** Portfolio channel template content. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "template",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BasePortfolioChannelTemplateContent> contents =
    new LinkedHashSet<BasePortfolioChannelTemplateContent>();

  /** Portfolio channel template description. */
  @Column(length = 512)
  protected String description;

  /** Event. */
  @JoinColumn(
    name      = "disclosureEventId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DisclosureEvent disclosureEvent;

  /** Portfolio channel template Id, PK. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Portfolio channel template content. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "template"
  )
  @Where(clause = "version=(select temp.inUsedVersion from PortfolioChannelTemplate temp where temp.id=templateId)")
  protected Set<BasePortfolioChannelTemplateContent> inUsedContents =
    new LinkedHashSet<BasePortfolioChannelTemplateContent>();

  /** Which active version in used for current. */
  @Column protected Long inUsedVersion = 0L;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "locked",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean locked;

  /** channel template name. */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String name;

  /** portfolio. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Portfolio channel template variable. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "template"
  )
  protected Set<PortfolioChannelTemplateVariable> variables = new LinkedHashSet<PortfolioChannelTemplateVariable>();

  /** version number. */
  @Column protected Long version = 0L;

  /** Email from. */
  @Column(
    nullable = true,
    length   = 255
  )
  private String mailFrom;

  /** Email subject. */
  @Column(
    nullable = true,
    length   = 255
  )
  private String mailSubject;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void addVariables(PortfolioChannelTemplateVariable variable) {
    if (variable != null) {
      this.variables.add(variable);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioChannelTemplate)) {
      return false;
    }

    PortfolioChannelTemplate that = (PortfolioChannelTemplate) o;

    if ((active != null) ? (!active.equals(that.active)) : (that.active != null)) {
      return false;
    }

    if ((channelType != null) ? (!channelType.equals(that.channelType)) : (that.channelType != null)) {
      return false;
    }

    if ((content != null) ? (!content.equals(that.content)) : (that.content != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
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
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the channelType
   */
  public ChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   localeType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BasePortfolioChannelTemplateContent getContent(LocaleType localeType) {
    for (BasePortfolioChannelTemplateContent portfolioChannelTemplateContent : contents) {
      if (portfolioChannelTemplateContent.getLocale().equals(localeType)) {
        return portfolioChannelTemplateContent;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BasePortfolioChannelTemplateContent> getContents() {
    return contents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public DisclosureEvent getDisclosureEvent() {
    return disclosureEvent;
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
   * @param   locale  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BasePortfolioChannelTemplateContent getInUsedContent(String locale) {
    LocaleType localeType = LocaleType.convert(locale);

    if (localeType != null) {
      for (BasePortfolioChannelTemplateContent usedContent : inUsedContents) {
        if (usedContent.getLocale().toString().equals(localeType.toString())) {
          return usedContent;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BasePortfolioChannelTemplateContent> getInUsedContents() {
    return inUsedContents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getInUsedVersion() {
    return inUsedVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getLocked() {
    if (locked == null) {
      return Boolean.FALSE;
    }

    return locked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMailFrom() {
    return mailFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMailSubject() {
    return mailSubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   variable  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioChannelTemplateVariable getVariable(String variable) {
    for (PortfolioChannelTemplateVariable portfolioChannelTemplateVariable : variables) {
      if (portfolioChannelTemplateVariable.getExpression().equalsIgnoreCase(variable)) {
        return portfolioChannelTemplateVariable;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioChannelTemplateVariable> getVariables() {
    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getVersion() {
    return (version == null) ? 0L : version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 37;
    result = (31 * result) + ((channelType != null) ? channelType.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((content != null) ? content.hashCode() : 0);
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);

    return result;
  }
  /*
  * (non-Javadoc)
  *
  * @see java.lang.Object#equals(java.lang.Object)
  */

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  active  DOCUMENT ME!
   */
  public void setActive(Boolean active) {
    this.active = active;
  }
  /*
    * (non-Javadoc)
    *
    * @see java.lang.Object#hashCode()
    */

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelType  the channelType to set
   */
  public void setChannelType(ChannelType channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  content  DOCUMENT ME!
   */
  public void setContent(String content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contents  DOCUMENT ME!
   */
  public void setContents(Set<BasePortfolioChannelTemplateContent> contents) {
    this.contents = contents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disclosureEvent  DOCUMENT ME!
   */
  public void setDisclosureEvent(DisclosureEvent disclosureEvent) {
    this.disclosureEvent = disclosureEvent;
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
   * @param  inUsedContents  DOCUMENT ME!
   */
  public void setInUsedContents(Set<BasePortfolioChannelTemplateContent> inUsedContents) {
    this.inUsedContents = inUsedContents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  inUsedVersion  DOCUMENT ME!
   */
  public void setInUsedVersion(Long inUsedVersion) {
    this.inUsedVersion = inUsedVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  locked  DOCUMENT ME!
   */
  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mailFrom  DOCUMENT ME!
   */
  public void setMailFrom(String mailFrom) {
    this.mailFrom = mailFrom;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mailSubject  DOCUMENT ME!
   */
  public void setMailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  the portfolio to set
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variables  DOCUMENT ME!
   */
  public void setVariables(Set<PortfolioChannelTemplateVariable> variables) {
    this.variables = variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioChannelTemplate");
    sb.append("{id=").append(id);
    sb.append(", description=").append(description);
    sb.append(", channelType=").append(channelType);
    sb.append(", portfolio=").append(portfolio);
    sb.append(", name='").append(name).append('\'');
    sb.append(", content='").append(content).append('\'');
    sb.append(", active=").append(active);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioChannelTemplate
