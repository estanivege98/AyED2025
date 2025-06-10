package Parciales.Arboles.esPrincesa;

import TP2.Ejercicio1.*;
public class ParcialV2 {
    private BinaryTree<Personaje> arbol;

    public Personaje princesaAccesible() {
        if(arbol == null || arbol.isEmpty()){
            return null;
        }
        return helper(arbol);
    }

    private Personaje helper(BinaryTree<Personaje> arbol) {
        Personaje persona = null;
        if(!arbol.getData().esDragon()){
            if(arbol.getData().esPrincesa()){
                persona = arbol.getData();
            }
            else{
                if(arbol.hasLeftChild()){
                    persona = helper(arbol.getLeftChild());
                }
                if(arbol.hasRightChild() && persona == null){
                    persona = helper(arbol.getRightChild());
                }
            }
        }
        return persona;
    }
}
