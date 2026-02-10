package br.com.israel.ismotFlix.main;

import br.com.israel.ismotFlix.models.Movie;
import br.com.israel.ismotFlix.models.Series;
import br.com.israel.ismotFlix.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainList {
    public static void main(String[] args) {
        Movie movie = new Movie("Velozes e furiosos", 2005);
        movie.rate(6);
        Series serie = new Series("Stranger Things", 2015);
        Movie movie2 = new Movie("carros", 2005);
        movie2.rate(8);
        Series serie2 = new Series("lost", 2015);

        List<Title> titles = new ArrayList<>();
        titles.add(movie);
        titles.add(movie2);
        titles.add(serie);
        titles.add(serie2);

        for (Title title: titles){
            System.out.println(title.getName());
            if (title instanceof Movie movieItem){
                System.out.println(movieItem.getClassification());
            }
        }

        Collections.sort(titles);
        System.out.println(titles);

        titles.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println(titles);

    }
}
