package TP2.Ejercicio5;
import TP2.Ejercicio1.*;
import TP1.Ejercicio8.*;
public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        BinaryTree<Integer> abAux;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
        cola.enqueue(this.arbol);
        cola.enqueue(null);
        int nivelAct = 0;
        int suma = 0;
        while (!cola.isEmpty()) {
            //int suma = 0;
            abAux = cola.dequeue();
            if(abAux != null){
                if(nivelAct == p){
                    suma += abAux.getData();
                }
                if(abAux.hasLeftChild()){
                    cola.enqueue(abAux.getLeftChild());
                }
                if(abAux.hasRightChild()){
                    cola.enqueue(abAux.getRightChild());
                }
            }
            else if(!cola.isEmpty()){
                nivelAct++;
                cola.enqueue(null);
            }
        }
        return suma;
    }
}
