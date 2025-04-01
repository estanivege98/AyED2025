package TP2.Ejercicio4;
import TP2.Ejercicio1.*;
public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio(){
        if(arbol.isEmpty()){
            return 0;
        }
        else{
            //int retardoMayor = Integer.MIN_VALUE;
            return retardoReenvioRec(arbol);
        }
    }

    private int retardoReenvioRec(BinaryTree<Integer> arbol){
        if(arbol.isLeaf()){
            return arbol.getData();
        }
        else{
            int retardoIzq = retardoReenvioRec(arbol.getLeftChild());
            int retardoDer = retardoReenvioRec(arbol.getRightChild());
            return arbol.getData() + Math.max(retardoIzq, retardoDer);
        }
    }
}
