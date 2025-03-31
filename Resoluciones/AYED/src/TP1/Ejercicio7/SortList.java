package TP1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> l1, ArrayList<Integer> l2){
        ArrayList<Integer> l = new ArrayList<Integer>();

        int indice1 = 0;
        int indice2 = 0;

        while (indice1 < l1.size() -1 && indice2 < l2.size() - 1){
            if(l1.get(indice1) < l2.get(indice2)){
                l.add(l1.get(indice1));
                indice1++;
            }
            else{
                l.add(l2.get(indice2));
                indice2++;
            }
        }

        while(indice1 < l1.size()){
            l.add(l1.get(indice1));
            indice1++;
        }
        while (indice2 < l2.size()){
            l.add(l2.get(indice2));
            indice2++;
        }
        return l;
    }
}
