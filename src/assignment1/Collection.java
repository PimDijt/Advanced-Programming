package assignment1;

public class Collection implements CollectionInterface {
	
	static final int MAX_ELEMENTS = 20; 
	Identifier[] col;
	int size;
	
	public Collection(){
		col = new Identifier[MAX_ELEMENTS];
	}

	public Collection(Collection src){
		col = new Identifier[MAX_ELEMENTS];
		for(int i=0; i<src.getSize();i++){
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
		for(int i=0; i<size;i++){
			if(col[i].isEqualTo(id)){
				return;
			}
		}
		col[size] = id;
		size++;
	}


	public void removeIdentifier(Identifier id) {
			
	}

	public Collection difference(Collection col) {
		return null;
	}

	public Collection union(Collection col) throws Exception{
		return null;
	}

	public Collection intersection(Collection col) {
		return null;
	}


	public Collection symmetricDifference(Collection col) {
		return null;
	}


}
