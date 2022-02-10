package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * This class is used to store EnterpriseDocumentMetaData information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:28
 */
@Entity
@Table(name = "EnterpriseDocumentMetaData")
public class EnterpriseDocumentMetaData extends BasicEnterpriseDocumentMetaData implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6770193603494072470L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "documentId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocument document;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentMetaData",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseDocumentMetaDataAnswerOption> metaDataAnswerOptions =
    new LinkedHashSet<EnterpriseDocumentMetaDataAnswerOption>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name   = "variableId",
    unique = true
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected BaseVariable variable = null;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createBCVariable.
   *
   * @return  BaseVariable
   */
  public BaseVariable createBCVariable() {
    if (this.variable == null) {
      this.variable = new BCVariable();
      this.variable.setCategory("EnterpriseDocument");
      this.variable.setBuildType("source");
      this.variable.setDisplayPosition("");
      this.variable.setTag("EnterpriseDocument");
      this.variable.setBuildType("eval");
      this.variable.setCreateDate(new Date());
      this.variable.setLocked(false);
    }

    this.variable.setName(this.name);
    this.variable.setDescription(this.description);
    this.variable.setDisplayName(this.name);
    this.variable.setDataType(this.dataType);
    this.variable.setBusinessDataType(this.dataType);
    this.variable.detectDataType();

    if (this.document != null) {
      String expression = "evalManager.getDocMetaData(new Long("
        + document.getId() + "),\"" + this.name + "\")";

      variable.setExpression(expression);
    }

    this.variable.setLastUpdateDate(new Date());

    return this.variable;
  } // end method createBCVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createVariable.
   *
   * @return  BaseVariable
   */
  public BaseVariable createVariable() {
    if (this.variable == null) {
      this.variable = new Variable();
      this.variable.setCategory("EnterpriseDocument");
      this.variable.setBuildType("source");
      this.variable.setDisplayPosition("");
      this.variable.setTag("EnterpriseDocument");
      this.variable.setBuildType("eval");
      this.variable.setCreateDate(new Date());
      this.variable.setLocked(false);
    }

    this.variable.setName(this.name);
    this.variable.setDescription(this.description);
    this.variable.setDisplayName(this.name);
    this.variable.setDataType(this.dataType);
    this.variable.setBusinessDataType(this.dataType);
    this.variable.detectDataType();

    if (this.document != null) {
      String expression = "evalManager.getDocMetaData(new Long("
        + document.getId() + "),\"" + this.name + "\")";

      variable.setExpression(expression);
    }

    this.variable.setLastUpdateDate(new Date());

    return this.variable;
  } // end method createVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getDocument() {
    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data answer options.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentMetaDataAnswerOption> getMetaDataAnswerOptions() {
    return metaDataAnswerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document.
   *
   * @param  document  EnterpriseDocument
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data answer options.
   *
   * @param  metaDataAnswerOptions  Set
   */
  public void setMetaDataAnswerOptions(Set<EnterpriseDocumentMetaDataAnswerOption> metaDataAnswerOptions) {
    this.metaDataAnswerOptions = metaDataAnswerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  BaseVariable
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  Variable
   */
  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAnswerOptions.
   *
   * @param  metaData  EnterpriseDocumentMetaData
   */
  public void updateAnswerOptions(EnterpriseDocumentMetaData metaData) {
    Set<EnterpriseDocumentMetaDataAnswerOption> awOptions = metaData.getMetaDataAnswerOptions();

    if (!metaDataAnswerOptions.isEmpty()) {
      metaDataAnswerOptions.clear();
    }

    if (!awOptions.isEmpty()) {
      metaDataAnswerOptions.addAll(awOptions);
    }
// Map<String, EnterpriseDocumentMetaDataAnswerOption> map       =
// new HashMap<String, EnterpriseDocumentMetaDataAnswerOption>();
//
// if ((awOptions != null) && !awOptions.isEmpty()) {
// for (EnterpriseDocumentMetaDataAnswerOption awOption : awOptions) {
// map.put(awOption.getValue(), awOption);
// }
// }
//
// if ((awOptions != null) && !awOptions.isEmpty()) {
// for (EnterpriseDocumentMetaDataAnswerOption metaDataAnswerOption : metaDataAnswerOptions) {
// EnterpriseDocumentMetaDataAnswerOption tmpAw = map.get(metaDataAnswerOption.getValue());
//
// if (tmpAw != null) {
// metaDataAnswerOption.update(tmpAw);
// }
// }
// }
  } // end method updateAnswerOptions
} // end class EnterpriseDocumentMetaData
