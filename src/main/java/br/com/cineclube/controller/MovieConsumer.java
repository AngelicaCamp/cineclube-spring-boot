package br.com.cineclube.controller;


import br.com.cineclube.model.Movie;
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

    @Value("${tmdb.api.url}/movie/")
    private String tmdbUrl;

    @Autowired
    private RestTemplate apiRequest;

    @GetMapping("/{id}")
    public Movie getMovieByID(@PathVariable Long id) {

        String endpoint = tmdbUrl + id + "?api_key=" + apiKey + "&language=pt-BR";

        Movie movie = apiRequest.getForObject(endpoint, Movie.class);

        return movie;
    }



}
