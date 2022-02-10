package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * User Preview Result Search.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:08
 */
@Entity public class UserPreviewResultSearch extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2266936080152462272L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "userSavedSearchQuery",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected List<ExpQueryModel> expQueryModels = new ArrayList<ExpQueryModel>();

  /** TODO: DOCUMENT ME! */
  @Column protected Long previewResultId;

  /** query Name. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String queryName;

  /** query String. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String queryString;

  /** quer yUserId. */
  @Column protected Long queryUserId;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long searchId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for exp query models.
   *
   * @return  List
   */
  public List<ExpQueryModel> getExpQueryModels() {
    return expQueryModels;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview result id.
   *
   * @return  Long
   */
  public Long getPreviewResultId() {
    return previewResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query name.
   *
   * @return  String
   */
  public String getQueryName() {
    return queryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query string.
   *
   * @return  String
   */
  public String getQueryString() {
    return queryString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query user id.
   *
   * @return  Long
   */
  public Long getQueryUserId() {
    return queryUserId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search id.
   *
   * @return  Long
   */
  public Long getSearchId() {
    return searchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exp query models.
   *
   * @param  expQueryModels  List
   */
  public void setExpQueryModels(List<ExpQueryModel> expQueryModels) {
    this.expQueryModels = expQueryModels;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview result id.
   *
   * @param  previewResultId  Long
   */
  public void setPreviewResultId(Long previewResultId) {
    this.previewResultId = previewResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for query name.
   *
   * @param  queryName  String
   */
  public void setQueryName(String queryName) {
    this.queryName = queryName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for query string.
   *
   * @param  queryString  String
   */
  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for query user id.
   *
   * @param  queryUserId  Long
   */
  public void setQueryUserId(Long queryUserId) {
    this.queryUserId = queryUserId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search id.
   *
   * @param  searchId  Long
   */
  public void setSearchId(Long searchId) {
    this.searchId = searchId;
  }
} // end class UserPreviewResultSearch
