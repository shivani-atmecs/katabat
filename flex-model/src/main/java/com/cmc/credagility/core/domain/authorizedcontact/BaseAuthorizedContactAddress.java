package com.cmc.credagility.core.domain.authorizedcontact;

import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.contact.GeneralContactAddress;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:56
 */
@MappedSuperclass public abstract class BaseAuthorizedContactAddress extends BaseAuthorizedContact
  implements GeneralContactAddress { }
