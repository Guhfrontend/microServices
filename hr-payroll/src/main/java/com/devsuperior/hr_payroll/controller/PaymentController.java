package com.devsuperior.hr_payroll.controller;

import com.devsuperior.hr_payroll.model.Payment;
import com.devsuperior.hr_payroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return ResponseEntity.ok(paymentService.getPayment(workerId,days));
    }


    public ResponseEntity<Payment> getPaymentAlternative(Long workerId,Integer days){
        return ResponseEntity.ok(new Payment("brann", 400.0, days));
    }
}

