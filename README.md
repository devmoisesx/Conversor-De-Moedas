# Conversor de Moedas com API

Este projeto é um **Conversor de Moedas** desenvolvido em **Java** que utiliza uma API para realizar a conversão de moedas e exibir a taxa de câmbio atual com base em uma moeda escolhida. É uma aplicação simples e eficiente para quem precisa de conversões de moedas atualizadas em tempo real.

## Funcionalidades

- Conversão entre diferentes moedas.
- Exibição da taxa de câmbio atual para as moedas selecionadas.
- Atualizações em tempo real usando uma API de taxas de câmbio.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **API de Taxas de Câmbio**: Serviço externo para obter as taxas de câmbio atualizadas.
- **Bibliotecas Java**:
  - `URI`.
  - `HttpClient`.
  - `HttpRequest`.
  - `HttpResponse`.
  - `Dotenv`.
  - `Gson` para manipulação de JSON.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter:

- Java 22 ou superior instalado.
- Uma conta em uma API de câmbio, [ExchangeRate-API](https://www.exchangerate-api.com/), para obter uma chave de API.
- Um editor de código ou IDE como IntelliJ IDEA ou Eclipse.

## Configuração do Projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/devmoisesx/Conversor-De-Moedas.git
   ```

2. Importe o projeto para sua IDE de preferência.

3. Crie um arquivo `.env` na pasta src do projeto.

4. Adicione sua chave de API ao arquivo de configuração `.env` no formato: `KEY = (Sua chave de API)`.

5. Instale a biblioteca externa `Gson`.

## Como Executar

1. Execute o arquivo `Princial.java` diretamente pela IDE.

2. Insira as informações solicitadas, como a moeda de origem, a moeda de destino e o valor a ser convertido.

## Exemplo de Uso

- **Entrada**:

  - Moeda de origem: USD
  - Moeda de destino: BRL
  - Valor: 100

- **Saída**:
  - Valor convertido: R$ 500,00
  - Taxa de câmbio atual: 1 USD = 5 BRL

---

**Desenvolvido por Moisés Xavier**
