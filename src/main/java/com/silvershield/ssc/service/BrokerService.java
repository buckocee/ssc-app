package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.BrokerStagingDTO;

import java.util.List;

public interface BrokerService {

    Broker saveBroker(Broker broker);
    Broker getBrokerById(Integer id);
    List<Broker> getBrokers();
    void deleteBroker(Integer id);
    Broker updateBroker(Broker broker);
    List<Broker> getBrokerByStatus(Broker.Status status);

    List<BrokerStagingDTO> getBrokerDTOs();
}
