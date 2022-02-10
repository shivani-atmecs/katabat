package com.cmc.credagility.core.domain.businesscontext;


import com.cmc.credagility.core.domain.base.BaseEntity;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  04/23/2015 09:41
 */
@Entity public class BCIStatusDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -4396875686929755030L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted = false;


  /** TODO: DOCUMENT ME! */
  @Column(name = "description")
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "statusCode",
    nullable = false
  )
  protected String statusCode;

  @JoinColumn(
    name       = "businessContextId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BusinessContext businessContext;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * BusinessContext.
   *
   * @return  BusinessContext.
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getDeleted() {
    return deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getStatusCode() {
    return statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setBusinessContext.
   *
   * @param  businessContext  $param.type$
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setDeleted.
   *
   * @param  deleted  $param.type$
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setDescription.
   *
   * @param  description  $param.type$
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setStatusCode.
   *
   * @param  statusCode  $param.type$
   */
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }
} // end class BCIStatusDetail
