package br.com.screenmatch.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer numberEp;
    private Double rating;
    private LocalDate releaseDate;

    public Episode(Integer num, DataEpisode dataEpisode) {
        this.season = num;
        this.title = dataEpisode.title();
        this.numberEp = dataEpisode.numberEp();
        try {
            this.rating = Double.valueOf(dataEpisode.rating());
        }catch (NumberFormatException exception){
            this.rating = 0.0;
        }

        try {
            this.releaseDate = LocalDate.parse(dataEpisode.released());
        } catch (DateTimeParseException ex) {
            this.releaseDate = null;
        }

    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberEp() {
        return numberEp;
    }

    public void setNumberEp(Integer numberEp) {
        this.numberEp = numberEp;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return  "temporada=" + season +
                ", titulo='" + title + '\'' +
                ", numeroEpisodio=" + numberEp +
                ", avaliacao=" + rating +
                ", dataLancamento=" + releaseDate;
    }
}

