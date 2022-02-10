package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:11
 */
@Entity
@Table(name = "TsysAggregatedPromiseToPayHistory")
public class TsysAggregatedPromiseToPayHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7279935838697302607L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "brokenPromiseFlagsLTD",
    length = 25
  )
  protected String brokenPromiseFlagsLTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "brokenPromisesAmountPrevYear",
    length = 25
  )
  protected String brokenPromisesAmountPrevYear;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "brokenPromisesAmountYTD",
    length = 25
  )
  protected String brokenPromisesAmountYTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "brokenPromisesPrevYear",
    length = 25
  )
  protected String brokenPromisesPrevYear;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partialPromisesAmountPrevYear",
    length = 25
  )
  protected String partialPromisesAmountPrevYear;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partialPromisesAmountYTD",
    length = 25
  )
  protected String partialPromisesAmountYTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partialPromisesLTD",
    length = 25
  )
  protected String partialPromisesLTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partialPromisesPrevYear",
    length = 25
  )
  protected String partialPromisesPrevYear;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "partialPromisesYTD",
    length = 25
  )
  protected String partialPromisesYTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "promisesAmountKeptPrevYear",
    length = 25
  )
  protected String promisesAmountKeptPrevYear;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "promisesAmountKeptYTD",
    length = 25
  )
  protected String promisesAmountKeptYTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "promisesKeptLTD",
    length = 25
  )
  protected String promisesKeptLTD;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "promisesKeptPartially",
    length = 25
  )
  protected String promisesKeptPartially;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "promisesKeptPrevYear",
    length = 25
  )
  protected String promisesKeptPrevYear;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "promisesKeptYTD",
    length = 25
  )
  protected String promisesKeptYTD;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "tsysAccountId",
    updatable = false,
    nullable  = false
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected TsysAccount tsysAccount;

  /** Document PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long tsysAggregatedPromiseToPayHistoryId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promise flags LTD.
   *
   * @return  String
   */
  public String getBrokenPromiseFlagsLTD() {
    return brokenPromiseFlagsLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promises amount prev year.
   *
   * @return  String
   */
  public String getBrokenPromisesAmountPrevYear() {
    return brokenPromisesAmountPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promises amount YTD.
   *
   * @return  String
   */
  public String getBrokenPromisesAmountYTD() {
    return brokenPromisesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for broken promises prev year.
   *
   * @return  String
   */
  public String getBrokenPromisesPrevYear() {
    return brokenPromisesPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for partial promises amount prev year.
   *
   * @return  String
   */
  public String getPartialPromisesAmountPrevYear() {
    return partialPromisesAmountPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for partial promises amount YTD.
   *
   * @return  String
   */
  public String getPartialPromisesAmountYTD() {
    return partialPromisesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for partial promises LTD.
   *
   * @return  String
   */
  public String getPartialPromisesLTD() {
    return partialPromisesLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for partial promises prev year.
   *
   * @return  String
   */
  public String getPartialPromisesPrevYear() {
    return partialPromisesPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for partial promises YTD.
   *
   * @return  String
   */
  public String getPartialPromisesYTD() {
    return partialPromisesYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises amount kept prev year.
   *
   * @return  String
   */
  public String getPromisesAmountKeptPrevYear() {
    return promisesAmountKeptPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises amount kept YTD.
   *
   * @return  String
   */
  public String getPromisesAmountKeptYTD() {
    return promisesAmountKeptYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises kept LTD.
   *
   * @return  String
   */
  public String getPromisesKeptLTD() {
    return promisesKeptLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises kept partially.
   *
   * @return  String
   */
  public String getPromisesKeptPartially() {
    return promisesKeptPartially;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises kept prev year.
   *
   * @return  String
   */
  public String getPromisesKeptPrevYear() {
    return promisesKeptPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promises kept YTD.
   *
   * @return  String
   */
  public String getPromisesKeptYTD() {
    return promisesKeptYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys account.
   *
   * @return  TsysAccount
   */
  public TsysAccount getTsysAccount() {
    return tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys aggregated promise to pay history id.
   *
   * @return  Long
   */
  public Long getTsysAggregatedPromiseToPayHistoryId() {
    return tsysAggregatedPromiseToPayHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result)
      + ((tsysAggregatedPromiseToPayHistoryId != null) ? tsysAggregatedPromiseToPayHistoryId.hashCode() : 0);
    result = (31 * result) + ((tsysAccount != null) ? tsysAccount.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for broken promise flags LTD.
   *
   * @param  brokenPromiseFlagsLTD  String
   */
  public void setBrokenPromiseFlagsLTD(String brokenPromiseFlagsLTD) {
    this.brokenPromiseFlagsLTD = brokenPromiseFlagsLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for broken promises amount prev year.
   *
   * @param  brokenPromisesAmountPrevYear  String
   */
  public void setBrokenPromisesAmountPrevYear(String brokenPromisesAmountPrevYear) {
    this.brokenPromisesAmountPrevYear = brokenPromisesAmountPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for broken promises amount YTD.
   *
   * @param  brokenPromisesAmountYTD  String
   */
  public void setBrokenPromisesAmountYTD(String brokenPromisesAmountYTD) {
    this.brokenPromisesAmountYTD = brokenPromisesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for broken promises prev year.
   *
   * @param  brokenPromisesPrevYear  String
   */
  public void setBrokenPromisesPrevYear(String brokenPromisesPrevYear) {
    this.brokenPromisesPrevYear = brokenPromisesPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for partial promises amount prev year.
   *
   * @param  partialPromisesAmountPrevYear  String
   */
  public void setPartialPromisesAmountPrevYear(String partialPromisesAmountPrevYear) {
    this.partialPromisesAmountPrevYear = partialPromisesAmountPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for partial promises amount YTD.
   *
   * @param  partialPromisesAmountYTD  String
   */
  public void setPartialPromisesAmountYTD(String partialPromisesAmountYTD) {
    this.partialPromisesAmountYTD = partialPromisesAmountYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for partial promises LTD.
   *
   * @param  partialPromisesLTD  String
   */
  public void setPartialPromisesLTD(String partialPromisesLTD) {
    this.partialPromisesLTD = partialPromisesLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for partial promises prev year.
   *
   * @param  partialPromisesPrevYear  String
   */
  public void setPartialPromisesPrevYear(String partialPromisesPrevYear) {
    this.partialPromisesPrevYear = partialPromisesPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for partial promises YTD.
   *
   * @param  partialPromisesYTD  String
   */
  public void setPartialPromisesYTD(String partialPromisesYTD) {
    this.partialPromisesYTD = partialPromisesYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises amount kept prev year.
   *
   * @param  promisesAmountKeptPrevYear  String
   */
  public void setPromisesAmountKeptPrevYear(String promisesAmountKeptPrevYear) {
    this.promisesAmountKeptPrevYear = promisesAmountKeptPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises amount kept YTD.
   *
   * @param  promisesAmountKeptYTD  String
   */
  public void setPromisesAmountKeptYTD(String promisesAmountKeptYTD) {
    this.promisesAmountKeptYTD = promisesAmountKeptYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises kept LTD.
   *
   * @param  promisesKeptLTD  String
   */
  public void setPromisesKeptLTD(String promisesKeptLTD) {
    this.promisesKeptLTD = promisesKeptLTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises kept partially.
   *
   * @param  promisesKeptPartially  String
   */
  public void setPromisesKeptPartially(String promisesKeptPartially) {
    this.promisesKeptPartially = promisesKeptPartially;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises kept prev year.
   *
   * @param  promisesKeptPrevYear  String
   */
  public void setPromisesKeptPrevYear(String promisesKeptPrevYear) {
    this.promisesKeptPrevYear = promisesKeptPrevYear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promises kept YTD.
   *
   * @param  promisesKeptYTD  String
   */
  public void setPromisesKeptYTD(String promisesKeptYTD) {
    this.promisesKeptYTD = promisesKeptYTD;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys account.
   *
   * @param  tsysAccount  TsysAccount
   */
  public void setTsysAccount(TsysAccount tsysAccount) {
    this.tsysAccount = tsysAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys aggregated promise to pay history id.
   *
   * @param  tsysAggregatedPromiseToPayHistoryId  Long
   */
  public void setTsysAggregatedPromiseToPayHistoryId(Long tsysAggregatedPromiseToPayHistoryId) {
    this.tsysAggregatedPromiseToPayHistoryId = tsysAggregatedPromiseToPayHistoryId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TsysAggregatedPromiseToPayHistoryId");
    sb.append("{tsysAggregatedPromiseToPayHistoryId=").append(tsysAggregatedPromiseToPayHistoryId);
    sb.append('}');

    return sb.toString();
  }
} // end class TsysAggregatedPromiseToPayHistory
