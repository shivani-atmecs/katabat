package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

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
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to represent the actions after survey was taken.
 *
 * <p><a href="PortfolioSurveyAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioStaticPage extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4511379323268076233L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> allow sub flow, default is <code>false.</code> */
  @Column(
    name             = "allowSubFlow",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSubFlow = false;

  /** The description for one task, it show in top of the task when execute workflow. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String flexStationText;

  /** Survey action name. */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String pageName;

  /** Which page will redirect. */
  @Column(
    length   = 2048,
    nullable = true
  )
  protected String pageUrl;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long staticPageId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioStaticPage)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioStaticPage that = (PortfolioStaticPage) o;

    if ((pageName != null) ? (!pageName.equals(that.pageName)) : (that.pageName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow sub flow.
   *
   * @return  Boolean
   */
  public Boolean getAllowSubFlow() {
    if (allowSubFlow == null) {
      return Boolean.FALSE;
    }

    return allowSubFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexStationText() {
    return flexStationText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPageName() {
    return pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPageUrl() {
    return pageUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getStaticPageId() {
    return staticPageId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((pageName != null) ? pageName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for thank you page.
   *
   * @return  boolean
   */
  public boolean isThankYouPage() {
    return "Thank You".equalsIgnoreCase(pageName)
      || "thankYou".equalsIgnoreCase(pageName);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow sub flow.
   *
   * @param  allowSubFlow  Boolean
   */
  public void setAllowSubFlow(Boolean allowSubFlow) {
    this.allowSubFlow = allowSubFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flexStationText  DOCUMENT ME!
   */
  public void setFlexStationText(String flexStationText) {
    this.flexStationText = flexStationText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  pageName  DOCUMENT ME!
   */
  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  pageUrl  DOCUMENT ME!
   */
  public void setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  staticPageId  DOCUMENT ME!
   */
  public void setStaticPageId(Long staticPageId) {
    this.staticPageId = staticPageId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyNextPage{");
    sb.append(", pageName='").append(pageName).append('\'');
    sb.append(", id=").append(staticPageId);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioStaticPage other) {
    this.pageName = other.getPageName();
    this.pageUrl  = other.getPageUrl();
  }
} // end class PortfolioStaticPage
