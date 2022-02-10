package com.cmc.credagility.core.domain.agency;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.export.BaseExportLayout;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 09:58
 */
@Entity
@Table(name = "AgencyExportLayout")
public class AgencyExportLayout extends BaseExportLayout {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1572000332832938629L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "bcExportLayout",
    cascade  = CascadeType.ALL
  )
  @OrderBy("displayOrder desc")
  protected Set<AgencyExportLayoutColumn> columns = new LinkedHashSet<AgencyExportLayoutColumn>();

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyExportLayout object.
   */
  public AgencyExportLayout() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for columns.
   *
   * @return  Set
   */
  public Set<AgencyExportLayoutColumn> getColumns() {
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
   * setter method for columns.
   *
   * @param  columns  Set
   */
  public void setColumns(Set<AgencyExportLayoutColumn> columns) {
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
} // end class AgencyExportLayout
