package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Claim;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClaimService {
    Claim saveClaim(Claim claim);
    List<Claim> getClaims();

    List<Claim> getClaimsByUserId(Integer userId);

    Claim getClaimById(Integer id, Integer userId);

    String attachInvoice(Integer claimId, MultipartFile file) throws Exception;
}
