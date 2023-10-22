package co.edu.uniquindio.poo;

import java.time.LocalDate;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;

public class LibroImpreso extends Libro {
    private final byte cantidad;
    private final String formato;

    public LibroImpreso(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion,
            byte cantidad, String formato) {
        super(nombre, autor, editorial, añoPublicacion);
        ASSERTION.assertion(cantidad > 0, "La cantidad de libros debe ser mayor a 0");
        this.cantidad = cantidad;
        this.formato = "Impreso";
    }

    public byte getCantidad() {
        return cantidad;
    }
    
    public String getFormato(){
        return formato;
    }
}
