package br.com.israel.viaCep.controller;

import br.com.israel.viaCep.model.Address;
import br.com.israel.viaCep.model.Cep;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    public Address get(String search) throws IOException, InterruptedException {
        try {
            String url = "http://viacep.com.br/ws/" + search + "/json/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return jsonTreated(response);
        }catch (IllegalArgumentException e){
            System.out.println("Seu CEP não é valido confira: " + search);
            return null;
        }
    }

    public Address jsonTreated(HttpResponse<String> response){
        Gson gson = new Gson();
        Cep cep = gson.fromJson(response.body(), Cep.class);
        return new Address(cep);
    }
}
