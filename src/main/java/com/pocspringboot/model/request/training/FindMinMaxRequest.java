package com.pocspringboot.model.request.training;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindMinMaxRequest {

    private MinMaxStrategyType strategy;

    private List<Product> products;

}