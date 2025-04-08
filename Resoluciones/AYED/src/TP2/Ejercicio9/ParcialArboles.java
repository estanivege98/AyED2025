package TP2.Ejercicio9;
import TP2.Ejercicio1.*;
public class ParcialArboles {
    public BinaryTree<Dato> sumAndDif(BinaryTree<Integer> arbol){
        if(arbol.isEmpty()){
            return null;
        }
        else{
            BinaryTree<Dato> nevoArbol = new BinaryTree<Dato>();
            sumAndDifRec(arbol, nevoArbol);
        }
        return nevoArbol;
    }

    private void sumAndDifRec(BinaryTree<Integer> arbol, BinaryTree<Dato> nuevoArbol){
        BinaryTree<Dato> izq = new BinaryTree<Dato>();
        BinaryTree<Dato> der = new BinaryTree<Dato>();
    }
}
