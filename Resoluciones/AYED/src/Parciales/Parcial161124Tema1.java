package Parciales;
import TP3.Ejercicio1.GeneralTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Parcial161124Tema1 {
    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(arbol1.isEmpty() || arbol2.isEmpty()){
            return false;
        }
        else{
            return recorrido(arbol1, arbol2);
        }
    }
    private boolean recorrido(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        boolean ok= true;
        if(arbol1.getData()>=arbol2.getData()){
            ok = false;
        }
        if(arbol1.isLeaf() && arbol2.isLeaf()){
            return ok;
        }
        if(arbol1.isLeaf() && !arbol2.isLeaf()){
            return ok;
        }
        if(!arbol1.isLeaf() && arbol2.isLeaf()){
            return false;
        }

            List<GeneralTree<Integer>> hijos1 = new ArrayList<GeneralTree<Integer>>();
            List<GeneralTree<Integer>> hijos2 = new ArrayList<GeneralTree<Integer>>();
            int cont1=0;
            int cont2=0;
            for(GeneralTree<Integer> hijo: arbol1.getChildren()){
                hijos1.add(hijo);
                cont1+=hijo.getData();
            }
            for(GeneralTree<Integer> hijo: arbol2.getChildren()){
                hijos2.add(hijo);
                cont2+=hijo.getData();
            }
            if(cont2 <= cont1){
                return false;
            }
            Iterator<GeneralTree<Integer>> it1 = hijos1.iterator();
            Iterator<GeneralTree<Integer>> it2 = hijos2.iterator();
            while((it1.hasNext() && it2.hasNext()) && (ok)){
                GeneralTree<Integer> hijo1 = it1.next();
                GeneralTree<Integer> hijo2 = it2.next();
                ok = recorrido(hijo1, hijo2);
            }

        return ok;
    }
}
