package co.edu.uniquindio.poo;

public class Autor {
    private final String id;
    private final String nombre;
    private final String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad){
        assert id != null;
        assert nombre != null;
        assert nacionalidad !=null;
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
