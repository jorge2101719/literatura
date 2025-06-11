package com.literatura.desafio_literatura.principal;

import com.literatura.desafio_literatura.model.Datos;
import com.literatura.desafio_literatura.model.LibroDatos;
import com.literatura.desafio_literatura.service.ConsumoAPI;
import com.literatura.desafio_literatura.service.ConvierteDatos;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<Datos> datosLibro = new ArrayList<>();

    public Principal() {
    }

    public void mostrarMenu() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    1.- Buscar libro por título
                    2.- Listar libros registrados
                    3.- Listar autores registrados
                    4.- Listar autores vivos en un determinado año
                    5.- Listar libros por idioma(s)
                    
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
                    listarAutoreVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");

            }
        }
    }


    // Búsqueda de libro por nombre
    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<LibroDatos> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {

            System.out.println("Libro encontrado");
                System.out.println(libroBuscado.get());
            } else {
                System.out.println("Libro no encontrado");
            }
        }

    private void buscarLibrosRegistrados() {
        System.out.println("en construcción... punto 2");
    }

    private void listarAutoresRegistrados() {
        System.out.println("en construcción... punto 3");
    }

    private void listarAutoreVivos() {
        System.out.println("en construcción... punto 4");
    }

    private void listarLibrosPorIdioma() {
        System.out.println("en construcción... punto 5");
    }


    }

