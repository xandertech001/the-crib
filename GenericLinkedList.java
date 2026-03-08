import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A generic doubly linked list that supports forward and backward traversal via a ListIterator.
 * @param <T> the type of elements stored in the list
 */
public class GenericLinkedList<T> implements Iterable<T> {

    /** Internal node class holding data and links to neighbors. */
    private class Node {
        T data;
        Node prev;
        Node next;

        /** Constructs a node with the given data. */
        Node(T data) { this.data = data; }
    }

    private Node head;
    private Node tail;
    private int size;

    /** Constructs an empty GenericLinkedList. */
    public GenericLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the front of the list.
     * @param element the element to add
     */
    public void addFirst(T element) {
        Node node = new Node(element);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to add
     */
    public void addLast(T element) {
        Node node = new Node(element);
        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * Clears all elements from the list.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Checks if the list contains the specified element.
     * @param element the element to search for
     * @return true if found
     */
    public boolean contains(T element) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.equals(element)) return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * Returns the element at the given index.
     * @param index zero-based index
     * @return the element at that position
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T get(int index) {
        checkIndex(index);
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.data;
    }

    /**
     * Returns the first element without removing it.
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        return head.data;
    }

    /**
     * Returns the last element without removing it.
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        return tail.data;
    }

    /**
     * Returns true if the list has no elements.
     * @return true if empty
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns the number of elements in the list.
     * @return list size
     */
    public int size() { return size; }

    /**
     * Removes and returns the first element.
     * @return the removed first element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    /**
     * Removes and returns the last element.
     * @return the removed last element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return data;
    }

    /**
     * Removes the element at the specified index.
     * @param index the index to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        return cur.data;
    }

    /**
     * Removes the first occurrence of the specified element.
     * @param element the element to remove
     * @return true if removed, false if not found
     */
    public boolean remove(T element) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.equals(element)) {
                if (cur == head) { removeFirst(); return true; }
                if (cur == tail) { removeLast(); return true; }
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * Converts the list to an Object array in order.
     * @return an array of all elements
     */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node cur = head;
        for (int i = 0; i < size; i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }
        return arr;
    }

    /**
     * Returns a ListIterator over elements in this list starting from the front.
     * @return a ListIterator
     */
    @Override
    public ListIterator<T> iterator() {
        return new GenericIterator();
    }

    /** Validates that an index is within bounds. */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Inner class implementing ListIterator for forward and backward traversal.
     */
    private class GenericIterator implements ListIterator<T> {
        private Node nextNode;   // node to be returned by next()
        private Node lastReturned; // last node returned by next() or previous()
        private int cursor;

        /** Constructs an iterator starting at the head. */
        GenericIterator() {
            nextNode = head;
            lastReturned = null;
            cursor = 0;
        }

        /** @return true if there is a next element */
        @Override
        public boolean hasNext() { return nextNode != null; }

        /**
         * Returns the next element and advances the cursor.
         * @return the next element
         * @throws NoSuchElementException if no next element
         */
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = nextNode;
            nextNode = nextNode.next;
            cursor++;
            return lastReturned.data;
        }

        /** @return true if there is a previous element */
        @Override
        public boolean hasPrevious() { return cursor > 0; }

        /**
         * Returns the previous element and moves the cursor backward.
         * @return the previous element
         * @throws NoSuchElementException if no previous element
         */
        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (nextNode == null) nextNode = tail;
            else nextNode = nextNode.prev;
            lastReturned = nextNode;
            cursor--;
            return lastReturned.data;
        }

        /**
         * Removes the node last returned by next() or previous().
         * @throws IllegalStateException if next/previous has not been called, or remove was already called
         */
        @Override
        public void remove() {
            if (lastReturned == null) throw new IllegalStateException();
            Node toRemove = lastReturned;
            if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
            else head = toRemove.next;
            if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
            else tail = toRemove.prev;
            // If we just removed what nextNode's previous was, adjust cursor
            if (lastReturned == nextNode) {
                nextNode = toRemove.next;
            } else {
                cursor--;
            }
            size--;
            lastReturned = null;
        }

        /** @return the index of the element that would be returned by next() */
        @Override
        public int nextIndex() { return cursor; }

        /** @return the index of the element that would be returned by previous() */
        @Override
        public int previousIndex() { return cursor - 1; }

        /** Not supported. */
        @Override
        public void set(T e) { throw new UnsupportedOperationException(); }

        /** Not supported. */
        @Override
        public void add(T e) { throw new UnsupportedOperationException(); }
    }
}
