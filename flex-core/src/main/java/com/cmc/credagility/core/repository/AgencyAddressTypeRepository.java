package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.address.AddressType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:21
 */
public interface AgencyAddressTypeRepository extends JpaRepository<AddressType, Long> { }
