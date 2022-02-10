package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yongliu on 11/23/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/23/2016 15:35
 */
@Entity
@Table(
  name              = "BureauDataProviderRequestType",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "unique_bureau_data_provider_request_type",
      columnNames   = { "bureauDataProviderId", "bureauRequestTypeId" }
    )
  }
)
public class BureauDataProviderRequestType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5291546289909646647L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "bureauDataProviderId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BureauDataProvider bureauDataProvider;

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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(Object)
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

    BureauDataProviderRequestType that = (BureauDataProviderRequestType) o;

    if ((bureauDataProvider != null) ? (!bureauDataProvider.equals(that.bureauDataProvider))
                                     : (that.bureauDataProvider != null)) {
      return false;
    }

    return !((bureauRequestType != null) ? (!bureauRequestType.equals(that.bureauRequestType))
                                         : (that.bureauRequestType != null));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bureauDataProvider != null) ? bureauDataProvider.hashCode() : 0);
    result = (31 * result) + ((bureauRequestType != null) ? bureauRequestType.hashCode() : 0);

    return result;
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
} // end class BureauDataProviderRequestType
