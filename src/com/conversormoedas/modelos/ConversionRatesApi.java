package com.conversormoedas.modelos;

import java.util.Map;

public record ConversionRatesApi(String result, String base_code, Map<String, Double> conversion_rates) {

}