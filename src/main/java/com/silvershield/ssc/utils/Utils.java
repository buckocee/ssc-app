package com.silvershield.ssc.utils;

import com.silvershield.ssc.model.CarrierStagingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static boolean addressMatch(CarrierStagingDTO dto){
        return dto.getPhyStreet().equalsIgnoreCase(dto.getMailingStreet())
        && dto.getPhyCity().equalsIgnoreCase(dto.getMailingCity())
        && dto.getPhyState().equalsIgnoreCase(dto.getMailingState());
    }
}
