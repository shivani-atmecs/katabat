package com.cmc.credagility.core.domain.disclosure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.channel.DialerChannelResultVariableValue;
import com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplateVariableValue;


/**
 * Created by IntelliJ IDEA. User: wangy Date: 12-11-17 Time: AM9:15 To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "DisclosureAuditVariableValue",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "disclosureAuditId", "portfolioChannelTemplateVariableId" }) }
)
public class DisclosureAuditVariableValue extends PortfolioChannelTemplateVariableValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "disclosureAuditId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DisclosureAudit disclosureAudit;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioChannelTemplateVariableValue#equals(Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    DialerChannelResultVariableValue other = (DialerChannelResultVariableValue) obj;

    if (disclosureAudit == null) {
      if (other.getChannelResult() != null) {
        return false;
      }
    } else if (!disclosureAudit.equals(other.getChannelResult())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public DisclosureAudit getDisclosureAudit() {
    return disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioChannelTemplateVariableValue#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((disclosureAudit == null) ? 0 : disclosureAudit.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disclosureAudit  DOCUMENT ME!
   */
  public void setDisclosureAudit(DisclosureAudit disclosureAudit) {
    this.disclosureAudit = disclosureAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }
} // end class DisclosureAuditVariableValue
