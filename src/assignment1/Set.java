package assignment1;

public class Set implements SetInterface {
	
	static final int MAX_ELEMENTS = 20; 
	Identifier[] col;
	int size;
	
	public Set(){
		col = new Identifier[MAX_ELEMENTS];
	}

	public Set(Set src) {
		col = new Identifier[MAX_ELEMENTS];
		for (int i = 0; i < src.getSize(); i++) {
			col[i] = src.col[i];
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
			if (col[i].isEqualTo(id)) {
				return;
			}
		}
		col[size] = id;
		size++;
	}


	public void removeIdentifier(Identifier id) {
			
	}

	public Set difference(Set col) {
		return null;
	}

	public Set union(Set col) throws Exception{
		return null;
	}

	public Set intersection(Set col) {
		return null;
	}


	public Set symmetricDifference(Set col) {
		return null;
	}


}
