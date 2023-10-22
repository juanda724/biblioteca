package co.edu.uniquindio.poo;

import java.time.LocalDate;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;

public class LibroDigital extends Libro {
    private final String URL;

    public LibroDigital(String nombre, Autor autor, Editorial editorial, LocalDate añoPublicacion, String URL) {
        super(nombre, autor, editorial, añoPublicacion);
        ASSERTION.assertion(URL != null && URL.isBlank(), "Debe añadir la URL del libro digital");
        this.URL=URL;
    }

    public String getURL() {
        return URL;
    }
}
