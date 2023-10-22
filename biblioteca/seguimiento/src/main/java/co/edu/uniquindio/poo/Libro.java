package co.edu.uniquindio.poo;
import java.time.LocalDate;

import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;

public abstract class Libro {
    private final String nombre;
    private LocalDate añoPublicacion; 
    Autor autor;
  


    public Libro(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion){
        ASSERTION.assertion(nombre != null && nombre.isBlank(),"El nombre del libro es requerido");
        ASSERTION.assertion(añoPublicacion.isAfter(LocalDate.now()),"El año de publicacion debe ser anterior al actual");
        this.nombre=nombre;
        this.añoPublicacion=añoPublicacion;
        this.autor=autor;
    }

    public String getNombre(){
        return nombre;
    }

    public LocalDate getAñoPublicacion(){
        return añoPublicacion;
    }

    public abstract String getFormato();

}

