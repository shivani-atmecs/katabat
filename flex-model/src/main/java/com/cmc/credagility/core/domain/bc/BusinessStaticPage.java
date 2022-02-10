package com.cmc.credagility.core.domain.bc;

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
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:37
 */
@Entity @Table public class BusinessStaticPage extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -973471639435651271L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSubFlow = false;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  @Lob protected String flexStationText;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String pageName;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 2048,
    nullable = true
  )
  protected String pageUrl;


  /** TODO: DOCUMENT ME! */
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

    if (!(o instanceof BusinessStaticPage)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BusinessStaticPage that = (BusinessStaticPage) o;

    if ((pageName != null) ? (!pageName.equals(that.pageName)) : (that.pageName != null)) {
      return false;
    }

    return true;
  }

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
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex station text.
   *
   * @return  String
   */
  public String getFlexStationText() {
    return flexStationText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for page name.
   *
   * @return  String
   */
  public String getPageName() {
    return pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for page url.
   *
   * @return  String
   */
  public String getPageUrl() {
    return pageUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static page id.
   *
   * @return  Long
   */
  public Long getStaticPageId() {
    return staticPageId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
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
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex station text.
   *
   * @param  flexStationText  String
   */
  public void setFlexStationText(String flexStationText) {
    this.flexStationText = flexStationText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for page name.
   *
   * @param  pageName  String
   */
  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for page url.
   *
   * @param  pageUrl  String
   */
  public void setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static page id.
   *
   * @param  staticPageId  Long
   */
  public void setStaticPageId(Long staticPageId) {
    this.staticPageId = staticPageId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
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
   * update.
   *
   * @param  other  BusinessStaticPage
   */
  public void update(BusinessStaticPage other) {
    this.pageName = other.getPageName();
    this.pageUrl  = other.getPageUrl();
  }

} // end class BusinessStaticPage
