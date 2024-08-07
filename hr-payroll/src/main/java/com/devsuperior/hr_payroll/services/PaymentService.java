package com.devsuperior.hr_payroll.services;

import com.devsuperior.hr_payroll.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("Gustavo", 200.0, days);
    }
}
