package TP1.Ejercicio4;

public class SwapValores {
    public static void swap1 (int x, int y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }
    public static void swap2 (Integer x, Integer y) {
        if (x < y) {
            int tmp = x ;
            x = y ;
            y = tmp;
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        Integer c = 3, d = 4;
        swap1(a,b);
        swap2(c,d);
        System.out.println("a=" + a + " b=" + b) ;
        System.out.println("c=" + c + " d=" + d) ;
    }

    // Los valores varian dentro de las funciones swap1 y swap2, pero no se ven reflejados en el main.
    // Esto se debe a que los parametros de las funciones son pasados por valor, y no por referencia.
    // Los datos primitivos no se ven afectados por los cambios realizados en las funciones, ya que se pasan por valor.
    // Java no trabaja con paso por referencia, por lo que no se pueden modificar los valores de las variables en las funciones.
}
