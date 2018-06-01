package com.silvershield.ssc.controller;

import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.CarrierStagingDTO;
import com.silvershield.ssc.service.CarrierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carriers")
public class CarrierController {

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService){
        this.carrierService = carrierService;
    }

    @GetMapping(value = "/{carrierId}")
    public Carrier getCarrierById(@PathVariable("carrierId") Integer carrierId){
        return carrierService.getCarrierById(carrierId);
    }

    @PostMapping
    public Carrier saveCarrier(@RequestBody Carrier carrier){
        return carrierService.saveCarrier(carrier);
    }

    @GetMapping
    public List<Carrier> getCarriers(){
        return carrierService.getCarriers();
    }

    @DeleteMapping(value = "/{carrierId}")
    public void deleteCarrier(@PathVariable("carrierId") Integer carrierId){
        carrierService.deleteCarrier(carrierId);
    }

    @GetMapping(value = "/dtos")
    public List<CarrierStagingDTO> getDTOs(){
        return carrierService.getCarrierDTOs();
    }
}
