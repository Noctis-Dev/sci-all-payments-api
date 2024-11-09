package org.noctisdev.payments.infraestructure.controllers;

import org.noctisdev.payments.application.IPaymentProfileService;
import org.noctisdev.payments.application.dto.BaseResponse;
import org.noctisdev.payments.application.dto.request.PaymentProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class CreatePaymentProfileController {

    @Autowired
    private IPaymentProfileService service;

    @PostMapping
    public ResponseEntity<BaseResponse> createPaymentProfile(@RequestBody PaymentProfileRequest request) {
        return service.createPaymentProfile(request).apply();
    }

}
