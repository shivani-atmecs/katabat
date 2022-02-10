package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * This class is used to store ivr service vendor information.
 *
 * <p><a href="IvrServiceVendor.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:04
 */
@Entity
@Table(
  name              = "IvrServiceVendor",
  uniqueConstraints = { @UniqueConstraint(columnNames = "name") },
  indexes           = {
    @Index(
      name          = "postalCodeIndex",
      columnList    = "postalCode"
    )
  }
)
public class IvrServiceVendor extends BaseServiceVendor {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1721856263452924490L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Result Id, PK. */
  @Column(
    name     = "vendorId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long vendorId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * The vendorId.
   *
   * @return  the vendorId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  @Override public Long getVendorId() {
    return vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setVendorId.
   *
   * @param  vendorId  the vendorId to set
   */
  @Override public void setVendorId(Long vendorId) {
    this.vendorId = vendorId;
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

    retValue.append("IvrServiceVendor ( ").append(super.toString()).append(TAB).append("vendorId = ").append(
      this.vendorId).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class IvrServiceVendor
