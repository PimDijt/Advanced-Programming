package assignment2;

import assignment1.Identifier;

public class Set<E extends Data<E>> implements SetInterface<E> {

	private List<E> set;
	
	public Set() {
		set = new List<E>();
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
		set.init();
		return this;
	}

	public int getSize() {
		return set.size();
	}

	public boolean contains(E id) {
		if(set.find(id)){
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public Set<E> addElement(E id) throws Exception {
		set.insert(id);
		return this;
	}

	public Set<E> removeElement(E id) {
		set.find(id);
		set.remove();
		return this;
	}

	public E getElement() {
		set.goToLast();
		return set.retrieve();	
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