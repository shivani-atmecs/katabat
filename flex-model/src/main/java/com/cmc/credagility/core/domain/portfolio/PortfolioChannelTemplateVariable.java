package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.MetaDataValueType;


/**
 * Created by IntelliJ IDEA. User: ysun Date: 7/23/11 Time: 9:27 PM To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioChannelTemplateVariable",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "templateId", "position" }) },
  indexes           = {
    @Index(
      name          = "FK99_templateId",
      columnList    = "templateId"
    )
  }
)
public class PortfolioChannelTemplateVariable extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Portfolio channel template variable expression. */
  @Column(
    name      = "expression",
    nullable  = false,
    updatable = false
  )
  protected String expression;

  /** Portfolio channel template variable format. */
  @Column(
    name      = "format",
    updatable = false
  )
  protected String format;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Portfolio channel template variable position. */
  @Column(
    name      = "position",
    nullable  = false,
    updatable = false
  )
  protected Integer position;

  /** PortfolioChannelTemplate PK templateId. */
  @JoinColumn(
    name      = "templateId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected PortfolioChannelTemplate template;

  /**
   * Portfolio channel template variable metaData value type.
   *
   * @see  com.cmc.credagility.core.domain.type.MetaDataValueType
   */
  @Column(
    name      = "type",
    nullable  = false,
    updatable = false,
    length    = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected MetaDataValueType type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final PortfolioChannelTemplateVariable other = (PortfolioChannelTemplateVariable) obj;

    if (this.position == null) {
      if (other.getPosition() != null) {
        return false;
      }
    } else if (!this.position.equals(other.getPosition())) {
      return false;
    }

    if (this.template == null) {
      if (other.getTemplate() != null) {
        return false;
      }
    } else if (!this.position.equals(other.getTemplate())) {
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
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFormat() {
    return format;
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
  public Integer getPosition() {
    return position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioChannelTemplate getTemplate() {
    return template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public MetaDataValueType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result)
      + ((this.position == null) ? 0 : this.position.hashCode());
    result = (PRIME * result)
      + ((this.template == null) ? 0 : this.template.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression  DOCUMENT ME!
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  format  DOCUMENT ME!
   */
  public void setFormat(String format) {
    this.format = format;
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
   * @param  position  DOCUMENT ME!
   */
  public void setPosition(Integer position) {
    this.position = position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  template  DOCUMENT ME!
   */
  public void setTemplate(PortfolioChannelTemplate template) {
    this.template = template;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  DOCUMENT ME!
   */
  public void setType(MetaDataValueType type) {
    this.type = type;
  }
} // end class PortfolioChannelTemplateVariable
