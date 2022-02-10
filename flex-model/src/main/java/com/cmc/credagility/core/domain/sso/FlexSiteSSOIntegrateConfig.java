package com.cmc.credagility.core.domain.sso;

import java.io.Serializable;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  02/17/2017 11:43
 */
@Entity
@Table(name = "FlexSiteSSOIntegrateConfig")
public class FlexSiteSSOIntegrateConfig implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3718982798460934455L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @Column(
    name     = "context",
    nullable = false,
    length   = 40
  )
  private String context;

  @Column(
    name     = "logoutURL",
    nullable = true,
    length   = 200
  )
  private String logoutURL;

  @Column(
    name     = "querySql",
    nullable = false,
    length   = 600
  )
  private String querySql;

  @Column(
    name     = "tag",
    unique   = true,
    nullable = false,
    length   = 255
  )
  private String tag;

  @Column(
    name     = "tokenFields",
    nullable = false,
    length   = 400
  )
  private String tokenFields;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new FlexSiteSSOIntegrateConfig object.
   */
  public FlexSiteSSOIntegrateConfig() { }

  /**
   * Creates a new FlexSiteSSOIntegrateConfig object.
   *
   * @param  logoutURL    String
   * @param  querySql     String
   * @param  tag          String
   * @param  tokenFields  String
   * @param  context      String
   */
  public FlexSiteSSOIntegrateConfig(String logoutURL, String querySql, String tag,
    String tokenFields, String context) {
    this.logoutURL   = logoutURL;
    this.querySql    = querySql;
    this.tag         = tag;
    this.tokenFields = tokenFields;
    this.context     = context;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
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
   * getter method for logout URL.
   *
   * @return  String
   */
  public String getLogoutURL() {
    return logoutURL;
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
   * getter method for tag.
   *
   * @return  String
   */
  public String getTag() {
    return tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for token fields.
   *
   * @return  String
   */
  public String getTokenFields() {
    return tokenFields;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
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
   * setter method for logout URL.
   *
   * @param  logoutURL  String
   */
  public void setLogoutURL(String logoutURL) {
    this.logoutURL = logoutURL;
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
   * setter method for tag.
   *
   * @param  tag  String
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for token fields.
   *
   * @param  tokenFields  String
   */
  public void setTokenFields(String tokenFields) {
    this.tokenFields = tokenFields;
  }
} // end class FlexSiteSSOIntegrateConfig
