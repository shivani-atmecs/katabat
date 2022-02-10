package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Arrays;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:22
 */
@Entity
@Table(
  name    = "TwilioVoicePrompt",
  indexes =
    @Index(
      name = "nameIndex",
      columnList = "name"
    )
)
public class TwilioVoicePrompt extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5676219591894836976L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioSubAccount twilioSubAccount;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(
    name     = "name",
    nullable = false,
    unique   = true
  )
  private String name;

  @Column(
    name     = "text",
    nullable = true,
    length   = 320
  )
  private String text;
  @Column(
    name             = "wavBlob",
    columnDefinition = "LONGBLOB"
  )
  private byte[] wavBlob;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    TwilioVoicePrompt that = (TwilioVoicePrompt) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((text != null) ? (!text.equals(that.text)) : (that.text != null)) {
      return false;
    }

    if (!Arrays.equals(wavBlob, that.wavBlob)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text.
   *
   * @return  String
   */
  public String getText() {
    return text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio sub account.
   *
   * @return  TwilioSubAccount
   */
  public TwilioSubAccount getTwilioSubAccount() {
    return twilioSubAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for wav blob.
   *
   * @return  byte[]
   */
  public byte[] getWavBlob() {
    return wavBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((text != null) ? text.hashCode() : 0);
    result = (31 * result) + ((wavBlob != null) ? Arrays.hashCode(wavBlob) : 0);

    return result;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  text  DOCUMENT ME!
   */
  public void setText(String text) {
    this.text = text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio sub account.
   *
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public void setTwilioSubAccount(TwilioSubAccount twilioSubAccount) {
    this.twilioSubAccount = twilioSubAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for wav blob.
   *
   * @param  wavBlob  byte[]
   */
  public void setWavBlob(byte[] wavBlob) {
    this.wavBlob = wavBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return ("TwilioVoicePrompt{"
        + "id=" + id
        + ", name='" + name + '\''
        + ", text='" + text + '\''
        + ", wavBlob.length=" + ((wavBlob == null) ? 0 : wavBlob.length)
        + '}');
  }
} // end class TwilioVoicePrompt
