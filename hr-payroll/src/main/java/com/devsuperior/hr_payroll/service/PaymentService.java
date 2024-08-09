package com.devsuperior.hr_payroll.service;

import com.devsuperior.hr_payroll.model.Payment;
import com.devsuperior.hr_payroll.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;


    public Payment getPayment(long workerId, int days){
        Map<String, String> uriVariabel = new HashMap<>();
        uriVariabel.put("id", ""+workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariabel);

        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }


}
