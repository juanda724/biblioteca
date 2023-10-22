/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.test.java.co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Autor;
import co.edu.uniquindio.poo.Biblioteca;
import co.edu.uniquindio.poo.Editorial;
import co.edu.uniquindio.poo.LibroCD;

/**
 * Unit test for simple App.
 */
public class AppTest implements AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */

    @Test
    public void datosCompletos() {
        LOG.info("Iniciado test datos completos");
        Biblioteca biblioteca = new Biblioteca("Banco de la republica");
        var autor = new Autor("108J7", "Gabriel Garcia Marquez", "Colombia");
        var editorial = new Editorial("546", "Visual", "3172145324");
        var libro = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(2022, 2, 31), 25);
       
        biblioteca.registrarLibro(libro);
       
        assertTrue(biblioteca.libros().contains(libro));
        assertEquals(1, biblioteca.libros().size());
        LOG.info("Finalizando test datos completos");
    }
}
