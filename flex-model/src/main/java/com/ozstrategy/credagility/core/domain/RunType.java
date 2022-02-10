package com.ozstrategy.credagility.core.domain;

import org.springframework.util.StringUtils;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:37
 */
public class RunType {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private boolean batch = false;

  private boolean bureauImport = false;
  private boolean channel      = false;
  private boolean cid          = false;
  private boolean event        = false;
  private boolean persona      = false;
  private boolean preview      = false;

  private boolean program = false;
  private boolean queue   = false;
  private boolean score   = false;
  private boolean status  = false;
  private boolean dataExport=false;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RunType object.
   */
  public RunType() { }

  /**
   * Creates a new RunType object.
   *
   * @param  type  String
   */
  public RunType(String type) {
    program      = true;
    channel      = true;
    persona      = true;
    score        = true;
    queue        = true;
    status       = true;
    bureauImport = true;
    dataExport   = true;

    if (type.equalsIgnoreCase("batch")) {
      batch = true;
    } else if (type.equalsIgnoreCase("cid")) {
      cid = true;
    } else if (type.equalsIgnoreCase("preview")) {
      preview = true;
    } else if (type.equalsIgnoreCase("event")) {
      event = true;
    }

  }

  /**
   * Creates a new RunType object.
   *
   * @param  type        String
   * @param  actionType  String
   */
  public RunType(String type, String actionType) {
    if (type.equalsIgnoreCase("batch")) {
      batch = true;
    } else if (type.equalsIgnoreCase("cid")) {
      cid = true;
    } else if (type.equalsIgnoreCase("preview")) {
      preview = true;
    } else if (type.equalsIgnoreCase("event")) {
      event = true;
    }

    for (String t : StringUtils.delimitedListToStringArray(actionType, ",")) {
      program = true;

      if ("channel".equalsIgnoreCase(t)) {
        channel = true;
      } else if ("queue".equalsIgnoreCase(t)) {
        queue = true;
      } else if ("persona".equalsIgnoreCase(t)) {
        persona = true;
      } else if ("score".equalsIgnoreCase(t)) {
        score = true;
      } else if ("status".equalsIgnoreCase(t)) {
        status = true;
      } else if ("bureauImport".equalsIgnoreCase(t)) {
        bureauImport = true;
      }else if ("dataExport".equalsIgnoreCase(t)) {
        dataExport = true;
      }
    }

  } // end ctor RunType

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isBatch() {
    return batch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau import.
   *
   * @return  boolean
   */
  public boolean isBureauImport() {
    return bureauImport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isCID() {
    return cid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEvent() {
    return event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona.
   *
   * @return  boolean
   */
  public boolean isPersona() {
    return persona;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isPreview() {
    return preview;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isProgram() {
    return program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isQueue() {
    return queue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isScore() {
    return score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batch  DOCUMENT ME!
   */
  public void setBatch(boolean batch) {
    this.batch = batch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau import.
   *
   * @param  bureauImport  boolean
   */
  public void setBureauImport(boolean bureauImport) {
    this.bureauImport = bureauImport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channel  DOCUMENT ME!
   */
  public void setChannel(boolean channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cid  DOCUMENT ME!
   */
  public void setCID(boolean cid) {
    this.cid = cid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  event  DOCUMENT ME!
   */
  public void setEvent(boolean event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for persona.
   *
   * @param  persona  boolean
   */
  public void setPersona(boolean persona) {
    this.persona = persona;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preview  DOCUMENT ME!
   */
  public void setPreview(boolean preview) {
    this.preview = preview;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  program  DOCUMENT ME!
   */
  public void setProgram(boolean program) {
    this.program = program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  queue  DOCUMENT ME!
   */
  public void setQueue(boolean queue) {
    this.queue = queue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  score  DOCUMENT ME!
   */
  public void setScore(boolean score) {
    this.score = score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(boolean status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  public boolean isDataExport() {
    return dataExport;
  }

  public void setDataExport(boolean dataExport) {
    this.dataExport = dataExport;
  }

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "RunType{"
      + "batch=" + batch
      + ", channel=" + channel
      + ", cid=" + cid
      + ", event=" + event
      + ", persona=" + persona
      + ", preview=" + preview
      + ", program=" + program
      + ", queue=" + queue
      + ", score=" + score
      + ", bureauImport=" + bureauImport
      + ", dataExport=" + dataExport
      + '}';
  }
} // end class RunType
