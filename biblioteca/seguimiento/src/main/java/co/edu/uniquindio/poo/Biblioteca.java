package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

/**
 * 
 *
 */
public class Biblioteca {
     private final Collection<Libro> libros;
    
     public Biblioteca(){
        this.libros= new LinkedList<>();
     }
    
    public void registrarLibro(Libro libro){
        validarLibroRegistrado(libro);
        libros.add(libro);

    }

    public void validarLibroRegistrado(Libro libro){
        boolean existeLibro = buscarLibroPorNombre(libro.nombre()).isPresent();
        ASSERTION.assertion(!existeLibro, "El libro ya esta registrado")
    }

    public Optional<Libro> buscarLibroPorNombre(String nombre){
        Predicate<Libro> condicion = libro->libro.nombre().equals(nombre);
        return libros.stream().filter(condicion).findAny();
    }
    
    
    


}


