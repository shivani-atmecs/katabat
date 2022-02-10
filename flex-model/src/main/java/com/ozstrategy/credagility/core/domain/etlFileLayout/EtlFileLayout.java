package com.ozstrategy.credagility.core.domain.etlFileLayout;

import com.cmc.credagility.core.domain.portfolio.Portfolio;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 10:02
 */
@Entity
@Table(name = "EtlFileLayout")
public class EtlFileLayout extends BaseEtlFileLayout {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  @Enumerated(value = EnumType.STRING)
  protected EtlAccountLoaderCategoryEnum category;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    cascade  = CascadeType.ALL,
    mappedBy = "etlFileLayout"
  )
  @OrderBy("displayOrder asc ")
  protected Set<EtlFileLayoutColumn> columns = new LinkedHashSet<EtlFileLayoutColumn>();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String executeSyntax;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  @Column(
    nullable = false,
    length   = 32
  )
  @Enumerated(EnumType.STRING)
  private TokenizerTypeEnum tokenizer = TokenizerTypeEnum.FixedLength;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EtlFileLayout object.
   */
  public EtlFileLayout() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseEtlFileLayout#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EtlFileLayout)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EtlFileLayout that = (EtlFileLayout) o;

    if (category != that.category) {
      return false;
    }

    if ((executeSyntax != null) ? (!executeSyntax.equals(that.executeSyntax)) : (that.executeSyntax != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if (tokenizer != that.tokenizer) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  EtlAccountLoaderCategoryEnum
   */
  public EtlAccountLoaderCategoryEnum getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for columns.
   *
   * @return  Set
   */
  public Set<EtlFileLayoutColumn> getColumns() {
    return columns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execute syntax.
   *
   * @return  String
   */
  public String getExecuteSyntax() {
    return executeSyntax;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tokenizer.
   *
   * @return  TokenizerTypeEnum
   */
  public TokenizerTypeEnum getTokenizer() {
    return tokenizer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseEtlFileLayout#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((executeSyntax != null) ? executeSyntax.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((tokenizer != null) ? tokenizer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  EtlAccountLoaderCategoryEnum
   */
  public void setCategory(EtlAccountLoaderCategoryEnum category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for columns.
   *
   * @param  columns  Set
   */
  public void setColumns(Set<EtlFileLayoutColumn> columns) {
    this.columns = columns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execute syntax.
   *
   * @param  executeSyntax  String
   */
  public void setExecuteSyntax(String executeSyntax) {
    this.executeSyntax = executeSyntax;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tokenizer.
   *
   * @param  tokenizer  TokenizerTypeEnum
   */
  public void setTokenizer(TokenizerTypeEnum tokenizer) {
    this.tokenizer = tokenizer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateColumns.
   *
   * @param  layoutColumns  Set
   */
  public void updateColumns(Set<EtlFileLayoutColumn> layoutColumns) {
    for (EtlFileLayoutColumn layoutColumn : layoutColumns) {
      layoutColumn.setEtlFileLayout(this);
    }

    this.columns.addAll(layoutColumns);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateExistsColumns.
   *
   * @param  layoutColumns  Set
   */
  public void updateExistsColumns(Set<EtlFileLayoutColumn> layoutColumns) {
    if (null == layoutColumns) {
      columns.clear();

      return;
    } else if (layoutColumns.size() == 0) {
      columns.clear();

      return;
    }

    Map<Long, EtlFileLayoutColumn> newColumnMap = new HashMap<Long, EtlFileLayoutColumn>();

    for (EtlFileLayoutColumn layoutColumn : layoutColumns) {
      if ((null != layoutColumn.getId()) && (0 != layoutColumn.getId().intValue())) {
        newColumnMap.put(layoutColumn.getId(), layoutColumn);
      }
    }

    Map<Long, EtlFileLayoutColumn> idExists    = new HashMap<Long, EtlFileLayoutColumn>();
    Set<EtlFileLayoutColumn>       removeExits = new HashSet<EtlFileLayoutColumn>();

    for (EtlFileLayoutColumn layoutColumn : columns) {
      if ((null != layoutColumn.getId()) && (0 != layoutColumn.getId().intValue())
            && newColumnMap.containsKey(layoutColumn.getId())) {
        idExists.put(layoutColumn.getId(), layoutColumn);
      } else {
        removeExits.add(layoutColumn);
      }
    }

    // remove columns exist but  layoutColumns not exists that id is null or 0
    columns.removeAll(removeExits);

    EtlFileLayoutColumn existColumns = null;

    for (EtlFileLayoutColumn column : layoutColumns) {
      if ((null != column.getId()) && (0 != column.getId().intValue()) && idExists.containsKey(column.getId())) {
        existColumns = idExists.get(column.getId());

        // copy this value
        existColumns.setDefaultValue(column.getDefaultValue());
        existColumns.setPositions(column.getPositions());
        existColumns.setVariable(column.getVariable());
        existColumns.setAllowNull(column.getAllowNull());
        existColumns.setScale(column.getScale());
        existColumns.setFormat(column.getFormat());
        existColumns.setValueLength(column.getValueLength());
        existColumns.setDisplayOrder(column.getDisplayOrder());
        existColumns.setLastUpdater(column.getLastUpdater());
        existColumns.setLastUpdateDate(column.getLastUpdateDate());

      } else {
        column.setId(null);
        column.setEtlFileLayout(this);
        columns.add(column);
      }
    }

  } // end method updateExistsColumns

} // end class EtlFileLayout
