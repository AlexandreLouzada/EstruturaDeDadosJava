package Revisao;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    public static void main(String[] args) {
        try {
            // Criar cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Criar requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://jsonplaceholder.typicode.com/users"))
                    .GET()
                    .build();

            // Enviar requisição e obter resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Exibir resposta
            System.out.println("Código de status: " + response.statusCode());
            System.out.println("Resposta JSON:\n" + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

