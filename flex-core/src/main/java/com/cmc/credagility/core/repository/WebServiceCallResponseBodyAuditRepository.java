package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.webactivity.WebServiceCallResponseBodyAudit;


/**
 * Created by rkodali on 3/12/2018.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Repository public interface WebServiceCallResponseBodyAuditRepository
  extends JpaRepository<WebServiceCallResponseBodyAudit, Long> { }
