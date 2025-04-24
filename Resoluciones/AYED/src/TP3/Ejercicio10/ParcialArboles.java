package TP3.Ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import TP3.Ejercicio1.GeneralTree;
import TP1.Ejercicio8.*;
public class ParcialArboles {

    // realmente, no termino de entender que es lo que quieren
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
        if (arbol.isEmpty()) {
            return lista;
        } else {
            int suma = 0;
            recorrido(arbol, lista, suma, 0);
            return lista;
        }

    }

        private static void recorrido (GeneralTree<Integer> arbol, List<Integer> lista, int suma, int nivel){
            if (arbol.isLeaf()) {
                if(arbol.getData() == 1){
                    lista.add(arbol.getData());
                    suma += arbol.getData() * nivel;
                }
            }
            else{
                for(GeneralTree < Integer > hijo : arbol.getChildren()){
                    if(arbol.getData() == 1){
                        lista.add(arbol.getData());
                        suma += arbol.getData() * nivel;
                    }
                    recorrido(hijo, lista, suma, nivel+1);
                }

            }
        }
    }

