package com.cmc.credagility.core.domain.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/14/2014 18:06
 */
@Entity
@Table(name = "CustomerEmployment")
public class CustomerEmployment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7707603477452820115L;


  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(CustomerEmployment.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "customerEmploymentId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customerEmploymentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employerName",
    length = 250
  )
  protected String employerName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "employmentStatus",
    length = 150
  )
  protected String employmentStatus;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "jobCode",
    length = 150
  )
  protected String jobCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "natureOfBusiness",
    length = 150
  )
  protected String natureOfBusiness;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "occupation",
    length = 150
  )
  protected String occupation;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final CustomerEmployment other = (CustomerEmployment) obj;

    if (createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (employerName == null) {
      if (other.getEmployerName() != null) {
        return false;
      }
    } else if (!employerName.equals(other.getEmployerName())) {
      return false;
    }

    if (jobCode == null) {
      if (other.getJobCode() != null) {
        return false;
      }
    } else if (!jobCode.equals(other.getJobCode())) {
      return false;
    }

    if (occupation == null) {
      if (other.getOccupation() != null) {
        return false;
      }
    } else if (!occupation.equals(other.getOccupation())) {
      return false;
    }

    if (natureOfBusiness == null) {
      if (other.getNatureOfBusiness() != null) {
        return false;
      }
    } else if (!natureOfBusiness.equals(other.getNatureOfBusiness())) {
      return false;
    }

    if (employmentStatus == null) {
      if (other.getEmploymentStatus() != null) {
        return false;
      }
    } else if (!employmentStatus.equals(other.getEmploymentStatus())) {
      return false;
    }

    if (customer == null) {
      if (other.getCustomer() != null) {
        return false;
      }
    } else if (!customer.equals(other.getCustomer())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer employment id.
   *
   * @return  Long
   */
  public Long getCustomerEmploymentId() {
    return customerEmploymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employer name.
   *
   * @return  String
   */
  public String getEmployerName() {
    return employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for employment status.
   *
   * @return  String
   */
  public String getEmploymentStatus() {
    return employmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for job code.
   *
   * @return  String
   */
  public String getJobCode() {
    return jobCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nature of business.
   *
   * @return  String
   */
  public String getNatureOfBusiness() {
    return natureOfBusiness;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((employerName == null) ? 0 : employerName.hashCode());
    result = (prime * result) + ((occupation == null) ? 0 : occupation.hashCode());
    result = (prime * result) + ((jobCode == null) ? 0 : jobCode.hashCode());
    result = (prime * result) + ((natureOfBusiness == null) ? 0 : natureOfBusiness.hashCode());
    result = (prime * result) + ((employmentStatus == null) ? 0 : employmentStatus.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer employment id.
   *
   * @param  customerEmploymentId  Long
   */
  public void setCustomerEmploymentId(Long customerEmploymentId) {
    this.customerEmploymentId = customerEmploymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employer name.
   *
   * @param  employerName  String
   */
  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for employment status.
   *
   * @param  employmentStatus  String
   */
  public void setEmploymentStatus(String employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for job code.
   *
   * @param  jobCode  String
   */
  public void setJobCode(String jobCode) {
    this.jobCode = jobCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nature of business.
   *
   * @param  natureOfBusiness  String
   */
  public void setNatureOfBusiness(String natureOfBusiness) {
    this.natureOfBusiness = natureOfBusiness;
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
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("CustomerEmployment ( ").append(super.toString()).append(TAB).append("employmentName = ").append(
      this.employerName).append(TAB).append("occupation = ").append(this.occupation).append(TAB).append(
      "occupationType = ").append(this.jobCode).append(TAB).append("natureOfBusiness = ").append(
      this.natureOfBusiness).append(TAB).append(TAB).append("employmentStatus = ").append(this.employmentStatus).append(
      TAB).append(" )");

    return retValue.toString();
  }
} // end class CustomerEmployment
