package com.cmc.credagility.core.domain.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.type.LocaleType;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  08/19/2015 11:20
 */
@Entity public class LocaleConfig implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3009248714403351357L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "language",
    length   = 100,
    nullable = false,
    unique   = true
  )
  protected String language;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "locale",
    length   = 5,
    nullable = false,
    unique   = true
  )
  @Enumerated(EnumType.STRING)
  protected LocaleType locale;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long localeConfigId;

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

    LocaleConfig that = (LocaleConfig) o;

    return locale == that.locale;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.FALSE;

    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getLanguage() {
    return language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * LocaleType.
   *
   * @return  LocaleType.
   */
  public LocaleType getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getLocaleConfigId() {
    return localeConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    return (locale != null) ? locale.hashCode() : 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setActive.
   *
   * @param  active  $param.type$
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLanguage.
   *
   * @param  language  $param.type$
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLocale.
   *
   * @param  locale  $param.type$
   */
  public void setLocale(LocaleType locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLocaleConfigId.
   *
   * @param  localeConfigId  $param.type$
   */
  public void setLocaleConfigId(Long localeConfigId) {
    this.localeConfigId = localeConfigId;
  }
} // end class LocaleConfig
