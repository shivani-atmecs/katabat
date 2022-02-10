package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.cmc.credagility.core.domain.webactivity.Browser;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  01/15/2015 15:32
 */
@Repository("browserRepository")
public interface BrowserRepository extends CrudRepository<Browser, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findFirstByActivityChannelAndUserAgentIsNullOrderByCreateDateDesc.
   *
   * @param   activityChannel  WebActivityChannel
   *
   * @return  Browser
   */
  Browser findFirstByActivityChannelAndUserAgentIsNullOrderByCreateDateDesc(WebActivityChannel activityChannel);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findBySessionIdAndHttpServerAndActivityChannel.
   *
   * @param   userAgent        httpSessionId String
   * @param   activityChannel  String
   *
   * @return  List
   */
  Browser findFirstByUserAgentAndActivityChannelOrderByCreateDateDesc(String userAgent,
    WebActivityChannel activityChannel);
} // end interface BrowserRepository
