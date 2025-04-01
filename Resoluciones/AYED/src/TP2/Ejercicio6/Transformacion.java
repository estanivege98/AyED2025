package TP2.Ejercicio6;

import TP2.Ejercicio1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma(){
        if(arbol == null){
            return null;
        }

        sumaRecursiva(arbol);
        return arbol;
    }

    private int sumaRecursiva(BinaryTree<Integer> arbol){
        int suma = 0;

        if(arbol.isLeaf()){
            suma += arbol.getData();
            arbol.setData(0);
            return suma;
        }
        else{
            if(arbol.getLeftChild() != null){
                suma += sumaRecursiva(arbol.getLeftChild());
            }
            if(arbol.getRightChild() != null){
                suma += sumaRecursiva(arbol.getRightChild());
            }

        }
        int valorAct = arbol.getData();
        arbol.setData(suma);
        return valorAct + suma;
    }
}
