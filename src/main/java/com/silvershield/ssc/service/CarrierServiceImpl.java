package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Address;
import com.silvershield.ssc.model.Carrier;
import com.silvershield.ssc.model.CarrierStagingDTO;
import com.silvershield.ssc.repos.CarrierRepository;
import com.silvershield.ssc.repos.CarrierStagingDTORepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class CarrierServiceImpl implements CarrierService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CarrierRepository carrierRepository;
    private final CarrierStagingDTORepo carrierStagingDTORepo;
    private final RestTemplate restTemplate;
    @Value("{app.nhtsa.webkey}")
    private String webKey;

    @Autowired
    public CarrierServiceImpl(CarrierRepository carrierRepository, CarrierStagingDTORepo carrierStagingDTORepo,
                              RestTemplate restTemplate) {
        this.carrierRepository = carrierRepository;
        this.carrierStagingDTORepo = carrierStagingDTORepo;
        this.restTemplate = restTemplate;
    }

    @Override
    public Carrier saveCarrier(Carrier carrier) {
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
    public List<CarrierStagingDTO> getCarrierDTOs() {
        List<CarrierStagingDTO> carrierStagingDTOS = carrierStagingDTORepo.findAll(); // carrierStagingDTORepo.findAll(PageRequest.of(0, 500, Sort.by("dotNumber")));

//        do {
        List<Carrier> carriers = new ArrayList<>();

        for (CarrierStagingDTO dto : carrierStagingDTOS) {

            Address physicalAddress = new Address(null, dto.getPhyStreet(), null, dto.getPhyCity(), dto.getPhyState(),
                    dto.getPhyCountry(), dto.getPhyZip());

            Address mailingAddress = new Address(null, dto.getMailingStreet(), null, dto.getMailingCity(),
                    dto.getMailingState(), dto.getMailingCountry(), dto.getMailingZip());
            carriers.add(new Carrier(null, null, dto.getDotNumber().toString(), Carrier.Status.ACTIVE,
                    StringUtils.hasText(dto.getDoingBusinessAsName()) ? dto.getDoingBusinessAsName()
                            : dto.getLegalName(), dto.getTelephone(), dto.getFax(),
                    dto.getEmailAddress(),
                    null,
                    physicalAddress,
                    mailingAddress));

        }
        List<Carrier> savedCarriers = carrierRepository.saveAll(carriers);
//            logger.error("Processed [{}] records in slice number [{}].", savedCarriers.size(), carrierStagingDTOS.getNumber());
//
//            carrierStagingDTOS = carrierStagingDTOS.hasNext() ? carrierStagingDTORepo.findAll(carrierStagingDTOS.nextPageable()) : carrierStagingDTOS;
//        } while (carrierStagingDTOS.hasNext());

        return carrierStagingDTOS; //.toList();
    }

    @Override
    public Carrier validateCarrier(Carrier carrier) {
        return null;
    }
}
