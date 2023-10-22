package co.edu.uniquindio.poo;

import java.time.LocalDate;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;

public class LibroDigital extends Libro {
    private final String URL;
    private final String formato;

    public LibroDigital(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, String URL, String formato) {
        super(nombre, autor, editorial, añoPublicacion);
        ASSERTION.assertion(URL != null && URL.isBlank(), "Debe añadir la URL del libro digital");
        this.URL=URL;
        this.formato="Digital";
    }

    public String getURL() {
        return URL;
    }

    public String getFormato(){
        return formato;
    }
}
