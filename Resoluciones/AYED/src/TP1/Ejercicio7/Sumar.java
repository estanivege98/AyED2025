package TP1.Ejercicio7;

import java.util.LinkedList;

public class Sumar {

    public static int sumarLinkedList(LinkedList<Integer> l){

        return sumarLinkedListRec(l, l.size()-1 );

    }

    private static int sumarLinkedListRec(LinkedList<Integer> l, int i){
        if (i<0){
            return 0;
        }
        else{
            return l.get(i) + sumarLinkedListRec(l, i-1);
        }
    }
}
