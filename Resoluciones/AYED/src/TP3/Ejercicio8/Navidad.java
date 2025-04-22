// Navidad navidad dulce navidad

package TP3.Ejercicio8;
import TP3.Ejercicio1.*;
public class Navidad {
    private GeneralTree<Integer> arbolito;

    public Navidad(GeneralTree<Integer> arbolito) {
        this.arbolito = arbolito;
    }

    public boolean esAbetoNavidenio(){
        if(arbolito.isEmpty()){
            return false;
        }
        else{
            //boolean esAbeto = true;
            return esAbetoRec(this.arbolito);
            //return esAbeto;
        }
    }

    private boolean esAbetoRec(GeneralTree<Integer> arbolito){
        int nodosHijos = 0;
        for(GeneralTree<Integer> child : arbolito.getChildren()){
            if(child.isLeaf()){
                nodosHijos++;
            }
            else{
                if(!esAbetoRec(child)){
                    return false;
                }
                //nodosHijos += child.getChildren().size();
            }
        }
        return nodosHijos>=3;
    }
}
