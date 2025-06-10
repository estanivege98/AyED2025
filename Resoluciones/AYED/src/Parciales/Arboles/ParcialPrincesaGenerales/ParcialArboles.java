package Parciales.Arboles.ParcialPrincesaGenerales;

import TP3.Ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {
    public List<Personaje> encontrarPrincesa(GeneralTree<Personaje> arbol) {
        List<Personaje> camino = new ArrayList<Personaje>();
        List<Personaje> camActual = new ArrayList<Personaje>();

        if (arbol == null || arbol.isEmpty()) {
            return camino;
        } else {
            recorrido(arbol, camino, camActual);
            return camino;
        }
    }

    private void recorrido(GeneralTree<Personaje> arbol, List<Personaje> camino, List<Personaje> camActual) {
        if (!arbol.getData().esDragon()) {
            if (camino.isEmpty()) {
                camActual.add(arbol.getData());
                if (arbol.getData().esPrincesa()) {
                    camino.clear();
                    camino.addAll(new ArrayList<Personaje>(camActual));
                }
            }

        }
//        else{
//            camActual.clear();
//        }
        for (GeneralTree<Personaje> hijo : arbol.getChildren()) {
            recorrido(hijo, camino, camActual);
        }
        camActual.remove(camActual.size() - 1);
    }
}
