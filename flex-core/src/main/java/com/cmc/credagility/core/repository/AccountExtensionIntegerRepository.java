package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.AccountExtensionInteger;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:Hao.Kang@ozstrategy.com">Hao Kang</a>
 * @version  11/30/2015 23:00
 */
@Repository public interface AccountExtensionIntegerRepository extends JpaRepository<AccountExtensionInteger, Long> { }
