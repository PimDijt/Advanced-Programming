package assignment2;

public class List<E extends Data<E>> implements ListInterface<E>{

	Node<E> first, current, last;
	int size;
	
	public List(){
		size = 0;
	}
	
	public List<E> init() {
		first = current = last = null;
		size = 0;
		
		return this;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public List<E> insert(E d) {
		if (isEmpty()) {
			first = current = last = new Node(d.clone());
		} else {
			goToFirst();
			if (current.data.compareTo(d) < 0) {
				first = new Node<E>(d.clone(), null, current);
			} else {
				while (current.data.compareTo(d) > 0) {
					if (current.next == null) {
						last = new Node<E>(d.clone(), current, null);
					}
					current = current.next;
				}
				Node<E> tmp = new Node<E>(d.clone(), current.prior, current);
				tmp.prior.next = tmp;
				current.prior = tmp;
				
			}
		}
		size++;
		return this;
	}

	public E retrieve() {
		return current.data;
	}

	public List<E> remove() {
		if (size == 1) {
			this.init();
			return this;
		}
		if (current == first) {
			first = first.next;
			first.prior = null;
		} else if (current == last) {
			last = last.prior;
			last.next = null;
		} else {
			current.prior.next = current.next;
			current.next.prior = current.prior;
		}
		size--;
		return this;
	}

	public boolean find(E d) {
		current = first;
		while (current.next != null){
			if (current.data.compareTo(d) == 0){
				return true;
			} else if (current.data.compareTo(d) < 0){
				break;
			}
			current = current.next;
		}
		return false;
	}

	public boolean goToFirst() {
		if (!isEmpty()){
			current = first;
			return true;
		}
		return false;
	}

	public boolean goToLast() {
		if (!isEmpty()){
			current = last;
			return true;
		}
		return false;
	}

	public boolean goToNext() {
		if(isEmpty() || current == last){
			return false;
		}
		current = current.next;
		return true;
	}

	public boolean goToPrevious() {
		if(isEmpty() || current == first){
			return false;
		}
		current = current.prior;
		return true;
		
	}

	public List<E> clone() {
		List<E> clone = new List<E>();
		
		if(goToFirst()){
			do {
				clone.insert((E) current.data.clone());
			} while(goToNext());
		}
		return clone;
	}
}
