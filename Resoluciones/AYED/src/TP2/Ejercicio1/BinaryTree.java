package TP2.Ejercicio1;

import TP1.Ejercicio8.*;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {

		if(this.isLeaf()){
			return 1;
		}
		else{
			int cant = 0;
			if(this.hasLeftChild()){
				cant += this.getLeftChild().contarHojas();
			}
			if(this.hasRightChild()){
				cant += this.getRightChild().contarHojas();
			}
			return cant;
		}
	}

    public BinaryTree<T> espejo(){
		BinaryTree<T> espejo = new BinaryTree<T>();
		if(!this.isEmpty()){
			espejo.setData(this.getData());
			if(this.hasLeftChild()){
				espejo.addRightChild(this.getLeftChild().espejo());
			}
			if(this.hasRightChild()){
				espejo.addLeftChild(this.getRightChild().espejo());
			}
		}
		return espejo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m) {
       BinaryTree<T> abAux = null;
       Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
       List<List<T>> niveles = new ArrayList<>();
       cola.enqueue(this);
       cola.enqueue(null);
       int nivelAct = 0;
       niveles.add(new ArrayList<>());
       while (!cola.isEmpty() && nivelAct <= m) {
           abAux = cola.dequeue();
           if (abAux != null) {
               if (nivelAct >= n) {
                   niveles.get(nivelAct).add(abAux.getData());
               }
               if (abAux.hasLeftChild() && nivelAct + 1 <= m) {
                   cola.enqueue(abAux.getLeftChild());
               }
               if (abAux.hasRightChild() && nivelAct + 1 <= m) {
                   cola.enqueue(abAux.getRightChild());
               }
           } else {
               if (!cola.isEmpty()) {
                   cola.enqueue(null);
                   nivelAct++;
                   if (nivelAct <= m) {
                       niveles.add(new ArrayList<>());
                   }
               }
           }
       }
       for (int i = n; i <= m && i < niveles.size(); i++) {
           System.out.println("Nivel " + i + ": " + niveles.get(i));
       }
   }



}

