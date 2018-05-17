package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Claim;

import java.util.List;

public interface ClaimService {
    Claim saveClaim(Claim claim);
    List<Claim> getClaims();
}
