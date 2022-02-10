package com.cmc.credagility.core.domain.sso;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by lihao1 on 1/15/16.
 */
@Entity
@Table(
        name    = "SsoToken",
        indexes = {
                @javax.persistence.Index(
                        name = "idx_SsoToken_tokenId",
                        columnList = "tokenId"
                )
        }
)
public class SsoToken extends BaseEntity{
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;
    @Column
    private String tokenId;
    @Column(columnDefinition = "TEXT")
    private String token;
    @Column(length = 64)
    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
