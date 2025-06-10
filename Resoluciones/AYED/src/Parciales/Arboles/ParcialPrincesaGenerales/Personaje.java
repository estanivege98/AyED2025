package Parciales.Arboles.ParcialPrincesaGenerales;

public class Personaje {
    private String nombre;
    private String tipo;

    public Personaje(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public boolean esDragon(){
        return tipo.equals("Dragon");
    }

    public boolean esPrincesa(){
        return tipo.equals("Princesa");
    }
}
