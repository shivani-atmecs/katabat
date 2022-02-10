package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.event.Event;
import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.cmc.credagility.core.domain.webhook.WebhookEventChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 14:30
 */
public interface EventRepository extends JpaRepository<Event, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByBusinessContext_Id.
   *
   * @param   businessContextId  Long
   *
   * @return  List
   */
  @Query("SELECT e FROM Event e WHERE e.businessContext.id = ?1  AND  (e.eventType = null or e.eventType != 'webhook' )")
  List<Event> findByBusinessContext_Id(Long businessContextId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByEventNameAndPortfolio_PortfolioId.
   *
   * @param   eventName  String
   * @param   aLong      Long
   *
   * @return  Event
   */
  @Query("SELECT e FROM Event e WHERE e.eventName = ?1 AND e.portfolio.portfolioId = ?2 AND (e.eventType = null or e.eventType != 'webhook' )")
  Event findByEventNameAndPortfolio_PortfolioId(String eventName, Long aLong);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByPortfolio_PortfolioId.
   *
   * @param   portfolioId  Long
   *
   * @return  List
   */
  @Query("SELECT e FROM Event e WHERE  e.portfolio.portfolioId = ?1 AND (e.eventType = null or e.eventType != 'webhook' )")
  List<Event> findByPortfolio_PortfolioId(Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web hook event by name.
   *
   * @param   eventName  String
   *
   * @return  Event
   */
  @Query(value = "select e from Event e where e.eventType = 'webhook' and e.eventName = ?1")
  Event getWebhookEventByName(String eventName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web hook event by client and channel.
   *
   * @param   clientId  String
   * @param   channel  WebActivityChannel
   *
   * @return  List<WebhookEventChannel>
   */
  @Query("select we from WebhookEventChannel we where we.webhook.clientId=?1 and we.channel=?2 and we.event.eventType='webhook'")
  List<WebhookEventChannel> getClientWebhookEvnets(String clientId,WebActivityChannel channel);

} // end interface EventRepository
