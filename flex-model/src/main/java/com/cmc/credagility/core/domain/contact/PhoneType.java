package com.cmc.credagility.core.domain.contact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Phone Type information.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/14/2014 18:21
 */
@Entity
@Table(
  name              = "PhoneType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "name") },
  indexes           = {
    @Index(
      name          = "idx_clientPhoneTypeAlias",
      columnList    = "clientPhoneTypeAlias"
    )
  }
)
public class PhoneType extends BaseEntity implements Serializable, ContactType {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 0L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Client phone id. */
  @Column(
    name   = "clientPhoneTypeAlias",
    length = 30
  )
  protected String clientPhoneTypeAlias;


  /** If allow display on QueueExport. */
  @Transient protected Boolean displayOnQueueExport;


  /** If enable call type control. */
  @Transient protected Boolean enableCallTypeControl;


  /** If enable preview dialing. */
  @Transient protected Boolean enablePreviewDialing;

  /** Phone Type Name. */
  @Column(
    name   = "name",
// unique = true,
    length = 20
  )
  protected String name;

  /** Phone priority. */
  protected Integer priority;


  /** Phone type short name. */
  @Column(length = 255)
  protected String shortName;

  /** Phone Type PK. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PhoneType object.
   */
  public PhoneType() {
    super();
  }

  /**
   * Creates a new PhoneType object.
   *
   * @param  typeId  Long
   * @param  name    String
   */
  public PhoneType(Long typeId, String name) {
    super();
    this.typeId = typeId;
    this.name   = name;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  type  PhoneType
   */
  public void deepCopy(PhoneType type) {
    if (type != null) {
      this.typeId                = type.getTypeId();
      this.name                  = type.getName();
      this.priority              = type.getPriority();
      this.displayOnQueueExport  = type.getDisplayOnQueueExport();
      this.enableCallTypeControl = type.getEnableCallTypeControl();
      this.enablePreviewDialing  = type.getEnablePreviewDialing();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PhoneType)) {
      return false;
    }

    PhoneType phoneType = (PhoneType) o;

    if ((name != null) ? (!name.equals(phoneType.name)) : (phoneType.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client phone type alias.
   *
   * @return  String
   */
  public String getClientPhoneTypeAlias() {
    return clientPhoneTypeAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for enable preview dialing.
   *
   * @return  Boolean
   */
  public Boolean getEnablePreviewDialing() {
    return enablePreviewDialing;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for short name.
   *
   * @return  String
   */
  public String getShortName() {
    return shortName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type code.
   *
   * @return  String
   */
  @Override public String getTypeCode() {
    return getClass().getSimpleName() + this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type id.
   *
   * @return  Long
   */
  public Long getTypeId() {
    return typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 1;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client phone type alias.
   *
   * @param  clientPhoneTypeAlias  String
   */
  public void setClientPhoneTypeAlias(String clientPhoneTypeAlias) {
    this.clientPhoneTypeAlias = clientPhoneTypeAlias;
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
   * setter method for enable preview dialing.
   *
   * @param  enablePreviewDialing  Boolean
   */
  public void setEnablePreviewDialing(Boolean enablePreviewDialing) {
    this.enablePreviewDialing = enablePreviewDialing;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for short name.
   *
   * @param  shortName  String
   */
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type id.
   *
   * @param  typeId  Long
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
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

    retValue.append("PhoneType ( ").append(super.toString()).append(TAB).append("name = ").append(this.name).append(TAB)
      .append("typeId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class PhoneType
