package TP5.Ejercicio5;

public class Persona {
    private String nombre;
    private String domicilio;
    private String tipo;
    private boolean cobro;

    public Persona(String nombre, String domicilio, String tipo, boolean cobro) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.tipo = tipo;
        this.cobro = cobro;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public String getTipo() {
        return tipo;
    }
    public boolean isCobro() {
        return cobro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCobro(boolean cobro) {
        this.cobro = cobro;
    }
}
