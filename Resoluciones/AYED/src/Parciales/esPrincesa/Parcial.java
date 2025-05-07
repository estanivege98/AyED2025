package Parciales.esPrincesa;
/* Las operaciones esDragon()\: boolean y esPrincesa(): boolean permiten averiguar si un persona es un
dragón o una princesa respectivamente
Suponemos que ningún personaje es un dragón y princesa a la vez y que un persona puede no ser
ninguna de las dos cosas. Dado un árbol binario de personajes, se denominan nodos accesibles a
aquellos nodos tales que a lo largo de la raíz hasta la hoja NO se encuentra ningún dragón
Debe implementar un método princesaAccesible(): Personaje en la clase árbol binario que encunetre
una princesa accesible */
import java.util.ArrayList;
import java.util.List;
import TP2.Ejercicio1.*;
public class Parcial {
    private BinaryTree<Personaje> arbol;

    public Personaje princesaAccesible() {
        if(arbol == null || arbol.isEmpty()){
            return null;
        }
        Personaje personaje = null;
        helper(arbol, true, personaje);
        return personaje;
    }

    private void helper(BinaryTree<Personaje> arbol, boolean esAccesible, Personaje personaje) {
        if(arbol.getData().esPrincesa()){
            personaje = arbol.getData();
        }
        else if(arbol.getData().esDragon()){
            esAccesible = false;
        }
        else{
            if(arbol.hasLeftChild() && esAccesible){
                helper(arbol.getLeftChild(), esAccesible, personaje);
            }
            if(arbol.hasRightChild() && esAccesible){
                helper(arbol.getRightChild(), esAccesible, personaje);
            }
        }
    }
}
