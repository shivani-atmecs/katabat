package com.cmc.credagility.core.domain.webhook;

/**
 * Created by jiazhang on 16/7/27.
 *
 * @author   <a href="mailto:jia.zhang@ozstrategy.com">Jia Zhang</a>
 * @version  07/27/2016 16:31
 */
public enum WebhookStatus {
    //~ Enum constants ---------------------------------------------------------------------------------------------------

    ACTIVE("Active"), INACTIVE("Inactive"), ACTIVEPENDING("ActivePending"), INACTIVEPENDING("InactivePending");

    //~ Instance fields --------------------------------------------------------------------------------------------------

    private String strValue;

    //~ Constructors -----------------------------------------------------------------------------------------------------

    private WebhookStatus() {
        this.strValue = this.name();
    }

    private WebhookStatus(String strValue) {
        this.strValue = strValue;
    }

    //~ Methods ----------------------------------------------------------------------------------------------------------

    /**
     * @see  Enum#toString()
     */
    @Override public String toString() {
        return strValue;
    }
}

