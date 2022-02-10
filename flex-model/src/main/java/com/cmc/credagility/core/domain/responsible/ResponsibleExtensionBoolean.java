package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  08/03/2015 10:37
 */
@Entity
@Table(name = "ResponsibleExtensionBoolean")
public class ResponsibleExtensionBoolean extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157903902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleExtensionBooleanId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleExtensionBooleanId;

  @Column(
    name   = "clientDefinedBoolean1",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean1;

  @Column(
    name   = "clientDefinedBoolean10",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean10;

  @Column(
    name   = "clientDefinedBoolean11",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean11;

  @Column(
    name   = "clientDefinedBoolean12",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean12;

  @Column(
    name   = "clientDefinedBoolean13",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean13;

  @Column(
    name   = "clientDefinedBoolean14",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean14;

  @Column(
    name   = "clientDefinedBoolean15",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean15;

  @Column(
    name   = "clientDefinedBoolean16",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean16;

  @Column(
    name   = "clientDefinedBoolean17",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean17;

  @Column(
    name   = "clientDefinedBoolean18",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean18;

  @Column(
    name   = "clientDefinedBoolean19",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean19;

  @Column(
    name   = "clientDefinedBoolean2",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean2;

  @Column(
    name   = "clientDefinedBoolean20",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean20;

  @Column(
    name   = "clientDefinedBoolean3",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean3;

  @Column(
    name   = "clientDefinedBoolean4",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean4;

  @Column(
    name   = "clientDefinedBoolean5",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean5;

  @Column(
    name   = "clientDefinedBoolean6",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean6;

  @Column(
    name   = "clientDefinedBoolean7",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean7;

  @Column(
    name   = "clientDefinedBoolean8",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean8;

  @Column(
    name   = "clientDefinedBoolean9",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean9;

  @JoinColumn(
    name   = "responsibleId",
    unique = true
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean1() {
    return clientDefinedBoolean1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean10.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean10() {
    return clientDefinedBoolean10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean11.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean11() {
    return clientDefinedBoolean11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean12.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean12() {
    return clientDefinedBoolean12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean13.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean13() {
    return clientDefinedBoolean13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean14.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean14() {
    return clientDefinedBoolean14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean15.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean15() {
    return clientDefinedBoolean15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean16.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean16() {
    return clientDefinedBoolean16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean17.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean17() {
    return clientDefinedBoolean17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean18.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean18() {
    return clientDefinedBoolean18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean19.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean19() {
    return clientDefinedBoolean19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean2.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean2() {
    return clientDefinedBoolean2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean20.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean20() {
    return clientDefinedBoolean20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean3.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean3() {
    return clientDefinedBoolean3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean4.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean4() {
    return clientDefinedBoolean4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean5.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean5() {
    return clientDefinedBoolean5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean6.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean6() {
    return clientDefinedBoolean6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean7.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean7() {
    return clientDefinedBoolean7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean8.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean8() {
    return clientDefinedBoolean8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean9.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean9() {
    return clientDefinedBoolean9;
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
   * getter method for responsible extension boolean id.
   *
   * @return  Long
   */
  public Long getResponsibleExtensionBooleanId() {
    return responsibleExtensionBooleanId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean1.
   *
   * @param  clientDefinedBoolean1  Boolean
   */
  public void setClientDefinedBoolean1(Boolean clientDefinedBoolean1) {
    this.clientDefinedBoolean1 = clientDefinedBoolean1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean10.
   *
   * @param  clientDefinedBoolean10  Boolean
   */
  public void setClientDefinedBoolean10(Boolean clientDefinedBoolean10) {
    this.clientDefinedBoolean10 = clientDefinedBoolean10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean11.
   *
   * @param  clientDefinedBoolean11  Boolean
   */
  public void setClientDefinedBoolean11(Boolean clientDefinedBoolean11) {
    this.clientDefinedBoolean11 = clientDefinedBoolean11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean12.
   *
   * @param  clientDefinedBoolean12  Boolean
   */
  public void setClientDefinedBoolean12(Boolean clientDefinedBoolean12) {
    this.clientDefinedBoolean12 = clientDefinedBoolean12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean13.
   *
   * @param  clientDefinedBoolean13  Boolean
   */
  public void setClientDefinedBoolean13(Boolean clientDefinedBoolean13) {
    this.clientDefinedBoolean13 = clientDefinedBoolean13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean14.
   *
   * @param  clientDefinedBoolean14  Boolean
   */
  public void setClientDefinedBoolean14(Boolean clientDefinedBoolean14) {
    this.clientDefinedBoolean14 = clientDefinedBoolean14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean15.
   *
   * @param  clientDefinedBoolean15  Boolean
   */
  public void setClientDefinedBoolean15(Boolean clientDefinedBoolean15) {
    this.clientDefinedBoolean15 = clientDefinedBoolean15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean16.
   *
   * @param  clientDefinedBoolean16  Boolean
   */
  public void setClientDefinedBoolean16(Boolean clientDefinedBoolean16) {
    this.clientDefinedBoolean16 = clientDefinedBoolean16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean17.
   *
   * @param  clientDefinedBoolean17  Boolean
   */
  public void setClientDefinedBoolean17(Boolean clientDefinedBoolean17) {
    this.clientDefinedBoolean17 = clientDefinedBoolean17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean18.
   *
   * @param  clientDefinedBoolean18  Boolean
   */
  public void setClientDefinedBoolean18(Boolean clientDefinedBoolean18) {
    this.clientDefinedBoolean18 = clientDefinedBoolean18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean19.
   *
   * @param  clientDefinedBoolean19  Boolean
   */
  public void setClientDefinedBoolean19(Boolean clientDefinedBoolean19) {
    this.clientDefinedBoolean19 = clientDefinedBoolean19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean2.
   *
   * @param  clientDefinedBoolean2  Boolean
   */
  public void setClientDefinedBoolean2(Boolean clientDefinedBoolean2) {
    this.clientDefinedBoolean2 = clientDefinedBoolean2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean20.
   *
   * @param  clientDefinedBoolean20  Boolean
   */
  public void setClientDefinedBoolean20(Boolean clientDefinedBoolean20) {
    this.clientDefinedBoolean20 = clientDefinedBoolean20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean3.
   *
   * @param  clientDefinedBoolean3  Boolean
   */
  public void setClientDefinedBoolean3(Boolean clientDefinedBoolean3) {
    this.clientDefinedBoolean3 = clientDefinedBoolean3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean4.
   *
   * @param  clientDefinedBoolean4  Boolean
   */
  public void setClientDefinedBoolean4(Boolean clientDefinedBoolean4) {
    this.clientDefinedBoolean4 = clientDefinedBoolean4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean5.
   *
   * @param  clientDefinedBoolean5  Boolean
   */
  public void setClientDefinedBoolean5(Boolean clientDefinedBoolean5) {
    this.clientDefinedBoolean5 = clientDefinedBoolean5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean6.
   *
   * @param  clientDefinedBoolean6  Boolean
   */
  public void setClientDefinedBoolean6(Boolean clientDefinedBoolean6) {
    this.clientDefinedBoolean6 = clientDefinedBoolean6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean7.
   *
   * @param  clientDefinedBoolean7  Boolean
   */
  public void setClientDefinedBoolean7(Boolean clientDefinedBoolean7) {
    this.clientDefinedBoolean7 = clientDefinedBoolean7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean8.
   *
   * @param  clientDefinedBoolean8  Boolean
   */
  public void setClientDefinedBoolean8(Boolean clientDefinedBoolean8) {
    this.clientDefinedBoolean8 = clientDefinedBoolean8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean9.
   *
   * @param  clientDefinedBoolean9  Boolean
   */
  public void setClientDefinedBoolean9(Boolean clientDefinedBoolean9) {
    this.clientDefinedBoolean9 = clientDefinedBoolean9;
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
   * setter method for responsible extension boolean id.
   *
   * @param  responsibleExtensionBooleanId  Long
   */
  public void setResponsibleExtensionBooleanId(Long responsibleExtensionBooleanId) {
    this.responsibleExtensionBooleanId = responsibleExtensionBooleanId;
  }
} // end class ResponsibleExtensionBoolean
