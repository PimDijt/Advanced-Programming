package assignment2;

public class Number implements NumberInterface{

	private StringBuffer num;
	
	Number(){
		num = new StringBuffer();
		num.append('0');
	}
	
	
	public Number clone() {
		Number number = new Number();
		number.init(this.getChar(0));
		
		for(int i = 1; i<this.size(); i++){
			number.addDigit(this.getChar(i));
		}
		
		return number;
		
	}

	public int compareTo(Number number) {
		return this.num.toString().compareTo(number.num.toString());
	}


	public Number init(char c) {
		num.setLength(0);
		num.append(c);
		return this;
	}


	public Number addDigit(char c) {
		num.append(c);
		return this;
	}

	public char getChar(int index) {
		return num.charAt(index);
	}

	public int size() {
		return num.length();
	}

	public boolean isEqualTo(Number number) {
		if (this.size() != number.size()) {
			return false;
		} else {
			for (int i = 0; i < this.size(); i++) {
				if (this.getChar(i) != number.getChar(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
