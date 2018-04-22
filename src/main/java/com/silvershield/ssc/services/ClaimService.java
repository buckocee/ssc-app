package com.silvershield.ssc.services;

import com.silvershield.ssc.models.Claim;
import com.silvershield.ssc.repos.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {

    ClaimRepository claimRepository;

    @Autowired
    public ClaimService(ClaimRepository claimRepository){
        this.claimRepository = claimRepository;
    }

    public Claim saveClaim(Claim claim){
        Claim savedClaim = claimRepository.save(claim);
        return savedClaim;
    }
}
