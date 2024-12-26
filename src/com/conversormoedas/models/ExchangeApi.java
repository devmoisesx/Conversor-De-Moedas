package com.conversormoedas.models;

public record ExchangeApi(String result, String base_code, String target_code, Double conversion_result) {
}
