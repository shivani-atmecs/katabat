package com.cmc.credagility.core.domain.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Division;


/**
 * This class is used to store BaseUrlInfo information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:37
 */
@Entity
@Table(
  name    = "BaseUrlInfo",
  indexes = {
    @Index(
      name = "strKey",
      columnList = "strKey"
    )
  }
)
public class BaseUrlInfo extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1777836257853882690L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Criteria. */
  @Column(length = 255)
  protected String criteria;


  /** Pk. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         id;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String strKey;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String url;

  @JoinColumn(name = "divisionId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Division division;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BaseUrlInfo baseUrlInfo = (BaseUrlInfo) o;

    if ((strKey != null) ? (!strKey.equals(baseUrlInfo.strKey)) : (baseUrlInfo.strKey != null)) {
      return false;
    }

    if ((url != null) ? (!url.equals(baseUrlInfo.url)) : (baseUrlInfo.url != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(baseUrlInfo.criteria)) : (baseUrlInfo.criteria != null)) {
      return false;
    }

    if (((division != null) && (division.getDivisionName() != null))
          ? (!division.getDivisionName().equals(baseUrlInfo.division.getDivisionName()))
          : (baseUrlInfo.division != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for division.
   *
   * @return  Division
   */
  public Division getDivision() {
    return division;
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
   * getter method for str key.
   *
   * @return  String
   */
  public String getStrKey() {
    return strKey;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((strKey != null) ? strKey.hashCode() : 0);
    result = (31 * result) + ((url != null) ? url.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((division != null) ? division.getDivisionName().hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for division.
   *
   * @param  division  Division
   */
  public void setDivision(Division division) {
    this.division = division;
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
   * setter method for str key.
   *
   * @param  strKey  String
   */
  public void setStrKey(String strKey) {
    this.strKey = strKey;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BaseUrlInfo");
    sb.append("{strKey='").append(strKey).append('\'');
    sb.append(", criteria='").append(criteria).append('\'');
    sb.append(", url='").append(url).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class BaseUrlInfo
