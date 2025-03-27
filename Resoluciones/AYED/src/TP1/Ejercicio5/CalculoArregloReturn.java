package TP1.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class CalculoArregloReturn {
    private List<Integer> arreglo = new ArrayList<Integer>();

    public Integer maximo(){
        Integer max = Integer.MIN_VALUE;
        for(Integer i : arreglo){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    public Integer minimo(){
        Integer min = Integer.MAX_VALUE;
        for(Integer i : arreglo){
            if(i < min){
                min = i;
            }
        }
        return min;
    }

    public double promedio(){
        double sum = 0;
        for(Integer i : arreglo){
            sum += i;
        }
        return sum / arreglo.size();
    }

    public static void main(String[] args) {
        CalculoArregloReturn calculo = new CalculoArregloReturn();
        calculo.arreglo.add(1);
        calculo.arreglo.add(2);
        calculo.arreglo.add(3);
        calculo.arreglo.add(4);
        calculo.arreglo.add(5);
        System.out.println("Maximo: " + calculo.maximo());
        System.out.println("Minimo: " + calculo.minimo());
        System.out.println("Promedio: " + calculo.promedio());
    }
}
