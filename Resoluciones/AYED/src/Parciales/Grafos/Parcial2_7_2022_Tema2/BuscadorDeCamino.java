package Parciales.Grafos.Parcial2_7_2022_Tema2;
import TP5.ejercicio1.*;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
public class BuscadorDeCamino {
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMinimo){
        List<String> caminoFinal = new LinkedList<String>();
        if (ciudades != null || !ciudades.isEmpty()) {
            Vertex<String> vOr = ciudades.search(origen);
            if(vOr != null){
                Vertex<String> vDestino = ciudades.search(destino);
                if (vDestino != null){

                    boolean[] visitados = new boolean[ciudades.getSize()];
                    dfs(ciudades, vOr, vDestino, caminoFinal, visitados, montoMinimo, 0);
                }
            }
        }
        return caminoFinal;
    }

    private boolean dfs(Graph<String> ciudades, Vertex<String> or,
                     Vertex<String> des, List<String> caminoActual
            ,boolean[] visitados, int montoMinimo, int montoActual){
        boolean encontrado = false;
        visitados[or.getPosition()] = true; // Marca el origen como visitado
        caminoActual.add(or.getData()); // Agrega el origen al recorrido
        if(or == des){
            return true;
        }
        else{
            List<Edge<String>> adyacentes = ciudades.getEdges(or);
            Iterator<Edge<String>> it = adyacentes.iterator();
            while(it.hasNext() && !encontrado){
                Edge<String> adyacente = it.next();
                Vertex<String> vecino = adyacente.getTarget();
                int pesoArista = adyacente.getWeight();
                if(!visitados[vecino.getPosition()] && pesoArista >= montoMinimo){
                    encontrado = dfs(ciudades, vecino, des, caminoActual, visitados, montoMinimo, montoActual + pesoArista);
                }
            }
        }
        if(!encontrado){
            caminoActual.remove(caminoActual.size() - 1); // Deshace el último paso si no se encontró un camino
        }
        visitados[or.getPosition()] = false; // Desmarca el origen al retroceder
        return encontrado;
    }
}
