package com.silvershield.ssc.controller;


import com.silvershield.ssc.auth.AuthService;
import com.silvershield.ssc.service.BrokerService;
import com.silvershield.ssc.service.CarrierService;
import com.silvershield.ssc.service.ClaimService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ClaimController.class)
public class ClaimControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BrokerService brokerService;

    @MockBean
    private CarrierService carrierService;

    @MockBean
    private ClaimService claimService;

    @MockBean
    private AuthService authService;

    @Test
    public void getAllClaims() {
    }

    @Test
    public void getClaimById() {
    }

    @Test
    public void saveClaim() {
    }

    @Test
    public void submitClaim() {
    }

    @Test
    public void testClaim() {
    }
}