package com.ozstrategy.credagility.core.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  12/25/2015 17:11
 */
public class MediaTypeUtils {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final Map<String, String> extensionMediaTypeMap = new HashMap<String, String>();

  /** DOCUMENT ME! */
  public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";

  static {
    extensionMediaTypeMap.put(".icon", "image/vnd.microsoft.icon");
    extensionMediaTypeMap.put(".png", "image/png");
    extensionMediaTypeMap.put(".gif", "image/gif");
    extensionMediaTypeMap.put(".jpeg", "image/jpeg");
    extensionMediaTypeMap.put(".xml", "application/xml");
    extensionMediaTypeMap.put(".json", "application/json");
    extensionMediaTypeMap.put(".html", "text/html");
    extensionMediaTypeMap.put(".pdf", "application/pdf");
    extensionMediaTypeMap.put(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    extensionMediaTypeMap.put(".xls", "application/vnd.ms-excel");
    extensionMediaTypeMap.put(".cvs", "text/csv");
    extensionMediaTypeMap.put(".doc", "application/msword");
    extensionMediaTypeMap.put(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    extensionMediaTypeMap.put(".ppt", "application/vnd.ms-powerpoint");
    extensionMediaTypeMap.put(".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
    extensionMediaTypeMap.put(".zip", "application/zip");
    extensionMediaTypeMap.put(".tar", "application/x-tar");
    extensionMediaTypeMap.put(".gzip", "application/x-gzip");
    extensionMediaTypeMap.put(".js", "application/javascript");
    extensionMediaTypeMap.put(".css", "text/css");
    extensionMediaTypeMap.put(".rtf", "application/rtf");
    extensionMediaTypeMap.put(".txt", "text/plain");
    extensionMediaTypeMap.put(".msg", "application/vnd.ms-outlook");
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   extension  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getContentType(String extension) {
    if (StringUtils.hasText(extension)) {
      if (!extension.startsWith(".")) {
        extension = "." + extension;
      }

      extension = extension.toLowerCase();

      String mediaType = extensionMediaTypeMap.get(extension);

      if (mediaType != null) {
        return mediaType.toString();
      }
    }

    return APPLICATION_OCTET_STREAM.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @param   contentType  String
   *
   * @return  String
   */
  public static String getExtension(String contentType) {
    if (contentType != null) {
      contentType = contentType.toLowerCase();

      for (String extension : extensionMediaTypeMap.keySet()) {
        String fileContentType = extensionMediaTypeMap.get(extension);

        if (fileContentType.equalsIgnoreCase(contentType)) {
          return extension;
        }
      }
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  args  DOCUMENT ME!
   */
  public static void main(String[] args) {
    System.out.println(getContentType("pdf"));
    System.out.println(getContentType("xml"));
    System.out.println(getContentType("rft"));
    System.out.println(getContentType("docx"));
    System.out.println(getExtension("application/pdf"));
    System.out.println(getExtension("text/css"));
    System.out.println(getExtension("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
  }
} // end class MediaTypeUtils
