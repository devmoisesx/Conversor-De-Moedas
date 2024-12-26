package com.conversormoedas.models;

public class Exchange {
    private String baseCode, targetCode, result;
    private Double conversionResult;

    public Exchange(ExchangeApi respostaApi) {
        this.baseCode = respostaApi.base_code();
        this.targetCode = respostaApi.target_code();
        this.result = respostaApi.result();
        this.conversionResult = respostaApi.conversion_result();
    }

    @Override
    public String toString() {
        return "\nResultado da conversão: " + result + "\n\nMoeda base: " + baseCode + "\nMoeda alvo: " + targetCode + "\n\nValor da conversão: " + conversionResult;
    }
}
