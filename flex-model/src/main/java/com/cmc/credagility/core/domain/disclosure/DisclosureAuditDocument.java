package com.cmc.credagility.core.domain.disclosure;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.channel.BaseChannelResultDocument;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:05
 */
@Entity
@Table(name = "DisclosureAuditDocument")
public class DisclosureAuditDocument extends BaseChannelResultDocument implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3970629918763651740L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */


  @JoinColumn(
    name     = "disclosureAuditId",
    nullable = false,
    unique   = true
  )
  @ManyToOne protected DisclosureAudit disclosureAudit;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    DisclosureAuditDocument that = (DisclosureAuditDocument) o;

    if ((disclosureAudit != null) ? (!disclosureAudit.equals(that.disclosureAudit)) : (that.disclosureAudit != null)) {
      return false;
    }

    return super.equals(o);
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelResultDocument#getChannelResult()
   */
  @Override public DisclosureAudit getChannelResult() {
    return disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disclosure audit.
   *
   * @return  DisclosureAudit
   */
  public DisclosureAudit getDisclosureAudit() {
    return disclosureAudit;
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
   * setter method for disclosure audit.
   *
   * @param  disclosureAudit  DisclosureAudit
   */
  public void setDisclosureAudit(DisclosureAudit disclosureAudit) {
    this.disclosureAudit = disclosureAudit;
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
} // end class DisclosureAuditDocument
