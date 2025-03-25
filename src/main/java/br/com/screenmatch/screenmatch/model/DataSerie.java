package br.com.screenmatch.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(@JsonAlias("Title")          String title,
                        @JsonAlias("totalSeasons")   Integer totalSeasons,
                        @JsonAlias("imdbRating")      String Score,
                        @JsonAlias("imdbVotes")      String votes
                        ) {

}
