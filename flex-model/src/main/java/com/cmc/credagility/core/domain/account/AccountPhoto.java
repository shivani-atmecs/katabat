package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * Created by Yang Wang on 2/22/16.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  02/22/2016 15:56 PM
 */
@Entity
@Table(name = "AccountPhoto")
public class AccountPhoto extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4875388672577834583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(name = "extension")
  protected String extension;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "Id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "photoBlob",
    nullable         = false,
    columnDefinition = "LONGBLOB"
  )
  @Lob protected byte[] photoBlob;

  /** TODO: DOCUMENT ME! */
  @Column(name = "photoName")
  protected String photoName;

  /** TODO: DOCUMENT ME! */
  @Column(name = "photoType")
  protected String photoType;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for photo blob.
   *
   * @return  byte[]
   */
  public byte[] getPhotoBlob() {
    return photoBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for photo name.
   *
   * @return  String
   */
  public String getPhotoName() {
    return photoName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for photo type.
   *
   * @return  String
   */
  public String getPhotoType() {
    return photoType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for photo blob.
   *
   * @param  photoBlob  byte[]
   */
  public void setPhotoBlob(byte[] photoBlob) {
    this.photoBlob = photoBlob;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for photo name.
   *
   * @param  photoName  String
   */
  public void setPhotoName(String photoName) {
    this.photoName = photoName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for photo type.
   *
   * @param  photoType  String
   */
  public void setPhotoType(String photoType) {
    this.photoType = photoType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }
} // end class AccountPhoto
