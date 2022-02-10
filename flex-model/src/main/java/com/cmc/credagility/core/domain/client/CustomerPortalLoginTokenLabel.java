package com.cmc.credagility.core.domain.client;

import java.util.Objects;

import javax.persistence.Column;
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


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "CustomerPortalLoginTokenLabel",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "tokenId", "language" }) }
)
public class CustomerPortalLoginTokenLabel extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 80758963791822847L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * Define the token error message.
   *
   * <p>such as: Original Account is required</p>
   */
  @Column(
    name   = "errorMessage",
    length = 255
  )
  private String errorMessage;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id private Long id;

  /**
   * The token referenced the label text in front-end (customer portal).
   *
   * <p>such as: OAN --> Last 4 Digital Account Number</p>
   */
  private String labelText;


  /**
   * The <code>labelText</code> language Reference <code>CustomerPortalPreferredLanguages</code> table.
   *
   * <p>English --> en_US French --> fr_FR</p>
   */
  @Column(length = 10)
  private String language;


  @JoinColumn(
    name       = "tokenId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private CustomerPortalLoginToken token;

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

    CustomerPortalLoginTokenLabel that = (CustomerPortalLoginTokenLabel) o;

    return labelText.equals(that.labelText)
      && language.equals(that.language)
      && token.equals(that.token);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getErrorMessage() {
    return errorMessage;
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
  public String getLabelText() {
    return labelText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLanguage() {
    return language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerPortalLoginToken getToken() {
    return token;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return Objects.hash(super.hashCode(), labelText, language, token.getId());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  errorMessage  DOCUMENT ME!
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
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
   * @param  labelText  DOCUMENT ME!
   */
  public void setLabelText(String labelText) {
    this.labelText = labelText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  language  DOCUMENT ME!
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  token  DOCUMENT ME!
   */
  public void setToken(CustomerPortalLoginToken token) {
    this.token = token;
  }
} // end class CustomerPortalLoginTokenLabel
