package br.com.israel.ismotFlix.main;

import br.com.israel.ismotFlix.models.Title;
import br.com.israel.ismotFlix.models.TitleTMDB;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o filme que deseja procurar");
        var search = read.nextLine();
        String link = "https://api.themoviedb.org/3/search/movie?query=" + search;
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiOGRmNTUzYWY2OGM1YmVhZmYzMmMxMzQ5OTU0NDE3YiIsIm5iZiI6MTc3MDc0NzIxMy44MjksInN1YiI6IjY5OGI3NTRkMzU0YzEwYmE0NDgyMzFiOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5rw1_bRNgcLd9mnB19ImrZ8KWiDYKJu6uYzNBtrRNNU";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .header("Authorization", "Bearer " + token)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        Gson gson = new Gson();
        TitleTMDB titleTmdb = gson.fromJson(response.body(), TitleTMDB.class);
        System.out.println(titleTmdb);
        ArrayList<Title> titles = new ArrayList<>();
        for (var i: titleTmdb.results()){
            String name = i.title();
            int releaseYear = 0;
            if(!i.release_date().isEmpty()){
                releaseYear = Integer.parseInt(i.release_date().split("-")[0]);
            }
            Title title = new Title(name, releaseYear);
            titles.add(title);
        }
        System.out.println(titles);
    }
}
