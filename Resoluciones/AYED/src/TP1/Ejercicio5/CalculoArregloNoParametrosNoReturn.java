package TP1.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class CalculoArregloNoParametrosNoReturn {
    private List<Integer> arreglo = new ArrayList<Integer>();
    private Datos d= new Datos();

    public void maximo(){
        d.setMax(Integer.MIN_VALUE);
        for(Integer i : arreglo){
            if(i > d.getMax()){
                d.setMax(i);
            }
        }
    }

    public void minimo(){
        d.setMin(Integer.MAX_VALUE);
        for(Integer i : arreglo){
            if(i < d.getMin()){
                d.setMin(i);
            }
        }
    }

    public void promedio(){
        double sum = 0;
        for(Integer i : arreglo){
            sum += i;
        }
        d.setPromedio(sum / arreglo.size());
    }

    public static void main(String[] args) {
        CalculoArregloNoParametrosNoReturn calculo = new CalculoArregloNoParametrosNoReturn();
        calculo.arreglo.add(1);
        calculo.arreglo.add(2);
        calculo.arreglo.add(3);
        calculo.arreglo.add(4);
        calculo.arreglo.add(5);
        calculo.maximo();
        calculo.minimo();
        calculo.promedio();
        System.out.println("Maximo: " + calculo.d.getMax());
        System.out.println("Minimo: " + calculo.d.getMin());
        System.out.println("Promedio: " + calculo.d.getPromedio());
    }
}
