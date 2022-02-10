package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.AccountExtensionChar;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:Hao.Kang@ozstrategy.com">Hao Kang</a>
 * @version  11/30/2015 22:55
 */
@Repository public interface AccountExtensionCharRepository extends JpaRepository<AccountExtensionChar, Long> { }
