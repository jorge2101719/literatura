package com.literatura.desafio_literatura.repository;

import com.literatura.desafio_literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.idiomas >= :idioma")
    List<Libro> findForIdiomas(String idioma);
}
