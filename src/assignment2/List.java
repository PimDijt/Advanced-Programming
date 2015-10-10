package assignment2;

public class List<E extends Data<E>> implements ListInterface<E> {

	Node<E> first, current, last;
	int size;

	public List() {
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
			first = current = last = new Node<E>(d.clone());
		} else {
			goToFirst();
			if (current.data.compareTo(d) > 0) {
				first = new Node<E>(d, null, current);
				current.prior = first;
			} else {
				while(goToNext()){
					if (current.data.compareTo(d) > 0){
						Node<E> tmp = new Node<E>(d, current.prior, current);
						tmp.prior.next = tmp;
						current.prior = tmp;
						size++;
						return this;
					}
				}				
				last = new Node<E>(d, current, null);
				current.next = last;
				goToLast();
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
			goToFirst();
		} else if (current == last) {
			last = last.prior;
			last.next = null;
			goToLast();
		} else {
			current.prior.next = current.next;
			current.next.prior = current.prior;
			goToNext();
		}
		size--;
		return this;
	}

	public boolean find(E d) {
		if(isEmpty()) return false;
		
		goToFirst();
		do {
			if (current.data.compareTo(d) == 0) return true;
			if (current.data.compareTo(d) > 0) break;
		} while(goToNext());
		return false;
	}

	public boolean goToFirst() {
		if (!isEmpty()) {
			current = first;
			return true;
		}
		return false;
	}

	public boolean goToLast() {
		if (!isEmpty()) {
			current = last;
			return true;
		}
		return false;
	}

	public boolean goToNext() {
		if (isEmpty() || current == last) {
			return false;
		}
		current = current.next;
		return true;
	}

	public boolean goToPrevious() {
		if (isEmpty() || current == first) {
			return false;
		}
		current = current.prior;
		return true;
	}

	public List<E> clone() {
		List<E> clone = new List<E>();

		if (goToFirst()) {
			do {
				clone.insert((E) current.data.clone());
			} while (goToNext());
		}
		return clone;
	}
}

class Node<E extends Data<E>> {

    E data;
    Node<E> prior,
         next;

    public Node(E d) {
        this(d, null, null);
    }

    public Node(E data, Node<E> prior, Node<E> next) {
        this.data = data == null ? null : data;
        this.prior = prior;
        this.next = next;
    }
}