package TP5.Ejercicio3;

import TP5.ejercicio1.*;

import java.util.List;
import java.util.LinkedList;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }

    /* Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
    pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible)*/
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[this.mapaCiudades.getSize()];
                devolverCamino(origen, destino, camino, marca);
            }
        }
        return camino;
    }

    private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marca) {
        int pos = origen.getPosition();
        if (marca[pos]) return false; // Si ya se visitó, no continuar
        marca[pos] = true; // Marcar como visitado
        camino.add(origen.getData()); // Agregar ciudad al camino
        if (origen.equals(destino)) return true; // Si se llegó al destino, retornar true
        List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
        for (Edge<String> e : adyacentes) {
            Vertex<String> vecino = e.getTarget();
            if (devolverCamino(vecino, destino, camino, marca)) return true; // Si se encontró un camino, retornar true
        }
        camino.remove(camino.size() - 1); // Si no se encontró un camino, quitar la ciudad del camino
        return false; // No se encontró un camino
    }

    /* Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
    que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
    vacía. (Sin tener en cuenta el combustible).*/

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[this.mapaCiudades.getSize()];
                exeptuar(ciudades, marca);
                devolverCamino(origen, destino, camino, marca);
            }
        }
        return camino;
    }

    private void exeptuar(List<String> ciudades, boolean[] marca) {
        for (String ciudad : ciudades) {
            Vertex<String> v = this.mapaCiudades.search(ciudad);
            if (v != null) {
                marca[v.getPosition()] = true; // Marcar las ciudades a exceptuar
            }
        }
    }

    /* Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
    existe camino retorna la lista vacía. (Las rutas poseen la distancia) */
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<String>();
        List<String> caminoAux = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[this.mapaCiudades.getSize()];
                caminoMasCorto(origen, destino, camino, caminoAux, marca, 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }

    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> camino, List<String> caminoAux,
                                   boolean[] marca, int total, int min) {
        marca[origen.getPosition()] = true;
        caminoAux.add(origen.getData());
        if (origen == destino) {
            if (total < min) {
                camino.clear();
                camino.addAll(new LinkedList<String>(caminoAux));
                min = total;
            }
        }
        else {
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            for (Edge<String> e : adyacentes) {
                Vertex<String> vecino = e.getTarget();
                if (!marca[vecino.getPosition()]) {
                    int distancia = e.getWeight();
                    int nuevoTotal = total + distancia;
                    if (nuevoTotal < min) { // Solo continuar si el nuevo total es menor que el mínimo encontrado
                        min = caminoMasCorto(vecino, destino, camino, caminoAux, marca, nuevoTotal, min);
                    }
                }
            }
        }
        marca[origen.getPosition()] = false;
        caminoAux.remove(camino.size() - 1);
        return min;
    }

    /* Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
    quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.*/

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new LinkedList<>();
        if(!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[this.mapaCiudades.getSize()];
                caminoSinCargarCombustible(origen, destino, camino, marca, tanqueAuto);
            }
        }
        return camino;
    }
    private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marca,
                                           int tanqueAuto){
        boolean encontrado = false;
        marca[origen.getPosition()] = true;
        camino.add(origen.getData());

        if (origen == destino){
            return true;
        }
        else{
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            for(Edge<String> e : adyacentes){
                Vertex<String> vecino = e.getTarget();
                int distancia = e.getWeight();
                if(!marca[vecino.getPosition()] && tanqueAuto - distancia > 0) {
                    encontrado = caminoSinCargarCombustible(vecino, destino, camino, marca, tanqueAuto - distancia);
                }
            }
        }
        if (!encontrado) {
            camino.remove(camino.size() - 1); // Si no se encontró un camino, quitar la ciudad del camino
        }
        marca[origen.getPosition()] = false; // Desmarcar el origen para permitir otros caminos
        return encontrado; // Retornar si se encontró un camino
    }

    /* Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
    que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
    medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
    retorna la lista vacía. */

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new LinkedList<String>();
        List<String> caminoAct = new LinkedList<String>();
        if(!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[this.mapaCiudades.getSize()];
                caminoConMenorCargaDeCombustible(origen, destino, camino, caminoAct, marca, tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }
    public int caminoConMenorCargaDeCombustible(Vertex<String> origen, Vertex<String> destino, List<String> camino, List<String> caminoAct
            , boolean[] marca, int tanqueActual, int tanqueAuto, int cargas, int minCargas){
        /* tanqueAuto: Capacidad total del tanque
        * tanqueActual: Cantidad de gasolina/nafta que el tanque tiene */
        marca[origen.getPosition()] = true;
        caminoAct.add(origen.getData());
        if(origen == destino && cargas < minCargas){
            camino.clear();
            camino.addAll(caminoAct);
            minCargas = cargas;
        }
        else{
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            for(Edge<String> e : adyacentes){
                Vertex<String> vecino = e.getTarget();
                int distancia = e.getWeight();
                if(!marca[vecino.getPosition()]){
                    if (tanqueActual >= distancia){
                        // Si el tanque actual es suficiente para llegar al vecino
                        minCargas = caminoConMenorCargaDeCombustible(vecino, destino, camino, caminoAct, marca, tanqueActual - distancia, tanqueAuto, cargas, minCargas);
                    } else if (tanqueAuto >= distancia) {
                        // Si el tanque no es suficiente pero se puede recargar en el vecino
                        minCargas = caminoConMenorCargaDeCombustible(vecino, destino, camino, caminoAct, marca, tanqueAuto - distancia, tanqueAuto, cargas + 1, minCargas);
                    }
                }
            }
        }
        marca[origen.getPosition()] = false; // Desmarcar el origen para permitir otros caminos
        caminoAct.remove(caminoAct.size() - 1); // Quitar la ciudad del camino actual
        return minCargas;
    }
}
