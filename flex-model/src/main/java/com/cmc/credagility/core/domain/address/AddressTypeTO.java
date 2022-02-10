package com.cmc.credagility.core.domain.address;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:11
 */
public class AddressTypeTO {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Boolean allowPermanence;


  /** TODO: DOCUMENT ME! */
  protected String name;


  /** TODO: DOCUMENT ME! */
  protected Integer priority;

  /** TODO: DOCUMENT ME! */
  protected String typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AddressType object.
   */
  public AddressTypeTO() { }

  /**
   * Creates a new AddressType object.
   *
   * @param  addressType      typeId
   * @param  allowPermanence  name
   */
  public AddressTypeTO(AddressType addressType, Boolean allowPermanence) {
    this.typeId          = addressType.getTypeId().toString();
    this.name            = addressType.getName();
    this.priority        = addressType.getPriority();
    this.allowPermanence = allowPermanence;
  }

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

    AddressTypeTO that = (AddressTypeTO) o;

    if ((allowPermanence != null) ? (!allowPermanence.equals(that.allowPermanence)) : (that.allowPermanence != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((typeId != null) ? (!typeId.equals(that.typeId)) : (that.typeId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getAllowPermanence() {
    return allowPermanence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getTypeId() {
    return typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (allowPermanence != null) ? allowPermanence.hashCode() : 0;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((typeId != null) ? typeId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAllowPermanence.
   *
   * @param  allowPermanence  $param.type$
   */
  public void setAllowPermanence(Boolean allowPermanence) {
    this.allowPermanence = allowPermanence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setName.
   *
   * @param  name  $param.type$
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPriority.
   *
   * @param  priority  $param.type$
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTypeId.
   *
   * @param  typeId  $param.type$
   */
  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }
} // end class AddressTypeTO
