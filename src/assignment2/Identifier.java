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
	
	public boolean isEqualTo(IdentifierInterface id) {
		if (this.getSize() != id.getSize()) {
			return false;
		}
		
		for (int i = 0; i < this.getSize(); i++) {
			if (this.getChar(i) != id.getChar(i)) {
				return false;
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
	
	public int compareTo(IdentifierInterface identifier) {
		StringBuffer identifierContent = new StringBuffer();

		for (int i = 0; i < identifier.getSize(); i++) {
			identifierContent.append(identifier.getChar(i));
		}
		
		return this.id.toString().compareTo(identifierContent.toString());		
	}
}