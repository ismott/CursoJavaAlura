package br.com.israel.ismotFlix.models;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private double sumReview;
    private int totalReview;
    private int durationMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public double getSumReview() {
        return sumReview;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getTotalReview(){
        return totalReview;
    }

    public void displaysTechnicalSpecifications() {
        System.out.printf("""
                Nome: %s
                Ano de lançamento: %d
                tempo de duração: %d
                avaliação: %.2f
                """, name, releaseYear, durationMinutes, getAverage());
    }

    public void rate(double score) {
        sumReview += score;
        totalReview++;
    }

    public double getAverage(){
        return sumReview/totalReview;
    }

    @Override
    public int compareTo(Title title) {
        return this.getName().compareTo(title.getName());
    }

    @Override
    public String toString() {
        return  "{name='" + name + '\'' +
                ", releaseYear=" + releaseYear + "}";
    }
}
