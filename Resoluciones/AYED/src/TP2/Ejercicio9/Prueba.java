package TP2.Ejercicio9;
import TP2.Ejercicio1.*;
public class Prueba {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(20);
        BinaryTree<Integer> izq = new BinaryTree<Integer>(5);
        BinaryTree<Integer> der = new BinaryTree<Integer>(30);
        arbol.addLeftChild(izq);
        arbol.addRightChild(der);

        izq.addLeftChild(new BinaryTree<Integer>(-5));
        izq.addRightChild(new BinaryTree<Integer>(10));
        der.addLeftChild(new BinaryTree<Integer>(50));
        der.addRightChild(new BinaryTree<Integer>(-9));

        izq.getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        der.getLeftChild().addRightChild(new BinaryTree<Integer>(4));

        der.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));

        ParcialArboles pa = new ParcialArboles();
        BinaryTree<Dato> nuevoArbol = pa.sumAndDif(arbol);
        System.out.println("Arbol original:");
        arbol.entreNiveles(0, 5);
        System.out.println("Arbol nuevo:");
        nuevoArbol.entreNiveles(0, 5);
    }
}
