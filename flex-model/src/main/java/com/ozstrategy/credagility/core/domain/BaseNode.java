package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:57
 */
@MappedSuperclass public abstract class BaseNode<S extends BaseStrategy> extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Graph Cell id. */
  @Column(length = 32)
  protected String cellId;

  /** Node rule criteria. */
  @Lob protected String criteria;

  /** Description for the node. */
  @Column(length = 255)
  protected String description;

  /** Child node are in exclusive mode. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean exclusiveChild = false;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer level;

  /** Name for the node. */
  @Column(length = 255)
  protected String name;

  /** Node priority. */
  @Column protected Integer priority = 1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "valid",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean valid = true;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public abstract Long getId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy.
   *
   * @return  S
   */
  public abstract S getStrategy();

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseNode baseNode = (BaseNode) o;

    if ((cellId != null) ? (!cellId.equals(baseNode.cellId)) : (baseNode.cellId != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(baseNode.criteria)) : (baseNode.criteria != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(baseNode.description)) : (baseNode.description != null)) {
      return false;
    }

    if ((exclusiveChild != null) ? (!exclusiveChild.equals(baseNode.exclusiveChild))
                                 : (baseNode.exclusiveChild != null)) {
      return false;
    }

    if ((level != null) ? (!level.equals(baseNode.level)) : (baseNode.level != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(baseNode.name)) : (baseNode.name != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(baseNode.priority)) : (baseNode.priority != null)) {
      return false;
    }

    if ((valid != null) ? (!valid.equals(baseNode.valid)) : (baseNode.valid != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Graph Cell id.
   *
   * @return  cell id
   */

  public String getCellId() {
    return cellId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The node criteria.
   *
   * @return  node criteria
   */

  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   */

  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag for child exclusive mode.
   *
   * @return  the exclusive flag
   */

  public Boolean getExclusiveChild() {
    if (exclusiveChild == null) {
      return Boolean.FALSE;
    }

    return exclusiveChild;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for level.
   *
   * @return  Integer
   */
  public Integer getLevel() {
    return level;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Node name.
   *
   * @return  node name
   */

  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Node priority for exclusive mode.
   *
   * @return  the node priority
   */

  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for valid.
   *
   * @return  Boolean
   */
  public Boolean getValid() {
    if (valid == null) {
      return Boolean.FALSE;
    }

    return valid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 47;
    result = (31 * result) + ((cellId != null) ? cellId.hashCode() : 0);
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((exclusiveChild != null) ? exclusiveChild.hashCode() : 0);
    result = (31 * result) + ((level != null) ? level.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((valid != null) ? valid.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set cell id.
   *
   * @param  cellId  graph cell id
   */
  public void setCellId(String cellId) {
    this.cellId = cellId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set description.
   *
   * @param  description  to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set exclusive child flag.
   *
   * @param  exclusiveChild  flag to set
   */
  public void setExclusiveChild(Boolean exclusiveChild) {
    this.exclusiveChild = exclusiveChild;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  level  DOCUMENT ME!
   */
  public void setLevel(Integer level) {
    this.level = level;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set node name.
   *
   * @param  name  to set
   */
  public void setName(String name) {
    this.name = name;

    if (this.name != null) {
      this.name = this.name.trim();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set node priority.
   *
   * @param  priority  to set
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  valid  DOCUMENT ME!
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
} // end class BaseNode
