package Parciales.Arboles.Recuperatorio7122024;

public class Compuesto {
    private String tipo;
    private int tiempo;


    public Compuesto(String tipo, int tiempo) {
        this.tipo = tipo;
        this.tiempo = tiempo;

    }

    public int getVueltas() {
        return tiempo;
    }

    public double getCompuesto(){
        if(tipo.equals("Med")){
            return 0.4;
        }
        if(tipo.equals("Hard")){
            return 0.7;
        }
        return 0;
    }


}
