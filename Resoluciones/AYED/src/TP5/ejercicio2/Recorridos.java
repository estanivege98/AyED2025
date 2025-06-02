package TP5.ejercicio2;
import TP5.ejercicio1.*;

import java.util.List;
import java.util.LinkedList;
import TP1.Ejercicio8.*;
public class Recorridos<T> {

    public List<T> dfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getVertices().size()];
        List<T> recorrido = new LinkedList<T>();
        for (int i = 0; i< grafo.getSize(); i++){
            if (!marca[i]){
                recorridoDfs(grafo, marca, recorrido, i);
            }
        }
        return recorrido;
    }

    private void recorridoDfs(Graph<T> grafo, boolean[] marca, List<T> recorrido, int i){
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        recorrido.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for(Edge<T> e : adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]){
                recorridoDfs(grafo, marca, recorrido, j);
            }
        }
    }

    public List<T> bfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getVertices().size()];
        List<T> recorrido = new LinkedList<T>();
        for (int i = 0; i< grafo.getSize(); i++){
            if(!marca[i]){
                recorridoBfs(grafo, marca, recorrido, i);
            }
        }
        return recorrido;
    }

    private void recorridoBfs(Graph<T> grafo, boolean[] marca, List<T> recorrido, int i){
        Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
        cola.enqueue(grafo.getVertex(i));
        cola.enqueue(null);
        marca[i] = true;
        while(!cola.isEmpty()){
            Vertex<T> v = cola.dequeue();
            if( v != null){
                List<Edge<T>> adyacentes = grafo.getEdges(v);
                recorrido.add(v.getData());
                for(Edge<T> e : adyacentes){
                    int j = e.getTarget().getPosition();
                    if (!marca[j]){
                        cola.enqueue(e.getTarget());
                        marca[j] = true;
                    }
                }
            }
            else if(!cola.isEmpty()){
                cola.enqueue(null);
            }
        }
    }
}
