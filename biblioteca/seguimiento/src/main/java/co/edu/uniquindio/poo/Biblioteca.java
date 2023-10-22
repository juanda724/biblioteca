package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;
/**
 * 
 *
 */
public class Biblioteca {
    private final String nombre; 
    private final Collection<Libro> libros;
    
     public Biblioteca(String nombre){
        ASSERTION.assertion(nombre != null && nombre.isBlank(),"El nombre de la biblioteca es requerido");
        this.libros= new LinkedList<>();
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void registrarLibro(Libro libro){
        validarLibroRegistrado(libro);
        libros.add(libro);

    }

    public void validarLibroRegistrado(Libro libro){
        boolean existeLibro = buscarLibroPorNombre(libro.getNombre()).isPresent();
        ASSERTION.assertion(!existeLibro, "El libro ya está registrado");
    }

    public Optional<Libro> buscarLibroPorNombre(String nombre){
        Predicate<Libro> condicion = libro->libro.getNombre().equals(nombre);
        return libros.stream().filter(condicion).findAny();
    }
    
    public Optional<Libro> buscarLibroAutor(String nombre){
        Predicate<Libro> condicion = libro->libro.autor.getNombre().equals(nombre);
        return libros.stream().filter(condicion).findAny();
    }

    public Optional<Libro> buscarLibroNombreFormato(String nombre, String nombre2){
        Predicate<Libro> condicion = libro->libro.getNombre().equals(nombre);
        Predicate<Libro> condicion2 = libro->libro.instanceOf(nombre2);
        return libros.stream().filter(condicion.and(condicion2)).findAny();
    }

    public 
}


