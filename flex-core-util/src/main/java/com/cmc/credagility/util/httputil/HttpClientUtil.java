package com.cmc.credagility.util.httputil;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;


/**
 * This class is used to provide http client util.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/27/2014 10:27
 */
public class HttpClientUtil {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   url             DOCUMENT ME!
   * @param   inputXml        DOCUMENT ME!
   * @param   timeoutMinutes  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  public static String postACIXml(String url, String inputXml,
    int timeoutMinutes) throws Exception {
    String response = null;

    // Prepare HTTP post
    PostMethod post = new PostMethod(url);

    // Request content will be retrieved directly
    try {
      StringRequestEntity entity = new StringRequestEntity(inputXml,
          "application/x-www-form-urlencoded", "UTF-8");
      post.setRequestEntity(entity);

      // Get HTTP client
      HttpClient httpClient = new HttpClient();

      HttpConnectionManagerParams ps = httpClient.getHttpConnectionManager().getParams();
      ps.setConnectionTimeout(timeoutMinutes * 60000);


      if (httpClient.executeMethod(post) == 200) {
        response = post.getResponseBodyAsString();
      }
    } catch (Exception e) {
      // Get exception, service is not avalible
      throw e;
    } finally {
      // Release current connection to the connection pool once you are done
      post.releaseConnection();
    } // end try-catch-finally

    return response;
  } // end method postACIXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   url             DOCUMENT ME!
   * @param   inputXml        DOCUMENT ME!
   * @param   timeoutMinutes  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  public static String postConvergeXml(String url, String inputXml,
    int timeoutMinutes) throws Exception {
    String response = null;

    // Prepare HTTP post
    PostMethod post = new PostMethod(url);


    // Request content will be retrieved directly
    try {
      // Per default, the request content needs to be buffered
      // in order to determine its length.
      // Request body buffering can be avoided when
      // content length is explicitly specified
      // post.setRequestEntity(new StringRequestEntity(inputXml, "text/xml",
      // "ISO-8859-1"));

      // The encoding method is very important. If you post it in URLENcoded
      // format like FireFox


      StringRequestEntity entity = new StringRequestEntity(inputXml,
          "application/x-www-form-urlencoded", "UTF-8");
      post.setRequestEntity(entity);

      // Get HTTP client
      HttpClient httpClient = new HttpClient();

      HttpConnectionManagerParams ps = httpClient.getHttpConnectionManager().getParams();
      ps.setConnectionTimeout(timeoutMinutes * 60000);


      if (httpClient.executeMethod(post) == 200) {
        response = post.getResponseBodyAsString();
      }
    } catch (Exception e) {
      // Get exception, service is not avalible
      throw e;
    } finally {
      // Release current connection to the connection pool once you are done
      post.releaseConnection();
    } // end try-catch-finally

    return response;
  } // end method postConvergeXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * postITSXml.
   *
   * @param   url       String
   * @param   inputXml  String
   *
   * @return  String
   *
   * @throws  Exception  exception
   */
  public static String postITSXml(String url, String inputXml) throws Exception {
    return postITSXml(url, inputXml, 3);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * postITSXml.
   *
   * @param   url             String
   * @param   inputXml        String
   * @param   timeoutMinutes  int
   *
   * @return  String
   *
   * @throws  Exception  exception
   */
  public static String postITSXml(String url, String inputXml,
    int timeoutMinutes) throws Exception {
    String response = null;

    // Prepare HTTP post
    PostMethod post = new PostMethod(url);

    // Request content will be retrieved directly
    try {
      // Per default, the request content needs to be buffered
      // in order to determine its length.
      // Request body buffering can be avoided when
      // content length is explicitly specified
      // post.setRequestEntity(new StringRequestEntity(inputXml, "text/xml",
      // "ISO-8859-1"));

      // The encoding method is very important. If you post it in URLENcoded
      // format like FireFox
      StringRequestEntity entity = new StringRequestEntity(inputXml,
          "text/xml", "UTF-8");
      post.setRequestEntity(entity);

      // Get HTTP client
      HttpClient                  httpClient = new HttpClient();
      HttpConnectionManagerParams ps         = httpClient.getHttpConnectionManager().getParams();
      ps.setConnectionTimeout(timeoutMinutes * 60000);

      if (httpClient.executeMethod(post) == 200) {
        response = post.getResponseBodyAsString();
      }
    } catch (Exception e) {
      // Get exception, service is not avalible
      throw e;
    } finally {
      // Release current connection to the connection pool once you are done
      post.releaseConnection();
    } // end try-catch-finally

    return response;
  } // end method postITSXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * postXml.
   *
   * @param   url             String
   * @param   inputXml        String
   * @param   timeoutMinutes  int
   *
   * @return  String
   *
   * @throws  Exception  exception
   */
  public static String postXml(String url, String inputXml, int timeoutMinutes) throws Exception {
    return postXml(url, "paymentData", inputXml, timeoutMinutes);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * postXml.
   *
   * @param   url             String
   * @param   name            String
   * @param   inputXml        String
   * @param   timeoutMinutes  int
   *
   * @return  String
   *
   * @throws  Exception  exception
   */
  public static String postXml(String url, String name, String inputXml,
    int timeoutMinutes) throws Exception {
    String response = null;

    // Prepare HTTP post
    PostMethod post = new PostMethod(url);

    // Request content will be retrieved directly
    try {
      // Per default, the request content needs to be buffered
      // in order to determine its length.
      // Request body buffering can be avoided when
      // content length is explicitly specified
      // post.setRequestEntity(new StringRequestEntity(inputXml, "text/xml",
      // "ISO-8859-1"));
      NameValuePair[] data = { new NameValuePair(name, inputXml), };
      post.setRequestBody(data);

      // Get HTTP client
      HttpClient                  httpClient = new HttpClient();
      HttpConnectionManagerParams ps         = httpClient.getHttpConnectionManager().getParams();
      ps.setConnectionTimeout(timeoutMinutes * 60000);

      if (httpClient.executeMethod(post) == 200) {
        response = post.getResponseBodyAsString();
      }
    } catch (Exception e) {
      // Get exception, service is not avalible
      throw e;
    } finally {
      // Release current connection to the connection pool once you are done
      post.releaseConnection();
    } // end try-catch-finally

    return response;
  } // end method postXml
} // end class HttpClientUtil
