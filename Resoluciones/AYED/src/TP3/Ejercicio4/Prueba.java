package TP3.Ejercicio4;
import TP3.Ejercicio1.*;
import java.util.LinkedList;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        // Areas de Emrpesa
        AreaEmpresa a = new AreaEmpresa("A", 4);
        AreaEmpresa b = new AreaEmpresa("B", 7);
        AreaEmpresa c = new AreaEmpresa("C", 5);
        AreaEmpresa d = new AreaEmpresa("D", 6);
        AreaEmpresa e = new AreaEmpresa("E", 10);
        AreaEmpresa f = new AreaEmpresa("F", 18);
        AreaEmpresa g = new AreaEmpresa("G", 9);
        AreaEmpresa h = new AreaEmpresa("H", 12);
        AreaEmpresa i = new AreaEmpresa("I", 19);
        AreaEmpresa j = new AreaEmpresa("J", 13);
        AreaEmpresa k = new AreaEmpresa("K", 25);
        AreaEmpresa l = new AreaEmpresa("L", 10);
        AreaEmpresa m = new AreaEmpresa("M", 14);

        // Creo el Arbol

        // Area J
        GeneralTree<AreaEmpresa> j1 = new GeneralTree<AreaEmpresa>(a);
        GeneralTree<AreaEmpresa> j2 = new GeneralTree<AreaEmpresa>(b);
        GeneralTree<AreaEmpresa> j3 = new GeneralTree<AreaEmpresa>(c);
        List<GeneralTree<AreaEmpresa>> hijosJ = new LinkedList<GeneralTree<AreaEmpresa>>();
        hijosJ.add(j1);
        hijosJ.add(j2);
        hijosJ.add(j3);
        GeneralTree<AreaEmpresa> arbolJ = new GeneralTree<AreaEmpresa>(j, hijosJ);

        // Area K
        GeneralTree<AreaEmpresa> k1 = new GeneralTree<AreaEmpresa>(d);
        GeneralTree<AreaEmpresa> k2 = new GeneralTree<AreaEmpresa>(e);
        GeneralTree<AreaEmpresa> k3 = new GeneralTree<AreaEmpresa>(f);
        List<GeneralTree<AreaEmpresa>> hijosK = new LinkedList<GeneralTree<AreaEmpresa>>();
        hijosK.add(k1);
        hijosK.add(k2);
        hijosK.add(k3);
        GeneralTree<AreaEmpresa> arbolK = new GeneralTree<AreaEmpresa>(k, hijosK);

        // Area L
        GeneralTree<AreaEmpresa> l1 = new GeneralTree<AreaEmpresa>(g);
        GeneralTree<AreaEmpresa> l2 = new GeneralTree<AreaEmpresa>(h);
        GeneralTree<AreaEmpresa> l3 = new GeneralTree<AreaEmpresa>(i);
        List<GeneralTree<AreaEmpresa>> hijosL = new LinkedList<GeneralTree<AreaEmpresa>>();
        hijosL.add(l1);
        hijosL.add(l2);
        hijosL.add(l3);
        GeneralTree<AreaEmpresa> arbolL = new GeneralTree<AreaEmpresa>(l, hijosL);

        // Area M
        List<GeneralTree<AreaEmpresa>> hijosM = new LinkedList<GeneralTree<AreaEmpresa>>();
        hijosM.add(arbolJ);
        hijosM.add(arbolK);
        hijosM.add(arbolL);
        GeneralTree<AreaEmpresa> m1 = new GeneralTree<AreaEmpresa>(m, hijosM);

        // Prueba
        AnalizadorArbol analizador = new AnalizadorArbol();
        System.out.println("El promedio maximo de tardanza es: " + analizador.devolverMaximoPromedio(m1));

    }
}
