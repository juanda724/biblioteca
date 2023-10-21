package co.edu.uniquindio.poo;
import java.time.LocalDate;

public abstract class Libro {
    private final String nombre;
    private LocalDate añoPublicacion; 

    public Libro(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion){
        assert nombre != null;
        assert añoPublicacion.isAfter(añoPublicacion);
        this.nombre=nombre;
        this.añoPublicacion=añoPublicacion;

    }

    public String getNombre(){
        return nombre;
    }

    public LocalDate getAñoPublicacion(){
        return añoPublicacion;
    }


}

