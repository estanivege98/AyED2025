package TP3.Ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import TP3.Ejercicio1.GeneralTree;
import TP1.Ejercicio8.*;
public class ParcialArboles {


    /* Implemente la clase ParcialArboles, y el método:
public static List<Integer> resolver(GeneralTree<Integer> arbol)
que recibe un árbol general de valores enteros, que solo pueden ser 0 o 1 y devuelve una lista con los
valores que componen el “camino filtrado de valor máximo”, se llama “filtrado” porque sólo se agregan al
camino los valores iguales a 1 (los 0 no se agregan), mientras que es “de valor máximo” porque se obtiene
de realizar el siguiente cálculo: es la suma de los valores de los nodos multiplicados por su nivel. De haber
más de uno, devolver el primero que se encuentre.
Por ejemplo, para el árbol general que aparece en el gráfico, el resultado de la invocación al método
resolver debería devolver una lista con los valores: 1, 1, 1 , y NO 1, 0 , 1, 1 dado que filtramos el valor 0.
Con esa configuración se obtiene el mayor valor según el cálculo: 1*0 + 0*1 + 1*2 + 1*3
(El camino 1*0+1*1+0*2+0*3+1*4 también da 5, pero no es el primero)
 Nota: No puede generar la lista resultado con 0 / 1 y en un segundo recorrido eliminar los elementos con
valor 0*/

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> lista = new ArrayList<Integer>();
        List<Integer> listaAct = new ArrayList<Integer>();
        if (arbol.isEmpty()) {
            return lista;
        } else {
            int suma = 0;
            Maximo max = new Maximo();
            recorrido(arbol, lista ,listaAct, suma, 0, max);
            return lista;
        }

    }

        private static void recorrido (GeneralTree<Integer> arbol, List<Integer> lista,List<Integer> listaAct, int suma, int nivel, Maximo max){
            if(arbol.getData() == 1){
                listaAct.add(arbol.getData());
                suma += arbol.getData() * nivel;
            }
            if(arbol.isLeaf()){
                if(suma > max.getMaximo()){
                    max.setMaximo(suma);
                    lista.clear();
                    lista.addAll(listaAct);
                }
            }
            else{
                for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                    recorrido(hijo, lista, listaAct, suma, nivel + 1, max);
                }
            }
            if(!listaAct.isEmpty()){
                listaAct.removeLast();
            }
        }

    public static void main(String[] args){
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);

        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);

        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);

        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);

        System.out.println(resolver(a));

    }
    }

