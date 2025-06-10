package Parciales.Arboles.Redictado2022;
import TP2.Ejercicio1.BinaryTree;
import java.util.ArrayList;
import java.util.List;
public class ParcialArboles {
    public List<Integer> resolver(BinaryTree<Integer> arbol, int min){
        if(arbol == null || arbol.isEmpty()){
            return new ArrayList<>();
        }
        List<Integer> camino = new ArrayList<Integer>();
        List<Integer> camAct = new ArrayList<Integer>();
        recorrido(arbol, camino, camAct, min, 0);
        return camino;
    }

    private boolean recorrido(BinaryTree<Integer> arbol, List<Integer> camino, List<Integer> camAct, int min, int cantPares){
        if(arbol.getData() % 2 == 0){
            cantPares++;
        }
        camAct.add(arbol.getData());
        if(arbol.isLeaf()){
            if(cantPares >= min){
                camino.clear();
                camino.addAll(new ArrayList<Integer>(camAct));
                return true;
            }
        }
        else{
            if(arbol.hasLeftChild() && recorrido(arbol.getLeftChild(), camino, camAct, min, cantPares)){
               return true;
            }
            if(arbol.hasRightChild() && recorrido(arbol.getRightChild(), camino, camAct, min, cantPares)){
                return true;
            }
        }
        camAct.remove(camAct.size() - 1);
        return false;
    }
}
