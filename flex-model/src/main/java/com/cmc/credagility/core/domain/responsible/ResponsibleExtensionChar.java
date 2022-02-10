package com.cmc.credagility.core.domain.responsible;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

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
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 16:43
 */
@Entity
@Table(name = "ResponsibleExtensionChar")
public class ResponsibleExtensionChar extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157910902237779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "resposibleExtensionCharId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long resposibleExtensionCharId;


  @Column(
    name   = "clientDefinedChar1",
    length = 1000
  )
  private String clientDefinedChar1;

  @Column(
    name   = "clientDefinedChar10",
    length = 1000
  )
  private String clientDefinedChar10;

  @Column(
    name   = "clientDefinedChar11",
    length = 1000
  )
  private String clientDefinedChar11;
  @Column(
    name   = "clientDefinedChar12",
    length = 1000
  )
  private String clientDefinedChar12;
  @Column(
    name   = "clientDefinedChar13",
    length = 1000
  )
  private String clientDefinedChar13;
  @Column(
    name   = "clientDefinedChar14",
    length = 1000
  )
  private String clientDefinedChar14;
  @Column(
    name   = "clientDefinedChar15",
    length = 1000
  )
  private String clientDefinedChar15;
  @Column(
    name   = "clientDefinedChar16",
    length = 1000
  )
  private String clientDefinedChar16;
  @Column(
    name   = "clientDefinedChar17",
    length = 1000
  )
  private String clientDefinedChar17;
  @Column(
    name   = "clientDefinedChar18",
    length = 1000
  )
  private String clientDefinedChar18;

  @Column(
    name   = "clientDefinedChar2",
    length = 1000
  )
  private String clientDefinedChar2;
  @Column(
    name   = "clientDefinedChar20",
    length = 1000
  )
  private String clientDefinedChar20;

  @Column(
    name   = "clientDefinedChar21",
    length = 1000
  )
  private String clientDefinedChar21;

  @Column(
    name   = "clientDefinedChar3",
    length = 1000
  )
  private String clientDefinedChar3;

  @Column(
    name   = "clientDefinedChar4",
    length = 1000
  )
  private String clientDefinedChar4;

  @Column(
    name   = "clientDefinedChar5",
    length = 1000
  )
  private String clientDefinedChar5;

  @Column(
    name   = "clientDefinedChar6",
    length = 1000
  )
  private String clientDefinedChar6;

  @Column(
    name   = "clientDefinedChar7",
    length = 1000
  )
  private String clientDefinedChar7;

  @Column(
    name   = "clientDefinedChar8",
    length = 1000
  )
  private String clientDefinedChar8;

  @Column(
    name   = "clientDefinedChar9",
    length = 1000
  )
  private String clientDefinedChar9;

  @JoinColumn(
    name   = "responsibleId",
    unique = true
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar1() {
    return clientDefinedChar1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar10() {
    return clientDefinedChar10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar11() {
    return clientDefinedChar11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar12() {
    return clientDefinedChar12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar13() {
    return clientDefinedChar13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar14() {
    return clientDefinedChar14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar15() {
    return clientDefinedChar15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar16() {
    return clientDefinedChar16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar17() {
    return clientDefinedChar17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar18() {
    return clientDefinedChar18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar2() {
    return clientDefinedChar2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar20() {
    return clientDefinedChar20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar21() {
    return clientDefinedChar21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar3() {
    return clientDefinedChar3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar4() {
    return clientDefinedChar4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar5() {
    return clientDefinedChar5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar6() {
    return clientDefinedChar6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar7() {
    return clientDefinedChar7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar8() {
    return clientDefinedChar8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char9.
   *
   * @return  String
   */
  public String getClientDefinedChar9() {
    return clientDefinedChar9;
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
   * setClientDefinedChar1.
   *
   * @param  clientDefinedChar1  $param.type$
   */
  public void setClientDefinedChar1(String clientDefinedChar1) {
    this.clientDefinedChar1 = clientDefinedChar1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar10.
   *
   * @param  clientDefinedChar10  $param.type$
   */
  public void setClientDefinedChar10(String clientDefinedChar10) {
    this.clientDefinedChar10 = clientDefinedChar10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar11.
   *
   * @param  clientDefinedChar11  $param.type$
   */
  public void setClientDefinedChar11(String clientDefinedChar11) {
    this.clientDefinedChar11 = clientDefinedChar11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar12.
   *
   * @param  clientDefinedChar12  $param.type$
   */
  public void setClientDefinedChar12(String clientDefinedChar12) {
    this.clientDefinedChar12 = clientDefinedChar12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar13.
   *
   * @param  clientDefinedChar13  $param.type$
   */
  public void setClientDefinedChar13(String clientDefinedChar13) {
    this.clientDefinedChar13 = clientDefinedChar13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar14.
   *
   * @param  clientDefinedChar14  $param.type$
   */
  public void setClientDefinedChar14(String clientDefinedChar14) {
    this.clientDefinedChar14 = clientDefinedChar14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar15.
   *
   * @param  clientDefinedChar15  $param.type$
   */
  public void setClientDefinedChar15(String clientDefinedChar15) {
    this.clientDefinedChar15 = clientDefinedChar15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar16.
   *
   * @param  clientDefinedChar16  $param.type$
   */
  public void setClientDefinedChar16(String clientDefinedChar16) {
    this.clientDefinedChar16 = clientDefinedChar16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar17.
   *
   * @param  clientDefinedChar17  $param.type$
   */
  public void setClientDefinedChar17(String clientDefinedChar17) {
    this.clientDefinedChar17 = clientDefinedChar17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar18.
   *
   * @param  clientDefinedChar18  $param.type$
   */
  public void setClientDefinedChar18(String clientDefinedChar18) {
    this.clientDefinedChar18 = clientDefinedChar18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar2.
   *
   * @param  clientDefinedChar2  $param.type$
   */
  public void setClientDefinedChar2(String clientDefinedChar2) {
    this.clientDefinedChar2 = clientDefinedChar2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar20.
   *
   * @param  clientDefinedChar20  $param.type$
   */
  public void setClientDefinedChar20(String clientDefinedChar20) {
    this.clientDefinedChar20 = clientDefinedChar20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar21.
   *
   * @param  clientDefinedChar21  $param.type$
   */
  public void setClientDefinedChar21(String clientDefinedChar21) {
    this.clientDefinedChar21 = clientDefinedChar21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar3.
   *
   * @param  clientDefinedChar3  $param.type$
   */
  public void setClientDefinedChar3(String clientDefinedChar3) {
    this.clientDefinedChar3 = clientDefinedChar3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar4.
   *
   * @param  clientDefinedChar4  $param.type$
   */
  public void setClientDefinedChar4(String clientDefinedChar4) {
    this.clientDefinedChar4 = clientDefinedChar4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar5.
   *
   * @param  clientDefinedChar5  $param.type$
   */
  public void setClientDefinedChar5(String clientDefinedChar5) {
    this.clientDefinedChar5 = clientDefinedChar5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar6.
   *
   * @param  clientDefinedChar6  $param.type$
   */
  public void setClientDefinedChar6(String clientDefinedChar6) {
    this.clientDefinedChar6 = clientDefinedChar6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar7.
   *
   * @param  clientDefinedChar7  $param.type$
   */
  public void setClientDefinedChar7(String clientDefinedChar7) {
    this.clientDefinedChar7 = clientDefinedChar7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar8.
   *
   * @param  clientDefinedChar8  $param.type$
   */
  public void setClientDefinedChar8(String clientDefinedChar8) {
    this.clientDefinedChar8 = clientDefinedChar8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char9.
   *
   * @param  clientDefinedChar9  String
   */
  public void setClientDefinedChar9(String clientDefinedChar9) {
    this.clientDefinedChar9 = clientDefinedChar9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedString6.
   *
   * @param  clientDefinedChar6  $param.type$
   */
  public void setClientDefinedString6(String clientDefinedChar6) {
    this.clientDefinedChar6 = clientDefinedChar6;
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
} // end class ResponsibleExtensionChar
