package co.edu.uniquindio.poo;
import static co.edu.uniquindio.util.AssertionUtil.ASSERTION;

public class Autor {
    private final String id;
    private final String nombre;
    private final String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad){
        ASSERTION.assertion(id != null && id.isBlank(), "Debe poner la identificacion del autor");
        ASSERTION.assertion(nombre != null && nombre.isBlank(),"Debe poner el nombre del autor");
        ASSERTION.assertion(nacionalidad !=null && nacionalidad.isBlank(),"Debe poner la nacionalidad del autor");
        this.id=id;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }
    
    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }
    

    
}
