package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM5:57</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class BasicWorkflowTaskElementAnswer extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1122769706177824687L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Answer taking date. */
  @Column(
    name      = "answerDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date answerDate;

  /** Business data type. */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String businessDataType;

  /** Channel. */
  @Column(length = 20)
  protected String channel;


  /** Survey answer data. */
  @Column(
    name   = "data",
    length = 1024
  )
  protected String data;

  /** Data type. */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String dataType;

  /** value format. */
  @Column(length = 255)
  protected String valueFormat;

  /** Hash code of answer = hashCode(task code) + hashCode(answer data). */
  @Column private Integer answerHashCode;

  @Column private Date exportDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   taskCode  DOCUMENT ME!
   * @param   answer    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static int calAnswerHashCode(String taskCode, String answer) {
    int result = 0;

    result = ((taskCode != null) ? taskCode.hashCode() : 0);
    result = (31 * result) + ((answer != null) ? answer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   o  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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

    BasicWorkflowTaskElementAnswer that = (BasicWorkflowTaskElementAnswer) o;

    if (!answerDate.equals(that.answerDate)) {
      return false;
    }

    if (!businessDataType.equals(that.businessDataType)) {
      return false;
    }

    if ((data != null) ? (!data.equals(that.data)) : (that.data != null)) {
      return false;
    }

    if (!dataType.equals(that.dataType)) {
      return false;
    }

    if ((channel != null) ? (!channel.equals(that.channel)) : (that.channel != null)) {
      return false;
    }

    if ((exportDate != null) ? (!exportDate.equals(that.exportDate)) : (that.exportDate != null)) {
      return false;
    }

    if ((valueFormat != null) ? (!valueFormat.equals(that.valueFormat)) : (that.valueFormat != null)) {
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
  public Date getAnswerDate() {
    return answerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAnswerHashCode() {
    return answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData() {
    return data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getExportDate() {
    return exportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValueFormat() {
    return valueFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((data != null) ? data.hashCode() : 0);
    result = (31 * result) + ((valueFormat != null) ? valueFormat.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((answerDate != null) ? answerDate.hashCode() : 0);
    result = (31 * result) + ((exportDate != null) ? exportDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerDate  DOCUMENT ME!
   */
  public void setAnswerDate(Date answerDate) {
    this.answerDate = answerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerHashCode  DOCUMENT ME!
   */
  public void setAnswerHashCode(Integer answerHashCode) {
    this.answerHashCode = answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessDataType  DOCUMENT ME!
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channel  DOCUMENT ME!
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data  DOCUMENT ME!
   */
  public void setData(String data) {
    this.data = data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dataType  DOCUMENT ME!
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportDate  DOCUMENT ME!
   */
  public void setExportDate(Date exportDate) {
    this.exportDate = exportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  valueFormat  DOCUMENT ME!
   */
  public void setValueFormat(String valueFormat) {
    this.valueFormat = valueFormat;
  }
} // end class BasicWorkflowTaskElementAnswer
