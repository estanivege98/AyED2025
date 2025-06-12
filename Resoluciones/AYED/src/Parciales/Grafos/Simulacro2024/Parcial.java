package Parciales.Grafos.Simulacro2024;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import TP5.ejercicio1.*;
public class Parcial {
    public List<String> resolver(Graph<Ciudad> mapa, String ciudad, int cantDiasVacas) {
        List<String> resultado = new LinkedList<String>();
        if(mapa != null || mapa.isEmpty()){
            Vertex<Ciudad> origen = this.buscarCiudad(mapa, ciudad);
            if (origen != null) {
                boolean[] visitados = new boolean[mapa.getSize()];
                int dias = origen.getData().getCantDiasEstadia();
                if(dias <= cantDiasVacas){
                    this.dfs(mapa, origen, cantDiasVacas - dias, visitados, resultado, new LinkedList<String>());
                }

            }
        }
        return resultado;
    }

    private Vertex<Ciudad> buscarCiudad(Graph<Ciudad> mapa, String ciudad){
        for (Vertex<Ciudad> v : mapa.getVertices()) {
            if (v.getData().getNombre().equals(ciudad)) {
                return v;
            }
        }
        return null;
    }

    private void dfs(Graph<Ciudad> mapa, Vertex<Ciudad> origen, int cantDiasVacas, boolean[] visitados,
                        List<String> resultado, List<String> caminoAct) {
        caminoAct.add(origen.getData().getNombre());
        visitados[origen.getPosition()] = true;
        if(cantDiasVacas == 0){
            if(caminoAct.size() > resultado.size()){
                resultado.clear();
                resultado.addAll(new LinkedList<String>(caminoAct));
            }
        }
        else {
            for (Edge<Ciudad> e : mapa.getEdges(origen)) {
                Vertex<Ciudad> destino = e.getTarget();
                int diasCiudad = destino.getData().getCantDiasEstadia();
                if (!visitados[destino.getPosition()] && diasCiudad <= cantDiasVacas) {
                    this.dfs(mapa, destino, cantDiasVacas - diasCiudad, visitados, resultado, caminoAct);
                }
            }
        }
        caminoAct.removeLast(); // caminoAct.remove(caminoAct.size() - 1);
        visitados[origen.getPosition()] = false;
    }
}
