package com.devsuperior.hr_payroll.service;

import com.devsuperior.hr_payroll.feignclients.WorkerFeignClient;
import com.devsuperior.hr_payroll.model.Payment;
import com.devsuperior.hr_payroll.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;


    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }


}
