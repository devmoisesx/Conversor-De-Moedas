package com.conversormoedas.modelos;

import java.util.Map;

public class ConversionRates {
    private String result;
    private String baseCode;
    private Map<String, Double> conversionRates;

    public ConversionRates(ConversionRatesApi taxasConversaoApi) {
        this.result = taxasConversaoApi.result();
        this.baseCode = taxasConversaoApi.base_code();
        this.conversionRates = taxasConversaoApi.conversion_rates();
        for (Map.Entry<String, Double> entry : conversionRates.entrySet()) {
            System.out.println("\n" + entry.getKey() + ": " + entry.getValue());
        }

    }

    @Override
    public String toString() {
        return "\nMoeda base: " + baseCode;
    }
}
