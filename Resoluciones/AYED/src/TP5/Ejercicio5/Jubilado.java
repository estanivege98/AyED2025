package TP5.Ejercicio5;

public class Jubilado {
    private String nombre;
    private String domicilio;

    public Jubilado(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
