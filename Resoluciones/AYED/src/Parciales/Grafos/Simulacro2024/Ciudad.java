package Parciales.Grafos.Simulacro2024;

public class Ciudad {
    private String nombre;
    private int cantDiasEstadia;

    public Ciudad(String nombre, int cantDiasEstadia) {
        this.nombre = nombre;
        this.cantDiasEstadia = cantDiasEstadia;
    }
    public Ciudad(){

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantDiasEstadia() {
        return cantDiasEstadia;
    }
    public void setCantDiasEstadia(int cantDiasEstadia) {
        this.cantDiasEstadia = cantDiasEstadia;
    }
}
