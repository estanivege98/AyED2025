package TP5.Ejercicio5;

import TP5.ejercicio1.*;
import TP1.Ejercicio8.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BancoItau {

    public List<Jubilado> jubiladosDistanciaMenor(Graph<Persona> grafo, int grado, Persona empleado, int maxList) {
        List<Jubilado> jubilados = new ArrayList<Jubilado>();
        if (!grafo.isEmpty()) {
            Vertex<Persona> verticeEmpleado = this.buscarEmpleado(grafo, empleado);
            if (verticeEmpleado != null) {
                Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
                boolean[] visitados = new boolean[grafo.getSize()];
                cola.enqueue(verticeEmpleado);
                cola.enqueue(null); // Marca el final de un nivel
                visitados[verticeEmpleado.getPosition()] = true;
                while (!cola.isEmpty() && grado > 0 && jubilados.size() < maxList) {
                    Vertex<Persona> v = cola.dequeue();
                    if (v != null) {
                        List<Edge<Persona>> adyacentes = grafo.getEdges(v);
                        Iterator<Edge<Persona>> it = adyacentes.iterator();
                        while (it.hasNext() && jubilados.size() < maxList) {
                            Edge<Persona> arista = it.next();
                            Vertex<Persona> vecino = arista.getTarget();
                            if (!visitados[vecino.getPosition()]) {
                                visitados[vecino.getPosition()] = true;
                                if (vecino.getData().getTipo().equals("Jubulado") && !vecino.getData().isCobro()) {
                                    jubilados.add(new Jubilado(vecino.getData().getNombre(), vecino.getData().getDomicilio()));
                                }
                                cola.enqueue(vecino);
                            }
                        }
                    } else if (!cola.isEmpty()) {
                        grado--;
                        cola.enqueue(null); // Marca el final del siguiente nivel
                    }
                }
            }

        }
        return jubilados;

    }

    private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, Persona empleado) {
        for (Vertex<Persona> v : grafo.getVertices()) {
            if (v.getData().getTipo().equals("Empleado")) {
                return v;
            }
        }
        return null; // Retorna null si no se encuentra el empleado
    }
}
