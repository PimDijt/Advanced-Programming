package assignment3;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Identifier a = new Identifier().init('a');
		Identifier b = new Identifier().init('b');
		
		BinaryTree<IdentifierInterface> Boom = new BinaryTree<IdentifierInterface>();
		Boom.insert(a);
		Boom.insert(b);
		Boom.remove(a);
		Boom.remove(b);
	}
}