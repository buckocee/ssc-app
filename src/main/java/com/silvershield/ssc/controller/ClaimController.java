package com.silvershield.ssc.controller;

import com.silvershield.ssc.auth.AuthService;
import com.silvershield.ssc.auth.User;
import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.Claim;
import com.silvershield.ssc.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/claims")
public class ClaimController {

    private final Logger _logger = LoggerFactory.getLogger(ClaimController.class);

    private final BrokerService brokerService;
    private final CarrierService carrierService;
    private final AuthService authService;
    private final ClaimService claimService;

    @Autowired
    public ClaimController(BrokerService brokerService, CarrierService carrierService,
                           ClaimService claimService, AuthService authService){
        this.brokerService = brokerService;
        this.carrierService = carrierService;
        this.claimService = claimService;
        this.authService = authService;
    }

    @GetMapping
    public List<Claim> getAllClaims(){
        return claimService.getClaims();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable("id") String id){
        return null;
    }

    @PostMapping("/save")
    public Claim saveClaim(@RequestBody Claim claim){
        _logger.info("Claim [{}]", claim);
        return claimService.saveClaim(claim);
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

        return claimService.saveClaim(claim);
    }
}
