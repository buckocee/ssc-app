package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Address;
import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.CarrierStagingDTO;
import com.silvershield.ssc.repos.CarrierRepository;
import com.silvershield.ssc.repos.CarrierStagingDTORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class CarrierServiceImpl implements CarrierService {

    private CarrierRepository carrierRepository;
    private CarrierStagingDTORepo carrierStagingDTORepo;

    @Autowired
    public CarrierServiceImpl(CarrierRepository carrierRepository, CarrierStagingDTORepo carrierStagingDTORepo){
        this.carrierRepository = carrierRepository;
        this.carrierStagingDTORepo = carrierStagingDTORepo;
    }

    @Override
    public Carrier saveCarrier(Carrier carrier){
        return carrierRepository.save(carrier);
    }

    @Override
    public Carrier getCarrierById(Integer id) {
        return carrierRepository.getOne(id);
    }

    @Override
    public List<Carrier> getCarriers() {
        return carrierRepository.findAll();
    }

    @Override
    public void deleteCarrier(Integer id) {
        carrierRepository.deleteById(id);
    }

    @Override
    public List<CarrierStagingDTO> getCarrierDTOs(){
        List<CarrierStagingDTO> carrierStagingDTOS = carrierStagingDTORepo.findByCarrierOperationAndMailingState("C", "PA");
        carrierRepository.deleteAll();
        List<Carrier> carriers = carrierStagingDTOS.stream()
                .map(dto -> new Carrier(null,null, dto.getDotNumber().toString(), Carrier.Status.ACTIVE,
                        StringUtils.hasText(dto.getDoingBusinessAsName()) ? dto.getDoingBusinessAsName() : dto.getLegalName(), null, null, null,
                        new Address(null,dto.getPhyStreet(),null, dto.getPhyCity(),dto.getPhyState(), dto.getPhyCountry(), dto.getPhyZip()),
                        new Address(null, dto.getMailingStreet(),null,dto.getMailingCity(), dto.getMailingState(), dto.getMailingCountry(),dto.getMailingZip())))
                .collect(Collectors.toList());
        carrierRepository.saveAll(carriers);
        return carrierStagingDTOS;
    }
}
