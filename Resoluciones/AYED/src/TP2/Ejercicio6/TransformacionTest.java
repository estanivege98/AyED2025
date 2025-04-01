package TP2.Ejercicio6;

import TP2.Ejercicio1.*;

public class TransformacionTest {
    public static void main(String[] args) {
        System.out.println("Test Transformacion");
        // Nivel 0
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
        BinaryTree<Integer> izq = new BinaryTree<Integer>(2);
        BinaryTree<Integer> der = new BinaryTree<Integer>(3);
        arbol.addLeftChild(izq);
        arbol.addRightChild(der);
        // Nivel 1
        izq.addRightChild(new BinaryTree<Integer>(4));
        der.addLeftChild(new BinaryTree<Integer>(5));
        der.addRightChild(new BinaryTree<Integer>(6));
        // Nivel 2
        der.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        der.getLeftChild().addRightChild(new BinaryTree<Integer>(8));

        Transformacion transformacion = new Transformacion(arbol);
        System.out.println("Arbol original: " );
        arbol.entreNiveles(0, 4);
        BinaryTree<Integer> arbolTransformado = transformacion.suma();
        System.out.println("Arbol transformado: ");
        arbolTransformado.entreNiveles(0, 4);
    }
}
