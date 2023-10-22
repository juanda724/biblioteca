package co.edu.uniquindio.poo;

import java.util.ArrayList;
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

    public Optional<Libro> buscarLibroNombreFormato(String nombre, String formato){
        Predicate<Libro> condicion = libro->libro.getNombre().equals(nombre);
        Predicate<Libro> condicion2 = libro->libro.getFormato().equals(formato);
        return libros.stream().filter(condicion.and(condicion2)).findAny();
    }

  
public Collection<Integer> buscarCantidadLibrosFormato(String nombreAutor) {
    Collection<Integer> cantidades = new ArrayList<>();
    
    Predicate<Libro> condicion = libro -> libro.autor.getNombre().equals(nombreAutor);

    int cantidadLibrosDigitales = obtenerListaLibroDigital().stream().filter(condicion).mapToInt(l -> 1).sum();
    cantidades.add(cantidadLibrosDigitales);

    int cantidadLibrosCd = obtenerListaLibroCD().stream().filter(condicion).mapToInt(l -> 1).sum();
    cantidades.add(cantidadLibrosCd);

    int cantidadLibrosImpresos = obtenerListaLibroImpreso().stream().filter(condicion).mapToInt(l -> 1).sum();
    cantidades.add(cantidadLibrosImpresos);

    return cantidades;
}


    public Collection <Libro> obtenerListaLibroDigital(){
        Predicate<Libro> condicion= libro->libro instanceof LibroDigital;
        return libros.stream().filter(condicion).toList();
    }
    public Collection <Libro> obtenerListaLibroCD(){
        Predicate<Libro> condicion= libro->libro instanceof LibroCD;
        return libros.stream().filter(condicion).toList();
    }
    public Collection <Libro> obtenerListaLibroImpreso(){
        Predicate<Libro> condicion= libro->libro instanceof LibroImpreso;
        return libros.stream().filter(condicion).toList();
    }
}


