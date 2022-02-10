package com.cmc.credagility.core.domain.portfolio;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.ChannelType;


/**
 * This class is used to store Portfolio Channel Type information.
 *
 * <p><a href="PortfolioChannelType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PortfolioChannelType"</p>
 * @version  10/16/2014 10:00
 */
@Entity
@Table(name = "PortfolioChannelType")
public class PortfolioChannelType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8820679571377257001L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** channel type. */
  @JoinColumn(
    name      = "channelTypeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelType channelType;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** channel templates. */
  @Column(
    name     = "templates",
    nullable = false
  )
  protected String templates;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Portfolio channel type Id, PK. */
  @Column(
    name     = "typeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    PortfolioChannelType other = (PortfolioChannelType) obj;

    if (this.channelType == null) {
      if (other.channelType != null) {
        return false;
      }
    } else if (!this.channelType.equals(other.channelType)) {
      return false;
    }

    if (this.portfolio == null) {
      if (other.portfolio != null) {
        return false;
      }
    } else if (!this.portfolio.equals(other.portfolio)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The channelType.
   *
   * @return  the channelType
   *
   *          <p>column = "channelTypeId" not-null = "true" class = "com.cmc.credagility.ChannelType" insert = "true"
   *          update = "false"</p>
   */
  public ChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The portfolio.
   *
   * @return  the portfolio
   *
   *          <p>lazy = "proxy" column = "portfolioId" not-null = "true" class = "com.cmc.credagility.Portfolio" insert
   *          = "true" update = "false"</p>
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The templates.
   *
   * @return  the templates
   *
   *          <p>not-null = "true"</p>
   */
  public String getTemplates() {
    return templates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get template list.
   *
   * @return  get template list.
   */
  public Set<String> getTemplateSet() {
    Set<String> set = new LinkedHashSet<String>();

    if (templates != null) {
      String[] parts = templates.split(",");

      for (String part : parts) {
        set.add(part);
      }
    }

    return set;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The typeId.
   *
   * @return  the typeId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.channelType == null) ? 0 : this.channelType.hashCode());
    result = (prime * result)
      + ((this.portfolio == null) ? 0 : this.portfolio.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setChannelType.
   *
   * @param  channelType  the channelType to set
   */
  public void setChannelType(ChannelType channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPortfolio.
   *
   * @param  portfolio  the portfolio to set
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTemplates.
   *
   * @param  templates  the templates to set
   */
  public void setTemplates(String templates) {
    this.templates = templates;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTypeId.
   *
   * @param  typeId  the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
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

    retValue.append("PortfolioChannelType ( ").append(super.toString()).append(TAB).append(
      "portfolio = ").append(this.portfolio).append(TAB).append("typeId = ").append(
      this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class PortfolioChannelType
