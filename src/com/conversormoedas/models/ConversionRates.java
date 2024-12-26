package com.conversormoedas.models;

import java.util.Map;

public class ConversionRates {
    private String result, baseCode;
    private Map<String, Double> conversionRates;

    public ConversionRates(ConversionRatesApi taxasConversaoApi) {
        this.result = taxasConversaoApi.result();
        this.baseCode = taxasConversaoApi.base_code();
        this.conversionRates = taxasConversaoApi.conversion_rates();
        for (Map.Entry<String, Double> entry : conversionRates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    @Override
    public String toString() {
        return "\nMoeda base: " + baseCode;
    }
}
