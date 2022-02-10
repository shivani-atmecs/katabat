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

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 16:38
 */
@Entity
@Table(name = "ResponsibleExtensionInteger")
public class ResponsibleExtensionInteger extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157902902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleExtensionIntegerId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleExtensionIntegerId;

  @Column(name = "clientDefinedBigInt1")
  private Long clientDefinedBigInt1;

  @Column(name = "clientDefinedBigInt2")
  private Long clientDefinedBigInt2;

  @Column(name = "clientDefinedBigInt3")
  private Long clientDefinedBigInt3;

  @Column(name = "clientDefinedBigInt4")
  private Long clientDefinedBigInt4;


  @Column(
    name   = "clientDefinedInteger1",
    length = 9
  )
  private Integer clientDefinedInteger1;

  @Column(
    name   = "clientDefinedInteger10",
    length = 9
  )
  private Integer clientDefinedInteger10;
  @Column(
    name   = "clientDefinedInteger11",
    length = 9
  )
  private Integer clientDefinedInteger11;
  @Column(
    name   = "clientDefinedInteger12",
    length = 9
  )
  private Integer clientDefinedInteger12;
  @Column(
    name   = "clientDefinedInteger13",
    length = 9
  )
  private Integer clientDefinedInteger13;
  @Column(
    name   = "clientDefinedInteger14",
    length = 9
  )
  private Integer clientDefinedInteger14;
  @Column(
    name   = "clientDefinedInteger15",
    length = 9
  )
  private Integer clientDefinedInteger15;
  @Column(
    name   = "clientDefinedInteger16",
    length = 9
  )
  private Integer clientDefinedInteger16;
  @Column(
    name   = "clientDefinedInteger17",
    length = 9
  )
  private Integer clientDefinedInteger17;
  @Column(
    name   = "clientDefinedInteger18",
    length = 9
  )
  private Integer clientDefinedInteger18;
  @Column(
    name   = "clientDefinedInteger19",
    length = 9
  )
  private Integer clientDefinedInteger19;

  @Column(
    name   = "clientDefinedInteger2",
    length = 9
  )
  private Integer clientDefinedInteger2;
  @Column(
    name   = "clientDefinedInteger20",
    length = 9
  )
  private Integer clientDefinedInteger20;

  @Column(
    name   = "clientDefinedInteger3",
    length = 9
  )
  private Integer clientDefinedInteger3;

  @Column(
    name   = "clientDefinedInteger4",
    length = 9
  )
  private Integer clientDefinedInteger4;

  @Column(
    name   = "clientDefinedInteger5",
    length = 9
  )
  private Integer clientDefinedInteger5;

  @Column(
    name   = "clientDefinedInteger6",
    length = 9
  )
  private Integer clientDefinedInteger6;

  @Column(
    name   = "clientDefinedInteger7",
    length = 9
  )
  private Integer clientDefinedInteger7;

  @Column(
    name   = "clientDefinedInteger8",
    length = 9
  )
  private Integer clientDefinedInteger8;

  @Column(
    name   = "clientDefinedInteger9",
    length = 9
  )
  private Integer clientDefinedInteger9;

  @JoinColumn(
    name   = "responsibleId",
    unique = true
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getClientDefinedBigInt1() {
    return clientDefinedBigInt1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getClientDefinedBigInt2() {
    return clientDefinedBigInt2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getClientDefinedBigInt3() {
    return clientDefinedBigInt3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getClientDefinedBigInt4() {
    return clientDefinedBigInt4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger10() {
    return clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger11() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger12() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger13() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger14() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger15() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger16() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger17() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger18() {
    return clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger19() {
    return clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger20() {
    return clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger8() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger9() {
    return clientDefinedInteger9;
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
  public Long getResponsibleExtensionIntegerId() {
    return responsibleExtensionIntegerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedBigInt1.
   *
   * @param  clientDefinedBigInt1  $param.type$
   */
  public void setClientDefinedBigInt1(Long clientDefinedBigInt1) {
    this.clientDefinedBigInt1 = clientDefinedBigInt1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedBigInt2.
   *
   * @param  clientDefinedBigInt2  $param.type$
   */
  public void setClientDefinedBigInt2(Long clientDefinedBigInt2) {
    this.clientDefinedBigInt2 = clientDefinedBigInt2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedBigInt3.
   *
   * @param  clientDefinedBigInt3  $param.type$
   */
  public void setClientDefinedBigInt3(Long clientDefinedBigInt3) {
    this.clientDefinedBigInt3 = clientDefinedBigInt3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedBigInt4.
   *
   * @param  clientDefinedBigInt4  $param.type$
   */
  public void setClientDefinedBigInt4(Long clientDefinedBigInt4) {
    this.clientDefinedBigInt4 = clientDefinedBigInt4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger1.
   *
   * @param  clientDefinedInteger1  $param.type$
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger10.
   *
   * @param  clientDefinedInteger10  $param.type$
   */
  public void setClientDefinedInteger10(Integer clientDefinedInteger10) {
    this.clientDefinedInteger10 = clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger11.
   *
   * @param  clientDefinedInteger11  $param.type$
   */
  public void setClientDefinedInteger11(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger12.
   *
   * @param  clientDefinedInteger12  $param.type$
   */
  public void setClientDefinedInteger12(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger13.
   *
   * @param  clientDefinedInteger13  $param.type$
   */
  public void setClientDefinedInteger13(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger14.
   *
   * @param  clientDefinedInteger14  $param.type$
   */
  public void setClientDefinedInteger14(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger15.
   *
   * @param  clientDefinedInteger15  $param.type$
   */
  public void setClientDefinedInteger15(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger16.
   *
   * @param  clientDefinedInteger16  $param.type$
   */
  public void setClientDefinedInteger16(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger17.
   *
   * @param  clientDefinedInteger17  $param.type$
   */
  public void setClientDefinedInteger17(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger18.
   *
   * @param  clientDefinedInteger18  $param.type$
   */
  public void setClientDefinedInteger18(Integer clientDefinedInteger18) {
    this.clientDefinedInteger18 = clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger19.
   *
   * @param  clientDefinedInteger19  $param.type$
   */
  public void setClientDefinedInteger19(Integer clientDefinedInteger19) {
    this.clientDefinedInteger19 = clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger2.
   *
   * @param  clientDefinedInteger2  $param.type$
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger20.
   *
   * @param  clientDefinedInteger20  $param.type$
   */
  public void setClientDefinedInteger20(Integer clientDefinedInteger20) {
    this.clientDefinedInteger20 = clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger3.
   *
   * @param  clientDefinedInteger3  $param.type$
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger4.
   *
   * @param  clientDefinedInteger4  $param.type$
   */
  public void setClientDefinedInteger4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger5.
   *
   * @param  clientDefinedInteger5  $param.type$
   */
  public void setClientDefinedInteger5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger6.
   *
   * @param  clientDefinedInteger6  $param.type$
   */
  public void setClientDefinedInteger6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger7.
   *
   * @param  clientDefinedInteger7  $param.type$
   */
  public void setClientDefinedInteger7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger8.
   *
   * @param  clientDefinedInteger8  $param.type$
   */
  public void setClientDefinedInteger8(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setClientDefinedInteger9.
   *
   * @param  clientDefinedInteger9  $param.type$
   */
  public void setClientDefinedInteger9(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
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
   * setResponsibleExtensionIntegerId.
   *
   * @param  responsibleExtensionIntegerId  $param.type$
   */
  public void setResponsibleExtensionIntegerId(Long responsibleExtensionIntegerId) {
    this.responsibleExtensionIntegerId = responsibleExtensionIntegerId;
  }
} // end class ResponsibleExtensionInteger
