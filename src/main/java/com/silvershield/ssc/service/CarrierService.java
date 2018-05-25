package com.silvershield.ssc.service;

import com.silvershield.ssc.model.Carrier;

import java.util.List;

public interface CarrierService {
    Carrier saveCarrier(Carrier carrier);
    Carrier getCarrierById(Integer id);
    List<Carrier> getCarriers();
    void deleteCarrier(Integer id);
}
