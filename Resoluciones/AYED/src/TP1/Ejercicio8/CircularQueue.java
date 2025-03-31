package TP1.Ejercicio8;

public class CircularQueue<T> extends Queue<T>{
    public T shift(){
        T element = dequeue();
        enqueue(element);
        return element;
    }
}
