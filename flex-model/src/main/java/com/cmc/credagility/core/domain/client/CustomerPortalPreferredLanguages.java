package com.cmc.credagility.core.domain.client;


import java.io.Serializable;

import javax.persistence.*;

import com.cmc.credagility.core.domain.CurrencySymbolPosition;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Industry information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:37
 */
@Entity
@Table(name = "CustomerPortalPreferredLanguages")
public class CustomerPortalPreferredLanguages extends BaseEntity implements Serializable {
    //~ Static fields/initializers ---------------------------------------------------------------------------------------

    private static final long serialVersionUID = 6173035943480398028L;

    //~ Instance fields --------------------------------------------------------------------------------------------------

    /** comments. */
    @Column(
            name   = "languageName",
            length = 100
    )
    protected String languageName;

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id protected Long         languageId;

    /** industry industryName. */
    @Column(
            name     = "languageCode",
            nullable = false,
            length   = 50
    )
    protected String languageCode;

    /** TODO: DOCUMENT ME! */
    @Column(
            name     = "currencySymbolPosition",
            nullable = true,
            length   = 30
    )
    @Enumerated(EnumType.STRING)
    protected CurrencySymbolPosition currencySymbolPosition;

    @Column(
            name   = "currencySymbol",
            length = 4
    )
    protected String currencySymbol;

    //~ Methods ----------------------------------------------------------------------------------------------------------

    /**
     * equals.
     *
     * @param   obj  Object
     *
     * @return  boolean
     */
    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Industry other = (Industry) obj;

        if (languageName == null) {
            if (other.getIndustryName() != null) {
                return false;
            }
        } else if (!languageName.equals(other.getIndustryName())) {
            return false;
        }

        return true;
    } // end method equals

    //~ ------------------------------------------------------------------------------------------------------------------



    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * hashCode.
     *
     * @return  int
     */
    @Override public int hashCode() {
        final int prime  = 31;
        int       result = 1;
        result = (prime * result)
                + ((languageName == null) ? 0 : languageName.hashCode());

        return result;
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Long getLanguageId() {
        return languageId;
    }

      public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public CurrencySymbolPosition getCurrencySymbolPosition() {
        return currencySymbolPosition;
    }

    public void setCurrencySymbolPosition(CurrencySymbolPosition currencySymbolPosition) {
        this.currencySymbolPosition = currencySymbolPosition;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * Constructs a <code>String</code> with all attributes in industryName = value format.
     *
     * @return  a <code>String</code> representation of this object.
     */
    @Override public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("Customer Preferred Language ( ").append("languageName = ").append(this.languageName).append(TAB).append("languageCode = ")
                .append(this.languageCode).append(TAB).append(" )");

        return retValue.toString();
    }
} // end class Industry

