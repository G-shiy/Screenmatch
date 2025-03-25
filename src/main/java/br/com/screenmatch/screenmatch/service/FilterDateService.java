package br.com.screenmatch.screenmatch.service;

import br.com.screenmatch.screenmatch.model.Episode;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDateService {
    public static List<Episode> filterEpisodesAfterDate(List<Episode> episodes , String date) {

        try {
            LocalDate releaseDate = LocalDate.parse(date);
            return episodes.stream()
                    .filter(e -> e.getReleaseDate() != null && e.getReleaseDate().isAfter(releaseDate))
                    .collect(Collectors.toList());
        } catch (DateTimeParseException ex){
            return episodes.stream()
                    .filter(e -> e.getReleaseDate() != null )
                    .collect(Collectors.toList());
        }
    }
}
