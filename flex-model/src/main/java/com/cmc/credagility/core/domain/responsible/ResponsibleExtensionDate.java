package com.cmc.credagility.core.domain.responsible;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 16:42
 */
@Entity
@Table(name = "ResponsibleExtensionDate")
public class ResponsibleExtensionDate extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157920902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate10")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate10;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate11")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate11;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate12")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate12;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate13")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate13;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate14")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate14;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate15")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate15;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate16")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate16;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate17")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate17;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate18")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate18;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate19")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate19;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate20")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate20;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate3;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate4;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate5;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate6;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate7")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate7;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate8")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate8;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate9")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleExtensionDateId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleExtensionDateId;


  @JoinColumn(
    name   = "responsibleId",
    unique = true
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate10() {
    return clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate11() {
    return clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate12() {
    return clientDefinedDate12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate13() {
    return clientDefinedDate13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate14() {
    return clientDefinedDate14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate15() {
    return clientDefinedDate15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate16() {
    return clientDefinedDate16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate17() {
    return clientDefinedDate17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate18() {
    return clientDefinedDate18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate19() {
    return clientDefinedDate19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate20() {
    return clientDefinedDate20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate6() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate7() {
    return clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate8() {
    return clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate9() {
    return clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Responsible.
   *
   * @return  Responsible.
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getResponsibleExtensionDateId() {
    return responsibleExtensionDateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate1.
   *
   * @param  clientDefinedDate1  $param.type$
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate10.
   *
   * @param  clientDefinedDate10  $param.type$
   */
  public void setClientDefinedDate10(Date clientDefinedDate10) {
    this.clientDefinedDate10 = clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate11.
   *
   * @param  clientDefinedDate11  $param.type$
   */
  public void setClientDefinedDate11(Date clientDefinedDate11) {
    this.clientDefinedDate11 = clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate12.
   *
   * @param  clientDefinedDate12  $param.type$
   */
  public void setClientDefinedDate12(Date clientDefinedDate12) {
    this.clientDefinedDate12 = clientDefinedDate12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate13.
   *
   * @param  clientDefinedDate13  $param.type$
   */
  public void setClientDefinedDate13(Date clientDefinedDate13) {
    this.clientDefinedDate13 = clientDefinedDate13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate14.
   *
   * @param  clientDefinedDate14  $param.type$
   */
  public void setClientDefinedDate14(Date clientDefinedDate14) {
    this.clientDefinedDate14 = clientDefinedDate14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate15.
   *
   * @param  clientDefinedDate15  $param.type$
   */
  public void setClientDefinedDate15(Date clientDefinedDate15) {
    this.clientDefinedDate15 = clientDefinedDate15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate16.
   *
   * @param  clientDefinedDate16  $param.type$
   */
  public void setClientDefinedDate16(Date clientDefinedDate16) {
    this.clientDefinedDate16 = clientDefinedDate16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate17.
   *
   * @param  clientDefinedDate17  $param.type$
   */
  public void setClientDefinedDate17(Date clientDefinedDate17) {
    this.clientDefinedDate17 = clientDefinedDate17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate18.
   *
   * @param  clientDefinedDate18  $param.type$
   */
  public void setClientDefinedDate18(Date clientDefinedDate18) {
    this.clientDefinedDate18 = clientDefinedDate18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate19.
   *
   * @param  clientDefinedDate19  $param.type$
   */
  public void setClientDefinedDate19(Date clientDefinedDate19) {
    this.clientDefinedDate19 = clientDefinedDate19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate2.
   *
   * @param  clientDefinedDate2  $param.type$
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate20.
   *
   * @param  clientDefinedDate20  $param.type$
   */
  public void setClientDefinedDate20(Date clientDefinedDate20) {
    this.clientDefinedDate20 = clientDefinedDate20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate3.
   *
   * @param  clientDefinedDate3  $param.type$
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate4.
   *
   * @param  clientDefinedDate4  $param.type$
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate5.
   *
   * @param  clientDefinedDate5  $param.type$
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate6.
   *
   * @param  clientDefinedDate6  $param.type$
   */
  public void setClientDefinedDate6(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate7.
   *
   * @param  clientDefinedDate7  $param.type$
   */
  public void setClientDefinedDate7(Date clientDefinedDate7) {
    this.clientDefinedDate7 = clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate8.
   *
   * @param  clientDefinedDate8  $param.type$
   */
  public void setClientDefinedDate8(Date clientDefinedDate8) {
    this.clientDefinedDate8 = clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDate9.
   *
   * @param  clientDefinedDate9  $param.type$
   */
  public void setClientDefinedDate9(Date clientDefinedDate9) {
    this.clientDefinedDate9 = clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setResponsible.
   *
   * @param  responsible  $param.type$
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setResponsibleExtensionDateId.
   *
   * @param  responsibleExtensionDateId  $param.type$
   */
  public void setResponsibleExtensionDateId(Long responsibleExtensionDateId) {
    this.responsibleExtensionDateId = responsibleExtensionDateId;
  }
} // end class ResponsibleExtensionDate
