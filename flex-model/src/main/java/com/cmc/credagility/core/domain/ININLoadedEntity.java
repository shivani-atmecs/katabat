package com.cmc.credagility.core.domain;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by huailing on 15/8/18.
 *
 * @author   <a href="mailto:ailing.hu@ozstrategy.com">Ailing Hu</a>
 * @version  08/18/2015 15:38
 */
@Entity
@Table(name = "ININLoadedEntity")
public class ININLoadedEntity extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2923443645328610583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(name = "customerId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Customer customer;

  @Column(
    name     = "id",
    nullable = false,
    unique   = true
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id
  private Long id;

  @JoinColumn(name = "ininCallId")
  @ManyToOne(fetch = FetchType.LAZY)
  private ININCall ininCallId;

  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ININLoadedEntity object.
   */
  public ININLoadedEntity() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
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
   * getter method for inin call id.
   *
   * @return  ININCall
   */
  public ININCall getIninCallId() {
    return ininCallId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
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
   * setter method for inin call id.
   *
   * @param  ininCallId  ININCall
   */
  public void setIninCallId(ININCall ininCallId) {
    this.ininCallId = ininCallId;
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
} // end class ININLoadedEntity
