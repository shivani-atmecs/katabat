package com.cmc.credagility.core.domain.customer;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/07/2015 13:46
 */
@Entity
@Table(name = "CustomerAdditionalDetail")
public class CustomerAdditionalDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4471815709015673098L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate3;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate4;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate5;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate6;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate7")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate7;

  // SMW-1787
  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate8")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate8;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate9")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate9;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDecimal1")
  protected BigDecimal clientDefinedDecimal1;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDecimal2")
  protected BigDecimal clientDefinedDecimal2;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedDecimal3")
  protected BigDecimal clientDefinedDecimal3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag1",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag2",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag3",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag4",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "clientDefinedFlag5",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean clientDefinedFlag5;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger1")
  protected Integer clientDefinedInteger1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger10")
  protected Integer clientDefinedInteger10;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger11")
  protected Integer clientDefinedInteger11;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger12")
  protected Integer clientDefinedInteger12;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger13")
  protected Integer clientDefinedInteger13;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger14")
  protected Integer clientDefinedInteger14;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger15")
  protected Integer clientDefinedInteger15;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger16")
  protected Integer clientDefinedInteger16;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger17")
  protected Integer clientDefinedInteger17;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger18")
  protected Integer clientDefinedInteger18;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger19")
  protected Integer clientDefinedInteger19;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger2")
  protected Integer clientDefinedInteger2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger20")
  protected Integer clientDefinedInteger20;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger21")
  protected Integer clientDefinedInteger21;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger22")
  protected Integer clientDefinedInteger22;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger23")
  protected Integer clientDefinedInteger23;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger24")
  protected Integer clientDefinedInteger24;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger25")
  protected Integer clientDefinedInteger25;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger26")
  protected Integer clientDefinedInteger26;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedInteger27")
  protected Integer clientDefinedInteger27;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger3")
  protected Integer clientDefinedInteger3;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger4")
  protected Integer clientDefinedInteger4;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger5")
  protected Integer clientDefinedInteger5;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger6")
  protected Integer clientDefinedInteger6;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger7")
  protected Integer clientDefinedInteger7;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger8")
  protected Integer clientDefinedInteger8;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedInteger9")
  protected Integer clientDefinedInteger9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString1",
    length = 255
  )
  protected String clientDefinedString1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString10",
    length = 255
  )
  protected String clientDefinedString10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString11",
    length = 255
  )
  protected String clientDefinedString11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString12",
    length = 255
  )
  protected String clientDefinedString12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString13",
    length = 255
  )
  protected String clientDefinedString13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString14",
    length = 255
  )
  protected String clientDefinedString14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString15",
    length = 255
  )
  protected String clientDefinedString15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString16",
    length = 255
  )
  protected String clientDefinedString16;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString17")
  protected String clientDefinedString17;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString18")
  protected String clientDefinedString18;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString19")
  protected String clientDefinedString19;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString2",
    length = 255
  )
  protected String clientDefinedString2;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString20")
  protected String clientDefinedString20;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString21")
  protected String clientDefinedString21;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString22")
  protected String clientDefinedString22;

  /** DOCUMENT ME! */
  @Column(name = "clientDefinedString23")
  protected String clientDefinedString23;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString3",
    length = 255
  )
  protected String clientDefinedString3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString4",
    length = 255
  )
  protected String clientDefinedString4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString5",
    length = 255
  )
  protected String clientDefinedString5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString6",
    length = 255
  )
  protected String clientDefinedString6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString7",
    length = 255
  )
  protected String clientDefinedString7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString8",
    length = 255
  )
  protected String clientDefinedString8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientDefinedString9",
    length = 255
  )
  protected String clientDefinedString9;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @OneToOne protected Customer customer;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "customerAdditionalDetailId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customerAdditionalDetailId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "loanInServiceCenter",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean loanInServiceCenter;

  @Column(
    name   = "clientDefinedEncryptedField1",
    length = 150
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String clientDefinedEncryptedField1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    CustomerAdditionalDetail that = (CustomerAdditionalDetail) o;

    if ((clientDefinedDate1 != null) ? (!clientDefinedDate1.equals(that.clientDefinedDate1))
                                     : (that.clientDefinedDate1 != null)) {
      return false;
    }

    if ((clientDefinedDate2 != null) ? (!clientDefinedDate2.equals(that.clientDefinedDate2))
                                     : (that.clientDefinedDate2 != null)) {
      return false;
    }

    if ((clientDefinedDate3 != null) ? (!clientDefinedDate3.equals(that.clientDefinedDate3))
                                     : (that.clientDefinedDate3 != null)) {
      return false;
    }

    if ((clientDefinedDate4 != null) ? (!clientDefinedDate4.equals(that.clientDefinedDate4))
                                     : (that.clientDefinedDate4 != null)) {
      return false;
    }

    if ((clientDefinedDate5 != null) ? (!clientDefinedDate5.equals(that.clientDefinedDate5))
                                     : (that.clientDefinedDate5 != null)) {
      return false;
    }

    if ((clientDefinedDate6 != null) ? (!clientDefinedDate6.equals(that.clientDefinedDate6))
                                     : (that.clientDefinedDate6 != null)) {
      return false;
    }

    if ((clientDefinedDate7 != null) ? (!clientDefinedDate7.equals(that.clientDefinedDate7))
                                     : (that.clientDefinedDate7 != null)) {
      return false;
    }

    if ((clientDefinedFlag1 != null) ? (!clientDefinedFlag1.equals(that.clientDefinedFlag1))
                                     : (that.clientDefinedFlag1 != null)) {
      return false;
    }

    if ((clientDefinedFlag2 != null) ? (!clientDefinedFlag2.equals(that.clientDefinedFlag2))
                                     : (that.clientDefinedFlag2 != null)) {
      return false;
    }

    if ((clientDefinedFlag3 != null) ? (!clientDefinedFlag3.equals(that.clientDefinedFlag3))
                                     : (that.clientDefinedFlag3 != null)) {
      return false;
    }

    if ((clientDefinedFlag4 != null) ? (!clientDefinedFlag4.equals(that.clientDefinedFlag4))
                                     : (that.clientDefinedFlag4 != null)) {
      return false;
    }

    if ((clientDefinedFlag5 != null) ? (!clientDefinedFlag5.equals(that.clientDefinedFlag5))
                                     : (that.clientDefinedFlag5 != null)) {
      return false;
    }

    if ((clientDefinedInteger1 != null) ? (!clientDefinedInteger1.equals(that.clientDefinedInteger1))
                                        : (that.clientDefinedInteger1 != null)) {
      return false;
    }

    if ((clientDefinedInteger10 != null) ? (!clientDefinedInteger10.equals(that.clientDefinedInteger10))
                                         : (that.clientDefinedInteger10 != null)) {
      return false;
    }

    if ((clientDefinedInteger11 != null) ? (!clientDefinedInteger11.equals(that.clientDefinedInteger11))
                                         : (that.clientDefinedInteger11 != null)) {
      return false;
    }

    if ((clientDefinedInteger12 != null) ? (!clientDefinedInteger12.equals(that.clientDefinedInteger12))
                                         : (that.clientDefinedInteger12 != null)) {
      return false;
    }

    if ((clientDefinedInteger13 != null) ? (!clientDefinedInteger13.equals(that.clientDefinedInteger13))
                                         : (that.clientDefinedInteger13 != null)) {
      return false;
    }

    if ((clientDefinedInteger14 != null) ? (!clientDefinedInteger14.equals(that.clientDefinedInteger14))
                                         : (that.clientDefinedInteger14 != null)) {
      return false;
    }

    if ((clientDefinedInteger15 != null) ? (!clientDefinedInteger15.equals(that.clientDefinedInteger15))
                                         : (that.clientDefinedInteger15 != null)) {
      return false;
    }

    if ((clientDefinedInteger16 != null) ? (!clientDefinedInteger16.equals(that.clientDefinedInteger16))
                                         : (that.clientDefinedInteger16 != null)) {
      return false;
    }

    if ((clientDefinedInteger17 != null) ? (!clientDefinedInteger17.equals(that.clientDefinedInteger17))
                                         : (that.clientDefinedInteger17 != null)) {
      return false;
    }

    if ((clientDefinedInteger18 != null) ? (!clientDefinedInteger18.equals(that.clientDefinedInteger18))
                                         : (that.clientDefinedInteger18 != null)) {
      return false;
    }

    if ((clientDefinedInteger19 != null) ? (!clientDefinedInteger19.equals(that.clientDefinedInteger19))
                                         : (that.clientDefinedInteger19 != null)) {
      return false;
    }

    if ((clientDefinedInteger2 != null) ? (!clientDefinedInteger2.equals(that.clientDefinedInteger2))
                                        : (that.clientDefinedInteger2 != null)) {
      return false;
    }

    if ((clientDefinedInteger20 != null) ? (!clientDefinedInteger20.equals(that.clientDefinedInteger20))
                                         : (that.clientDefinedInteger20 != null)) {
      return false;
    }

    if ((clientDefinedInteger3 != null) ? (!clientDefinedInteger3.equals(that.clientDefinedInteger3))
                                        : (that.clientDefinedInteger3 != null)) {
      return false;
    }

    if ((clientDefinedInteger4 != null) ? (!clientDefinedInteger4.equals(that.clientDefinedInteger4))
                                        : (that.clientDefinedInteger4 != null)) {
      return false;
    }

    if ((clientDefinedInteger5 != null) ? (!clientDefinedInteger5.equals(that.clientDefinedInteger5))
                                        : (that.clientDefinedInteger5 != null)) {
      return false;
    }

    if ((clientDefinedInteger6 != null) ? (!clientDefinedInteger6.equals(that.clientDefinedInteger6))
                                        : (that.clientDefinedInteger6 != null)) {
      return false;
    }

    if ((clientDefinedInteger7 != null) ? (!clientDefinedInteger7.equals(that.clientDefinedInteger7))
                                        : (that.clientDefinedInteger7 != null)) {
      return false;
    }

    if ((clientDefinedInteger8 != null) ? (!clientDefinedInteger8.equals(that.clientDefinedInteger8))
                                        : (that.clientDefinedInteger8 != null)) {
      return false;
    }

    if ((clientDefinedInteger9 != null) ? (!clientDefinedInteger9.equals(that.clientDefinedInteger9))
                                        : (that.clientDefinedInteger9 != null)) {
      return false;
    }

    if ((clientDefinedString1 != null) ? (!clientDefinedString1.equals(that.clientDefinedString1))
                                       : (that.clientDefinedString1 != null)) {
      return false;
    }

    if ((clientDefinedString10 != null) ? (!clientDefinedString10.equals(that.clientDefinedString10))
                                        : (that.clientDefinedString10 != null)) {
      return false;
    }

    if ((clientDefinedString11 != null) ? (!clientDefinedString11.equals(that.clientDefinedString11))
                                        : (that.clientDefinedString11 != null)) {
      return false;
    }

    if ((clientDefinedString12 != null) ? (!clientDefinedString12.equals(that.clientDefinedString12))
                                        : (that.clientDefinedString12 != null)) {
      return false;
    }

    if ((clientDefinedString13 != null) ? (!clientDefinedString13.equals(that.clientDefinedString13))
                                        : (that.clientDefinedString13 != null)) {
      return false;
    }

    if ((clientDefinedString14 != null) ? (!clientDefinedString14.equals(that.clientDefinedString14))
                                        : (that.clientDefinedString14 != null)) {
      return false;
    }

    if ((clientDefinedString15 != null) ? (!clientDefinedString15.equals(that.clientDefinedString15))
                                        : (that.clientDefinedString15 != null)) {
      return false;
    }

    if ((clientDefinedString16 != null) ? (!clientDefinedString16.equals(that.clientDefinedString16))
                                        : (that.clientDefinedString16 != null)) {
      return false;
    }

    if ((clientDefinedString2 != null) ? (!clientDefinedString2.equals(that.clientDefinedString2))
                                       : (that.clientDefinedString2 != null)) {
      return false;
    }

    if ((clientDefinedString3 != null) ? (!clientDefinedString3.equals(that.clientDefinedString3))
                                       : (that.clientDefinedString3 != null)) {
      return false;
    }

    if ((clientDefinedString4 != null) ? (!clientDefinedString4.equals(that.clientDefinedString4))
                                       : (that.clientDefinedString4 != null)) {
      return false;
    }

    if ((clientDefinedString5 != null) ? (!clientDefinedString5.equals(that.clientDefinedString5))
                                       : (that.clientDefinedString5 != null)) {
      return false;
    }

    if ((clientDefinedString6 != null) ? (!clientDefinedString6.equals(that.clientDefinedString6))
                                       : (that.clientDefinedString6 != null)) {
      return false;
    }

    if ((clientDefinedString7 != null) ? (!clientDefinedString7.equals(that.clientDefinedString7))
                                       : (that.clientDefinedString7 != null)) {
      return false;
    }

    if ((clientDefinedString8 != null) ? (!clientDefinedString8.equals(that.clientDefinedString8))
                                       : (that.clientDefinedString8 != null)) {
      return false;
    }

    if ((clientDefinedString9 != null) ? (!clientDefinedString9.equals(that.clientDefinedString9))
                                       : (that.clientDefinedString9 != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((customerAdditionalDetailId != null) ? (!customerAdditionalDetailId.equals(that.customerAdditionalDetailId))
                                             : (that.customerAdditionalDetailId != null)) {
      return false;
    }


    if ((loanInServiceCenter != null) ? (!loanInServiceCenter.equals(that.loanInServiceCenter))
                                      : (that.loanInServiceCenter != null)) {
      return false;
    }

    if ((clientDefinedDate8 != null) ? (!clientDefinedDate8.equals(that.clientDefinedDate8))
                                     : (that.clientDefinedDate8 != null)) {
      return false;
    }

    if ((clientDefinedDate9 != null) ? (!clientDefinedDate9.equals(that.clientDefinedDate9))
                                     : (that.clientDefinedDate9 != null)) {
      return false;
    }

    if ((clientDefinedDecimal1 != null) ? (!clientDefinedDecimal1.equals(that.clientDefinedDecimal1))
                                        : (that.clientDefinedDecimal1 != null)) {
      return false;
    }

    if ((clientDefinedDecimal2 != null) ? (!clientDefinedDecimal2.equals(that.clientDefinedDecimal2))
                                        : (that.clientDefinedDecimal2 != null)) {
      return false;
    }

    if ((clientDefinedDecimal3 != null) ? (!clientDefinedDecimal3.equals(that.clientDefinedDecimal3))
                                        : (that.clientDefinedDecimal3 != null)) {
      return false;
    }

    if ((clientDefinedString17 != null) ? (!clientDefinedString17.equals(that.clientDefinedString17))
                                        : (that.clientDefinedString17 != null)) {
      return false;
    }

    if ((clientDefinedString18 != null) ? (!clientDefinedString18.equals(that.clientDefinedString18))
                                        : (that.clientDefinedString18 != null)) {
      return false;
    }

    if ((clientDefinedString19 != null) ? (!clientDefinedString19.equals(that.clientDefinedString19))
                                        : (that.clientDefinedString19 != null)) {
      return false;
    }

    if ((clientDefinedString20 != null) ? (!clientDefinedString20.equals(that.clientDefinedString20))
                                        : (that.clientDefinedString20 != null)) {
      return false;
    }

    if ((clientDefinedString21 != null) ? (!clientDefinedString21.equals(that.clientDefinedString21))
                                        : (that.clientDefinedString21 != null)) {
      return false;
    }

    if ((clientDefinedString22 != null) ? (!clientDefinedString22.equals(that.clientDefinedString22))
                                        : (that.clientDefinedString22 != null)) {
      return false;
    }

    if ((clientDefinedString23 != null) ? (!clientDefinedString23.equals(that.clientDefinedString23))
                                        : (that.clientDefinedString23 != null)) {
      return false;
    }

    if ((clientDefinedInteger21 != null) ? (!clientDefinedInteger21.equals(that.clientDefinedInteger21))
                                         : (that.clientDefinedInteger21 != null)) {
      return false;
    }

    if ((clientDefinedInteger22 != null) ? (!clientDefinedInteger22.equals(that.clientDefinedInteger22))
                                         : (that.clientDefinedInteger22 != null)) {
      return false;
    }

    if ((clientDefinedInteger23 != null) ? (!clientDefinedInteger23.equals(that.clientDefinedInteger23))
                                         : (that.clientDefinedInteger23 != null)) {
      return false;
    }

    if ((clientDefinedInteger24 != null) ? (!clientDefinedInteger24.equals(that.clientDefinedInteger24))
                                         : (that.clientDefinedInteger24 != null)) {
      return false;
    }

    if ((clientDefinedInteger25 != null) ? (!clientDefinedInteger25.equals(that.clientDefinedInteger25))
                                         : (that.clientDefinedInteger25 != null)) {
      return false;
    }

    if ((clientDefinedInteger26 != null) ? (!clientDefinedInteger26.equals(that.clientDefinedInteger26))
                                         : (that.clientDefinedInteger26 != null)) {
      return false;
    }

    if ((clientDefinedInteger27 != null) ? (!clientDefinedInteger27.equals(that.clientDefinedInteger27))
                                         : (that.clientDefinedInteger27 != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate6() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getClientDefinedDate7() {
    return clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date8.
   *
   * @return  Date
   */
  public Date getClientDefinedDate8() {
    return clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date9.
   *
   * @return  Date
   */
  public Date getClientDefinedDate9() {
    return clientDefinedDate9;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedEncryptedField1() {
    return clientDefinedEncryptedField1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getClientDefinedFlag3() {
    return clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getClientDefinedFlag4() {
    return clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getClientDefinedFlag5() {
    return clientDefinedFlag5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger10() {
    return clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger11() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger12() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger13() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger14() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger15() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger16() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger17() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger18() {
    return clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger19() {
    return clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger20() {
    return clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer21.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger21() {
    return clientDefinedInteger21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger22() {
    return clientDefinedInteger22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger23() {
    return clientDefinedInteger23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger24() {
    return clientDefinedInteger24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger25() {
    return clientDefinedInteger25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger26() {
    return clientDefinedInteger26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger27() {
    return clientDefinedInteger27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger8() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getClientDefinedInteger9() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString11() {
    return clientDefinedString11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString12() {
    return clientDefinedString12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString13() {
    return clientDefinedString13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString14() {
    return clientDefinedString14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString15() {
    return clientDefinedString15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString16() {
    return clientDefinedString16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string17.
   *
   * @return  String
   */
  public String getClientDefinedString17() {
    return clientDefinedString17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string18.
   *
   * @return  String
   */
  public String getClientDefinedString18() {
    return clientDefinedString18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString19() {
    return clientDefinedString19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString20() {
    return clientDefinedString20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString21() {
    return clientDefinedString21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString22() {
    return clientDefinedString22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedString23() {
    return clientDefinedString23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCustomerAdditionalDetailId() {
    return customerAdditionalDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getLoanInServiceCenter() {
    if (loanInServiceCenter == null) {
      return Boolean.FALSE;
    }

    return loanInServiceCenter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((clientDefinedDate1 != null) ? clientDefinedDate1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate2 != null) ? clientDefinedDate2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate3 != null) ? clientDefinedDate3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate4 != null) ? clientDefinedDate4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate5 != null) ? clientDefinedDate5.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate6 != null) ? clientDefinedDate6.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate7 != null) ? clientDefinedDate7.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag1 != null) ? clientDefinedFlag1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag2 != null) ? clientDefinedFlag2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag3 != null) ? clientDefinedFlag3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag4 != null) ? clientDefinedFlag4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag5 != null) ? clientDefinedFlag5.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger1 != null) ? clientDefinedInteger1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger10 != null) ? clientDefinedInteger10.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger11 != null) ? clientDefinedInteger11.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger12 != null) ? clientDefinedInteger12.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger13 != null) ? clientDefinedInteger13.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger14 != null) ? clientDefinedInteger14.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger15 != null) ? clientDefinedInteger15.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger16 != null) ? clientDefinedInteger16.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger17 != null) ? clientDefinedInteger17.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger18 != null) ? clientDefinedInteger18.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger19 != null) ? clientDefinedInteger19.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger2 != null) ? clientDefinedInteger2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger20 != null) ? clientDefinedInteger20.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger3 != null) ? clientDefinedInteger3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger4 != null) ? clientDefinedInteger4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger5 != null) ? clientDefinedInteger5.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger6 != null) ? clientDefinedInteger6.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger7 != null) ? clientDefinedInteger7.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger8 != null) ? clientDefinedInteger8.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger9 != null) ? clientDefinedInteger9.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString1 != null) ? clientDefinedString1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString10 != null) ? clientDefinedString10.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString11 != null) ? clientDefinedString11.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString12 != null) ? clientDefinedString12.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString13 != null) ? clientDefinedString13.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString14 != null) ? clientDefinedString14.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString15 != null) ? clientDefinedString15.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString16 != null) ? clientDefinedString16.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString2 != null) ? clientDefinedString2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString3 != null) ? clientDefinedString3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString4 != null) ? clientDefinedString4.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString5 != null) ? clientDefinedString5.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString6 != null) ? clientDefinedString6.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString7 != null) ? clientDefinedString7.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString8 != null) ? clientDefinedString8.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString9 != null) ? clientDefinedString9.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((customerAdditionalDetailId != null) ? customerAdditionalDetailId.hashCode() : 0);

    result = (31 * result) + ((loanInServiceCenter != null) ? loanInServiceCenter.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate8 != null) ? clientDefinedDate8.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate9 != null) ? clientDefinedDate9.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal1 != null) ? clientDefinedDecimal1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal2 != null) ? clientDefinedDecimal2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal3 != null) ? clientDefinedDecimal3.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString17 != null) ? clientDefinedString17.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString18 != null) ? clientDefinedString18.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString19 != null) ? clientDefinedString19.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString20 != null) ? clientDefinedString20.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString21 != null) ? clientDefinedString21.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString22 != null) ? clientDefinedString22.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString23 != null) ? clientDefinedString23.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger21 != null) ? clientDefinedInteger21.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger22 != null) ? clientDefinedInteger22.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger23 != null) ? clientDefinedInteger23.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger24 != null) ? clientDefinedInteger24.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger25 != null) ? clientDefinedInteger25.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger26 != null) ? clientDefinedInteger26.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger27 != null) ? clientDefinedInteger27.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate1  DOCUMENT ME!
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate2  DOCUMENT ME!
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate3  DOCUMENT ME!
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate4  DOCUMENT ME!
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate5  DOCUMENT ME!
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate6  DOCUMENT ME!
   */
  public void setClientDefinedDate6(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedDate7  DOCUMENT ME!
   */
  public void setClientDefinedDate7(Date clientDefinedDate7) {
    this.clientDefinedDate7 = clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date8.
   *
   * @param  clientDefinedDate8  Date
   */
  public void setClientDefinedDate8(Date clientDefinedDate8) {
    this.clientDefinedDate8 = clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date9.
   *
   * @param  clientDefinedDate9  Date
   */
  public void setClientDefinedDate9(Date clientDefinedDate9) {
    this.clientDefinedDate9 = clientDefinedDate9;
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
   * DOCUMENT ME!
   *
   * @param  clientDefinedEncryptedField1  DOCUMENT ME!
   */
  public void setClientDefinedEncryptedField1(String clientDefinedEncryptedField1) {
    this.clientDefinedEncryptedField1 = clientDefinedEncryptedField1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag1  DOCUMENT ME!
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag2  DOCUMENT ME!
   */
  public void setClientDefinedFlag2(Boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag3  DOCUMENT ME!
   */
  public void setClientDefinedFlag3(Boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag4  DOCUMENT ME!
   */
  public void setClientDefinedFlag4(Boolean clientDefinedFlag4) {
    this.clientDefinedFlag4 = clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedFlag5  DOCUMENT ME!
   */
  public void setClientDefinedFlag5(Boolean clientDefinedFlag5) {
    this.clientDefinedFlag5 = clientDefinedFlag5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger1  DOCUMENT ME!
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger10  DOCUMENT ME!
   */
  public void setClientDefinedInteger10(Integer clientDefinedInteger10) {
    this.clientDefinedInteger10 = clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger11  DOCUMENT ME!
   */
  public void setClientDefinedInteger11(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger12  DOCUMENT ME!
   */
  public void setClientDefinedInteger12(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger13  DOCUMENT ME!
   */
  public void setClientDefinedInteger13(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger14  DOCUMENT ME!
   */
  public void setClientDefinedInteger14(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger15  DOCUMENT ME!
   */
  public void setClientDefinedInteger15(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger16  DOCUMENT ME!
   */
  public void setClientDefinedInteger16(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger17  DOCUMENT ME!
   */
  public void setClientDefinedInteger17(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger18  DOCUMENT ME!
   */
  public void setClientDefinedInteger18(Integer clientDefinedInteger18) {
    this.clientDefinedInteger18 = clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger19  DOCUMENT ME!
   */
  public void setClientDefinedInteger19(Integer clientDefinedInteger19) {
    this.clientDefinedInteger19 = clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger2  DOCUMENT ME!
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger20  DOCUMENT ME!
   */
  public void setClientDefinedInteger20(Integer clientDefinedInteger20) {
    this.clientDefinedInteger20 = clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer21.
   *
   * @param  clientDefinedInteger21  Integer
   */
  public void setClientDefinedInteger21(Integer clientDefinedInteger21) {
    this.clientDefinedInteger21 = clientDefinedInteger21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger22  DOCUMENT ME!
   */
  public void setClientDefinedInteger22(Integer clientDefinedInteger22) {
    this.clientDefinedInteger22 = clientDefinedInteger22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger23  DOCUMENT ME!
   */
  public void setClientDefinedInteger23(Integer clientDefinedInteger23) {
    this.clientDefinedInteger23 = clientDefinedInteger23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger24  DOCUMENT ME!
   */
  public void setClientDefinedInteger24(Integer clientDefinedInteger24) {
    this.clientDefinedInteger24 = clientDefinedInteger24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger25  DOCUMENT ME!
   */
  public void setClientDefinedInteger25(Integer clientDefinedInteger25) {
    this.clientDefinedInteger25 = clientDefinedInteger25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger26  DOCUMENT ME!
   */
  public void setClientDefinedInteger26(Integer clientDefinedInteger26) {
    this.clientDefinedInteger26 = clientDefinedInteger26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger27  DOCUMENT ME!
   */
  public void setClientDefinedInteger27(Integer clientDefinedInteger27) {
    this.clientDefinedInteger27 = clientDefinedInteger27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger3  DOCUMENT ME!
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger4  DOCUMENT ME!
   */
  public void setClientDefinedInteger4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger5  DOCUMENT ME!
   */
  public void setClientDefinedInteger5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger6  DOCUMENT ME!
   */
  public void setClientDefinedInteger6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger7  DOCUMENT ME!
   */
  public void setClientDefinedInteger7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger8  DOCUMENT ME!
   */
  public void setClientDefinedInteger8(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedInteger9  DOCUMENT ME!
   */
  public void setClientDefinedInteger9(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString11  DOCUMENT ME!
   */
  public void setClientDefinedString11(String clientDefinedString11) {
    this.clientDefinedString11 = clientDefinedString11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString12  DOCUMENT ME!
   */
  public void setClientDefinedString12(String clientDefinedString12) {
    this.clientDefinedString12 = clientDefinedString12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString13  DOCUMENT ME!
   */
  public void setClientDefinedString13(String clientDefinedString13) {
    this.clientDefinedString13 = clientDefinedString13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString14  DOCUMENT ME!
   */
  public void setClientDefinedString14(String clientDefinedString14) {
    this.clientDefinedString14 = clientDefinedString14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString15  DOCUMENT ME!
   */
  public void setClientDefinedString15(String clientDefinedString15) {
    this.clientDefinedString15 = clientDefinedString15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString16  DOCUMENT ME!
   */
  public void setClientDefinedString16(String clientDefinedString16) {
    this.clientDefinedString16 = clientDefinedString16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string17.
   *
   * @param  clientDefinedString17  String
   */
  public void setClientDefinedString17(String clientDefinedString17) {
    this.clientDefinedString17 = clientDefinedString17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string18.
   *
   * @param  clientDefinedString18  String
   */
  public void setClientDefinedString18(String clientDefinedString18) {
    this.clientDefinedString18 = clientDefinedString18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString19  DOCUMENT ME!
   */
  public void setClientDefinedString19(String clientDefinedString19) {
    this.clientDefinedString19 = clientDefinedString19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString2  DOCUMENT ME!
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString20  DOCUMENT ME!
   */
  public void setClientDefinedString20(String clientDefinedString20) {
    this.clientDefinedString20 = clientDefinedString20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString21  DOCUMENT ME!
   */
  public void setClientDefinedString21(String clientDefinedString21) {
    this.clientDefinedString21 = clientDefinedString21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString22  DOCUMENT ME!
   */
  public void setClientDefinedString22(String clientDefinedString22) {
    this.clientDefinedString22 = clientDefinedString22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedString23  DOCUMENT ME!
   */
  public void setClientDefinedString23(String clientDefinedString23) {
    this.clientDefinedString23 = clientDefinedString23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

  /**
   * DOCUMENT ME!
   *
   * @param  customer  DOCUMENT ME!
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerAdditionalDetailId  DOCUMENT ME!
   */
  public void setCustomerAdditionalDetailId(Long customerAdditionalDetailId) {
    this.customerAdditionalDetailId = customerAdditionalDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loanInServiceCenter  DOCUMENT ME!
   */
  public void setLoanInServiceCenter(Boolean loanInServiceCenter) {
    this.loanInServiceCenter = loanInServiceCenter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "CustomerAdditionalDetail{"
      + ", customerAdditionalDetailId=" + customerAdditionalDetailId
      + '}';
  }
} // end class CustomerAdditionalDetail
