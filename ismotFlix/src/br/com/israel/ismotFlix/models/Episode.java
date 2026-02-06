package br.com.israel.ismotFlix.models;

import br.com.israel.ismotFlix.calculated.Classifiable;

public class Episode implements Classifiable {
    private int numero;
    private  String nome;
    private Series serie;
    private int totalViews;

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }

    @Override
    public int getClassification() {
        if(totalViews > 100) {
            return 4;
        }else {
            return 2;
        }

    }
}
