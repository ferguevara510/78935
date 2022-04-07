package mx.uv.t4is.saludosDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saludadores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer ID;
    String nombre;
    public Saludadores()
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