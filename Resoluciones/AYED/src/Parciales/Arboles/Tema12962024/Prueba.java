package Parciales.Arboles.Tema12962024;
import TP2.Ejercicio1.*;
public class Prueba {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
        BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(2);
        BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(3);
        arbol.addLeftChild(hijoIzq);
        arbol.addRightChild(hijoDer);

        BinaryTree<Integer> hijoIzqIzq = new BinaryTree<Integer>(4);
        hijoIzq.addLeftChild(hijoIzqIzq);

        BinaryTree<Integer> hijoDerIzq = new BinaryTree<Integer>(5);
        BinaryTree<Integer> hijoDerDer = new BinaryTree<Integer>(6);
        hijoDer.addLeftChild(hijoDerIzq);
        hijoDer.addRightChild(hijoDerDer);

        BinaryTree<Integer> ultimo = new BinaryTree<Integer>(7);
        hijoDer.getLeftChild().addLeftChild(ultimo);

        ParcialArboles parcial = new ParcialArboles(arbol);
        BinaryTree<Integer> nuevoArbol = parcial.nuevoTree();
        nuevoArbol.entreNiveles(0, 3);
    }
}
