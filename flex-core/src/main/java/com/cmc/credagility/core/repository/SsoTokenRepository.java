package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.sso.SsoToken;
import com.ozstrategy.credagility.core.domain.QueueAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by lihao1 on 1/25/16.
 */
public interface SsoTokenRepository extends JpaRepository<SsoToken, Long> {
    SsoToken findByTokenId(String tokenId);
}
