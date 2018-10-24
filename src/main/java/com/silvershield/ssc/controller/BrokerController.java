package com.silvershield.ssc.controller;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.model.BrokerStagingDTO;
import com.silvershield.ssc.service.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brokers")
public class BrokerController {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private BrokerService brokerService;

    @Autowired
    public BrokerController(BrokerService brokerService){

        this.brokerService = brokerService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Broker getBrokerById(@PathVariable("id") Integer id){
        return brokerService.getBrokerById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Broker> getBrokers(){
        return brokerService.getBrokers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Broker saveBroker(@RequestBody Broker broker){
        return brokerService.saveBroker(broker);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBroker(@PathVariable("id") Integer id){
        brokerService.deleteBroker(id);
    }

    @GetMapping(value = "/dto")
    public List<BrokerStagingDTO> getBrokerDTOs() {
        return brokerService.getBrokerDTOs();
    }
}
