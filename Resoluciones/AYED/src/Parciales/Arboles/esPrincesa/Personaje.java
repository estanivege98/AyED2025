package Parciales.Arboles.esPrincesa;

public class Personaje {
    private String nombre;
    private boolean esDragon;

    public Personaje(String nombre, boolean esDragon) {
        this.nombre = nombre;
        this.esDragon = esDragon;
    }

    public boolean esPrincesa(){
        return !esDragon;
    }
    public boolean esDragon(){
        return esDragon;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", esDragon=" + esDragon +
                '}';
    }
}
