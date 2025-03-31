package TP1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
// ejercicio 7h
public class InvertirLista {

    public static void invertirArrayList(ArrayList<Integer> lista){
        //List<Integer> l = new ArrayList<Integer>();
        invertirArrayListRec(lista, 0, lista.size() - 1);
    }

    private static void invertirArrayListRec(ArrayList<Integer> lista, int i, int j){
        if(i < j){
            int aux = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, aux);
            invertirArrayListRec(lista, i + 1, j - 1);
        }
    }
}
