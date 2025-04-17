package TP3.Ejercicio4;
import TP3.Ejercicio1.*;
import TP1.Ejercicio8.*;
public class AnalizadorArbol {
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol){
        GeneralTree<AreaEmpresa> abAux = new GeneralTree<AreaEmpresa>();
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        double promedioMaximo = Integer.MIN_VALUE;
        int cantNodos = 0;
        double promedio = 0;
        while(!cola.isEmpty()){
            abAux = cola.dequeue();
            if(abAux != null){
                cantNodos++;
                promedio += abAux.getData().getTardanza();
                if(abAux.hasChildren()){
                    for (GeneralTree<AreaEmpresa> hijos : abAux.getChildren()){
                        cola.enqueue(hijos);
                    }
                }

            }
            else{
                if(promedio/cantNodos > promedioMaximo){
                    promedioMaximo = promedio/cantNodos;
                }
                if(!cola.isEmpty()){
                    cantNodos = 0;
                    promedio = 0;
                    cola.enqueue(null);
                }
            }
        }
        return promedioMaximo;
    }
}
