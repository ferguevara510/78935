package mx.uv.t4is.saludos;

public class Saludos {
    Integer ID;
    String nombre;
    public Saludos()
    {
        ID = 0;
        nombre = "";
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}