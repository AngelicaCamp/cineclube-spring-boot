package br.com.cineclube.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class People {

    @JsonAlias("results")
    private List<Person> pessoas;

    public List<Person> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Person> pessoas) {
        this.pessoas = pessoas;
    }
}
