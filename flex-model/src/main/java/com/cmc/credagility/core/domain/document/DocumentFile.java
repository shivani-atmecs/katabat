package com.cmc.credagility.core.domain.document;

import java.io.Serializable;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:10
 */
@Entity public class DocumentFile extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7040840207306095552L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(length = 128)
  protected String extension;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "MEDIUMBLOB")
  protected byte[] fileContent;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fileType;

  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "originalName",
    length = 255
  )
  protected String originalName;

  /** Document responsible. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne protected Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original name.
   *
   * @return  String
   */
  public String getOriginalName() {
    if ((originalName == null) || "".equals(originalName.trim())) {
      return UUID.randomUUID().toString();
    }

    return originalName;
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
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original name.
   *
   * @param  originalName  String
   */
  public void setOriginalName(String originalName) {
    this.originalName = originalName;
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
} // end class DocumentFile
