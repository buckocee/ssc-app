package com.silvershield.ssc.controller;

import com.silvershield.ssc.auth.AuthService;
import com.silvershield.ssc.auth.User;
import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.Claim;
import com.silvershield.ssc.service.BrokerService;
import com.silvershield.ssc.service.CarrierService;
import com.silvershield.ssc.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/claims")
public class ClaimController {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

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
    public List<Claim> getAllClaims() throws Exception {
        User user = authService.getAuthenticatedUser();
        if (authService.isAdmin(user))
            return claimService.getClaims();
        Integer userId = user.getId();
        return claimService.getClaimsByUserId(userId);
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable("id") Integer id) {
        Claim claim = null;
        try {
          User user = authService.getAuthenticatedUser();
          claim = claimService.getClaimById(id, user.getId(), authService.isAdmin(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claim;
    }

    @PostMapping("/save")
    public Claim saveClaim(@RequestBody Claim claim) throws Exception {
        Integer userId = authService.getAuthenticatedUser().getId();
        claim.setUserId(userId);
        _logger.info("Claim [{}]", claim);
        return claimService.saveClaim(claim);
    }

    @PostMapping("/invoice/{claimId}")
    public ResponseEntity attachInvoice(@RequestBody MultipartFile file, @PathVariable Integer claimId) {
        try {
            claimService.attachInvoice(claimId, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/submit")
    public String submitClaim(@RequestBody Claim claim){
        return claimService.submitClaim(claim);
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
        user.setActive(true);
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
        claim.setUserId(savedUser.getId());
        claim.setDescription("Description");
        claim.setInvoiceNumber("INVC43354324143");
        claim.setStatus(Claim.Status.CREATED);
        claim.setSubmitDate(ZonedDateTime.now(ZoneId.of("UTC")));

        return claimService.saveClaim(claim);
    }
}
