package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.repos.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class BrokerServiceImpl implements BrokerService {

    private BrokerRepository brokerRepository;

    @Autowired
    public BrokerServiceImpl(BrokerRepository brokerRepository){
        this.brokerRepository = brokerRepository;
    }

    @Override
    public Broker saveBroker(Broker broker){
        return brokerRepository.save(broker);
    }

    @Override
    public Broker getBrokerById(Integer id){
        return brokerRepository.getOne(id);
    }

    @Override
    public List<Broker> getBrokers() {
        return brokerRepository.findAll();
    }

    @Override
    public void deleteBroker(Integer id) {
        brokerRepository.deleteById(id);
    }

    @Override
    public Broker updateBroker(Broker broker) {
        return brokerRepository.saveAndFlush(broker);
    }

    @Override
    public List<Broker> getBrokerByStatus(Broker.Status status) {
        return brokerRepository.findBrokersByStatus(status).orElse(null);
    }
}
