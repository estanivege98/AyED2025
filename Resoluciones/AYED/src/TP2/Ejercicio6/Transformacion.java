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
        if(arbol == null){
            return 0;
        }
        else{
            int sumaIzq = sumaRecursiva(arbol.getLeftChild());
            int sumaDer = sumaRecursiva(arbol.getRightChild());
            int valorAct = arbol.getData();
            arbol.setData(valorAct);
            return valorAct + sumaIzq + sumaDer;
        }
    }
}
