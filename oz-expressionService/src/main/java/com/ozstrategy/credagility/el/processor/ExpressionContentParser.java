package com.ozstrategy.credagility.el.processor;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 * @User:    wangy
 * @Date:    12-8-27
 * @Time:    AM10:03 To change this template use File | Settings | File Templates.
 */
public class ExpressionContentParser {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final transient Logger logger = LoggerFactory.getLogger(ExpressionContentParser.class);

  /** DOCUMENT ME! */
  public static final Pattern $_BRACES_EXPRESSION_PATTERN = Pattern.compile("\\$\\{[^\\$\\{|\\}]*\\}");

  /** DOCUMENT ME! */
  public static final Pattern $_BRACES_BRACKETS_EXPRESSION_PATTERN = Pattern.compile("\\$\\{\\[[^\\$\\{|\\}]*\\]\\}");

  /** DOCUMENT ME! */
  public static final Pattern DOLLAR_PATTERN = Pattern.compile(Pattern.quote("\\$"));

  /** DOCUMENT ME! */
  public static final Pattern LEFT_BRACES_PATTERN = Pattern.compile(Pattern.quote("\\{"));

  /** DOCUMENT ME! */
  public static final Pattern RIGHT_BRACES_PATTERN = Pattern.compile(Pattern.quote("\\}"));

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   content  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Set<String> listExpressions(String content) {
    Set<String> expressions = new HashSet<String>();

    if (StringUtils.hasText(content)) {
      if (logger.isDebugEnabled()) {
        logger.debug("Start fetching dollar expression:" + content);
      }

      Matcher matcher = $_BRACES_BRACKETS_EXPRESSION_PATTERN.matcher(content);

      while (matcher.find()) {
        DollarExpression expr = new DollarBracesBracketsExpression(content.substring(matcher.start(), matcher.end()));
        expressions.add(expr.getExpression().trim());
      }

      matcher = $_BRACES_EXPRESSION_PATTERN.matcher(content);

      while (matcher.find()) {
        DollarExpression expr = new DollarExpression(content.substring(matcher.start(), matcher.end()));
        expressions.add(expr.getExpression().trim());
      }

      if (logger.isDebugEnabled()) {
        logger.debug("End fetching dollar expression:" + content);
      }
    }

    return expressions;
  } // end method listExpressions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   content  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Set<String> listUnescapedHtmlExpressions(String content) {
    Set<String> expressions = new HashSet<String>();

    if (StringUtils.hasText(content)) {
      if (logger.isDebugEnabled()) {
        logger.debug("Start fetching dollar expression:" + content);
      }

      Matcher matcher = $_BRACES_BRACKETS_EXPRESSION_PATTERN.matcher(content);

      while (matcher.find()) {
        DollarExpression expr = new DollarBracesBracketsExpression(content.substring(matcher.start(), matcher.end()));
        expressions.add(StringEscapeUtils.unescapeHtml4(expr.getExpression().trim()));
      }

      matcher = $_BRACES_EXPRESSION_PATTERN.matcher(content);

      while (matcher.find()) {
        DollarExpression expr = new DollarExpression(content.substring(matcher.start(), matcher.end()));
        expressions.add(StringEscapeUtils.unescapeHtml4(expr.getExpression().trim()));
      }

      if (logger.isDebugEnabled()) {
        logger.debug("End fetching dollar expression:" + content);
      }
    }

    return expressions;
  } // end method listUnescapedHtmlExpressions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   content       DOCUMENT ME!
   * @param   unescapeHtml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Set<String> populateExpression(String content, boolean unescapeHtml) {
    if (unescapeHtml) {
      return listUnescapedHtmlExpressions(content);
    }

    return listExpressions(content);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   content  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String process(String content) {
    return process(content, new BasicExpressionProcessor());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   content    DOCUMENT ME!
   * @param   processor  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String process(String content, ExpressionProcessor processor) {
    if (StringUtils.hasText(content)) {
      StringBuffer sb = new StringBuffer();

      if (logger.isDebugEnabled()) {
        logger.debug("Start processing dollar expression:" + content);
      }

      boolean flag = false;

      Matcher matcher = $_BRACES_BRACKETS_EXPRESSION_PATTERN.matcher(content);

      while (matcher.find()) {
        flag = true;

        DollarExpression expr        = new DollarBracesBracketsExpression(content.substring(matcher.start(),
              matcher.end()));
        String           replacement = processor.process(expr);
        replacement = replacement.replace("$", "\\$");
        matcher.appendReplacement(sb, replacement);
      }

      if (flag) {
        matcher.appendTail(sb);
        content = sb.toString();
        sb      = new StringBuffer();
      }

      matcher = $_BRACES_EXPRESSION_PATTERN.matcher(content);

      while (matcher.find()) {
        DollarExpression expr        = new DollarExpression(content.substring(matcher.start(),
              matcher.end()));
        String           replacement = processor.process(expr);
        replacement = replacement.replace("$", "\\$");
        matcher.appendReplacement(sb, replacement);
      }

      matcher.appendTail(sb);

      if (logger.isDebugEnabled()) {
        logger.debug("End processing dollar expression:" + sb);

        logger.debug("Start processing escape character[\\$,\\{,\\} --> $, {, }]");
      }

      matcher = DOLLAR_PATTERN.matcher(sb);

      while (matcher.find()) {
        sb.replace(matcher.start(), matcher.end(), "$");

        // logger.debug(matcher.start()+"-"+ matcher.end()+":"+sb.substring(matcher.start(),matcher.end()-1));
      }

      matcher = LEFT_BRACES_PATTERN.matcher(sb);

      while (matcher.find()) {
        sb.replace(matcher.start(), matcher.end(), "{");

        // logger.debug(matcher.start()+"-"+ matcher.end()+":"+sb.substring(matcher.start(),matcher.end()-1));
      }

      matcher = RIGHT_BRACES_PATTERN.matcher(sb);

      while (matcher.find()) {
        sb.replace(matcher.start(), matcher.end(), "}");

        // logger.debug(matcher.start()+"-"+ matcher.end()+":"+sb.substring(matcher.start(),matcher.end()-1));
      }

      if (logger.isDebugEnabled()) {
        logger.debug("End processing escape character[\\$,\\{,\\} --> $, {, }]:" + sb);
      }

      return sb.toString();
    } // end if

    return content;
  } // end method process
} // end class ExpressionContentParser
