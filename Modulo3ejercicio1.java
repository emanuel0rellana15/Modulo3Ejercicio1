package com.mycompany.modulo3ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean prestado;

    public Libro(String titulo, String autor, int anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("El libro \"" + titulo + "\" ha sido prestado.");
        } else {
            System.out.println("El libro \"" + titulo + "\" ya está prestado.");
        }
    }

    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("El libro \"" + titulo + "\" ha sido devuelto.");
        } else {
            System.out.println("El libro \"" + titulo + "\" no estaba prestado.");
        }
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", Ano: " + anioPublicacion +
                ", Genero: " + genero + ", Prestado: " + (prestado ? "Si" : "No");
    }
}

class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido agregado a la biblioteca.");
    }

    public void buscarLibro(String busqueda, boolean porTitulo) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if ((porTitulo && libro.getTitulo().equalsIgnoreCase(busqueda)) ||
                (!porTitulo && libro.getAutor().equalsIgnoreCase(busqueda))) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
    if (porTitulo) {
        System.out.println("No se encontro ningun libro con ese título.");
    } else {
        System.out.println("No se encontro ningun libro con ese autor.");
    }
}

    }

    public void prestarLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.prestar();
                return;
            }
        }
        System.out.println("No se encontró el libro \"" + titulo + "\".");
    }

    public void devolverLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.devolver();
                return;
            }
        }
        System.out.println("No se encontró el libro \"" + titulo + "\".");
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles en la biblioteca.");
        } else {
            for (int i = 0; i < libros.size(); i++) {
                System.out.println(libros.get(i));
            }
        }
    }
}

/**
 *
 * @author emanuel
 */
public class Modulo3ejercicio1 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menu Biblioteca Virtual ---");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Buscar libro por titulo");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Prestar un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("6. Mostrar todos los libros");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ano de publicacion: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Ingrese el genero del libro: ");
                    String genero = scanner.nextLine();
                    Libro nuevoLibro = new Libro(titulo, autor, anio, genero);
                    biblioteca.agregarLibro(nuevoLibro);
                    break;
                case 2:
                    System.out.print("Ingrese el titulo del libro a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    biblioteca.buscarLibro(tituloBusqueda, true);
                    break;
                case 3:
                    System.out.print("Ingrese el autor del libro a buscar: ");
                    String autorBusqueda = scanner.nextLine();
                    biblioteca.buscarLibro(autorBusqueda, false);
                    break;
                case 4:
                    System.out.print("Ingrese el titulo del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    biblioteca.prestarLibro(tituloPrestar);
                    break;
                case 5:
                    System.out.print("Ingrese el titulo del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolver);
                    break;
                case 6:
                    biblioteca.mostrarLibros();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no válida.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }
}
