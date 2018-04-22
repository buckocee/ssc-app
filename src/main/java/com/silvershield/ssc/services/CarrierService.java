package com.silvershield.ssc.services;

import com.silvershield.ssc.models.Broker;
import com.silvershield.ssc.models.Carrier;
import com.silvershield.ssc.repos.BrokerRepository;
import com.silvershield.ssc.repos.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrierService {

    CarrierRepository carrierRepository;

    @Autowired
    public CarrierService(CarrierRepository carrierRepository){
        this.carrierRepository = carrierRepository;
    }

    public Carrier saveCarrier(Carrier carrier){
        Carrier savedCarrier= carrierRepository.save(carrier);
        return savedCarrier;
    }
}
