package com.conversormoedas.api;

import com.conversormoedas.models.ConversionRates;
import com.conversormoedas.models.ConversionRatesApi;
import com.conversormoedas.models.Exchange;
import com.conversormoedas.models.ExchangeApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestApi {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String apiKey = dotenv.get("KEY");

    public static Exchange converterMoeda(String moedaASerConvertida, String moedaConverter, Double valorParaConverter) {
        String dados = moedaASerConvertida + "/" + moedaConverter + "/" + valorParaConverter;

        var json = response("pair", dados);
        Gson gson = new GsonBuilder().create();
        ExchangeApi respostaApi = gson.fromJson(json, ExchangeApi.class);
        Exchange convecaoDeMoeda = new Exchange(respostaApi);
        return convecaoDeMoeda;
    }

    public static ConversionRates taxaCambio(String moedaBase) {
        var json = response("latest", moedaBase);
        Gson gson = new GsonBuilder().create();
        ConversionRatesApi conversionRatesApi = gson.fromJson(json, ConversionRatesApi.class);
        ConversionRates taxasCambio = new ConversionRates(conversionRatesApi);
        return taxasCambio;
    }

    private static String response(String metodo, String dados) {
        try {
            String urlString = "https://v6.exchangerate-api.com/v6/" + apiKey + "/" + metodo + "/" + dados;
            URL url = new URL(urlString);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error em:");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return null;
    }
}
