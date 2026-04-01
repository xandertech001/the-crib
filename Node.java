/**
 * A generic node used in a singly-linked list.
 * Stores a data element and a reference to the next node.
 *
 * @param <T> the type of data stored in this node
 */
public class Node<T> {

    /** The data stored in this node. */
    T data;

    /** Reference to the next node in the chain. */
    Node<T> next;

    /**
     * Constructs a new Node with the given data and no next node.
     *
     * @param data the data to store
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
