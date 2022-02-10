package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:48
 */
@Entity @Table public class ApplicationVersion extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean current;
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enabled;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    length   = 255,
    nullable = false
  )
  private String version;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ApplicationConfig object.
   */
  public ApplicationVersion() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for current.
   *
   * @return  Boolean
   */
  public Boolean getCurrent() {
    return current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enabled.
   *
   * @return  Boolean
   */
  public Boolean getEnabled() {
    return enabled;
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
   * getter method for version.
   *
   * @return  String
   */
  public String getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current.
   *
   * @param  current  Boolean
   */
  public void setCurrent(Boolean current) {
    this.current = current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enabled.
   *
   * @param  enabled  Boolean
   */
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
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
   * setter method for version.
   *
   * @param  version  String
   */
  public void setVersion(String version) {
    this.version = version;
  }
} // end class ApplicationVersion
