package com.pocspringboot.service;

import com.pocspringboot.model.request.training.Product;
import com.pocspringboot.model.request.training.TrainingNumberReverseRequest;
import com.pocspringboot.model.request.training.ProductListRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingService {

    public Integer reverseString(TrainingNumberReverseRequest request) {
        int signal = (int) Math.signum(request.getNumber());
        String reversedString = new StringBuilder(String.valueOf(Math.abs(request.getNumber()))).reverse().toString();
        return Integer.parseInt(reversedString) * signal;
    }

    public Double sumProducts(ProductListRequest request) {
        return request.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (accumulator, combiner) -> {
                    log.info(String.format("Accumulator: %s Combiner: %s", accumulator, combiner));
                    return accumulator + combiner;
                });
    }

}
