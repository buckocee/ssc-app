package com.silvershield.ssc.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Arrays;

@Configuration
public class ClientConfiguration {

    @Bean
    @Primary
    ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
        return clientId -> clientRepository
                .findByClientId(clientId)
                .map(client -> {
                    BaseClientDetails details = new BaseClientDetails(client.getClientId(),
                            null, client.getScopes(), client.getAuthorizedGrantTypes(),
                            client.getAuthorities());
                    details.setAutoApproveScopes(Arrays.asList(client.getAutoApproveScopes().split(",")));
                    return details;
                })
                .orElseThrow(() -> new ClientRegistrationException(String.format("Client id %s not registered!", clientId)));
    }
}
