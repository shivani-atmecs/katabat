package com.cmc.credagility.core.domain.rbs;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 12:30
 */
@Entity
@Table(
  name    = "RBSOffset",
  indexes = {
    @Index(
      name = "originalAccountNumberHashIndex",
      columnList = "originalAccountNumberHash"
    )
  }
)
public class RBSOffset extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "offsetId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long offsetId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "originalAccountNumber",
    length   = 80,
    nullable = false
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String originalAccountNumber;

  @Column(
    length   = 100,
    nullable = false
  )
  private String originalAccountNumberHash;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for offset id.
   *
   * @return  Long
   */
  public Long getOffsetId() {
    return offsetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original account number.
   *
   * @return  String
   */
  public String getOriginalAccountNumber() {
    return originalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original account number hash.
   *
   * @return  String
   */
  public String getOriginalAccountNumberHash() {
    return originalAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((originalAccountNumber == null) ? 0 : originalAccountNumber.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for offset id.
   *
   * @param  offsetId  Long
   */
  public void setOffsetId(Long offsetId) {
    this.offsetId = offsetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original account number.
   *
   * @param  originalAccountNumber  String
   */
  public void setOriginalAccountNumber(String originalAccountNumber) {
    this.originalAccountNumber = originalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original account number hash.
   *
   * @param  originalAccountNumberHash  String
   */
  public void setOriginalAccountNumberHash(String originalAccountNumberHash) {
    this.originalAccountNumberHash = originalAccountNumberHash;
  }
} // end class RBSOffset
