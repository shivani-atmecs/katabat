package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:45
 */
@Entity
@Table(
  uniqueConstraints = {
    @UniqueConstraint(
      name = "value",
      columnNames = { "value", "channel", "category", "context", "scopeId" }
    )
  }
)
public class EnterpriseHotSpot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1540309600493555003L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The value should be: Document/Workflow */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String category;

  /** The value should be: Agency/DebtorSite */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String channel;

  /** The value should be: responsible/agency/business */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String context;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 100
  )
  protected String label;

  /**
   * The value should be:
   *
   * <pre>
       1. if context is equal to 'responsible', the scopeId should be the portfolio id.
       2. if context is equal to 'business_context', the scopeId should be the id of BusinessContext id.
       3. if context is equal to 'agency
   ', ignore.
   * </pre>
   */
  @Column protected Long scopeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String value;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    EnterpriseHotSpot that = (EnterpriseHotSpot) o;

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((channel != null) ? (!channel.equals(that.channel)) : (that.channel != null)) {
      return false;
    }

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((scopeId != null) ? (!scopeId.equals(that.scopeId)) : (that.scopeId != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
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
   * getter method for label.
   *
   * @return  String
   */
  public String getLabel() {
    return label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scope id.
   *
   * @return  Long
   */
  public Long getScopeId() {
    return scopeId;
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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (category != null) ? category.hashCode() : 0;
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((scopeId != null) ? scopeId.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
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
   * setter method for label.
   *
   * @param  label  String
   */
  public void setLabel(String label) {
    this.label = label;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for scope id.
   *
   * @param  scopeId  Long
   */
  public void setScopeId(Long scopeId) {
    this.scopeId = scopeId;
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
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseHotSpot");
    sb.append("{label='").append(label).append('\'');
    sb.append(", value='").append(value).append('\'');
    sb.append(", id=").append(id);
    sb.append(", channel='").append(channel).append('\'');
    sb.append(", category='").append(category).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseHotSpot
