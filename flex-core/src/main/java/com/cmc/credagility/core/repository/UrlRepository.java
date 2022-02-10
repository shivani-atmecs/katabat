package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.cmc.credagility.core.domain.webactivity.Url;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/31/2014 17:23
 */
@Repository("urlRepository")
public interface UrlRepository extends JpaRepository<Url, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findFirstByBaseUrlAndPageNameAndActivityChannelOrderByCreateDateDesc.
   *
   * @param   baseUrl          String
   * @param   pageName         String
   * @param   activityChannel  WebActivityChannel
   *
   * @return  Url
   */
  Url findFirstByBaseUrlAndPageNameAndActivityChannelOrderByCreateDateDesc(String baseUrl, String pageName,
    WebActivityChannel activityChannel);
}
