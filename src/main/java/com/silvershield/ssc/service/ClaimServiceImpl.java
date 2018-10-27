package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Claim;
import com.silvershield.ssc.repos.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Validated
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository){
        this.claimRepository = claimRepository;
    }

    @Override
    public Claim getClaimById(Integer id, Integer userId) {
        return claimRepository.findById(id)
                .filter(claim -> claim.getUserId().compareTo(userId) == 0)
                .orElse(null);
    }

    @Override
    public Claim saveClaim(Claim claim){
        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> getClaims() {
        return claimRepository.findAll();
    }

    @Override
    public List<Claim> getClaimsByUserId(Integer userId) {
        return claimRepository.findClaimByUserId(userId);
    }

    @Override
    public String attachInvoice(Integer claimId, MultipartFile file) throws Exception {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new Exception(String.format("Claim with ID %d not found!", claimId)));
        claim.setInvoiceName(file.getOriginalFilename());
        claim.setInvoice(file.getBytes());
        claim = claimRepository.save(claim);
        return claim.getInvoiceName();
    }
}
