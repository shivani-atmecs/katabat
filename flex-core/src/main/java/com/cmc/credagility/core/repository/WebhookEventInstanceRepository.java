package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.webhook.WebhookEventInstance;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:shuan.wu@ozstrategy.com">Shuang Wu</a>
 * @version  08/18/2016 15:08
 */
@Repository public interface WebhookEventInstanceRepository extends JpaRepository<WebhookEventInstance, Long> { }
