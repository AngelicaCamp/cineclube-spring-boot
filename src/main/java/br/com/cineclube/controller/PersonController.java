package br.com.cineclube.controller;

import br.com.cineclube.model.People;
import br.com.cineclube.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping("/pessoas")
public class PersonController {


    @Autowired
    private PersonConsumer personConsumer;

    @GetMapping
    public String list(Model model){
        People people = new People();
        Person person = new Person();

        model.addAttribute("pessoaList", people.getPessoas());
        model.addAttribute("person", person);

        return "pessoas/manterPessoa.html";
    }

    @GetMapping("/buscarID")
    public String getPersonByID(Person person, Model model){
        Long id = person.getId();

        Person resultadoBusca = personConsumer.getPersonByID(id);

        model.addAttribute("pessoaList", List.of(resultadoBusca));
        model.addAttribute("person", person);

        return "pessoas/manterPessoa.html";
    }

    @GetMapping("/buscaNome")
    public String searchPeople(Person person, Model model) {

        String nome = person.getName();

        People resultadoBusca = personConsumer.searchPeople(nome);

        model.addAttribute("pessoaList", resultadoBusca.getPessoas());
        model.addAttribute("person", person);

        return "pessoas/manterPessoa.html";

    }

}
