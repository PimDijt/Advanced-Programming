package assignment1;

public class Identifier implements IdentifierInterface {

	StringBuffer id;
	
	public Identifier() {
		id = new StringBuffer();
		id.append('a');
	}

	public Identifier(Identifier src){
		id = new StringBuffer();
		for(int i=0; i<src.size();i++){
			id.append(src.getChar(i));
		}
	}
	
	public void init(char c) {
		id.setLength(0);
		id.append(c);
	}

	public void addChar(char c) {
		id.append(c);
	}

	public char getChar(int index) {
		char c = id.charAt(index);
		return c;
	}

	public int size() {
		int size = id.length();
		return size;
	}

	public boolean isEqual(Identifier id) {
		// TODO Auto-generated method stub
		return false;
	}
}
