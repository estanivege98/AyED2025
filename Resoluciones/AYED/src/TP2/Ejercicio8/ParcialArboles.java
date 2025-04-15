package TP2.Ejercicio8;
import TP2.Ejercicio1.*;
public class ParcialArboles {

    public ParcialArboles() {
        // Constructor vacío
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
        if(arbol1 == null){
            return true;
        }
        if(!arbol1.getData().equals(arbol2.getData()) || arbol2.isEmpty()){
            return false;
        }

        else{
            boolean esPrefijoIzq = esPrefijoRec(arbol1.getLeftChild(), arbol2.getLeftChild());
            boolean esPrefijoDer = esPrefijoRec(arbol1.getRightChild(), arbol2.getRightChild());
            return esPrefijoIzq && esPrefijoDer;
        }

    }
}
