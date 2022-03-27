package br.com.cineclube.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Movies {

    @JsonAlias("results")
    private List<Movie> filmes;

    public List<Movie> getFilmes() {
        return filmes;
    }


    public void setPessoas(List<Person> pessoas) {
        this.filmes = filmes;
    }
}





