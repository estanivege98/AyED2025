package TP2.Ejercicio7;
import TP2.Ejercicio1.*;
public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num) {
        if (arbol == null || arbol.isEmpty()){
            return false;
        }

        else {
            BinaryTree<Integer> nodo = buscarNodo(arbol, num);
            if (nodo.isEmpty()){
                return false;
            }
            BinaryTree<Integer> izq = nodo.hasLeftChild() ? nodo.getLeftChild() : null;
            BinaryTree<Integer> der = nodo.hasRightChild() ? nodo.getRightChild() : null;

            int cantIzq = (izq != null) ? contarSoloHijo(izq) : -1;
            int cantDer = (der != null) ? contarSoloHijo(der) : -1;
            return cantIzq > cantDer;
        }
    }

    private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> arbol, int num) {
        BinaryTree<Integer> aux = new BinaryTree<Integer>();
        if(arbol.getData().equals(num)){
            return arbol;
        }
        else{
            if(arbol.hasLeftChild()){
                aux = buscarNodo(arbol.getLeftChild(), num);
            }
            if(aux.isEmpty() && arbol.hasRightChild()){
                    aux = buscarNodo(arbol.getRightChild(), num);
                }
            }
        return aux;
    }

    private int contarSoloHijo(BinaryTree<Integer> arbol) {
        int cant = 0;
        if(arbol.hasLeftChild()){
            cant = contarSoloHijo(arbol.getLeftChild());
        }
        if(arbol.hasRightChild()){
            cant += contarSoloHijo(arbol.getRightChild());
        }
        if(arbol.getLeftChild() == null ^ arbol.getRightChild() == null){
            // XOR, para reemplazar el if largo de
            // if((!arbol.hasLeftChild() && arbol.hasRightChild()) || (arbol.hasLeftChild() && !arbol.hasRightChild())){
            cant++;
        }
        return cant;
    }
}
