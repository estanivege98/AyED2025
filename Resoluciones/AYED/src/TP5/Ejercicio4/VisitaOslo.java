/* Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por un
conjunto de lugares que están restringidos.
Escriba una clase llamada VisitaOslo e implemente su método:
paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) :
List<String>*/
package TP5.Ejercicio4;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import TP5.ejercicio1.*;

public class VisitaOslo {
    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
        List<String> recorrido = new ArrayList<String>();
        if (lugares == null || lugares.isEmpty()) {
            return recorrido; // Retorna una lista vacía si los parámetros son nulos
        } else {
            boolean[] marcas = new boolean[lugares.getSize()];
            Vertex<String> origen = lugares.search("Ayuntamiento");
            Vertex<String> des = lugares.search(destino);
            if (origen != null || destino != null){
                marcarRestringidos(lugares, lugaresRestringidos, marcas);
                recorridoAux(lugares, origen, des, recorrido, 0, marcas);
            }

        }
        return recorrido;
    }

    private void marcarRestringidos(Graph<String> lugares, List<String> lugaresRestringidos, boolean[] marcas) {
        for (String nom : lugaresRestringidos) {
            Vertex<String> v = lugares.search(nom);
            if (v != null) {
                marcas[v.getPosition()] = true;
            }
        }
    }
/* Codigo ineficiente, al cumplir deberia detener la ejecucion */
//    private boolean recorridoAux(Graph<String> lugares, Vertex<String> origen, Vertex<String> destino, int maxTiempo,
//                              List<String> lugaresRestringidos, List<String> recorrido, int tiempoActual, boolean[] marcas) {
//        boolean encontrado = false;
//        marcas[origen.getPosition()] = true; // Marca el origen como visitado
//        recorrido.add(origen.getData()); // Agrega el origen al recorrido
//        if (origen == destino){
//            return true;
//        }
//        else{
//            List<Edge<String>> adyacentes = lugares.getEdges(origen);
//            for(Edge<String> adyacente : adyacentes){
//                Vertex<String> vecino = adyacente.getTarget();
//                int tiempoArista = adyacente.getWeight();
//                if(marcas[vecino.getPosition()] && tiempoActual - tiempoArista >= 0){
//                    encontrado = recorridoAux(lugares, vecino, destino, maxTiempo, lugaresRestringidos, recorrido, tiempoActual - tiempoArista, marcas);
//                }
//            }
//        }
//        if(!encontrado){
//            recorrido.remove(recorrido.size()-1);
//        }
//        marcas[origen.getPosition()] = false; // Desmarca el origen al retroceder
//        return encontrado;
//
//    }

    private boolean recorridoAux(Graph<String> lugares, Vertex<String> origen, Vertex<String> destino,
                                 List<String> recorrido, int tiempoActual, boolean[] marcas) {
        boolean encontrado = false;
        marcas[origen.getPosition()] = true;
        recorrido.add(origen.getData());
        if (origen == destino) {
            return true;
        }
        else{
            List<Edge<String>> adyacentes = lugares.getEdges(origen);
            Iterator<Edge<String>> iterator = adyacentes.iterator();
            while(iterator.hasNext() && !encontrado){
                Edge<String> adyacente = iterator.next();
                Vertex<String> vecino = adyacente.getTarget();
                int tiempoArista = adyacente.getWeight();
                if(!marcas[vecino.getPosition()] && tiempoActual - tiempoArista >= 0){
                    encontrado = recorridoAux(lugares, vecino, destino, recorrido, tiempoActual, marcas);
                }
            }
        }
        if (!encontrado) {
            recorrido.remove(recorrido.size() - 1);
        }
        marcas[origen.getPosition()] = false; // Desmarca el origen al retroceder
        return encontrado;
    }
}
