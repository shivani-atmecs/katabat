package com.cmc.credagility.core.domain.citi;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.contact.ContactableBaseObject;


/**
 * CitiAccountOffer entity.
 *
 * @author   Kpalanivelu
 * @version  10/14/2014 16:11
 */
@Entity
@Table(name = "CitiAccountOffer")
public class CitiAccountOffer extends ContactableBaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5579087971478503377L;
  // Fields

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations CitiAccountOffer CitiAccount : */
  @JoinColumn(
    name       = "citiAccountId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CitiAccount citiAccount;

  // Constructors
  @Column(
    name      = "buydown",
    precision = 11,
    scale     = 2
  )
  private BigDecimal buydown;
  @Column(
    name      = "channelOriginalExpenditure",
    precision = 11,
    scale     = 2
  )
  private BigDecimal channelOriginalExpenditure;
  @Column(
    name   = "description",
    length = 15
  )
  private String     description;
  @Column(name = "expireDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       expireDate;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long         id;

  @Column(
    name      = "loanAmount",
    precision = 13,
    scale     = 2
  )
  private BigDecimal loanAmount;
  @Column(
    name      = "loanExpenditure",
    precision = 11,
    scale     = 2
  )
  private BigDecimal loanExpenditure;
  @Column(
    name      = "monthlyIncome",
    precision = 11,
    scale     = 2
  )
  private BigDecimal monthlyIncome;
  @Column(
    name      = "monthlyIncomeDifference",
    precision = 11,
    scale     = 2
  )
  private BigDecimal monthlyIncomeDifference;
  @Column(
    name      = "monthlyIncomeUpfront",
    precision = 11,
    scale     = 2
  )
  private BigDecimal monthlyIncomeUpfront;
  @Column(
    name      = "nclSaveAmount",
    precision = 11,
    scale     = 2
  )
  private BigDecimal nclSaveAmount;
  @Column(
    name      = "nclSavePercentage",
    precision = 10,
    scale     = 3
  )
  private BigDecimal nclSavePercentage;
  @Column(
    name      = "newPimi",
    precision = 11,
    scale     = 2
  )
  private BigDecimal newPimi;

  // private CitiAccount citiAccountId;
  // npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name     = "offer",
    length   = 20,
    nullable = false
  )
  private Long offer;

  @Column(name = "offerDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       offerDate;
  @Column(
    name     = "offerIndex",
    length   = 2,
    nullable = false
  )
  private Integer    offerIndex;
  @Column(
    name      = "payment",
    precision = 11,
    scale     = 2
  )
  private BigDecimal payment;
  @Column(
    name      = "paymentDifference",
    precision = 11,
    scale     = 2
  )
  private BigDecimal paymentDifference;
  @Column(
    name      = "plImpact",
    precision = 11,
    scale     = 2
  )
  private BigDecimal plImpact;
  @Column(
    name      = "postModPayment",
    precision = 11,
    scale     = 2
  )
  private BigDecimal postModPayment;
  @Column(
    name   = "prodcode",
    length = 10
  )
  private String     prodcode;
  @Column(
    name      = "rate",
    precision = 10,
    scale     = 3
  )
  private BigDecimal rate;
  @Column(
    name      = "rateDifference",
    precision = 10,
    scale     = 3
  )
  private BigDecimal rateDifference;
  @Column(
    name      = "totalCost",
    precision = 11,
    scale     = 2
  )
  private BigDecimal totalCost;
  @Column(
    name   = "type",
    length = 15
  )
  private String     type;
  @Column(
    name      = "writedown",
    precision = 11,
    scale     = 2
  )
  private BigDecimal writedown;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CitiAccountOffer object.
   */
  public CitiAccountOffer() { }


  /**
   * Creates a new CitiAccountOffer object.
   *
   * @param  citiAccount                 CitiAccount
   * @param  offer                       Long
   * @param  type                        String
   * @param  description                 String
   * @param  loanAmount                  BigDecimal
   * @param  rate                        BigDecimal
   * @param  rateDifference              BigDecimal
   * @param  payment                     BigDecimal
   * @param  paymentDifference           BigDecimal
   * @param  monthlyIncome               BigDecimal
   * @param  monthlyIncomeDifference     BigDecimal
   * @param  newPimi                     BigDecimal
   * @param  loanExpenditure             BigDecimal
   * @param  channelOriginalExpenditure  BigDecimal
   * @param  monthlyIncomeUpfront        BigDecimal
   * @param  buydown                     BigDecimal
   * @param  writedown                   BigDecimal
   * @param  totalCost                   BigDecimal
   * @param  postModPayment              BigDecimal
   * @param  nclSaveAmount               BigDecimal
   * @param  nclSavePercentage           BigDecimal
   * @param  plImpact                    BigDecimal
   * @param  offerDate                   Date
   * @param  expireDate                  Date
   * @param  prodcode                    String
   * @param  offerindex                  Integer
   * @param  createDate                  Date
   * @param  lastUpdateDate              Date
   */
  public CitiAccountOffer(CitiAccount citiAccount, Long offer, String type,
    String description, BigDecimal loanAmount, BigDecimal rate,
    BigDecimal rateDifference, BigDecimal payment,
    BigDecimal paymentDifference, BigDecimal monthlyIncome,
    BigDecimal monthlyIncomeDifference, BigDecimal newPimi,
    BigDecimal loanExpenditure, BigDecimal channelOriginalExpenditure,
    BigDecimal monthlyIncomeUpfront, BigDecimal buydown,
    BigDecimal writedown, BigDecimal totalCost, BigDecimal postModPayment,
    BigDecimal nclSaveAmount, BigDecimal nclSavePercentage,
    BigDecimal plImpact, Date offerDate, Date expireDate, String prodcode,
    Integer offerindex, Date createDate, Date lastUpdateDate) {
    this.citiAccount                = citiAccount;
    this.offer                      = offer;
    this.type                       = type;
    this.description                = description;
    this.loanAmount                 = loanAmount;
    this.rate                       = rate;
    this.rateDifference             = rateDifference;
    this.payment                    = payment;
    this.paymentDifference          = paymentDifference;
    this.monthlyIncome              = monthlyIncome;
    this.monthlyIncomeDifference    = monthlyIncomeDifference;
    this.newPimi                    = newPimi;
    this.loanExpenditure            = loanExpenditure;
    this.channelOriginalExpenditure = channelOriginalExpenditure;
    this.monthlyIncomeUpfront       = monthlyIncomeUpfront;
    this.buydown                    = buydown;
    this.writedown                  = writedown;
    this.totalCost                  = totalCost;
    this.postModPayment             = postModPayment;
    this.nclSaveAmount              = nclSaveAmount;
    this.nclSavePercentage          = nclSavePercentage;
    this.plImpact                   = plImpact;
    this.offerDate                  = offerDate;
    this.expireDate                 = expireDate;
    this.prodcode                   = prodcode;
    this.offerIndex                 = offerindex;
    this.createDate                 = createDate;
    this.lastUpdateDate             = lastUpdateDate;
  } // end ctor CitiAccountOffer

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for buydown.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBuydown() {
    return buydown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel original expenditure.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChannelOriginalExpenditure() {
    return channelOriginalExpenditure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi account.
   *
   * @return  CitiAccount
   */
  public CitiAccount getCitiAccount() {
    return citiAccount;
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
   * getter method for expire date.
   *
   * @return  Date
   */
  public Date getExpireDate() {
    return expireDate;
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
   * getter method for loan amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLoanAmount() {
    return loanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan expenditure.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLoanExpenditure() {
    return loanExpenditure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyIncome() {
    return monthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly income difference.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyIncomeDifference() {
    return monthlyIncomeDifference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly income upfront.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyIncomeUpfront() {
    return monthlyIncomeUpfront;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl save amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclSaveAmount() {
    return nclSaveAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl save percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclSavePercentage() {
    return nclSavePercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new pimi.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNewPimi() {
    return newPimi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for offer.
   *
   * @return  Long
   */
  public Long getOffer() {
    return offer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for offer date.
   *
   * @return  Date
   */
  public Date getOfferDate() {
    return offerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for offer index.
   *
   * @return  Integer
   */
  public Integer getOfferIndex() {
    return offerIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment difference.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPaymentDifference() {
    return paymentDifference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pl impact.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPlImpact() {
    return plImpact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for post mod payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPostModPayment() {
    return postModPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prodcode.
   *
   * @return  String
   */
  public String getProdcode() {
    return prodcode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRate() {
    return rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rate difference.
   *
   * @return  BigDecimal
   */
  public BigDecimal getRateDifference() {
    return rateDifference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total cost.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalCost() {
    return totalCost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for writedown.
   *
   * @return  BigDecimal
   */
  public BigDecimal getWritedown() {
    return writedown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for buydown.
   *
   * @param  buydown  BigDecimal
   */
  public void setBuydown(BigDecimal buydown) {
    this.buydown = buydown;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel original expenditure.
   *
   * @param  channelOriginalExpenditure  BigDecimal
   */
  public void setChannelOriginalExpenditure(BigDecimal channelOriginalExpenditure) {
    this.channelOriginalExpenditure = channelOriginalExpenditure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for citi account.
   *
   * @param  citiAccount  CitiAccount
   */
  public void setCitiAccount(CitiAccount citiAccount) {
    this.citiAccount = citiAccount;
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
   * setter method for expire date.
   *
   * @param  expireDate  Date
   */
  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
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
   * setter method for loan amount.
   *
   * @param  loanAmount  BigDecimal
   */
  public void setLoanAmount(BigDecimal loanAmount) {
    this.loanAmount = loanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan expenditure.
   *
   * @param  loanExpenditure  BigDecimal
   */
  public void setLoanExpenditure(BigDecimal loanExpenditure) {
    this.loanExpenditure = loanExpenditure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly income.
   *
   * @param  monthlyIncome  BigDecimal
   */
  public void setMonthlyIncome(BigDecimal monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly income difference.
   *
   * @param  monthlyIncomeDifference  BigDecimal
   */
  public void setMonthlyIncomeDifference(BigDecimal monthlyIncomeDifference) {
    this.monthlyIncomeDifference = monthlyIncomeDifference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly income upfront.
   *
   * @param  monthlyIncomeUpfront  BigDecimal
   */
  public void setMonthlyIncomeUpfront(BigDecimal monthlyIncomeUpfront) {
    this.monthlyIncomeUpfront = monthlyIncomeUpfront;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl save amount.
   *
   * @param  nclSaveAmount  BigDecimal
   */
  public void setNclSaveAmount(BigDecimal nclSaveAmount) {
    this.nclSaveAmount = nclSaveAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl save percentage.
   *
   * @param  nclSavePercentage  BigDecimal
   */
  public void setNclSavePercentage(BigDecimal nclSavePercentage) {
    this.nclSavePercentage = nclSavePercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new pimi.
   *
   * @param  newPimi  BigDecimal
   */
  public void setNewPimi(BigDecimal newPimi) {
    this.newPimi = newPimi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for offer.
   *
   * @param  offer  Long
   */
  public void setOffer(Long offer) {
    this.offer = offer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for offer date.
   *
   * @param  offerDate  Date
   */
  public void setOfferDate(Date offerDate) {
    this.offerDate = offerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for offer index.
   *
   * @param  offerIndex  Integer
   */
  public void setOfferIndex(Integer offerIndex) {
    this.offerIndex = offerIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  BigDecimal
   */
  public void setPayment(BigDecimal payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment difference.
   *
   * @param  paymentDifference  BigDecimal
   */
  public void setPaymentDifference(BigDecimal paymentDifference) {
    this.paymentDifference = paymentDifference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pl impact.
   *
   * @param  plImpact  BigDecimal
   */
  public void setPlImpact(BigDecimal plImpact) {
    this.plImpact = plImpact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for post mod payment.
   *
   * @param  postModPayment  BigDecimal
   */
  public void setPostModPayment(BigDecimal postModPayment) {
    this.postModPayment = postModPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prodcode.
   *
   * @param  prodcode  String
   */
  public void setProdcode(String prodcode) {
    this.prodcode = prodcode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rate.
   *
   * @param  rate  BigDecimal
   */
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rate difference.
   *
   * @param  rateDifference  BigDecimal
   */
  public void setRateDifference(BigDecimal rateDifference) {
    this.rateDifference = rateDifference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total cost.
   *
   * @param  totalCost  BigDecimal
   */
  public void setTotalCost(BigDecimal totalCost) {
    this.totalCost = totalCost;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for writedown.
   *
   * @param  writedown  BigDecimal
   */
  public void setWritedown(BigDecimal writedown) {
    this.writedown = writedown;
  }
} // end class CitiAccountOffer
