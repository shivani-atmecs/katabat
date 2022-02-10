package com.ozstrategy.credagility.core.domain.document.responsible;

import com.cmc.credagility.core.domain.portfolio.PortfolioQuestion;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;

import javax.persistence.*;


/**
 * This class is used to store ResponsibleDocumentMetaDataValue information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 15:02
 */
@Entity
@Table(name = "ResponsibleDocumentMetaDataValue")
public class ResponsibleDocumentMetaDataValue extends DocumentMetaDataValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentInstanceId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ResponsibleDocumentInstance documentInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "questionId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestion element;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "agentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible owner;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getDocumentInstance()
   */
  @Override public ResponsibleDocumentInstance getDocumentInstance() {
    return documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element.
   *
   * @return  PortfolioQuestion
   */
  public PortfolioQuestion getElement() {
    return element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#getOwner()
   */
  @Override public Responsible getOwner() {
    return owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object obj) {
    setOwner((Responsible) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instance.
   *
   * @param  documentInstance  ResponsibleDocumentInstance
   */
  public void setDocumentInstance(ResponsibleDocumentInstance documentInstance) {
    this.documentInstance = documentInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element.
   *
   * @param  element  PortfolioQuestion
   */
  public void setElement(PortfolioQuestion element) {
    this.element = element;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue#setElementForMetaData(Object)
   */
  @Override public void setElementForMetaData(Object obj) {
    setElement((PortfolioQuestion) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for owner.
   *
   * @param  owner  Responsible
   */
  public void setOwner(Responsible owner) {
    this.owner = owner;
  }
} // end class ResponsibleDocumentMetaDataValue
