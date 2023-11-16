package com.pocspringboot.controller;

import com.pocspringboot.model.request.training.TrainingNumberReverseRequest;
import com.pocspringboot.model.request.training.TrainingSumProductsRequest;
import com.pocspringboot.service.TrainingService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
public class TrainingController {

    private final TrainingService service;

    @PostMapping("/number-reverse")
    public Integer numberReverse(@Valid @RequestBody TrainingNumberReverseRequest request) {
        return service.reverseString(request);
    }

    @PostMapping("/sum-products")
    public Double sumProducts(@Valid @RequestBody TrainingSumProductsRequest request) {
        return service.sumProducts(request);
    }

}