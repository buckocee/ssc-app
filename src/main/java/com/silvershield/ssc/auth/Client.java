package com.silvershield.ssc.auth;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String secret;

    @Column(name = "scope")
    private String scopes = StringUtils
            .arrayToCommaDelimitedString(new String[]{"openid"});

    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes = StringUtils
            .arrayToCommaDelimitedString(new String[]{"authorization_code",
                    "refresh_token", "password"});

    @Column(name = "authorities")
    private String authorities = StringUtils
            .arrayToCommaDelimitedString(new String[]{"ROLE_USER", "ROLE_ADMIN"});

    @Column(name = "autoapprove")
    private String autoApproveScopes = StringUtils
            .arrayToCommaDelimitedString(new String[]{".*"});

    public Client(String clientId, String clientSecret) {
        this.clientId = clientId;
        secret = clientSecret;
    }

    public Client() {
    }
}
