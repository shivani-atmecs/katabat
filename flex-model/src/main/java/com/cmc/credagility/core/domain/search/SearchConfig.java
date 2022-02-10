package com.cmc.credagility.core.domain.search;

import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:16
 */
@Entity
@Table(name = "SearchConfig")
public class SearchConfig {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5553879490170922847L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = Boolean.TRUE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "searchTemplateId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SearchTemplate searchTemplate;
  @Column(
    name   = "dateFormat",
    length = 50
  )
  private String           dateFormat;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "description",
    nullable = true,
    length   = 255
  )
  private String description;

  @Column(
    name     = "helper",
    nullable = false,
    length   = 400
  )
  private String helper;

  @Column(
    name     = "priority",
    nullable = false,
    length   = 11
  )
  private Long priority;

  // (Like{0},Equal{1},HashEqual...) etc
  @Column(
    name     = "queryParams",
    nullable = true,
    length   = 255
  )
  private String queryParams;
  @Column(
    name     = "querySql",
    nullable = false,
    length   = 10000
  )
  private String querySql;

  @Column(
    name     = "searchConfigId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long searchConfigId;
  @Column(
    name     = "searchMethodName",
    nullable = false,
    length   = 255
  )
  private String   searchMethodName;
  @Column(
    name     = "searchResultTemplate",
    nullable = false,
    length   = 255
  )
  private String   searchResultTemplate;

  // lz
  @Column(
    name     = "searchToken",
    nullable = true,
    length   = 255
  )
  private String searchToken;

  @Column(
    name     = "searchTriggerRegExp",
    nullable = false,
    length   = 255
  )
  private String searchTriggerRegExp;

  @Column(
    name     = "tag",
    nullable = true,
    length   = 255
  )
  private String tag;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SearchConfig object.
   */
  public SearchConfig() { }

  /**
   * Creates a new SearchConfig object.
   *
   * @param  searchConfigId  Long
   * @param  searchToken     String
   * @param  queryParams     String
   * @param  querySql        String
   */
  public SearchConfig(Long searchConfigId, String searchToken, String queryParams, String querySql) {
    this.searchConfigId = searchConfigId;
    this.searchToken    = searchToken;
    this.queryParams    = queryParams;
    this.querySql       = querySql;
  }

  /**
   * Creates a new SearchConfig object.
   *
   * @param  searchConfigId        Long
   * @param  searchMethodName      String
   * @param  searchToken           String
   * @param  searchTriggerRegExp   String
   * @param  searchResultTemplate  String
   * @param  description           String
   */
  public SearchConfig(Long searchConfigId, String searchMethodName, String searchToken, String searchTriggerRegExp,
    String searchResultTemplate, String description) {
    this.searchConfigId       = searchConfigId;
    this.searchMethodName     = searchMethodName;
    this.searchToken          = searchToken;
    this.searchTriggerRegExp  = searchTriggerRegExp;
    this.searchResultTemplate = searchResultTemplate;
    this.description          = description;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      // NULL means active - maximize performance
      return Boolean.TRUE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date format.
   *
   * @return  String
   */
  public String getDateFormat() {
    return dateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for helper.
   *
   * @return  String
   */
  public String getHelper() {
    return helper;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Long
   */
  public Long getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query params.
   *
   * @return  String
   */
  public String getQueryParams() {
    return queryParams;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query sql.
   *
   * @return  String
   */
  public String getQuerySql() {
    return querySql;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search config id.
   *
   * @return  Long
   */
  public Long getSearchConfigId() {
    return searchConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search method name.
   *
   * @return  String
   */
  public String getSearchMethodName() {
    return searchMethodName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search result template.
   *
   * @return  String
   */
  public String getSearchResultTemplate() {
    return searchResultTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search template.
   *
   * @return  SearchTemplate
   */
  public SearchTemplate getSearchTemplate() {
    return searchTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search token.
   *
   * @return  String
   */
  public String getSearchToken() {
    return searchToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search trigger reg exp.
   *
   * @return  String
   */
  public String getSearchTriggerRegExp() {
    return searchTriggerRegExp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tag.
   *
   * @return  String
   */
  public String getTag() {
    return tag;
  }

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
   * setter method for date format.
   *
   * @param  dateFormat  String
   */
  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for helper.
   *
   * @param  helper  String
   */
  public void setHelper(String helper) {
    this.helper = helper;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Long
   */
  public void setPriority(Long priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for query params.
   *
   * @param  queryParams  String
   */
  public void setQueryParams(String queryParams) {
    this.queryParams = queryParams;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for query sql.
   *
   * @param  querySql  String
   */
  public void setQuerySql(String querySql) {
    this.querySql = querySql;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search config id.
   *
   * @param  searchConfigId  Long
   */
  public void setSearchConfigId(Long searchConfigId) {
    this.searchConfigId = searchConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search method name.
   *
   * @param  searchMethodName  String
   */
  public void setSearchMethodName(String searchMethodName) {
    this.searchMethodName = searchMethodName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search result template.
   *
   * @param  searchResultTemplate  String
   */
  public void setSearchResultTemplate(String searchResultTemplate) {
    this.searchResultTemplate = searchResultTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search template.
   *
   * @param  searchTemplate  SearchTemplate
   */
  public void setSearchTemplate(SearchTemplate searchTemplate) {
    this.searchTemplate = searchTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search token.
   *
   * @param  searchToken  String
   */
  public void setSearchToken(String searchToken) {
    this.searchToken = searchToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search trigger reg exp.
   *
   * @param  searchTriggerRegExp  String
   */
  public void setSearchTriggerRegExp(String searchTriggerRegExp) {
    this.searchTriggerRegExp = searchTriggerRegExp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tag.
   *
   * @param  tag  String
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

} // end class SearchConfig
