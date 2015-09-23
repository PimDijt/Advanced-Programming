package assignment2;;

public class Identifier implements IdentifierInterface {

	private StringBuffer id;

	public Identifier() {
		id = new StringBuffer();
		id.append('a');
	}

	public Identifier(Identifier src){
		id = new StringBuffer();
		for (int i = 0; i < src.getSize(); i++) {
			id.append(src.getChar(i));
		}
	}

	public Identifier init(char c) {
		id.setLength(0);
		id.append(c);
		return null;
	}

	public Identifier addChar(char c) {
		id.append(c);
		return null;
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

	@Override
	public Identifier clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public int compareTo(Identifier o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(IdentifierInterface o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
