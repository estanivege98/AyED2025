package Parciales.Parcial1EraFecha2024;

import TP3.Ejercicio1.GeneralTree;
import TP1.Ejercicio8.*;

import java.util.List;
import java.util.ArrayList;
public class ParcialArboles {
    public GeneralTree<Integer> arbol;

//    public List<Integer> nivel(int num) {
//        GeneralTree<Integer> abAux = new GeneralTree<Integer>();
//        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
//        List<Integer> lista = new ArrayList<Integer>();
//        cola.enqueue(abAux);
//        cola.enqueue(null);
//        boolean corta = true;
//        while(!cola.isEmpty()){
//            abAux = cola.dequeue();
//            if(abAux != null){
//                lista.add(abAux.getData());
//                if((abAux.getChildren().size() < num) && (abAux.getChildren().size() > num)){
//                    corta = false;
//                }
//                for(GeneralTree<Integer> hijos: abAux.getChildren()){
//                    cola.enqueue(hijos);
//                }
//            }
//            if(corta){
//                return lista;
//            }
//            else{
//                lista.clear();
//                cola.enqueue(null);
//                corta = true;
//            }
//        }
//        return new ArrayList<>();
//    }

    public List<Integer> nivel(int num){
        GeneralTree<Integer> abAux = new GeneralTree<Integer>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(abAux);
        cola.enqueue(null);
        int cantNodos = 0;
        boolean corte = false;
        List<Integer> listaAct = new ArrayList<>();
        List<Integer> listaNodos = new ArrayList<>();
        boolean cumpleNivel = false;
        while(!cola.isEmpty() && !corte){
            abAux = cola.dequeue();
            if(abAux != null){
                if(abAux.getChildren().size() == num){
                    cumpleNivel = true;
                }
                listaAct.add(abAux.getData());
                for(GeneralTree<Integer> nodo : abAux.getChildren()){
                    cola.enqueue(nodo);
                }
            }
            else{
                if(cumpleNivel){
                    //listaNodos.clear();
                    listaNodos.addAll(listaAct);
                    corte = true;
                }
                else{
                    listaAct.clear();
                }
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }
        }
        return listaNodos;
    }
}
