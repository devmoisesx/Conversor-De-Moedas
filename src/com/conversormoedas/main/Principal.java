package com.conversormoedas.main;

import com.conversormoedas.api.RequestApi;
import java.util.Scanner;
import static com.sun.tools.javac.util.StringUtils.toUpperCase;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ativo = true;
        String moedaASerConvertida;
        String moedaDeConversao;
        String moedaBaseDeTaxas;
        double valorASerConvertido;

        try {
            while (ativo) {
                System.out.println("=== Conversor de Moedas ===");
                System.out.println("1. Converter moeda");
                System.out.println("2. Exibir valor da cotação das moedas");
                System.out.println("3. Fechar");

                switch (scanner.nextByte()) {
                    case 1:
                        System.out.println("\n--- Converter moeda ---");
                        System.out.println("Qual moeda deseja converter?\n");
                        moedaASerConvertida = escolherOpcaoMoeda();

                        System.out.println("\nPara qual moeda deseja converter?\n");
                        moedaDeConversao = escolherOpcaoMoeda();

                        System.out.println("\nQual valor deseja converter?");
                        valorASerConvertido = scanner.nextDouble();

                        System.out.println(RequestApi.converterMoeda(moedaASerConvertida, moedaDeConversao, valorASerConvertido));
                        ativo = continuarPrograma();
                        break;
                    case 2:
                        System.out.println("\n--- Exibir valor da cotação das moedas ---");
                        System.out.println("Com base em qual moeda?");
                        moedaBaseDeTaxas = escolherOpcaoMoeda();
                        System.out.println(RequestApi.taxaCambio(moedaBaseDeTaxas));
                        ativo = continuarPrograma();
                        break;
                    case 3:
                        ativo = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        ativo = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fim do programa!");

    }

    private static boolean continuarPrograma() {
        boolean ativo = false;
        boolean loop = true;

        while(loop) {
            System.out.println("\n------------------------------------\n");
            System.out.println("Deseja continuar a execução do programa? ---");
            System.out.println("1. Sim, voltar para a tela inicial");
            System.out.println("2. Não, fechar o programa");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    ativo = true;
                    loop = false;
                    break;
                case 2:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        return ativo;
    }

    private static String escolherOpcaoMoeda() {
        var escolha = "";
        var loop = true;

        while (loop) {
            System.out.println("1. USD - Dólar");
            System.out.println("2. EUR - Euro");
            System.out.println("3. BRL - Real Brasileiro");
            System.out.println("4. CNY - Yuan Chines");
            System.out.println("5. JPY - Yen Japones");
            System.out.println("6. Digitar moeda");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    escolha = "USD";
                    loop = false;
                    break;
                case 2:
                    escolha = "EUR";
                    loop = false;
                    break;
                case 3:
                    escolha = "BRL";
                    loop = false;
                    break;
                case 4:
                    escolha = "CNY";
                    loop = false;
                    break;
                case 5:
                    escolha = "JPY";
                    loop = false;
                    break;
                case 6:
                    System.out.println("\nPara qual moeda deseja converter? Escreva a sigla da moeda com apenas 3 letras");
                    escolha = toUpperCase(scanner.nextLine());
                    loop = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
                    break;
            }
        }
        return escolha;
    }

}