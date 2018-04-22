package com.silvershield.ssc.controllers;

import com.silvershield.ssc.models.Broker;
import com.silvershield.ssc.models.Carrier;
import com.silvershield.ssc.models.Claim;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class OverviewController {

    // TODO all claims
    @GetMapping("/review-claims")
    public List<Claim> getAllClaims(){
        return null;
    }

    // TODO claims by status
    @GetMapping("/review-claims/{status}")
    public List<Claim> getClaimsByStatus(){
        return null;
    }

    // TODO claims by user
    @GetMapping("/review-claims/{userId}")
    public List<Claim> getClaimsByUser(){
        return null;
    }

    // TODO all brokers
    @GetMapping("/review-brokers")
    public List<Broker> getAllBrokers(){
        return null;
    }

    // TODO brokers by status
    @GetMapping("review-brokers/{status}")
    public List<Broker> getBrokersByStatus(){
        return null;
    }

    // TODO all carriers
    @GetMapping("review-carriers")
    public List<Carrier> getAllCarriers(){
        return null;
    }

    // TODO all carriers by status
    @GetMapping("review-carriers/{status}")
    public List<Broker> getCarriersByStatus(){
        return null;
    }

    // TODO all carriers by number of claims
    @GetMapping("review-carriers/{count}")
    public List<Broker> getCarriersByCount(){
        return null;
    }
}
