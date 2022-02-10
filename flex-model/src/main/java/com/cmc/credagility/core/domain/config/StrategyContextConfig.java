package com.cmc.credagility.core.domain.config;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store StrategyContextConfig information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 14:41
 */
@Entity
@Table(name = "StrategyContextConfig")
public class StrategyContextConfig {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Applicable modules, separated by commas. */
  @Column(length = 255)
  protected String applicableModules;

  /** Context name. */
  @Column(
    nullable = false,
    unique   = true,
    length   = 255
  )
  private String contextName;


  /** If enabled. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enabled = Boolean.FALSE;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private int id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StrategyContextConfig object.
   */
  public StrategyContextConfig() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for applicable modules.
   *
   * @return  String
   */
  public String getApplicableModules() {
    return applicableModules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context name.
   *
   * @return  String
   */
  public String getContextName() {
    return contextName;
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
   * @return  int
   */
  public int getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for applicable modules.
   *
   * @param  applicableModules  String
   */
  public void setApplicableModules(String applicableModules) {
    this.applicableModules = applicableModules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context name.
   *
   * @param  contextName  String
   */
  public void setContextName(String contextName) {
    this.contextName = contextName;
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
   * @param  id  int
   */
  public void setId(int id) {
    this.id = id;
  }
} // end class StrategyContextConfig
