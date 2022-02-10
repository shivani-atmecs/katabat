package com.cmc.credagility.core.domain.responsible;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 16:41
 */
@Entity
@Table(name = "ResponsibleExtensionDecimal")
public class ResponsibleExtensionDecimal extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157910902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal1",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal10",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal11",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal12",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal13",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal14",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal15",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal16",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal16;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal17",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal17;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal18",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal18;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal19",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal19;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal2",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal20",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal20;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal3",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal4",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal5",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal6",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal7",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal8",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal9",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleExtensionDecimalId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleExtensionDecimalId;


  @JoinColumn(
    name   = "responsibleId",
    unique = true
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal10() {
    return clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal11() {
    return clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal12() {
    return clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal13() {
    return clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal14() {
    return clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal15() {
    return clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal16() {
    return clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal17() {
    return clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal18() {
    return clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal19() {
    return clientDefinedDecimal19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal20() {
    return clientDefinedDecimal20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal4() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal5() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal6() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal7() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal8() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal9() {
    return clientDefinedDecimal9;
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
  public Long getResponsibleExtensionDecimalId() {
    return responsibleExtensionDecimalId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal1.
   *
   * @param  clientDefinedDecimal1  $param.type$
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal10.
   *
   * @param  clientDefinedDecimal10  $param.type$
   */
  public void setClientDefinedDecimal10(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal11.
   *
   * @param  clientDefinedDecimal11  $param.type$
   */
  public void setClientDefinedDecimal11(BigDecimal clientDefinedDecimal11) {
    this.clientDefinedDecimal11 = clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal12.
   *
   * @param  clientDefinedDecimal12  $param.type$
   */
  public void setClientDefinedDecimal12(BigDecimal clientDefinedDecimal12) {
    this.clientDefinedDecimal12 = clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal13.
   *
   * @param  clientDefinedDecimal13  $param.type$
   */
  public void setClientDefinedDecimal13(BigDecimal clientDefinedDecimal13) {
    this.clientDefinedDecimal13 = clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal14.
   *
   * @param  clientDefinedDecimal14  $param.type$
   */
  public void setClientDefinedDecimal14(BigDecimal clientDefinedDecimal14) {
    this.clientDefinedDecimal14 = clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal15.
   *
   * @param  clientDefinedDecimal15  $param.type$
   */
  public void setClientDefinedDecimal15(BigDecimal clientDefinedDecimal15) {
    this.clientDefinedDecimal15 = clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal16.
   *
   * @param  clientDefinedDecimal16  $param.type$
   */
  public void setClientDefinedDecimal16(BigDecimal clientDefinedDecimal16) {
    this.clientDefinedDecimal16 = clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal17.
   *
   * @param  clientDefinedDecimal17  $param.type$
   */
  public void setClientDefinedDecimal17(BigDecimal clientDefinedDecimal17) {
    this.clientDefinedDecimal17 = clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal18.
   *
   * @param  clientDefinedDecimal18  $param.type$
   */
  public void setClientDefinedDecimal18(BigDecimal clientDefinedDecimal18) {
    this.clientDefinedDecimal18 = clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal19.
   *
   * @param  clientDefinedDecimal19  $param.type$
   */
  public void setClientDefinedDecimal19(BigDecimal clientDefinedDecimal19) {
    this.clientDefinedDecimal19 = clientDefinedDecimal19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal2.
   *
   * @param  clientDefinedDecimal2  $param.type$
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal20.
   *
   * @param  clientDefinedDecimal20  $param.type$
   */
  public void setClientDefinedDecimal20(BigDecimal clientDefinedDecimal20) {
    this.clientDefinedDecimal20 = clientDefinedDecimal20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal3.
   *
   * @param  clientDefinedDecimal3  $param.type$
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal4.
   *
   * @param  clientDefinedDecimal4  $param.type$
   */
  public void setClientDefinedDecimal4(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal5.
   *
   * @param  clientDefinedDecimal5  $param.type$
   */
  public void setClientDefinedDecimal5(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal6.
   *
   * @param  clientDefinedDecimal6  $param.type$
   */
  public void setClientDefinedDecimal6(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal7.
   *
   * @param  clientDefinedDecimal7  $param.type$
   */
  public void setClientDefinedDecimal7(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal8.
   *
   * @param  clientDefinedDecimal8  $param.type$
   */
  public void setClientDefinedDecimal8(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedDecimal9.
   *
   * @param  clientDefinedDecimal9  $param.type$
   */
  public void setClientDefinedDecimal9(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
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
   * setResponsibleExtensionDecimalId.
   *
   * @param  responsibleExtensionDecimalId  $param.type$
   */
  public void setResponsibleExtensionDecimalId(Long responsibleExtensionDecimalId) {
    this.responsibleExtensionDecimalId = responsibleExtensionDecimalId;
  }
} // end class ResponsibleExtensionDecimal
