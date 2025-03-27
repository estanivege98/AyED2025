package TP1.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Mario", "Lopez", "a@gmail.com", "1", "Calle 123");
        Estudiante e2 = new Estudiante();
        e2.setNombre("Juana");
        e2.setApellido("Garcia");
        e2.setEmail("juana@gmail.com");
        e2.setComision("2");
        e2.setDireccion("Calle 456");

        Profesor p1 = new Profesor("Eduardo", "Perez", "a@hotmail.com", "Algoritmos", "Ingenieria");
        Profesor p2 = new Profesor();
        p2.setNombre("Maria");
        p2.setApellido("Rodriguez");
        p2.setEmail("rodriguez@gmail.com");
        p2.setCatedra("Arte Moderno");
        p2.setFacultad("Bellas Artes");
        Profesor p3 = new Profesor();
        p3.setNombre("Carlos");
        p3.setApellido("Gomez");
        p3.setEmail("carlos@gmail.com");
        p3.setCatedra("Matematica 1");
        p3.setFacultad("Arquitectura");

        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        List<Profesor> profesores = new ArrayList<Profesor>();

        estudiantes.add(e1);
        estudiantes.add(e2);

        profesores.add(p1);
        profesores.add(p2);
        profesores.add(p3);

        // Recorrido de las listas imprimiendo los datos

        System.out.println("Estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }

        System.out.println("Profesores:");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.tusDatos());
        }
    }
}
