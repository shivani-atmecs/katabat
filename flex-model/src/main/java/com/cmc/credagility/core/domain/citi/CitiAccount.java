package com.cmc.credagility.core.domain.citi;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.contact.ContactableBaseObject;


/**
 * This class is used to store CitiAccount information for Citi.
 *
 * @author   <a href="mailto:kattasrinivas@etisbew.com">Srinivasa Katta</a>,Modified by Karthikeyan Palanivelu
 * @version  10/14/2014 16:02
 */
@Entity
@Table(name = "CitiAccount")
public class CitiAccount extends ContactableBaseObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5579087971478503377L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations CitiAccount CitiAccountOffer : */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.EAGER,
    mappedBy = "citiAccount"
  )
  protected Set<CitiAccountOffer> accountOffers = new LinkedHashSet<CitiAccountOffer>();


  // npelleti, 07/30, USBank, Removed unique constraint
  /** citi account id PK. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         citiAccountId;

  /** accountNum. */
  // Fields
  @JoinColumn(
    insertable = true,
    updatable  = false
  )
  @OneToOne(mappedBy = "citiAccount")
  private Account account;
  @Column(
    name   = "cesCode1",
    length = 5
  )
  private String  cesCode1;
  @Column(
    name   = "cesCode10",
    length = 5
  )
  private String  cesCode10;
  @Column(
    name   = "cesCode11",
    length = 5
  )
  private String  cesCode11;
  @Column(
    name   = "cesCode12",
    length = 5
  )
  private String  cesCode12;
  @Column(
    name   = "cesCode13",
    length = 5
  )
  private String  cesCode13;
  @Column(
    name   = "cesCode14",
    length = 5
  )
  private String  cesCode14;
  @Column(
    name   = "cesCode15",
    length = 5
  )
  private String  cesCode15;
  @Column(
    name   = "cesCode16",
    length = 5
  )
  private String  cesCode16;
  @Column(
    name   = "cesCode17",
    length = 5
  )
  private String  cesCode17;
  @Column(
    name   = "cesCode18",
    length = 5
  )
  private String  cesCode18;
  @Column(
    name   = "cesCode19",
    length = 5
  )
  private String  cesCode19;
  @Column(
    name   = "cesCode2",
    length = 5
  )
  private String  cesCode2;
  @Column(
    name   = "cesCode20",
    length = 5
  )
  private String  cesCode20;
  @Column(
    name   = "cesCode3",
    length = 5
  )
  private String  cesCode3;
  @Column(
    name   = "cesCode4",
    length = 5
  )
  private String  cesCode4;
  @Column(
    name   = "cesCode5",
    length = 5
  )
  private String  cesCode5;
  @Column(
    name   = "cesCode6",
    length = 5
  )
  private String  cesCode6;
  @Column(
    name   = "cesCode7",
    length = 5
  )
  private String  cesCode7;
  @Column(
    name   = "cesCode8",
    length = 5
  )
  private String  cesCode8;
  @Column(
    name   = "cesCode9",
    length = 5
  )
  private String  cesCode9;

  @Column(
    name      = "debFees",
    precision = 19,
    scale     = 2
  )
  private BigDecimal debFees;

  @Column(
    name      = "deferredAmount",
    precision = 19,
    scale     = 2
  )
  private BigDecimal deferredAmount;
  @Column(
    name   = "isnHardship",
    length = 11
  )
  private String     isnHardship;
  @Column(
    name   = "isnMod",
    length = 11
  )
  private String     isnMod;
  @Column(
    name   = "isnRefi",
    length = 11
  )
  private String     isnRefi;
  @Column(
    name      = "ncl25",
    precision = 19,
    scale     = 2
  )
  private BigDecimal ncl25;
  @Column(
    name      = "ncl50",
    precision = 19,
    scale     = 2
  )
  private BigDecimal ncl50;
  @Column(
    name      = "ncl50distress",
    precision = 19,
    scale     = 2
  )
  private BigDecimal ncl50distress;
  @Column(
    name      = "ncl75",
    precision = 19,
    scale     = 2
  )
  private BigDecimal ncl75;
  @Column(
    name      = "nclMod25",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclMod25;
  @Column(
    name   = "nclMod25label",
    length = 25
  )
  private String     nclMod25label;
  @Column(
    name      = "nclMod50",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclMod50;
  @Column(
    name      = "nclMod50distress",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclMod50distress;
  @Column(
    name   = "nclMod50distressLabel",
    length = 25
  )
  private String     nclMod50distressLabel;
  @Column(
    name   = "nclMod50label",
    length = 25
  )
  private String     nclMod50label;
  @Column(
    name      = "nclMod75",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclMod75;
  @Column(
    name   = "nclMod75label",
    length = 25
  )
  private String     nclMod75label;
  @Column(
    name      = "nclRefi25",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclRefi25;
  @Column(
    name   = "nclRefi25label",
    length = 25
  )
  private String     nclRefi25label;
  @Column(
    name      = "nclRefi50",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclRefi50;
  @Column(
    name      = "nclRefi50distress",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclRefi50distress;
  @Column(
    name   = "nclRefi50distressLabel",
    length = 25
  )
  private String     nclRefi50distressLabel;
  @Column(
    name   = "nclRefi50label",
    length = 25
  )
  private String     nclRefi50label;
  @Column(
    name      = "nclRefi75",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nclRefi75;
  @Column(
    name   = "nclRefi75label",
    length = 25
  )
  private String     nclRefi75label;

  @Column(name = "nextResetDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date nextResetDate;

  @Column(
    name      = "nextResetRate",
    precision = 19,
    scale     = 2
  )
  private BigDecimal nextResetRate;
  @Column(
    name   = "numOfUnits",
    length = 3
  )
  private Long       numOfUnits;
  @Column(
    name   = "occupancy",
    length = 5
  )
  private String     occupancy;
  @Column(
    name      = "originalFrontRatio",
    precision = 10,
    scale     = 3
  )
  private BigDecimal originalFrontRatio;
  @Column(
    name   = "originalIncomeType",
    length = 11
  )
  private String     originalIncomeType;

  @Column(
    name      = "originalMonthlyIncome",
    precision = 19,
    scale     = 2
  )
  private BigDecimal originalMonthlyIncome;

  @Column(
    name      = "otherDue",
    precision = 19,
    scale     = 2
  )
  private BigDecimal otherDue;

  @Column(
    name      = "piDue",
    precision = 19,
    scale     = 2
  )
  private BigDecimal piDue;
  @Column(
    name   = "prodArmIo",
    length = 10
  )
  private String     prodArmIo;
  @Column(
    name   = "propertyType",
    length = 5
  )
  private String     propertyType;
  @Column(
    name   = "remainingTerm",
    length = 3
  )
  private Long       remainingTerm;
  @Column(
    name   = "riskSegment",
    length = 15
  )
  private String     riskSegment;
  @Column(
    name      = "taxesInsurance",
    precision = 19,
    scale     = 2
  )
  private BigDecimal taxesInsurance;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CitiAccount object.
   */
  public CitiAccount() { }

  /**
   * Creates a new CitiAccount object.
   *
   * @param  account                 Account
   * @param  cesCode1                String
   * @param  cesCode2                String
   * @param  cesCode3                String
   * @param  cesCode4                String
   * @param  cesCode5                String
   * @param  cesCode6                String
   * @param  cesCode7                String
   * @param  cesCode8                String
   * @param  cesCode9                String
   * @param  cesCode10               String
   * @param  cesCode11               String
   * @param  cesCode12               String
   * @param  cesCode13               String
   * @param  cesCode14               String
   * @param  cesCode15               String
   * @param  cesCode16               String
   * @param  cesCode17               String
   * @param  cesCode18               String
   * @param  cesCode19               String
   * @param  cesCode20               String
   * @param  numOfUnits              Long
   * @param  propertyType            String
   * @param  occupancy               String
   * @param  remainingTerm           Long
   * @param  riskSegment             String
   * @param  ncl25                   BigDecimal
   * @param  ncl50                   BigDecimal
   * @param  ncl75                   BigDecimal
   * @param  ncl50distress           BigDecimal
   * @param  nclRefi25               BigDecimal
   * @param  nclRefi50               BigDecimal
   * @param  nclRefi75               BigDecimal
   * @param  nclRefi50distress       BigDecimal
   * @param  nclMod25                BigDecimal
   * @param  nclMod50                BigDecimal
   * @param  nclMod75                BigDecimal
   * @param  nclMod50distress        BigDecimal
   * @param  nclRefi25label          String
   * @param  nclRefi50label          String
   * @param  nclRefi75label          String
   * @param  nclRefi50distressLabel  String
   * @param  nclMod25label           String
   * @param  nclMod50label           String
   * @param  nclMod75label           String
   * @param  nclMod50distressLabel   String
   * @param  isnHardship             String
   * @param  isnRefi                 String
   * @param  isnMod                  String
   * @param  originalIncomeType      String
   * @param  prodArmIo               String
   * @param  originalFrontRatio      BigDecimal
   * @param  taxesInsurance          BigDecimal
   * @param  createDate              Date
   * @param  lastUpdateDate          Date
   */
  public CitiAccount(Account account, String cesCode1, String cesCode2,
    String cesCode3, String cesCode4, String cesCode5, String cesCode6,
    String cesCode7, String cesCode8, String cesCode9, String cesCode10,
    String cesCode11, String cesCode12, String cesCode13, String cesCode14,
    String cesCode15, String cesCode16, String cesCode17, String cesCode18,
    String cesCode19, String cesCode20, Long numOfUnits, String propertyType,
    String occupancy, Long remainingTerm, String riskSegment,
    BigDecimal ncl25, BigDecimal ncl50, BigDecimal ncl75,
    BigDecimal ncl50distress, BigDecimal nclRefi25, BigDecimal nclRefi50,
    BigDecimal nclRefi75, BigDecimal nclRefi50distress, BigDecimal nclMod25,
    BigDecimal nclMod50, BigDecimal nclMod75, BigDecimal nclMod50distress,
    String nclRefi25label, String nclRefi50label, String nclRefi75label,
    String nclRefi50distressLabel, String nclMod25label,
    String nclMod50label, String nclMod75label, String nclMod50distressLabel,
    String isnHardship, String isnRefi, String isnMod,
    String originalIncomeType, String prodArmIo,
    BigDecimal originalFrontRatio, BigDecimal taxesInsurance,
    Date createDate, Date lastUpdateDate) {
    this.account           = account;
    this.cesCode1          = cesCode1;
    this.cesCode2          = cesCode2;
    this.cesCode3          = cesCode3;
    this.cesCode4          = cesCode4;
    this.cesCode5          = cesCode5;
    this.cesCode6          = cesCode6;
    this.cesCode7          = cesCode7;
    this.cesCode8          = cesCode8;
    this.cesCode9          = cesCode9;
    this.cesCode10         = cesCode10;
    this.cesCode11         = cesCode11;
    this.cesCode12         = cesCode12;
    this.cesCode13         = cesCode13;
    this.cesCode14         = cesCode14;
    this.cesCode15         = cesCode15;
    this.cesCode16         = cesCode16;
    this.cesCode17         = cesCode17;
    this.cesCode18         = cesCode18;
    this.cesCode19         = cesCode19;
    this.cesCode20         = cesCode20;
    this.numOfUnits        = numOfUnits;
    this.propertyType      = propertyType;
    this.occupancy         = occupancy;
    this.remainingTerm     = remainingTerm;
    this.riskSegment       = riskSegment;
    this.ncl25             = ncl25;
    this.ncl50             = ncl50;
    this.ncl75             = ncl75;
    this.ncl50distress     = ncl50distress;
    this.nclRefi25         = nclRefi25;
    this.nclRefi50         = nclRefi50;
    this.nclRefi75         = nclRefi75;
    this.nclRefi50distress = nclRefi50distress;
    this.nclMod25          = nclMod25;
    this.nclMod50          = nclMod50;
    this.nclMod75          = nclMod75;
    this.nclMod50distress  = nclMod50distress;

    this.nclRefi25label         = nclRefi25label;
    this.nclRefi50label         = nclRefi50label;
    this.nclRefi75label         = nclRefi75label;
    this.nclRefi50distressLabel = nclRefi50distressLabel;
    this.nclMod25label          = nclMod25label;
    this.nclMod50label          = nclMod50label;
    this.nclMod75label          = nclMod75label;
    this.nclMod50distressLabel  = nclMod50distressLabel;
    this.isnHardship            = isnHardship;
    this.isnRefi                = isnRefi;
    this.isnMod                 = isnMod;
    this.originalIncomeType     = originalIncomeType;
    this.prodArmIo              = prodArmIo;
    this.originalFrontRatio     = originalFrontRatio;
    this.taxesInsurance         = taxesInsurance;
    this.createDate             = createDate;
    this.lastUpdateDate         = lastUpdateDate;
  } // end ctor CitiAccount

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Adds a Account Offer for the citi account.
   *
   * @param   citiaccountoffer  Account Offer
   *
   * @return  adds a Account Offer for the citi account.
   */
  public boolean addAccountOffer(CitiAccountOffer citiaccountoffer) {
    citiaccountoffer.setCitiAccount(this);

    return getAccountOffers().add(citiaccountoffer);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account offers.
   *
   * @return  Set
   */
  public Set<CitiAccountOffer> getAccountOffers() {
    return accountOffers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find the first offer (within this citiaccount) that matches given criteria. This method is used in account import
   * batch job. NULL will match to NULL.
   *
   * @param   citiAccountId  DOCUMENT ME!
   * @param   offerIndex     DOCUMENT ME!
   *
   * @return  find the first offer (within this citiaccount) that matches given criteria.
   */
  public CitiAccountOffer getAccountOffers(Long citiAccountId,
    Integer offerIndex) {
    if ((accountOffers == null) || (accountOffers.size() == 0)) {
      return null;
    }

    for (CitiAccountOffer cao : accountOffers) {
      if (((citiAccountId == null) && (cao.getCitiAccount().getCitiAccountId() != null))
            || ((citiAccountId != null) && (cao.getCitiAccount().getCitiAccountId() == null))
            || ((citiAccountId != null) && !citiAccountId.equals(cao.getCitiAccount().getCitiAccountId()))) {
        continue; // citiAccountId not match
      } else if (((offerIndex == null) && (cao.getOfferIndex() != null))
            || ((offerIndex != null) && (cao.getOfferIndex() == null))
            || ((offerIndex != null) && !offerIndex.equals(cao.getOfferIndex()))) {
        continue; // offerIndex not match
      }

      return cao;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account offers count.
   *
   * @return  Integer
   */
  public Integer getAccountOffersCount() {
    if (accountOffers == null) {
      return 0;
    }

    return accountOffers.size();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code1.
   *
   * @return  String
   */
  public String getCesCode1() {
    return cesCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code10.
   *
   * @return  String
   */
  public String getCesCode10() {
    return cesCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code11.
   *
   * @return  String
   */
  public String getCesCode11() {
    return cesCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code12.
   *
   * @return  String
   */
  public String getCesCode12() {
    return cesCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code13.
   *
   * @return  String
   */
  public String getCesCode13() {
    return cesCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code14.
   *
   * @return  String
   */
  public String getCesCode14() {
    return cesCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code15.
   *
   * @return  String
   */
  public String getCesCode15() {
    return cesCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code16.
   *
   * @return  String
   */
  public String getCesCode16() {
    return cesCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code17.
   *
   * @return  String
   */
  public String getCesCode17() {
    return cesCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code18.
   *
   * @return  String
   */
  public String getCesCode18() {
    return cesCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code19.
   *
   * @return  String
   */
  public String getCesCode19() {
    return cesCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code2.
   *
   * @return  String
   */
  public String getCesCode2() {
    return cesCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code20.
   *
   * @return  String
   */
  public String getCesCode20() {
    return cesCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code3.
   *
   * @return  String
   */
  public String getCesCode3() {
    return cesCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code4.
   *
   * @return  String
   */
  public String getCesCode4() {
    return cesCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code5.
   *
   * @return  String
   */
  public String getCesCode5() {
    return cesCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code6.
   *
   * @return  String
   */
  public String getCesCode6() {
    return cesCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code7.
   *
   * @return  String
   */
  public String getCesCode7() {
    return cesCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code8.
   *
   * @return  String
   */
  public String getCesCode8() {
    return cesCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ces code9.
   *
   * @return  String
   */
  public String getCesCode9() {
    return cesCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for citi account id.
   *
   * @return  Long
   */
  public Long getCitiAccountId() {
    return citiAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deb fees.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDebFees() {
    return debFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deferred amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDeferredAmount() {
    return deferredAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for isn hardship.
   *
   * @return  String
   */
  public String getIsnHardship() {
    return isnHardship;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for isn mod.
   *
   * @return  String
   */
  public String getIsnMod() {
    return isnMod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for isn refi.
   *
   * @return  String
   */
  public String getIsnRefi() {
    return isnRefi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl25.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNcl25() {
    return ncl25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl50.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNcl50() {
    return ncl50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl50distress.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNcl50distress() {
    return ncl50distress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl75.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNcl75() {
    return ncl75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod25.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclMod25() {
    return nclMod25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod25label.
   *
   * @return  String
   */
  public String getNclMod25label() {
    return nclMod25label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod50.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclMod50() {
    return nclMod50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod50distress.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclMod50distress() {
    return nclMod50distress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod50distress label.
   *
   * @return  String
   */
  public String getNclMod50distressLabel() {
    return nclMod50distressLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod50label.
   *
   * @return  String
   */
  public String getNclMod50label() {
    return nclMod50label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod75.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclMod75() {
    return nclMod75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl mod75label.
   *
   * @return  String
   */
  public String getNclMod75label() {
    return nclMod75label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi25.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclRefi25() {
    return nclRefi25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi25label.
   *
   * @return  String
   */
  public String getNclRefi25label() {
    return nclRefi25label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi50.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclRefi50() {
    return nclRefi50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi50distress.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclRefi50distress() {
    return nclRefi50distress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi50distress label.
   *
   * @return  String
   */
  public String getNclRefi50distressLabel() {
    return nclRefi50distressLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi50label.
   *
   * @return  String
   */
  public String getNclRefi50label() {
    return nclRefi50label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi75.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNclRefi75() {
    return nclRefi75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncl refi75label.
   *
   * @return  String
   */
  public String getNclRefi75label() {
    return nclRefi75label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next reset date.
   *
   * @return  Date
   */
  public Date getNextResetDate() {
    return nextResetDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next reset rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNextResetRate() {
    return nextResetRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for num of units.
   *
   * @return  Long
   */
  public Long getNumOfUnits() {
    return numOfUnits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for occupancy.
   *
   * @return  String
   */
  public String getOccupancy() {
    return occupancy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original front ratio.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOriginalFrontRatio() {
    return originalFrontRatio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original income type.
   *
   * @return  String
   */
  public String getOriginalIncomeType() {
    return originalIncomeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original monthly income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOriginalMonthlyIncome() {
    return originalMonthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOtherDue() {
    return otherDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pi due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPiDue() {
    return piDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prod arm io.
   *
   * @return  String
   */
  public String getProdArmIo() {
    return prodArmIo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for property type.
   *
   * @return  String
   */
  public String getPropertyType() {
    return propertyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remaining term.
   *
   * @return  Long
   */
  public Long getRemainingTerm() {
    return remainingTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for risk segment.
   *
   * @return  String
   */
  public String getRiskSegment() {
    return riskSegment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for taxes insurance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTaxesInsurance() {
    return taxesInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account offers.
   *
   * @param  accountOffers  Set
   */
  public void setAccountOffers(Set<CitiAccountOffer> accountOffers) {
    this.accountOffers = accountOffers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code1.
   *
   * @param  cesCode1  String
   */
  public void setCesCode1(String cesCode1) {
    this.cesCode1 = cesCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code10.
   *
   * @param  cesCode10  String
   */
  public void setCesCode10(String cesCode10) {
    this.cesCode10 = cesCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code11.
   *
   * @param  cesCode11  String
   */
  public void setCesCode11(String cesCode11) {
    this.cesCode11 = cesCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code12.
   *
   * @param  cesCode12  String
   */
  public void setCesCode12(String cesCode12) {
    this.cesCode12 = cesCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code13.
   *
   * @param  cesCode13  String
   */
  public void setCesCode13(String cesCode13) {
    this.cesCode13 = cesCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code14.
   *
   * @param  cesCode14  String
   */
  public void setCesCode14(String cesCode14) {
    this.cesCode14 = cesCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code15.
   *
   * @param  cesCode15  String
   */
  public void setCesCode15(String cesCode15) {
    this.cesCode15 = cesCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code16.
   *
   * @param  cesCode16  String
   */
  public void setCesCode16(String cesCode16) {
    this.cesCode16 = cesCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code17.
   *
   * @param  cesCode17  String
   */
  public void setCesCode17(String cesCode17) {
    this.cesCode17 = cesCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code18.
   *
   * @param  cesCode18  String
   */
  public void setCesCode18(String cesCode18) {
    this.cesCode18 = cesCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code19.
   *
   * @param  cesCode19  String
   */
  public void setCesCode19(String cesCode19) {
    this.cesCode19 = cesCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code2.
   *
   * @param  cesCode2  String
   */
  public void setCesCode2(String cesCode2) {
    this.cesCode2 = cesCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code20.
   *
   * @param  cesCode20  String
   */
  public void setCesCode20(String cesCode20) {
    this.cesCode20 = cesCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code3.
   *
   * @param  cesCode3  String
   */
  public void setCesCode3(String cesCode3) {
    this.cesCode3 = cesCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code4.
   *
   * @param  cesCode4  String
   */
  public void setCesCode4(String cesCode4) {
    this.cesCode4 = cesCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code5.
   *
   * @param  cesCode5  String
   */
  public void setCesCode5(String cesCode5) {
    this.cesCode5 = cesCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code6.
   *
   * @param  cesCode6  String
   */
  public void setCesCode6(String cesCode6) {
    this.cesCode6 = cesCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code7.
   *
   * @param  cesCode7  String
   */
  public void setCesCode7(String cesCode7) {
    this.cesCode7 = cesCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code8.
   *
   * @param  cesCode8  String
   */
  public void setCesCode8(String cesCode8) {
    this.cesCode8 = cesCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ces code9.
   *
   * @param  cesCode9  String
   */
  public void setCesCode9(String cesCode9) {
    this.cesCode9 = cesCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for citi account id.
   *
   * @param  citiAccountId  Long
   */
  public void setCitiAccountId(Long citiAccountId) {
    this.citiAccountId = citiAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deb fees.
   *
   * @param  debFees  BigDecimal
   */
  public void setDebFees(BigDecimal debFees) {
    this.debFees = debFees;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deferred amount.
   *
   * @param  deferredAmount  BigDecimal
   */
  public void setDeferredAmount(BigDecimal deferredAmount) {
    this.deferredAmount = deferredAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for isn hardship.
   *
   * @param  isnHardship  String
   */
  public void setIsnHardship(String isnHardship) {
    this.isnHardship = isnHardship;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for isn mod.
   *
   * @param  isnMod  String
   */
  public void setIsnMod(String isnMod) {
    this.isnMod = isnMod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for isn refi.
   *
   * @param  isnRefi  String
   */
  public void setIsnRefi(String isnRefi) {
    this.isnRefi = isnRefi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl25.
   *
   * @param  ncl25  BigDecimal
   */
  public void setNcl25(BigDecimal ncl25) {
    this.ncl25 = ncl25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl50.
   *
   * @param  ncl50  BigDecimal
   */
  public void setNcl50(BigDecimal ncl50) {
    this.ncl50 = ncl50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl50distress.
   *
   * @param  ncl50distress  BigDecimal
   */
  public void setNcl50distress(BigDecimal ncl50distress) {
    this.ncl50distress = ncl50distress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl75.
   *
   * @param  ncl75  BigDecimal
   */
  public void setNcl75(BigDecimal ncl75) {
    this.ncl75 = ncl75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod25.
   *
   * @param  nclMod25  BigDecimal
   */
  public void setNclMod25(BigDecimal nclMod25) {
    this.nclMod25 = nclMod25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod25label.
   *
   * @param  nclMod25label  String
   */
  public void setNclMod25label(String nclMod25label) {
    this.nclMod25label = nclMod25label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod50.
   *
   * @param  nclMod50  BigDecimal
   */
  public void setNclMod50(BigDecimal nclMod50) {
    this.nclMod50 = nclMod50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod50distress.
   *
   * @param  nclMod50distress  BigDecimal
   */
  public void setNclMod50distress(BigDecimal nclMod50distress) {
    this.nclMod50distress = nclMod50distress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod50distress label.
   *
   * @param  nclMod50distressLabel  String
   */
  public void setNclMod50distressLabel(String nclMod50distressLabel) {
    this.nclMod50distressLabel = nclMod50distressLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod50label.
   *
   * @param  nclMod50label  String
   */
  public void setNclMod50label(String nclMod50label) {
    this.nclMod50label = nclMod50label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod75.
   *
   * @param  nclMod75  BigDecimal
   */
  public void setNclMod75(BigDecimal nclMod75) {
    this.nclMod75 = nclMod75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl mod75label.
   *
   * @param  nclMod75label  String
   */
  public void setNclMod75label(String nclMod75label) {
    this.nclMod75label = nclMod75label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi25.
   *
   * @param  nclRefi25  BigDecimal
   */
  public void setNclRefi25(BigDecimal nclRefi25) {
    this.nclRefi25 = nclRefi25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi25label.
   *
   * @param  nclRefi25label  String
   */
  public void setNclRefi25label(String nclRefi25label) {
    this.nclRefi25label = nclRefi25label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi50.
   *
   * @param  nclRefi50  BigDecimal
   */
  public void setNclRefi50(BigDecimal nclRefi50) {
    this.nclRefi50 = nclRefi50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi50distress.
   *
   * @param  nclRefi50distress  BigDecimal
   */
  public void setNclRefi50distress(BigDecimal nclRefi50distress) {
    this.nclRefi50distress = nclRefi50distress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi50distress label.
   *
   * @param  nclRefi50distressLabel  String
   */
  public void setNclRefi50distressLabel(String nclRefi50distressLabel) {
    this.nclRefi50distressLabel = nclRefi50distressLabel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi50label.
   *
   * @param  nclRefi50label  String
   */
  public void setNclRefi50label(String nclRefi50label) {
    this.nclRefi50label = nclRefi50label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi75.
   *
   * @param  nclRefi75  BigDecimal
   */
  public void setNclRefi75(BigDecimal nclRefi75) {
    this.nclRefi75 = nclRefi75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncl refi75label.
   *
   * @param  nclRefi75label  String
   */
  public void setNclRefi75label(String nclRefi75label) {
    this.nclRefi75label = nclRefi75label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next reset date.
   *
   * @param  nextResetDate  Date
   */
  public void setNextResetDate(Date nextResetDate) {
    this.nextResetDate = nextResetDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next reset rate.
   *
   * @param  nextResetRate  BigDecimal
   */
  public void setNextResetRate(BigDecimal nextResetRate) {
    this.nextResetRate = nextResetRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for num of units.
   *
   * @param  numOfUnits  Long
   */
  public void setNumOfUnits(Long numOfUnits) {
    this.numOfUnits = numOfUnits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for occupancy.
   *
   * @param  occupancy  String
   */
  public void setOccupancy(String occupancy) {
    this.occupancy = occupancy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original front ratio.
   *
   * @param  originalFrontRatio  BigDecimal
   */
  public void setOriginalFrontRatio(BigDecimal originalFrontRatio) {
    this.originalFrontRatio = originalFrontRatio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original income type.
   *
   * @param  originalIncomeType  String
   */
  public void setOriginalIncomeType(String originalIncomeType) {
    this.originalIncomeType = originalIncomeType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original monthly income.
   *
   * @param  originalMonthlyIncome  BigDecimal
   */
  public void setOriginalMonthlyIncome(BigDecimal originalMonthlyIncome) {
    this.originalMonthlyIncome = originalMonthlyIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other due.
   *
   * @param  otherDue  BigDecimal
   */
  public void setOtherDue(BigDecimal otherDue) {
    this.otherDue = otherDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pi due.
   *
   * @param  piDue  BigDecimal
   */
  public void setPiDue(BigDecimal piDue) {
    this.piDue = piDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prod arm io.
   *
   * @param  prodArmIo  String
   */
  public void setProdArmIo(String prodArmIo) {
    this.prodArmIo = prodArmIo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for property type.
   *
   * @param  propertyType  String
   */
  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remaining term.
   *
   * @param  remainingTerm  Long
   */
  public void setRemainingTerm(Long remainingTerm) {
    this.remainingTerm = remainingTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for risk segment.
   *
   * @param  riskSegment  String
   */
  public void setRiskSegment(String riskSegment) {
    this.riskSegment = riskSegment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for taxes insurance.
   *
   * @param  taxesInsurance  BigDecimal
   */
  public void setTaxesInsurance(BigDecimal taxesInsurance) {
    this.taxesInsurance = taxesInsurance;
  }

} // end class CitiAccount
