package assignment2;


public class Set<E extends Data<E>> implements SetInterface<E> {

	private List<E> set;
	
	public Set() {
		set = new List<E>();
	}
	
	public Set<E> clone() {
		Set<E> cloneSet = new Set<E>();
		cloneSet.set = set.clone();
		return cloneSet;
	}

	public Set<E> init() {
		set.init();
		return this;
	}

	public int getSize() {
		return set.size();
	}

	public boolean contains(E id) {
		return set.find(id);
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public Set<E> addElement(E id) throws Exception {
		if(set.find(id)){
			set.remove();
		}
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