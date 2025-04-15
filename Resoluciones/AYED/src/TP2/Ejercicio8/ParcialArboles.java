package TP2.Ejercicio8;
import TP2.Ejercicio1.*;
public class ParcialArboles {
    private BinaryTree<Integer> arbol1;
    private BinaryTree<Integer> arbol2;
    public ParcialArboles(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        this.arbol1 = arbol1;
        this.arbol2 = arbol2;
    }
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if(arbol1.isEmpty() || arbol2.isEmpty()){
            return false;
        }
        if(!arbol1.getData().equals(arbol2.getData())){
            return false;
        }
        else{
            //boolean esPrefijo = true;
            return esPrefijoRec(arbol1, arbol2);
            //return esPrefijo;
        }
    }

    private boolean esPrefijoRec(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean esPrefijoIzq = true;
        boolean esPrefijoDer = true;

        if(!arbol1.getData().equals(arbol2.getData()) || arbol2.isEmpty()){
            return false;
        }
        else{
            if(arbol1.hasLeftChild() && arbol2.hasLeftChild()){
                esPrefijoIzq = esPrefijoRec(arbol1.getLeftChild(), arbol2.getLeftChild());
            }
            if(arbol1.hasRightChild() && arbol2.hasRightChild()){
                esPrefijoDer = esPrefijoRec(arbol1.getRightChild(), arbol2.getRightChild());
            }

            return esPrefijoIzq && esPrefijoDer;
        }

    }
}
