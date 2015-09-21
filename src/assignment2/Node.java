package assignment2;

// Inner class for the implementation of the List class.

class Node<E extends Data> {

    E data;
    Node prior,
         next;

    public Node(E d) {
        this(d, null, null);
    }

    public Node(E data, Node prior, Node next) {
        this.data = data == null ? null : data;
        this.prior = prior;
        this.next = next;
    }
}
