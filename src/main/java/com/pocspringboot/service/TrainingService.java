package com.pocspringboot.service;

import com.pocspringboot.model.request.training.Product;
import com.pocspringboot.model.request.training.TrainingNumberReverseRequest;
import com.pocspringboot.model.request.training.ProductListRequest;
import com.pocspringboot.model.response.training.SumEvenOddResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingService {

    public Integer reverseString(TrainingNumberReverseRequest request) {
        int signal = (int) Math.signum(request.getNumber());
        String reversedString = new StringBuilder(String.valueOf(Math.abs(request.getNumber()))).reverse().toString();
        return Integer.parseInt(reversedString) * signal;
    }

    public Double calculateProductsPriceSum(ProductListRequest request) {
        return request.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (accumulator, combiner) -> {
                    log.info(String.format("Accumulator: %s Combiner: %s", accumulator, combiner));
                    return accumulator + combiner;
                });
    }

    public Double calculateProductPriceAverage(ProductListRequest request) {
        return request.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<String> convertUppercaseToLowercase(ProductListRequest request) {
        return request.getProducts().stream()
                .map(Product::getName)
                .map(String::toLowerCase)
                .toList();
    }

    public SumEvenOddResponse calculateSumEvenOdd(ProductListRequest request) {
        Long evenSum = request.getProducts().stream()
                .map(Product::getId)
                .reduce(0L, (accumulator, id) -> {
                    boolean isEven = id%2==0;
                    return isEven ? accumulator + 1 : accumulator;
                });

        return SumEvenOddResponse.builder()
                .even(evenSum)
                .odd(request.getProducts().size() - evenSum)
                .build();
    }

}
