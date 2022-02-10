package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.cmc.credagility.core.domain.webhook.WebhookEventChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  08/17/2016 17:35
 */
@Repository
public interface WebhookEventChannelRepository extends JpaRepository<WebhookEventChannel, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  @Query("select we from WebhookEventChannel we where we.webhook.clientId=?1 and we.webhook.status='ACTIVE'and we.channel=?2")
  List<WebhookEventChannel> getClientWebhookEvents(String clientId, String channel);

}
