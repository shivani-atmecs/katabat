package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.slm.SlmEsignatureForm;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import org.springframework.util.StringUtils;


/**
 * This class is used to store ResponsibleDetail information for NCC2.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:27
 */
@Entity
@Table(
  name    = "ResponsibleDetail",
  indexes = {
    @Index(
      name = "clientReferenceIdIndex",
      columnList = "clientReferenceId"
    ),
    @Index(
      name = "employerEmailAddressIndex",
      columnList = "employerEmailAddress"
    ),
    @Index(
      name = "employerFaxNumIndex",
      columnList = "employerFaxNum"
    ),
    @Index(
      name = "employerMobilePhoneNumIndex",
      columnList = "employerMobilePhoneNum"
    ),
    @Index(
      name = "employerPhoneNum1Index",
      columnList = "employerPhoneNum1"
    ),
    @Index(
      name = "employerPhoneNum2Index",
      columnList = "employerPhoneNum2"
    ),
    @Index(
      name = "employerPostalCodeIndex",
      columnList = "employerPostalCode"
    )
  }
)
public class ResponsibleDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5579087971478503377L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode1",
    length = 20
  )
  protected String clientDefined20CharCode1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode2",
    length = 20
  )
  protected String clientDefined20CharCode2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode3",
    length = 20
  )
  protected String clientDefined20CharCode3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode4",
    length = 20
  )
  protected String clientDefined20CharCode4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined20CharCode5",
    length = 20
  )
  protected String clientDefined20CharCode5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode1",
    length = 50
  )
  protected String clientDefined50CharCode1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode10",
    length = 50
  )
  protected String clientDefined50CharCode10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode11",
    length = 50
  )
  protected String clientDefined50CharCode11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode12",
    length = 50
  )
  protected String clientDefined50CharCode12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode13",
    length = 50
  )
  protected String clientDefined50CharCode13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode14",
    length = 50
  )
  protected String clientDefined50CharCode14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode15",
    length = 50
  )
  protected String clientDefined50CharCode15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode16",
    length = 50
  )
  protected String clientDefined50CharCode16;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode2",
    length = 50
  )
  protected String clientDefined50CharCode2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode3",
    length = 50
  )
  protected String clientDefined50CharCode3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode4",
    length = 50
  )
  protected String clientDefined50CharCode4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode5",
    length = 50
  )
  protected String clientDefined50CharCode5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode6",
    length = 50
  )
  protected String clientDefined50CharCode6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode7",
    length = 50
  )
  protected String clientDefined50CharCode7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode8",
    length = 50
  )
  protected String clientDefined50CharCode8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefined50CharCode9",
    length = 50
  )
  protected String clientDefined50CharCode9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientReferenceId",
    length = 50
  )
  protected String clientReferenceId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerAddress1",
    length = 150
  )
  protected String employerAddress1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerAddress2",
    length = 150
  )
  protected String employerAddress2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerAddress3",
    length = 150
  )
  protected String employerAddress3;

  // npelleti Made column non nullable 08/06
  // npelleti Made column nullable 08/19

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerCity",
    length = 50 /*, nullable=false*/
  )
  protected String employerCity;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerCountry",
    length = 100
  )
  protected String employerCountry;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerEmailAddress",
    length = 128
  )
  protected String employerEmailAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerFaxNum",
    length = 20
  )
  protected String employerFaxNum;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerMobilePhoneNum",
    length = 20
  )
  protected String employerMobilePhoneNum;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerPhoneNum1",
    length = 20
  )
  protected String employerPhoneNum1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerPhoneNum2",
    length = 20
  )
  protected String employerPhoneNum2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerPostalCode",
    length = 25
  )
  protected String employerPostalCode;
  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerProvince",
    length = 100
  )
  protected String employerProvince;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "occupation",
    length = 150
  )
  protected String occupation;

  /** Responsible Detail id PK. */

  @Column(
    name     = "responsibleDetailId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleDetailId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "responsibleDetail",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<SlmEsignatureForm> slmForbearenceForms = new LinkedHashSet<SlmEsignatureForm>();

  // Constructors
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
    name   = "clientDefined120CharCode1",
    length = 120
  )
  private String clientDefined120CharCode1;
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

  // Version of the E-sign Agreement Disclosure
  @Column(
    name   = "clientDefined5CharCode1",
    length = 5
  )
  private String clientDefined5CharCode1;
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
    name   = "clientDefined80CharCode1",
    length = 80
  )
  private String clientDefined80CharCode1;

  // Date of E-Sign Agreement Disclosure Accepted / Declined
  @Column(name = "clientDefinedDate1")
  private Date clientDefinedDate1;
  @Column(name = "clientDefinedDate2")
  private Date clientDefinedDate2;
  @Column(name = "clientDefinedDate3")
  private Date clientDefinedDate3;
  @Column(name = "clientDefinedDate4")
  private Date clientDefinedDate4;
  @Column(name = "clientDefinedDate5")
  private Date clientDefinedDate5;
  @Column(name = "clientDefinedDate6")
  private Date clientDefinedDate6;

  @Column(name = "clientDefinedDecimal1")
  private BigDecimal clientDefinedDecimal1;
  @Column(name = "clientDefinedDecimal2")
  private BigDecimal clientDefinedDecimal2;
  @Column(name = "clientDefinedDecimal3")
  private BigDecimal clientDefinedDecimal3;

  // For the Status of E-sign Agreement Disclosure
  @Column(
    name   = "clientDefinedFlag1",
    length = 1
  )
  private String clientDefinedFlag1;

  // npelleti 08/17 modified the datatype to char(1)

  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private String clientDefinedFlag2;


  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private String clientDefinedFlag3;
  @Column(
    name   = "clientDefinedFlag4",
    length = 1
  )
  private String clientDefinedFlag4;
  @Column(
    name   = "clientDefinedFlag5",
    length = 1
  )
  private String clientDefinedFlag5;
  @Column(
    name   = "clientDefinedFlag6",
    length = 1
  )
  private String clientDefinedFlag6;

  // Place Holders for Future Use
  @Column(name = "clientDefinedInteger1")
  private Integer clientDefinedInteger1;
  @Column(name = "clientDefinedInteger2")
  private Integer clientDefinedInteger2;
  @Column(name = "clientDefinedInteger3")
  private Integer clientDefinedInteger3;
  @Column(
    name   = "clientDefinedString1",
    length = 50
  )
  private String  clientDefinedString1;

  @Column(
    name   = "clientDefinedString2",
    length = 50
  )
  private String clientDefinedString2;
  @Column(
    name   = "clientDefinedString3",
    length = 50
  )
  private String clientDefinedString3;

  @Column(name = "jobCode")
  private Integer jobCode;

  @Column(name = "languageCode")
  private String languageCode;

  @Column(name = "mailCode")
  private String mailCode;

  @Column(
    name   = "maritalStatus",
    length = 10
  )
  private String maritalStatus;

  @Column(name = "preferredLanguageCode")
  private String preferredLanguageCode;

  /** responsibleId. */
  @JoinColumn(
    name   = "responsibleId",
    unique = true /* ,nullable = false */
  )
  @ManyToOne(cascade = CascadeType.ALL)
  private Responsible responsible;

  private final static Map<String, String> preferredLanguageCodeMap = new HashMap<String, String>();

  static {
    preferredLanguageCodeMap.put("en_US", "EN");
    preferredLanguageCodeMap.put("fr_FR", "FR");
    preferredLanguageCodeMap.put("es_US", "SP");
  }

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ResponsibleDetail object.
   */
  public ResponsibleDetail() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addResponsible.
   *
   * @param  responsible  Responsible
   */
  public void addResponsible(Responsible responsible) {
    responsible.setResponsibleDetail(this);
    setResponsible(responsible);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSlmForbearenceForm.
   *
   * @param  slmForbearenceForm  SlmEsignatureForm
   */
  public void addSlmForbearenceForm(SlmEsignatureForm slmForbearenceForm) {
    slmForbearenceForm.setResponsibleDetail(this);
    this.slmForbearenceForms.add(slmForbearenceForm);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code1.
   *
   * @return  String
   */
  public String getClientDefined10CharCode1() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code2.
   *
   * @return  String
   */
  public String getClientDefined10CharCode2() {
    return clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code3.
   *
   * @return  String
   */
  public String getClientDefined10CharCode3() {
    return clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined120 char code1.
   *
   * @return  String
   */
  public String getClientDefined120CharCode1() {
    return clientDefined120CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code1.
   *
   * @return  String
   */
  public String getClientDefined15CharCode1() {
    return clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code2.
   *
   * @return  String
   */
  public String getClientDefined15CharCode2() {
    return clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code3.
   *
   * @return  String
   */
  public String getClientDefined15CharCode3() {
    return clientDefined15CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code1.
   *
   * @return  String
   */
  public String getClientDefined20CharCode1() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code2.
   *
   * @return  String
   */
  public String getClientDefined20CharCode2() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code3.
   *
   * @return  String
   */
  public String getClientDefined20CharCode3() {
    return clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code4.
   *
   * @return  String
   */
  public String getClientDefined20CharCode4() {
    return clientDefined20CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code5.
   *
   * @return  String
   */
  public String getClientDefined20CharCode5() {
    return clientDefined20CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code1.
   *
   * @return  String
   */
  public String getClientDefined25CharCode1() {
    return clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code2.
   *
   * @return  String
   */
  public String getClientDefined25CharCode2() {
    return clientDefined25CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code3.
   *
   * @return  String
   */
  public String getClientDefined25CharCode3() {
    return clientDefined25CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code1.
   *
   * @return  String
   */
  public String getClientDefined50CharCode1() {
    return clientDefined50CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code10.
   *
   * @return  String
   */
  public String getClientDefined50CharCode10() {
    return clientDefined50CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code11.
   *
   * @return  String
   */
  public String getClientDefined50CharCode11() {
    return clientDefined50CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code12.
   *
   * @return  String
   */
  public String getClientDefined50CharCode12() {
    return clientDefined50CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code13.
   *
   * @return  String
   */
  public String getClientDefined50CharCode13() {
    return clientDefined50CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code14.
   *
   * @return  String
   */
  public String getClientDefined50CharCode14() {
    return clientDefined50CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code15.
   *
   * @return  String
   */
  public String getClientDefined50CharCode15() {
    return clientDefined50CharCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code16.
   *
   * @return  String
   */
  public String getClientDefined50CharCode16() {
    return clientDefined50CharCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code2.
   *
   * @return  String
   */
  public String getClientDefined50CharCode2() {
    return clientDefined50CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code3.
   *
   * @return  String
   */
  public String getClientDefined50CharCode3() {
    return clientDefined50CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code4.
   *
   * @return  String
   */
  public String getClientDefined50CharCode4() {
    return clientDefined50CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code5.
   *
   * @return  String
   */
  public String getClientDefined50CharCode5() {
    return clientDefined50CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code6.
   *
   * @return  String
   */
  public String getClientDefined50CharCode6() {
    return clientDefined50CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code7.
   *
   * @return  String
   */
  public String getClientDefined50CharCode7() {
    return clientDefined50CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code8.
   *
   * @return  String
   */
  public String getClientDefined50CharCode8() {
    return clientDefined50CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined50 char code9.
   *
   * @return  String
   */
  public String getClientDefined50CharCode9() {
    return clientDefined50CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code1.
   *
   * @return  String
   */
  public String getClientDefined5CharCode1() {
    return clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code2.
   *
   * @return  String
   */
  public String getClientDefined5CharCode2() {
    return clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code3.
   *
   * @return  String
   */
  public String getClientDefined5CharCode3() {
    return clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code1.
   *
   * @return  String
   */
  public String getClientDefined80CharCode1() {
    return clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date2.
   *
   * @return  Date
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date3.
   *
   * @return  Date
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date4.
   *
   * @return  Date
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date5.
   *
   * @return  Date
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date6.
   *
   * @return  Date
   */
  public Date getClientDefinedDate6() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  String
   */
  public String getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  String
   */
  public String getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag3.
   *
   * @return  String
   */
  public String getClientDefinedFlag3() {
    return clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag4.
   *
   * @return  String
   */
  public String getClientDefinedFlag4() {
    return clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag5.
   *
   * @return  String
   */
  public String getClientDefinedFlag5() {
    return clientDefinedFlag5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag6.
   *
   * @return  String
   */
  public String getClientDefinedFlag6() {
    return clientDefinedFlag6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer1.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer2.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer3.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string1.
   *
   * @return  String
   */
  public String getClientDefinedString1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string2.
   *
   * @return  String
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string3.
   *
   * @return  String
   */
  public String getClientDefinedString3() {
    return clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client reference id.
   *
   * @return  String
   */
  public String getClientReferenceId() {
    return clientReferenceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer address1.
   *
   * @return  String
   */
  public String getEmployerAddress1() {
    return employerAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer address2.
   *
   * @return  String
   */
  public String getEmployerAddress2() {
    return employerAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer address3.
   *
   * @return  String
   */
  public String getEmployerAddress3() {
    return employerAddress3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer city.
   *
   * @return  String
   */
  public String getEmployerCity() {
    return employerCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer country.
   *
   * @return  String
   */
  public String getEmployerCountry() {
    return employerCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer email address.
   *
   * @return  String
   */
  public String getEmployerEmailAddress() {
    return employerEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer fax num.
   *
   * @return  String
   */
  public String getEmployerFaxNum() {
    return employerFaxNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer mobile phone num.
   *
   * @return  String
   */
  public String getEmployerMobilePhoneNum() {
    return employerMobilePhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer phone num1.
   *
   * @return  String
   */
  public String getEmployerPhoneNum1() {
    return employerPhoneNum1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer phone num2.
   *
   * @return  String
   */
  public String getEmployerPhoneNum2() {
    return employerPhoneNum2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer postal code.
   *
   * @return  String
   */
  public String getEmployerPostalCode() {
    return employerPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer province.
   *
   * @return  String
   */
  public String getEmployerProvince() {
    return employerProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for job code.
   *
   * @return  Integer
   */
  public Integer getJobCode() {
    return jobCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for language code.
   *
   * @return  String
   */
  public String getLanguageCode() {
    return languageCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail code.
   *
   * @return  String
   */
  public String getMailCode() {
    return mailCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for marital status.
   *
   * @return  String
   */
  public String getMaritalStatus() {
    return maritalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for occupation.
   *
   * @return  String
   */
  public String getOccupation() {
    return occupation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible detail id.
   *
   * @return  Long
   */
  public Long getResponsibleDetailId() {
    return responsibleDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for slm forbearence forms.
   *
   * @return  Set
   */
  public Set<SlmEsignatureForm> getSlmForbearenceForms() {
    return slmForbearenceForms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code1.
   *
   * @param  clientDefined10CharCode1  String
   */
  public void setClientDefined10CharCode1(String clientDefined10CharCode1) {
    this.clientDefined10CharCode1 = clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code2.
   *
   * @param  clientDefined10CharCode2  String
   */
  public void setClientDefined10CharCode2(String clientDefined10CharCode2) {
    this.clientDefined10CharCode2 = clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code3.
   *
   * @param  clientDefined10CharCode3  String
   */
  public void setClientDefined10CharCode3(String clientDefined10CharCode3) {
    this.clientDefined10CharCode3 = clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined120 char code1.
   *
   * @param  clientDefined120CharCode1  String
   */
  public void setClientDefined120CharCode1(String clientDefined120CharCode1) {
    this.clientDefined120CharCode1 = clientDefined120CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code1.
   *
   * @param  clientDefined15CharCode1  String
   */
  public void setClientDefined15CharCode1(String clientDefined15CharCode1) {
    this.clientDefined15CharCode1 = clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code2.
   *
   * @param  clientDefined15CharCode2  String
   */
  public void setClientDefined15CharCode2(String clientDefined15CharCode2) {
    this.clientDefined15CharCode2 = clientDefined15CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code3.
   *
   * @param  clientDefined15CharCode3  String
   */
  public void setClientDefined15CharCode3(String clientDefined15CharCode3) {
    this.clientDefined15CharCode3 = clientDefined15CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code1.
   *
   * @param  clientDefined20CharCode1  String
   */
  public void setClientDefined20CharCode1(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code2.
   *
   * @param  clientDefined20CharCode2  String
   */
  public void setClientDefined20CharCode2(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code3.
   *
   * @param  clientDefined20CharCode3  String
   */
  public void setClientDefined20CharCode3(String clientDefined20CharCode3) {
    this.clientDefined20CharCode3 = clientDefined20CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code4.
   *
   * @param  clientDefined20CharCode4  String
   */
  public void setClientDefined20CharCode4(String clientDefined20CharCode4) {
    this.clientDefined20CharCode4 = clientDefined20CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code5.
   *
   * @param  clientDefined20CharCode5  String
   */
  public void setClientDefined20CharCode5(String clientDefined20CharCode5) {
    this.clientDefined20CharCode5 = clientDefined20CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code1.
   *
   * @param  clientDefined25CharCode1  String
   */
  public void setClientDefined25CharCode1(String clientDefined25CharCode1) {
    this.clientDefined25CharCode1 = clientDefined25CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code2.
   *
   * @param  clientDefined25CharCode2  String
   */
  public void setClientDefined25CharCode2(String clientDefined25CharCode2) {
    this.clientDefined25CharCode2 = clientDefined25CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code3.
   *
   * @param  clientDefined25CharCode3  String
   */
  public void setClientDefined25CharCode3(String clientDefined25CharCode3) {
    this.clientDefined25CharCode3 = clientDefined25CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code1.
   *
   * @param  clientDefined50CharCode1  String
   */
  public void setClientDefined50CharCode1(String clientDefined50CharCode1) {
    this.clientDefined50CharCode1 = clientDefined50CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code10.
   *
   * @param  clientDefined50CharCode10  String
   */
  public void setClientDefined50CharCode10(String clientDefined50CharCode10) {
    this.clientDefined50CharCode10 = clientDefined50CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code11.
   *
   * @param  clientDefined50CharCode11  String
   */
  public void setClientDefined50CharCode11(String clientDefined50CharCode11) {
    this.clientDefined50CharCode11 = clientDefined50CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code12.
   *
   * @param  clientDefined50CharCode12  String
   */
  public void setClientDefined50CharCode12(String clientDefined50CharCode12) {
    this.clientDefined50CharCode12 = clientDefined50CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code13.
   *
   * @param  clientDefined50CharCode13  String
   */
  public void setClientDefined50CharCode13(String clientDefined50CharCode13) {
    this.clientDefined50CharCode13 = clientDefined50CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code14.
   *
   * @param  clientDefined50CharCode14  String
   */
  public void setClientDefined50CharCode14(String clientDefined50CharCode14) {
    this.clientDefined50CharCode14 = clientDefined50CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code15.
   *
   * @param  clientDefined50CharCode15  String
   */
  public void setClientDefined50CharCode15(String clientDefined50CharCode15) {
    this.clientDefined50CharCode15 = clientDefined50CharCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code16.
   *
   * @param  clientDefined50CharCode16  String
   */
  public void setClientDefined50CharCode16(String clientDefined50CharCode16) {
    this.clientDefined50CharCode16 = clientDefined50CharCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code2.
   *
   * @param  clientDefined50CharCode2  String
   */
  public void setClientDefined50CharCode2(String clientDefined50CharCode2) {
    this.clientDefined50CharCode2 = clientDefined50CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code3.
   *
   * @param  clientDefined50CharCode3  String
   */
  public void setClientDefined50CharCode3(String clientDefined50CharCode3) {
    this.clientDefined50CharCode3 = clientDefined50CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code4.
   *
   * @param  clientDefined50CharCode4  String
   */
  public void setClientDefined50CharCode4(String clientDefined50CharCode4) {
    this.clientDefined50CharCode4 = clientDefined50CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code5.
   *
   * @param  clientDefined50CharCode5  String
   */
  public void setClientDefined50CharCode5(String clientDefined50CharCode5) {
    this.clientDefined50CharCode5 = clientDefined50CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code6.
   *
   * @param  clientDefined50CharCode6  String
   */
  public void setClientDefined50CharCode6(String clientDefined50CharCode6) {
    this.clientDefined50CharCode6 = clientDefined50CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code7.
   *
   * @param  clientDefined50CharCode7  String
   */
  public void setClientDefined50CharCode7(String clientDefined50CharCode7) {
    this.clientDefined50CharCode7 = clientDefined50CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code8.
   *
   * @param  clientDefined50CharCode8  String
   */
  public void setClientDefined50CharCode8(String clientDefined50CharCode8) {
    this.clientDefined50CharCode8 = clientDefined50CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined50 char code9.
   *
   * @param  clientDefined50CharCode9  String
   */
  public void setClientDefined50CharCode9(String clientDefined50CharCode9) {
    this.clientDefined50CharCode9 = clientDefined50CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code1.
   *
   * @param  clientDefined5CharCode1  String
   */
  public void setClientDefined5CharCode1(String clientDefined5CharCode1) {
    this.clientDefined5CharCode1 = clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code2.
   *
   * @param  clientDefined5CharCode2  String
   */
  public void setClientDefined5CharCode2(String clientDefined5CharCode2) {
    this.clientDefined5CharCode2 = clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code3.
   *
   * @param  clientDefined5CharCode3  String
   */
  public void setClientDefined5CharCode3(String clientDefined5CharCode3) {
    this.clientDefined5CharCode3 = clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code1.
   *
   * @param  clientDefined80CharCode1  String
   */
  public void setClientDefined80CharCode1(String clientDefined80CharCode1) {
    this.clientDefined80CharCode1 = clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date2.
   *
   * @param  clientDefinedDate2  Date
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date3.
   *
   * @param  clientDefinedDate3  Date
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date4.
   *
   * @param  clientDefinedDate4  Date
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date5.
   *
   * @param  clientDefinedDate5  Date
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date6.
   *
   * @param  clientDefinedDate6  Date
   */
  public void setClientDefinedDate6(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal3.
   *
   * @param  clientDefinedDecimal3  BigDecimal
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  String
   */
  public void setClientDefinedFlag1(String clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  String
   */
  public void setClientDefinedFlag2(String clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag3.
   *
   * @param  clientDefinedFlag3  String
   */
  public void setClientDefinedFlag3(String clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag4.
   *
   * @param  clientDefinedFlag4  String
   */
  public void setClientDefinedFlag4(String clientDefinedFlag4) {
    this.clientDefinedFlag4 = clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag5.
   *
   * @param  clientDefinedFlag5  String
   */
  public void setClientDefinedFlag5(String clientDefinedFlag5) {
    this.clientDefinedFlag5 = clientDefinedFlag5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag6.
   *
   * @param  clientDefinedFlag6  String
   */
  public void setClientDefinedFlag6(String clientDefinedFlag6) {
    this.clientDefinedFlag6 = clientDefinedFlag6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer1.
   *
   * @param  clientDefinedInteger1  Integer
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer2.
   *
   * @param  clientDefinedInteger2  Integer
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer3.
   *
   * @param  clientDefinedInteger3  Integer
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string1.
   *
   * @param  clientDefinedString1  String
   */
  public void setClientDefinedString1(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string2.
   *
   * @param  clientDefinedString2  String
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string3.
   *
   * @param  clientDefinedString3  String
   */
  public void setClientDefinedString3(String clientDefinedString3) {
    this.clientDefinedString3 = clientDefinedString3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client reference id.
   *
   * @param  clientReferenceId  String
   */
  public void setClientReferenceId(String clientReferenceId) {
    this.clientReferenceId = clientReferenceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer address1.
   *
   * @param  employerAddress1  String
   */
  public void setEmployerAddress1(String employerAddress1) {
    this.employerAddress1 = employerAddress1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer address2.
   *
   * @param  employerAddress2  String
   */
  public void setEmployerAddress2(String employerAddress2) {
    this.employerAddress2 = employerAddress2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer address3.
   *
   * @param  employerAddress3  String
   */
  public void setEmployerAddress3(String employerAddress3) {
    this.employerAddress3 = employerAddress3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer city.
   *
   * @param  employerCity  String
   */
  public void setEmployerCity(String employerCity) {
    this.employerCity = employerCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer country.
   *
   * @param  employerCountry  String
   */
  public void setEmployerCountry(String employerCountry) {
    this.employerCountry = employerCountry;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer email address.
   *
   * @param  employerEmailAddress  String
   */
  public void setEmployerEmailAddress(String employerEmailAddress) {
    this.employerEmailAddress = employerEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer fax num.
   *
   * @param  employerFaxNum  String
   */
  public void setEmployerFaxNum(String employerFaxNum) {
    this.employerFaxNum = employerFaxNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer mobile phone num.
   *
   * @param  employerMobilePhoneNum  String
   */
  public void setEmployerMobilePhoneNum(String employerMobilePhoneNum) {
    this.employerMobilePhoneNum = employerMobilePhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer phone num1.
   *
   * @param  employerPhoneNum1  String
   */
  public void setEmployerPhoneNum1(String employerPhoneNum1) {
    this.employerPhoneNum1 = employerPhoneNum1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer phone num2.
   *
   * @param  employerPhoneNum2  String
   */
  public void setEmployerPhoneNum2(String employerPhoneNum2) {
    this.employerPhoneNum2 = employerPhoneNum2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer postal code.
   *
   * @param  employerPostalCode  String
   */
  public void setEmployerPostalCode(String employerPostalCode) {
    this.employerPostalCode = employerPostalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer province.
   *
   * @param  employerProvince  String
   */
  public void setEmployerProvince(String employerProvince) {
    this.employerProvince = employerProvince;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for job code.
   *
   * @param  jobCode  Integer
   */
  public void setJobCode(Integer jobCode) {
    this.jobCode = jobCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for language code.
   *
   * @param  languageCode  String
   */
  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail code.
   *
   * @param  mailCode  String
   */
  public void setMailCode(String mailCode) {
    this.mailCode = mailCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for marital status.
   *
   * @param  maritalStatus  String
   */
  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for occupation.
   *
   * @param  occupation  String
   */
  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible detail id.
   *
   * @param  responsibleDetailId  Long
   */
  public void setResponsibleDetailId(Long responsibleDetailId) {
    this.responsibleDetailId = responsibleDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for slm forbearence forms.
   *
   * @param  slmForbearenceForms  Set
   */
  public void setSlmForbearenceForms(Set<SlmEsignatureForm> slmForbearenceForms) {
    this.slmForbearenceForms = slmForbearenceForms;
  }

  public String getPreferredLanguageCode() {
    if (StringUtils.hasText(preferredLanguageCode)) {
      return preferredLanguageCodeMap.get(preferredLanguageCode);
    }

    return "EN";
  }

  public void setPreferredLanguageCode(String preferredLanguageCode) {
    this.preferredLanguageCode = preferredLanguageCode;
  }
} // end class ResponsibleDetail
