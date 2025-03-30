package TP1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    //private List<Integer> arreglo = new ArrayList<Integer>();

    public static void main(String[] args) {
        List<Integer> arreglo = new ArrayList<>();
        while(args.length > 0){
            arreglo.add(Integer.parseInt(args[0]));
        }
    }
}
