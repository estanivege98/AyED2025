package TP1.Ejercicio5;

public class Datos {

    private int max;
    private int min;
    private double promedio;

    public Datos(){

    }

    public Datos(int max, int min, double promedio){
        this.max = max;
        this.min = min;
        this.promedio = promedio;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Maximo: " + max + "\nMinimo: " + min + "\nPromedio: " + promedio;
    }
}
