package com.literatura.desafio_literatura.model;

import jakarta.persistence.*;

//import java.util.List;


@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;
//    @Transient
//    private List<Libro> libros;

    @OneToOne
    @JoinTable(
            name = "libros",
            joinColumns = @JoinColumn(name = "autores_id"),
            inverseJoinColumns = @JoinColumn(name = "Id")
    )

    private Libro libros;

    public Autor() {}

    public Autor(AutorDatos autores) {
        this.nombre = autores.nombre();

        if(autores.nacimiento() == null) {
            this.nacimiento = 2000;
        } else {
            this.nacimiento = autores.nacimiento();
        }

        if(autores.fallecimiento() == null) {
            this.fallecimiento = 5000;
        } else {
            this.fallecimiento = autores.fallecimiento();
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + "Fecha de Nacimiento " + nacimiento + "Fecha de muerte " + fallecimiento;
    }

    public Libro getLibros() {
        return libros;
    }

    public void setLibros(Libro libros) {
        this.libros = libros;
    }

}
