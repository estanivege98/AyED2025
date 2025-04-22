package TP3.Ejercicio7;

import TP3.Ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Camino {
    GeneralTree<Integer> arbol;

    public Camino(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> caminoAHojaMasLejana(){
        if(this.arbol.isEmpty()){
            return new ArrayList<Integer>();
        }
        else{
            List<Integer> lista = new ArrayList<Integer>();
            hojaMasLejana(this.arbol, lista, new ArrayList<Integer>());
            return lista;
        }

    }

    private void hojaMasLejana(GeneralTree<Integer> arbol, List<Integer>lista, List<Integer> listaAct){
        listaAct.add(arbol.getData());
        if(arbol.isLeaf()){
            if(lista.size() < listaAct.size()){
                lista.clear();
                lista.addAll(listaAct);
            }
        }
        else{
            for(GeneralTree<Integer> hijo : arbol.getChildren()){
                hojaMasLejana(hijo, lista, listaAct);
            }
        }
        listaAct.remove(listaAct.size()-1);

    }
}
