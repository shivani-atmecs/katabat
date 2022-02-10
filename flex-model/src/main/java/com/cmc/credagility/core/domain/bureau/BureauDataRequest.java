package com.cmc.credagility.core.domain.bureau;

import com.cmc.credagility.core.domain.base.AbstractBaseActionResult;
import com.ozstrategy.credagility.core.domain.BureauDataProvider;
import com.ozstrategy.credagility.core.domain.BureauImportAction;
import com.ozstrategy.credagility.core.domain.BureauRequestType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * This class is used to store Bureau import action information.
 *
 * <p><a href="BureauDataRequest.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/15/2016 11:22
 */
@Entity
@Table(
  name    = "BureauDataRequest",
  indexes = {
    @Index(
      name = "createDateIndex",
      columnList = "createDate"
    ),
    @Index(
      name = "ruleBatchIdIndex",
      columnList = "ruleBatchId"
    ),
    @Index(
      name = "sourceIndex",
      columnList = "source"
    ),
    @Index(
      name = "statusIndex",
      columnList = "status"
    ),
    @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    )
  }
)
public class BureauDataRequest extends AbstractBaseActionResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7170030771562768124L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "bureauDataProviderId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BureauDataProvider bureauDataProvider;

  @JoinColumn(
    name     = "bureauImportActionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BureauImportAction bureauImportAction;

  @JoinColumn(
    name     = "bureauRequestTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BureauRequestType bureauRequestType;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau data provider.
   *
   * @return  BureauDataProvider
   */
  public BureauDataProvider getBureauDataProvider() {
    return bureauDataProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau import action.
   *
   * @return  BureauImportAction
   */
  public BureauImportAction getBureauImportAction() {
    return bureauImportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau request type.
   *
   * @return  BureauRequestType
   */
  public BureauRequestType getBureauRequestType() {
    return bureauRequestType;
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
   * setter method for bureau data provider.
   *
   * @param  bureauDataProvider  BureauDataProvider
   */
  public void setBureauDataProvider(BureauDataProvider bureauDataProvider) {
    this.bureauDataProvider = bureauDataProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau import action.
   *
   * @param  bureauImportAction  BureauImportAction
   */
  public void setBureauImportAction(BureauImportAction bureauImportAction) {
    this.bureauImportAction = bureauImportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau request type.
   *
   * @param  bureauRequestType  BureauRequestType
   */
  public void setBureauRequestType(BureauRequestType bureauRequestType) {
    this.bureauRequestType = bureauRequestType;
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
} // end class BureauDataRequest
