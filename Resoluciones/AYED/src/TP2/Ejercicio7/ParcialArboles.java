package TP2.Ejercicio7;
import TP2.Ejercicio1.*;
public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num) {
        if (arbol.isEmpty()){
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
        if(arbol == null){
            return null;
        }
        else{
            if(arbol.getData().equals(num)){
                return arbol;
            }
            else{
                BinaryTree<Integer> izq = buscarNodo(arbol.getLeftChild(), num);
                if(izq != null){
                    return izq;
                }
                else{
                    return buscarNodo(arbol.getRightChild(), num);
                }
            }
        }
    }

    private int contarSoloHijo(BinaryTree<Integer> arbol) {
        if(arbol == null){
            return 0;
        }
        else{
            int cantIzq = contarSoloHijo(arbol.getLeftChild());
            int cantDer = contarSoloHijo(arbol.getRightChild());
            if (arbol.hasLeftChild() && !arbol.hasRightChild()) {
                return 1 + cantIzq + cantDer;
            } else if (!arbol.hasLeftChild() && arbol.hasRightChild()) {
                return 1 + cantIzq + cantDer;
            } else {
                return cantIzq + cantDer;
            }
        }
    }
}
