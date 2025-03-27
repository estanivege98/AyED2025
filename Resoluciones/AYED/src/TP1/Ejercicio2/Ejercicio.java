package TP1.Ejercicio2;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Ejercicio {

    public List<Integer> devolucion(int n){
        List<Integer> arreglo = new ArrayList<Integer>();
        int cant = Contador.contarN(n);
        int cont = 1;
        while(cant>=cont){
            arreglo.add(cont * n);
            cont++;
        }
        return arreglo;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Ejercicio e = new Ejercicio();
        System.out.println("Ingrese un numero: ");
        int n = s.nextInt();
        List<Integer> resultado = e.devolucion(n);
        for (int i = 0; i<resultado.size(); i++){
            System.out.println(resultado.get(i));
        }
    }
}
