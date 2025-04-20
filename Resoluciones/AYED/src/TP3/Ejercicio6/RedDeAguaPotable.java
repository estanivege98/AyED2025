package TP3.Ejercicio6;

import TP3.Ejercicio1.GeneralTree;

// Consultar

public class RedDeAguaPotable {
    private GeneralTree<Character> red;

    public RedDeAguaPotable(GeneralTree<Character> red){
        this.red = red;
    }

    public double minimoCaudal(double caudal){
        if(this.red.isEmpty()){
            return 0;
        }
        else{
            return (!red.isLeaf()) ? minimoCaudalRec(this.red, caudal) : caudal;
        }
    }

    private double minimoCaudalRec(GeneralTree<Character> arbol, double caudal){
        if(arbol.isLeaf()){
            return caudal;
        }
        double cantCaudal = caudal / arbol.getChildren().size();
        double minCaudal = Integer.MAX_VALUE;
        for(GeneralTree<Character> hijo : arbol.getChildren()){
            double caudalHijo = minimoCaudalRec(hijo, cantCaudal);
            minCaudal = Math.min(minCaudal, caudalHijo);
        }
        return minCaudal;
    }
}
