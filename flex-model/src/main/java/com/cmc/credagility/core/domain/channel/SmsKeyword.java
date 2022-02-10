package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;

@Entity
@Table(
        name = "SmsKeyword",
        uniqueConstraints = { @UniqueConstraint(columnNames = "keyword") }
)
public class SmsKeyword extends BaseEntity implements Serializable {

    /**
     * Document PK
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(
            unique = true,
            nullable = false
    )
    protected Long smsKeywordId;

    /**
     * DOCUMENT ME!
     */
    @Column(name = "keyword", length = 100)
    protected String keyword;

    /**
     * DOCUMENT ME!
     */
    @Column(name = "type", length = 10)
    protected String type;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String Keyword) {
        this.keyword = keyword;
    }

    public Long getSmsKeywordId() {
        return smsKeywordId;
    }

    public void setSmsKeywordId(Long smsKeywordId) {
        this.smsKeywordId = smsKeywordId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
