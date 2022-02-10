package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactType;


/**
 * This class is used to store Email Type information.
 *
 * <p><a href="EmailType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:25
 */
@Entity
@Table(
  name              = "EmailType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "name") },
  indexes           = {
    @Index(
      name          = "idx_clientEmailTypeAlias",
      columnList    = "clientEmailTypeAlias"
    )
  }
)
public class EmailType extends BaseEntity implements Serializable, ContactType {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 0L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** client email. */
  @Column(
    name   = "clientEmailTypeAlias",
    length = 30
  )
  protected String clientEmailTypeAlias;

  /** Phone type Name. */
  @Column(
    name   = "name",
    length = 20
  )
  protected String name;

  /** email priority. */
  @Column(name = "priority")
  protected Integer priority;

  /** Phone Type PK. */
  @Column(
    name     = "typeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EmailType object.
   */
  public EmailType() {
    super();
  }

  /**
   * Creates a new EmailType object.
   *
   * @param  typeId  DOCUMENT ME!
   * @param  name    DOCUMENT ME!
   */
  public EmailType(Long typeId, String name) {
    super();
    this.typeId = typeId;
    this.name   = name;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void deepCopy(EmailType type) {
    if (type != null) {
      this.typeId = type.getTypeId();
      this.name   = type.getName();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final EmailType other = (EmailType) obj;

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client email type alias.
   *
   * @return  String
   */
  public String getClientEmailTypeAlias() {
    return clientEmailTypeAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "false" length = "20" unique = "true"</p>
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.ContactType#getTypeCode()
   */
  @Override public String getTypeCode() {
    return getClass().getSimpleName() + this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The typeId.
   *
   * @return  the typeId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
    * (non-Javadoc)
    *
    * @see java.lang.Object#hashCode()
    */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client email type alias.
   *
   * @param  clientEmailTypeAlias  String
   */
  public void setClientEmailTypeAlias(String clientEmailTypeAlias) {
    this.clientEmailTypeAlias = clientEmailTypeAlias;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type id.
   *
   * @param  typeId  Long
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("EmailType ( ").append(super.toString()).append(TAB).append("name = ").append(this.name).append(TAB)
      .append("typeId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class EmailType
