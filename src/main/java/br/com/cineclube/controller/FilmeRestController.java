package br.com.cineclube.controller;


import br.com.cineclube.dao.FilmeRepository;
import br.com.cineclube.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmeRestController {

    @Autowired
    private FilmeRepository daoFilme;

    // Buscar filme por ID
    @GetMapping("/filme/{id}")
    Optional<Filme> getFilme (@PathVariable Long id){
        return daoFilme.findById(id);
    }

    // Buscar lista de filmes
    @GetMapping(value = "/filmes")
    Iterable<Filme> getFilmes(){
        return daoFilme.findAll();
    }

    // Criar novo filme (create)
    @PostMapping("/filme")
    Filme postFilme(@RequestBody Filme filme){
        daoFilme.save(filme);
        return filme;
    }

    // Deletar filme (delete)
    @DeleteMapping("/filme/{id}")
    void deleteFilme(@PathVariable Long id){
        daoFilme.deleteById(id);
    }

    // Atualizar filme (update)
    @PutMapping("/filme/{id}")
    ResponseEntity<Filme> putFilme(@PathVariable Long id, @RequestBody Filme filme){
        Filme f = daoFilme.save(filme);

        if(f != null)
            return new ResponseEntity<>(filme, HttpStatus.CREATED);

        return new ResponseEntity<>(filme,HttpStatus.OK);
    }
}
