package com.silvershield.ssc;

import com.silvershield.ssc.auth.Client;
import com.silvershield.ssc.auth.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@EnableCaching
@EnableOAuth2Client
@SpringBootApplication
public class SscApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SscApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (!clientRepository.existsById(1L))
            Stream.of("html5,password", "android,secret").map(x -> x.split(","))
                    .forEach(x -> clientRepository.save(new Client(x[0], passwordEncoder.encode(x[1]))));
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
