package br.com.screenmatch.screenmatch.service;

import br.com.screenmatch.screenmatch.model.DataEpisode;
import br.com.screenmatch.screenmatch.model.DataSeason;
import br.com.screenmatch.screenmatch.model.DataSerie;
import br.com.screenmatch.screenmatch.model.Episode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuService {
    private Scanner sc = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();
    private DataConvert conversor = new DataConvert();
    private final String ADRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=cf1af910";


    public void showMenu(){
        System.out.println("Digite o nome da série para buscar");
        String seriesName = sc.nextLine();
        var json = consumer.dataMiningMovie(ADRESS + seriesName.replace(" ", "+") + API_KEY);
        DataSerie data = conversor.convert(json, DataSerie.class);
        System.out.println(data);

        List<DataSeason> seasons = new ArrayList<>();

		for(int i =1; i <= data.totalSeasons(); i++){
			json  = consumer.dataMiningMovie(ADRESS + seriesName.replace(" ", "+") + "&season=" + i + API_KEY);
			DataSeason dataSeason = conversor.convert(json, DataSeason.class);
			seasons.add(dataSeason);
		}

		seasons.forEach(System.out::println);


        seasons.forEach(season -> season.episodes()
                .forEach(episode -> System.out.println(episode.title())));

        List<DataEpisode> dataEpisodes = seasons.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());
                //.toList (caso a lista seja imutável)

        dataEpisodes.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DataEpisode::rating).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episode> episodes = seasons.stream()
                .flatMap(e -> e.episodes().stream()
                        .map(d -> new Episode(e.numberSeason(), d)))
                .collect(Collectors.toList());

        episodes.forEach(System.out::println);


    }
}
