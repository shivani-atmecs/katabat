package com.cmc.credagility.core.domain.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  02/27/2015 11:15
 */
@Entity
@Table(
  name              = "CustomerScoreType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "customerScoreName") }
)
public class CustomerScoreType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -748395413819609591L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name   = "customerScoreDescription",
    length = 200
  )
  private String customerScoreDescription;

  @Column(
    name   = "customerScoreName",
    unique = true,
    length = 60
  )
  private String customerScoreName;

  @Column(
    name     = "customerScoreTypeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long customerScoreTypeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new CustomerScoreType object.
   */
  public CustomerScoreType() {
    super();
  }

  /**
   * Creates a new CustomerScoreType object.
   *
   * @param  typeId  DOCUMENT ME!
   * @param  name    DOCUMENT ME!
   */
  public CustomerScoreType(Long typeId, String name) {
    super();
    this.customerScoreTypeId = typeId;
    this.customerScoreName   = name;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CustomerScoreType other = (CustomerScoreType) obj;

    if (customerScoreName == null) {
      if (other.customerScoreName != null) {
        return false;
      }
    } else if (!customerScoreName.equals(other.customerScoreName)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerScoreDescription() {
    return customerScoreDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCustomerScoreName() {
    return customerScoreName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCustomerScoreTypeId() {
    return customerScoreTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((customerScoreName == null) ? 0 : customerScoreName.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerScoreDescription  DOCUMENT ME!
   */
  public void setCustomerScoreDescription(String customerScoreDescription) {
    this.customerScoreDescription = customerScoreDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerScoreName  DOCUMENT ME!
   */
  public void setCustomerScoreName(String customerScoreName) {
    this.customerScoreName = customerScoreName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerScoreTypeId  DOCUMENT ME!
   */
  public void setCustomerScoreTypeId(Long customerScoreTypeId) {
    this.customerScoreTypeId = customerScoreTypeId;
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

    retValue = "ScoreDetail ( " + super.toString() + TAB + "scoreId = "
      + this.customerScoreTypeId + TAB + "scoreName = " + this.customerScoreName + TAB
      + "scoreDescription = " + this.customerScoreDescription + TAB + " )";

    return retValue;
  }
} // end class CustomerScoreType
