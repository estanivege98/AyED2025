package Parciales;

import TP3.Ejercicio1.GeneralTree;
import java.util.ArrayList;
import TP1.Ejercicio8.*;
/* Llamaremos a un árbol general creciente si en cada nivel del árbol la cantidad de nodos que hay en ese
nivel es igual al valor del nivel más 1. Es decir, el nivel 0 tiene exactamente un nodo, el nivel 1 tiene
exactamente 2 nodos, el nivel k tiene exactamente k+1 nodos. Comprobar si un árbol general es
creciente y en caso de que lo sea, retornar el nodo del árbol con mayor cantidad de hijos, en caso de
no serlo, retornar null */
public class ParcialEsCreciente {
    public GeneralTree<Integer> arbol;

    public boolean esCreciente(GeneralTree<Integer> arbol) {
        GeneralTree<Integer> abAux = new GeneralTree<Integer>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        int cont = 0;
        boolean ok = true;
        int nivel = 0;
        while(!cola.isEmpty() && ok) {
            abAux = cola.dequeue();
            if(abAux != null) {
                cont++;
                for(GeneralTree<Integer> hijos: abAux.getChildren()) {
                    cola.enqueue(hijos);
                }
            }
            if(cont > nivel+1){
                ok = false;
            }
            else{
                if(!cola.isEmpty()) {
                    cola.enqueue(null);
                    nivel++;
                    cont = 0;
                }
            }
        }
        return ok;
    }
}
