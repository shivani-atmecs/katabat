package com.ozstrategy.credagility.core.domain.document;

import com.ozstrategy.credagility.core.converter.ByteEncryptedConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * UploadDocumentBlob Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:49
 */
@MappedSuperclass public abstract class BasicUploadDocumentBlob extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Basic(fetch = FetchType.LAZY)
  @Column(
    name             = "content",
    nullable         = false,
    columnDefinition = "LONGBLOB"
  )
  @Convert(converter = ByteEncryptedConverter.class)
  protected byte[] content;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "fileBlobId",
    nullable = false,
    length   = 19
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long fileBlobId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc instance.
   *
   * @return  BasicDocumentInstance
   */
  public abstract BasicDocumentInstance getDocInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateDocumentInstance.
   *
   * @param  docInstance  BasicDocumentInstance
   */
  public abstract void updateDocumentInstance(BasicDocumentInstance docInstance);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toByteArray.
   *
   * @param   fromBlob  Blob
   *
   * @return  byte[]
   */
  public static byte[] toByteArray(Blob fromBlob) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try {
      return toByteArrayImpl(fromBlob, baos);
    } catch (Exception e) { }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toByteArrayImpl.
   *
   * @param   fromBlob  Blob
   * @param   baos      ByteArrayOutputStream
   *
   * @return  byte[]
   *
   * @throws  java.sql.SQLException  exception
   * @throws  java.io.IOException   exception
   */
  public static byte[] toByteArrayImpl(Blob fromBlob, ByteArrayOutputStream baos) throws SQLException, IOException {
    byte[]      buf      = new byte[4000];
    int         dataSize;
    InputStream is       = fromBlob.getBinaryStream();

    try {
      while ((dataSize = is.read(buf)) != -1) {
        baos.write(buf, 0, dataSize);
      }
    } finally {
      if (is != null) {
        is.close();
      }
    }

    return baos.toByteArray();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    BasicUploadDocumentBlob that = (BasicUploadDocumentBlob) o;

    if ((fileBlobId != null) ? (!fileBlobId.equals(that.fileBlobId)) : (that.fileBlobId != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @return  byte[]
   */
  public byte[] getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file blob id.
   *
   * @return  Long
   */
  public Long getFileBlobId() {
    return fileBlobId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((fileBlobId != null) ? fileBlobId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content.
   *
   * @param  content  byte[]
   */
  public void setContent(byte[] content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file blob id.
   *
   * @param  fileBlobId  Long
   */
  public void setFileBlobId(Long fileBlobId) {
    this.fileBlobId = fileBlobId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file.
   *
   * @return  Blob
   */
  @SuppressWarnings("unused")
  protected Blob getFile() {
    try {
      return new SerialBlob(this.content);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file.
   *
   * @param  file  Blob
   */
  @SuppressWarnings("unused")
  protected void setFile(Blob file) {
    this.content = toByteArray(file);
  }
} // end class BasicUploadDocumentBlob
