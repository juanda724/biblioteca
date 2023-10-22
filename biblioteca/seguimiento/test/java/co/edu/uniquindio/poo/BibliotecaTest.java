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
import co.edu.uniquindio.poo.LibroImpreso;

/**
 * Unit test for simple App.
 */
public class BibliotecaTest implements AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */

  
    @Test
    public void datosCompletos() {
        LOG.info("Iniciando test datos completos");
        Biblioteca biblioteca = new Biblioteca("Banco de la republica");
        var autor = new Autor("108J7", "Gabriel Garcia Marquez", "Colombia");
        var editorial = new Editorial("546", "Editorial Sudamericana", "43005400");
        var libro = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(1982, 2, 31), 25);
       
        assertEquals("Banco de la republica", biblioteca.getNombre());
        assertEquals("100 años de soledad", libro.getNombre());
        assertEquals(LocalDate.of(1982, 2 , 31), libro.getAñoPublicacion());
        assertEquals("25", libro.getTamañoMB());
        assertEquals("108J7", autor.getId());
        assertEquals("Gabriel Garcia Marquez", libro.autor.getNombre());
        assertEquals("Colombia", libro.autor.getNacionalidad());
        assertEquals("546",libro.editorial.getId());
        assertEquals("Editorial Sudamericana", libro.editorial.getNombre());
        assertEquals("43005400", libro.editorial.getTelefono());
    
        LOG.info("Finalizando test datos Completos");
    }
  
    @Test
    public void datosNulos() {
        LOG.info("Inicio de prueba datos nulos...");
        assertThrows(Throwable.class, ()-> new Biblioteca(null));
        LOG.info("Fin de prueba datos nulos...");
    }
  
     @Test
    public void registrarLibro() {
        LOG.info("Iniciado test registrar Libro");
        Biblioteca biblioteca = new Biblioteca("Banco de la republica");
        var autor = new Autor("108J7", "Gabriel Garcia Marquez", "Colombia");
        var editorial = new Editorial("546", "Editorial Sudamericana", "43005400");
        var libro = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(1982, 2, 31), 25);
       
        biblioteca.registrarLibro(libro);
       
        assertTrue(biblioteca.libros().contains(libro));
        assertEquals(1, biblioteca.libros().size());
        LOG.info("Finalizando test registrar Libro");
    }

    @Test
    public void registrarLibroRepetido(){
        LOG.info("Iniciado test registrar Libro repetido");
        Biblioteca biblioteca = new Biblioteca("Banco de la republica");
        var autor = new Autor("108J7", "Gabriel Garcia Marquez", "Colombia");
        var editorial = new Editorial("546", "Editorial Sudamericana", "43005400");
        var libro = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(1982, 2, 31), 25);
        var libro2 = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(1982, 2, 31), 25);

        biblioteca.registrarLibro(libro);        
        biblioteca.registrarLibro(libro2);
   
        assertThrows(Throwable.class,()->libro.registrarJugador(libro2));
        LOG.info("Finalizando test registrar libro repetido");
    }   

    @Test
    public void buscarLibroAutor(){
        LOG.info("Iniciando prueba buscar libro por autor");
        Biblioteca biblioteca = new Biblioteca("Banco de la republica");
        var autor = new Autor("108J7", "Gabriel Garcia Marquez", "Colombia");
        var editorial = new Editorial("546", "Editorial Sudamericana", "43005400");
        var libro = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(1982, 2, 31), 25);
        var editorial2 = new Editorial("456", "Alfagura", "1321");
        var libro2 = new LibroImpreso("El coronel no tiene quien le escriba", autor, editorial2,null, 5, null);

        biblioteca.registrarLibro(libro);        
        biblioteca.registrarLibro(libro2);
        
        Optional<Libro> resultado = biblioteca.buscarLibroAutor("Gabriel Garcia Marquez");

        assertTrue(resultado.isPresent());
        assertEquals("Gabriel Garcia Marquez", resultado.autor.getNombre());
        LOG.info("Finalizando prueba buscar libro por autor");
    }

    @Test void buscarLibroNombreFormato(){
        Biblioteca biblioteca = new Biblioteca("Banco de la republica");
        var autor = new Autor("108J7", "Gabriel Garcia Marquez", "Colombia");
        var editorial = new Editorial("546", "Editorial Sudamericana", "43005400");
        var libro = new LibroCD("100 años de soledad", autor, editorial, LocalDate.of(1982, 2, 31), 25);
        
        biblioteca.registrarLibro(libro);

        Optional<Libro> libroEncontrado = biblioteca.buscarLibroNombreFormato("100 años de soledad", "CD");
        assertTrue(libroEncontrado.isPresent());
        assertEquals("100 años de soledad", libro.getNombre());
        assertEquals("CD", libro.getFormato());

    }
}

