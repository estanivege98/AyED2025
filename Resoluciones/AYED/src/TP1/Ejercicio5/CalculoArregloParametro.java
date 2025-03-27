package TP1.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class CalculoArregloParametro {
    private List<Integer> arreglo = new ArrayList<Integer>();

    public void maximo(Datos d){
        d.setMax(Integer.MIN_VALUE);
        for(Integer i : arreglo){
            if(i > d.getMax()){
                d.setMax(i);
            }
        }
    }

    public void minimo(Datos d){
        d.setMin(Integer.MAX_VALUE);
        for(Integer i : arreglo){
            if(i < d.getMin()){
                d.setMin(i);
            }
        }
    }

    public void promedio(Datos d){
        double sum = 0;
        for(Integer i : arreglo){
            sum += i;
        }
        d.setPromedio(sum / arreglo.size());
    }

    public static void main(String[] args) {
        CalculoArregloParametro calculo = new CalculoArregloParametro();
        Datos d = new Datos();
        calculo.arreglo.add(1);
        calculo.arreglo.add(2);
        calculo.arreglo.add(3);
        calculo.arreglo.add(4);
        calculo.arreglo.add(5);
        calculo.maximo(d);
        calculo.minimo(d);
        calculo.promedio(d);
        System.out.println(d);
    }
}
