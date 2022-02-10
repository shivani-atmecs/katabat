package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.AutoDebitEnrollment;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Repository public interface AutoDebitEnrollmentRepository extends JpaRepository<AutoDebitEnrollment, Long> { } // end interface AutoDebitEnrollmentRepository
