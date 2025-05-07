package Parciales.esPrincesa;

import TP2.Ejercicio1.*;
public class ParcialV2 {
    private BinaryTree<Personaje> arbol;

    public Personaje princesaAccesible() {
        if(arbol == null || arbol.isEmpty()){
            return null;
        }
        Personaje personaje = null;
        //boolean encontrado = false;
        helper(arbol, true, personaje);
        return personaje;
    }

    private boolean helper(BinaryTree<Personaje> arbol, boolean esAccesible, Personaje personaje) {
        boolean encontrado = false;
        if(arbol.getData().esPrincesa()){
            personaje = arbol.getData();
            encontrado = true;
        }
        else if(arbol.getData().esDragon()){
            esAccesible = false;
        }
        else{
            if(arbol.hasLeftChild() && esAccesible){
                encontrado = helper(arbol.getLeftChild(), esAccesible, personaje);
            }
            if(arbol.hasRightChild() && esAccesible){
                encontrado = helper(arbol.getRightChild(), esAccesible, personaje);
            }
        }
        return encontrado;
    }
}
