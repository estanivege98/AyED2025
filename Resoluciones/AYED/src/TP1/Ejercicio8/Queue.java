package TP1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Sequence{
    protected List<T> data;

    public Queue() {
        this.data = new ArrayList<T>();
    }

    public void enqueue(T element){
        this.data.add(element);
    }

    public T dequeue(){
        if(this.data.isEmpty()){
            return null;
        }
        T element = this.data.getFirst();
        this.data.removeFirst();
        return element;
    }

    public T head(){
        if(this.data.isEmpty()){
            return null;
        }
        return this.data.getFirst();
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    public int size(){
        return this.data.size();
    }

    @Override
    public String toString(){
        String str = "[";
        for (T d: data){
            str = str + d + ",";
        }
        str = str.substring(0, str.length() - 2)+"]";
        return str;
    }

}
