package assignment2;

import assignment1.Identifier;

public class Set<E extends Data<E>> implements SetInterface<E> {

	private List<E> set;
	private int size;
	
	public Set() {
		set = new List<E>();
		size = 0;
	}
	
	public Set<E> clone() {
		Set cloneSet = new Set();

//		for(int i=0; i<this.getSize(); i++){
//			Identifier identifier = new Identifier(this.elements[i]);
//			elements[i]=identifier;
//			size++;
//		}
		return null;
	}

	public Set<E> init() {
		return null;
	}

	public int getSize() {
		return 0;
	}

	public boolean contains(E id) {
		return false;
	}

	public boolean isEmpty() {
		return false;
	}

	public SetInterface<E> addElement(E id) throws Exception {
		return null;
	}

	public SetInterface<E> removeElement(E id) {
		return null;
	}

	public E getElement() {
		return null;
	}

	public Set<E> difference(Set<E> col) {
		return null;
	}

	public Set<E> union(Set<E> col) throws Exception {
		return null;
	}

	public Set<E> intersection(Set<E> col) {
		return null;
	}

	public Set<E> symmetricDifference(Set<E> col) throws Exception {
		return null;
	}
}