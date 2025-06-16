package com.literatura.desafio_literatura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Integer contador;

    @Column(unique = true)
    private String titulo;

    @Column(name = "id_libro", unique = true)
    private Integer id_libro;

    @Column(name = "idiomas")
    private List<String> idiomas;
    private Integer descargas;

    @OneToOne(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autores;


    public Libro() {}

    public Libro(LibroDatos libroDatos) {
        this.id_libro = libroDatos.id_libro();
        this.titulo = libroDatos.titulo();
        this.descargas = libroDatos.descargas();

        if(!libroDatos.idiomas().isEmpty()) {
            this.idiomas = libroDatos.idiomas();
        }

        if(!libroDatos.autores().isEmpty()) {
            for(AutorDatos autorDatos : libroDatos.autores()) {
                this.autores = new Autor(autorDatos);
                break;
            }
        }
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
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

    public Autor getAutores() {
        return autores;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "[id_libro= " + id_libro +
                ", titulo= " + titulo +
                ", autor(es)= " + autores +
                ", idioma(s)= " + idiomas +
                ", descargas= " + descargas
                + "]";
    }

}
