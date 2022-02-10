package com.cmc.credagility.core.domain.channel;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:12
 */
@Entity
@Table(
  name    = "SecurePdfChannelResult",
  indexes = {
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
    ),
    @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class SecurePdfChannelResult extends BaseChannelResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<SecurePdfChannelActualResult> actualResults = new LinkedHashSet<SecurePdfChannelActualResult>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "channelResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long channelResultId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<SecurePdfChannelResultDestination> securePdfChannelResultDestination =
    new LinkedHashSet<SecurePdfChannelResultDestination>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<SecurePdfChannelResultVariableValue> variableValues =
    new LinkedHashSet<SecurePdfChannelResultVariableValue>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual results.
   *
   * @return  Set
   */
  public Set<SecurePdfChannelActualResult> getActualResults() {
    return actualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result id.
   *
   * @return  Long
   */
  public Long getChannelResultId() {
    return channelResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#getResultId()
   */
  @Override public Long getResultId() {
    return getChannelResultId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for secure pdf channel result destination.
   *
   * @return  Set
   */
  public Set<SecurePdfChannelResultDestination> getSecurePdfChannelResultDestination() {
    return securePdfChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable values.
   *
   * @return  Set
   */
  public Set<SecurePdfChannelResultVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual results.
   *
   * @param  actualResults  Set
   */
  public void setActualResults(Set<SecurePdfChannelActualResult> actualResults) {
    this.actualResults = actualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result id.
   *
   * @param  channelResultId  Long
   */
  public void setChannelResultId(Long channelResultId) {
    this.channelResultId = channelResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#setResultId(java.lang.Long)
   */
  @Override public void setResultId(Long resultId) {
    setChannelResultId(resultId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secure pdf channel result destination.
   *
   * @param  securePdfChannelResultDestination  Set
   */
  public void setSecurePdfChannelResultDestination(
    Set<SecurePdfChannelResultDestination> securePdfChannelResultDestination) {
    this.securePdfChannelResultDestination = securePdfChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable values.
   *
   * @param  variableValues  Set
   */
  public void setVariableValues(Set<SecurePdfChannelResultVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("emailChannelResult ( ").append(super.toString()).append(TAB).append("channelResultId = ").append(
      this.channelResultId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class SecurePdfChannelResult
