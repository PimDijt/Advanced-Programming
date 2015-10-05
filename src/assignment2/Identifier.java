package assignment2;;

public class Identifier implements IdentifierInterface {

	private StringBuffer id;
	
	public Identifier() {
		id = new StringBuffer();
		id.append('a');
	}
	
	public Identifier init(char c) {
		id.setLength(0);
		id.append(c);
		return this;
	}

	public Identifier addChar(char c) {
		id.append(c);
		return this;
	}

	public char getChar(int index) {
		return id.charAt(index);
	}

	public int getSize() {
		return id.length();
	}
	
	public boolean isEqualTo(Identifier id) {
		if (this.getSize() != id.getSize()) {
			return false;
		} else {
			for (int i = 0; i < this.getSize(); i++) {
				if (this.getChar(i) != id.getChar(i)) {
					return false;
				}
			}
		}
		return true;
	}

	public Identifier clone() {
		Identifier identifier = new Identifier().init(this.getChar(0));
		for (int i = 1; i < this.getSize(); i++) {
			identifier.addChar(this.getChar(i));
		}
		return identifier;
	}
	
	public int compareTo(Identifier identifier) {
		return this.getValue().toString().compareTo(identifier.getValue().toString());		
	}
	
	private StringBuffer getValue(){
		return this.id;
	}
	
}