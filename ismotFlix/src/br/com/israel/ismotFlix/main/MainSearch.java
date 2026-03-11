package br.com.israel.ismotFlix.main;

import br.com.israel.ismotFlix.Controller.Request;
import br.com.israel.ismotFlix.models.Title;
import br.com.israel.ismotFlix.models.TitleTMDB;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o filme que deseja procurar");
        var search = URLEncoder.encode(read.nextLine(), StandardCharsets.UTF_8);
        Request request = new Request();
        request.getReques(search);
        var list = request.getTitles();
        System.out.println(list);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter fileWriter = new FileWriter("movies.json");
        fileWriter.write(gson.toJson(list));
        fileWriter.close();
    }
}
