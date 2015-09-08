package assignment1;

public class Collection implements CollectionInterface {
	
	static final int MAX_ELEMENTS = 20; 
	Identifier[] col;
	
	public Collection() {
		col = new Identifier[MAX_ELEMENTS];
	}

	public Collection(Collection src){
		col = new Identifier[MAX_ELEMENTS];
		for(int i=0; i<src.size();i++){
			col[i] = src.col[i];
		}
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addIdentifier(Identifier id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeIdentifier(Identifier id) {
		// TODO Auto-generated method stub

	}


	@Override
	public Collection difference(Collection col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection union(Collection col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection intersection(Collection col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection symmetricDifference(Collection col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}
}
