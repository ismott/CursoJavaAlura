package br.com.israel.MusiMot.Model;

public class Audio {
    private String name;
    private int duration;
    private String author;
    private int view;
    private int like;

    public int getView() {
        return view;
    }

    public int getLike() {
        return like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int sumView(){
        return this.view++;
    }

    public int sumLike(){
        return this.like++;
    }
}
