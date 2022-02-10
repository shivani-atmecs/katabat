package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * This class can be used to store Account related information just like we are using AccountDetail table.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 16:35
 */
@Entity
@Table(
  name    = "AccountAdditionalDetail",
  indexes = {
    @Index(
      name = "indx_clientDefinedString1",
      columnList = "clientDefinedString1"
    )
  }
)
public class AccountAdditionalDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8316677445620060171L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = CascadeType.ALL)
  protected Account account;

  /** Account Additional Detail id PK. */
  /** AccountAdditionalDetail id PK. */
  @Column(
    name     = "accountAdditionalDetailId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountAdditionalDetailId;

  @Column(
    name   = "clientDefined10CharCode1",
    length = 10
  )
  private String clientDefined10CharCode1;
  @Column(
    name   = "clientDefined10CharCode10",
    length = 10
  )
  private String clientDefined10CharCode10;
  @Column(
    name   = "clientDefined10CharCode11",
    length = 10
  )
  private String clientDefined10CharCode11;
  @Column(
    name   = "clientDefined10CharCode12",
    length = 10
  )
  private String clientDefined10CharCode12;
  @Column(
    name   = "clientDefined10CharCode13",
    length = 10
  )
  private String clientDefined10CharCode13;
  @Column(
    name   = "clientDefined10CharCode14",
    length = 10
  )
  private String clientDefined10CharCode14;

  @Column(
    name   = "clientDefined10CharCode15",
    length = 10
  )
  private String clientDefined10CharCode15;
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
    name   = "clientDefined10CharCode4",
    length = 10
  )
  private String clientDefined10CharCode4;
  @Column(
    name   = "clientDefined10CharCode5",
    length = 10
  )
  private String clientDefined10CharCode5;
  @Column(
    name   = "clientDefined10CharCode6",
    length = 10
  )
  private String clientDefined10CharCode6;
  @Column(
    name   = "clientDefined10CharCode7",
    length = 10
  )
  private String clientDefined10CharCode7;
  @Column(
    name   = "clientDefined10CharCode8",
    length = 10
  )
  private String clientDefined10CharCode8;
  @Column(
    name   = "clientDefined10CharCode9",
    length = 10
  )
  private String clientDefined10CharCode9;

  @Column(
    name   = "clientDefined15CharCode1",
    length = 15
  )
  private String clientDefined15CharCode1;
  @Column(
    name   = "clientDefined15CharCode10",
    length = 15
  )
  private String clientDefined15CharCode10;

  @Column(
    name   = "clientDefined15CharCode11",
    length = 15
  )
  private String clientDefined15CharCode11;

  @Column(
    name   = "clientDefined15CharCode12",
    length = 15
  )
  private String clientDefined15CharCode12;

  @Column(
    name   = "clientDefined15CharCode13",
    length = 15
  )
  private String clientDefined15CharCode13;

  @Column(
    name   = "clientDefined15CharCode14",
    length = 15
  )
  private String clientDefined15CharCode14;

  @Column(
    name   = "clientDefined15CharCode15",
    length = 15
  )
  private String clientDefined15CharCode15;
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
    name   = "clientDefined15CharCode5",
    length = 15
  )
  private String clientDefined15CharCode5;
  @Column(
    name   = "clientDefined15CharCode6",
    length = 15
  )
  private String clientDefined15CharCode6;
  @Column(
    name   = "clientDefined15CharCode7",
    length = 15
  )
  private String clientDefined15CharCode7;
  @Column(
    name   = "clientDefined15CharCode8",
    length = 15
  )
  private String clientDefined15CharCode8;
  @Column(
    name   = "clientDefined15CharCode9",
    length = 15
  )
  private String clientDefined15CharCode9;


  @Column(
    name   = "clientDefined1CharCode1",
    length = 1
  )
  private String clientDefined1CharCode1;
  @Column(
    name   = "clientDefined1CharCode10",
    length = 1
  )
  private String clientDefined1CharCode10;
  @Column(
    name   = "clientDefined1CharCode11",
    length = 1
  )
  private String clientDefined1CharCode11;
  @Column(
    name   = "clientDefined1CharCode12",
    length = 1
  )
  private String clientDefined1CharCode12;
  @Column(
    name   = "clientDefined1CharCode13",
    length = 1
  )
  private String clientDefined1CharCode13;
  @Column(
    name   = "clientDefined1CharCode14",
    length = 1
  )
  private String clientDefined1CharCode14;
  @Column(
    name   = "clientDefined1CharCode15",
    length = 1
  )
  private String clientDefined1CharCode15;
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
    name   = "clientDefined20CharCode10",
    length = 20
  )
  private String clientDefined20CharCode10;

  @Column(
    name   = "clientDefined20CharCode11",
    length = 20
  )
  private String clientDefined20CharCode11;

  @Column(
    name   = "clientDefined20CharCode12",
    length = 20
  )
  private String clientDefined20CharCode12;

  @Column(
    name   = "clientDefined20CharCode13",
    length = 20
  )
  private String clientDefined20CharCode13;

  @Column(
    name   = "clientDefined20CharCode14",
    length = 20
  )
  private String clientDefined20CharCode14;

  @Column(
    name   = "clientDefined20CharCode15",
    length = 20
  )
  private String clientDefined20CharCode15;


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
    name   = "clientDefined20CharCode5",
    length = 20
  )
  private String clientDefined20CharCode5;
  @Column(
    name   = "clientDefined20CharCode6",
    length = 20
  )
  private String clientDefined20CharCode6;
  @Column(
    name   = "clientDefined20CharCode7",
    length = 20
  )
  private String clientDefined20CharCode7;
  @Column(
    name   = "clientDefined20CharCode8",
    length = 20
  )
  private String clientDefined20CharCode8;
  @Column(
    name   = "clientDefined20CharCode9",
    length = 20
  )
  private String clientDefined20CharCode9;
  @Column(
    name   = "clientDefined25CharCode1",
    length = 25
  )
  private String clientDefined25CharCode1;
  @Column(
    name   = "clientDefined25CharCode10",
    length = 25
  )
  private String clientDefined25CharCode10;


  @Column(
    name   = "clientDefined25CharCode11",
    length = 25
  )
  private String clientDefined25CharCode11;
  @Column(
    name   = "clientDefined25CharCode12",
    length = 25
  )
  private String clientDefined25CharCode12;
  @Column(
    name   = "clientDefined25CharCode13",
    length = 25
  )
  private String clientDefined25CharCode13;
  @Column(
    name   = "clientDefined25CharCode14",
    length = 25
  )
  private String clientDefined25CharCode14;
  @Column(
    name   = "clientDefined25CharCode15",
    length = 25
  )
  private String clientDefined25CharCode15;


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
    name   = "clientDefined25CharCode4",
    length = 25
  )
  private String clientDefined25CharCode4;
  @Column(
    name   = "clientDefined25CharCode5",
    length = 25
  )
  private String clientDefined25CharCode5;
  @Column(
    name   = "clientDefined25CharCode6",
    length = 25
  )
  private String clientDefined25CharCode6;
  @Column(
    name   = "clientDefined25CharCode7",
    length = 25
  )
  private String clientDefined25CharCode7;
  @Column(
    name   = "clientDefined25CharCode8",
    length = 25
  )
  private String clientDefined25CharCode8;
  @Column(
    name   = "clientDefined25CharCode9",
    length = 25
  )
  private String clientDefined25CharCode9;
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
    name   = "clientDefined32CharCode10",
    length = 32
  )
  private String clientDefined32CharCode10;
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
    name   = "clientDefined32CharCode4",
    length = 32
  )
  private String clientDefined32CharCode4;
  @Column(
    name   = "clientDefined32CharCode5",
    length = 32
  )
  private String clientDefined32CharCode5;

  @Column(
    name   = "clientDefined32CharCode6",
    length = 32
  )
  private String clientDefined32CharCode6;

  @Column(
    name   = "clientDefined32CharCode7",
    length = 32
  )
  private String clientDefined32CharCode7;

  @Column(
    name   = "clientDefined32CharCode8",
    length = 32
  )
  private String clientDefined32CharCode8;

  @Column(
    name   = "clientDefined32CharCode9",
    length = 32
  )
  private String clientDefined32CharCode9;


  @Column(
    name   = "clientDefined35CharCode1",
    length = 35
  )
  private String clientDefined35CharCode1;
  @Column(
    name   = "clientDefined35CharCode10",
    length = 35
  )
  private String clientDefined35CharCode10;
  @Column(
    name   = "clientDefined35CharCode2",
    length = 35
  )
  private String clientDefined35CharCode2;
  @Column(
    name   = "clientDefined35CharCode3",
    length = 35
  )
  private String clientDefined35CharCode3;
  @Column(
    name   = "clientDefined35CharCode4",
    length = 35
  )
  private String clientDefined35CharCode4;
  @Column(
    name   = "clientDefined35CharCode5",
    length = 35
  )
  private String clientDefined35CharCode5;


  @Column(
    name   = "clientDefined35CharCode6",
    length = 35
  )
  private String clientDefined35CharCode6;
  @Column(
    name   = "clientDefined35CharCode7",
    length = 35
  )
  private String clientDefined35CharCode7;
  @Column(
    name   = "clientDefined35CharCode8",
    length = 35
  )
  private String clientDefined35CharCode8;
  @Column(
    name   = "clientDefined35CharCode9",
    length = 35
  )
  private String clientDefined35CharCode9;


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
    name   = "clientDefined45CharCode10",
    length = 45
  )
  private String clientDefined45CharCode10;
  @Column(
    name   = "clientDefined45CharCode11",
    length = 45
  )
  private String clientDefined45CharCode11;
  @Column(
    name   = "clientDefined45CharCode12",
    length = 45
  )
  private String clientDefined45CharCode12;
  @Column(
    name   = "clientDefined45CharCode13",
    length = 45
  )
  private String clientDefined45CharCode13;
  @Column(
    name   = "clientDefined45CharCode14",
    length = 45
  )
  private String clientDefined45CharCode14;
  @Column(
    name   = "clientDefined45CharCode15",
    length = 45
  )
  private String clientDefined45CharCode15;
  @Column(
    name   = "clientDefined45CharCode16",
    length = 45
  )
  private String clientDefined45CharCode16;
  @Column(
    name   = "clientDefined45CharCode17",
    length = 45
  )
  private String clientDefined45CharCode17;
  @Column(
    name   = "clientDefined45CharCode18",
    length = 45
  )
  private String clientDefined45CharCode18;
  @Column(
    name   = "clientDefined45CharCode19",
    length = 45
  )
  private String clientDefined45CharCode19;
  @Column(
    name   = "clientDefined45CharCode2",
    length = 45
  )
  private String clientDefined45CharCode2;
  @Column(
    name   = "clientDefined45CharCode20",
    length = 45
  )
  private String clientDefined45CharCode20;
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
    name   = "clientDefined45CharCode5",
    length = 45
  )
  private String clientDefined45CharCode5;
  @Column(
    name   = "clientDefined45CharCode6",
    length = 45
  )
  private String clientDefined45CharCode6;
  @Column(
    name   = "clientDefined45CharCode7",
    length = 45
  )
  private String clientDefined45CharCode7;
  @Column(
    name   = "clientDefined45CharCode8",
    length = 45
  )
  private String clientDefined45CharCode8;
  @Column(
    name   = "clientDefined45CharCode9",
    length = 45
  )
  private String clientDefined45CharCode9;
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
    name   = "clientDefined4CharCode4",
    length = 4
  )
  private String clientDefined4CharCode4;
  @Column(
    name   = "clientDefined4CharCode5",
    length = 4
  )
  private String clientDefined4CharCode5;
  @Column(
    name   = "clientDefined4CharCode6",
    length = 4
  )
  private String clientDefined4CharCode6;

  @Column(
    name   = "clientDefined4CharCode7",
    length = 4
  )
  private String clientDefined4CharCode7;
  @Column(
    name   = "clientDefined4CharCode8",
    length = 4
  )
  private String clientDefined4CharCode8;
  @Column(
    name   = "clientDefined5CharCode1",
    length = 5
  )
  private String clientDefined5CharCode1;
  @Column(
    name   = "clientDefined5CharCode10",
    length = 5
  )
  private String clientDefined5CharCode10;
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
    name   = "clientDefined5CharCode5",
    length = 5
  )
  private String clientDefined5CharCode5;
  @Column(
    name   = "clientDefined5CharCode6",
    length = 5
  )
  private String clientDefined5CharCode6;
  @Column(
    name   = "clientDefined5CharCode7",
    length = 5
  )
  private String clientDefined5CharCode7;
  @Column(
    name   = "clientDefined5CharCode8",
    length = 5
  )
  private String clientDefined5CharCode8;
  @Column(
    name   = "clientDefined5CharCode9",
    length = 5
  )
  private String clientDefined5CharCode9;
  @Column(
    name   = "clientDefined8CharCode1",
    length = 8
  )
  private String clientDefined8CharCode1;
  @Column(
    name   = "clientDefined8CharCode10",
    length = 8
  )
  private String clientDefined8CharCode10;
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
  @Column(
    name   = "clientDefined8CharCode7",
    length = 8
  )
  private String clientDefined8CharCode7;
  @Column(
    name   = "clientDefined8CharCode8",
    length = 8
  )
  private String clientDefined8CharCode8;
  @Column(
    name   = "clientDefined8CharCode9",
    length = 8
  )
  private String clientDefined8CharCode9;
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate1;
  @Column(name = "clientDefinedDate10")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate10;
  @Column(name = "clientDefinedDate11")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate11;
  @Column(name = "clientDefinedDate12")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate12;
  @Column(name = "clientDefinedDate13")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate13;
  @Column(name = "clientDefinedDate14")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate14;
  @Column(name = "clientDefinedDate15")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   clientDefinedDate15;

  @Column(name = "clientDefinedDate16")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate16;

  @Column(name = "clientDefinedDate17")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate17;

  @Column(name = "clientDefinedDate18")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate18;

  @Column(name = "clientDefinedDate19")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate19;


  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate2;

  @Column(name = "clientDefinedDate20")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate20;
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate3;
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate4;
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate5;
  @Column(name = "clientDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate6;
  @Column(name = "clientDefinedDate7")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate7;
  @Column(name = "clientDefinedDate8")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate8;
  @Column(name = "clientDefinedDate9")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       clientDefinedDate9;
  @Column(name = "clientDefinedDecimal1")
  private BigDecimal clientDefinedDecimal1;
  @Column(name = "clientDefinedDecimal10")
  private BigDecimal clientDefinedDecimal10;
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
  @Column(name = "clientDefinedDecimal16")
  private BigDecimal clientDefinedDecimal16;
  @Column(name = "clientDefinedDecimal17")
  private BigDecimal clientDefinedDecimal17;
  @Column(name = "clientDefinedDecimal18")
  private BigDecimal clientDefinedDecimal18;
  @Column(name = "clientDefinedDecimal19")
  private BigDecimal clientDefinedDecimal19;
  @Column(name = "clientDefinedDecimal2")
  private BigDecimal clientDefinedDecimal2;
  @Column(name = "clientDefinedDecimal20")
  private BigDecimal clientDefinedDecimal20;
  @Column(name = "clientDefinedDecimal3")
  private BigDecimal clientDefinedDecimal3;
  @Column(name = "clientDefinedDecimal4")
  private BigDecimal clientDefinedDecimal4;
  @Column(name = "clientDefinedDecimal5")
  private BigDecimal clientDefinedDecimal5;
  @Column(name = "clientDefinedDecimal6")
  private BigDecimal clientDefinedDecimal6;
  @Column(name = "clientDefinedDecimal7")
  private BigDecimal clientDefinedDecimal7;
  @Column(name = "clientDefinedDecimal8")
  private BigDecimal clientDefinedDecimal8;
  @Column(name = "clientDefinedDecimal9")
  private BigDecimal clientDefinedDecimal9;

  @Column(
    name   = "clientDefinedEncryptedField1",
    length = 80
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String clientDefinedEncryptedField1;

  @Column(
    name   = "clientDefinedEncryptedField2",
    length = 80
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String clientDefinedEncryptedField2;

  @Column(
    name   = "clientDefinedEncryptedField3",
    length = 80
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String  clientDefinedEncryptedField3;
  @Column(
    name             = "clientDefinedFlag1",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag1;
  @Column(
    name             = "clientDefinedFlag2",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag2;

  @Column(
    name             = "clientDefinedFlag3",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag3;
  @Column(
    name             = "clientDefinedFlag4",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag4;
  @Column(
    name             = "clientDefinedFlag5",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag5;
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
    name   = "clientDefinedInteger18",
    length = 11
  )
  private Integer clientDefinedInteger18;
  @Column(
    name   = "clientDefinedInteger19",
    length = 11
  )
  private Integer clientDefinedInteger19;
  @Column(
    name   = "clientDefinedInteger2",
    length = 11
  )
  private Integer clientDefinedInteger2;
  @Column(
    name   = "clientDefinedInteger20",
    length = 11
  )
  private Integer clientDefinedInteger20;
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
  private Long    clientDefinedLong1;
  @Column(name = "clientDefinedLong10")
  private Long    clientDefinedLong10;
  @Column(name = "clientDefinedLong2")
  private Long    clientDefinedLong2;
  @Column(name = "clientDefinedLong3")
  private Long    clientDefinedLong3;
  @Column(name = "clientDefinedLong4")
  private Long    clientDefinedLong4;
  @Column(name = "clientDefinedLong5")
  private Long    clientDefinedLong5;
  @Column(name = "clientDefinedLong6")
  private Long    clientDefinedLong6;
  @Column(name = "clientDefinedLong7")
  private Long    clientDefinedLong7;
  @Column(name = "clientDefinedLong8")
  private Long    clientDefinedLong8;
  @Column(name = "clientDefinedLong9")
  private Long    clientDefinedLong9;
  @Column(
    name   = "clientDefinedString1",
    length = 100
  )
  private String  clientDefinedString1;
  @Column(
    name   = "clientDefinedString10",
    length = 550
  )
  private String  clientDefinedString10;
  @Column(
    name   = "clientDefinedString11",
    length = 550
  )
  private String  clientDefinedString11;

  @Column(
    name   = "clientDefinedString12",
    length = 550
  )
  private String clientDefinedString12;

  @Column(
    name   = "clientDefinedString13",
    length = 550
  )
  private String clientDefinedString13;

  @Column(
    name   = "clientDefinedString14",
    length = 550
  )
  private String clientDefinedString14;
  @Column(
    name   = "clientDefinedString15",
    length = 550
  )
  private String clientDefinedString15;
  @Column(
    name   = "clientDefinedString16",
    length = 550
  )
  private String clientDefinedString16;
  @Column(
    name   = "clientDefinedString17",
    length = 550
  )
  private String clientDefinedString17;
  @Column(
    name   = "clientDefinedString18",
    length = 550
  )
  private String clientDefinedString18;

  @Column(
    name   = "clientDefinedString19",
    length = 550
  )
  private String clientDefinedString19;

  @Column(
    name   = "clientDefinedString2",
    length = 100
  )
  private String clientDefinedString2;

  @Column(
    name   = "clientDefinedString20",
    length = 550
  )
  private String clientDefinedString20;
  @Column(
    name   = "clientDefinedString21",
    length = 550
  )
  private String clientDefinedString21;
  @Column(
    name   = "clientDefinedString22",
    length = 550
  )
  private String clientDefinedString22;
  @Column(
    name   = "clientDefinedString23",
    length = 100
  )
  private String clientDefinedString23;

  @Column(
    name   = "clientDefinedString24",
    length = 550
  )
  private String clientDefinedString24;

  @Column(
    name   = "clientDefinedString25",
    length = 550
  )
  private String clientDefinedString25;

  @Column(
    name   = "clientDefinedString26",
    length = 550
  )
  private String clientDefinedString26;
  @Column(
    name   = "clientDefinedString27",
    length = 550
  )
  private String clientDefinedString27;
  @Column(
    name   = "clientDefinedString28",
    length = 550
  )
  private String clientDefinedString28;
  @Column(
    name   = "clientDefinedString29",
    length = 550
  )
  private String clientDefinedString29;

  @Column(
    name   = "clientDefinedString3",
    length = 550
  )
  private String clientDefinedString3;
  @Column(
    name   = "clientDefinedString30",
    length = 550
  )
  private String clientDefinedString30;

  @Column(
    name   = "clientDefinedString31",
    length = 550
  )
  private String clientDefinedString31;

  @Column(
    name   = "clientDefinedString32",
    length = 550
  )
  private String clientDefinedString32;
  @Column(
    name   = "clientDefinedString33",
    length = 550
  )
  private String clientDefinedString33;
  @Column(
    name   = "clientDefinedString34",
    length = 550
  )
  private String clientDefinedString34;
  @Column(
    name   = "clientDefinedString35",
    length = 550
  )
  private String clientDefinedString35;
  @Column(
    name   = "clientDefinedString4",
    length = 100
  )
  private String clientDefinedString4;

  @Column(
    name   = "clientDefinedString5",
    length = 100
  )
  private String clientDefinedString5;

  @Column(
    name   = "clientDefinedString6",
    length = 550
  )
  private String clientDefinedString6;

  @Column(
    name   = "clientDefinedString7",
    length = 550
  )
  private String clientDefinedString7;

  @Column(
    name   = "clientDefinedString8",
    length = 550
  )
  private String clientDefinedString8;
  @Column(
    name   = "clientDefinedString9",
    length = 550
  )
  private String clientDefinedString9;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account additional detail id.
   *
   * @return  Long
   */
  public Long getAccountAdditionalDetailId() {
    return accountAdditionalDetailId;
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
   * getter method for client defined10 char code10.
   *
   * @return  String
   */
  public String getClientDefined10CharCode10() {
    return clientDefined10CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code11.
   *
   * @return  String
   */
  public String getClientDefined10CharCode11() {
    return clientDefined10CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code12.
   *
   * @return  String
   */
  public String getClientDefined10CharCode12() {
    return clientDefined10CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code13.
   *
   * @return  String
   */
  public String getClientDefined10CharCode13() {
    return clientDefined10CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code14.
   *
   * @return  String
   */
  public String getClientDefined10CharCode14() {
    return clientDefined10CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code15.
   *
   * @return  String
   */
  public String getClientDefined10CharCode15() {
    return clientDefined10CharCode15;
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
   * getter method for client defined10 char code4.
   *
   * @return  String
   */
  public String getClientDefined10CharCode4() {
    return clientDefined10CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code5.
   *
   * @return  String
   */
  public String getClientDefined10CharCode5() {
    return clientDefined10CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code6.
   *
   * @return  String
   */
  public String getClientDefined10CharCode6() {
    return clientDefined10CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code7.
   *
   * @return  String
   */
  public String getClientDefined10CharCode7() {
    return clientDefined10CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code8.
   *
   * @return  String
   */
  public String getClientDefined10CharCode8() {
    return clientDefined10CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code9.
   *
   * @return  String
   */
  public String getClientDefined10CharCode9() {
    return clientDefined10CharCode9;
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
   * getter method for client defined15 char code10.
   *
   * @return  String
   */
  public String getClientDefined15CharCode10() {
    return clientDefined15CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code11.
   *
   * @return  String
   */
  public String getClientDefined15CharCode11() {
    return clientDefined15CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code12.
   *
   * @return  String
   */
  public String getClientDefined15CharCode12() {
    return clientDefined15CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code13.
   *
   * @return  String
   */
  public String getClientDefined15CharCode13() {
    return clientDefined15CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code14.
   *
   * @return  String
   */
  public String getClientDefined15CharCode14() {
    return clientDefined15CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code15.
   *
   * @return  String
   */
  public String getClientDefined15CharCode15() {
    return clientDefined15CharCode15;
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
   * getter method for client defined15 char code4.
   *
   * @return  String
   */
  public String getClientDefined15CharCode4() {
    return clientDefined15CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code5.
   *
   * @return  String
   */
  public String getClientDefined15CharCode5() {
    return clientDefined15CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code6.
   *
   * @return  String
   */
  public String getClientDefined15CharCode6() {
    return clientDefined15CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code7.
   *
   * @return  String
   */
  public String getClientDefined15CharCode7() {
    return clientDefined15CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code8.
   *
   * @return  String
   */
  public String getClientDefined15CharCode8() {
    return clientDefined15CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code9.
   *
   * @return  String
   */
  public String getClientDefined15CharCode9() {
    return clientDefined15CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code1.
   *
   * @return  String
   */
  public String getClientDefined1CharCode1() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code10.
   *
   * @return  String
   */
  public String getClientDefined1CharCode10() {
    return clientDefined1CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code11.
   *
   * @return  String
   */
  public String getClientDefined1CharCode11() {
    return clientDefined1CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code12.
   *
   * @return  String
   */
  public String getClientDefined1CharCode12() {
    return clientDefined1CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code13.
   *
   * @return  String
   */
  public String getClientDefined1CharCode13() {
    return clientDefined1CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code14.
   *
   * @return  String
   */
  public String getClientDefined1CharCode14() {
    return clientDefined1CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code15.
   *
   * @return  String
   */
  public String getClientDefined1CharCode15() {
    return clientDefined1CharCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code2.
   *
   * @return  String
   */
  public String getClientDefined1CharCode2() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code3.
   *
   * @return  String
   */
  public String getClientDefined1CharCode3() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code4.
   *
   * @return  String
   */
  public String getClientDefined1CharCode4() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code5.
   *
   * @return  String
   */
  public String getClientDefined1CharCode5() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code6.
   *
   * @return  String
   */
  public String getClientDefined1CharCode6() {
    return clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code7.
   *
   * @return  String
   */
  public String getClientDefined1CharCode7() {
    return clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code8.
   *
   * @return  String
   */
  public String getClientDefined1CharCode8() {
    return clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code9.
   *
   * @return  String
   */
  public String getClientDefined1CharCode9() {
    return clientDefined1CharCode9;
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
   * getter method for client defined20 char code10.
   *
   * @return  String
   */
  public String getClientDefined20CharCode10() {
    return clientDefined20CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code11.
   *
   * @return  String
   */
  public String getClientDefined20CharCode11() {
    return clientDefined20CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code12.
   *
   * @return  String
   */
  public String getClientDefined20CharCode12() {
    return clientDefined20CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code13.
   *
   * @return  String
   */
  public String getClientDefined20CharCode13() {
    return clientDefined20CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code14.
   *
   * @return  String
   */
  public String getClientDefined20CharCode14() {
    return clientDefined20CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code15.
   *
   * @return  String
   */
  public String getClientDefined20CharCode15() {
    return clientDefined20CharCode15;
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
   * getter method for client defined20 char code6.
   *
   * @return  String
   */
  public String getClientDefined20CharCode6() {
    return clientDefined20CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code7.
   *
   * @return  String
   */
  public String getClientDefined20CharCode7() {
    return clientDefined20CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code8.
   *
   * @return  String
   */
  public String getClientDefined20CharCode8() {
    return clientDefined20CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code9.
   *
   * @return  String
   */
  public String getClientDefined20CharCode9() {
    return clientDefined20CharCode9;
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
   * getter method for client defined25 char code10.
   *
   * @return  String
   */
  public String getClientDefined25CharCode10() {
    return clientDefined25CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code11.
   *
   * @return  String
   */
  public String getClientDefined25CharCode11() {
    return clientDefined25CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code12.
   *
   * @return  String
   */
  public String getClientDefined25CharCode12() {
    return clientDefined25CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code13.
   *
   * @return  String
   */
  public String getClientDefined25CharCode13() {
    return clientDefined25CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code14.
   *
   * @return  String
   */
  public String getClientDefined25CharCode14() {
    return clientDefined25CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code15.
   *
   * @return  String
   */
  public String getClientDefined25CharCode15() {
    return clientDefined25CharCode15;
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
   * getter method for client defined25 char code4.
   *
   * @return  String
   */
  public String getClientDefined25CharCode4() {
    return clientDefined25CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code5.
   *
   * @return  String
   */
  public String getClientDefined25CharCode5() {
    return clientDefined25CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code6.
   *
   * @return  String
   */
  public String getClientDefined25CharCode6() {
    return clientDefined25CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code7.
   *
   * @return  String
   */
  public String getClientDefined25CharCode7() {
    return clientDefined25CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code8.
   *
   * @return  String
   */
  public String getClientDefined25CharCode8() {
    return clientDefined25CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined25 char code9.
   *
   * @return  String
   */
  public String getClientDefined25CharCode9() {
    return clientDefined25CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code1.
   *
   * @return  String
   */
  public String getClientDefined2CharCode1() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code2.
   *
   * @return  String
   */
  public String getClientDefined2CharCode2() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code3.
   *
   * @return  String
   */
  public String getClientDefined2CharCode3() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code4.
   *
   * @return  String
   */
  public String getClientDefined2CharCode4() {
    return clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code5.
   *
   * @return  String
   */
  public String getClientDefined2CharCode5() {
    return clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code1.
   *
   * @return  String
   */
  public String getClientDefined32CharCode1() {
    return clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code10.
   *
   * @return  String
   */
  public String getClientDefined32CharCode10() {
    return clientDefined32CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code2.
   *
   * @return  String
   */
  public String getClientDefined32CharCode2() {
    return clientDefined32CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code3.
   *
   * @return  String
   */
  public String getClientDefined32CharCode3() {
    return clientDefined32CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code4.
   *
   * @return  String
   */
  public String getClientDefined32CharCode4() {
    return clientDefined32CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code5.
   *
   * @return  String
   */
  public String getClientDefined32CharCode5() {
    return clientDefined32CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code6.
   *
   * @return  String
   */
  public String getClientDefined32CharCode6() {
    return clientDefined32CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code7.
   *
   * @return  String
   */
  public String getClientDefined32CharCode7() {
    return clientDefined32CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code8.
   *
   * @return  String
   */
  public String getClientDefined32CharCode8() {
    return clientDefined32CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined32 char code9.
   *
   * @return  String
   */
  public String getClientDefined32CharCode9() {
    return clientDefined32CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code1.
   *
   * @return  String
   */
  public String getClientDefined35CharCode1() {
    return clientDefined35CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code10.
   *
   * @return  String
   */
  public String getClientDefined35CharCode10() {
    return clientDefined35CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code2.
   *
   * @return  String
   */
  public String getClientDefined35CharCode2() {
    return clientDefined35CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code3.
   *
   * @return  String
   */
  public String getClientDefined35CharCode3() {
    return clientDefined35CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code4.
   *
   * @return  String
   */
  public String getClientDefined35CharCode4() {
    return clientDefined35CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code5.
   *
   * @return  String
   */
  public String getClientDefined35CharCode5() {
    return clientDefined35CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code6.
   *
   * @return  String
   */
  public String getClientDefined35CharCode6() {
    return clientDefined35CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code7.
   *
   * @return  String
   */
  public String getClientDefined35CharCode7() {
    return clientDefined35CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code8.
   *
   * @return  String
   */
  public String getClientDefined35CharCode8() {
    return clientDefined35CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined35 char code9.
   *
   * @return  String
   */
  public String getClientDefined35CharCode9() {
    return clientDefined35CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code1.
   *
   * @return  String
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code2.
   *
   * @return  String
   */
  public String getClientDefined3CharCode2() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code3.
   *
   * @return  String
   */
  public String getClientDefined3CharCode3() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code4.
   *
   * @return  String
   */
  public String getClientDefined3CharCode4() {
    return clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code5.
   *
   * @return  String
   */
  public String getClientDefined3CharCode5() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code1.
   *
   * @return  String
   */
  public String getClientDefined45CharCode1() {
    return clientDefined45CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code10.
   *
   * @return  String
   */
  public String getClientDefined45CharCode10() {
    return clientDefined45CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code11.
   *
   * @return  String
   */
  public String getClientDefined45CharCode11() {
    return clientDefined45CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code12.
   *
   * @return  String
   */
  public String getClientDefined45CharCode12() {
    return clientDefined45CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code13.
   *
   * @return  String
   */
  public String getClientDefined45CharCode13() {
    return clientDefined45CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code14.
   *
   * @return  String
   */
  public String getClientDefined45CharCode14() {
    return clientDefined45CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code15.
   *
   * @return  String
   */
  public String getClientDefined45CharCode15() {
    return clientDefined45CharCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code16.
   *
   * @return  String
   */
  public String getClientDefined45CharCode16() {
    return clientDefined45CharCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code17.
   *
   * @return  String
   */
  public String getClientDefined45CharCode17() {
    return clientDefined45CharCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code18.
   *
   * @return  String
   */
  public String getClientDefined45CharCode18() {
    return clientDefined45CharCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code19.
   *
   * @return  String
   */
  public String getClientDefined45CharCode19() {
    return clientDefined45CharCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code2.
   *
   * @return  String
   */
  public String getClientDefined45CharCode2() {
    return clientDefined45CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code20.
   *
   * @return  String
   */
  public String getClientDefined45CharCode20() {
    return clientDefined45CharCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code3.
   *
   * @return  String
   */
  public String getClientDefined45CharCode3() {
    return clientDefined45CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code4.
   *
   * @return  String
   */
  public String getClientDefined45CharCode4() {
    return clientDefined45CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code5.
   *
   * @return  String
   */
  public String getClientDefined45CharCode5() {
    return clientDefined45CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code6.
   *
   * @return  String
   */
  public String getClientDefined45CharCode6() {
    return clientDefined45CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code7.
   *
   * @return  String
   */
  public String getClientDefined45CharCode7() {
    return clientDefined45CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code8.
   *
   * @return  String
   */
  public String getClientDefined45CharCode8() {
    return clientDefined45CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined45 char code9.
   *
   * @return  String
   */
  public String getClientDefined45CharCode9() {
    return clientDefined45CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code1.
   *
   * @return  String
   */
  public String getClientDefined4CharCode1() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code2.
   *
   * @return  String
   */
  public String getClientDefined4CharCode2() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code3.
   *
   * @return  String
   */
  public String getClientDefined4CharCode3() {
    return clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code4.
   *
   * @return  String
   */
  public String getClientDefined4CharCode4() {
    return clientDefined4CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code5.
   *
   * @return  String
   */
  public String getClientDefined4CharCode5() {
    return clientDefined4CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code6.
   *
   * @return  String
   */
  public String getClientDefined4CharCode6() {
    return clientDefined4CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code7.
   *
   * @return  String
   */
  public String getClientDefined4CharCode7() {
    return clientDefined4CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code8.
   *
   * @return  String
   */
  public String getClientDefined4CharCode8() {
    return clientDefined4CharCode8;
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
   * getter method for client defined5 char code10.
   *
   * @return  String
   */
  public String getClientDefined5CharCode10() {
    return clientDefined5CharCode10;
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
   * getter method for client defined5 char code4.
   *
   * @return  String
   */
  public String getClientDefined5CharCode4() {
    return clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code5.
   *
   * @return  String
   */
  public String getClientDefined5CharCode5() {
    return clientDefined5CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code6.
   *
   * @return  String
   */
  public String getClientDefined5CharCode6() {
    return clientDefined5CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code7.
   *
   * @return  String
   */
  public String getClientDefined5CharCode7() {
    return clientDefined5CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code8.
   *
   * @return  String
   */
  public String getClientDefined5CharCode8() {
    return clientDefined5CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code9.
   *
   * @return  String
   */
  public String getClientDefined5CharCode9() {
    return clientDefined5CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code1.
   *
   * @return  String
   */
  public String getClientDefined8CharCode1() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code10.
   *
   * @return  String
   */
  public String getClientDefined8CharCode10() {
    return clientDefined8CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code2.
   *
   * @return  String
   */
  public String getClientDefined8CharCode2() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code3.
   *
   * @return  String
   */
  public String getClientDefined8CharCode3() {
    return clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code4.
   *
   * @return  String
   */
  public String getClientDefined8CharCode4() {
    return clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code5.
   *
   * @return  String
   */
  public String getClientDefined8CharCode5() {
    return clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code6.
   *
   * @return  String
   */
  public String getClientDefined8CharCode6() {
    return clientDefined8CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code7.
   *
   * @return  String
   */
  public String getClientDefined8CharCode7() {
    return clientDefined8CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code8.
   *
   * @return  String
   */
  public String getClientDefined8CharCode8() {
    return clientDefined8CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code9.
   *
   * @return  String
   */
  public String getClientDefined8CharCode9() {
    return clientDefined8CharCode9;
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
   * getter method for client defined date10.
   *
   * @return  Date
   */
  public Date getClientDefinedDate10() {
    return clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date11.
   *
   * @return  Date
   */
  public Date getClientDefinedDate11() {
    return clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date12.
   *
   * @return  Date
   */
  public Date getClientDefinedDate12() {
    return clientDefinedDate12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date13.
   *
   * @return  Date
   */
  public Date getClientDefinedDate13() {
    return clientDefinedDate13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date14.
   *
   * @return  Date
   */
  public Date getClientDefinedDate14() {
    return clientDefinedDate14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date15.
   *
   * @return  Date
   */
  public Date getClientDefinedDate15() {
    return clientDefinedDate15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date16.
   *
   * @return  Date
   */
  public Date getClientDefinedDate16() {
    return clientDefinedDate16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date17.
   *
   * @return  Date
   */
  public Date getClientDefinedDate17() {
    return clientDefinedDate17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date18.
   *
   * @return  Date
   */
  public Date getClientDefinedDate18() {
    return clientDefinedDate18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date19.
   *
   * @return  Date
   */
  public Date getClientDefinedDate19() {
    return clientDefinedDate19;
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
   * getter method for client defined date20.
   *
   * @return  Date
   */
  public Date getClientDefinedDate20() {
    return clientDefinedDate20;
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
   * getter method for client defined date7.
   *
   * @return  Date
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
   * getter method for client defined decimal10.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal10() {
    return clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal11.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal11() {
    return clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal12.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal12() {
    return clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal13.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal13() {
    return clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal14.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal14() {
    return clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal15.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal15() {
    return clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal16.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal16() {
    return clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal17.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal17() {
    return clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal18.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal18() {
    return clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal19.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal19() {
    return clientDefinedDecimal19;
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
   * getter method for client defined decimal20.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal20() {
    return clientDefinedDecimal20;
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
   * getter method for client defined decimal4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal4() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal5() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal6() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal7() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal8.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal8() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal9.
   *
   * @return  BigDecimal
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
  public String getClientDefinedEncryptedField1() {
    return clientDefinedEncryptedField1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedEncryptedField2() {
    return clientDefinedEncryptedField2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getClientDefinedEncryptedField3() {
    return clientDefinedEncryptedField3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag3.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag3() {
    return clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag4.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag4() {
    return clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag5.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag5() {
    return clientDefinedFlag5;
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
   * getter method for client defined integer10.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger10() {
    return clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer11.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger11() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer12.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger12() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer13.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger13() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer14.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger14() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer15.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger15() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer16.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger16() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer17.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger17() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer18.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger18() {
    return clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer19.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger19() {
    return clientDefinedInteger19;
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
   * getter method for client defined integer20.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger20() {
    return clientDefinedInteger20;
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
   * getter method for client defined integer4.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer5.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer6.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer7.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer8.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger8() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer9.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger9() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long1.
   *
   * @return  Long
   */
  public Long getClientDefinedLong1() {
    return clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long10.
   *
   * @return  Long
   */
  public Long getClientDefinedLong10() {
    return clientDefinedLong10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long2.
   *
   * @return  Long
   */
  public Long getClientDefinedLong2() {
    return clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long3.
   *
   * @return  Long
   */
  public Long getClientDefinedLong3() {
    return clientDefinedLong3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long4.
   *
   * @return  Long
   */
  public Long getClientDefinedLong4() {
    return clientDefinedLong4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long5.
   *
   * @return  Long
   */
  public Long getClientDefinedLong5() {
    return clientDefinedLong5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long6.
   *
   * @return  Long
   */
  public Long getClientDefinedLong6() {
    return clientDefinedLong6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long7.
   *
   * @return  Long
   */
  public Long getClientDefinedLong7() {
    return clientDefinedLong7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long8.
   *
   * @return  Long
   */
  public Long getClientDefinedLong8() {
    return clientDefinedLong8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long9.
   *
   * @return  Long
   */
  public Long getClientDefinedLong9() {
    return clientDefinedLong9;
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
   * getter method for client defined string10.
   *
   * @return  String
   */
  public String getClientDefinedString10() {
    return clientDefinedString10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string11.
   *
   * @return  String
   */
  public String getClientDefinedString11() {
    return clientDefinedString11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string12.
   *
   * @return  String
   */
  public String getClientDefinedString12() {
    return clientDefinedString12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string13.
   *
   * @return  String
   */
  public String getClientDefinedString13() {
    return clientDefinedString13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string14.
   *
   * @return  String
   */
  public String getClientDefinedString14() {
    return clientDefinedString14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string15.
   *
   * @return  String
   */
  public String getClientDefinedString15() {
    return clientDefinedString15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string16.
   *
   * @return  String
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
   * getter method for client defined string19.
   *
   * @return  String
   */
  public String getClientDefinedString19() {
    return clientDefinedString19;
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
   * getter method for client defined string20.
   *
   * @return  String
   */
  public String getClientDefinedString20() {
    return clientDefinedString20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string21.
   *
   * @return  String
   */
  public String getClientDefinedString21() {
    return clientDefinedString21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string22.
   *
   * @return  String
   */
  public String getClientDefinedString22() {
    return clientDefinedString22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string23.
   *
   * @return  String
   */
  public String getClientDefinedString23() {
    return clientDefinedString23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string24.
   *
   * @return  String
   */
  public String getClientDefinedString24() {
    return clientDefinedString24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string25.
   *
   * @return  String
   */
  public String getClientDefinedString25() {
    return clientDefinedString25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string26.
   *
   * @return  String
   */
  public String getClientDefinedString26() {
    return clientDefinedString26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string27.
   *
   * @return  String
   */
  public String getClientDefinedString27() {
    return clientDefinedString27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string28.
   *
   * @return  String
   */
  public String getClientDefinedString28() {
    return clientDefinedString28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string29.
   *
   * @return  String
   */
  public String getClientDefinedString29() {
    return clientDefinedString29;
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
   * getter method for client defined string30.
   *
   * @return  String
   */
  public String getClientDefinedString30() {
    return clientDefinedString30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string31.
   *
   * @return  String
   */
  public String getClientDefinedString31() {
    return clientDefinedString31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string32.
   *
   * @return  String
   */
  public String getClientDefinedString32() {
    return clientDefinedString32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string33.
   *
   * @return  String
   */
  public String getClientDefinedString33() {
    return clientDefinedString33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string34.
   *
   * @return  String
   */
  public String getClientDefinedString34() {
    return clientDefinedString34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string35.
   *
   * @return  String
   */
  public String getClientDefinedString35() {
    return clientDefinedString35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string4.
   *
   * @return  String
   */
  public String getClientDefinedString4() {
    return clientDefinedString4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string5.
   *
   * @return  String
   */
  public String getClientDefinedString5() {
    return clientDefinedString5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string6.
   *
   * @return  String
   */
  public String getClientDefinedString6() {
    return clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string7.
   *
   * @return  String
   */
  public String getClientDefinedString7() {
    return clientDefinedString7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string8.
   *
   * @return  String
   */
  public String getClientDefinedString8() {
    return clientDefinedString8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string9.
   *
   * @return  String
   */
  public String getClientDefinedString9() {
    return clientDefinedString9;
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
   * setter method for account additional detail id.
   *
   * @param  accountAdditionalDetailId  Long
   */
  public void setAccountAdditionalDetailId(Long accountAdditionalDetailId) {
    this.accountAdditionalDetailId = accountAdditionalDetailId;
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
   * setter method for client defined10 char code10.
   *
   * @param  clientDefined10CharCode10  String
   */
  public void setClientDefined10CharCode10(String clientDefined10CharCode10) {
    this.clientDefined10CharCode10 = clientDefined10CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code11.
   *
   * @param  clientDefined10CharCode11  String
   */
  public void setClientDefined10CharCode11(String clientDefined10CharCode11) {
    this.clientDefined10CharCode11 = clientDefined10CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code12.
   *
   * @param  clientDefined10CharCode12  String
   */
  public void setClientDefined10CharCode12(String clientDefined10CharCode12) {
    this.clientDefined10CharCode12 = clientDefined10CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code13.
   *
   * @param  clientDefined10CharCode13  String
   */
  public void setClientDefined10CharCode13(String clientDefined10CharCode13) {
    this.clientDefined10CharCode13 = clientDefined10CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code14.
   *
   * @param  clientDefined10CharCode14  String
   */
  public void setClientDefined10CharCode14(String clientDefined10CharCode14) {
    this.clientDefined10CharCode14 = clientDefined10CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code15.
   *
   * @param  clientDefined10CharCode15  String
   */
  public void setClientDefined10CharCode15(String clientDefined10CharCode15) {
    this.clientDefined10CharCode15 = clientDefined10CharCode15;
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
   * setter method for client defined10 char code4.
   *
   * @param  clientDefined10CharCode4  String
   */
  public void setClientDefined10CharCode4(String clientDefined10CharCode4) {
    this.clientDefined10CharCode4 = clientDefined10CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code5.
   *
   * @param  clientDefined10CharCode5  String
   */
  public void setClientDefined10CharCode5(String clientDefined10CharCode5) {
    this.clientDefined10CharCode5 = clientDefined10CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code6.
   *
   * @param  clientDefined10CharCode6  String
   */
  public void setClientDefined10CharCode6(String clientDefined10CharCode6) {
    this.clientDefined10CharCode6 = clientDefined10CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code7.
   *
   * @param  clientDefined10CharCode7  String
   */
  public void setClientDefined10CharCode7(String clientDefined10CharCode7) {
    this.clientDefined10CharCode7 = clientDefined10CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code8.
   *
   * @param  clientDefined10CharCode8  String
   */
  public void setClientDefined10CharCode8(String clientDefined10CharCode8) {
    this.clientDefined10CharCode8 = clientDefined10CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code9.
   *
   * @param  clientDefined10CharCode9  String
   */
  public void setClientDefined10CharCode9(String clientDefined10CharCode9) {
    this.clientDefined10CharCode9 = clientDefined10CharCode9;
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
   * setter method for client defined15 char code10.
   *
   * @param  clientDefined15CharCode10  String
   */
  public void setClientDefined15CharCode10(String clientDefined15CharCode10) {
    this.clientDefined15CharCode10 = clientDefined15CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code11.
   *
   * @param  clientDefined15CharCode11  String
   */
  public void setClientDefined15CharCode11(String clientDefined15CharCode11) {
    this.clientDefined15CharCode11 = clientDefined15CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code12.
   *
   * @param  clientDefined15CharCode12  String
   */
  public void setClientDefined15CharCode12(String clientDefined15CharCode12) {
    this.clientDefined15CharCode12 = clientDefined15CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code13.
   *
   * @param  clientDefined15CharCode13  String
   */
  public void setClientDefined15CharCode13(String clientDefined15CharCode13) {
    this.clientDefined15CharCode13 = clientDefined15CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code14.
   *
   * @param  clientDefined15CharCode14  String
   */
  public void setClientDefined15CharCode14(String clientDefined15CharCode14) {
    this.clientDefined15CharCode14 = clientDefined15CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code15.
   *
   * @param  clientDefined15CharCode15  String
   */
  public void setClientDefined15CharCode15(String clientDefined15CharCode15) {
    this.clientDefined15CharCode15 = clientDefined15CharCode15;
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
   * setter method for client defined15 char code4.
   *
   * @param  clientDefined15CharCode4  String
   */
  public void setClientDefined15CharCode4(String clientDefined15CharCode4) {
    this.clientDefined15CharCode4 = clientDefined15CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code5.
   *
   * @param  clientDefined15CharCode5  String
   */
  public void setClientDefined15CharCode5(String clientDefined15CharCode5) {
    this.clientDefined15CharCode5 = clientDefined15CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code6.
   *
   * @param  clientDefined15CharCode6  String
   */
  public void setClientDefined15CharCode6(String clientDefined15CharCode6) {
    this.clientDefined15CharCode6 = clientDefined15CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code7.
   *
   * @param  clientDefined15CharCode7  String
   */
  public void setClientDefined15CharCode7(String clientDefined15CharCode7) {
    this.clientDefined15CharCode7 = clientDefined15CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code8.
   *
   * @param  clientDefined15CharCode8  String
   */
  public void setClientDefined15CharCode8(String clientDefined15CharCode8) {
    this.clientDefined15CharCode8 = clientDefined15CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code9.
   *
   * @param  clientDefined15CharCode9  String
   */
  public void setClientDefined15CharCode9(String clientDefined15CharCode9) {
    this.clientDefined15CharCode9 = clientDefined15CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code1.
   *
   * @param  clientDefined1CharCode1  String
   */
  public void setClientDefined1CharCode1(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code10.
   *
   * @param  clientDefined1CharCode10  String
   */
  public void setClientDefined1CharCode10(String clientDefined1CharCode10) {
    this.clientDefined1CharCode10 = clientDefined1CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code11.
   *
   * @param  clientDefined1CharCode11  String
   */
  public void setClientDefined1CharCode11(String clientDefined1CharCode11) {
    this.clientDefined1CharCode11 = clientDefined1CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code12.
   *
   * @param  clientDefined1CharCode12  String
   */
  public void setClientDefined1CharCode12(String clientDefined1CharCode12) {
    this.clientDefined1CharCode12 = clientDefined1CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code13.
   *
   * @param  clientDefined1CharCode13  String
   */
  public void setClientDefined1CharCode13(String clientDefined1CharCode13) {
    this.clientDefined1CharCode13 = clientDefined1CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code14.
   *
   * @param  clientDefined1CharCode14  String
   */
  public void setClientDefined1CharCode14(String clientDefined1CharCode14) {
    this.clientDefined1CharCode14 = clientDefined1CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code15.
   *
   * @param  clientDefined1CharCode15  String
   */
  public void setClientDefined1CharCode15(String clientDefined1CharCode15) {
    this.clientDefined1CharCode15 = clientDefined1CharCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code2.
   *
   * @param  clientDefined1CharCode2  String
   */
  public void setClientDefined1CharCode2(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code3.
   *
   * @param  clientDefined1CharCode3  String
   */
  public void setClientDefined1CharCode3(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code4.
   *
   * @param  clientDefined1CharCode4  String
   */
  public void setClientDefined1CharCode4(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code5.
   *
   * @param  clientDefined1CharCode5  String
   */
  public void setClientDefined1CharCode5(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code6.
   *
   * @param  clientDefined1CharCode6  String
   */
  public void setClientDefined1CharCode6(String clientDefined1CharCode6) {
    this.clientDefined1CharCode6 = clientDefined1CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code7.
   *
   * @param  clientDefined1CharCode7  String
   */
  public void setClientDefined1CharCode7(String clientDefined1CharCode7) {
    this.clientDefined1CharCode7 = clientDefined1CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code8.
   *
   * @param  clientDefined1CharCode8  String
   */
  public void setClientDefined1CharCode8(String clientDefined1CharCode8) {
    this.clientDefined1CharCode8 = clientDefined1CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code9.
   *
   * @param  clientDefined1CharCode9  String
   */
  public void setClientDefined1CharCode9(String clientDefined1CharCode9) {
    this.clientDefined1CharCode9 = clientDefined1CharCode9;
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
   * setter method for client defined20 char code10.
   *
   * @param  clientDefined20CharCode10  String
   */
  public void setClientDefined20CharCode10(String clientDefined20CharCode10) {
    this.clientDefined20CharCode10 = clientDefined20CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code11.
   *
   * @param  clientDefined20CharCode11  String
   */
  public void setClientDefined20CharCode11(String clientDefined20CharCode11) {
    this.clientDefined20CharCode11 = clientDefined20CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code12.
   *
   * @param  clientDefined20CharCode12  String
   */
  public void setClientDefined20CharCode12(String clientDefined20CharCode12) {
    this.clientDefined20CharCode12 = clientDefined20CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code13.
   *
   * @param  clientDefined20CharCode13  String
   */
  public void setClientDefined20CharCode13(String clientDefined20CharCode13) {
    this.clientDefined20CharCode13 = clientDefined20CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code14.
   *
   * @param  clientDefined20CharCode14  String
   */
  public void setClientDefined20CharCode14(String clientDefined20CharCode14) {
    this.clientDefined20CharCode14 = clientDefined20CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code15.
   *
   * @param  clientDefined20CharCode15  String
   */
  public void setClientDefined20CharCode15(String clientDefined20CharCode15) {
    this.clientDefined20CharCode15 = clientDefined20CharCode15;
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
   * setter method for client defined20 char code6.
   *
   * @param  clientDefined20CharCode6  String
   */
  public void setClientDefined20CharCode6(String clientDefined20CharCode6) {
    this.clientDefined20CharCode6 = clientDefined20CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code7.
   *
   * @param  clientDefined20CharCode7  String
   */
  public void setClientDefined20CharCode7(String clientDefined20CharCode7) {
    this.clientDefined20CharCode7 = clientDefined20CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code8.
   *
   * @param  clientDefined20CharCode8  String
   */
  public void setClientDefined20CharCode8(String clientDefined20CharCode8) {
    this.clientDefined20CharCode8 = clientDefined20CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code9.
   *
   * @param  clientDefined20CharCode9  String
   */
  public void setClientDefined20CharCode9(String clientDefined20CharCode9) {
    this.clientDefined20CharCode9 = clientDefined20CharCode9;
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
   * setter method for client defined25 char code10.
   *
   * @param  clientDefined25CharCode10  String
   */
  public void setClientDefined25CharCode10(String clientDefined25CharCode10) {
    this.clientDefined25CharCode10 = clientDefined25CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code11.
   *
   * @param  clientDefined25CharCode11  String
   */
  public void setClientDefined25CharCode11(String clientDefined25CharCode11) {
    this.clientDefined25CharCode11 = clientDefined25CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code12.
   *
   * @param  clientDefined25CharCode12  String
   */
  public void setClientDefined25CharCode12(String clientDefined25CharCode12) {
    this.clientDefined25CharCode12 = clientDefined25CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code13.
   *
   * @param  clientDefined25CharCode13  String
   */
  public void setClientDefined25CharCode13(String clientDefined25CharCode13) {
    this.clientDefined25CharCode13 = clientDefined25CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code14.
   *
   * @param  clientDefined25CharCode14  String
   */
  public void setClientDefined25CharCode14(String clientDefined25CharCode14) {
    this.clientDefined25CharCode14 = clientDefined25CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code15.
   *
   * @param  clientDefined25CharCode15  String
   */
  public void setClientDefined25CharCode15(String clientDefined25CharCode15) {
    this.clientDefined25CharCode15 = clientDefined25CharCode15;
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
   * setter method for client defined25 char code4.
   *
   * @param  clientDefined25CharCode4  String
   */
  public void setClientDefined25CharCode4(String clientDefined25CharCode4) {
    this.clientDefined25CharCode4 = clientDefined25CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code5.
   *
   * @param  clientDefined25CharCode5  String
   */
  public void setClientDefined25CharCode5(String clientDefined25CharCode5) {
    this.clientDefined25CharCode5 = clientDefined25CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code6.
   *
   * @param  clientDefined25CharCode6  String
   */
  public void setClientDefined25CharCode6(String clientDefined25CharCode6) {
    this.clientDefined25CharCode6 = clientDefined25CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code7.
   *
   * @param  clientDefined25CharCode7  String
   */
  public void setClientDefined25CharCode7(String clientDefined25CharCode7) {
    this.clientDefined25CharCode7 = clientDefined25CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code8.
   *
   * @param  clientDefined25CharCode8  String
   */
  public void setClientDefined25CharCode8(String clientDefined25CharCode8) {
    this.clientDefined25CharCode8 = clientDefined25CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined25 char code9.
   *
   * @param  clientDefined25CharCode9  String
   */
  public void setClientDefined25CharCode9(String clientDefined25CharCode9) {
    this.clientDefined25CharCode9 = clientDefined25CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code1.
   *
   * @param  clientDefined2CharCode1  String
   */
  public void setClientDefined2CharCode1(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code2.
   *
   * @param  clientDefined2CharCode2  String
   */
  public void setClientDefined2CharCode2(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code3.
   *
   * @param  clientDefined2CharCode3  String
   */
  public void setClientDefined2CharCode3(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code4.
   *
   * @param  clientDefined2CharCode4  String
   */
  public void setClientDefined2CharCode4(String clientDefined2CharCode4) {
    this.clientDefined2CharCode4 = clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code5.
   *
   * @param  clientDefined2CharCode5  String
   */
  public void setClientDefined2CharCode5(String clientDefined2CharCode5) {
    this.clientDefined2CharCode5 = clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code1.
   *
   * @param  clientDefined32CharCode1  String
   */
  public void setClientDefined32CharCode1(String clientDefined32CharCode1) {
    this.clientDefined32CharCode1 = clientDefined32CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code10.
   *
   * @param  clientDefined32CharCode10  String
   */
  public void setClientDefined32CharCode10(String clientDefined32CharCode10) {
    this.clientDefined32CharCode10 = clientDefined32CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code2.
   *
   * @param  clientDefined32CharCode2  String
   */
  public void setClientDefined32CharCode2(String clientDefined32CharCode2) {
    this.clientDefined32CharCode2 = clientDefined32CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code3.
   *
   * @param  clientDefined32CharCode3  String
   */
  public void setClientDefined32CharCode3(String clientDefined32CharCode3) {
    this.clientDefined32CharCode3 = clientDefined32CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code4.
   *
   * @param  clientDefined32CharCode4  String
   */
  public void setClientDefined32CharCode4(String clientDefined32CharCode4) {
    this.clientDefined32CharCode4 = clientDefined32CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code5.
   *
   * @param  clientDefined32CharCode5  String
   */
  public void setClientDefined32CharCode5(String clientDefined32CharCode5) {
    this.clientDefined32CharCode5 = clientDefined32CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code6.
   *
   * @param  clientDefined32CharCode6  String
   */
  public void setClientDefined32CharCode6(String clientDefined32CharCode6) {
    this.clientDefined32CharCode6 = clientDefined32CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code7.
   *
   * @param  clientDefined32CharCode7  String
   */
  public void setClientDefined32CharCode7(String clientDefined32CharCode7) {
    this.clientDefined32CharCode7 = clientDefined32CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code8.
   *
   * @param  clientDefined32CharCode8  String
   */
  public void setClientDefined32CharCode8(String clientDefined32CharCode8) {
    this.clientDefined32CharCode8 = clientDefined32CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined32 char code9.
   *
   * @param  clientDefined32CharCode9  String
   */
  public void setClientDefined32CharCode9(String clientDefined32CharCode9) {
    this.clientDefined32CharCode9 = clientDefined32CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code1.
   *
   * @param  clientDefined35CharCode1  String
   */
  public void setClientDefined35CharCode1(String clientDefined35CharCode1) {
    this.clientDefined35CharCode1 = clientDefined35CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code10.
   *
   * @param  clientDefined35CharCode10  String
   */
  public void setClientDefined35CharCode10(String clientDefined35CharCode10) {
    this.clientDefined35CharCode10 = clientDefined35CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code2.
   *
   * @param  clientDefined35CharCode2  String
   */
  public void setClientDefined35CharCode2(String clientDefined35CharCode2) {
    this.clientDefined35CharCode2 = clientDefined35CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code3.
   *
   * @param  clientDefined35CharCode3  String
   */
  public void setClientDefined35CharCode3(String clientDefined35CharCode3) {
    this.clientDefined35CharCode3 = clientDefined35CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code4.
   *
   * @param  clientDefined35CharCode4  String
   */
  public void setClientDefined35CharCode4(String clientDefined35CharCode4) {
    this.clientDefined35CharCode4 = clientDefined35CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code5.
   *
   * @param  clientDefined35CharCode5  String
   */
  public void setClientDefined35CharCode5(String clientDefined35CharCode5) {
    this.clientDefined35CharCode5 = clientDefined35CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code6.
   *
   * @param  clientDefined35CharCode6  String
   */
  public void setClientDefined35CharCode6(String clientDefined35CharCode6) {
    this.clientDefined35CharCode6 = clientDefined35CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code7.
   *
   * @param  clientDefined35CharCode7  String
   */
  public void setClientDefined35CharCode7(String clientDefined35CharCode7) {
    this.clientDefined35CharCode7 = clientDefined35CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code8.
   *
   * @param  clientDefined35CharCode8  String
   */
  public void setClientDefined35CharCode8(String clientDefined35CharCode8) {
    this.clientDefined35CharCode8 = clientDefined35CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined35 char code9.
   *
   * @param  clientDefined35CharCode9  String
   */
  public void setClientDefined35CharCode9(String clientDefined35CharCode9) {
    this.clientDefined35CharCode9 = clientDefined35CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code1.
   *
   * @param  clientDefined3CharCode1  String
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code2.
   *
   * @param  clientDefined3CharCode2  String
   */
  public void setClientDefined3CharCode2(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code3.
   *
   * @param  clientDefined3CharCode3  String
   */
  public void setClientDefined3CharCode3(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code4.
   *
   * @param  clientDefined3CharCode4  String
   */
  public void setClientDefined3CharCode4(String clientDefined3CharCode4) {
    this.clientDefined3CharCode4 = clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code5.
   *
   * @param  clientDefined3CharCode5  String
   */
  public void setClientDefined3CharCode5(String clientDefined3CharCode5) {
    this.clientDefined3CharCode5 = clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code1.
   *
   * @param  clientDefined45CharCode1  String
   */
  public void setClientDefined45CharCode1(String clientDefined45CharCode1) {
    this.clientDefined45CharCode1 = clientDefined45CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code10.
   *
   * @param  clientDefined45CharCode10  String
   */
  public void setClientDefined45CharCode10(String clientDefined45CharCode10) {
    this.clientDefined45CharCode10 = clientDefined45CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code11.
   *
   * @param  clientDefined45CharCode11  String
   */
  public void setClientDefined45CharCode11(String clientDefined45CharCode11) {
    this.clientDefined45CharCode11 = clientDefined45CharCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code12.
   *
   * @param  clientDefined45CharCode12  String
   */
  public void setClientDefined45CharCode12(String clientDefined45CharCode12) {
    this.clientDefined45CharCode12 = clientDefined45CharCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code13.
   *
   * @param  clientDefined45CharCode13  String
   */
  public void setClientDefined45CharCode13(String clientDefined45CharCode13) {
    this.clientDefined45CharCode13 = clientDefined45CharCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code14.
   *
   * @param  clientDefined45CharCode14  String
   */
  public void setClientDefined45CharCode14(String clientDefined45CharCode14) {
    this.clientDefined45CharCode14 = clientDefined45CharCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code15.
   *
   * @param  clientDefined45CharCode15  String
   */
  public void setClientDefined45CharCode15(String clientDefined45CharCode15) {
    this.clientDefined45CharCode15 = clientDefined45CharCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code16.
   *
   * @param  clientDefined45CharCode16  String
   */
  public void setClientDefined45CharCode16(String clientDefined45CharCode16) {
    this.clientDefined45CharCode16 = clientDefined45CharCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code17.
   *
   * @param  clientDefined45CharCode17  String
   */
  public void setClientDefined45CharCode17(String clientDefined45CharCode17) {
    this.clientDefined45CharCode17 = clientDefined45CharCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code18.
   *
   * @param  clientDefined45CharCode18  String
   */
  public void setClientDefined45CharCode18(String clientDefined45CharCode18) {
    this.clientDefined45CharCode18 = clientDefined45CharCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code19.
   *
   * @param  clientDefined45CharCode19  String
   */
  public void setClientDefined45CharCode19(String clientDefined45CharCode19) {
    this.clientDefined45CharCode19 = clientDefined45CharCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code2.
   *
   * @param  clientDefined45CharCode2  String
   */
  public void setClientDefined45CharCode2(String clientDefined45CharCode2) {
    this.clientDefined45CharCode2 = clientDefined45CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code20.
   *
   * @param  clientDefined45CharCode20  String
   */
  public void setClientDefined45CharCode20(String clientDefined45CharCode20) {
    this.clientDefined45CharCode20 = clientDefined45CharCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code3.
   *
   * @param  clientDefined45CharCode3  String
   */
  public void setClientDefined45CharCode3(String clientDefined45CharCode3) {
    this.clientDefined45CharCode3 = clientDefined45CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code4.
   *
   * @param  clientDefined45CharCode4  String
   */
  public void setClientDefined45CharCode4(String clientDefined45CharCode4) {
    this.clientDefined45CharCode4 = clientDefined45CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code5.
   *
   * @param  clientDefined45CharCode5  String
   */
  public void setClientDefined45CharCode5(String clientDefined45CharCode5) {
    this.clientDefined45CharCode5 = clientDefined45CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code6.
   *
   * @param  clientDefined45CharCode6  String
   */
  public void setClientDefined45CharCode6(String clientDefined45CharCode6) {
    this.clientDefined45CharCode6 = clientDefined45CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code7.
   *
   * @param  clientDefined45CharCode7  String
   */
  public void setClientDefined45CharCode7(String clientDefined45CharCode7) {
    this.clientDefined45CharCode7 = clientDefined45CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code8.
   *
   * @param  clientDefined45CharCode8  String
   */
  public void setClientDefined45CharCode8(String clientDefined45CharCode8) {
    this.clientDefined45CharCode8 = clientDefined45CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined45 char code9.
   *
   * @param  clientDefined45CharCode9  String
   */
  public void setClientDefined45CharCode9(String clientDefined45CharCode9) {
    this.clientDefined45CharCode9 = clientDefined45CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code1.
   *
   * @param  clientDefined4CharCode1  String
   */
  public void setClientDefined4CharCode1(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code2.
   *
   * @param  clientDefined4CharCode2  String
   */
  public void setClientDefined4CharCode2(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code3.
   *
   * @param  clientDefined4CharCode3  String
   */
  public void setClientDefined4CharCode3(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code4.
   *
   * @param  clientDefined4CharCode4  String
   */
  public void setClientDefined4CharCode4(String clientDefined4CharCode4) {
    this.clientDefined4CharCode4 = clientDefined4CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code5.
   *
   * @param  clientDefined4CharCode5  String
   */
  public void setClientDefined4CharCode5(String clientDefined4CharCode5) {
    this.clientDefined4CharCode5 = clientDefined4CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code6.
   *
   * @param  clientDefined4CharCode6  String
   */
  public void setClientDefined4CharCode6(String clientDefined4CharCode6) {
    this.clientDefined4CharCode6 = clientDefined4CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code7.
   *
   * @param  clientDefined4CharCode7  String
   */
  public void setClientDefined4CharCode7(String clientDefined4CharCode7) {
    this.clientDefined4CharCode7 = clientDefined4CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code8.
   *
   * @param  clientDefined4CharCode8  String
   */
  public void setClientDefined4CharCode8(String clientDefined4CharCode8) {
    this.clientDefined4CharCode8 = clientDefined4CharCode8;
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
   * setter method for client defined5 char code10.
   *
   * @param  clientDefined5CharCode10  String
   */
  public void setClientDefined5CharCode10(String clientDefined5CharCode10) {
    this.clientDefined5CharCode10 = clientDefined5CharCode10;
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
   * setter method for client defined5 char code4.
   *
   * @param  clientDefined5CharCode4  String
   */
  public void setClientDefined5CharCode4(String clientDefined5CharCode4) {
    this.clientDefined5CharCode4 = clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code5.
   *
   * @param  clientDefined5CharCode5  String
   */
  public void setClientDefined5CharCode5(String clientDefined5CharCode5) {
    this.clientDefined5CharCode5 = clientDefined5CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code6.
   *
   * @param  clientDefined5CharCode6  String
   */
  public void setClientDefined5CharCode6(String clientDefined5CharCode6) {
    this.clientDefined5CharCode6 = clientDefined5CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code7.
   *
   * @param  clientDefined5CharCode7  String
   */
  public void setClientDefined5CharCode7(String clientDefined5CharCode7) {
    this.clientDefined5CharCode7 = clientDefined5CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code8.
   *
   * @param  clientDefined5CharCode8  String
   */
  public void setClientDefined5CharCode8(String clientDefined5CharCode8) {
    this.clientDefined5CharCode8 = clientDefined5CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code9.
   *
   * @param  clientDefined5CharCode9  String
   */
  public void setClientDefined5CharCode9(String clientDefined5CharCode9) {
    this.clientDefined5CharCode9 = clientDefined5CharCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code1.
   *
   * @param  clientDefined8CharCode1  String
   */
  public void setClientDefined8CharCode1(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code10.
   *
   * @param  clientDefined8CharCode10  String
   */
  public void setClientDefined8CharCode10(String clientDefined8CharCode10) {
    this.clientDefined8CharCode10 = clientDefined8CharCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code2.
   *
   * @param  clientDefined8CharCode2  String
   */
  public void setClientDefined8CharCode2(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code3.
   *
   * @param  clientDefined8CharCode3  String
   */
  public void setClientDefined8CharCode3(String clientDefined8CharCode3) {
    this.clientDefined8CharCode3 = clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code4.
   *
   * @param  clientDefined8CharCode4  String
   */
  public void setClientDefined8CharCode4(String clientDefined8CharCode4) {
    this.clientDefined8CharCode4 = clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code5.
   *
   * @param  clientDefined8CharCode5  String
   */
  public void setClientDefined8CharCode5(String clientDefined8CharCode5) {
    this.clientDefined8CharCode5 = clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code6.
   *
   * @param  clientDefined8CharCode6  String
   */
  public void setClientDefined8CharCode6(String clientDefined8CharCode6) {
    this.clientDefined8CharCode6 = clientDefined8CharCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code7.
   *
   * @param  clientDefined8CharCode7  String
   */
  public void setClientDefined8CharCode7(String clientDefined8CharCode7) {
    this.clientDefined8CharCode7 = clientDefined8CharCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code8.
   *
   * @param  clientDefined8CharCode8  String
   */
  public void setClientDefined8CharCode8(String clientDefined8CharCode8) {
    this.clientDefined8CharCode8 = clientDefined8CharCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code9.
   *
   * @param  clientDefined8CharCode9  String
   */
  public void setClientDefined8CharCode9(String clientDefined8CharCode9) {
    this.clientDefined8CharCode9 = clientDefined8CharCode9;
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
   * setter method for client defined date10.
   *
   * @param  clientDefinedDate10  Date
   */
  public void setClientDefinedDate10(Date clientDefinedDate10) {
    this.clientDefinedDate10 = clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date11.
   *
   * @param  clientDefinedDate11  Date
   */
  public void setClientDefinedDate11(Date clientDefinedDate11) {
    this.clientDefinedDate11 = clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date12.
   *
   * @param  clientDefinedDate12  Date
   */
  public void setClientDefinedDate12(Date clientDefinedDate12) {
    this.clientDefinedDate12 = clientDefinedDate12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date13.
   *
   * @param  clientDefinedDate13  Date
   */
  public void setClientDefinedDate13(Date clientDefinedDate13) {
    this.clientDefinedDate13 = clientDefinedDate13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date14.
   *
   * @param  clientDefinedDate14  Date
   */
  public void setClientDefinedDate14(Date clientDefinedDate14) {
    this.clientDefinedDate14 = clientDefinedDate14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date15.
   *
   * @param  clientDefinedDate15  Date
   */
  public void setClientDefinedDate15(Date clientDefinedDate15) {
    this.clientDefinedDate15 = clientDefinedDate15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date16.
   *
   * @param  clientDefinedDate16  Date
   */
  public void setClientDefinedDate16(Date clientDefinedDate16) {
    this.clientDefinedDate16 = clientDefinedDate16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date17.
   *
   * @param  clientDefinedDate17  Date
   */
  public void setClientDefinedDate17(Date clientDefinedDate17) {
    this.clientDefinedDate17 = clientDefinedDate17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date18.
   *
   * @param  clientDefinedDate18  Date
   */
  public void setClientDefinedDate18(Date clientDefinedDate18) {
    this.clientDefinedDate18 = clientDefinedDate18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date19.
   *
   * @param  clientDefinedDate19  Date
   */
  public void setClientDefinedDate19(Date clientDefinedDate19) {
    this.clientDefinedDate19 = clientDefinedDate19;
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
   * setter method for client defined date20.
   *
   * @param  clientDefinedDate20  Date
   */
  public void setClientDefinedDate20(Date clientDefinedDate20) {
    this.clientDefinedDate20 = clientDefinedDate20;
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
   * setter method for client defined date7.
   *
   * @param  clientDefinedDate7  Date
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
   * setter method for client defined decimal10.
   *
   * @param  clientDefinedDecimal10  BigDecimal
   */
  public void setClientDefinedDecimal10(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal11.
   *
   * @param  clientDefinedDecimal11  BigDecimal
   */
  public void setClientDefinedDecimal11(BigDecimal clientDefinedDecimal11) {
    this.clientDefinedDecimal11 = clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal12.
   *
   * @param  clientDefinedDecimal12  BigDecimal
   */
  public void setClientDefinedDecimal12(BigDecimal clientDefinedDecimal12) {
    this.clientDefinedDecimal12 = clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal13.
   *
   * @param  clientDefinedDecimal13  BigDecimal
   */
  public void setClientDefinedDecimal13(BigDecimal clientDefinedDecimal13) {
    this.clientDefinedDecimal13 = clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal14.
   *
   * @param  clientDefinedDecimal14  BigDecimal
   */
  public void setClientDefinedDecimal14(BigDecimal clientDefinedDecimal14) {
    this.clientDefinedDecimal14 = clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal15.
   *
   * @param  clientDefinedDecimal15  BigDecimal
   */
  public void setClientDefinedDecimal15(BigDecimal clientDefinedDecimal15) {
    this.clientDefinedDecimal15 = clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal16.
   *
   * @param  clientDefinedDecimal16  BigDecimal
   */
  public void setClientDefinedDecimal16(BigDecimal clientDefinedDecimal16) {
    this.clientDefinedDecimal16 = clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal17.
   *
   * @param  clientDefinedDecimal17  BigDecimal
   */
  public void setClientDefinedDecimal17(BigDecimal clientDefinedDecimal17) {
    this.clientDefinedDecimal17 = clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal18.
   *
   * @param  clientDefinedDecimal18  BigDecimal
   */
  public void setClientDefinedDecimal18(BigDecimal clientDefinedDecimal18) {
    this.clientDefinedDecimal18 = clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal19.
   *
   * @param  clientDefinedDecimal19  BigDecimal
   */
  public void setClientDefinedDecimal19(BigDecimal clientDefinedDecimal19) {
    this.clientDefinedDecimal19 = clientDefinedDecimal19;
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
   * setter method for client defined decimal20.
   *
   * @param  clientDefinedDecimal20  BigDecimal
   */
  public void setClientDefinedDecimal20(BigDecimal clientDefinedDecimal20) {
    this.clientDefinedDecimal20 = clientDefinedDecimal20;
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
   * setter method for client defined decimal4.
   *
   * @param  clientDefinedDecimal4  BigDecimal
   */
  public void setClientDefinedDecimal4(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal5.
   *
   * @param  clientDefinedDecimal5  BigDecimal
   */
  public void setClientDefinedDecimal5(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal6.
   *
   * @param  clientDefinedDecimal6  BigDecimal
   */
  public void setClientDefinedDecimal6(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal7.
   *
   * @param  clientDefinedDecimal7  BigDecimal
   */
  public void setClientDefinedDecimal7(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal8.
   *
   * @param  clientDefinedDecimal8  BigDecimal
   */
  public void setClientDefinedDecimal8(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal9.
   *
   * @param  clientDefinedDecimal9  BigDecimal
   */
  public void setClientDefinedDecimal9(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
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
   * @param  clientDefinedEncryptedField2  DOCUMENT ME!
   */
  public void setClientDefinedEncryptedField2(String clientDefinedEncryptedField2) {
    this.clientDefinedEncryptedField2 = clientDefinedEncryptedField2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientDefinedEncryptedField3  DOCUMENT ME!
   */
  public void setClientDefinedEncryptedField3(String clientDefinedEncryptedField3) {
    this.clientDefinedEncryptedField3 = clientDefinedEncryptedField3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  Boolean
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  Boolean
   */
  public void setClientDefinedFlag2(Boolean clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag3.
   *
   * @param  clientDefinedFlag3  Boolean
   */
  public void setClientDefinedFlag3(Boolean clientDefinedFlag3) {
    this.clientDefinedFlag3 = clientDefinedFlag3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag4.
   *
   * @param  clientDefinedFlag4  Boolean
   */
  public void setClientDefinedFlag4(Boolean clientDefinedFlag4) {
    this.clientDefinedFlag4 = clientDefinedFlag4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag5.
   *
   * @param  clientDefinedFlag5  Boolean
   */
  public void setClientDefinedFlag5(Boolean clientDefinedFlag5) {
    this.clientDefinedFlag5 = clientDefinedFlag5;
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
   * setter method for client defined integer10.
   *
   * @param  clientDefinedInteger10  Integer
   */
  public void setClientDefinedInteger10(Integer clientDefinedInteger10) {
    this.clientDefinedInteger10 = clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer11.
   *
   * @param  clientDefinedInteger11  Integer
   */
  public void setClientDefinedInteger11(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer12.
   *
   * @param  clientDefinedInteger12  Integer
   */
  public void setClientDefinedInteger12(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer13.
   *
   * @param  clientDefinedInteger13  Integer
   */
  public void setClientDefinedInteger13(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer14.
   *
   * @param  clientDefinedInteger14  Integer
   */
  public void setClientDefinedInteger14(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer15.
   *
   * @param  clientDefinedInteger15  Integer
   */
  public void setClientDefinedInteger15(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer16.
   *
   * @param  clientDefinedInteger16  Integer
   */
  public void setClientDefinedInteger16(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer17.
   *
   * @param  clientDefinedInteger17  Integer
   */
  public void setClientDefinedInteger17(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer18.
   *
   * @param  clientDefinedInteger18  Integer
   */
  public void setClientDefinedInteger18(Integer clientDefinedInteger18) {
    this.clientDefinedInteger18 = clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer19.
   *
   * @param  clientDefinedInteger19  Integer
   */
  public void setClientDefinedInteger19(Integer clientDefinedInteger19) {
    this.clientDefinedInteger19 = clientDefinedInteger19;
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
   * setter method for client defined integer20.
   *
   * @param  clientDefinedInteger20  Integer
   */
  public void setClientDefinedInteger20(Integer clientDefinedInteger20) {
    this.clientDefinedInteger20 = clientDefinedInteger20;
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
   * setter method for client defined integer4.
   *
   * @param  clientDefinedInteger4  Integer
   */
  public void setClientDefinedInteger4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer5.
   *
   * @param  clientDefinedInteger5  Integer
   */
  public void setClientDefinedInteger5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer6.
   *
   * @param  clientDefinedInteger6  Integer
   */
  public void setClientDefinedInteger6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer7.
   *
   * @param  clientDefinedInteger7  Integer
   */
  public void setClientDefinedInteger7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer8.
   *
   * @param  clientDefinedInteger8  Integer
   */
  public void setClientDefinedInteger8(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer9.
   *
   * @param  clientDefinedInteger9  Integer
   */
  public void setClientDefinedInteger9(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long1.
   *
   * @param  clientDefinedLong1  Long
   */
  public void setClientDefinedLong1(Long clientDefinedLong1) {
    this.clientDefinedLong1 = clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long10.
   *
   * @param  clientDefinedLong10  Long
   */
  public void setClientDefinedLong10(Long clientDefinedLong10) {
    this.clientDefinedLong10 = clientDefinedLong10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long2.
   *
   * @param  clientDefinedLong2  Long
   */
  public void setClientDefinedLong2(Long clientDefinedLong2) {
    this.clientDefinedLong2 = clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long3.
   *
   * @param  clientDefinedLong3  Long
   */
  public void setClientDefinedLong3(Long clientDefinedLong3) {
    this.clientDefinedLong3 = clientDefinedLong3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long4.
   *
   * @param  clientDefinedLong4  Long
   */
  public void setClientDefinedLong4(Long clientDefinedLong4) {
    this.clientDefinedLong4 = clientDefinedLong4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long5.
   *
   * @param  clientDefinedLong5  Long
   */
  public void setClientDefinedLong5(Long clientDefinedLong5) {
    this.clientDefinedLong5 = clientDefinedLong5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long6.
   *
   * @param  clientDefinedLong6  Long
   */
  public void setClientDefinedLong6(Long clientDefinedLong6) {
    this.clientDefinedLong6 = clientDefinedLong6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long7.
   *
   * @param  clientDefinedLong7  Long
   */
  public void setClientDefinedLong7(Long clientDefinedLong7) {
    this.clientDefinedLong7 = clientDefinedLong7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long8.
   *
   * @param  clientDefinedLong8  Long
   */
  public void setClientDefinedLong8(Long clientDefinedLong8) {
    this.clientDefinedLong8 = clientDefinedLong8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long9.
   *
   * @param  clientDefinedLong9  Long
   */
  public void setClientDefinedLong9(Long clientDefinedLong9) {
    this.clientDefinedLong9 = clientDefinedLong9;
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
   * setter method for client defined string10.
   *
   * @param  clientDefinedString10  String
   */
  public void setClientDefinedString10(String clientDefinedString10) {
    this.clientDefinedString10 = clientDefinedString10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string11.
   *
   * @param  clientDefinedString11  String
   */
  public void setClientDefinedString11(String clientDefinedString11) {
    this.clientDefinedString11 = clientDefinedString11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string12.
   *
   * @param  clientDefinedString12  String
   */
  public void setClientDefinedString12(String clientDefinedString12) {
    this.clientDefinedString12 = clientDefinedString12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string13.
   *
   * @param  clientDefinedString13  String
   */
  public void setClientDefinedString13(String clientDefinedString13) {
    this.clientDefinedString13 = clientDefinedString13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string14.
   *
   * @param  clientDefinedString14  String
   */
  public void setClientDefinedString14(String clientDefinedString14) {
    this.clientDefinedString14 = clientDefinedString14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string15.
   *
   * @param  clientDefinedString15  String
   */
  public void setClientDefinedString15(String clientDefinedString15) {
    this.clientDefinedString15 = clientDefinedString15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string16.
   *
   * @param  clientDefinedString16  String
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
   * setter method for client defined string19.
   *
   * @param  clientDefinedString19  String
   */
  public void setClientDefinedString19(String clientDefinedString19) {
    this.clientDefinedString19 = clientDefinedString19;
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
   * setter method for client defined string20.
   *
   * @param  clientDefinedString20  String
   */
  public void setClientDefinedString20(String clientDefinedString20) {
    this.clientDefinedString20 = clientDefinedString20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string21.
   *
   * @param  clientDefinedString21  String
   */
  public void setClientDefinedString21(String clientDefinedString21) {
    this.clientDefinedString21 = clientDefinedString21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string22.
   *
   * @param  clientDefinedString22  String
   */
  public void setClientDefinedString22(String clientDefinedString22) {
    this.clientDefinedString22 = clientDefinedString22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string23.
   *
   * @param  clientDefinedString23  String
   */
  public void setClientDefinedString23(String clientDefinedString23) {
    this.clientDefinedString23 = clientDefinedString23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string24.
   *
   * @param  clientDefinedString24  String
   */
  public void setClientDefinedString24(String clientDefinedString24) {
    this.clientDefinedString24 = clientDefinedString24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string25.
   *
   * @param  clientDefinedString25  String
   */
  public void setClientDefinedString25(String clientDefinedString25) {
    this.clientDefinedString25 = clientDefinedString25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string26.
   *
   * @param  clientDefinedString26  String
   */
  public void setClientDefinedString26(String clientDefinedString26) {
    this.clientDefinedString26 = clientDefinedString26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string27.
   *
   * @param  clientDefinedString27  String
   */
  public void setClientDefinedString27(String clientDefinedString27) {
    this.clientDefinedString27 = clientDefinedString27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string28.
   *
   * @param  clientDefinedString28  String
   */
  public void setClientDefinedString28(String clientDefinedString28) {
    this.clientDefinedString28 = clientDefinedString28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string29.
   *
   * @param  clientDefinedString29  String
   */
  public void setClientDefinedString29(String clientDefinedString29) {
    this.clientDefinedString29 = clientDefinedString29;
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
   * setter method for client defined string30.
   *
   * @param  clientDefinedString30  String
   */
  public void setClientDefinedString30(String clientDefinedString30) {
    this.clientDefinedString30 = clientDefinedString30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string31.
   *
   * @param  clientDefinedString31  String
   */
  public void setClientDefinedString31(String clientDefinedString31) {
    this.clientDefinedString31 = clientDefinedString31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string32.
   *
   * @param  clientDefinedString32  String
   */
  public void setClientDefinedString32(String clientDefinedString32) {
    this.clientDefinedString32 = clientDefinedString32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string33.
   *
   * @param  clientDefinedString33  String
   */
  public void setClientDefinedString33(String clientDefinedString33) {
    this.clientDefinedString33 = clientDefinedString33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string34.
   *
   * @param  clientDefinedString34  String
   */
  public void setClientDefinedString34(String clientDefinedString34) {
    this.clientDefinedString34 = clientDefinedString34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string35.
   *
   * @param  clientDefinedString35  String
   */
  public void setClientDefinedString35(String clientDefinedString35) {
    this.clientDefinedString35 = clientDefinedString35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string4.
   *
   * @param  clientDefinedString4  String
   */
  public void setClientDefinedString4(String clientDefinedString4) {
    this.clientDefinedString4 = clientDefinedString4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string5.
   *
   * @param  clientDefinedString5  String
   */
  public void setClientDefinedString5(String clientDefinedString5) {
    this.clientDefinedString5 = clientDefinedString5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string6.
   *
   * @param  clientDefinedString6  String
   */
  public void setClientDefinedString6(String clientDefinedString6) {
    this.clientDefinedString6 = clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string7.
   *
   * @param  clientDefinedString7  String
   */
  public void setClientDefinedString7(String clientDefinedString7) {
    this.clientDefinedString7 = clientDefinedString7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string8.
   *
   * @param  clientDefinedString8  String
   */
  public void setClientDefinedString8(String clientDefinedString8) {
    this.clientDefinedString8 = clientDefinedString8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string9.
   *
   * @param  clientDefinedString9  String
   */
  public void setClientDefinedString9(String clientDefinedString9) {
    this.clientDefinedString9 = clientDefinedString9;
  }

} // end class AccountAdditionalDetail
