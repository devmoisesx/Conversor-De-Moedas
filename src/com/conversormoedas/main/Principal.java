package com.conversormoedas.main;

import com.conversormoedas.api.RequestApi;
import com.sun.net.httpserver.Request;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Digite o valor que você quer converter: ");
//        String valor = scanner.nextLine();
//        System.out.println(valor);
        int i = 0;
        int j = 0;
        String moedaASerConvertida = "";
        double valorParaConverter = 0;
        String moedaDeConversao = "";
        try {
            while (i != 3) {
                System.out.println("--- Escolha entre as opçoes abaixo ---");
                System.out.println("1. Converter moeda");
                System.out.println("2. Exibir valor da cotação das moedas");
                System.out.println("3. Fechar");

                i = scanner.nextByte();

                switch (i) {
                    case 1 -> {
                        System.out.println("\n--- Converter moeda ---");
                        System.out.println("Qual moeda deseja converter?");
                        System.out.println("1. USD - Dólar");
                        System.out.println("2. EUR - Euro");
                        System.out.println("3. BRL - Real Brasileiro");
                        System.out.println("4. CNY - Yuan Chines");
                        System.out.println("5. JPY - Yen Japones");
                        System.out.println("6. Digitar moeda");
                        switch (scanner.nextInt()) {
                            case 1 -> {
                                moedaASerConvertida = "USD";
                                break;
                            }
                            case 2 -> {
                                moedaASerConvertida = "EUR";
                                break;
                            }
                            case 3 -> {
                                moedaASerConvertida = "BRL";
                                break;
                            }
                            case 4 -> {
                                moedaASerConvertida = "CNY";
                                break;
                            }
                            case 5 -> {
                                moedaASerConvertida = "JPY";
                                break;
                            }
                            case 6 -> {
                                moedaASerConvertida = scanner.next();
                                break;
                            }
                        }
                        System.out.println("\n------------------------------------\n");
                        System.out.println("Moeda a ser Convertida: " + moedaASerConvertida);
                        System.out.println("Qual valor deseja converter?");
                        valorParaConverter = scanner.nextDouble();

                        System.out.println("\n------------------------------------\n");
                        System.out.println("Para qual moeda deseja converter?");
                        System.out.println("1. USD");
                        System.out.println("2. EUR");
                        System.out.println("3. BRL");
                        System.out.println("4. CNY - Yuan Chines");
                        System.out.println("5. JPY - Yen Japones");
                        System.out.println("6. Digitar moeda");
                        switch (scanner.nextInt()) {
                            case 1 -> {
                                moedaDeConversao = "USD";
                                break;
                            }
                            case 2 -> {
                                moedaDeConversao = "EUR";
                                break;
                            }
                            case 3 -> {
                                moedaDeConversao = "BRL";
                                break;
                            }
                            case 4 -> {
                                moedaDeConversao = "CNY";
                                break;
                            }
                            case 5 -> {
                                moedaDeConversao = "JPY";
                                break;
                            }
                            case 6 -> {
                                moedaDeConversao = scanner.next();
                                break;
                            }
                        }
                        System.out.println(RequestApi.converterMoeda(moedaASerConvertida, moedaDeConversao, valorParaConverter));
                        break;
                    }
                    case 2 -> {
                        System.out.println("\n------------------------------------\n");
                        System.out.println("--- Exibir valor da cotação das moedas ---");
                        System.out.println("Com base em qual moeda?");
                        System.out.println("1. USD");
                        System.out.println("2. EUR");
                        System.out.println("3. BRL");
                        System.out.println("4. CNY - Yuan Chines");
                        System.out.println("5. JPY - Yen Japones");
                        System.out.println("6. Digitar moeda");

                        switch (scanner.nextInt()) {
                            case 1:
                                System.out.println(RequestApi.taxaCambio("USD"));
                                break;
                            case 2:
                                System.out.println(RequestApi.taxaCambio("EUR"));
                                break;
                            case 3:
                                System.out.println(RequestApi.taxaCambio("BRL"));
                                break;
                            case 4:
                                System.out.println(RequestApi.taxaCambio("CNY"));
                                break;
                            case 5:
                                System.out.println(RequestApi.taxaCambio("JPY"));
                                break;
                            case 6:
                                System.out.println(RequestApi.taxaCambio(scanner.next()));
                                break;
                        }
                        break;
                    }
                }
                System.out.println("\n------------------------------------\n");
                System.out.println("Deseja continuar a execução do programa? ---");
                System.out.println("1. Sim, voltar para a tela inicial");
                System.out.println("2. Não, fechar programa");

                switch (scanner.nextInt()) {
                    case 1:
                        i = 0;
                        break;
                    case 2:
                        i = 3;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("Fim do programa!");

    }
}