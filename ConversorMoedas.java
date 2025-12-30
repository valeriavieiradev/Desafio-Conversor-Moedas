import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMoedas {

    // 🔐 API KEY segura via variável de ambiente
    private static final String API_KEY = System.getenv("EXCHANGE_API_KEY");

    public static void main(String[] args) {

        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("ERRO: API_KEY não encontrada. Configure a variável de ambiente EXCHANGE_API_KEY.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {

            mostrarMenu();
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Real (BRL) -> Dólar (USD)");
                    System.out.print("Digite o valor em Reais: ");
                    double valor1 = scanner.nextDouble();
                    double taxa1 = buscarTaxa("BRL", "USD");
                    System.out.println("Valor convertido: " + converter(valor1, taxa1) + " USD");
                    break;

                case 2:
                    System.out.println("Dólar (USD) -> Real (BRL)");
                    System.out.print("Digite o valor em Dólares: ");
                    double valor2 = scanner.nextDouble();
                    double taxa2 = buscarTaxa("USD", "BRL");
                    System.out.println("Valor convertido: " + converter(valor2, taxa2) + " BRL");
                    break;

                case 3:
                    System.out.println("Real (BRL) -> Peso Argentino (ARS)");
                    System.out.print("Digite o valor em Reais: ");
                    double valor3 = scanner.nextDouble();
                    double taxa3 = buscarTaxa("BRL", "ARS");
                    System.out.println("Valor convertido: " + converter(valor3, taxa3) + " ARS");
                    break;

                case 4:
                    System.out.println("Peso Argentino (ARS) -> Real (BRL)");
                    System.out.print("Digite o valor em Pesos Argentinos: ");
                    double valor4 = scanner.nextDouble();
                    double taxa4 = buscarTaxa("ARS", "BRL");
                    System.out.println("Valor convertido: " + converter(valor4, taxa4) + " BRL");
                    break;

                case 5:
                    System.out.println("Dólar (USD) -> Peso Chileno (CLP)");
                    System.out.print("Digite o valor em Dólares: ");
                    double valor5 = scanner.nextDouble();
                    double taxa5 = buscarTaxa("USD", "CLP");
                    System.out.println("Valor convertido: " + converter(valor5, taxa5) + " CLP");
                    break;

                case 6:
                    System.out.println("Peso Chileno (CLP) -> Dólar (USD)");
                    System.out.print("Digite o valor em Pesos Chilenos: ");
                    double valor6 = scanner.nextDouble();
                    double taxa6 = buscarTaxa("CLP", "USD");
                    System.out.println("Valor convertido: " + converter(valor6, taxa6) + " USD");
                    break;

                case 7:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    // 🔹 MENU
    static void mostrarMenu() {
        System.out.println("=================================");
        System.out.println("      CONVERSOR DE MOEDAS");
        System.out.println("=================================");
        System.out.println("1 - Real (BRL) -> Dólar (USD)");
        System.out.println("2 - Dólar (USD) -> Real (BRL)");
        System.out.println("3 - Real (BRL) -> Peso Argentino (ARS)");
        System.out.println("4 - Peso Argentino (ARS) -> Real (BRL)");
        System.out.println("5 - Dólar (USD) -> Peso Chileno (CLP)");
        System.out.println("6 - Peso Chileno (CLP) -> Dólar (USD)");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // 🔹 CONVERSÃO
    static double converter(double valor, double taxa) {
        return valor * taxa;
    }

    // 🔹 BUSCA TAXA NA API
    static double buscarTaxa(String moedaBase, String moedaDestino) {

        String url = "https://v6.exchangerate-api.com/v6/"
                + API_KEY + "/pair/"
                + moedaBase + "/"
                + moedaDestino;

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // Compatível com versões antigas do Gson
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(response.body());
            JsonObject json = element.getAsJsonObject();

            // Verifica sucesso
            if (!json.get("result").getAsString().equals("success")) {
                System.out.println("Erro ao consultar API: " + json);
                return 0;
            }

            return json.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Erro ao buscar taxa: " + e.getMessage());
            return 0;
        }
    }
}