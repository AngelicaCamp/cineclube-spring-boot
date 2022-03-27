package br.com.cineclube.dao;

import br.com.cineclube.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    //findAll, findById, get, save, delete, update


}
