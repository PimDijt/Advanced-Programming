package assignment1;

public class Identifier implements IdentifierInterface {

	StringBuffer id;

	public Identifier() {
		id = new StringBuffer();
		id.append('a');
	}

	public Identifier(Identifier src) {
		id = new StringBuffer();
		for (int i = 0; i < src.getSize(); i++) {
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

	public int getSize() {
		return id.length();
	}

	public boolean isEqualTo(Identifier identifier) {
		if (this.getSize() != identifier.getSize()) {
			return false;
		} else {
			for (int i = 0; i < this.getSize(); i++) {
				if (this.getChar(i) != identifier.getChar(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
