package Parciales.Arboles.Tema12962024;

import TP2.Ejercicio1.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> nuevoTree() {
        if(arbol == null || arbol.isEmpty()){
            return null;
        }
        BinaryTree<Integer> arbolNuevo = new BinaryTree<Integer>();
        //arbolNuevo.addLeftChild(arbolNuevo);
        helper(arbol, arbolNuevo, 0);
        return arbolNuevo;
    }

    private void helper(BinaryTree<Integer> arbol, BinaryTree<Integer> arbolNuevo, int valorAnt) {
        int valorAct = arbol.getData() + valorAnt;
        arbolNuevo.setData(valorAct);
        valorAnt = arbol.getData();
        if(arbol.hasLeftChild()){
            BinaryTree<Integer> nuevoHijoIzq = new BinaryTree<Integer>();
            arbolNuevo.addLeftChild(nuevoHijoIzq);
            this.helper(arbol.getLeftChild(), arbolNuevo.getLeftChild(), valorAnt);
        }
        if(arbol.hasRightChild()){
            BinaryTree<Integer> nuevoHijoDer = new BinaryTree<Integer>();
            arbolNuevo.addRightChild(nuevoHijoDer);
            this.helper(arbol.getRightChild(), arbolNuevo.getRightChild(), 0);
        }
    }
}
