package com.pocspringboot.enumeration;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
public enum MinMaxStrategyType {
    TRADITIONAL_LOOP("traditional_loop"),
    STREAM("stream");

    private String name;

    public static MinMaxStrategyType fromName(String name) {
        return Stream.of(values())
                .filter(strategyType -> strategyType.name.equals(name))
                .findFirst()
                .orElse(null);
    }
    
}
