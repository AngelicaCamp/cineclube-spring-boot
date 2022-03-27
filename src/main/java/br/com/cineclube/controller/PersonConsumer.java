package br.com.cineclube.controller;


import br.com.cineclube.model.People;
import br.com.cineclube.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonConsumer {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String tmdbUrl;

    @Autowired
    private RestTemplate apiRequest;

    @GetMapping("/{id}")
    public Person getPersonByID (@PathVariable Long id){
        String endpoint = tmdbUrl + "/person/" + id + "?api_key=" + apiKey;

        Person person = apiRequest.getForObject(endpoint, Person.class);
        return person;
    }

    @GetMapping(params = "name")
    public People searchPeople(@RequestParam String name){

        String endpoint = tmdbUrl + "/search/person" + "?api_key=" + apiKey + "&query=" + name;

        People people = apiRequest.getForObject(endpoint, People.class);

        return people;
    }
}
