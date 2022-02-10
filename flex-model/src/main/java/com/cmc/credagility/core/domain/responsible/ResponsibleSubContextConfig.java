package com.cmc.credagility.core.domain.responsible;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store ResponsibleSubContextConfig information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:45
 */
@Entity
@Table(name = "ResponsibleSubContextConfig")
public class ResponsibleSubContextConfig {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String applicableModules;

  @Column(
    nullable = false,
    unique   = true,
    length   = 255
  )
  private String contextName;


  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enabled = Boolean.FALSE;

  @GeneratedValue(strategy = IDENTITY)
  @Id private int id;

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
} // end class ResponsibleSubContextConfig
