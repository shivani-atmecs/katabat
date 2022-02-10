package com.cmc.credagility.core.domain.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Yang Wang on 1/20/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/20/2015 15:09 PM
 */
@Entity
@Table(name = "LookUpValue")
public class LookUpValue implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8790608321426888401L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    nullable = false,
    length   = 30
  )
  private String category;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private int         id;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key1;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key10;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key11;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key12;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key13;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key14;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key15;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key16;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key17;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key18;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key19;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key2;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key20;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key3;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key4;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key5;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key6;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key7;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key8;

  @Column(
    nullable = true,
    length   = 30
  )
  private String key9;

  @Column(
    nullable = false,
    length   = 6
  )
  private String locale;

  @Column(
    nullable = true,
    length   = 1024
  )
  private String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  int
   */
  public int getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key1.
   *
   * @return  String
   */
  public String getKey1() {
    return key1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key10.
   *
   * @return  String
   */
  public String getKey10() {
    return key10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key11.
   *
   * @return  String
   */
  public String getKey11() {
    return key11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key12.
   *
   * @return  String
   */
  public String getKey12() {
    return key12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key13.
   *
   * @return  String
   */
  public String getKey13() {
    return key13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key14.
   *
   * @return  String
   */
  public String getKey14() {
    return key14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key15.
   *
   * @return  String
   */
  public String getKey15() {
    return key15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key16.
   *
   * @return  String
   */
  public String getKey16() {
    return key16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key17.
   *
   * @return  String
   */
  public String getKey17() {
    return key17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key18.
   *
   * @return  String
   */
  public String getKey18() {
    return key18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key19.
   *
   * @return  String
   */
  public String getKey19() {
    return key19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key2.
   *
   * @return  String
   */
  public String getKey2() {
    return key2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key20.
   *
   * @return  String
   */
  public String getKey20() {
    return key20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key3.
   *
   * @return  String
   */
  public String getKey3() {
    return key3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key4.
   *
   * @return  String
   */
  public String getKey4() {
    return key4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key5.
   *
   * @return  String
   */
  public String getKey5() {
    return key5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key6.
   *
   * @return  String
   */
  public String getKey6() {
    return key6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key7.
   *
   * @return  String
   */
  public String getKey7() {
    return key7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key8.
   *
   * @return  String
   */
  public String getKey8() {
    return key8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for key9.
   *
   * @return  String
   */
  public String getKey9() {
    return key9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locale.
   *
   * @return  String
   */
  public String getLocale() {
    return locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  int
   */
  public void setId(int id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key1.
   *
   * @param  key1  String
   */
  public void setKey1(String key1) {
    this.key1 = key1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key10.
   *
   * @param  key10  String
   */
  public void setKey10(String key10) {
    this.key10 = key10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key11.
   *
   * @param  key11  String
   */
  public void setKey11(String key11) {
    this.key11 = key11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key12.
   *
   * @param  key12  String
   */
  public void setKey12(String key12) {
    this.key12 = key12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key13.
   *
   * @param  key13  String
   */
  public void setKey13(String key13) {
    this.key13 = key13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key14.
   *
   * @param  key14  String
   */
  public void setKey14(String key14) {
    this.key14 = key14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key15.
   *
   * @param  key15  String
   */
  public void setKey15(String key15) {
    this.key15 = key15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key16.
   *
   * @param  key16  String
   */
  public void setKey16(String key16) {
    this.key16 = key16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key17.
   *
   * @param  key17  String
   */
  public void setKey17(String key17) {
    this.key17 = key17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key18.
   *
   * @param  key18  String
   */
  public void setKey18(String key18) {
    this.key18 = key18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key19.
   *
   * @param  key19  String
   */
  public void setKey19(String key19) {
    this.key19 = key19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key2.
   *
   * @param  key2  String
   */
  public void setKey2(String key2) {
    this.key2 = key2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key20.
   *
   * @param  key20  String
   */
  public void setKey20(String key20) {
    this.key20 = key20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key3.
   *
   * @param  key3  String
   */
  public void setKey3(String key3) {
    this.key3 = key3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key4.
   *
   * @param  key4  String
   */
  public void setKey4(String key4) {
    this.key4 = key4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key5.
   *
   * @param  key5  String
   */
  public void setKey5(String key5) {
    this.key5 = key5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key6.
   *
   * @param  key6  String
   */
  public void setKey6(String key6) {
    this.key6 = key6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key7.
   *
   * @param  key7  String
   */
  public void setKey7(String key7) {
    this.key7 = key7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key8.
   *
   * @param  key8  String
   */
  public void setKey8(String key8) {
    this.key8 = key8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for key9.
   *
   * @param  key9  String
   */
  public void setKey9(String key9) {
    this.key9 = key9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale.
   *
   * @param  locale  String
   */
  public void setLocale(String locale) {
    this.locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class LookUpValue
