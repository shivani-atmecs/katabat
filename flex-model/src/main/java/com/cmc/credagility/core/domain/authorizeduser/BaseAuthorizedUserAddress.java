package com.cmc.credagility.core.domain.authorizeduser;

import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.contact.GeneralContactAddress;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 09:40
 */
@MappedSuperclass public abstract class BaseAuthorizedUserAddress extends BaseAuthorizedUser
  implements GeneralContactAddress { }
