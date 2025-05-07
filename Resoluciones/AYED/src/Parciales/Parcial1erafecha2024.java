package Parciales;

import TP3.Ejercicio1.GeneralTree;
import TP1.Ejercicio8.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class Parcial1erafecha2024 {
    public GeneralTree<Integer> arbol;

    public List<Integer> nivel(int num) {
        GeneralTree<Integer> abAux = new GeneralTree<Integer>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        List<Integer> lista = new ArrayList<Integer>();
        cola.enqueue(abAux);
        cola.enqueue(null);
        boolean corta = true;
        while(!cola.isEmpty()){
            abAux = cola.dequeue();
            if(abAux != null){
                lista.add(abAux.getData());
                if((abAux.getChildren().size() < num) && (abAux.getChildren().size() > num)){
                    corta = false;
                }
                for(GeneralTree<Integer> hijos: abAux.getChildren()){
                    cola.enqueue(hijos);
                }
            }
            if(corta){
                return lista;
            }
            else{
                lista.clear();
                cola.enqueue(null);
                corta = true;
            }
        }
        return new ArrayList<>();
    }
}
