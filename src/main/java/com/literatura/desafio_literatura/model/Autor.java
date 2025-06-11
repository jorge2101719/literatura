package com.literatura.desafio_literatura.model;

//import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name = "autores")
public class Autor {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(unique = true)
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;

//    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(AutorDatos autor) {
        this.nombre = autor.nombre();
        this.nacimiento = autor.nacimiento();
        this.fallecimiento = autor.fallecimiento();
    }

    public Autor() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
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

    public void imprimirInformacion() {
        System.out.println("Datos del Autor(es)");
        System.out.println("Nomber= " + nombre);
        System.out.println("Fecha de nacimiento= " + nacimiento);
        System.out.println("Fecha de fallecimiento= " + fallecimiento);
        System.out.println("Libros= " + libros);
        System.out.println("");
    }



}
