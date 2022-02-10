package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.channel.IvrOutboundAudit;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:47
 */
public interface IvrOutboundAuditRepository extends JpaRepository<IvrOutboundAudit, Long> { }
