package br.com.cineclube.controller;

import br.com.cineclube.dao.PessoaRepository;
import br.com.cineclube.model.Filme;
import br.com.cineclube.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PessoaRestController {

    @Autowired
    private PessoaRepository daoPessoa;


    // Buscar pessoa por ID
    @GetMapping("/pessoa/{id}")
    Optional<Pessoa> getPessoa (@PathVariable Long id){
        return daoPessoa.findById(id);
    }

    // Buscar lista de pessoas
    @GetMapping(value = "/pessoas")
    Iterable<Pessoa> getPessoas(){
        return daoPessoa.findAll();
    }

    // Criar nova pessoa (create)
    @PostMapping("/pessoa")
    Pessoa postPessoa(@RequestBody Pessoa pessoa){
        daoPessoa.save(pessoa);
        return pessoa;
    }

    // Deletar pessoa (delete)
    @DeleteMapping("/pessoa/{id}")
    void deletePessoa(@PathVariable Long id){
        daoPessoa.deleteById(id);
    }

    // Atualizar pessoa (update)
    @PutMapping("/pessoa/{id}")
    ResponseEntity<Pessoa> putPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa p = daoPessoa.save(pessoa);

        if(p != null)
            return new ResponseEntity<>(pessoa, HttpStatus.CREATED);

        return new ResponseEntity<>(pessoa,HttpStatus.OK);
    }

}
