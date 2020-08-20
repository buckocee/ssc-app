package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.BrokerStagingDTO;
import com.silvershield.ssc.repos.BrokerRepository;
import com.silvershield.ssc.repos.BrokerStagingDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class BrokerServiceImpl implements BrokerService {

    private final BrokerRepository brokerRepository;
    private final BrokerStagingDTORepository brokerStagingDTORepository;

    @Autowired
    public BrokerServiceImpl(BrokerRepository brokerRepository, BrokerStagingDTORepository brokerStagingDTORepository) {
        this.brokerRepository = brokerRepository;
        this.brokerStagingDTORepository = brokerStagingDTORepository;
    }

    @Override
    public Broker saveBroker(Broker broker) {
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

    @Override
    public List<BrokerStagingDTO> getBrokerDTOs() {
        List<BrokerStagingDTO> brokerStagingDTOs = brokerStagingDTORepository.findAll();
        brokerStagingDTOs.stream().map(brokerStagingDTO -> new Broker(null, brokerStagingDTO.getMcNumber(),
                brokerStagingDTO.getDotNumber(), brokerStagingDTO.getBusinessName(), Broker.Status.ACTIVE,
                null, null, brokerStagingDTO.getState(), brokerStagingDTO.getCity(), null))
                .forEach(brokerRepository::save);
        return brokerStagingDTOs;
    }
}
