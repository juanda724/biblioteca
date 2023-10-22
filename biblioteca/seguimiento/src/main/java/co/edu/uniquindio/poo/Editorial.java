package co.edu.uniquindio.poo;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;

public class Editorial {
    private final String id;
    private final String nombre;
    private final String telefono;
    public Editorial(String id, String nombre, String telefono) {
        ASSERTION.assertion(id != null && id.isBlank(), "Debe poner la identificacion de la editorial");
        ASSERTION.assertion(nombre != null && nombre.isBlank(),"Debe poner el nombre de la editorial");
        ASSERTION.assertion(telefono != null && telefono.isBlank(), "Debe poner el telefono de la editorial");
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }
}

