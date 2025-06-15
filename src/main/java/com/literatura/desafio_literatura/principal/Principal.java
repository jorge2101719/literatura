package com.literatura.desafio_literatura.principal;


import com.literatura.desafio_literatura.model.Autor;
import com.literatura.desafio_literatura.model.Datos;
import com.literatura.desafio_literatura.model.Idiomas;
import com.literatura.desafio_literatura.model.Libro;

import com.literatura.desafio_literatura.repository.AutorRepository;
import com.literatura.desafio_literatura.repository.LibroRepository;
import com.literatura.desafio_literatura.service.ConsumoAPI;
import com.literatura.desafio_literatura.service.ConvierteDatos;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

@Service
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    private static String raya = "--------------------------------------------";

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository)  {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    private final String mensaje = "No se encontraron resultados";

    public Principal() {
    }

    public void mostrarMenu() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    
                    Elija una de las siguientes alternativas:
                    
                    1.- Buscar libro por título
                    2.- Listar libros registrados
                    3.- Listar autores registrados
                    4.- Listar autores vivos en un determinado año
                    5.- Listar libros por idioma(s)
                    6.- Buscar libro en la base de datos
                    0.- Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    buscarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    buscarLibroEnLaBaseDeDatos();
                    break;
                case 0:
                    System.out.println("Gracias por su preferencia. Nos vemos pronto.");
                    break;
                default:
                    System.out.println("Opción incorrecta...");

            }
        }
    }


    // Búsqueda en la web
    private void buscarLibroPorTitulo() {
        Datos datos = getDatosLibro();


        if(!datos.resultados().isEmpty()) {
            Libro libro = new Libro(datos.resultados().get(0));
            libro = libroRepository.save(libro);
        } else {
            System.out.println(mensaje);
        }

        System.out.println("Datos del libro= ");
        System.out.println(datos);
//        if (libroBuscado.isPresent()) {
//            System.out.println("Libro encontrado");
//            System.out.println(libroBuscado.get());
//        } else {
//                System.out.println("Libro no encontrado");
//        }
    }

    private Datos getDatosLibro() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        tituloLibro = tituloLibro.replace(" ", "%20");
        System.out.println("Titulo= " + tituloLibro);
        var json = consumoApi.obtenerDatos(URL_BASE + tituloLibro);
        System.out.println(json);
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        return datos;
    }


    private void buscarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
//
//        System.out.println(libros);
//
//        libros.stream()
//                .sorted(Comparator.comparing(Libro::getTitulo))
//                .forEach(System.out::println);
//
        if(!libros.isEmpty()) {
            for(Libro libro : libros) {
                System.out.println("Titulo= " + libro.getTitulo());
                System.out.println("Autor(es)= " + libro.getAutores());
                System.out.println("Idioma(s)= " + libro.getIdiomas());
                System.out.println("Descargas=" + libro.getDescargas());
                System.out.println(raya);
            }
        } else {
            System.out.println(mensaje);
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();

        if(!autores.isEmpty()) {
            for(Autor autor : autores) {
                System.out.println("Nombre= " + autor.getNombre());
                System.out.println("Fecha de Nacimiento= " + autor.getNacimiento());
                System.out.println("Fecha de muerte= " + autor.getFallecimiento());
                System.out.println("Libros= " + autor.getLibros().getTitulo());
                System.out.println(raya);
            }
        } else {
            System.out.println(mensaje);
        }
    }

    private void listarAutoresVivos() {
        System.out.println("Escriba el año que desea investigar... ");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorRepository.findForYear(fecha);

        if(!autores.isEmpty()) {
            for(Autor autor : autores) {
                System.out.println("Nombre= " + autor.getNombre());
                System.out.println("Fecha de Nacimiento= " + autor.getNacimiento());
                System.out.println("Fecha de muerte= " + autor.getFallecimiento());
                System.out.println("Libros= " + autor.getLibros().getTitulo());
                System.out.println(raya);
            }
        } else {
            System.out.println(mensaje);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma....");

        var idiomaABuscar = teclado.nextLine();

        System.out.println(idiomaABuscar);

        //List<Libro> libros = libroRepository.findAll();
        List<Libro> libros = libroRepository.findForIdiomas(idiomaABuscar);

        ;
//        var menuIdiomas = """
//                Selecciones un idioma
//                1.- Español
//                2.- Inglés
//                0.- Cancelar búsqueda
//
//                """;
//        System.out.println(menuIdiomas);
//        var idioma = teclado.nextInt();
//        teclado.nextLine();
//
//        String seleccion = "";
//
//        if(idioma == 1) {
//            seleccion = "es";
//        } else if(idioma == 2) {
//            seleccion = "en";
//        } else {
//            seleccion = "0";
//            return;
//        }
//
        if(!libros.isEmpty()) {
            for(Libro libro : libros) {
                System.out.println("Título= " + libro.getTitulo());
                System.out.println("Autor= " + libro.getAutores());
                System.out.println("Idioma(s)= " + libro.getIdiomas());
                System.out.println("Descargas= " + libro.getDescargas());
                System.out.println(raya);
            }
        } else {
            System.out.println(mensaje);
        }
    }

    private void  buscarLibroEnLaBaseDeDatos() {
        System.out.println("Escriba el título del libro a buscar en la base de datos...");
        var tituloDelLibro = teclado.nextLine();

        Optional<Libro> libroBuscado = libroRepository.findByTituloContainingIgnoreCase(tituloDelLibro);

        if (libroBuscado.isPresent()) {
            System.out.println("Datos del libro: " + libroBuscado.get());
        } else {
            System.out.println(mensaje);
        }
    }

}

