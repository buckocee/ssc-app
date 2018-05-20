package com.silvershield.ssc.controller;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class OverviewController {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    // TODO all claims
    @GetMapping("/review-claims")
    public List<Claim> getAllClaims(){
        return null;
    }

    // TODO claims by status
    @GetMapping("/review-claims/{status}")
    public List<Claim> getClaimsByStatus(@PathVariable("status") String status){
        return null;
    }

    // TODO claims by user
    @GetMapping("/review-claims/{userId}")
    public List<Claim> getClaimsByUser(@PathVariable("userId") String userId){
        return null;
    }

    // TODO all brokers
    @GetMapping("/review-brokers")
    public List<Broker> getAllBrokers(){
        return null;
    }

    // TODO brokers by status
    @GetMapping("review-brokers/{status}")
    public List<Broker> getBrokersByStatus(@PathVariable("status") String status){
        return null;
    }

    // TODO all carriers
    @GetMapping("review-carriers")
    public List<Carrier> getAllCarriers(){
        return null;
    }

    // TODO all carriers by status
    @GetMapping("review-carriers/{status}")
    public List<Broker> getCarriersByStatus(@PathVariable("status") String status){
        return null;
    }

    // TODO all carriers by number of claims
    @GetMapping("review-carriers/{count}")
    public List<Broker> getCarriersByCount(@PathVariable("count") String count){
        return null;
    }
}
