package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.repos.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class BrokerServiceImpl implements BrokerService {

    private BrokerRepository brokerRepository;

    @Autowired
    public BrokerServiceImpl(BrokerRepository brokerRepository){
        this.brokerRepository = brokerRepository;
    }

    public Broker saveBroker(Broker broker){
        return brokerRepository.save(broker);
    }
}
