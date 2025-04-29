package TP3.Ejercicio9;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import TP1.Ejercicio8.*;
import TP3.Ejercicio1.GeneralTree;
/* SE DEBE REIMPLEMENTAR EN ITERATIVO (POR NIVELES) */
public class ParcialArboles {
//    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
//        if(arbol.isEmpty()){
//            return false;
//        }
//        else{
//            return seleccion(arbol, arbol.getData());
//        }
//    }
//
//    private static boolean seleccion(GeneralTree<Integer> arbol, int datoPadre){
//
//        if(arbol.isLeaf()){
//            return true;
//        }
//        else{
//            boolean seleccion = true;
//            int min = Integer.MAX_VALUE;
//            List<GeneralTree<Integer>> hijos = arbol.getChildren();
//            Iterator<GeneralTree<Integer>> it = hijos.iterator();
//            while (it.hasNext() && (seleccion)){
//                GeneralTree<Integer> hijo = it.next();
//                min = Math.min(min, hijo.getData());
//                seleccion = seleccion(hijo, datoPadre);
//            }
//            return seleccion && (min >= datoPadre);
//
//        }
//    }

    /* Probablemente se pueda mejorar el algoritmo quitando la variable
    * contador, pero ahora no tengo ganas jajaj */

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }
        else{
            GeneralTree<Integer> abAux = new GeneralTree<Integer>();
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
            cola.enqueue(arbol);
            cola.enqueue(null);
            int datoPadre = arbol.getData();
            boolean seleccion = true;
            int contador = 0;
            while(!cola.isEmpty() && seleccion){
                abAux = cola.dequeue();
                if(abAux != null){
                    if(abAux.getData() == datoPadre){
                        contador++;
                    }
                    for(GeneralTree<Integer> hijo : abAux.getChildren()){
                        cola.enqueue(hijo);
                    }
                }
                else{
                    if(contador == 0 && !cola.isEmpty()){
                        seleccion = false;
                    }
                    if(!cola.isEmpty()){
                        cola.enqueue(null);
                        contador = 0;
                        //datoPadre = cola.dequeue().getData();
                    }
                }
            }
            return seleccion;
        }
    }

    public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);

        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);

        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);

        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);

        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);

        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);

        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);

        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));

        /*No iba a hacer otro arbol, probe seteando los datos y me daba true igual,
        la idea es descomentar esto y las otras lineas comentadas para probar el segundo
        arbol de la practica mostrado como ejemplo. Ademas de comentar los nodos con valor 12*/
        //System.out.println("Es de seleccion el segundo arbol: " + esDeSeleccion(a));
    }
}
