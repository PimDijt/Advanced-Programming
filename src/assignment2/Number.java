package assignment2;

public class Number implements NumberInterface {

	StringBuffer num;
	
	Number(){
		num = new StringBuffer();
		num.append('0');
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

	public boolean isEqualTo(Number n) {
		if(this.size() != n.size()){
			return false;
		}else{
			for(int i = 0; i<this.size(); i++){
				if(this.getChar(i)!=n.getChar(i)){
					return false;
				}
			}
		}
		return true;
	}
	
	public Number clone() {
		Number number = new Number().init(this.getChar(0));
		for(int i = 1; i<this.size();i++){
			number.addDigit(this.getChar(i));
		}
		return number;
	}

	public int compareTo(Number number) {
		return this.toString().compareTo(number.toString());
	}






}
