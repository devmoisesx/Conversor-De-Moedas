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
    }

    @Override
    public String toString() {
        return "Resultado da requisição: " + result + "\nMoeda base: " + baseCode + "\nTaxas de conversão:\n" + conversionRates;
    }
}
