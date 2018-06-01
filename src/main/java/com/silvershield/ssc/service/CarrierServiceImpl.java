package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.CarrierStagingDTO;
import com.silvershield.ssc.repos.CarrierRepository;
import com.silvershield.ssc.repos.CarrierStagingDTORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CarrierServiceImpl implements CarrierService {

    private CarrierRepository carrierRepository;
    private CarrierStagingDTORepo carrierStagingDTORepo;

    @Autowired
    public CarrierServiceImpl(CarrierRepository carrierRepository, CarrierStagingDTORepo carrierStagingDTORepo){
        this.carrierRepository = carrierRepository;
        this.carrierStagingDTORepo = carrierStagingDTORepo;
    }

    @Override
    public Carrier saveCarrier(Carrier carrier){
        return carrierRepository.save(carrier);
    }

    @Override
    public Carrier getCarrierById(Integer id) {
        return carrierRepository.getOne(id);
    }

    @Override
    public List<Carrier> getCarriers() {
        return carrierRepository.findAll();
    }

    @Override
    public void deleteCarrier(Integer id) {
        carrierRepository.deleteById(id);
    }

    @Override
    public List<CarrierStagingDTO> getCarrierDTOs(){
        return carrierStagingDTORepo.findByCarrierOperationAndMailingState("C", "PA");
    }
}
