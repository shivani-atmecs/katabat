package com.cmc.credagility.core.domain.agency;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:11
 */
@Entity
@Table(
  name              = "AgencyPhoneType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "phoneTypeId" }) }
)
public class AgencyPhoneType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8921597534278706419L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name             = "displayOnQueueExport",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean displayOnQueueExport;

  @Column(
    name             = "enableCallTypeControl",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean  enableCallTypeControl;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name       = "phoneTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PhoneType phoneType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for display on queue export.
   *
   * @return  Boolean
   */
  public Boolean getDisplayOnQueueExport() {
    return displayOnQueueExport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable call type control.
   *
   * @return  Boolean
   */
  public Boolean getEnableCallTypeControl() {
    return enableCallTypeControl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  public PhoneType getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display on queue export.
   *
   * @param  displayOnQueueExport  Boolean
   */
  public void setDisplayOnQueueExport(Boolean displayOnQueueExport) {
    this.displayOnQueueExport = displayOnQueueExport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable call type control.
   *
   * @param  enableCallTypeControl  Boolean
   */
  public void setEnableCallTypeControl(Boolean enableCallTypeControl) {
    this.enableCallTypeControl = enableCallTypeControl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }
} // end class AgencyPhoneType
