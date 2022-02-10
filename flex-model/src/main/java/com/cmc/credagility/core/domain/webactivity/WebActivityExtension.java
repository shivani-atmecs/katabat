package com.cmc.credagility.core.domain.webactivity;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:16
 */
@Entity
@Table(name = "WebActivityExtension")
public class WebActivityExtension extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 244581273110868948L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data1",
    length = 250
  )
  protected String data1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data10",
    length = 750
  )
  protected String data10;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data11",
    length = 750
  )
  protected String data11;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data12",
    length = 750
  )
  protected String data12;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data2",
    length = 250
  )
  protected String data2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data3",
    length = 250
  )
  protected String data3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data4",
    length = 500
  )
  protected String data4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data5",
    length = 500
  )
  protected String data5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data6",
    length = 500
  )
  protected String data6;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data7",
    length = 750
  )
  protected String data7;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data8",
    length = 750
  )
  protected String data8;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data9",
    length = 750
  )
  protected String data9;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "webActivityExtensionId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long webActivityExtensionId;

  @JoinColumn(
    name     = "activityId",
    unique   = true,
    nullable = false
  )
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
  private WebActivity webActivity;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    final WebActivityExtension other = (WebActivityExtension) obj;

    if (this.data1 == null) {
      if (other.getData1() != null) {
        return false;
      }
    } else if (!this.data1.equals(other.getData1())) {
      return false;
    }

    if (this.data2 == null) {
      if (other.getData2() != null) {
        return false;
      }
    } else if (!this.data2.equals(other.getData2())) {
      return false;
    }

    if (this.data3 == null) {
      if (other.getData3() != null) {
        return false;
      }
    } else if (!this.data3.equals(other.getData3())) {
      return false;
    }

    if (this.data4 == null) {
      if (other.getData4() != null) {
        return false;
      }
    } else if (!this.data4.equals(other.getData4())) {
      return false;
    }

    if (this.data5 == null) {
      if (other.getData5() != null) {
        return false;
      }
    } else if (!this.data5.equals(other.getData5())) {
      return false;
    }

    if (this.data6 == null) {
      if (other.getData6() != null) {
        return false;
      }
    } else if (!this.data6.equals(other.getData6())) {
      return false;
    }

    if (this.data7 == null) {
      if (other.getData7() != null) {
        return false;
      }
    } else if (!this.data7.equals(other.getData7())) {
      return false;
    }

    if (this.data8 == null) {
      if (other.getData8() != null) {
        return false;
      }
    } else if (!this.data8.equals(other.getData8())) {
      return false;
    }

    if (this.data9 == null) {
      if (other.getData9() != null) {
        return false;
      }
    } else if (!this.data9.equals(other.getData9())) {
      return false;
    }

    if (this.data10 == null) {
      if (other.getData10() != null) {
        return false;
      }
    } else if (!this.data10.equals(other.getData10())) {
      return false;
    }

    if (this.webActivity.name == null) {
      if (other.getWebActivity().getName() != null) {
        return false;
      }
    } else if (!this.webActivity.name.equals(other.getWebActivity().getName())) {
      return false;
    }

    if (this.createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!this.createDate.equals(other.getCreateDate())) {
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
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data10.
   *
   * @return  String
   */
  public String getData10() {
    return data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data11.
   *
   * @return  String
   */
  public String getData11() {
    return data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data12.
   *
   * @return  String
   */
  public String getData12() {
    return data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data6.
   *
   * @return  String
   */
  public String getData6() {
    return data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data7.
   *
   * @return  String
   */
  public String getData7() {
    return data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data8.
   *
   * @return  String
   */
  public String getData8() {
    return data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data9.
   *
   * @return  String
   */
  public String getData9() {
    return data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web activity.
   *
   * @return  WebActivity
   */
  public WebActivity getWebActivity() {
    return webActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web activity extension id.
   *
   * @return  Long
   */
  public Long getWebActivityExtensionId() {
    return webActivityExtensionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (PRIME * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (PRIME * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (PRIME * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (PRIME * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());
    result = (PRIME * result)
      + ((this.data6 == null) ? 0 : this.data6.hashCode());
    result = (PRIME * result)
      + ((this.data7 == null) ? 0 : this.data7.hashCode());
    result = (PRIME * result)
      + ((this.data8 == null) ? 0 : this.data8.hashCode());
    result = (PRIME * result)
      + ((this.data9 == null) ? 0 : this.data9.hashCode());
    result = (PRIME * result)
      + ((this.data10 == null) ? 0 : this.data10.hashCode());
    result = (PRIME * result) + ((this.webActivity.name == null) ? 0 : this.webActivity.name.hashCode());

    return result;
  } // end method hashCode

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
   * setter method for data1.
   *
   * @param  data1  String
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data10.
   *
   * @param  data10  String
   */
  public void setData10(String data10) {
    this.data10 = data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data11.
   *
   * @param  data11  String
   */
  public void setData11(String data11) {
    this.data11 = data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data12.
   *
   * @param  data12  String
   */
  public void setData12(String data12) {
    this.data12 = data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data2.
   *
   * @param  data2  String
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data3.
   *
   * @param  data3  String
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data4.
   *
   * @param  data4  String
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data5.
   *
   * @param  data5  String
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data6.
   *
   * @param  data6  String
   */
  public void setData6(String data6) {
    this.data6 = data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data7.
   *
   * @param  data7  String
   */
  public void setData7(String data7) {
    this.data7 = data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data8.
   *
   * @param  data8  String
   */
  public void setData8(String data8) {
    this.data8 = data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data9.
   *
   * @param  data9  String
   */
  public void setData9(String data9) {
    this.data9 = data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web activity.
   *
   * @param  webActivity  WebActivity
   */
  public void setWebActivity(WebActivity webActivity) {
    this.webActivity = webActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web activity extension id.
   *
   * @param  webActivityExtensionId  Long
   */
  public void setWebActivityExtensionId(Long webActivityExtensionId) {
    this.webActivityExtensionId = webActivityExtensionId;
  }
} // end class WebActivityExtension
