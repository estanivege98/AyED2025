package TP1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestArrayList {
    //private List<Integer> arreglo = new ArrayList<Integer>();



    public static void main(String[] args) {
        List<Integer> arreglo = new ArrayList<>();
        if (args.length > 0) {
            int aux = args.length;
            while(aux > 0){
                arreglo.add(Integer.parseInt(args[aux - 1]));
                aux--;
            }
        }
        else{
            Scanner s = new Scanner(System.in);
            System.out.println("Ingrese tamaño del arreglo");
            int n = s.nextInt();
            System.out.println("Ingrese numeros: ");
            for(int i = 0; i < n; i++){
                arreglo.add(s.nextInt());
            }

        }
        System.out.println("El arreglo ingresado es: ");
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.println(arreglo.get(i));
        }

    }
}
