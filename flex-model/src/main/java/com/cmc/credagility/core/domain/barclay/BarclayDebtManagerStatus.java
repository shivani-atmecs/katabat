package com.cmc.credagility.core.domain.barclay;

import java.io.Serializable;

import java.sql.Timestamp;

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
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:30
 */
@Entity
@Table(
  name              = "BarclayDebtManagerStatus",
  uniqueConstraints = { @UniqueConstraint(columnNames = "barclayDebtManagerStatusId") }
)
public class BarclayDebtManagerStatus extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3776803535437139096L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "barclayDebtManagerStatusId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long barclayDebtManagerStatusId;

  @Column(
    name   = "debtManagerStatus",
    length = 255
  )
  private String debtManagerStatus;

  @Column(
    name   = "systemTime",
    length = 255
  )
  private Timestamp systemTime;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for barclay debt manager status id.
   *
   * @return  Long
   */
  public Long getBarclayDebtManagerStatusId() {
    return barclayDebtManagerStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for debt manager status.
   *
   * @return  String
   */
  public String getDebtManagerStatus() {
    return debtManagerStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system time.
   *
   * @return  Timestamp
   */
  public Timestamp getSystemTime() {
    return systemTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for barclay debt manager status id.
   *
   * @param  barclayDebtManagerStatusId  Long
   */
  public void setBarclayDebtManagerStatusId(Long barclayDebtManagerStatusId) {
    this.barclayDebtManagerStatusId = barclayDebtManagerStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for debt manager status.
   *
   * @param  debtManagerStatus  String
   */
  public void setDebtManagerStatus(String debtManagerStatus) {
    this.debtManagerStatus = debtManagerStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for system time.
   *
   * @param  systemTime  Timestamp
   */
  public void setSystemTime(Timestamp systemTime) {
    this.systemTime = systemTime;
  }
} // end class BarclayDebtManagerStatus
