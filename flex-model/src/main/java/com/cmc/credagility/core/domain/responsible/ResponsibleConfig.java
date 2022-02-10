package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store ResponsibleConfig information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 14:26
 */
@Entity
@Table(name = "ResponsibleConfig")
public class ResponsibleConfig extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientConsentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientConsentDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "cmcConsentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cmcConsentDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responsibleConfigId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long responsibleConfigId;

  @Cascade(
    {
      org.hibernate.annotations.CascadeType.SAVE_UPDATE,
      org.hibernate.annotations.CascadeType.DELETE
    }
  )
  @JoinColumn(
    name   = "responsibleId",
    unique = true /* ,nullable = false */
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for client consent date.
   *
   * @return  Date
   */
  public Date getClientConsentDate() {
    return clientConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc consent date.
   *
   * @return  Date
   */
  public Date getCmcConsentDate() {
    return cmcConsentDate;
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
   * getter method for responsible config id.
   *
   * @return  Long
   */
  public Long getResponsibleConfigId() {
    return responsibleConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client consent date.
   *
   * @param  clientConsentDate  Date
   */
  public void setClientConsentDate(Date clientConsentDate) {
    this.clientConsentDate = clientConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc consent date.
   *
   * @param  cmcConsentDate  Date
   */
  public void setCmcConsentDate(Date cmcConsentDate) {
    this.cmcConsentDate = cmcConsentDate;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible config id.
   *
   * @param  responsibleConfigId  Long
   */
  public void setResponsibleConfigId(Long responsibleConfigId) {
    this.responsibleConfigId = responsibleConfigId;
  }


} // end class ResponsibleConfig
