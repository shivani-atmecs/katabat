package com.cmc.credagility.core.domain.sor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.StringUtils;


/**
 * Created by zhubq on 4/18/16.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  04/18/2016 16:08
 */
@Entity @Table public class TransactionCodeDocumentConfigureData implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2026395553357095203L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String docName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 4
  )
  protected String transCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 4
  )
  protected String transCodePrefix;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 4
  )
  protected String transCodeSuffix;

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

    TransactionCodeDocumentConfigureData that = (TransactionCodeDocumentConfigureData) o;

    if ((docName != null) ? (!docName.equals(that.docName)) : (that.docName != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((transCode != null) ? (!transCode.equals(that.transCode)) : (that.transCode != null)) {
      return false;
    }

    if ((transCodePrefix != null) ? (!transCodePrefix.equals(that.transCodePrefix)) : (that.transCodePrefix != null)) {
      return false;
    }

    return !((transCodeSuffix != null) ? (!transCodeSuffix.equals(that.transCodeSuffix))
                                       : (that.transCodeSuffix != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc name.
   *
   * @return  String
   */
  public String getDocName() {
    return docName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for used doc name.
   *
   * @return  String
   */
  public String getFullTransCode() {
    if (StringUtils.hasText(this.getTransCodePrefix())) {
      transCode = this.getTransCodePrefix() + transCode;
    }

    if (StringUtils.hasText(this.getTransCodeSuffix())) {
      transCode += this.getTransCodeSuffix();
    }

    return transCode;

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
   * getter method for trans code.
   *
   * @return  String
   */
  public String getTransCode() {
    return transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans code prefix.
   *
   * @return  String
   */
  public String getTransCodePrefix() {
    return transCodePrefix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans code suffix.
   *
   * @return  String
   */
  public String getTransCodeSuffix() {
    return transCodeSuffix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (docName != null) ? docName.hashCode() : 0;
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((transCode != null) ? transCode.hashCode() : 0);
    result = (31 * result) + ((transCodePrefix != null) ? transCodePrefix.hashCode() : 0);
    result = (31 * result) + ((transCodeSuffix != null) ? transCodeSuffix.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for doc name.
   *
   * @param  docName  String
   */
  public void setDocName(String docName) {
    this.docName = docName;
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
   * setter method for trans code.
   *
   * @param  transCode  String
   */
  public void setTransCode(String transCode) {
    this.transCode = transCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans code prefix.
   *
   * @param  transCodePrefix  String
   */
  public void setTransCodePrefix(String transCodePrefix) {
    this.transCodePrefix = transCodePrefix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans code suffix.
   *
   * @param  transCodeSuffix  String
   */
  public void setTransCodeSuffix(String transCodeSuffix) {
    this.transCodeSuffix = transCodeSuffix;
  }
} // end class TransactionCodeDocumentConfigureData
