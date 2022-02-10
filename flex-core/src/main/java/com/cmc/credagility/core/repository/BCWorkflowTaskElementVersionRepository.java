package com.cmc.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskElementVersion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tangwei on 17/2/8.
 */
public interface BCWorkflowTaskElementVersionRepository extends JpaRepository<BCWorkflowTaskElementVersion, Long> { }