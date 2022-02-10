package com.cmc.credagility.core.domain.common;

import java.io.Serializable;

import java.util.Comparator;

import javax.persistence.Column;


/**
 * A simple JavaBean to represent label-value pairs. This is most commonly used when constructing user interface
 * elements which have a label to be displayed to the user, and a corresponding value to be returned to the server. One
 * example is the <code>&lt;html:options&gt;</code> tag.
 *
 * <p>Note: this class has a natural ordering that is inconsistent with equals.</p>
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 16:33
 */
@SuppressWarnings("unchecked")
public class LabelValue implements Comparable, Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3689355407466181430L;

  /** Comparator that can be used for a case insensitive sort of <code>LabelValue</code> objects. */
  public static final Comparator CASE_INSENSITIVE_ORDER = new Comparator() {
    @Override public int compare(
      Object o1,
      Object o2) {
      String label1 = ((LabelValue) o1).getLabel();
      String label2 = ((LabelValue) o2).getLabel();

      return label1.compareToIgnoreCase(label2);
    }
  };

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(length = 255)
  private String actionCode = null;

  /** The property which supplies the option label visible to the end user. */
  @Column(length = 255)
  private String label = null;

  /** The property which supplies the value returned to the server. */
  @Column(length = 255)
  private String value = null;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Construct an instance with the supplied property values.
   *
   * @param  label  The label to be displayed to the user.
   * @param  value  The value to be returned to the server.
   */
  public LabelValue(String label, String value) {
    this.label = label;
    this.value = value;
  }

  /**
   * Creates a new LabelValue object.
   *
   * @param  label       String
   * @param  value       String
   * @param  actionCode  String
   */
  public LabelValue(String label, String value, String actionCode) {
    this.label      = label;
    this.value      = value;
    this.actionCode = actionCode;
  }

  // ------------------------------------------------------------- Properties

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Compare LabelValueBeans based on the label, because that's the human viewable part of the object.
   *
   * @param   o  Object
   *
   * @return  compare LabelValueBeans based on the label, because that's the human viewable part of the object.
   *
   * @see     Comparable
   */
  @Override public int compareTo(Object o) {
    // Implicitly tests for the correct type, throwing
    // ClassCastException as required by interface
    String otherLabel = ((LabelValue) o).getLabel();

    return this.getLabel().compareTo(otherLabel);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * LabelValueBeans are equal if their values are both null or equal.
   *
   * @param   obj  Object
   *
   * @return  labelValueBeans are equal if their values are both null or equal.
   *
   * @see     java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof LabelValue)) {
      return false;
    }

    LabelValue bean = (LabelValue) obj;
    int        nil  = (this.getValue() == null) ? 1 : 0;
    nil += (bean.getValue() == null) ? 1 : 0;

    if (nil == 2) {
      return true;
    } else if (nil == 1) {
      return false;
    } else {
      return this.getValue().equals(bean.getValue());
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action code.
   *
   * @return  String
   */
  public String getActionCode() {
    return actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for label.
   *
   * @return  String
   */
  public String getLabel() {
    return label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The hash code is based on the object's value.
   *
   * @return  the hash code is based on the object's value.
   *
   * @see     java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    return (this.getValue() == null) ? 17 : this.getValue().hashCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action code.
   *
   * @param  actionCode  String
   */
  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for label.
   *
   * @param  label  String
   */
  public void setLabel(String label) {
    this.label = label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Return a string representation of this object.
   *
   * @return  return a string representation of this object.
   */
  @Override public String toString() {
    StringBuffer sb = new StringBuffer("LabelValue[");
    sb.append(this.label);
    sb.append(", ");
    sb.append(this.value);
    sb.append("]");

    return (sb.toString());
  }
} // end class LabelValue
