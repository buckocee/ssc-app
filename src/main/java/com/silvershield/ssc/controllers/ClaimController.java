package com.silvershield.ssc.controllers;

import com.silvershield.ssc.auth.AuthService;
import com.silvershield.ssc.auth.User;
import com.silvershield.ssc.models.Broker;
import com.silvershield.ssc.models.Carrier;
import com.silvershield.ssc.models.Claim;
import com.silvershield.ssc.repos.ClaimRepository;
import com.silvershield.ssc.services.BrokerService;
import com.silvershield.ssc.services.CarrierService;
import com.silvershield.ssc.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController("claims")
public class ClaimController {

    BrokerService brokerService;
    CarrierService carrierService;
    AuthService authService;
    ClaimService claimService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public ClaimController(BrokerService brokerService, CarrierService carrierService,
                           ClaimService claimService, AuthService authService){
        this.brokerService = brokerService;
        this.carrierService = carrierService;
        this.claimService = claimService;
//        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    @GetMapping
    public List<Claim> getAllClaims(){
        return null;
    }

    @GetMapping("/{id}")
    public Claim getClaimById(){
        return null;
    }

    @PostMapping("/save")
    public String saveClaim(@RequestBody Claim claim){
        return null;
    }

    @PostMapping("/submit")
    public String submitClaim(@RequestBody Claim claim){
        return null;
    }

    @GetMapping("/test")
    public Claim testClaim(){
        User user = new User();
        user.setEmail("user@email.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
//        user.setPassword(passwordEncoder.encode("password"));
        user.setPassword("password");
        user.setIsActive(true);
        user.setUserName("johndoe");
        user.setStatus(User.Status.ACTIVE);

        User savedUser = authService.saveUser(user);

        Broker broker = new Broker();
        broker.setBusinessName("Test");
        broker.setDotNumber("DOT343123456");
        broker.setMcNumber("MC324352462");
        broker.setStatus(Broker.Status.ACTIVE);

        Broker savedBroker = brokerService.saveBroker(broker);

        Carrier carrier = new Carrier();
        carrier.setBusinessName("Test Carrier");
        carrier.setDotNumber("DOT25342645634");
        carrier.setMcNumber("MC4352345434654");
        carrier.setStatus(Carrier.Status.ACTIVE);

        Carrier savedCarrier = carrierService.saveCarrier(carrier);

        Claim claim = new Claim();
        claim.setBrokerId(savedBroker.getId());
        claim.setCarrierId(savedCarrier.getId());
        claim.setCreatedById(savedUser.getId());
        claim.setDescription("Description");
        claim.setInvoiceNumber("INVC43354324143");
        claim.setStatus(Claim.Status.CREATED);
        claim.setSubmitDate(new Timestamp(System.currentTimeMillis()));

        Claim savedClaim = claimService.saveClaim(claim);

        return savedClaim;
    }
}
