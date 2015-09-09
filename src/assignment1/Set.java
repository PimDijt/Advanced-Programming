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

	public boolean contains(Identifier id) {
		return false;
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
		int toRemove = 0;
		
		for (int i = 0; i < size; i++){ // Get index of the item that has to be removed
				if (col[i] == id){
					toRemove = i;
					break;
				}
			}
		
		for (int i = toRemove; i < size; i++){ // "Remove" items by overwriting by following items
			col[i] = col[i+1];
		}
		size--;
	}

	public Set difference(Set src) {
		Set result = new Set(this);
		Set foreignSet = new Set(src);
		while (foreignSet.getSize() > 0) {
			Identifier tmp = foreignSet.getIdentifier();
			result.removeIdentifier(tmp);
			foreignSet.removeIdentifier(tmp);
		}
		
		return result;
	}

	public Set union(Set src) {
		Set result = new Set(this);
		Set foreignSet = new Set(src);
		while (foreignSet.getSize() > 0) {
			Identifier tmp = foreignSet.getIdentifier();
			foreignSet.removeIdentifier(tmp);
			if (!result.contains(tmp)){
				try {
					result.addIdentifier(tmp);
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
		}
		return result;
	}

	public Set intersection(Set src) {
		return null;
	}


	public Set symmetricDifference(Set src) {
		return null;
	}



}
