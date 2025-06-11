package com.literatura.desafio_literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDatos(
//        @JsonAlias("results") List<LibroDatos> resultados
        @JsonAlias("id") String id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDatos> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer descargas
) {
}
