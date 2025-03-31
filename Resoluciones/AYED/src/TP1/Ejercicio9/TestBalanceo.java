package TP1.Ejercicio9;
//Considere un string de caracteres S, el cual comprende únicamente los caracteres: (,),[,],{,}.
//Decimos que S está balanceado si tiene alguna de las siguientes formas:
//S = "" S es el string de longitud cero.
//        S = "(T)"
//S = "[T]"
//S = "{T}"
//S = "TU"
//Donde ambos T y U son strings balanceados. Por ejemplo, "{( ) [ ( ) ] }" está balanceado, pero
//"( [ ) ]" no lo está.
//a. Indique qué estructura de datos utilizará para resolver este problema y cómo la
//utilizará.
//b. Implemente una clase llamada tp1.ejercicio9.TestBalanceo, cuyo objetivo es
//determinar si un String dado está balanceado. El String a verificar es un parámetro de
//entrada (no es un dato predefinido).

import java.util.*;

//
public class TestBalanceo {

    public static boolean esBalanceado(String cadena){
        List<Character> cierre = new ArrayList<Character>();
        cierre.add(')');
        cierre.add(']');
        cierre.add('}');
        boolean ok = true;
        if(!cadena.isEmpty() && cierre.contains(cadena.charAt(0))){
            ok = false;
        }
        else{
            List<Character> apertura = new ArrayList<Character>();
            apertura.add('(');
            apertura.add('[');
            apertura.add('{');
            Stack<Character> pila = new Stack<Character>();
            Character actual, item;
            int i = 0;
            while(i<cadena.length() && ok){
                actual = cadena.charAt(i);
                if(apertura.contains(actual)){
                    pila.push(actual);
                }
                else{
                    if(!pila.isEmpty()){
                        item = pila.pop();
                        if(apertura.indexOf(item) != cierre.indexOf(actual)){
                            ok = false;
                        }
                    }
                }
                i++;
            }
            if(!pila.isEmpty()){
                ok = false;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese un String");
        String s = consola.nextLine();
        consola.close(); //No se va a leer mas datos de teclado. Cierro el objeto Scanner, libero el recurso.
        if(esBalanceado(s))
            System.out.println("La expresion " + s + " esta balanceada");
        else System.out.println("La expresion " + s + " no esta balanceada");
    }
}
