package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowScheduleAudit;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:12
 */
public interface EnterpriseWorkflowScheduleAuditRepository
  extends JpaRepository<EnterpriseWorkflowScheduleAudit, Long> { }
