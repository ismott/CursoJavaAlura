package br.com.israel.ismotFlix.main;

import br.com.israel.ismotFlix.calculated.RecommendationFilter;
import br.com.israel.ismotFlix.calculated.TimeCalculator;
import br.com.israel.ismotFlix.models.Movie;
import br.com.israel.ismotFlix.models.Series;

import java.util.ArrayList;

public class Main {
  public static void main() {
    Movie movie = new Movie("Velozes e furiosos", 2005);

    movie.setDurationMinutes(180);
    movie.setIncludedInPlan(true);

    movie.rate(8);
    movie.rate(5);
    movie.rate(10);
    movie.displaysTechnicalSpecifications();

    Series serie = new Series("Stranger Things", 2015);
    serie.setSeasons(5);
    serie.setEpisodeForSeason(9);
    serie.setMinutesForSeason(50);
    System.out.println("duração da serie: " + serie.getDurationMinutes());

    Movie movie2 = new Movie("carros", 2005);

    movie2.setDurationMinutes(120);
    movie2.setIncludedInPlan(true);

    TimeCalculator calculator = new TimeCalculator();
    calculator.includes(movie);
    calculator.includes(movie2);
    calculator.includes(serie);
    System.out.println("tempo total dos filmes: " + calculator.getTotalTime());
    RecommendationFilter filter = new RecommendationFilter();
    filter.filter(movie);

    ArrayList<Movie> movies = new ArrayList<>();
    movies.add(movie);
    movies.add(movie2);

    System.out.println("primeiro filme: " + movies.getFirst().getName());
    System.out.println(movies.toString());
  }
}