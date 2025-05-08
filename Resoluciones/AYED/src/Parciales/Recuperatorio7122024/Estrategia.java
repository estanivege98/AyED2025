package Parciales.Recuperatorio7122024;

import TP3.Ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {
    public List<Compuesto> mejorEstrategia(GeneralTree<Compuesto> arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return null;
        }
        List<Compuesto> respuesta = new ArrayList<>();
        List<Compuesto> camAct = new ArrayList<>();
        int tiempo = 0;
        int menorTiempo = Integer.MAX_VALUE;
        helper(arbol, respuesta, camAct, tiempo, menorTiempo);
        return respuesta;
    }

    private int helper(GeneralTree<Compuesto> arbol, List<Compuesto> respuesta, List<Compuesto> camAct, int tiempo, int menorTiempo) {
        if (tiempo > 0) {
            int tiempoNodo = (int)(arbol.getData().getCompuesto() * arbol.getData().getVueltas());
            tiempo += tiempoNodo;
            camAct.add(arbol.getData());
            if (arbol.isLeaf()) {
                if (tiempo < menorTiempo) {
                    menorTiempo = tiempo;
                    respuesta.clear();
                    respuesta.addAll(new ArrayList<>(camAct));
                }
            }
        }

        for (GeneralTree<Compuesto> hijo : arbol.getChildren()) {
            menorTiempo = helper(hijo, respuesta, camAct, tiempo + 10, menorTiempo);
        }

        camAct.remove(camAct.size() - 1);
        return menorTiempo;
    }
}
