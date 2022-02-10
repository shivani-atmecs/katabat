package com.cmc.credagility.core.domain.channel;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.ByteEncryptedConverter;


/**
 * Base Channel Result Document.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 15:11
 */
@MappedSuperclass public abstract class BaseChannelResultDocument extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;


  /** export Content Size. */
  protected Long exportContentSize;


  /** document extension. */
  @Column(length = 128)
  protected String extension;


  /** file Content. */
  @Column(columnDefinition = "MEDIUMBLOB")
  @Convert(converter = ByteEncryptedConverter.class)
  protected byte[] fileContent;


  /** doc fileType. */
  @Column protected String fileType;


  /** mail Content Size. */
  protected Long mailContentSize;

  /** Document responsible. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne protected Responsible responsible;


  @Basic(fetch = FetchType.LAZY)
  @Column(
    name             = "exportContent",
    nullable         = true,
    columnDefinition = "LONGBLOB"
  )
  @Convert(converter = ByteEncryptedConverter.class)
  private byte[] exportContent;


  @Basic(fetch = FetchType.LAZY)
  @Column(
    name             = "mailContent",
    nullable         = true,
    columnDefinition = "LONGBLOB"
  )
  @Convert(converter = ByteEncryptedConverter.class)
  private byte[] mailContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  AbstractChannelResult
   */
  public abstract AbstractChannelResult getChannelResult();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BaseChannelResultDocument that = (BaseChannelResultDocument) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if (!Arrays.equals(mailContent, that.mailContent)) {
      return false;
    }

    if ((fileType != null) ? (!fileType.equals(that.fileType)) : (that.fileType != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export content.
   *
   * @return  byte[]
   */
  public byte[] getExportContent() {
    return exportContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for export content size.
   *
   * @return  Long
   */
  public Long getExportContentSize() {
    return exportContentSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file content.
   *
   * @return  byte[]
   */
  public byte[] getFileContent() {
    return fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file type.
   *
   * @return  String
   */
  public String getFileType() {
    return fileType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail content.
   *
   * @return  byte[]
   */
  public byte[] getMailContent() {
    return mailContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mail content size.
   *
   * @return  Long
   */
  public Long getMailContentSize() {
    return mailContentSize;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((mailContent != null) ? Arrays.hashCode(mailContent) : 0);
    result = (31 * result) + ((fileType != null) ? fileType.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export content.
   *
   * @param  exportContent  byte[]
   */
  public void setExportContent(byte[] exportContent) {
    this.exportContent = exportContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for export content size.
   *
   * @param  exportContentSize  Long
   */
  public void setExportContentSize(Long exportContentSize) {
    this.exportContentSize = exportContentSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file content.
   *
   * @param  fileContent  byte[]
   */
  public void setFileContent(byte[] fileContent) {
    this.fileContent = fileContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file type.
   *
   * @param  fileType  String
   */
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail content.
   *
   * @param  mailContent  byte[]
   */
  public void setMailContent(byte[] mailContent) {
    this.mailContent = mailContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mail content size.
   *
   * @param  mailContentSize  Long
   */
  public void setMailContentSize(Long mailContentSize) {
    this.mailContentSize = mailContentSize;
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
} // end class BaseChannelResultDocument
