package com.cmc.credagility.core.domain.account;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.export.BaseExportLayout;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 10:17
 */
@Entity
@Table(name = "AccountExportLayout")
public class AccountExportLayout extends BaseExportLayout {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4155450319006437384L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 40)
  protected String category;

  /** DOCUMENT ME! */

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "accountExportLayout",
    cascade       = { CascadeType.REMOVE, CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc ")
  protected Set<AccountExportLayoutColumn> columns = new LinkedHashSet<AccountExportLayoutColumn>();

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountExportLayout object.
   */
  public AccountExportLayout() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    AccountExportLayout that = (AccountExportLayout) o;

    if ((columns != null) ? (!columns.equals(that.columns)) : (that.columns != null)) {
      return false;
    }

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for columns.
   *
   * @return  Set
   */
  public Set<AccountExportLayoutColumn> getColumns() {
    return columns;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((columns != null) ? columns.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for columns.
   *
   * @param  columns  Set
   */
  public void setColumns(Set<AccountExportLayoutColumn> columns) {
    this.columns = columns;
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
   * @see  com.cmc.credagility.core.domain.export.BaseExportLayout#update(com.cmc.credagility.core.domain.account.AccountExportLayout)
   */
  @Override public void update(AccountExportLayout layout) {
    super.update(layout);
    this.setCategory(layout.getCategory());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateColumns.
   *
   * @param  layoutColumns  Set
   */
  public void updateColumns(Set<AccountExportLayoutColumn> layoutColumns) {
    for (AccountExportLayoutColumn layoutColumn : layoutColumns) {
      layoutColumn.setAccountExportLayout(this);
    }

    this.columns.addAll(layoutColumns);
  }
} // end class AccountExportLayout
