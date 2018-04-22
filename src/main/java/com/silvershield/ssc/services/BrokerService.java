package com.silvershield.ssc.services;

import com.silvershield.ssc.models.Broker;
import com.silvershield.ssc.repos.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokerService {

    BrokerRepository brokerRepository;

    @Autowired
    public BrokerService(BrokerRepository brokerRepository){
        this.brokerRepository = brokerRepository;
    }

    public Broker saveBroker(Broker broker){
        Broker savedBroker = brokerRepository.save(broker);
        return savedBroker;
    }
}
