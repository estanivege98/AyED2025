package TP3.Ejercicio9;

import TP3.Ejercicio1.GeneralTree;

public class ParcialArboles {
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }
        else{
            return seleccion(arbol, arbol.getData());
        }
    }

    private static boolean seleccion(GeneralTree<Integer> arbol, int datoPadre){
        if(arbol.getData() > datoPadre){
            return false;
        }
        else{
            for(GeneralTree<Integer> child : arbol.getChildren()){
                if(!seleccion(child, arbol.getData())){
                    return false;
                }
            }
        }
        return true;
    }
}
