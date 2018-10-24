package com.silvershield.ssc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SscApplication {

//    @Autowired
//    private ClientRepository clientRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SscApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Stream.of("html5,password", "android,secret").map(x -> x.split(","))
//                .forEach(x -> clientRepository.save(new Client(x[0], passwordEncoder.encode(x[1]))));
//    }
}
