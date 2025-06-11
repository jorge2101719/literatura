package com.literatura.desafio_literatura.model;

//import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name = "libros")
public class Libro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(unique = true)
    private String titulo;
//    @ManyToOne
    private List<AutorDatos> autores;
//    @Enumerated(EnumType.STRING)
    private List<String> idiomas;
    private Integer descargas;

    public Libro(LibroDatos libroDatos) {
        this.id = Integer.valueOf(libroDatos.id());
        this.titulo = libroDatos.titulo();
        this.autores = libroDatos.autores();
        this.idiomas = libroDatos.idiomas();
        this.descargas = libroDatos.descargas();
    }

    public Libro() {}

    @Override
    public String toString() {
        return "titulo= " + titulo +
                "autores= " + autores +
                "idiomas= " + idiomas +
                "descargas= " + descargas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorDatos> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDatos> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }
}
