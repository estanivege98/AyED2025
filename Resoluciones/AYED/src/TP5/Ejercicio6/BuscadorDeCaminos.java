package TP5.Ejercicio6;
import TP5.ejercicio1.*;
import java.util.List;
import java.util.ArrayList;
public class BuscadorDeCaminos {
    private Graph<String> bosque;
    public List<List<String>> recorridosMasSeguro(){
        List<List<String>> caminos = new ArrayList<List<String>>();
        List<String> caminoAct = new ArrayList<String>();
        if(this.bosque != null || !this.bosque.isEmpty()){
            Vertex<String> casaCaperucita = this.bosque.search("Casa Caperucita");
            if(casaCaperucita != null){
                Vertex<String> casaAbuela = this.bosque.search("Casa Abuela");
                if(casaAbuela != null){
                    boolean[] visitados = new boolean[this.bosque.getVertices().size()];
                    this.recorridoMasSeguro(casaCaperucita, casaAbuela, caminos, caminoAct, visitados);
                }
            }
        }
        return caminos;
    }

    private void recorridoMasSeguro(Vertex<String> origen, Vertex<String> destino, List<List<String>> caminos, List<String> caminoAct, boolean[] visitados){
        caminoAct.add(origen.getData());
        visitados[origen.getPosition()] = true;
        if (origen == destino){
            caminos.add(new ArrayList<String>(caminoAct));
        }
        else{
            for(Edge<String> adyacente : this.bosque.getEdges(origen)){
                Vertex<String> vecino = adyacente.getTarget();
                int cantDulces = adyacente.getWeight();
                if(!visitados[vecino.getPosition()] && cantDulces < 5){
                    this.recorridoMasSeguro(vecino, destino, caminos, caminoAct, visitados);
                }
            }
        }
        visitados[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
    }
}
