package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplateVariableValue;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:40
 */
@Entity
@Table(
  name              = "LetterChannelResultVariableValue",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "channelResultId", "portfolioChannelTemplateVariableId" }) }
)
public class LetterChannelResultVariableValue extends PortfolioChannelTemplateVariableValue {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "channelResultId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected LetterChannelResult channelResult;


  /** pk. */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplateVariableValue#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof LetterChannelResultVariableValue)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    LetterChannelResultVariableValue that = (LetterChannelResultVariableValue) o;

    if ((channelResult != null) ? (!channelResult.equals(that.channelResult)) : (that.channelResult != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  LetterChannelResult
   */
  public LetterChannelResult getChannelResult() {
    return channelResult;
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
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioChannelTemplateVariableValue#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((channelResult != null) ? channelResult.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result.
   *
   * @param  channelResult  LetterChannelResult
   */
  public void setChannelResult(LetterChannelResult channelResult) {
    this.channelResult = channelResult;
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
} // end class LetterChannelResultVariableValue
