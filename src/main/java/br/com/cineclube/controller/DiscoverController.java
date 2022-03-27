package br.com.cineclube.controller;


import br.com.cineclube.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie/discover")
public class DiscoverController {

    @Autowired
    private MovieConsumer movieConsumer;


    @GetMapping
    public String filterMovies(Model model){
        Movies movies = movieConsumer.FiltrarFilmes();

        model.addAttribute("filmeList", movies.getFilmes());

        return "filmes/filtered.html";
    }

}
