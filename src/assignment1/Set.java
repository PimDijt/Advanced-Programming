package assignment1;

public class Set implements SetInterface {
	
	static final int MAX_ELEMENTS = 20; 
	private Identifier[] elements;
	private int size;
	
	public Set(){
		elements = new Identifier[MAX_ELEMENTS];
		size = 0;
	}

	public Set(Set src) {
		elements = new Identifier[MAX_ELEMENTS];
		for (int i = 0; i < src.getSize(); i++) {
			elements[i] = src.elements[i];
		}
	}

	public void init() {
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public Identifier getIdentifier() {
		return null;
	}
	
	public void addIdentifier(Identifier id) throws Exception {
		for (int i = 0; i < size; i++) {
			if (elements[i].isEqualTo(id)) {
				return;
			}
		}
		elements[size] = id;
		size++;
	}


	public void removeIdentifier(Identifier id) {
			
	}

	public Set difference(Set set) {
		return null;
	}

	public Set union(Set set){
		return null;
	}

	public Set intersection(Set set) {
		return null;
	}


	public Set symmetricDifference(Set set) {
		return null;
	}


}
