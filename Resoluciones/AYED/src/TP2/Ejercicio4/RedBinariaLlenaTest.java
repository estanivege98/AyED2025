package TP2.Ejercicio4;
import TP2.Ejercicio1.*;
public class RedBinariaLlenaTest {
    public static void main(String[] args) {
        System.out.println("Test Mayor Retardo");
        // Nivel 0
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
        BinaryTree<Integer> izq = new BinaryTree<Integer>(2);
        BinaryTree<Integer> der = new BinaryTree<Integer>(3);
        arbol.addLeftChild(izq);
        arbol.addRightChild(der);
        // Nivel 1
        izq.addLeftChild(new BinaryTree<Integer>(5));
        izq.addRightChild(new BinaryTree<Integer>(4));
        der.addLeftChild(new BinaryTree<Integer>(9));
        der.addRightChild(new BinaryTree<Integer>(8));
        // Nivel 2
        izq.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        izq.getLeftChild().addRightChild(new BinaryTree<Integer>(8));
        izq.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        izq.getRightChild().addRightChild(new BinaryTree<Integer>(6));
        der.getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
        der.getLeftChild().addRightChild(new BinaryTree<Integer>(8));
        der.getRightChild().addLeftChild(new BinaryTree<Integer>(2));
        der.getRightChild().addRightChild(new BinaryTree<Integer>(1));

        RedBinariaLlena red = new RedBinariaLlena(arbol);
        System.out.println("Retardo mayor: " + red.retardoReenvio());
    }
}
