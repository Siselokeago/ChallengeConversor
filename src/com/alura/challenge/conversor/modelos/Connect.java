package com.alura.challenge.conversor.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connect {
    private HttpResponse<String> response;
    public Connect(){

    }

    public HttpResponse<String> request(String divisa){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/9f961698aab6e945bc5565aa/" + divisa))
                    .build();
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }
}
