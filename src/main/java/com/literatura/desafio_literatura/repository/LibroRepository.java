package com.literatura.desafio_literatura.repository;

//import com.literatura.desafio_literatura.model.Idiomas;
import com.literatura.desafio_literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.idiomas[0] >= :idioma")
    List<Libro> findForIdiomas(String idioma);

    Optional<Libro> findByTituloContainingIgnoreCase(String tituloDelLibro);

//    List<Libro> findByIdioma(String idiomaSeleccionado);
}
