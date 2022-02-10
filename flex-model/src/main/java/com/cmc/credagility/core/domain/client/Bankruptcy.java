package com.cmc.credagility.core.domain.client;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.BankruptcyStatus;
import com.cmc.credagility.core.domain.type.BankruptcyType;
import com.cmc.credagility.core.domain.type.InfoSource;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Bankruptcy information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:38
 */
@Entity
@Table(name = "Bankruptcy")
public class Bankruptcy extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final long serialVersionUID = -2569320270616692189L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "amount1")
  private BigDecimal amount1;
  @Column(name = "amount2")
  private BigDecimal amount2;
  @Column(name = "amount3")
  private BigDecimal amount3;


  @Column(
    name             = "asset",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean asset;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long         bankruptcyId;

  @Column(
    name   = "caseNumber",
    length = 20
  )
  private String caseNumber;

  @Column(
    name   = "courtName",
    length = 20
  )
  private String courtName;

  @Column(
    name   = "data1",
    length = 20
  )
  private String data1;
  @Column(
    name   = "data2",
    length = 20
  )
  private String data2;
  @Column(
    name   = "data3",
    length = 20
  )
  private String data3;

  @Column(name = "date1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date1;
  @Column(name = "date2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date2;
  @Column(name = "date3")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date3;
  @Column(name = "dischargeDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dischargeDate;

  @Column(name = "dismissDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dismissDate;

  @Column(name = "filedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date filedDate;

  // npelleti, 07/30, USBank, Added NotNull Annotation, placed after dischargeDate
  @Column(
    name     = "infoSource",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  private InfoSource infoSource;


  @OneToOne(mappedBy = "bankruptcy")
  private Responsible      responsible;
  @Column(
    name   = "status",
    length = 12
  )
  @Enumerated(value = EnumType.STRING)
  private BankruptcyStatus status;

// npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name     = "type",
    nullable = false,
    length   = 8
  )
  @Enumerated(value = EnumType.STRING)
  private BankruptcyType type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final Bankruptcy other = (Bankruptcy) obj;

    if (amount1 == null) {
      if (other.amount1 != null) {
        return false;
      }
    } else if (!amount1.equals(other.amount1)) {
      return false;
    }

    if (amount2 == null) {
      if (other.amount2 != null) {
        return false;
      }
    } else if (!amount2.equals(other.amount2)) {
      return false;
    }

    if (amount3 == null) {
      if (other.amount3 != null) {
        return false;
      }
    } else if (!amount3.equals(other.amount3)) {
      return false;
    }

    if (caseNumber == null) {
      if (other.caseNumber != null) {
        return false;
      }
    } else if (!caseNumber.equals(other.caseNumber)) {
      return false;
    }

    if (data1 == null) {
      if (other.data1 != null) {
        return false;
      }
    } else if (!data1.equals(other.data1)) {
      return false;
    }

    if (data2 == null) {
      if (other.data2 != null) {
        return false;
      }
    } else if (!data2.equals(other.data2)) {
      return false;
    }

    if (data3 == null) {
      if (other.data3 != null) {
        return false;
      }
    } else if (!data3.equals(other.data3)) {
      return false;
    }

    if (date1 == null) {
      if (other.date1 != null) {
        return false;
      }
    } else if (!date1.equals(other.date1)) {
      return false;
    }

    if (date2 == null) {
      if (other.date2 != null) {
        return false;
      }
    } else if (!date2.equals(other.date2)) {
      return false;
    }

    if (date3 == null) {
      if (other.date3 != null) {
        return false;
      }
    } else if (!date3.equals(other.date3)) {
      return false;
    }

    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
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
  public BigDecimal getAmount1() {
    return amount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAmount2() {
    return amount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getAmount3() {
    return amount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAsset() {
    return asset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBankruptcyId() {
    return bankruptcyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCaseNumber() {
    return caseNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCourtName() {
    return courtName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDate1() {
    return date1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDate2() {
    return date2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDate3() {
    return date3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDischargeDate() {
    return dischargeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDismissDate() {
    return dismissDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getFiledDate() {
    return filedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public InfoSource getInfoSource() {
    return infoSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BankruptcyStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BankruptcyType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((amount1 == null) ? 0 : amount1.hashCode());
    result = (prime * result) + ((amount2 == null) ? 0 : amount2.hashCode());
    result = (prime * result) + ((amount3 == null) ? 0 : amount3.hashCode());
    result = (prime * result)
      + ((caseNumber == null) ? 0 : caseNumber.hashCode());
    result = (prime * result) + ((data1 == null) ? 0 : data1.hashCode());
    result = (prime * result) + ((data2 == null) ? 0 : data2.hashCode());
    result = (prime * result) + ((data3 == null) ? 0 : data3.hashCode());
    result = (prime * result) + ((date1 == null) ? 0 : date1.hashCode());
    result = (prime * result) + ((date2 == null) ? 0 : date2.hashCode());
    result = (prime * result) + ((date3 == null) ? 0 : date3.hashCode());
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount1  DOCUMENT ME!
   */
  public void setAmount1(BigDecimal amount1) {
    this.amount1 = amount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount2  DOCUMENT ME!
   */
  public void setAmount2(BigDecimal amount2) {
    this.amount2 = amount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  amount3  DOCUMENT ME!
   */
  public void setAmount3(BigDecimal amount3) {
    this.amount3 = amount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  asset  DOCUMENT ME!
   */
  public void setAsset(Boolean asset) {
    this.asset = asset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bankruptcyId  DOCUMENT ME!
   */
  public void setBankruptcyId(Long bankruptcyId) {
    this.bankruptcyId = bankruptcyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  caseNumber  DOCUMENT ME!
   */
  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  courtName  DOCUMENT ME!
   */
  public void setCourtName(String courtName) {
    this.courtName = courtName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data1  DOCUMENT ME!
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data2  DOCUMENT ME!
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data3  DOCUMENT ME!
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  date1  DOCUMENT ME!
   */
  public void setDate1(Date date1) {
    this.date1 = date1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  date2  DOCUMENT ME!
   */
  public void setDate2(Date date2) {
    this.date2 = date2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  date3  DOCUMENT ME!
   */
  public void setDate3(Date date3) {
    this.date3 = date3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dischargeDate  DOCUMENT ME!
   */
  public void setDischargeDate(Date dischargeDate) {
    this.dischargeDate = dischargeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dismissDate  DOCUMENT ME!
   */
  public void setDismissDate(Date dismissDate) {
    this.dismissDate = dismissDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  filedDate  DOCUMENT ME!
   */
  public void setFiledDate(Date filedDate) {
    this.filedDate = filedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  infoSource  DOCUMENT ME!
   */
  public void setInfoSource(InfoSource infoSource) {
    this.infoSource = infoSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  DOCUMENT ME!
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(BankruptcyStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void setType(BankruptcyType type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "Bankruptcy ( " + super.toString() + TAB + "bankruptcyId = "
      + this.bankruptcyId + TAB + "type = " + this.type + TAB
      + "caseNumber = " + this.caseNumber + TAB + "amount1 = " + this.amount1
      + TAB + "amount2 = " + this.amount2 + TAB + "amount3 = " + this.amount3
      + TAB + "data1 = " + this.data1 + TAB + "data2 = " + this.data2 + TAB
      + "data3 = " + this.data3 + TAB + "date1 = " + this.date1 + TAB
      + "date2 = " + this.date2 + TAB + "date3 = " + this.date3 + TAB + " )";

    return retValue;
  }

} // end class Bankruptcy
