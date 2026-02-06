package br.com.israel.ismotFlix.models;

import br.com.israel.ismotFlix.calculated.Classifiable;

public class Movie extends Title implements Classifiable {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(String name, int releaseYear){
        super(name, releaseYear);
    }


    @Override
    public int getClassification() {
        return (int) getAverage()/2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}
