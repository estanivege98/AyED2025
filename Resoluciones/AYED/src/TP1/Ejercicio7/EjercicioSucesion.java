// Ejercicios 7g

package TP1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
    public static List<Integer> calcularSucesion(int n){
        List<Integer> l = new ArrayList<Integer>();
        calculoSucesionRec(l,n);
        return l;
    }

    private static void calculoSucesionRec(List<Integer> l, int n){
        l.add(n);
        if(n>1){
            if (n%2==0) calculoSucesionRec(l, n/2);
            else calculoSucesionRec(l, (3*n)+1);
        }
    }


}
