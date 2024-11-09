package org.noctisdev.payments.infraestructure.controllers;

import org.noctisdev.payments.application.IPaymentService;
import org.noctisdev.payments.application.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donations")
public class GetPaymentsController {

    @Autowired
    private IPaymentService service;

    @GetMapping
    public ResponseEntity<BaseResponse> getPayments(@RequestParam String user) {
        return service.getPayment(user).apply();
    }

}
