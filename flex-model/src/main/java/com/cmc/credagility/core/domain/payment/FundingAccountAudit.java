package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.annotations.Target;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store funding account change information.
 *
 * <p><a href="FundingAccountAudit.java.html"><i>View Source</i></a></p>
 *
 * @author   DOCUMENT ME!
 * @version  $Revision$, $Date$
 *
 * @hibernate.class
 *   table = "FundingAccountAudit"
 */
@Entity
@Table(name = "FundingAccountAudit")
public class FundingAccountAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6054515507664452002L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name   = "actionPerformed",
    length = 25
  )
  protected String actionPerformed;

  /** DOCUMENT ME! */
  @Column(name = "customerId")
  protected Long customerId;

  /** DOCUMENT ME! */

  /** DOCUMENT ME! */

  @Column(
    name     = "fundingAccountAuditId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long fundingAccountAuditId;

  /** DOCUMENT ME! */
  @Column(name = "fundingAccountId")
  protected Long fundingAccountId;

  /** DOCUMENT ME! */
  @AttributeOverrides(
    {
      @AttributeOverride(
        name = "fundingAccountNum",
        column = @Column(name = "fundingAccountNum")
      ),
      @AttributeOverride(
        name = "holderFullName",
        column = @Column(name = "holderFullName")
      ),
      @AttributeOverride(
        name = "nickName",
        column = @Column(name = "nickName")
      ),
      @AttributeOverride(
        name = "routingNumber",
        column = @Column(name = "routingNumber")
      ),
      @AttributeOverride(
        name = "type",
        column = @Column(name = "type")
      ),
      @AttributeOverride(
        name = "subType",
        column = @Column(name = "subType")
      ),
      @AttributeOverride(
        name = "cvv",
        column = @Column(name = "cvv")
      ),
      @AttributeOverride(
        name = "expirationDate",
        column = @Column(name = "expirationDate")
      ),
      @AttributeOverride(
        name = "address.address1",
        column = @Column(name = "address1")
      ),
      @AttributeOverride(
        name = "address.address2",
        column = @Column(name = "address2")
      ),
      @AttributeOverride(
        name = "address.address3",
        column = @Column(name = "address3")
      ),
      @AttributeOverride(
        name = "address.address4",
        column = @Column(name = "address4")
      ),
      @AttributeOverride(
        name = "address.city",
        column = @Column(name = "city")
      ),
      @AttributeOverride(
        name = "address.country",
        column = @Column(name = "country")
      ),
      @AttributeOverride(
        name = "address.postalCode",
        column = @Column(name = "postalCode")
      ),
      @AttributeOverride(
        name = "address.province",
        column = @Column(name = "province")
      )
    }
  )
  @Embedded
  @Target(FundingInformation.class)
  protected FundingInformation fundingInformation = new FundingInformation();


  /** DOCUMENT ME! */
  @AttributeOverrides(
    {
      @AttributeOverride(
        name = "fundingAccountNum",
        column = @Column(name = "new_fundingAccountNum")
      ),
      @AttributeOverride(
        name = "holderFullName",
        column = @Column(name = "new_holderFullName")
      ),
      @AttributeOverride(
        name = "nickName",
        column = @Column(name = "new_nickName")
      ),
      @AttributeOverride(
        name = "routingNumber",
        column = @Column(name = "new_routingNumber")
      ),
      @AttributeOverride(
        name = "type",
        column = @Column(name = "new_type")
      ),
      @AttributeOverride(
        name = "subType",
        column = @Column(name = "new_subType")
      ),
      @AttributeOverride(
        name = "cvv",
        column = @Column(name = "new_cvv")
      ),
      @AttributeOverride(
        name = "expirationDate",
        column = @Column(name = "new_expirationDate")
      ),
      @AttributeOverride(
        name = "address.address1",
        column = @Column(name = "new_address1")
      ),
      @AttributeOverride(
        name = "address.address2",
        column = @Column(name = "new_address2")
      ),
      @AttributeOverride(
        name = "address.address3",
        column = @Column(name = "new_address3")
      ),
      @AttributeOverride(
        name = "address.address4",
        column = @Column(name = "new_address4")
      ),
      @AttributeOverride(
        name = "address.city",
        column = @Column(name = "new_city")
      ),
      @AttributeOverride(
        name = "address.country",
        column = @Column(name = "new_country")
      ),
      @AttributeOverride(
        name = "address.postalCode",
        column = @Column(name = "new_postalCode")
      ),
      @AttributeOverride(
        name = "address.province",
        column = @Column(name = "new_province")
      )
    }
  )
  @Embedded
  @Target(FundingInformation.class)
  protected FundingInformation new_fundingInformation = new FundingInformation();

  /** DOCUMENT ME! */
  @Column(
    name   = "reserve1",
    length = 50
  )
  protected String reserve1;

  /** DOCUMENT ME! */
  @Column(
    name   = "reserve2",
    length = 50
  )
  protected String reserve2;

  /** DOCUMENT ME! */
  @Column(name = "responsibleId")
  protected Long responsibleId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public FundingAccountAudit() { }

  /**
   * Creates a new $class.name$ object.
   *
   * @param  fundingInformation      DOCUMENT ME!
   * @param  new_fundingInformation  DOCUMENT ME!
   */
  public FundingAccountAudit(FundingInformation fundingInformation, FundingInformation new_fundingInformation) {
    this.fundingInformation.deepCopy(fundingInformation);
    this.new_fundingInformation.deepCopy(new_fundingInformation);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final FundingAccountAudit other = (FundingAccountAudit) obj;

    if (this.customerId == null) {
      if (other.getCustomerId() != null) {
        return false;
      }
    } else if (!this.customerId.equals(other.getCustomerId())) {
      return false;
    }

    if (this.responsibleId == null) {
      if (other.getResponsibleId() != null) {
        return false;
      }
    } else if (!this.responsibleId.equals(other.getResponsibleId())) {
      return false;
    }

    if (this.fundingAccountId == null) {
      if (other.getFundingAccountId() != null) {
        return false;
      }
    } else if (!this.fundingAccountId.equals(other.getFundingAccountId())) {
      return false;
    }

    if (this.fundingInformation == null) {
      if (other.getFundingInformation() != null) {
        return false;
      }
    } else if (!this.fundingInformation.equals(other.getFundingInformation())) {
      return false;
    }

    if (this.new_fundingInformation == null) {
      if (other.getNew_fundingInformation() != null) {
        return false;
      }
    } else if (!this.new_fundingInformation.equals(other.getNew_fundingInformation())) {
      return false;
    }

    if (!Objects.equals(actionPerformed, other.actionPerformed)) {
      return false;
    }

    if (!Objects.equals(reserve1, other.reserve1)) {
      return false;
    }

    if (!Objects.equals(reserve2, other.reserve2)) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  f  DOCUMENT ME!
   */
  public void deepCopy(FundingAccountAudit f) {
    this.fundingInformation.deepCopy(f.getFundingInformation());
    this.new_fundingInformation.deepCopy(f.getNew_fundingInformation());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getActionPerformed() {
    return actionPerformed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFundingAccountAuditId() {
    return fundingAccountAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFundingAccountId() {
    return fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FundingInformation getFundingInformation() {
    return fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public FundingInformation getNew_fundingInformation() {
    return new_fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReserve1() {
    return reserve1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReserve2() {
    return reserve2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getResponsibleId() {
    return responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((this.fundingInformation == null) ? 0 : this.fundingInformation.hashCode());
    result = (PRIME * result) + ((this.new_fundingInformation == null) ? 0 : this.new_fundingInformation.hashCode());
    result = (PRIME * result) + ((this.customerId == null) ? 0 : this.customerId.hashCode());
    result = (PRIME * result) + ((this.responsibleId == null) ? 0 : this.responsibleId.hashCode());
    result = (PRIME * result) + ((this.fundingAccountId == null) ? 0 : this.fundingAccountId.hashCode());
    result = (PRIME * result) + ((actionPerformed != null) ? actionPerformed.hashCode() : 0);
    result = (PRIME * result) + ((reserve1 != null) ? reserve1.hashCode() : 0);
    result = (PRIME * result) + ((reserve2 != null) ? reserve2.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionPerformed  DOCUMENT ME!
   */
  public void setActionPerformed(String actionPerformed) {
    this.actionPerformed = actionPerformed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  customerId  DOCUMENT ME!
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountAuditId  DOCUMENT ME!
   */
  public void setFundingAccountAuditId(Long fundingAccountAuditId) {
    this.fundingAccountAuditId = fundingAccountAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountId  DOCUMENT ME!
   */
  public void setFundingAccountId(Long fundingAccountId) {
    this.fundingAccountId = fundingAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingInformation  DOCUMENT ME!
   */
  public void setFundingInformation(FundingInformation fundingInformation) {
    this.fundingInformation = fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  new_fundingInformation  DOCUMENT ME!
   */
  public void setNew_fundingInformation(FundingInformation new_fundingInformation) {
    this.new_fundingInformation = new_fundingInformation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reserve1  DOCUMENT ME!
   */
  public void setReserve1(String reserve1) {
    this.reserve1 = reserve1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reserve2  DOCUMENT ME!
   */
  public void setReserve2(String reserve2) {
    this.reserve2 = reserve2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsibleId  DOCUMENT ME!
   */
  public void setResponsibleId(Long responsibleId) {
    this.responsibleId = responsibleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("FundingAccountAudit ( ").append("customerId = ").append(this.customerId).append(TAB).append(
      "responsibleId = ").append(this.responsibleId).append(TAB).append("fundingAccountId = ").append(
      this.fundingAccountId).append(TAB).append("fundingInformation = ").append(this.fundingInformation).append(TAB)
      .append("new_fundingInformation = ").append(this.new_fundingInformation).append("actionPerformed = ").append(
      this.actionPerformed).append("reserve1 = ").append(this.reserve1).append("reserve2 = ").append(this.reserve2)
      .append(" )");

    return retValue.toString();
  }
} // end class FundingAccountAudit
