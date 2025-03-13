package TP1.Ejercicio1;


public class Ejercicio1 {

    public static void realizarConFor(int a, int b) {
        for (int i = a; i<=b; i++){
            System.out.println(i);
        }
    }

    public static void realizarConWhile(int a, int b){
        while (a <= b){
            System.out.println(a);
            a++;
        }
    }

    public static void realizarSinEstructura(int a, int b){
        if(a<=b){
            System.out.println((a));
            realizarSinEstructura(a+1, b);
        }
    }

    public static void main(String[] args) {
        System.out.println("Realizado con For: ");
        realizarConFor(1, 4);
        System.out.println("Realizado con While: ");
        realizarConWhile(1, 4);
        System.out.println("Realizado sin estructuras de control iterativas: ");
        realizarSinEstructura(1, 4);
    }
}
