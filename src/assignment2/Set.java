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

	public Set<E> addElement(E id) {
		if(set.find(id)) set.remove(); 
		set.insert(id);
		return this;
	}

	public Set<E> removeElement(E id) {
		set.find(id);
		set.remove();
		return this;
	}

	public E getElement() {
		set.goToFirst();
		return set.retrieve();
	}

	public Set<E> difference(Set<E> col) {
		Set<E> difference = this.clone();
		Set<E> newSet 	  = col.clone();
		
		while(!newSet.isEmpty()){
			E id = newSet.getElement();
			if(difference.contains(id)){
				difference.removeElement(id);
			}
			newSet.removeElement(id);
		}
		return difference;
	}

	public Set<E> union(Set<E> col) {
		Set<E> union = this.clone();
		Set<E> newSet = col.clone();
		
		while(!newSet.isEmpty()){
			E id = newSet.getElement();
			union.addElement(id);
			newSet.removeElement(id);
		}
		return union;
	}

	public Set<E> intersection(Set<E> col){
		Set<E> intersection = new Set<E>();
		Set<E> set1 = this.clone();
		Set<E> set2 = col.clone();
		
		while(!set1.isEmpty()){
			E id = set1.getElement();
			if(set2.contains(id)) intersection.addElement(id);
			set1.removeElement(id);
		}
		return intersection;
	}

	public Set<E> symmetricDifference(Set<E> col) {
		return col.difference(this).union(this.difference(col));
	}
}