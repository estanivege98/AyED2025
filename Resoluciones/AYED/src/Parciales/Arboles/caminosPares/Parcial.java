package Parciales.Arboles.caminosPares;
/* Dado un árbol general, encontrar todos los caminos desde la raíz a una hoja, tales que la cantidad de
nodos en el camino sea un número par. Escribir el siguiente método dentro de la clase Parcial public ??
caminosPares(ArbolGeneral<Character> arbol) */
import TP3.Ejercicio1.GeneralTree;
import java.util.ArrayList;
import java.util.List;
public class Parcial {
    public List<List<Character>> caminosPares(GeneralTree<Character> arbol){
        if(arbol == null || arbol.isEmpty()){
            return null;
        }
        List<List<Character>> caminosPares =new ArrayList<>();
        List<Character> camino = new ArrayList<>();
        helper(arbol, caminosPares, camino);
        return caminosPares;
    }

    private void helper(GeneralTree<Character> arbol, List<List<Character>> caminosPares, List<Character> camino){
        camino.add(arbol.getData());
        if(arbol.isLeaf()){
            if(camino.size() % 2 == 0){
                caminosPares.add(new ArrayList<>(camino));
            }
        }
        else{
            for(GeneralTree<Character> hijo: arbol.getChildren()){
                helper(hijo, caminosPares, camino);
            }
        }
        camino.remove(camino.size()-1);
    }
}
