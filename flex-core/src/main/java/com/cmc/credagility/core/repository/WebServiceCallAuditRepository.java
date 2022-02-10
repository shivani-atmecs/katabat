package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.webactivity.WebServiceCallAudit;


/**
 * Created by rkodali on 3/12/2018.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Repository public interface WebServiceCallAuditRepository extends JpaRepository<WebServiceCallAudit, Long> { }
