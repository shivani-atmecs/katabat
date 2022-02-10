package com.cmc.credagility.core.domain.variable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:33
 */
@DiscriminatorValue("System")
@Entity public class Variable extends BaseVariable { }
