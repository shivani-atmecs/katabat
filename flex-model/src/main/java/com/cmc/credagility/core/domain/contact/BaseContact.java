package com.cmc.credagility.core.domain.contact;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * This class is used to store customer contact information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:17
 */
@MappedSuperclass public abstract class BaseContact extends AbstractBaseContact {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4703840119409844422L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** responsible. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
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

    retValue.append("BaseContact ( ").append(super.toString()).append(TAB).append("responsible = ").append(
      this.responsible).append(TAB).append(
      "source = ").append(this.source).append(TAB).append("status = ").append(this.status).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class BaseContact
