package com.cmc.credagility.core.domain.search;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 14:20
 */
@Entity
@Table(name = "SearchTemplate")
public class SearchTemplate {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "id",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(
    name     = "name",
    nullable = false,
    length   = 255
  )
  private String name;

  @Column(
    name     = "tpl",
    nullable = false,
    length   = 1000
  )
  private String tpl;

  @Column(
    name     = "url",
    nullable = false,
    length   = 1000
  )
  private String url;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tpl.
   *
   * @return  String
   */
  public String getTpl() {
    return tpl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for url.
   *
   * @return  String
   */
  public String getUrl() {
    return url;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tpl.
   *
   * @param  tpl  String
   */
  public void setTpl(String tpl) {
    this.tpl = tpl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for url.
   *
   * @param  url  String
   */
  public void setUrl(String url) {
    this.url = url;
  }
} // end class SearchTemplate
