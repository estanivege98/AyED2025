package Parciales.ParcialProgramacionIII;
import TP3.Ejercicio1.GeneralTree;
import TP1.Ejercicio8.*;
public class ParcialArboles {
    public GeneralTree<String> tesoroAccesibleMasCercano(GeneralTree<String> arbol){
        if(arbol == null || arbol.isEmpty()){
            return null;
        }
        GeneralTree<String> arbolAux = new GeneralTree<>();
        Queue<GeneralTree<String>> cola = new Queue<GeneralTree<String>>();
        cola.enqueue(arbol);
        cola.enqueue(null);

        while(!cola.isEmpty()){
            arbolAux = cola.dequeue();
            if(arbolAux != null){
                if(arbolAux.getData().equals("Tesoro")){
                    return arbolAux;
                }
                for(GeneralTree<String> hijo : arbolAux.getChildren()){
                    if(!hijo.equals("Bloqueo")){
                        cola.enqueue(hijo);
                    }
                }
            }

            if(!cola.isEmpty()){
                cola.enqueue(null);
            }
        }

        return new GeneralTree<String>();
    }
}
