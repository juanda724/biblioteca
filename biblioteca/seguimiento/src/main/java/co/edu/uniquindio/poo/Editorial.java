package co.edu.uniquindio.poo;

public class Editorial {
    private final String id;
    private final String nombre;
    private final String telefono;
    public Editorial(String id, String nombre, String telefono) {
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

