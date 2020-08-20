package com.silvershield.ssc.repos;

import com.silvershield.ssc.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    List<Claim> findClaimByUserId(Integer userId);
}
