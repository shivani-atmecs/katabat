package com.ozstrategy.credagility.core.domain.workflow;

import java.util.HashMap;
import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:46
 */
public class PreviewDocFileItem {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private byte[]              content;
  private Long                docVerTemplateId;
  private String              extension;
  private String              originalName;
  private Map<String, String> variables = new HashMap<String, String>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PreviewDocFileItem object.
   */
  public PreviewDocFileItem() { }

  /**
   * Creates a new PreviewDocFileItem object.
   *
   * @param  content    DOCUMENT ME!
   * @param  variables  DOCUMENT ME!
   */
  public PreviewDocFileItem(byte[] content, Map<String, String> variables) {
    this.content = content;

    if ((variables != null) && !variables.isEmpty()) {
      this.variables = variables;
    }
  }

  /**
   * Creates a new PreviewDocFileItem object.
   *
   * @param  documentVersionTemplateId  DOCUMENT ME!
   * @param  content                    DOCUMENT ME!
   * @param  variables                  DOCUMENT ME!
   */
  public PreviewDocFileItem(Long documentVersionTemplateId, byte[] content, Map<String, String> variables) {
    this(content, variables);
    this.docVerTemplateId = documentVersionTemplateId;
  }

  /**
   * Creates a new PreviewDocFileItem object.
   *
   * @param  documentVersionTemplateId  DOCUMENT ME!
   * @param  content                    DOCUMENT ME!
   * @param  variables                  DOCUMENT ME!
   * @param  extension                  DOCUMENT ME!
   * @param  originalName               DOCUMENT ME!
   */
  public PreviewDocFileItem(Long documentVersionTemplateId, byte[] content, Map<String, String> variables,
    String extension, String originalName) {
    this(documentVersionTemplateId, content, variables);
    this.extension    = extension;
    this.originalName = (originalName != null) ? originalName.replaceAll(" ", "_") : null;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for content.
   *
   * @return  byte[]
   */
  public byte[] getContent() {
    return content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc ver template id.
   *
   * @return  Long
   */
  public Long getDocVerTemplateId() {
    return docVerTemplateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original name.
   *
   * @return  String
   */
  public String getOriginalName() {
    return originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variables.
   *
   * @return  Map
   */
  public Map<String, String> getVariables() {
    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for content.
   *
   * @param  content  byte[]
   */
  public void setContent(byte[] content) {
    this.content = content;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for doc ver template id.
   *
   * @param  docVerTemplateId  Long
   */
  public void setDocVerTemplateId(Long docVerTemplateId) {
    this.docVerTemplateId = docVerTemplateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original name.
   *
   * @param  originalName  String
   */
  public void setOriginalName(String originalName) {
    this.originalName = originalName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variables.
   *
   * @param  variables  Map
   */
  public void setVariables(Map<String, String> variables) {
    this.variables = variables;
  }
} // end class PreviewDocFileItem
