package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Claim;
import com.silvershield.ssc.repos.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ClaimServiceImpl implements ClaimService {

    private ClaimRepository claimRepository;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository){
        this.claimRepository = claimRepository;
    }

    @Override
    public Claim saveClaim(Claim claim){
        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> getClaims() {
        return claimRepository.findAll();
    }
}
