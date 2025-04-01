package TP2.Ejercicio3;
import TP2.Ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol() {
        this.arbol = new BinaryTree<>();
    }

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> numerosParesPreOrden(){
        if(!arbol.isEmpty()){
            List<Integer> lista = new ArrayList<Integer>();
            preOrden(arbol, lista);
            return lista;
        }
        return null;
    }

    private void preOrden(BinaryTree<Integer> arbol, List<Integer> lista){
        if(arbol.getData() % 2 == 0){
            lista.add(arbol.getData());
        }
        if(arbol.hasLeftChild()){
            preOrden(arbol.getLeftChild(), lista);
        }
        if(arbol.hasRightChild()){
            preOrden(arbol.getRightChild(), lista);
        }
    }

    public List<Integer> numerosParesPostOrden(){
        if(!arbol.isEmpty()){
            List<Integer> lista = new ArrayList<Integer>();
            postOrden(arbol, lista);
            return lista;
        }
        return null;
    }

    private void postOrden(BinaryTree<Integer> arbol, List<Integer> lista){
        if(arbol.getData() % 2 == 0){
            lista.add(arbol.getData());
        }
        if(arbol.hasLeftChild()){
            postOrden(arbol.getLeftChild(), lista);
        }
        if(arbol.hasRightChild()){
            postOrden(arbol.getRightChild(), lista);
        }
    }
}
