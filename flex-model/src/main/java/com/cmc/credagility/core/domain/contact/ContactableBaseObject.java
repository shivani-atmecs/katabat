package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.DoNotContactReason;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * All level address,email and phone need extend this class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:27
 */
@MappedSuperclass public abstract class ContactableBaseObject extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1355604281605353352L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** If do not contact. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean doNotContact;


  /** If doNotContact=true, show the do not contact reason. */
  @Column(
    name   = "doNotContactReason",
    length = 12
  )
  @Enumerated(EnumType.STRING)
  protected DoNotContactReason doNotContactReason;

  /**
   * Context sensitive Id determined by doNotContactReason. For example, if DoNotContactReason is Payment, then
   * doNotContactReasonId would be the paymentId.
   */
  @Column(
    name   = "doNotContactReasonId",
    length = 20
  )
  protected String doNotContactReasonId;


  /** Until which date do not contact. */
  @Column(name = "doNotContactUntil")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date doNotContactUntil;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  object  ContactableBaseObject
   */
  public void deepCopy(ContactableBaseObject object) {
    if (object != null) {
      this.doNotContact         = object.getDoNotContact();
      this.doNotContactUntil    = object.getDoNotContactUntil();
      this.doNotContactReason   = object.getDoNotContactReason();
      this.doNotContactReasonId = object.getDoNotContactReasonId();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact.
   *
   * @return  Boolean
   */
  public Boolean getDoNotContact() {
    if (doNotContact == null) {
      return Boolean.FALSE;
    }

    return doNotContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact reason.
   *
   * @return  DoNotContactReason
   */
  public DoNotContactReason getDoNotContactReason() {
    return doNotContactReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact reason id.
   *
   * @return  String
   */
  public String getDoNotContactReasonId() {
    return doNotContactReasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact until.
   *
   * @return  Date
   */
  public Date getDoNotContactUntil() {
    return doNotContactUntil;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update noContactUntil. If pass in Null, it means NEVRER contact any more.
   *
   * @param   doNotContactUntil  DOCUMENT ME!
   * @param   reason             DOCUMENT ME!
   * @param   reasonId           DOCUMENT ME!
   *
   * @return  update noContactUntil.
   */
  public Boolean markDoNotContact(Date doNotContactUntil, DoNotContactReason reason, String reasonId) {
    // Check if it has been set to "NEVER CONTACT"
    // Negative wins
    if (Boolean.TRUE.equals(this.doNotContact)
          && (this.doNotContactUntil == null)) {
      return false;
    }

    Date now = new Date();

    // if already do not contact...
    if (Boolean.TRUE.equals(this.doNotContact)) {
      // doNotContactUntil definitely is not null
      if ((doNotContactUntil == null)
            || this.doNotContactUntil.before(doNotContactUntil)) {
        this.doNotContactUntil    = doNotContactUntil;
        this.doNotContactReason   = reason;
        this.doNotContactReasonId = reasonId;
        this.setLastUpdateDate(now);

        return true;
      }

      return false;
    }

    // If still contactable
    doNotContact              = Boolean.TRUE;
    this.doNotContactUntil    = doNotContactUntil;
    this.doNotContactReason   = reason;
    this.doNotContactReasonId = reasonId;
    this.setLastUpdateDate(now);

    return true;
  } // end method markDoNotContact

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Allow contact.
   *
   * @return  allow contact.
   */
  public Boolean removeDoNotContact() {
    boolean ret = false;

    if (Boolean.TRUE.equals(this.doNotContact)) {
      ret = true;
    }

    this.doNotContact         = false;
    this.doNotContactUntil    = null;
    this.doNotContactReason   = null;
    this.doNotContactReasonId = null;

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact.
   *
   * @param  doNotContact  Boolean
   */
  public void setDoNotContact(Boolean doNotContact) {
    this.doNotContact = doNotContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact reason.
   *
   * @param  doNotContactReason  DoNotContactReason
   */
  public void setDoNotContactReason(DoNotContactReason doNotContactReason) {
    this.doNotContactReason = doNotContactReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact reason id.
   *
   * @param  doNotContactReasonId  String
   */
  public void setDoNotContactReasonId(String doNotContactReasonId) {
    this.doNotContactReasonId = doNotContactReasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact until.
   *
   * @param  doNotContactUntil  Date
   */
  public void setDoNotContactUntil(Date doNotContactUntil) {
    this.doNotContactUntil = doNotContactUntil;
  }
} // end class ContactableBaseObject
