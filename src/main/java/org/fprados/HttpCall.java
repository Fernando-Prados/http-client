package org.fprados;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCall {
    public static HttpResponse<String> execute(String verb, String url, String body) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(url));

            if ("GET".equals(verb)) {
                requestBuilder.GET();
            } else {
                System.out.println("Método no soportado: " + verb);
                return null;
            }

            HttpRequest request = requestBuilder.build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
