package com.silvershield.ssc.controller;

import com.silvershield.ssc.model.Broker;
import com.silvershield.ssc.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "brokers")
public class BrokerController {

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

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<Broker> getBrokers(){
        return brokerService.getBrokers();
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public Broker saveBroker(@RequestBody Broker broker){
        return brokerService.saveBroker(broker);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBroker(@PathVariable("id") Integer id){
        brokerService.deleteBroker(id);
    }
}
