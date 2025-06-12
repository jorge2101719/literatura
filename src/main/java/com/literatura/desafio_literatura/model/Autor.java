package com.literatura.desafio_literatura.model;

import jakarta.persistence.*;



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

    @OneToOne
    @JoinTable(
            name = "libros",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )

    private Libro libros;

    public Autor() {}

    public Autor(AutorDatos autor) {
        this.nombre = autor.nombre();

        if(autor.nacimiento() == null) {
            this.nacimiento = 2000;
        } else {
            this.nacimiento = autor.nacimiento();
        }

        if(autor.fallecimiento() == null) {
            this.fallecimiento = 5000;
        } else {
            this.fallecimiento = autor.fallecimiento();
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
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + nacimiento +
                ", fechaFallecimiento=" + fallecimiento +
                ", libros=" + libros +
                '}';
    }

    public Libro getLibros() {
        return libros;
    }

    public void setLibros(Libro libros) {
        this.libros = libros;
    }

}
