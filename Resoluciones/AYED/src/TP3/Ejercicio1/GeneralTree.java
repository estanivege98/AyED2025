package TP3.Ejercicio1;

import java.util.LinkedList;
import java.util.List;


import TP1.Ejercicio8.*;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	// CONSULTAR EN CLASE (Los 3 metodos)

	public int altura() {
		int max = 0;
		if(this.hasChildren()){
			for (GeneralTree<T> child : this.children) {
				int h = child.altura();
				if (h > max) {
					max = h;
				}
			}
		}
		return max + 1;
	}
	
	public int nivel(T dato){
		int nivel = 0;
		if(this.getData().equals(dato)){
			return nivel;
		}
		else{
			for (GeneralTree<T> hijos : this.getChildren()){
				nivel = hijos.nivel(dato);
				if(nivel != -1){
					return nivel + 1;
				}
			}
			return -1;
		}
	}

	public int ancho(){
		GeneralTree<T> abAux = new GeneralTree<T>();
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nodoMax = Integer.MIN_VALUE;
		while(!cola.isEmpty()){
			abAux = cola.dequeue();
			int nodoActual = 0;
			if(abAux != null){
				if(abAux.hasChildren()){
					for (GeneralTree<T> hijos : abAux.getChildren()){
						nodoActual++;
						cola.enqueue(hijos);
					}
				}
			}
			else {
				if(nodoActual > nodoMax){
					nodoMax = nodoActual;
				}
				if(!cola.isEmpty()){
					cola.enqueue(null);
				}

			}
		}
		return nodoMax;
	}

	// CONSULTAR

	public boolean esAncestro(T a, T b){
		if(this.getData().equals(a)){
			return buscarDescendiente(b);
		}
		else{
			for (GeneralTree<T> hijos : this.getChildren()){
				if(hijos.esAncestro(a, b)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean buscarDescendiente(T dato){
		if(this.getData().equals(dato)){
			return true;
		}
		else{
			for (GeneralTree<T> hijos : this.getChildren()){
				if(hijos.buscarDescendiente(dato)){
					return true;
				}
			}
		}
		return false;
	}
}