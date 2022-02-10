package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to represent survey question answer options.
 *
 * <p><a href="PortfolioSurveyAnswerOption.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyAnswerOption extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8882911248356034483L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The Answer option show priority. */
  @Column protected Integer displayOrder;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** <code>true</code> this answer option will selected automatic, default is <code>false.</code> */
  @Column(
    name             = "isDefault",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isDefault;

  /** option Name. */
  @Column(length = 256)
  protected String name;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "questionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PortfolioQuestion question = new PortfolioQuestion();

  /** option description. */
  @Column(length = 1024)
  protected String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PortfolioSurveyAnswerOption object.
   */
  public PortfolioSurveyAnswerOption() { }

  /**
   * Creates a new PortfolioSurveyAnswerOption object.
   *
   * @param  value  DOCUMENT ME!
   */
  public PortfolioSurveyAnswerOption(String value) {
    if (value != null) {
      String[] buf = value.split("##::");

      if (buf.length > 0) {
        name = buf[0].trim();
      }

      if (buf.length > 1) {
        this.value = buf[1].trim();
      } else {
        this.value = name;
      }

      if (buf.length == 3) {
        this.isDefault = new Boolean(buf[2].trim()).booleanValue();
      } else if (buf.length == 4) {
        this.isDefault = new Boolean(buf[3].trim()).booleanValue();
      }
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOption  DOCUMENT ME!
   */
  public void copy(PortfolioSurveyAnswerOption answerOption) {
    this.name         = answerOption.getName();
    this.value        = answerOption.getValue();
    this.isDefault    = answerOption.getDefault();
    this.displayOrder = answerOption.getDisplayOrder();
    this.setCreateDate(new Date());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyAnswerOption that = (PortfolioSurveyAnswerOption) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((question != null) ? (!question.equals(that.question)) : (that.question != null)) {
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
  public Boolean getDefault() {
    if (isDefault == null) {
      return false;
    }

    return isDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDisplayOrder() {
    return displayOrder;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestion getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aDefault  DOCUMENT ME!
   */
  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayOrder  DOCUMENT ME!
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  question  DOCUMENT ME!
   */
  public void setQuestion(PortfolioQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyAnswerOption");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", value='").append(value).append('\'');
    sb.append(", isDefault='").append(isDefault).append('\'');
// sb.append(", question=").append(question);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyAnswerOption
