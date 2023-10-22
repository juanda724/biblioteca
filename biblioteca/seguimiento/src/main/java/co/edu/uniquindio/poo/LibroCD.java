package co.edu.uniquindio.poo;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;
import java.time.LocalDate;


public class LibroCD extends Libro{
    private final String tamañoMB;
    private final String formato;

    public LibroCD(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, String tamañoMB, String formato) {
        super(nombre, autor, editorial, añoPublicacion);
        ASSERTION.assertion(tamañoMB != null && tamañoMB.isBlank(), "Debe añadir el tamaño en MegaBytes del libro");
        this.tamañoMB = tamañoMB;
        this.formato = "CD";
    }
    
    public String getTamañoMB(){
        return tamañoMB;
    }
 
    public String getFormato(){
        return formato;
    }

}
