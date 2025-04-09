package TP2.Ejercicio9;
import TP2.Ejercicio1.*;
public class ParcialArboles {
    public BinaryTree<Dato> sumAndDif(BinaryTree<Integer> arbol){
        if(arbol.isEmpty()){
            return null;
        }
        else{
            BinaryTree<Dato> nuevoArbol = new BinaryTree<Dato>();

            sumAndDifRec(arbol, nuevoArbol, 0, 0);
            return nuevoArbol;
        }
        //return nuevoArbol;
    }

    private void sumAndDifRec(BinaryTree<Integer> arbol, BinaryTree<Dato> nuevoArbol, int valorPadre, int sumaValorOriginal){
        int valorActual = arbol.getData();
        int suma = sumaValorOriginal + valorActual;
        int resta = valorActual - valorPadre;

        Dato datoIzq = new Dato(suma, resta);

        nuevoArbol.setData(datoIzq);

        if(arbol.hasLeftChild()){

            BinaryTree<Dato> nodoIzq = new BinaryTree<Dato>();
            nuevoArbol.addLeftChild(nodoIzq);
            sumAndDifRec(arbol.getLeftChild(), nodoIzq, valorActual,suma);
        }
        if(arbol.hasRightChild()){

            BinaryTree<Dato> nodoDer = new BinaryTree<Dato>();
            nuevoArbol.addRightChild(nodoDer);
            sumAndDifRec(arbol.getRightChild(), nodoDer, valorActual,suma);
        }
    }
}
