import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic singly-linked list used for separate chaining in the hash table.
 * Supports add, remove, contains, and iteration.
 *
 * @param <T> the type of elements stored in this list
 */
public class LinkedList<T> implements Iterable<T> {

    /** Head node of the list. */
    private Node<T> head;

    /** Number of elements in the list. */
    private int size;

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param data the element to add
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Returns the first element whose equality check matches the given data,
     * or null if not found.
     *
     * @param data the element to search for
     * @return the matching element, or null
     */
    public T find(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Checks whether the list contains an element equal to the given data.
     *
     * @param data the element to check
     * @return true if found, false otherwise
     */
    public boolean contains(T data) {
        return find(data) != null;
    }

    /**
     * Removes the first element equal to the given data.
     *
     * @param data the element to remove
     * @return true if removed, false if not found
     */
    public boolean remove(T data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list.
     *
     * @return an Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
