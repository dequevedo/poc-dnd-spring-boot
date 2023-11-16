package com.pocspringboot.controller;

import com.pocspringboot.model.request.training.TrainingNumberReverseRequest;
import com.pocspringboot.model.request.training.ProductListRequest;
import com.pocspringboot.model.response.training.SumEvenOddResponse;
import com.pocspringboot.service.TrainingService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
public class TrainingController {

    private final TrainingService service;

    @PostMapping("/number-reverse")
    public Integer numberReverse(@Valid @RequestBody TrainingNumberReverseRequest request) {
        return service.reverseString(request);
    }

    @PostMapping("/products-sum")
    public Double calculateProductsPriceSum(@Valid @RequestBody ProductListRequest request) {
        return service.calculateProductsPriceSum(request);
    }

    @PostMapping("/products-average")
    public Double calculateProductPriceAverage(@Valid @RequestBody ProductListRequest request) {
        return service.calculateProductPriceAverage(request);
    }

    @PostMapping("/to-lower-case")
    public List<String> convertUppercaseToLowercase(@Valid @RequestBody ProductListRequest request) {
        return service.convertUppercaseToLowercase(request);
    }

    @PostMapping("/sum-even-odd")
    public SumEvenOddResponse calculateSumEvenOdd(@Valid @RequestBody ProductListRequest request) {
        return service.calculateSumEvenOdd(request);
    }

}