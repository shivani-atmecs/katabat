package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 17:38
 */
@Entity
@Table(name = "AccountAuto")
public class AccountAuto extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1327897894576L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;
  @Column(
    name   = "autoDescription",
    length = 255
  )
  private String  autoDescription;

  // npelleti 08/11 droped unique constraint.
  @Column(
    name     = "autoId",

    // unique   = true,
    nullable = false
  )

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long autoId;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name      = "interestRate",
    nullable  = false,
    precision = 19,
    scale     = 4
  )
  private BigDecimal interestRate;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name     = "loanDuration",
    nullable = false,
    length   = 11
  )
  private Integer loanDuration;


  @Column(
    name   = "loanNum",
    length = 20
  )
  private String loanNum;


  @Column(
    name   = "loanProvider",
    length = 100
  )
  private String     loanProvider;
  @Column(name = "principalAmount")
  private BigDecimal principalAmount;
  @Column(name = "purchaseDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       purchaseDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>lazy = "proxy" column = "accountNum" not-null = "true" class = "com.cmc.credagility.Account" insert =
   *          "true" update = "false"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "255"</p>
   */
  public String getAutoDescription() {
    return autoDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getAutoId() {
    return autoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "true" precision = "19" scale = "4"</p>
   */
  public BigDecimal getInterestRate() {
    return interestRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanDuration() {
    return loanDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "20"</p>
   */
  public String getLoanNum() {
    return loanNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "100"</p>
   */
  public String getLoanProvider() {
    return loanProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMaskedLoanNum() {
    if (!StringUtils.hasText(loanNum)) {
      return "";
    }

    int len = loanNum.length();

    if (len > 5) {
      return "XXXXXXXX-" + loanNum.substring(len - 4, len);
    }

    return "XXXXXXXX-" + loanNum.substring(len - 1, len);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPrincipalAmount() {
    return principalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPurchaseDate() {
    return purchaseDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  autoDescription  DOCUMENT ME!
   */
  public void setAutoDescription(String autoDescription) {
    this.autoDescription = autoDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  autoId  DOCUMENT ME!
   */
  public void setAutoId(Long autoId) {
    this.autoId = autoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  interestRate  DOCUMENT ME!
   */
  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loanDuration  DOCUMENT ME!
   */
  public void setLoanDuration(Integer loanDuration) {
    this.loanDuration = loanDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loanNum  DOCUMENT ME!
   */
  public void setLoanNum(String loanNum) {
    this.loanNum = loanNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loanProvider  DOCUMENT ME!
   */
  public void setLoanProvider(String loanProvider) {
    this.loanProvider = loanProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalAmount  DOCUMENT ME!
   */
  public void setPrincipalAmount(BigDecimal principalAmount) {
    this.principalAmount = principalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  purchaseDate  DOCUMENT ME!
   */
  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

} // end class AccountAuto
