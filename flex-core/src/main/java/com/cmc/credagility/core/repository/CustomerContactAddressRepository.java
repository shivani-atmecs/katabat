package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.customer.CustomerContactAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: sujy
 * Date: 15/3/4
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerContactAddressRepository extends JpaRepository<CustomerContactAddress, Long> {
}
