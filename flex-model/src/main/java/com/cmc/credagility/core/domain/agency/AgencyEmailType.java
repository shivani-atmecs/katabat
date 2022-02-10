package com.cmc.credagility.core.domain.agency;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.EmailType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 09:56
 */
@Entity
@Table(
  name              = "AgencyEmailType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "emailTypeId" }) }
)
public class AgencyEmailType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1239440306335541918L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "emailTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private EmailType emailType;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long  id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type.
   *
   * @return  EmailType
   */
  public EmailType getEmailType() {
    return emailType;
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
   * setter method for email type.
   *
   * @param  emailType  EmailType
   */
  public void setEmailType(EmailType emailType) {
    this.emailType = emailType;
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
} // end class AgencyEmailType
