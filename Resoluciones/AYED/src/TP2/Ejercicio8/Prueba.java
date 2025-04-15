package TP2.Ejercicio8;
import TP2.Ejercicio1.*;
//import TP2.Ejercicio9.ParcialArboles;
import TP2.Ejercicio8.ParcialArboles;
public class Prueba {
    public static void main(String[] args) {
        // arbol 1
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(65);
        BinaryTree<Integer> izq1 = new BinaryTree<Integer>(37);
        BinaryTree<Integer> der1 = new BinaryTree<Integer>(81);
        arbol1.addLeftChild(izq1);
        arbol1.addRightChild(der1);
        izq1.addRightChild(new BinaryTree<Integer>(47));
        der1.addRightChild(new BinaryTree<Integer>(93));

        // arbol 2
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(65);
        BinaryTree<Integer> izq2 = new BinaryTree<Integer>(37);
        BinaryTree<Integer> der2 = new BinaryTree<Integer>(81);
        arbol2.addLeftChild(izq2);
        arbol2.addRightChild(der2);
        izq2.addLeftChild(new BinaryTree<Integer>(22));
        izq2.addRightChild(new BinaryTree<Integer>(47));
        der2.addRightChild(new BinaryTree<Integer>(93));
        der2.addLeftChild(new BinaryTree<Integer>(76));


        // prueba

        ParcialArboles pa = new ParcialArboles();
        System.out.println("Arbol 1:");
        arbol1.entreNiveles(0, 5);
        System.out.println("Arbol 2:");
        arbol2.entreNiveles(0, 5);
        System.out.println("Es prefijo: " + pa.esPrefijo(arbol1, arbol2));
    }
}
