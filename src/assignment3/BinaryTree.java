package assignment3;

import java.util.Iterator;

public class BinaryTree<E extends Data<E>> implements BinaryTreeInterface<E>{

	Node<E> root;
	
	BinaryTree(){
	}
	
	public BinaryTree<E> init() {
		root.left = root.right = null;
		root.data = null;
		return this;
	}
	
	public boolean isEmpty(){
		return root.data == null;
	}
	
	public boolean contains(E e){
		return contains(this.root, e);
	}
	
	private boolean contains(Node<E> root, E e) {
		if (isEmpty()) return false;
		return e == root.data || contains(root.left, e) || contains(root.right, e);
	}

	public BinaryTree<E> remove(E e){
		root = remove(this.root, e);
		return this;
	}
	
	private Node<E> remove(Node<E> root, E e){
		if(root == null){
			throw new Error("...");
		}
		if(e.compareTo(root.data) < 0){
			root.left = remove(root.left, e);
		} else if(e.compareTo(root.data) > 0){
			root.right = remove(root.right, e);
		} else { //0 or 1 child
			if(root.left == null){
				root = root.right;
			} 
			else if(root.right == null){
				root = root.left;
			} else { // 2 children
				root.data  = smallest(root.right);
				root.right = remove(root.right, root.data);
			}
		}		
		return root;
	}

	private E smallest(Node<E> root){
		return root.left == null ? root.data : smallest(root.left); 
	}
	
	public BinaryTree<E> insert(E e){
		root = insert(this.root, e);
		return this;
	}
	
	private Node<E> insert(Node<E> root, E e) {
		if(root == null){
			return new Node<E>(e);
		}
		if(e.compareTo(root.data) < 0){
			root.left  = insert(root.left, e);
		} else { 
			root.right = insert(root.right, e);
		}
		return root;
	}

	public Iterator<E> iterateUp() {
		return null;
	}

	public Iterator<E> iterateDown() {
		return null;
	}
}


class Node<E extends Data<E>> {

    E data;
    Node<E> left, right;

    public Node(E d) {
        this(d, null, null);
    }

    public Node(E data, Node<E> left, Node<E> right) {
        this.data = data == null ? null : data;
        this.left = left;
        this.right = right;
    }
}