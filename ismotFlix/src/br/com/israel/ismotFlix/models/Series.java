package br.com.israel.ismotFlix.models;

public class Series extends Title{
    private int seasons;
    private boolean active;
    private int episodeForSeason;
    private int minutesForSeason;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public boolean isActive() {
        return active;
    }

    public int getEpisodeForSeason() {
        return episodeForSeason;
    }

    public int getMinutesForSeason() {
        return minutesForSeason;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setMinutesForSeason(int minutesForSeason) {
        this.minutesForSeason = minutesForSeason;
    }

    public void setEpisodeForSeason(int episodeForSeason) {
        this.episodeForSeason = episodeForSeason;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getDurationMinutes(){
        return seasons * episodeForSeason * minutesForSeason;
    }

}
