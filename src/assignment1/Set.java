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

	public boolean contains(Identifier id) {
		for (int i = 0; i < size; i++){
			if (elements[i].isEqualTo(id)){
				return true;
			}
		}
		return false;
	}
	
	public Identifier getIdentifier() {
		return elements[size-1];
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
		int toRemove = 0;
		
		for (int i = 0; i < size; i++){ 
				if (elements[i].isEqualTo(id)){
					toRemove = i;
					break;
				}
			}
		
		for (int i = toRemove; i < size; i++){
			elements[i] = elements[i+1];
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
		Set result = new Set();
		Set foreignSet = new Set(src);
		
		while(foreignSet.getSize() > 0){
			Identifier tmp = foreignSet.getIdentifier();
			if (this.contains(tmp)){
				try {
					result.addIdentifier(tmp);
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
			foreignSet.removeIdentifier(tmp);
		}
		return result;
	}

	public Set symmetricDifference(Set src) {
		Set foreignSet = new Set(src);
		Set union = new Set(this).union(foreignSet);
		Set intersection = new Set(this).intersection(foreignSet);
		Set result = union.difference(intersection);
		return result;
	}
}
