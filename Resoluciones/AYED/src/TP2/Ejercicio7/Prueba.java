package TP2.Ejercicio7;
import TP2.Ejercicio1.*;
public class Prueba {
    public static void main(String[] args) {
        // nivel 0
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
        // nivel 1
        BinaryTree<Integer> izq = new BinaryTree<Integer>(7);
        BinaryTree<Integer> der = new BinaryTree<Integer>(-5);
        arbol.addLeftChild(izq);
        arbol.addRightChild(der);
        // nivel 2
        izq.addLeftChild(new BinaryTree<Integer>(23));
        izq.addRightChild(new BinaryTree<Integer>(6));
        der.addLeftChild(new BinaryTree<>(19));
        // nivel 3
        izq.getLeftChild().addLeftChild(new BinaryTree<>(-3));
        izq.getRightChild().addLeftChild(new BinaryTree<>(55));
        izq.getRightChild().addRightChild(new BinaryTree<>(11));
        der.getLeftChild().addRightChild(new BinaryTree<>(4));

        // nivel 4
        der.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(18));

        // Prueba
        ParcialArboles pa = new ParcialArboles(arbol);
       System.out.println(pa.isLeftTree(7));
       System.out.println(pa.isLeftTree(2));
       System.out.println(pa.isLeftTree(-5));
       System.out.println(pa.isLeftTree(19));
       System.out.println(pa.isLeftTree(-3));
    }
}
