package com.cmc.credagility.core.domain.account;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.export.AvailableAccountExportLayoutMappingField;
import com.cmc.credagility.core.domain.export.BaseExportLayoutColumn;
import com.cmc.credagility.core.domain.variable.BaseVariable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 10:19
 */
@Entity public class AccountExportLayoutColumn extends BaseExportLayoutColumn {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountExportLayoutId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountExportLayout accountExportLayout;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "mappingFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AvailableAccountExportLayoutMappingField mappingField;

  /** TODO: DOCUMENT ME! */
  protected String staticFieldDataType;


  /** TODO: DOCUMENT ME! */
  protected String staticFieldName;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected BaseVariable variable;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountExportLayoutColumn object.
   */
  public AccountExportLayoutColumn() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.export.BaseExportLayoutColumn#equals(java.lang.Object)
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

    AccountExportLayoutColumn column = (AccountExportLayoutColumn) o;


    if ((id != null) ? (!id.equals(column.id)) : (column.id != null)) {
      return false;
    }

    if ((mappingField != null) ? (!mappingField.equals(column.mappingField)) : (column.mappingField != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(column.variable)) : (column.variable != null)) {
      return false;
    }

    if ((format != null) ? (!format.equals(column.format)) : (column.format != null)) {
      return false;
    }

    if ((staticFieldName != null) ? (!staticFieldName.equals(column.staticFieldName))
                                  : (column.staticFieldName != null)) {
      return false;
    }

    if ((staticFieldDataType != null) ? (!staticFieldDataType.equals(column.staticFieldDataType))
                                      : (column.staticFieldDataType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account export layout.
   *
   * @return  AccountExportLayout
   */
  public AccountExportLayout getAccountExportLayout() {
    return accountExportLayout;
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
   * getter method for mapping field.
   *
   * @return  AvailableAccountExportLayoutMappingField
   */
  public AvailableAccountExportLayoutMappingField getMappingField() {
    return mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static field data type.
   *
   * @return  String
   */
  public String getStaticFieldDataType() {
    return staticFieldDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static field name.
   *
   * @return  String
   */
  public String getStaticFieldName() {
    return staticFieldName;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((mappingField != null) ? mappingField.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((format != null) ? format.hashCode() : 0);
    result = (31 * result) + ((staticFieldName != null) ? staticFieldName.hashCode() : 0);
    result = (31 * result) + ((staticFieldDataType != null) ? staticFieldDataType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account export layout.
   *
   * @param  accountExportLayout  AccountExportLayout
   */
  public void setAccountExportLayout(AccountExportLayout accountExportLayout) {
    this.accountExportLayout = accountExportLayout;
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
   * setter method for mapping field.
   *
   * @param  mappingField  AvailableAccountExportLayoutMappingField
   */
  public void setMappingField(AvailableAccountExportLayoutMappingField mappingField) {
    this.mappingField = mappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static field data type.
   *
   * @param  staticFieldDataType  String
   */
  public void setStaticFieldDataType(String staticFieldDataType) {
    this.staticFieldDataType = staticFieldDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static field name.
   *
   * @param  staticFieldName  String
   */
  public void setStaticFieldName(String staticFieldName) {
    this.staticFieldName = staticFieldName;
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
} // end class AccountExportLayoutColumn
