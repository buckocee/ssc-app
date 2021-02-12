package com.silvershield.ssc.auth;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Column(name = "scope")
    private final String scopes = StringUtils
            .arrayToCommaDelimitedString(new String[]{"openid"});
    @Column(name = "authorized_grant_types")
    private final String authorizedGrantTypes = StringUtils
            .arrayToCommaDelimitedString(new String[]{"authorization_code",
                    "refresh_token", "password"});
    @Column(name = "authorities")
    private final String authorities = StringUtils
            .arrayToCommaDelimitedString(new String[]{"ROLE_USER", "ROLE_ADMIN"});
    @Column(name = "autoapprove")
    private final String autoApproveScopes = StringUtils
            .arrayToCommaDelimitedString(new String[]{".*"});
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_secret")
    private String secret;

    public Client(String clientId, String clientSecret) {
        this.clientId = clientId;
        secret = clientSecret;
    }

    public Client() {
    }
}
