package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Claim;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ClaimService {
    Claim saveClaim(Claim claim);
    List<Claim> getClaims();

    List<Claim> getClaimsByUserId(Integer userId);

  Claim getClaimById(Integer id, Integer userId, boolean role_admin);

    String attachInvoice(Integer claimId, MultipartFile file) throws Exception;
}
