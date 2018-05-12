package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.repos.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CarrierServiceImpl implements CarrierService {

    private CarrierRepository carrierRepository;

    @Autowired
    public CarrierServiceImpl(CarrierRepository carrierRepository){
        this.carrierRepository = carrierRepository;
    }

    @Override
    public Carrier saveCarrier(Carrier carrier){
        return carrierRepository.save(carrier);
    }
}
