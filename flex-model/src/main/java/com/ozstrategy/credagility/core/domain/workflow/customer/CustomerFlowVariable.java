package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.variable.BaseVariable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Created by xiangwei on 17/3/27.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  06/27/2017 16:44
 */
@DiscriminatorValue("CustomerFlow")
@Entity public class CustomerFlowVariable extends BaseVariable { }
