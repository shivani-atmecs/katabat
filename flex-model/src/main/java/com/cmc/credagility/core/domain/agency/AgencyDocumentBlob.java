package com.cmc.credagility.core.domain.agency;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

import javax.sql.rowset.serial.SerialBlob;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * Blob record associated to {@link AgencyDocument}.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 18:00 PM
 */
@Entity
@Table(name = "AgencyDocumentBlob")
public class AgencyDocumentBlob extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 985328843778845898L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Which document this blob file belonged to. */
  @JoinColumn(name = "agencyDocumentId")
  @ManyToOne(
    fetch    = FetchType.LAZY,
    optional = false,
    cascade  = CascadeType.ALL
  )
  protected AgencyDocument agencyDocument;

  /** Blob content. */
  @Basic(fetch = FetchType.LAZY)
  @Column(
    name             = "content",
    nullable         = false,
    columnDefinition = "LONGBLOB"
  )
  @Lob protected byte[] content;

  /** PK, identity property. */
  @Column(
    name     = "fileBlobId",
    nullable = false,
    length   = 19
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long fileBlobId;

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

    AgencyDocumentBlob that = (AgencyDocumentBlob) o;

    if (fileBlobId != that.fileBlobId) {
      return false;
    }

    if (agencyDocument.getId() != that.agencyDocument.getId()) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency document.
   *
   * @return  AgencyDocument
   */
  public AgencyDocument getAgencyDocument() {
    return agencyDocument;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = (int) (fileBlobId ^ (fileBlobId >>> 32));
    result = (31 * result) + (int) (agencyDocument.getId() ^ (agencyDocument.getId() >>> 32));

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency document.
   *
   * @param  agencyDocument  AgencyDocument
   */
  public void setAgencyDocument(AgencyDocument agencyDocument) {
    this.agencyDocument = agencyDocument;
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

  @SuppressWarnings("unused")
  private Blob getFile() {
    try {
      return new SerialBlob(this.content);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  file  DOCUMENT ME!
   */
  @SuppressWarnings("unused")
  private void setFile(Blob file) {
    this.content = toByteArray(file);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private byte[] toByteArray(Blob fromBlob) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try {
      return toByteArrayImpl(fromBlob, baos);
    } catch (Exception e) { }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private byte[] toByteArrayImpl(Blob fromBlob, ByteArrayOutputStream baos) throws SQLException, IOException {
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
} // end class AgencyDocumentBlob
