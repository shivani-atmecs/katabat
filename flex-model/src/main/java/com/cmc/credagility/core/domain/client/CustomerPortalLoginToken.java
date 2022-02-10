package com.cmc.credagility.core.domain.client;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "CustomerPortalLoginToken")
public class CustomerPortalLoginToken extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1033090320129891922L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * Some times in front-end login token with 'OR' condition which configured in
   * (CustomerPortalLoginConfiguration.groups).
   *
   * <p>such as: original Account Number OR Responsible Identification Number</p>
   *
   * <p>So in front-end (login page), the token which not the Last, should display a additional text 'OR'</p>
   *
   * <p>Text Configuration Key (I18N): pages.login.form.additional.or=OR</p>
   *
   * <p>+------------------------------------------------------------------------------+</p>
   *
   * <p>Original Account Number: ________________________ OR</p>
   *
   * <p>Responsible Identification</p>
   *
   * <p>Number: ________________________</p>
   *
   * <p>Zip Code: ________________________</p>
   *
   * <p>+------------------------------------------------------------------------------+</p>
   */
  @Transient private String additionalLabelText;

  /**
   * Is this token has already encrypted by hash (such as: ssnHash, originalAccountNumberHash and etc.) in DB.
   *
   * <p>If <code>true / Y</code> means this token has already encrypted by hash in DB.</p>
   */
  @Column(
    name             = "isHashEncrypted",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean hashEncrypted = Boolean.FALSE;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Long id;

  @OneToMany(
    fetch    = FetchType.EAGER,
    mappedBy = "token",
    cascade  = { CascadeType.ALL }
  )
  private Set<CustomerPortalLoginTokenLabel> labels;

  @Transient private String labelText;

  @Transient private String errorMessageText;

  /** Max length allow entered in front-end. */
  private Integer maxLength;

  /** The token name such as: OAN, zipCode and etc. */
  @Column(
    nullable = false,
    length   = 100
  )
  private String token;

  /**
   * The <code>token</code> type.
   *
   * <p>Number, Date Null or empty text will using the String data type.</p>
   */
  private String type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CustomerPortalLoginToken that = (CustomerPortalLoginToken) o;

    return hashEncrypted.equals(that.hashEncrypted)
      && maxLength.equals(that.maxLength)
      && token.equals(that.token)
      && type.equals(that.type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAdditionalLabelText() {
    return additionalLabelText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHashEncrypted() {
    return hashEncrypted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerPortalLoginTokenLabel> getLabels() {
    return labels;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLabelText() {
    if ((labels != null) && !labels.isEmpty()) {
      labelText = this.labels.iterator().next().getLabelText();
    }

    return labelText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMaxLength() {
    return maxLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getToken() {
    return token;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return Objects.hash(super.hashCode(), hashEncrypted, maxLength, token, type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  additionalLabelText  DOCUMENT ME!
   */
  public void setAdditionalLabelText(String additionalLabelText) {
    this.additionalLabelText = additionalLabelText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hashEncrypted  DOCUMENT ME!
   */
  public void setHashEncrypted(Boolean hashEncrypted) {
    this.hashEncrypted = hashEncrypted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  labels  DOCUMENT ME!
   */
  public void setLabels(Set<CustomerPortalLoginTokenLabel> labels) {
    this.labels = labels;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  labelText  DOCUMENT ME!
   */
  public void setLabelText(String labelText) {
    this.labelText = labelText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxLength  DOCUMENT ME!
   */
  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  token  DOCUMENT ME!
   */
  public void setToken(String token) {
    this.token = token;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getErrorMessageText() {
    if ((labels != null) && !labels.isEmpty()) {
      errorMessageText = this.labels.iterator().next().getErrorMessage();
    }

    return errorMessageText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

} // end class CustomerPortalLoginToken
