package com.silvershield.ssc.repos;

import com.silvershield.ssc.model.CarrierStagingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrierStagingDTORepo extends JpaRepository<CarrierStagingDTO, Integer> {

    List<CarrierStagingDTO> findByCarrierOperationAndMailingState(String carrierOperation, String mailingState);
}
