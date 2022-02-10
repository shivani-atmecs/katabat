package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.slm.SlmSchoolStatus;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;
import org.springframework.util.StringUtils;


/**
 * This class is used to store AccountDetail information for Discover.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 15:11
 */
@Entity
@Table(
  name    = "AccountDetail",
  indexes = {
    @Index(
      name = "clientDefined35CharCode1Index",
      columnList = "clientDefined35CharCode1"
    ),
    @Index(
      name = "clientDefinedInteger10Index",
      columnList = "clientDefinedInteger10"
    ),
    @Index(
      name = "indx_clientDefinedString1",
      columnList = "clientDefinedString1"
    )
  }
)
public class AccountDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5579087971478503377L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account Detail id PK. */
  // npelleti 08/16 Drop Unique constraint.
  @Column(
    name     = "accountDetailId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountDetailId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "schoolIdentifier",
    unique   = false,
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SlmSchoolStatus slmSchoolStatus;

  /** accountNum. */
  // Fields
  @JoinColumn(updatable = false)
  @OneToOne(mappedBy = "accountDetail")
  private Account account;

  @Column(
    name             = "allowProgram",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean allowProgram;

  @Column(name = "cancelledPaymentDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date cancelledPaymentDate;

  @Column(
    name   = "clientDefined10CharCode1",
    length = 10
  )
  private String clientDefined10CharCode1;

  @Column(
    name   = "clientDefined10CharCode2",
    length = 10
  )
  private String clientDefined10CharCode2;

  @Column(
    name   = "clientDefined10CharCode3",
    length = 10
  )
  private String clientDefined10CharCode3;

  @Column(
    name   = "clientDefined15CharCode1",
    length = 15
  )
  private String clientDefined15CharCode1;

  @Column(
    name   = "clientDefined15CharCode2",
    length = 15
  )
  private String clientDefined15CharCode2;
  @Column(
    name   = "clientDefined15CharCode3",
    length = 15
  )
  private String clientDefined15CharCode3;
  @Column(
    name   = "clientDefined15CharCode4",
    length = 15
  )
  private String clientDefined15CharCode4;

  @Column(
    name   = "clientDefined1CharCode1",
    length = 1
  )
  private String clientDefined1CharCode1;
  @Column(
    name   = "clientDefined1CharCode2",
    length = 1
  )
  private String clientDefined1CharCode2;
  @Column(
    name   = "clientDefined1CharCode3",
    length = 1
  )
  private String clientDefined1CharCode3;

  @Column(
    name   = "clientDefined1CharCode4",
    length = 1
  )
  private String clientDefined1CharCode4;
  @Column(
    name   = "clientDefined1CharCode5",
    length = 1
  )
  private String clientDefined1CharCode5;
  @Column(
    name   = "clientDefined1CharCode6",
    length = 1
  )
  private String clientDefined1CharCode6;
  @Column(
    name   = "clientDefined1CharCode7",
    length = 1
  )
  private String clientDefined1CharCode7;

  // Place Holders for Future Use

  @Column(
    name   = "clientDefined1CharCode8",
    length = 1
  )
  private String clientDefined1CharCode8;
  @Column(
    name   = "clientDefined1CharCode9",
    length = 1
  )
  private String clientDefined1CharCode9;

  @Column(
    name   = "clientDefined20CharCode1",
    length = 20
  )
  private String clientDefined20CharCode1;

  @Column(
    name   = "clientDefined20CharCode2",
    length = 20
  )
  private String clientDefined20CharCode2;

  @Column(
    name   = "clientDefined20CharCode3",
    length = 20
  )
  private String clientDefined20CharCode3;

  @Column(
    name   = "clientDefined20CharCode4",
    length = 20
  )
  private String clientDefined20CharCode4;

  @Column(
    name   = "clientDefined25CharCode1",
    length = 25
  )
  private String clientDefined25CharCode1;

  @Column(
    name   = "clientDefined25CharCode2",
    length = 25
  )
  private String clientDefined25CharCode2;
  @Column(
    name   = "clientDefined25CharCode3",
    length = 25
  )
  private String clientDefined25CharCode3;

  @Column(
    name   = "clientDefined2CharCode1",
    length = 2
  )
  private String clientDefined2CharCode1;
  @Column(
    name   = "clientDefined2CharCode2",
    length = 2
  )
  private String clientDefined2CharCode2;

  @Column(
    name   = "clientDefined2CharCode3",
    length = 2
  )
  private String clientDefined2CharCode3;

  @Column(
    name   = "clientDefined2CharCode4",
    length = 2
  )
  private String clientDefined2CharCode4;

  @Column(
    name   = "clientDefined2CharCode5",
    length = 2
  )
  private String clientDefined2CharCode5;
  @Column(
    name   = "clientDefined32CharCode1",
    length = 32
  )
  private String clientDefined32CharCode1;

  @Column(
    name   = "clientDefined32CharCode2",
    length = 32
  )
  private String clientDefined32CharCode2;
  @Column(
    name   = "clientDefined32CharCode3",
    length = 32
  )
  private String clientDefined32CharCode3;

  @Column(
    name   = "clientDefined35CharCode1",
    length = 35
  )
  private String clientDefined35CharCode1;

  @Column(
    name   = "clientDefined35CharCode2",
    length = 35
  )
  private String clientDefined35CharCode2;

  @Column(
    name   = "clientDefined3CharCode1",
    length = 3
  )
  private String clientDefined3CharCode1;

  @Column(
    name   = "clientDefined3CharCode2",
    length = 3
  )
  private String clientDefined3CharCode2;
  @Column(
    name   = "clientDefined3CharCode3",
    length = 3
  )
  private String clientDefined3CharCode3;

  @Column(
    name   = "clientDefined3CharCode4",
    length = 3
  )
  private String clientDefined3CharCode4;

  @Column(
    name   = "clientDefined3CharCode5",
    length = 3
  )
  private String clientDefined3CharCode5;

  @Column(
    name   = "clientDefined45CharCode1",
    length = 45
  )
  private String clientDefined45CharCode1;

  @Column(
    name   = "clientDefined45CharCode2",
    length = 45
  )
  private String clientDefined45CharCode2;

  @Column(
    name   = "clientDefined45CharCode3",
    length = 45
  )
  private String clientDefined45CharCode3;

  @Column(
    name   = "clientDefined45CharCode4",
    length = 45
  )
  private String clientDefined45CharCode4;

  @Column(
    name   = "clientDefined4CharCode1",
    length = 4
  )
  private String clientDefined4CharCode1;

  @Column(
    name   = "clientDefined4CharCode2",
    length = 4
  )
  private String clientDefined4CharCode2;
  @Column(
    name   = "clientDefined4CharCode3",
    length = 4
  )
  private String clientDefined4CharCode3;
  @Column(
    name   = "clientDefined5CharCode1",
    length = 5
  )
  private String clientDefined5CharCode1;

  // npelleti 08/16/09 Set the length to 5 and moved the column.
  @Column(
    name   = "clientDefined5CharCode2",
    length = 5
  )
  private String clientDefined5CharCode2;

  @Column(
    name   = "clientDefined5CharCode3",
    length = 5
  )
  private String clientDefined5CharCode3;
  @Column(
    name   = "clientDefined5CharCode4",
    length = 5
  )
  private String clientDefined5CharCode4;

  @Column(
    name   = "clientDefined8CharCode1",
    length = 8
  )
  private String clientDefined8CharCode1;
  @Column(
    name   = "clientDefined8CharCode2",
    length = 8
  )
  private String clientDefined8CharCode2;
  @Column(
    name   = "clientDefined8CharCode3",
    length = 8
  )
  private String clientDefined8CharCode3;
  @Column(
    name   = "clientDefined8CharCode4",
    length = 8
  )
  private String clientDefined8CharCode4;

  @Column(
    name   = "clientDefined8CharCode5",
    length = 8
  )
  private String clientDefined8CharCode5;
  @Column(
    name   = "clientDefined8CharCode6",
    length = 8
  )
  private String clientDefined8CharCode6;

  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate1;

  @Column(name = "clientDefinedDate10")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate10;

  @Column(name = "clientDefinedDate11")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate11;
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate2;
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate3;
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate4;
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate5;
  @Column(name = "clientDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate6;
  @Column(name = "clientDefinedDate7")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate7;
  @Column(name = "clientDefinedDate8")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate8;

  @Column(name = "clientDefinedDate9")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate9;

  @Column(name = "clientDefinedDecimal1")
  private BigDecimal clientDefinedDecimal1;
  @Column(name = "clientDefinedDecimal10")
  private BigDecimal clientDefinedDecimal10;

  // Added by Etisbew on 08/19/2009 for DFS Account Import Job-Start
  @Column(name = "clientDefinedDecimal11")
  private BigDecimal clientDefinedDecimal11;
  @Column(name = "clientDefinedDecimal12")
  private BigDecimal clientDefinedDecimal12;
  @Column(name = "clientDefinedDecimal13")
  private BigDecimal clientDefinedDecimal13;
  @Column(name = "clientDefinedDecimal14")
  private BigDecimal clientDefinedDecimal14;
  @Column(name = "clientDefinedDecimal15")
  private BigDecimal clientDefinedDecimal15;
  @Column(name = "clientDefinedDecimal2")
  private BigDecimal clientDefinedDecimal2;
  @Column(name = "clientDefinedDecimal3")
  private BigDecimal clientDefinedDecimal3;
  @Column(name = "clientDefinedDecimal4")
  private BigDecimal clientDefinedDecimal4;
  @Column(
    name      = "clientDefinedDecimal5",
    precision = 20,
    scale     = 13
  )
  private BigDecimal clientDefinedDecimal5;
  @Column(
    name      = "clientDefinedDecimal6",
    precision = 20,
    scale     = 13
  )
  private BigDecimal clientDefinedDecimal6;
  @Column(name = "clientDefinedDecimal7")
  private BigDecimal clientDefinedDecimal7;
  @Column(name = "clientDefinedDecimal8")
  private BigDecimal clientDefinedDecimal8;

  @Column(name = "clientDefinedDecimal9")
  private BigDecimal clientDefinedDecimal9;

  @Column(
    name   = "clientDefinedEncryptedString",
    length = 256
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String clientDefinedEncryptedString;

  // Added by Etisbew on 08/19/2009 for DFS Account Import Job-Start
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag1;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag2;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag3;

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag4;
  // Constructors

  @Column(
    name   = "clientDefinedInteger1",
    length = 11
  )
  private Integer clientDefinedInteger1;
  @Column(
    name   = "clientDefinedInteger10",
    length = 11
  )
  private Integer clientDefinedInteger10;

  @Column(
    name   = "clientDefinedInteger11",
    length = 11
  )
  private Integer clientDefinedInteger11;

  @Column(
    name   = "clientDefinedInteger12",
    length = 11
  )
  private Integer clientDefinedInteger12;

  @Column(
    name   = "clientDefinedInteger13",
    length = 11
  )
  private Integer clientDefinedInteger13;

  @Column(
    name   = "clientDefinedInteger14",
    length = 11
  )
  private Integer clientDefinedInteger14;

  @Column(
    name   = "clientDefinedInteger15",
    length = 11
  )
  private Integer clientDefinedInteger15;

  @Column(
    name   = "clientDefinedInteger16",
    length = 11
  )
  private Integer clientDefinedInteger16;

  @Column(
    name   = "clientDefinedInteger17",
    length = 11
  )
  private Integer clientDefinedInteger17;
  @Column(
    name   = "clientDefinedInteger2",
    length = 11
  )
  private Integer clientDefinedInteger2;
  @Column(
    name   = "clientDefinedInteger3",
    length = 11
  )
  private Integer clientDefinedInteger3;
  @Column(
    name   = "clientDefinedInteger4",
    length = 11
  )
  private Integer clientDefinedInteger4;
  @Column(
    name   = "clientDefinedInteger5",
    length = 11
  )
  private Integer clientDefinedInteger5;
  @Column(
    name   = "clientDefinedInteger6",
    length = 11
  )
  private Integer clientDefinedInteger6;
  @Column(
    name   = "clientDefinedInteger7",
    length = 11
  )
  private Integer clientDefinedInteger7;
  @Column(
    name   = "clientDefinedInteger8",
    length = 11
  )
  private Integer clientDefinedInteger8;
  @Column(
    name   = "clientDefinedInteger9",
    length = 11
  )
  private Integer clientDefinedInteger9;

  @Column(name = "clientDefinedLong1")
  private Long clientDefinedLong1;

  @Column(name = "clientDefinedLong2")
  private Long clientDefinedLong2;

  @Column(name = "clientDefinedLong3")
  private Long clientDefinedLong3;

  @Column(name = "clientDefinedLong4")
  private Long clientDefinedLong4;

  @Column(
    name   = "clientDefinedString1",
    length = 100
  )
  private String clientDefinedString1;

  @Column(
    name   = "clientDefinedString10",
    length = 256
  )
  private String clientDefinedString10;

  @Column(
    name   = "clientDefinedString2",
    length = 100
  )
  private String clientDefinedString2;

  @Column(
    name   = "clientDefinedString3",
    length = 550
  )
  private String clientDefinedString3;

  @Column(
    name   = "clientDefinedString4",
    length = 256
  )
  private String clientDefinedString4;

  @Column(
    name   = "clientDefinedString5",
    length = 256
  )
  private String clientDefinedString5;

  @Column(
    name   = "clientDefinedString6",
    length = 256
  )
  private String clientDefinedString6;

  @Column(
    name   = "clientDefinedString7",
    length = 256
  )
  private String clientDefinedString7;

  @Column(
    name   = "clientDefinedString8",
    length = 256
  )
  private String clientDefinedString8;

  @Column(
    name   = "clientDefinedString9",
    length = 256
  )
  private String clientDefinedString9;

  @Column(name = "updatedPaymentAmountDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedPaymentAmountDate;

  @Column(name = "updatedPaymentDayDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedPaymentDayDate;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * default constructor.
   */
  public AccountDetail() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ----------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   *
   *          <p>property-ref = "accountDetail" "com.cmc.credagility.Account" insert = "true" cascade = "none"</p>
   */

  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ///////End for DFS///////////////////////////////
  // Property accessors
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getAccountDetailId() {
    return this.accountDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAccountId() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined20CharCode1.
   *
   * @return  the clientDefined20CharCode1
   */
  public String getAccountKey() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // acsPortfolio
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAcsPortfolio() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Gopal 08/23 changed the field from clientDefined25CharCode2 to
  // clientDefined45CharCode2 -- end

  // RUA- Return file export
  // Gopal -- 08/20 added for Action Codes and Reaction Codes
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getActioncode() {
    return clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowProgram() {
    return allowProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // alopBalance
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAlopBalance() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getApplicationStatus() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // bankNumber
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBankNumber() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // bestTimeToCall
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBestTimeToCall() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // bkScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getBkScore() {
    return clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // reason to Block Account
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBlockAndReasonCode() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBranch() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public String getBrokenPromiseFlag() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code3 to Boolean.
   *
   * @return  Boolean
   */
  public Boolean getClientDefined1CharCode3ToBoolean() {
    if (StringUtils.hasText(clientDefined1CharCode3)) {

      return (clientDefined1CharCode3.equalsIgnoreCase("Y") || clientDefined1CharCode3.equalsIgnoreCase("TRUE")) ?
          Boolean.TRUE : Boolean.FALSE;
    }

    return null;
  }
  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCancelledPaymentDate() {
    return cancelledPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // challengerMod3
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getChallengerMod3() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // challengerMod4
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getChallengerMod4() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // cicKey
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCicKey() {
    return clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // cimsBankNumber
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCimsBankNumber() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined10CharCode1.
   *
   * @return  the clientDefined10CharCode1
   *
   *          <p>not-null = "false" length = "10"</p>
   */
  public String getClientDefined10CharCode1() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined10CharCode2.
   *
   * @return  the clientDefined10CharCode2
   *
   *          <p>not-null = "false" length = "10"</p>
   */
  public String getClientDefined10CharCode2() {
    return clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined10CharCode3.
   *
   * @return  the clientDefined10CharCode3
   *
   *          <p>not-null = "false" length = "10"</p>
   */
  public String getClientDefined10CharCode3() {
    return clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode1.
   *
   * @return  the clientDefined15CharCode1
   *
   *          <p>not-null = "false" length = "15"</p>
   */
  public String getClientDefined15CharCode1() {
    return clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode2.
   *
   * @return  the clientDefined15CharCode2
   *
   *          <p>not-null = "false" length = "15"</p>
   */
  public String getClientDefined15CharCode2() {
    return clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode3.
   *
   * @return  the clientDefined15CharCode3
   *
   *          <p>not-null = "false" length = "15"</p>
   */
  public String getClientDefined15CharCode3() {
    return clientDefined15CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode4.
   *
   * @return  the clientDefined15CharCode4
   *
   *          <p>not-null = "false" length = "15"</p>
   */
  public String getClientDefined15CharCode4() {
    return clientDefined15CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode1.
   *
   * @return  the clientDefined1CharCode1
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode1() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode2.
   *
   * @return  the clientDefined1CharCode2
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode2() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode3.
   *
   * @return  the clientDefined1CharCode3
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode3() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode4.
   *
   * @return  the clientDefined1CharCode4
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode4() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode5.
   *
   * @return  the clientDefined1CharCode5
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode5() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode6.
   *
   * @return  the clientDefined1CharCode6
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode6() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode7.
   *
   * @return  the clientDefined1CharCode7
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode7() {
    return clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode8.
   *
   * @return  the clientDefined1CharCode8
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode8() {
    return clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined1CharCode9.
   *
   * @return  the clientDefined1CharCode9
   *
   *          <p>not-null = "false" length = "1"</p>
   */
  public String getClientDefined1CharCode9() {
    return clientDefined1CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined20CharCode1.
   *
   * @return  the clientDefined20CharCode1
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getClientDefined20CharCode1() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined20CharCode2.
   *
   * @return  the clientDefined20CharCode2
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getClientDefined20CharCode2() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined20CharCode3.
   *
   * @return  the clientDefined20CharCode3
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getClientDefined20CharCode3() {
    return clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefined20CharCode4() {
    return clientDefined20CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined25CharCode1.
   *
   * @return  the clientDefined25CharCode1
   *
   *          <p>not-null = "false" length = "25"</p>
   */
  public String getClientDefined25CharCode1() {
    return clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined25CharCode2.
   *
   * @return  the clientDefined25CharCode2
   *
   *          <p>not-null = "false" length = "25"</p>
   */
  public String getClientDefined25CharCode2() {
    return clientDefined25CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined25CharCode3.
   *
   * @return  the clientDefined25CharCode3
   *
   *          <p>not-null = "false" length = "25"</p>
   */
  public String getClientDefined25CharCode3() {
    return clientDefined25CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined2CharCode1.
   *
   * @return  the clientDefined2CharCode1
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getClientDefined2CharCode1() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined2CharCode2.
   *
   * @return  the clientDefined2CharCode2
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getClientDefined2CharCode2() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined2CharCode3.
   *
   * @return  the clientDefined2CharCode3
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getClientDefined2CharCode3() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined2CharCode4.
   *
   * @return  the clientDefined2CharCode4
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getClientDefined2CharCode4() {
    return clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined2CharCode5.
   *
   * @return  the clientDefined2CharCode5
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getClientDefined2CharCode5() {
    return clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined32CharCode1.
   *
   * @return  the clientDefined32CharCode1
   *
   *          <p>not-null = "false" length = "32"</p>
   */
  public String getClientDefined32CharCode1() {
    return clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined32CharCode2.
   *
   * @return  the clientDefined32CharCode2
   *
   *          <p>not-null = "false" length = "32"</p>
   */
  public String getClientDefined32CharCode2() {
    return clientDefined32CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined32CharCode3.
   *
   * @return  the clientDefined32CharCode3
   *
   *          <p>not-null = "false" length = "32"</p>
   */
  public String getClientDefined32CharCode3() {
    return clientDefined32CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined35CharCode1.
   *
   * @return  the clientDefined35CharCode1
   *
   *          <p>not-null = "false" length = "35"</p>
   */
  public String getClientDefined35CharCode1() {
    return clientDefined35CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined35CharCode2.
   *
   * @return  the clientDefined35CharCode2
   *
   *          <p>not-null = "false" length = "35"</p>
   */
  public String getClientDefined35CharCode2() {
    return clientDefined35CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined3CharCode1.
   *
   * @return  the clientDefined3CharCode1
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined3CharCode2.
   *
   * @return  the clientDefined3CharCode2
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getClientDefined3CharCode2() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined3CharCode3.
   *
   * @return  the clientDefined3CharCode3
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getClientDefined3CharCode3() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The ClientDefined3CharCode4.
   *
   * @return  the ClientDefined3CharCode4
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getClientDefined3CharCode4() {
    return clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The ClientDefined3CharCode5.
   *
   * @return  the ClientDefined3CharCode5
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getClientDefined3CharCode5() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined45CharCode1.
   *
   * @return  the clientDefined45CharCode1
   *
   *          <p>not-null = "false" length = "45"</p>
   */
  public String getClientDefined45CharCode1() {
    return clientDefined45CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined45CharCode2.
   *
   * @return  the clientDefined45CharCode2
   *
   *          <p>not-null = "false" length = "45"</p>
   */
  public String getClientDefined45CharCode2() {
    return clientDefined45CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined45CharCode3.
   *
   * @return  the clientDefined45CharCode3
   *
   *          <p>not-null = "false" length = "45"</p>
   */
  public String getClientDefined45CharCode3() {
    return clientDefined45CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined45CharCode4.
   *
   * @return  the clientDefined45CharCode4
   *
   *          <p>not-null = "false" length = "45"</p>
   */
  public String getClientDefined45CharCode4() {
    return clientDefined45CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined4CharCode1.
   *
   * @return  the clientDefined4CharCode1
   *
   *          <p>not-null = "false" length = "4"</p>
   */
  public String getClientDefined4CharCode1() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined4CharCode2.
   *
   * @return  the clientDefined4CharCode2
   *
   *          <p>not-null = "false" length = "4"</p>
   */
  public String getClientDefined4CharCode2() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined4CharCode3.
   *
   * @return  the clientDefined4CharCode3
   *
   *          <p>not-null = "false" length = "4"</p>
   */
  public String getClientDefined4CharCode3() {
    return clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined5CharCode1.
   *
   * @return  the clientDefined5CharCode1
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public String getClientDefined5CharCode1() {
    return clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined5CharCode2.
   *
   * @return  the clientDefined5CharCode2
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public String getClientDefined5CharCode2() {
    return clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined5CharCode3.
   *
   * @return  the clientDefined5CharCode3
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public String getClientDefined5CharCode3() {
    return clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined5CharCode4.
   *
   * @return  the clientDefined5CharCode4
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public String getClientDefined5CharCode4() {
    return clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined8CharCode1.
   *
   * @return  the clientDefined8CharCode1
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getClientDefined8CharCode1() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined8CharCode2.
   *
   * @return  the clientDefined8CharCode2
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getClientDefined8CharCode2() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined8CharCode3.
   *
   * @return  the clientDefined8CharCode3
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getClientDefined8CharCode3() {
    return clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined8CharCode4.
   *
   * @return  the clientDefined8CharCode4
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getClientDefined8CharCode4() {
    return clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined8CharCode5.
   *
   * @return  the clientDefined8CharCode5
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getClientDefined8CharCode5() {
    return clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined8CharCode6.
   *
   * @return  the clientDefined8CharCode6
   *
   *          <p>not-null = "false" length = "8"</p>
   */
  public String getClientDefined8CharCode6() {
    return clientDefined8CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate1.
   *
   * @return  the clientDefinedDate1
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate10.
   *
   * @return  the clientDefinedDate10
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate10() {
    return clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate11.
   *
   * @return  the clientDefinedDate11
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate11() {
    return clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate2.
   *
   * @return  the clientDefinedDate2
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate3.
   *
   * @return  the clientDefinedDate3
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate4.
   *
   * @return  the clientDefinedDate4
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate5.
   *
   * @return  the clientDefinedDate5
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate6.
   *
   * @return  the clientDefinedDate6
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate6() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate7.
   *
   * @return  the clientDefinedDate7
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate7() {
    return clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate8.
   *
   * @return  the clientDefinedDate8
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate8() {
    return clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDate9.
   *
   * @return  the clientDefinedDate9
   *
   *          <p>not-null = "false"</p>
   */
  public Date getClientDefinedDate9() {
    return clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal1.
   *
   * @return  the clientDefinedDecimal1
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal10.
   *
   * @return  the clientDefinedDecimal10
   */
  public BigDecimal getClientDefinedDecimal10() {
    return clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal11.
   *
   * @return  the clientDefinedDecimal11
   */
  public BigDecimal getClientDefinedDecimal11() {
    return clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal12.
   *
   * @return  the clientDefinedDecimal12
   */
  public BigDecimal getClientDefinedDecimal12() {
    return clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal13.
   *
   * @return  the clientDefinedDecimal13
   */
  public BigDecimal getClientDefinedDecimal13() {
    return clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal14.
   *
   * @return  the clientDefinedDecimal14
   */
  public BigDecimal getClientDefinedDecimal14() {
    return clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal15.
   *
   * @return  the clientDefinedDecimal15
   */
  public BigDecimal getClientDefinedDecimal15() {
    return clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal2.
   *
   * @return  the clientDefinedDecimal2
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal3.
   *
   * @return  the clientDefinedDecimal3
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal4.
   *
   * @return  the clientDefinedDecimal4
   */
  public BigDecimal getClientDefinedDecimal4() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal5.
   *
   * @return  the clientDefinedDecimal5
   */
  public BigDecimal getClientDefinedDecimal5() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal6.
   *
   * @return  the clientDefinedDecimal6
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientDefinedDecimal6() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal7.
   *
   * @return  the clientDefinedDecimal7
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientDefinedDecimal7() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal8.
   *
   * @return  the clientDefinedDecimal8
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientDefinedDecimal8() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal9.
   *
   * @return  the clientDefinedDecimal9
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getClientDefinedDecimal9() {
    return clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedEncryptedString() {
    return clientDefinedEncryptedString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getClientDefinedFlag3() {
    return clientDefinedFlag3;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getClientDefinedFlag4() {
    return clientDefinedFlag4;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger1.
   *
   * @return  the clientDefinedInteger1
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger10.
   *
   * @return  the clientDefinedInteger10
   *
   *          <p>not-null = "false" length = "10"</p>
   */

  public Integer getClientDefinedInteger10() {
    return clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger11.
   *
   * @return  the clientDefinedInteger11
   *
   *          <p>not-null = "false" length = "10"</p>
   */
  public Integer getClientDefinedInteger11() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger12.
   *
   * @return  the clientDefinedInteger12
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger12() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger13.
   *
   * @return  the clientDefinedInteger13
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger13() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger14.
   *
   * @return  the clientDefinedInteger14
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger14() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger15.
   *
   * @return  the clientDefinedInteger15
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger15() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger16.
   *
   * @return  the clientDefinedInteger16
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger16() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger17.
   *
   * @return  the clientDefinedInteger17
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger17() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger2.
   *
   * @return  the clientDefinedInteger2
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger3.
   *
   * @return  the clientDefinedInteger3
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger4.
   *
   * @return  the clientDefinedInteger4
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger5.
   *
   * @return  the clientDefinedInteger5
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public Integer getClientDefinedInteger5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger6.
   *
   * @return  the clientDefinedInteger6
   *
   *          <p>not-null = "false" length = "9"</p>
   */
  public Integer getClientDefinedInteger6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger7.
   *
   * @return  the clientDefinedInteger7
   *
   *          <p>not-null = "false" length = "9"</p>
   */
  public Integer getClientDefinedInteger7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger8.
   *
   * @return  the clientDefinedInteger8
   *
   *          <p>not-null = "false" length = "9"</p>
   */
  public Integer getClientDefinedInteger8() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedInteger9.
   *
   * @return  the clientDefinedInteger9
   *
   *          <p>not-null = "false" length = "9"</p>
   */
  public Integer getClientDefinedInteger9() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedLong1.
   *
   * @return  the clientDefinedLong1
   */
  public Long getClientDefinedLong1() {
    return clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedLong2.
   *
   * @return  the clientDefinedLong2
   */
  public Long getClientDefinedLong2() {
    return clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedLong3.
   *
   * @return  the clientDefinedLong3
   */
  public Long getClientDefinedLong3() {
    return clientDefinedLong3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedLong4.
   *
   * @return  the clientDefinedLong4
   */
  public Long getClientDefinedLong4() {
    return clientDefinedLong4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedString1.
   *
   * @return  the clientDefinedString1
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getClientDefinedString1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString10() {
    return clientDefinedString10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedString2.
   *
   * @return  the clientDefinedString2
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedString3.
   *
   * @return  the clientDefinedString3
   *
   *          <p>not-null = "false" length = "50"</p>
   */
  public String getClientDefinedString3() {
    return clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString4() {
    return clientDefinedString4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString5() {
    return clientDefinedString5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString6() {
    return clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString7() {
    return clientDefinedString7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString8() {
    return clientDefinedString8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString9() {
    return clientDefinedString9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // CMO
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCMO() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBBalanceAmount.
   *
   * @return  the cOBBalanceAmount
   */
  public BigDecimal getCOBBalanceAmount() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBCashAmount.
   *
   * @return  the cOBCashAmount
   */
  public BigDecimal getCOBCashAmount() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBInterestAmount.
   *
   * @return  the cOBInterestAmount
   */
  public BigDecimal getCOBInterestAmount() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBLateFeeAmount.
   *
   * @return  the cOBLateFeeAmount
   */
  public BigDecimal getCOBLateFeeAmount() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBMerchandiseAmount.
   *
   * @return  the cOBMerchandiseAmount
   */
  public BigDecimal getCOBMerchandiseAmount() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBMiscAmount.
   *
   * @return  the cOBMiscAmount
   */
  public BigDecimal getCOBMiscAmount() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBOtherFeeAmount.
   *
   * @return  the cOBOtherFeeAmount
   */
  public BigDecimal getCOBOtherFeeAmount() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cOBOverLimitFeeAmount.
   *
   * @return  the cOBOverLimitFeeAmount
   */
  public BigDecimal getCOBOverLimitFeeAmount() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // collateralType
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getCollateralType() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCollectionUnit() {
    return clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getControlThree() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // crediCardProgram8
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCrediCardProgram8() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // creditCardDebt
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCreditCardDebt() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // currentFico
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getCurrentFico() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // custAddressStreet3
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustAddressStreet3() {
    return clientDefined35CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Customer GRB number
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustErbNum() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Customer Info number
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustInfoNum() {
    return clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // customRiskScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomRiskScore() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getCycleDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDaysOD() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysOnBook() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysSinceBrokenPromise() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysSinceLastPtp() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysSinceRpc() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDaysToProjectedChargeOff() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The ddfsVarDt1.
   *
   * @return  the ddfsVarDt1
   */
  public Date getDfsVarDt1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarDt2.
   *
   * @return  the dfsVarDt2
   */
  public Date getDfsVarDt2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarDt3.
   *
   * @return  the dfsVarDt3
   */
  public Date getDfsVarDt3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarDt4.
   *
   * @return  the dfsVarDt4
   */
  public Date getDfsVarDt4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarDt5.
   *
   * @return  the dfsVarDt5
   */
  public Date getDfsVarDt5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarInd1.
   *
   * @return  the dfsVarInd1
   */
  public String getDfsVarInd1() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarInd2.
   *
   * @return  the dfsVarInd2
   */
  public String getDfsVarInd2() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarInd3.
   *
   * @return  the dfsVarInd3
   */
  public String getDfsVarInd3() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarInd4.
   *
   * @return  the dfsVarInd4
   */
  public String getDfsVarInd4() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarInd5.
   *
   * @return  the dfsVarInd5
   */
  public String getDfsVarInd5() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarNbr1.
   *
   * @return  the dfsVarNbr1
   */
  public Integer getDfsVarNbr1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarNbr2.
   *
   * @return  the dfsVarNbr2
   */
  public Integer getDfsVarNbr2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarNbr3.
   *
   * @return  the dfsVarNbr3
   */
  public Integer getDfsVarNbr3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarNbr4.
   *
   * @return  the dfsVarNbr4
   */
  public Integer getDfsVarNbr4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarNbr5.
   *
   * @return  the dfsVarNbr5
   */
  public Integer getDfsVarNbr5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarTxt1.
   *
   * @return  the dfsVarTxt1
   */
  public String getDfsVarTxt1() {
    return clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarTxt2.
   *
   * @return  the dfsVarTxt2
   */
  public String getDfsVarTxt2() {
    return clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarTxt3.
   *
   * @return  the dfsVarTxt3
   */
  public String getDfsVarTxt3() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarTxt4.
   *
   * @return  the dfsVarTxt4
   */
  public String getDfsVarTxt4() {
    return clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The dfsVarTxt5.
   *
   * @return  the dfsVarTxt5
   */
  public String getDfsVarTxt5() {
    return clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDscore() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEditedActNum() {
    return clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEFlag() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // expirationDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getExpirationDate() {
    return clientDefinedDate5;
  }

  /*
   * getter for Extension Eligibility Flag -- Added by Etisbew on march 30, 2009
   */

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExtensionEligibilityFlag() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFeeWaiverA() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFeeWaiverB() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFeeWaiverC() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGreaterThan70PercReage() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHardShipA() {
    return clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHardShipB() {
    return clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHardShipC() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getHouseholdRiskModel() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // householdType
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getHouseholdType() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getIntensityCell() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The internetRegisteredKey.
   *
   * @return  the internetRegisteredKey
   */
  public String getInternetRegisteredKey() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLaScore() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastBillDate() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lastMonetaryDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastMonetaryDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lastMonetaryType
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastMonetaryType() {
    return clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastOfferReviewedWebsite() {
    return clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLastPtpAmount() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // LastWorkedCollId -- user
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastWorkedCollId() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The legalActionFlag1.
   *
   * @return  the legalActionFlag1
   */
  public String getLegalActionFlag1() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The legalActionFlag2.
   *
   * @return  the legalActionFlag2
   */
  public String getLegalActionFlag2() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The legalScore1.
   *
   * @return  the legalScore1
   */
  public Integer getLegalScore1() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The legalScore2.
   *
   * @return  the legalScore2
   */
  public Integer getLegalScore2() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The legalScore3.
   *
   * @return  the legalScore3
   */
  public Integer getLegalScore3() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The legalScore4.
   *
   * @return  the legalScore4
   */
  public Integer getLegalScore4() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // letterUserDefined10Type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLetterUserDefined10Type() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // letterUserDefined2Type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLetterUserDefined2Type() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // letterUserDefined3
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLetterUserDefined3() {
    return clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // letterUserDefined8Type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLetterUserDefined8Type() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // letterUserDefined9
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLetterUserDefined9() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lmAsapIndicator
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLmAsapIndicator() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLoanType() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lob
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLob() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLongTermAssistanceA() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLongTermAssistanceB() {
    return clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLongTermAssistanceC() {
    return clientDefined8CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lossMitigationRiskScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getLossMitigationRiskScore() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lpmiIndicator
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLpmiIndicator() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // maturityDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMaturityDate() {
    return clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMFlag() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // monthsLastCheckReturned
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMonthsLastCheckReturned() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // mortgageBalances
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getMortgageBalances() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // mortgageDelinquencyFlag
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getMortgageDelinquencyFlag() {
    return Boolean.TRUE.equals(clientDefinedFlag2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // mortgageOwnedInvestor
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMortgageOwnedInvestor() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // mortgageTrades
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMortgageTrades() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The mSAAccountStatus.
   *
   * @return  the mSAAccountStatus
   */
  public String getMSAAccountStatus() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The mSAChargeOffDate.
   *
   * @return  the mSAChargeOffDate
   */
  public Date getMSAChargeOffDate() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The MSAModel1.
   *
   * @return  the MSAModel1
   */
  public String getMSAModel1() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The MSAModel2.
   *
   * @return  the MSAModel2
   */
  public String getMSAModel2() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The mSARecovererCode.
   *
   * @return  the mSARecovererCode
   */
  public String getMSARecovererCode() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The mSAU10RMSCode.
   *
   * @return  the mSAU10RMSCode
   */
  public String getMSAU10RMSCode() {
    return clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // mspLoanNumber
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMspLoanNumber() {
    return clientDefined25CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMultipleRelationshipFlag() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // nccLienPosition
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNccLienPosition() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // numberofReturnedChecks
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNumberofReturnedChecks() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Identifier of program type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferPaletteFld1() {
    return clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Identifier of program type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferPaletteFld2() {
    return clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Identifier of program type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferPaletteFld3() {
    return clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Identifier of program type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferPaletteFld4() {
    return clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Identifier of program type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferPaletteFld5() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Identifier of program type
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOfferPaletteFld6() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // original1stMortgageAmount
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginal1stMortgageAmount() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // originalDTI
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginalDTI() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // originalFicoScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getOriginalFicoScore() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // originalPropertyValue
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOriginalPropertyValue() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // otherDebt
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getOtherDebt() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPreviousBalance() {
    return this.clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPrimaryProgramOffer() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProcessingDate() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // product
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProduct() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // programLastUpdateDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProgramLastUpdateDate() {
    return clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // programLastUpdateTime
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProgramLastUpdateTime() {
    return clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // programScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getProgramScore() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getProjectedChargeOffDate() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRateReductionA() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRateReductionB() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRateReductionC() {
    return clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The rcFiller.
   *
   * @return  the rcFiller
   */
  public String getRcFiller() {
    return clientDefined32CharCode1;
  }

  /*
   * getter for Reage Eligibility Flag -- Added by Etisbew on march 30, 2009
   */

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReactionCode() {
    return clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReageEligibilityFlag() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReasonCode() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecentNsfFlag() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // recoveryGrade
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRecoveryGrade() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // repossessionDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRepossessionDate() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // rightPartyContactScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRightPartyContactScore() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // rollDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRollDate() {
    return clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal15.
   *
   * @return  the clientDefinedDecimal15
   */
  public BigDecimal getScoreNumber10() {
    return clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal9.
   *
   * @return  the clientDefinedDecimal9
   */
  public BigDecimal getScoreNumber4() {
    return clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal10.
   *
   * @return  the clientDefinedDecimal10
   */
  public BigDecimal getScoreNumber5() {
    return clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal11.
   *
   * @return  the clientDefinedDecimal11
   */
  public BigDecimal getScoreNumber6() {
    return clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal12.
   *
   * @return  the clientDefinedDecimal12
   */
  public BigDecimal getScoreNumber7() {
    return clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal13.
   *
   * @return  the clientDefinedDecimal13
   */
  public BigDecimal getScoreNumber8() {
    return clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefinedDecimal14.
   *
   * @return  the clientDefinedDecimal14
   */
  public BigDecimal getScoreNumber9() {
    return clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSecondaryProgramOffer() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // secondaryStateCode1
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSecondaryStateCode1() {
    return clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // secondaryStateCode2
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSecondaryStateCode2() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // secondaryStateCode3
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSecondaryStateCode3() {
    return clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // secondaryStateCode4
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSecondaryStateCode4() {
    return clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // secondaryStateCode5
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSecondaryStateCode5() {
    return clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSettlement30Percentage() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSettlement60Percentage() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSettlement90Percentage() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // settlementScore
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSettlementScore() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSFlag() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getShortTermAssistanceA() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getShortTermAssistanceB() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getShortTermAssistanceC() {
    return clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SlmSchoolStatus getSlmSchoolStatus() {
    return slmSchoolStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // stateIncomeFlag
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean getStateIncomeFlag() {
    return Boolean.TRUE.equals(clientDefinedFlag1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStraightRollerFlag() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // systemOfRecord
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSystemOfRecord() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTertiaryProgramOffer() {
    return clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined10CharCode2.
   *
   * @return  the clientDefined10CharCode2
   */
  public String getTreatment1() {
    return clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined10CharCode3.
   *
   * @return  the clientDefined10CharCode3
   */
  public String getTreatment2() {
    return clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The treatment2Value.
   *
   * @return  the treatment2Value
   */
  public String getTreatment2Value() {
    return clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode1.
   *
   * @return  the clientDefined15CharCode1
   */
  public String getTreatment3() {
    return clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode3.
   *
   * @return  the clientDefined15CharCode3
   */
  public String getTreatment4() {
    return clientDefined15CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientDefined15CharCode4.
   *
   * @return  the clientDefined15CharCode4
   */
  public String getTreatment5() {
    return clientDefined15CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * TRIAD SPID from Tsys.
   *
   * @return  DOCUMENT ME!
   */
  public Integer getTriadSPID() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // udDateField1
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getUdDateField1() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getUpdatedPaymentAmountDate() {
    return updatedPaymentAmountDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getUpdatedPaymentDate() {
    Date ret = null;

    if (updatedPaymentDayDate != null) {
      ret = updatedPaymentDayDate;
    }

    if (updatedPaymentAmountDate != null) {
      if (ret == null) {
        ret = updatedPaymentAmountDate;
      } else if (ret.getTime() < updatedPaymentAmountDate.getTime()) {
        ret = updatedPaymentAmountDate;
      }
    }

    if (cancelledPaymentDate != null) {
      if (ret == null) {
        ret = cancelledPaymentDate;
      } else if (ret.getTime() < cancelledPaymentDate.getTime()) {
        ret = cancelledPaymentDate;
      }
    }

    return ret;
  } // end method getUpdatedPaymentDate

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getUpdatedPaymentDayDate() {
    return updatedPaymentDayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Gopal -- 08/20 added for Action Codes and Reaction Codes - end

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUser() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // ///////Business Methods for NCC CARD GEN 2/////////////////
  // userDefined1
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUserDefined1() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // userDefined4
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUserDefined4() {
    return clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 'userDefinedField1'.
   *
   * @return  DOCUMENT ME!
   */
  public String getUserDefinedField1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 'userDefinedField2'.
   *
   * @return  DOCUMENT ME!
   */
  public String getUserDefinedField2() {
    return clientDefinedString2;
  }
  // ~
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 'userDefinedField3'.
   *
   * @return  DOCUMENT ME!
   */
  public String getUserDefinedField3() {
    return clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 'userDefinedFieldS1'.
   *
   * @return  tsys Placement File Record 100 'userDefinedFieldS1'.
   */
  public Integer getUserDefinedFieldS1() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getUtilizationPercent() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // warningBulletinDate
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getWarningBulletinDate() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // warningBulletinZone
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getWarningBulletinZone() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountDetailId  DOCUMENT ME!
   */
  public void setAccountDetailId(Long accountDetailId) {
    this.accountDetailId = accountDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString1  DOCUMENT ME!
   */
  public void setAccountId(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Getters and Setters for DFS Account Import Job Added by Etisbew on 08/19/09-Start.
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME! the Account Key to set
   */
  public void setAccountKey(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal8  DOCUMENT ME!
   */
  public void setAcsPortfolio(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal6  DOCUMENT ME!
   */
  public void setAggregateBalance(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal7  DOCUMENT ME!
   */
  public void setAggregateMonthlyPayment(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowProgram  DOCUMENT ME!
   */
  public void setAllowProgram(Boolean allowProgram) {
    this.allowProgram = allowProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setAlopBalance(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setApplicationStatus(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal8  DOCUMENT ME!
   */
  public void setApr(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setBankNumber(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  DOCUMENT ME!
   */
  public void setBestTimeToCall(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger10  DOCUMENT ME!
   */
  public void setBkScore(Integer clientDefinedInteger10) {
    this.clientDefinedInteger10 = clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // reason to block account
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setBlockAndReasonCode(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode3  DOCUMENT ME!
   */
  public void setBorrowerAddress4(String clientDefined45CharCode3) {
    this.clientDefined45CharCode3 = clientDefined45CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Branch
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setBranch(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setBrokenPromiseFlag(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelledPaymentDate  DOCUMENT ME!
   */
  public void setCancelledPaymentDate(Date cancelledPaymentDate) {
    this.cancelledPaymentDate = cancelledPaymentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger14  DOCUMENT ME!
   */
  public void setChallengerMod3(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger15  DOCUMENT ME!
   */
  public void setChallengerMod4(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode2  DOCUMENT ME!
   */
  public void setCicKey(String clientDefined15CharCode2) {
    this.clientDefined15CharCode2 = clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode2  DOCUMENT ME!
   */
  public void setCimsBankNumber(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Added by Gopal on 08/09/09 for RBS Specific Fields-End
  // Added by Estibew on 08/10/09 for RBS Specific Fields -Start
  /*
   * public void setResponsibleName1(String clientDefined35CharCode1) {
   * this.clientDefined35CharCode1 = clientDefined35CharCode1; }
   */

  // Gopal 08/23 changed the field from clientDefined25CharCode3 to
  // clientDefined45CharCode3
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode1  DOCUMENT ME!
   */
  public void setCityProvince1(String clientDefined45CharCode1) {
    this.clientDefined45CharCode1 = clientDefined45CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Gopal 08/23 changed the field from clientDefined25CharCode3 to
  // clientDefined45CharCode3 ---End
  /*
   * public void setResponsibleName2(String clientDefined35CharCode2) {
   * this.clientDefined35CharCode2 = clientDefined35CharCode2; }
   */
  // Gopal 08/23 changed the field from clientDefined25CharCode2 to
  // clientDefined45CharCode2
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode2  DOCUMENT ME!
   */
  public void setCityProvince2(String clientDefined45CharCode2) {
    this.clientDefined45CharCode2 = clientDefined45CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined10CharCode1  the clientDefined10CharCode1 to set
   */
  public void setClientDefined10CharCode1(String clientDefined10CharCode1) {
    this.clientDefined10CharCode1 = clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined10CharCode2  the clientDefined10CharCode2 to set
   */
  public void setClientDefined10CharCode2(String clientDefined10CharCode2) {
    this.clientDefined10CharCode2 = clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined10CharCode3  the clientDefined10CharCode3 to set
   */
  public void setClientDefined10CharCode3(String clientDefined10CharCode3) {
    this.clientDefined10CharCode3 = clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode1  the clientDefined15CharCode1 to set
   */
  public void setClientDefined15CharCode1(String clientDefined15CharCode1) {
    this.clientDefined15CharCode1 = clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode2  the clientDefined15CharCode2 to set
   */
  public void setClientDefined15CharCode2(String clientDefined15CharCode2) {
    this.clientDefined15CharCode2 = clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode3  the clientDefined15CharCode3 to set
   */
  public void setClientDefined15CharCode3(String clientDefined15CharCode3) {
    this.clientDefined15CharCode3 = clientDefined15CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode4  the clientDefined15CharCode4 to set
   */
  public void setClientDefined15CharCode4(String clientDefined15CharCode4) {
    this.clientDefined15CharCode4 = clientDefined15CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  the clientDefined1CharCode1 to set
   */
  public void setClientDefined1CharCode1(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  the clientDefined1CharCode2 to set
   */
  public void setClientDefined1CharCode2(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  the clientDefined1CharCode3 to set
   */
  public void setClientDefined1CharCode3(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  the clientDefined1CharCode4 to set
   */
  public void setClientDefined1CharCode4(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  the clientDefined1CharCode5 to set
   */
  public void setClientDefined1CharCode5(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  the clientDefined1CharCode6 to set
   */
  public void setClientDefined1CharCode6(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode7  the clientDefined1CharCode7 to set
   */
  public void setClientDefined1CharCode7(String clientDefined1CharCode7) {
    this.clientDefined1CharCode7 = clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode8  the clientDefined1CharCode8 to set
   */
  public void setClientDefined1CharCode8(String clientDefined1CharCode8) {
    this.clientDefined1CharCode8 = clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode9  the clientDefined1CharCode9 to set
   */
  public void setClientDefined1CharCode9(String clientDefined1CharCode9) {
    this.clientDefined1CharCode9 = clientDefined1CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setClientDefined20CharCode1(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setClientDefined20CharCode2(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode3  DOCUMENT ME!
   */
  public void setClientDefined20CharCode3(String clientDefined20CharCode3) {
    this.clientDefined20CharCode3 = clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode4  DOCUMENT ME!
   */
  public void setClientDefined20CharCode4(String clientDefined20CharCode4) {
    this.clientDefined20CharCode4 = clientDefined20CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined25CharCode1  the clientDefined25CharCode1 to set
   */
  public void setClientDefined25CharCode1(String clientDefined25CharCode1) {
    this.clientDefined25CharCode1 = clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined25CharCode2  the clientDefined25CharCode2 to set
   */
  public void setClientDefined25CharCode2(String clientDefined25CharCode2) {
    this.clientDefined25CharCode2 = clientDefined25CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined25CharCode3  the clientDefined25CharCode3 to set
   */
  public void setClientDefined25CharCode3(String clientDefined25CharCode3) {
    this.clientDefined25CharCode3 = clientDefined25CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  the clientDefined2CharCode1 to set
   */
  public void setClientDefined2CharCode1(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode2  the clientDefined2CharCode2 to set
   */
  public void setClientDefined2CharCode2(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode3  the clientDefined2CharCode3 to set
   */
  public void setClientDefined2CharCode3(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode4  the clientDefined2CharCode4 to set
   */
  public void setClientDefined2CharCode4(String clientDefined2CharCode4) {
    this.clientDefined2CharCode4 = clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode5  DOCUMENT ME!
   */
  public void setClientDefined2CharCode5(String clientDefined2CharCode5) {
    this.clientDefined2CharCode5 = clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined32CharCode1  the clientDefined32CharCode1 to set
   */
  public void setClientDefined32CharCode1(String clientDefined32CharCode1) {
    this.clientDefined32CharCode1 = clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined32CharCode2  the clientDefined32CharCode2 to set
   */
  public void setClientDefined32CharCode2(String clientDefined32CharCode2) {
    this.clientDefined32CharCode2 = clientDefined32CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined32CharCode3  the clientDefined32CharCode3 to set
   */
  public void setClientDefined32CharCode3(String clientDefined32CharCode3) {
    this.clientDefined32CharCode3 = clientDefined32CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined35CharCode1  DOCUMENT ME!
   */
  public void setClientDefined35CharCode1(String clientDefined35CharCode1) {
    this.clientDefined35CharCode1 = clientDefined35CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined35CharCode2  DOCUMENT ME!
   */
  public void setClientDefined35CharCode2(String clientDefined35CharCode2) {
    this.clientDefined35CharCode2 = clientDefined35CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  the clientDefined3CharCode1 to set
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  the clientDefined3CharCode2 to set
   */
  public void setClientDefined3CharCode2(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode3  the clientDefined3CharCode3 to set
   */
  public void setClientDefined3CharCode3(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode4  DOCUMENT ME!
   */
  public void setClientDefined3CharCode4(String clientDefined3CharCode4) {
    this.clientDefined3CharCode4 = clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode5  DOCUMENT ME!
   */
  public void setClientDefined3CharCode5(String clientDefined3CharCode5) {
    this.clientDefined3CharCode5 = clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode1  the clientDefined45CharCode1 to set
   */
  public void setClientDefined45CharCode1(String clientDefined45CharCode1) {
    this.clientDefined45CharCode1 = clientDefined45CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode2  the clientDefined45CharCode2 to set
   */
  public void setClientDefined45CharCode2(String clientDefined45CharCode2) {
    this.clientDefined45CharCode2 = clientDefined45CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode3  the clientDefined45CharCode3 to set
   */
  public void setClientDefined45CharCode3(String clientDefined45CharCode3) {
    this.clientDefined45CharCode3 = clientDefined45CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode4  the clientDefined45CharCode4 to set
   */
  public void setClientDefined45CharCode4(String clientDefined45CharCode4) {
    this.clientDefined45CharCode4 = clientDefined45CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  the clientDefined4CharCode1 to set
   */
  public void setClientDefined4CharCode1(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  the clientDefined4CharCode2 to set
   */
  public void setClientDefined4CharCode2(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode3  the clientDefined4CharCode3 to set
   */
  public void setClientDefined4CharCode3(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode1  the clientDefined5CharCode1 to set
   */
  public void setClientDefined5CharCode1(String clientDefined5CharCode1) {
    this.clientDefined5CharCode1 = clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode2  the clientDefined5CharCode2 to set
   */
  public void setClientDefined5CharCode2(String clientDefined5CharCode2) {
    this.clientDefined5CharCode2 = clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode3  the clientDefined5CharCode3 to set
   */
  public void setClientDefined5CharCode3(String clientDefined5CharCode3) {
    this.clientDefined5CharCode3 = clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode4  the clientDefined5CharCode4 to set
   */
  public void setClientDefined5CharCode4(String clientDefined5CharCode4) {
    this.clientDefined5CharCode4 = clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode1  the clientDefined8CharCode1 to set
   */
  public void setClientDefined8CharCode1(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode2  the clientDefined8CharCode2 to set
   */
  public void setClientDefined8CharCode2(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode3  the clientDefined8CharCode3 to set
   */
  public void setClientDefined8CharCode3(String clientDefined8CharCode3) {
    this.clientDefined8CharCode3 = clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode4  the clientDefined8CharCode4 to set
   */
  public void setClientDefined8CharCode4(String clientDefined8CharCode4) {
    this.clientDefined8CharCode4 = clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode5  the clientDefined8CharCode5 to set
   */
  public void setClientDefined8CharCode5(String clientDefined8CharCode5) {
    this.clientDefined8CharCode5 = clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode6  the clientDefined8CharCode6 to set
   */
  public void setClientDefined8CharCode6(String clientDefined8CharCode6) {
    this.clientDefined8CharCode6 = clientDefined8CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  the clientDefinedDate1 to set
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate10  DOCUMENT ME!
   */
  public void setClientDefinedDate10(Date clientDefinedDate10) {
    this.clientDefinedDate10 = clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate11  DOCUMENT ME!
   */
  public void setClientDefinedDate11(Date clientDefinedDate11) {
    this.clientDefinedDate11 = clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  the clientDefinedDate2 to set
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  the clientDefinedDate3 to set
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate4  the clientDefinedDate4 to set
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  the clientDefinedDate5 to set
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate6  the clientDefinedDate6 to set
   */
  public void setClientDefinedDate6(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate7  the clientDefinedDate7 to set
   */
  public void setClientDefinedDate7(Date clientDefinedDate7) {
    this.clientDefinedDate7 = clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate8  the clientDefinedDate8 to set
   */
  public void setClientDefinedDate8(Date clientDefinedDate8) {
    this.clientDefinedDate8 = clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate9  DOCUMENT ME!
   */
  public void setClientDefinedDate9(Date clientDefinedDate9) {
    this.clientDefinedDate9 = clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  the clientDefinedDecimal1 to set
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal10  the clientDefinedDecimal10 to set
   */
  public void setClientDefinedDecimal10(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal11  the clientDefinedDecimal11 to set
   */

  public void setClientDefinedDecimal11(BigDecimal clientDefinedDecimal11) {
    this.clientDefinedDecimal11 = clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal12  the clientDefinedDecimal12 to set
   */

  public void setClientDefinedDecimal12(BigDecimal clientDefinedDecimal12) {
    this.clientDefinedDecimal12 = clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal13  the clientDefinedDecimal13 to set
   */

  public void setClientDefinedDecimal13(BigDecimal clientDefinedDecimal13) {
    this.clientDefinedDecimal13 = clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal14  the clientDefinedDecimal14 to set
   */

  public void setClientDefinedDecimal14(BigDecimal clientDefinedDecimal14) {
    this.clientDefinedDecimal14 = clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal15  the clientDefinedDecimal15 to set
   */

  public void setClientDefinedDecimal15(BigDecimal clientDefinedDecimal15) {
    this.clientDefinedDecimal15 = clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  the clientDefinedDecimal2 to set
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  the clientDefinedDecimal3 to set
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal4  the clientDefinedDecimal4 to set
   */
  public void setClientDefinedDecimal4(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal5  the clientDefinedDecimal5 to set
   */
  public void setClientDefinedDecimal5(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal6  the clientDefinedDecimal6 to set
   */
  public void setClientDefinedDecimal6(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal7  the clientDefinedDecimal7 to set
   */
  public void setClientDefinedDecimal7(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal8  the clientDefinedDecimal8 to set
   */
  public void setClientDefinedDecimal8(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal9  the clientDefinedDecimal9 to set
   */
  public void setClientDefinedDecimal9(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedEncryptedString  DOCUMENT ME!
   */
  public void setClientDefinedEncryptedString(String clientDefinedEncryptedString) {
    this.clientDefinedEncryptedString = clientDefinedEncryptedString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag1  DOCUMENT ME!
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag2  DOCUMENT ME!
   */
  public void setClientDefinedFlag2(Boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag3  DOCUMENT ME!
   */
  public void setClientDefinedFlag3(Boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag4  DOCUMENT ME!
   */
  public void setClientDefinedFlag4(Boolean clientDefinedFlag4) {
    this.clientDefinedFlag4 = clientDefinedFlag4;
  }
  // ~
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  the clientDefinedInteger1 to set
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger10  DOCUMENT ME!
   */
  public void setClientDefinedInteger10(Integer clientDefinedInteger10) {
    this.clientDefinedInteger10 = clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger11  DOCUMENT ME!
   */
  public void setClientDefinedInteger11(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger12  DOCUMENT ME!
   */
  public void setClientDefinedInteger12(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger13  DOCUMENT ME!
   */
  public void setClientDefinedInteger13(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger14  DOCUMENT ME!
   */
  public void setClientDefinedInteger14(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger15  DOCUMENT ME!
   */
  public void setClientDefinedInteger15(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger16  DOCUMENT ME!
   */
  public void setClientDefinedInteger16(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger17  DOCUMENT ME!
   */
  public void setClientDefinedInteger17(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  the clientDefinedInteger2 to set
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  the clientDefinedInteger3 to set
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  the clientDefinedInteger4 to set
   */
  public void setClientDefinedInteger4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  the clientDefinedInteger5 to set
   */
  public void setClientDefinedInteger5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  the clientDefinedInteger6 to set
   */
  public void setClientDefinedInteger6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  the clientDefinedInteger7 to set
   */
  public void setClientDefinedInteger7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger8  the clientDefinedInteger8 to set
   */
  public void setClientDefinedInteger8(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger9  the clientDefinedInteger9 to set
   */
  public void setClientDefinedInteger9(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedLong1  the clientDefinedLong1 to set
   */
  public void setClientDefinedLong1(Long clientDefinedLong1) {
    this.clientDefinedLong1 = clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedLong2  the clientDefinedLong2 to set
   */
  public void setClientDefinedLong2(Long clientDefinedLong2) {
    this.clientDefinedLong2 = clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedLong3  the clientDefinedLong3 to set
   */
  public void setClientDefinedLong3(Long clientDefinedLong3) {
    this.clientDefinedLong3 = clientDefinedLong3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedLong4  the clientDefinedLong4 to set
   */
  public void setClientDefinedLong4(Long clientDefinedLong4) {
    this.clientDefinedLong4 = clientDefinedLong4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString1  DOCUMENT ME!
   */
  public void setClientDefinedString1(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString10  DOCUMENT ME!
   */
  public void setClientDefinedString10(String clientDefinedString10) {
    this.clientDefinedString10 = clientDefinedString10;
  }
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString2  DOCUMENT ME!
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString3  DOCUMENT ME!
   */
  public void setClientDefinedString3(String clientDefinedString3) {
    this.clientDefinedString3 = clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString4  DOCUMENT ME!
   */
  public void setClientDefinedString4(String clientDefinedString4) {
    this.clientDefinedString4 = clientDefinedString4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString5  DOCUMENT ME!
   */
  public void setClientDefinedString5(String clientDefinedString5) {
    this.clientDefinedString5 = clientDefinedString5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString6  DOCUMENT ME!
   */
  public void setClientDefinedString6(String clientDefinedString6) {
    this.clientDefinedString6 = clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString7  DOCUMENT ME!
   */
  public void setClientDefinedString7(String clientDefinedString7) {
    this.clientDefinedString7 = clientDefinedString7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString8  DOCUMENT ME!
   */
  public void setClientDefinedString8(String clientDefinedString8) {
    this.clientDefinedString8 = clientDefinedString8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString9  DOCUMENT ME!
   */
  public void setClientDefinedString9(String clientDefinedString9) {
    this.clientDefinedString9 = clientDefinedString9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode1  DOCUMENT ME!
   */
  public void setCMO(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  balanceAmount  the cOBBalanceAmount to set
   */
  public void setCOBBalanceAmount(BigDecimal balanceAmount) {
    clientDefinedDecimal2 = balanceAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cashAmount  the cOBCashAmount to set
   */
  public void setCOBCashAmount(BigDecimal cashAmount) {
    clientDefinedDecimal3 = cashAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  interestAmount  the cOBInterestAmount to set
   */
  public void setCOBInterestAmount(BigDecimal interestAmount) {
    clientDefinedDecimal7 = interestAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lateFeeAmount  the cOBLateFeeAmount to set
   */
  public void setCOBLateFeeAmount(BigDecimal lateFeeAmount) {
    clientDefinedDecimal4 = lateFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  merchandiseAmount  the cOBMerchandiseAmount to set
   */
  public void setCOBMerchandiseAmount(BigDecimal merchandiseAmount) {
    clientDefinedDecimal1 = merchandiseAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  miscAmount  the cOBMiscAmount to set
   */
  public void setCOBMiscAmount(BigDecimal miscAmount) {
    clientDefinedDecimal8 = miscAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined45CharCode4  DOCUMENT ME!
   */
  public void setCoBorrowerAddress4(String clientDefined45CharCode4) {
    this.clientDefined45CharCode4 = clientDefined45CharCode4;
  }

  // Added by Estibew on 08/10/09 for RBS Specific Fields -end

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherFeeAmount  the cOBOtherFeeAmount to set
   */
  public void setCOBOtherFeeAmount(BigDecimal otherFeeAmount) {
    clientDefinedDecimal6 = otherFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  overLimitFeeAmount  the cOBOverLimitFeeAmount to set
   */
  public void setCOBOverLimitFeeAmount(BigDecimal overLimitFeeAmount) {
    clientDefinedDecimal5 = overLimitFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setCollateralType(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // CollatRefnum1
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setCollatRefNumOne(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // CollatRefnum2
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setCollatRefNumTwo(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Collection Location
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode4  DOCUMENT ME!
   */
  public void setCollectionLocation(String clientDefined5CharCode4) {
    this.clientDefined5CharCode4 = clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode4  DOCUMENT ME!
   */
  public void setCollectionUnit(String clientDefined8CharCode4) {
    this.clientDefined8CharCode4 = clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Added by Gopal on 08/09/09 for RBS Specific Fields-Start
  // Control3
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setControlThree(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setCrediCardProgram8(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal5  DOCUMENT ME!
   */
  public void setCreditCardDebt(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  DOCUMENT ME!
   */
  public void setCurrentFico(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined35CharCode1  DOCUMENT ME!
   */
  public void setCustAddressStreet3(String clientDefined35CharCode1) {
    this.clientDefined35CharCode1 = clientDefined35CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode2  DOCUMENT ME!
   */
  public void setCustErbNum(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  // Added by Kattasrinivas on 08/11/09 for Citi Aus Specific Fields-End

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined25CharCode1  DOCUMENT ME!
   */
  public void setCustInfoNum(String clientDefined25CharCode1) {
    this.clientDefined25CharCode1 = clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode3  DOCUMENT ME!
   */
  public void setCustomRiskScore(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setCycleDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setDaysOnBook(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // DaysOverDrawn
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setDaysOverDrawn(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setDaysSinceBrokenPromise(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setDaysSinceLastPtp(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setDaysSinceRpc(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  DOCUMENT ME!
   */
  public void setDaysToProjectedChargeOff(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarDt1  DOCUMENT ME! the ddfsVarDt1 to set
   */
  public void setDfsVarDt1(Date dfsVarDt1) {
    this.clientDefinedDate1 = dfsVarDt1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarDt2  the dfsVarDt2 to set
   */
  public void setDfsVarDt2(Date dfsVarDt2) {
    this.clientDefinedDate2 = dfsVarDt2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarDt3  the dfsVarDt3 to set
   */
  public void setDfsVarDt3(Date dfsVarDt3) {
    this.clientDefinedDate3 = dfsVarDt3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarDt4  the dfsVarDt4 to set
   */
  public void setDfsVarDt4(Date dfsVarDt4) {
    this.clientDefinedDate4 = dfsVarDt4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarDt5  the dfsVarDt5 to set
   */
  public void setDfsVarDt5(Date dfsVarDt5) {
    this.clientDefinedDate5 = dfsVarDt5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarInd1  the dfsVarInd1 to set
   */
  public void setDfsVarInd1(String dfsVarInd1) {
    this.clientDefined1CharCode2 = dfsVarInd1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarInd2  the dfsVarInd2 to set
   */
  public void setDfsVarInd2(String dfsVarInd2) {
    this.clientDefined1CharCode3 = dfsVarInd2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarInd3  the dfsVarInd3 to set
   */
  public void setDfsVarInd3(String dfsVarInd3) {
    this.clientDefined1CharCode4 = dfsVarInd3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarInd4  the dfsVarInd4 to set
   */
  public void setDfsVarInd4(String dfsVarInd4) {
    this.clientDefined1CharCode5 = dfsVarInd4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarInd5  the dfsVarInd5 to set
   */
  public void setDfsVarInd5(String dfsVarInd5) {
    this.clientDefined1CharCode6 = dfsVarInd5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarNbr1  the dfsVarNbr1 to set
   */
  public void setDfsVarNbr1(Integer dfsVarNbr1) {
    this.clientDefinedInteger1 = dfsVarNbr1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarNbr2  the dfsVarNbr2 to set
   */
  public void setDfsVarNbr2(Integer dfsVarNbr2) {
    this.clientDefinedInteger2 = dfsVarNbr2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarNbr3  the dfsVarNbr3 to set
   */
  public void setDfsVarNbr3(Integer dfsVarNbr3) {
    this.clientDefinedInteger3 = dfsVarNbr3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarNbr4  the dfsVarNbr4 to set
   */
  public void setDfsVarNbr4(Integer dfsVarNbr4) {
    this.clientDefinedInteger4 = dfsVarNbr4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarNbr5  the dfsVarNbr5 to set
   */
  public void setDfsVarNbr5(Integer dfsVarNbr5) {
    this.clientDefinedInteger5 = dfsVarNbr5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarTxt1  the dfsVarTxt1 to set
   */
  public void setDfsVarTxt1(String dfsVarTxt1) {
    this.clientDefined5CharCode1 = dfsVarTxt1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarTxt2  the dfsVarTxt2 to set
   */
  public void setDfsVarTxt2(String dfsVarTxt2) {
    this.clientDefined5CharCode2 = dfsVarTxt2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarTxt3  the dfsVarTxt3 to set
   */
  public void setDfsVarTxt3(String dfsVarTxt3) {
    this.clientDefined10CharCode1 = dfsVarTxt3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarTxt4  the dfsVarTxt4 to set
   */
  public void setDfsVarTxt4(String dfsVarTxt4) {
    this.clientDefined15CharCode2 = dfsVarTxt4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dfsVarTxt5  the dfsVarTxt5 to set
   */
  public void setDfsVarTxt5(String dfsVarTxt5) {
    this.clientDefined25CharCode1 = dfsVarTxt5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setDscore(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Edited Account Number
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined25CharCode1  DOCUMENT ME!
   */
  public void setEditAccountNumber(String clientDefined25CharCode1) {
    this.clientDefined25CharCode1 = clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // eflag
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setEFlag(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setExpirationDate(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /*
   * setter for Extension Eligibility Flag -- Added by Etisbew on march 30, 2009
   */
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setExtensionEligibilityFlag(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setFeeWaiverA(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode2  DOCUMENT ME!
   */
  public void setFeeWaiverB(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode3  DOCUMENT ME!
   */
  public void setFeeWaiverC(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setGasMeterNumber(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setGreaterThan70PercReage(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode4  DOCUMENT ME!
   */
  public void setHardShipA(String clientDefined2CharCode4) {
    this.clientDefined2CharCode4 = clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode5  DOCUMENT ME!
   */
  public void setHardShipB(String clientDefined2CharCode5) {
    this.clientDefined2CharCode5 = clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setHardShipC(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setHeloanRank(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setHeloanScore(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal10  DOCUMENT ME!
   */
  public void setHelocRank(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal9  DOCUMENT ME!
   */
  public void setHelocscore(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger17  DOCUMENT ME!
   */
  public void setHouseholdRiskModel(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode2  DOCUMENT ME!
   */
  public void setHouseholdType(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setIntensityCell(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  internetRegisteredKey  the internetRegisteredKey to set
   */
  public void setInternetRegisteredKey(String internetRegisteredKey) {
    this.clientDefined1CharCode1 = internetRegisteredKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setLaScore(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // LastACtion Code
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode3  DOCUMENT ME!
   */
  public void setLastActionCode(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setLastBillDate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setLastMonetaryDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode4  DOCUMENT ME!
   */
  public void setLastMonetaryType(String clientDefined2CharCode4) {
    this.clientDefined2CharCode4 = clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined32CharCode1  DOCUMENT ME!
   */
  public void setLastOfferReviewedWebsite(String clientDefined32CharCode1) {
    this.clientDefined32CharCode1 = clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setLastPtpAmount(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // lastWorkedAction
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode2  DOCUMENT ME!
   */
  public void setLastWorkedAction(String clientDefined5CharCode2) {
    this.clientDefined5CharCode2 = clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // LastWorkedCollId
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined10CharCode1  DOCUMENT ME!
   */
  public void setLastWorkedCollId(String clientDefined10CharCode1) {
    this.clientDefined10CharCode1 = clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // LastWorkedReaction
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode3  DOCUMENT ME!
   */
  public void setLastWorkedReAction(String clientDefined5CharCode3) {
    this.clientDefined5CharCode3 = clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // LateChargesDue
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal4  DOCUMENT ME!
   */
  public void setLateChargesDue(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  legalActionFlag1  the legalActionFlag1 to set
   */
  public void setLegalActionFlag1(String legalActionFlag1) {
    this.clientDefined2CharCode1 = legalActionFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  legalActionFlag2  the legalActionFlag2 to set
   */
  public void setLegalActionFlag2(String legalActionFlag2) {
    this.clientDefined2CharCode2 = legalActionFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString3  DOCUMENT ME!
   */
  public void setLegalEntity(String clientDefinedString3) {
    this.clientDefinedString3 = clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  legalScore1  the legalScore1 to set
   */
  public void setLegalScore1(Integer legalScore1) {
    this.clientDefinedInteger6 = legalScore1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  legalScore2  the legalScore2 to set
   */
  public void setLegalScore2(Integer legalScore2) {
    this.clientDefinedInteger7 = legalScore2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  legalScore3  the legalScore3 to set
   */
  public void setLegalScore3(Integer legalScore3) {
    this.clientDefinedInteger8 = legalScore3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  legalScore4  the legalScore4 to set
   */
  public void setLegalScore4(Integer legalScore4) {
    this.clientDefinedInteger9 = legalScore4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setLegalStatus(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setLetterUserDefined10Type(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setLetterUserDefined2Type(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined32CharCode1  DOCUMENT ME!
   */
  public void setLetterUserDefined3(String clientDefined32CharCode1) {
    this.clientDefined32CharCode1 = clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger9  DOCUMENT ME!
   */
  public void setLetterUserDefined8Type(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal7  DOCUMENT ME!
   */
  public void setLetterUserDefined9(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger16  DOCUMENT ME!
   */
  public void setLmAsapIndicator(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setLoanDuration(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Loan Type
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode3  DOCUMENT ME!
   */
  public void setLoanType(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setLob(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal9  DOCUMENT ME!
   */
  public void setLossMitigationRiskScore(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setLpmiIndicator(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal4  DOCUMENT ME!
   */
  public void setMargin(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal5  DOCUMENT ME!
   */
  public void setMarginValue(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate8  DOCUMENT ME!
   */
  public void setMaturityDate(Date clientDefinedDate8) {
    this.clientDefinedDate8 = clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // mflag
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode3  DOCUMENT ME!
   */
  public void setMFlag(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setMonthEnddate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setMonthsLastCheckReturned(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal4  DOCUMENT ME!
   */
  public void setMortgageBalances(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag2  DOCUMENT ME!
   */
  public void setMortgageDelinquencyFlag(boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setMortgageOwnedInvestor(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger8  DOCUMENT ME!
   */
  public void setMortgageTrades(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountStatus  the mSAAccountStatus to set
   */
  public void setMSAAccountStatus(String accountStatus) {
    clientDefined3CharCode1 = accountStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  chargeOffDate  the mSAChargeOffDate to set
   */
  public void setMSAChargeOffDate(Date chargeOffDate) {
    clientDefinedDate6 = chargeOffDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  MSAModel1  the MSAModel1 to set
   */
  public void setMSAModel1(String MSAModel1) {
    this.clientDefined8CharCode1 = MSAModel1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  MSAModel2  the MSAModel2 to set
   */
  public void setMSAModel2(String MSAModel2) {
    this.clientDefined8CharCode2 = MSAModel2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  recovererCode  the mSARecovererCode to set
   */
  public void setMSARecovererCode(String recovererCode) {
    clientDefined4CharCode1 = recovererCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  code  the mSAU10RMSCode to set
   */
  public void setMSAU10RMSCode(String code) {
    clientDefined1CharCode7 = code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined25CharCode2  DOCUMENT ME!
   */
  public void setMspLoanNumber(String clientDefined25CharCode2) {
    this.clientDefined25CharCode2 = clientDefined25CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode4  DOCUMENT ME!
   */
  public void setMultipleRelationshipFlag(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger12  DOCUMENT ME!
   */
  public void setNccLienPosition(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // noNsfItems
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode1  DOCUMENT ME!
   */
  public void setNoNsfItems(String clientDefined5CharCode1) {
    this.clientDefined5CharCode1 = clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setNumberofReturnedChecks(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode1  DOCUMENT ME!
   */
  public void setOfferPaletteFld1(String clientDefined5CharCode1) {
    this.clientDefined5CharCode1 = clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode2  DOCUMENT ME!
   */
  public void setOfferPaletteFld2(String clientDefined5CharCode2) {
    this.clientDefined5CharCode2 = clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode3  DOCUMENT ME!
   */
  public void setOfferPaletteFld3(String clientDefined5CharCode3) {
    this.clientDefined5CharCode3 = clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode4  DOCUMENT ME!
   */
  public void setOfferPaletteFld4(String clientDefined5CharCode4) {
    this.clientDefined5CharCode4 = clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode1  DOCUMENT ME!
   */
  public void setOfferPaletteFld5(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode2  DOCUMENT ME!
   */
  public void setOfferPaletteFld6(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setOriginal1stMortgageAmount(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setOriginalDTI(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  DOCUMENT ME!
   */
  public void setOriginalFicoScore(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setOriginalPropertyValue(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // RUA- SAS loader job
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal3  DOCUMENT ME!
   */
  public void setOriginationDebtRatio(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal6  DOCUMENT ME!
   */
  public void setOtherDebt(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Partial Amount
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setPartialAmount(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // perDiem
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal2  DOCUMENT ME!
   */
  public void setPerDiem(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Getters and Setters for DFS Account Import Job Added by Etisbew on 08/19/09-End.
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  // Fields used by SP for Previous Balance
  public void setPreviousBalance(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode1  DOCUMENT ME!
   */
  public void setPrimaryProgramOffer(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString1  DOCUMENT ME!
   */
  public void setProcessDesc(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // Processing Date
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setProcessingDate(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode1  DOCUMENT ME!
   */
  public void setProcessType(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode2  DOCUMENT ME!
   */
  public void setProduct(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString2  DOCUMENT ME!
   */
  public void setProductDesc(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode2  DOCUMENT ME!
   */
  public void setProductType(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate9  DOCUMENT ME!
   */
  public void setProgramLastUpdateDate(Date clientDefinedDate9) {
    this.clientDefinedDate9 = clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate10  DOCUMENT ME!
   */
  public void setProgramLastUpdateTime(Date clientDefinedDate10) {
    this.clientDefinedDate10 = clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger11  DOCUMENT ME!
   */
  public void setProgramScore(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setProjectedChargeOffDate(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode5  DOCUMENT ME!
   */
  public void setRateReductionA(String clientDefined3CharCode5) {
    this.clientDefined3CharCode5 = clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode2  DOCUMENT ME!
   */
  public void setRateReductionB(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode3  DOCUMENT ME!
   */
  public void setRateReductionC(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }
  // ------------------------------------------------------------------------------------------------------------------

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  rcFiller  the rcFiller to set
   */
  public void setRcFiller(String rcFiller) {
    this.clientDefined32CharCode1 = rcFiller;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /*
   * setter for Reage Eligibility Flag -- Added by Etisbew on march 30, 2009
   */
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode1  DOCUMENT ME!
   */
  public void setReageEligibilityFlag(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode6  DOCUMENT ME!
   */
  public void setRecentNsfFlag(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode1  DOCUMENT ME!
   */
  public void setRecoveryGrade(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // region code
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setRegionCd(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setRepossessionDate(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger13  DOCUMENT ME!
   */
  public void setRightPartyContactScore(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate7  DOCUMENT ME!
   */
  public void setRollDate(Date clientDefinedDate7) {
    this.clientDefinedDate7 = clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal15  the clientDefinedDecimal15 to set
   */
  public void setScoreNumber10(BigDecimal clientDefinedDecimal15) {
    this.clientDefinedDecimal15 = clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal9  the clientDefinedDecimal9 to set
   */
  public void setScoreNumber4(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal10  the clientDefinedDecimal10 to set
   */
  public void setScoreNumber5(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal11  the clientDefinedDecimal11 to set
   */
  public void setScoreNumber6(BigDecimal clientDefinedDecimal11) {
    this.clientDefinedDecimal11 = clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal12  the clientDefinedDecimal12 to set
   */
  public void setScoreNumber7(BigDecimal clientDefinedDecimal12) {
    this.clientDefinedDecimal12 = clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal13  the clientDefinedDecimal13 to set
   */
  public void setScoreNumber8(BigDecimal clientDefinedDecimal13) {
    this.clientDefinedDecimal13 = clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal14  the clientDefinedDecimal14 to set
   */
  public void setScoreNumber9(BigDecimal clientDefinedDecimal14) {
    this.clientDefinedDecimal14 = clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode2  DOCUMENT ME!
   */
  public void setSecondaryProgramOffer(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode4  DOCUMENT ME!
   */
  public void setSecondaryStateCode1(String clientDefined3CharCode4) {
    this.clientDefined3CharCode4 = clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode5  DOCUMENT ME!
   */
  public void setSecondaryStateCode2(String clientDefined3CharCode5) {
    this.clientDefined3CharCode5 = clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode1  DOCUMENT ME!
   */
  public void setSecondaryStateCode3(String clientDefined5CharCode1) {
    this.clientDefined5CharCode1 = clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode2  DOCUMENT ME!
   */
  public void setSecondaryStateCode4(String clientDefined5CharCode2) {
    this.clientDefined5CharCode2 = clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined5CharCode3  DOCUMENT ME!
   */
  public void setSecondaryStateCode5(String clientDefined5CharCode3) {
    this.clientDefined5CharCode3 = clientDefined5CharCode3;
  }

  // ///////Business Methods for NCC CARD GEN 2 - END/////////////////

  // ///////Business Methods for DFS/////////////////

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  clientDefined5CharCode1 DOCUMENT ME!
   */
  public void setSettlement30Percentage(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger8  clientDefined5CharCode2 DOCUMENT ME!
   */
  public void setSettlement60Percentage(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger9  clientDefined5CharCode3 DOCUMENT ME!
   */
  public void setSettlement90Percentage(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setSettlementScore(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  // sflag
  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode1  DOCUMENT ME!
   */
  public void setSFlag(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode2  DOCUMENT ME!
   */
  public void setShortTermAssistanceA(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode3  DOCUMENT ME!
   */
  public void setShortTermAssistanceB(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined3CharCode4  DOCUMENT ME!
   */
  public void setShortTermAssistanceC(String clientDefined3CharCode4) {
    this.clientDefined3CharCode4 = clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  slmSchoolStatus  DOCUMENT ME!
   */
  public void setSlmSchoolStatus(SlmSchoolStatus slmSchoolStatus) {
    this.slmSchoolStatus = slmSchoolStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag1  DOCUMENT ME!
   */
  public void setStateIncomeFlag(boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined1CharCode5  DOCUMENT ME!
   */
  public void setStraightRollerFlag(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined4CharCode1  DOCUMENT ME!
   */
  public void setSystemOfRecord(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined8CharCode3  DOCUMENT ME!
   */
  public void setTertiaryProgramOffer(String clientDefined8CharCode3) {
    this.clientDefined8CharCode3 = clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined10CharCode2  the treatment1 to set
   */
  public void setTreatment1(String clientDefined10CharCode2) {
    this.clientDefined10CharCode2 = clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined10CharCode3  the treatment2 to set
   */
  public void setTreatment2(String clientDefined10CharCode3) {
    this.clientDefined10CharCode3 = clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  treatment2Value  the treatment2Value to set
   */
  public void setTreatment2Value(String treatment2Value) {
    this.clientDefined15CharCode1 = treatment2Value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode1  the treatment3 to set
   */
  public void setTreatment3(String clientDefined15CharCode1) {
    this.clientDefined15CharCode1 = clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode3  the treatment4 to set
   */
  public void setTreatment4(String clientDefined15CharCode3) {
    this.clientDefined15CharCode3 = clientDefined15CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined15CharCode4  the treatment5 to set
   */
  public void setTreatment5(String clientDefined15CharCode4) {
    this.clientDefined15CharCode4 = clientDefined15CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * TRIAD SPID from Tsys.
   *
   * @param  triadSPID  DOCUMENT ME!
   */
  public void setTriadSPID(Integer triadSPID) {
    this.clientDefinedInteger3 = triadSPID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate4  DOCUMENT ME!
   */
  public void setUdDateField1(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updatedPaymentAmountDate  DOCUMENT ME!
   */
  public void setUpdatedPaymentAmountDate(Date updatedPaymentAmountDate) {
    this.updatedPaymentAmountDate = updatedPaymentAmountDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updatedPaymentDayDate  DOCUMENT ME!
   */
  public void setUpdatedPaymentDayDate(Date updatedPaymentDayDate) {
    this.updatedPaymentDayDate = updatedPaymentDayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined20CharCode1  DOCUMENT ME!
   */
  public void setUserDefined1(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefined2CharCode5  DOCUMENT ME!
   */
  public void setUserDefined4(String clientDefined2CharCode5) {
    this.clientDefined2CharCode5 = clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 - 'userDefinedField1'
   *
   * @param  userDefinedField1  DOCUMENT ME!
   */
  public void setUserDefinedField1(String userDefinedField1) {
    this.clientDefinedString1 = userDefinedField1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys placement file Record 100 - userDefinedField2.
   *
   * @param  userDefinedField2  DOCUMENT ME!
   */
  public void setUserDefinedField2(String userDefinedField2) {
    this.clientDefinedString2 = userDefinedField2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys placement file Record 100 'userDefinedField3'
   *
   * @param  userDefinedField3  DOCUMENT ME!
   */
  public void setUserDefinedField3(String userDefinedField3) {
    this.clientDefinedString3 = userDefinedField3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Tsys Placement File Record 100 'userDefinedFieldS1'.
   *
   * @param  userDefinedFieldS1  DOCUMENT ME!
   */
  public void setUserDefinedFieldS1(Integer userDefinedFieldS1) {
    this.clientDefinedInteger2 = userDefinedFieldS1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDecimal1  DOCUMENT ME!
   */
  public void setUtilizationPercent(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setWarningBulletinDate(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setWarningBulletinZone(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }
} // end class AccountDetail
