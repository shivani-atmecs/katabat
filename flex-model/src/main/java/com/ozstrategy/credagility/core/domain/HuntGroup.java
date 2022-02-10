package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.twilio.TwilioSubAccount;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:56
 */
@Entity
@Table(
  name              = "HuntGroup",
  uniqueConstraints = {
    @UniqueConstraint(
      columnNames   = { "name" },
      name          = "name"
    ),
    @UniqueConstraint(
      columnNames   = { "ncsPhoneNumber" },
      name          = "ncsPhoneNumber"
    )
  }
)
public class HuntGroup extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4822582894531796221L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active;


  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String clientPhoneNumber;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 200,
    nullable = false
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 20,
    nullable = false
  )
  protected String ncsPhoneNumber;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = false,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected TwilioSubAccount twilioSubAccount;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "huntGroup",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  private Set<HuntGroupUserRole> huntGroupUserRoles = new LinkedHashSet<HuntGroupUserRole>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    HuntGroup huntGroup = (HuntGroup) o;

    if ((active != null) ? (!active.equals(huntGroup.active)) : (huntGroup.active != null)) {
      return false;
    }

    if ((clientPhoneNumber != null) ? (!clientPhoneNumber.equals(huntGroup.clientPhoneNumber))
                                    : (huntGroup.clientPhoneNumber != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(huntGroup.description)) : (huntGroup.description != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(huntGroup.name)) : (huntGroup.name != null)) {
      return false;
    }

    if ((ncsPhoneNumber != null) ? (!ncsPhoneNumber.equals(huntGroup.ncsPhoneNumber))
                                 : (huntGroup.ncsPhoneNumber != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client phone number.
   *
   * @return  String
   */
  public String getClientPhoneNumber() {
    return clientPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hunt group user roles.
   *
   * @return  Set
   */
  public Set<HuntGroupUserRole> getHuntGroupUserRoles() {
    return huntGroupUserRoles;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ncs phone number.
   *
   * @return  String
   */
  public String getNcsPhoneNumber() {
    return ncsPhoneNumber;
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

  /**
   * getter method for twilio sub account.
   *
   * @return  TwilioSubAccount
   */
  public TwilioSubAccount getTwilioSubAccount() {
    return twilioSubAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((active != null) ? active.hashCode() : 0);
    result = (31 * result) + ((clientPhoneNumber != null) ? clientPhoneNumber.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((ncsPhoneNumber != null) ? ncsPhoneNumber.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client phone number.
   *
   * @param  clientPhoneNumber  String
   */
  public void setClientPhoneNumber(String clientPhoneNumber) {
    this.clientPhoneNumber = clientPhoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hunt group user roles.
   *
   * @param  huntGroupUserRoles  Set
   */
  public void setHuntGroupUserRoles(Set<HuntGroupUserRole> huntGroupUserRoles) {
    this.huntGroupUserRoles = huntGroupUserRoles;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ncs phone number.
   *
   * @param  ncsPhoneNumber  String
   */
  public void setNcsPhoneNumber(String ncsPhoneNumber) {
    this.ncsPhoneNumber = ncsPhoneNumber;
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
   * setter method for twilio sub account.
   *
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public void setTwilioSubAccount(TwilioSubAccount twilioSubAccount) {
    this.twilioSubAccount = twilioSubAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "HuntGroup{"
      + "id=" + id
      + ", name='" + name + '\''
      + ", description='" + description + '\''
      + ", ncsPhoneNumber='" + ncsPhoneNumber + '\''
      + ", clientPhoneNumber='" + clientPhoneNumber + '\''
      + ", active=" + active
      + ", priority=" + priority
      + '}';
  }
} // end class HuntGroup
