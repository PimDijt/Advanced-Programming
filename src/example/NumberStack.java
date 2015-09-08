package example;

class NumberStack implements NumberStackInterface {

	private static final int INITIAL_AMOUNT_OF_ELEMENTS = 10;

	private Number[] stackArray;
	private int amountElements;

	public NumberStack() {
		stackArray = new Number[INITIAL_AMOUNT_OF_ELEMENTS];
		amountElements = 0;
	}

	private void copyElements(Number[] dest, Number[] src, int amount) {
		for (int i = 0; i < amount; i++) {
			dest[i] = new Number(src[i]);
		}
	}

	public NumberStack(NumberStack src) {
		stackArray = new Number[src.stackArray.length];
		amountElements = src.amountElements;
		copyElements(stackArray, src.stackArray, amountElements);
	}

	public void init() {
		amountElements = 0;
	}

	private void increaseStackSize() {
		Number[] result = new Number[2 * stackArray.length];
		copyElements(result, stackArray, amountElements);
		stackArray = result;
	}

	public void push(Number element) {
		if (amountElements == stackArray.length) {
			increaseStackSize();
		}

		stackArray[amountElements] = new Number(element);
		amountElements += 1;
	}

	public Number pop () {
	amountElements -= 1;
	return stackArray[amountElements];
    }

	public Number top() {
		return new Number(stackArray[amountElements - 1]);
	}

	public boolean isEmpty() {
		return amountElements == 0;
	}

	public int size() {
		return amountElements;
	}

}
