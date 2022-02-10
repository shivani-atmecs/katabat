package com.cmc.credagility.core.domain.export;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:17
 */
@MappedSuperclass public class BaseExportConfiguration extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6931667163726058046L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "queueExportDestination",
    length = 256
  )
  protected String queueExportDestination;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "queueExportFileName",
    length = 256
  )
  protected String queueExportFileName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "queueExportLocation",
    length = 50
  )
  protected String queueExportLocation;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    BaseExportConfiguration that = (BaseExportConfiguration) o;

    if ((queueExportDestination != null) ? (!queueExportDestination.equals(that.queueExportDestination))
                                         : (that.queueExportDestination != null)) {
      return false;
    }

    if ((queueExportFileName != null) ? (!queueExportFileName.equals(that.queueExportFileName))
                                      : (that.queueExportFileName != null)) {
      return false;
    }

    if ((queueExportLocation != null) ? (!queueExportLocation.equals(that.queueExportLocation))
                                      : (that.queueExportLocation != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for processed queue export file name.
   *
   * @return  String
   */
  public String getProcessedQueueExportFileName() {
    if (!StringUtils.hasText(this.queueExportFileName)) {
      return this.queueExportFileName;
    }

    Pattern      p       = Pattern.compile("\\$\\{(.*?)\\}");
    Matcher      matcher = p.matcher(this.queueExportFileName);
    StringBuffer buffer  = new StringBuffer();

    while (matcher.find()) {
      String replacement = "";

      try {
        SimpleDateFormat sdf = new SimpleDateFormat(matcher.group(1));
        replacement = sdf.format(new Date());
      } catch (Exception e) { }

      matcher.appendReplacement(buffer, replacement);
    }

    matcher.appendTail(buffer);

    return buffer.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue export destination.
   *
   * @return  String
   */
  public String getQueueExportDestination() {
    return queueExportDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue export file name.
   *
   * @return  String
   */
  public String getQueueExportFileName() {
    return queueExportFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue export location.
   *
   * @return  String
   */
  public String getQueueExportLocation() {
    return queueExportLocation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((queueExportDestination != null) ? queueExportDestination.hashCode() : 0);
    result = (31 * result) + ((queueExportFileName != null) ? queueExportFileName.hashCode() : 0);
    result = (31 * result) + ((queueExportLocation != null) ? queueExportLocation.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue export destination.
   *
   * @param  queueExportDestination  String
   */
  public void setQueueExportDestination(String queueExportDestination) {
    this.queueExportDestination = queueExportDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue export file name.
   *
   * @param  queueExportFileName  String
   */
  public void setQueueExportFileName(String queueExportFileName) {
    this.queueExportFileName = queueExportFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue export location.
   *
   * @param  queueExportLocation  String
   */
  public void setQueueExportLocation(String queueExportLocation) {
    this.queueExportLocation = queueExportLocation;
  }
} // end class BaseExportConfiguration
