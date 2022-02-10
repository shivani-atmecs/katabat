package com.cmc.credagility.util;

/**
 * Created by Yang Wang on 2/28/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  02/28/2015 17:19 PM
 */
public class FileUtils {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for content type.
   *
   * @param   extension  String
   *
   * @return  String
   */
  public static String getContentType(String extension) {
    return getContentType(extension, "text/html");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for content type.
   *
   * @param   extension    String
   * @param   defaultType  String
   *
   * @return  String
   */
  public static String getContentType(String extension, String defaultType) {
    String ext = extension.toLowerCase();

    return MediaTypeUtils.getContentType(ext);

//    if (ext.equals(".xls") || ext.equals(".xlsx")) {
//      return "application/vnd.ms-excel";
//    } else if (ext.equals(".cvs") || ext.equals(".xlsx")) {
//      return "application/ms-excel";
//    } else if (ext.equals(".doc") || ext.equals(".docx")) {
//      return "application/msword";
//    } else if (ext.equals(".txt")) {
//      return "text/plain";
//    } else if (ext.equals(".pdf")) {
//      return "application/pdf";
//    } else if (ext.equals(".jpg") || ext.equals(".jpeg")) {
//      return "image/jpeg";
//    } else if (ext.equals(".ppt")) {
//      return "application/vnd.ms-powerpoint";
//    } else if (ext.equals(".gif")) {
//      return "image/gif";
//    }
//
//    return defaultType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateContentType.
   *
   * @param   extension  String
   *
   * @return  String
   */
  public static String populateContentType(String extension) {

    return MediaTypeUtils.getContentType(extension);
    
//    if ("pdf".equalsIgnoreCase(extension) || ".pdf".equalsIgnoreCase(extension)) {
//      return "application/pdf";
//    } else if ("xls".equalsIgnoreCase(extension) || ".xls".equalsIgnoreCase(extension)) {
//      return "application/vnd.ms-excel";
//    } else if ("xlsx".equalsIgnoreCase(extension) || ".xlsx".equalsIgnoreCase(extension)) {
//      return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    } else if ("doc".equalsIgnoreCase(extension) || ".doc".equalsIgnoreCase(extension)) {
//      return "application/msword";
//    } else if ("docx".equalsIgnoreCase(extension) || ".docx".equalsIgnoreCase(extension)) {
//      return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
//    } else if (".ppt".equalsIgnoreCase(extension)) {
//      return "application/vnd.ms-powerpoint";
//    } else if (".txt".equalsIgnoreCase(extension)) {
//      return "text/plain";
//    } else if (".jpg".equalsIgnoreCase(extension) || ".jpeg".equalsIgnoreCase(extension)) {
//      return "image/jpeg";
//    } else if (".gif".equalsIgnoreCase(extension)) {
//      return "image/gif";
//    }
//
//    return "";
  }
} // end class FileUtils
