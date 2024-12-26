package com.conversormoedas.modelos;

public class Exchange {
    private String baseCode;
    private String targetCode;
    private Double conversionResult;
    private String result;

    public Exchange(ExchangeApi respostaApi) {
        this.baseCode = respostaApi.base_code();
        this.targetCode = respostaApi.target_code();
        this.conversionResult = respostaApi.conversion_result();
        this.result = respostaApi.result();
    }

    @Override
    public String toString() {
        return "Resultado da conversão: " + result + "\n\nMoeda base: " + baseCode + "\nMoeda alvo: " + targetCode + "\n\nValor da conversão: " + conversionResult;
    }
}
