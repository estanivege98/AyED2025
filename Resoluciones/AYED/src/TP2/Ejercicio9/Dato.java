package TP2.Ejercicio9;

public class Dato {
    private int datoIzq;
    private int datoDer;

    public Dato(int datoIzq, int datoDer) {
        this.datoIzq = datoIzq;
        this.datoDer = datoDer;
    }

    public int getDatoIzq() {
        return datoIzq;
    }

    public int getDatoDer() {
        return datoDer;
    }

    public void setDatoIzq(int datoIzq) {
        this.datoIzq = datoIzq;
    }

    public void setDatoDer(int datoDer) {
        this.datoDer = datoDer;
    }

    @Override
    public String toString() {
        return "Dato [datoIzq=" + datoIzq + ", datoDer=" + datoDer + "]";
    }
}
