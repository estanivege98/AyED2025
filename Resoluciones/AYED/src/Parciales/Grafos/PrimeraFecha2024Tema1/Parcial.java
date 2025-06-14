package Parciales.Grafos.PrimeraFecha2024Tema1;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

import TP5.ejercicio1.*;

public class Parcial {
    public int resolver(Graph<Recinto> sitios, int tiempo) {
        int cantTotal = 0;
        if (sitios != null || !sitios.isEmpty()) {
            Vertex<Recinto> origen = this.buscarOrigen(sitios, "Entrada");
            if (origen != null) {
                boolean[] visitados = new boolean[sitios.getSize()];
                int tiempoOrigen = origen.getData().getTiempo();
                if (tiempoOrigen <= tiempo) {
                    cantTotal = this.dfs(origen, sitios, visitados, tiempo - tiempoOrigen, 1, Integer.MIN_VALUE);
                }

            }
        }
        return cantTotal;
    }

    private Vertex<Recinto> buscarOrigen(Graph<Recinto> sitios, String nombre) {
        Vertex<Recinto> origen = null;
        Iterator<Vertex<Recinto>> it = sitios.getVertices().iterator();
        while (it.hasNext() && origen == null) {
            Vertex<Recinto> v = it.next();
            if (v.getData().getNombre().equals(nombre)) {
                origen = v;
            }
        }
        return origen;
    }

    private int dfs(Vertex<Recinto> origen, Graph<Recinto> sitios, boolean[] visitados, int tiempo, int cantAct, int max){
        visitados[origen.getPosition()] = true;
        for (Edge<Recinto> e : sitios.getEdges(origen)) {
            Vertex<Recinto> destino = e.getTarget();
            int tiempoDestino = destino.getData().getTiempo();
            if (!visitados[destino.getPosition()] && tiempoDestino <= tiempo ) {
                max = this.dfs(destino, sitios, visitados, tiempo - tiempoDestino, cantAct+1, max);
            }
        }
        visitados[origen.getPosition()] = false;
        Math.max(max, cantAct);
        return max;
    }
}
