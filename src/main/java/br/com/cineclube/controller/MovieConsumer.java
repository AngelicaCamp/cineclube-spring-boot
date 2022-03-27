package br.com.cineclube.controller;


import br.com.cineclube.model.Movie;
import br.com.cineclube.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieConsumer {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String tmdbUrl;

    @Autowired
    private RestTemplate apiRequest;

    @GetMapping("/{id}")
    public Movie getMovieByID(@PathVariable Long id) {

        String endpoint = tmdbUrl + "/movie/" + id + "?api_key=" + apiKey + "&language=pt-BR";

        Movie movie = apiRequest.getForObject(endpoint, Movie.class);

        return movie;
    }

    @GetMapping("/filtered")
    public Movies FiltrarFilmes(){

        String filter = "&language=pt-BR&with_genres=sci-fi&sort_by=vote_count.desc&release_date.gte=1980&release_date.lte=1990";

        String endpoint = tmdbUrl + "/discover/movie?api_key=" + apiKey + filter;

        Movies movies = apiRequest.getForObject(endpoint, Movies.class);

        return movies;
    }
}
