package com.silvershield.ssc.controller;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.BrokerStagingDTO;
import com.silvershield.ssc.service.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brokers")
public class BrokerController {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private final BrokerService brokerService;

    @Autowired
    public BrokerController(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @Cacheable(value = "brokers", key = "#id")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Broker getBrokerById(@PathVariable("id") Integer id) {
        _logger.info("Retrieving broker with id [{}]", id);
        return brokerService.getBrokerById(id);
    }

    @Cacheable(value = "brokers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Broker> getBrokers() {
        return brokerService.getBrokers();
    }

    @CachePut(value = "brokers")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Broker saveBroker(@RequestBody Broker broker) {
        return brokerService.saveBroker(broker);
    }

    @CacheEvict(value = "brokers", key = "#id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBroker(@PathVariable("id") Integer id) {
        brokerService.deleteBroker(id);
    }

    @GetMapping(value = "/dto")
    public List<BrokerStagingDTO> getBrokerDTOs() {
        return brokerService.getBrokerDTOs();
    }
}
