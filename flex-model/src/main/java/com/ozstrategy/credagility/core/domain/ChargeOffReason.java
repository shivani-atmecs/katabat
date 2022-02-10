package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by yongwenchao on 15/8/5.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  08/05/2015 17:17
 */
@Entity
@Table(name = "ChargeOffReason")
public class ChargeOffReason extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 2733743027725880288L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false
  )
  @ManyToOne(cascade = { CascadeType.ALL })
  protected Portfolio portfolio;

  @Column(length = 255)
  private String   description;
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(length = 255)
  private String reasonCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge offcode.
   *
   * @return  setter method for charge offcode.
   */

  /**
   * getter method for charge offcode.
   *
   * @return  String
   */

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
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    return historical;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason.
   *
   * @return  setter method for reason.
   */
  public String getReasonCode() {
    return reasonCode;
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
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason code.
   *
   * @param  reasonCode  String
   */
  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }
} // end class ChargeOffReason
