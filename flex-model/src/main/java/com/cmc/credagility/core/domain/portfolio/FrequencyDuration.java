package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Portfolio Program Type information.
 *
 * <p><a href="PortfolioProgramType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PortfolioProgramType"</p>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class FrequencyDuration extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8526755985654057605L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer duration;

  /** Frequency mapping -2 map 2m;-1/0/null map 1m;1 map 1d;2 map 2d. */
  @Column(nullable = false)
  protected Integer frequency;

  /** Portfolio program type Id, PK. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  /** DOCUMENT ME! */
  @Column(length = 64)
  protected String name;

  /** portfolio. */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Required payments. */
  @Column(nullable = false)
  protected Integer requiredPayments;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof FrequencyDuration)) {
      return false;
    }

    FrequencyDuration that = (FrequencyDuration) o;

    if ((duration != null) ? (!duration.equals(that.duration)) : (that.duration != null)) {
      return false;
    }

    if ((frequency != null) ? (!frequency.equals(that.frequency)) : (that.frequency != null)) {
      return false;
    }

    if ((requiredPayments != null) ? (!requiredPayments.equals(that.requiredPayments))
                                   : (that.requiredPayments != null)) {
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
  public Integer getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFrequency() {
    return frequency;
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
   * @return  the portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getRequiredPayments() {
    return requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public int getSelectedTermInDays() {
    if (getFrequency() == -1) {
      return getDuration() * 30;
    } else if (getFrequency() == 7) {
      return getDuration() * 7;
    } else if (getFrequency() == 14) {
      return getDuration() * 14;
    } else {
      Integer days = (getFrequency() < 0) ? (getFrequency() * (-30)) : getFrequency();

      return getDuration() * days;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public int getSelectedTermInMonths() {
    if (getFrequency() == -1) {
      return getDuration();
    } else if (getFrequency() == 7) {
      return (getDuration() / 4) + 1;
    } else if (getFrequency() == 14) {
      return (getDuration() / 2) + 1;
    } else {
      Integer days = (getFrequency() < 0) ? (getFrequency() * (-30)) : getFrequency();

      return ((getDuration() * days) / 30) + 1;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((frequency != null) ? frequency.hashCode() : 0);
    result = (31 * result) + ((duration != null) ? duration.hashCode() : 0);
    result = (31 * result) + ((requiredPayments != null) ? requiredPayments.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  DOCUMENT ME!
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequency  DOCUMENT ME!
   */
  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  frequency  DOCUMENT ME!
   */
  public void setFrequency(String frequency) {
    try {
      this.frequency = new Integer(frequency);
    } catch (NumberFormatException e) { }

    if ((frequency == null) || ("monthly".equalsIgnoreCase(frequency))) {
      this.frequency = -1;
    } else if (("Fortnightly").equalsIgnoreCase(frequency) || ("biweekly").equalsIgnoreCase(frequency)) {
      this.frequency = 14;
    } else if (("Weekly").equalsIgnoreCase(frequency)) {
      this.frequency = 7;
    } else if (("Daily").equalsIgnoreCase(frequency)) {
      this.frequency = 1;
    }

    if (this.frequency == null) {
      frequency = frequency.trim();

      if (frequency.matches("^\\d+(m|M)$")) {
        this.frequency = -1 * (new Integer(frequency.substring(0, frequency.length() - 1)));
      } else if (frequency.matches("^\\d+(d|D)$")) {
        this.frequency = (new Integer(frequency.substring(0, frequency.length() - 1)));
      } else if (frequency.matches("^\\d+(w|W)$")) {
        this.frequency = 7 * (new Integer(frequency.substring(0, frequency.length() - 1)));
      }
    }
  } // end method setFrequency

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
   * @param  portfolio  the portfolio to set
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  requiredPayments  DOCUMENT ME!
   */
  public void setRequiredPayments(Integer requiredPayments) {
    this.requiredPayments = requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("FrequencyDuration");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", portfolio=").append(portfolio);
    sb.append(", frequency='").append(frequency).append('\'');
    sb.append(", requiredPayments='").append(requiredPayments).append('\'');
    sb.append(", duration=").append(duration);
    sb.append('}');

    return sb.toString();
  }

} // end class FrequencyDuration
