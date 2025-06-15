package com.literatura.desafio_literatura.repository;

import com.literatura.desafio_literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE :fecha between a.nacimiento AND a.fallecimiento")
    List<Autor> findForYear(int fecha);

    Optional<Autor> findByNombreContainingIgnoreCase(String nombreAutor);
}
