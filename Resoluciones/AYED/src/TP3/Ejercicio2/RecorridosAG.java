package TP3.Ejercicio2;
import TP3.Ejercicio1.*;
import java.util.LinkedList;
import java.util.List;

import TP1.Ejercicio8.*;

public class RecorridosAG {

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, int n){
        List<Integer> lista = new LinkedList<Integer>();
        preOrden(a, n, lista);
        return lista;
    }

    private void preOrden(GeneralTree<Integer> a, int n, List<Integer> lista){
        if(a.getData() % 2 !=0 && a.getData() > n){
            lista.add(a.getData());
        }
        for(GeneralTree<Integer> child : a.getChildren()){
            preOrden(child, n, lista);
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,int n){
        List<Integer> lista = new LinkedList<Integer>();
        inOrden(a, n, lista);
        return lista;
    }

    private void inOrden(GeneralTree<Integer> a, int n, List<Integer> lista){
        if(a.hasChildren()){
            inOrden(a.getChildren().getFirst(), n, lista);
        }
        if(a.getData() % 2 !=0 && a.getData() > n){
            lista.add(a.getData());
        }
        boolean ok = false;
        for(GeneralTree<Integer> i : a.getChildren()) {
            if (!ok) {
                ok = true;
            }
            else{
                inOrden(i, n, lista);
            }
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,int n){
        List<Integer> lista = new LinkedList<Integer>();
        postOrden(a, n, lista);
        return lista;
    }

    private void postOrden(GeneralTree<Integer> a, int n, List<Integer> lista){
        for(GeneralTree<Integer> child : a.getChildren()){
            postOrden(child, n, lista);
        }
        if(a.getData() % 2 !=0 && a.getData() > n){
            lista.add(a.getData());
        }
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles (GeneralTree <Integer> a,int n){
        List<Integer> lista = new LinkedList<Integer>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        GeneralTree<Integer> abAux = new GeneralTree<Integer>();
        cola.enqueue(a);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            abAux = cola.dequeue();
            if(abAux != null){
                if(abAux.getData() % 2 !=0 && abAux.getData() > n){
                    lista.add(abAux.getData());
                }
                if(abAux.hasChildren()){
                    for (GeneralTree<Integer> child : abAux.getChildren()){
                        cola.enqueue(child);
                    }
                }
            }
            else{
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }
        }
        return lista;
    }


}
