package com.silvershield.ssc.repos;

import com.silvershield.ssc.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
