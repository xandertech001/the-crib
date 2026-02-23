import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A generic priority queue backed by a regular array.
 * Elements are maintained in sorted order according to the provided Comparator.
 * Default capacity is 10; maximum capacity is 1000.
 *
 * @param <T> the type of elements stored in this priority queue
 */
public class MyPriorityQueue<T> implements PriorityQueueADT<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;
    private final Comparator<T> comparator;
    private final int capacity;

    /**
     * Creates a priority queue with the default capacity of 10.
     * @param comparator the comparator used to order elements
     */
    public MyPriorityQueue(Comparator<T> comparator) {
        this(comparator, DEFAULT_CAPACITY);
    }

    /**
     * Creates a priority queue with the given capacity.
     * @param comparator the comparator used to order elements
     * @param capacity   the maximum number of elements allowed
     * @throws IllegalArgumentException if capacity is less than 1 or exceeds MAX_CAPACITY
     */
    public MyPriorityQueue(Comparator<T> comparator, int capacity) {
        if (capacity < 1 || capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Capacity must be between 1 and " + MAX_CAPACITY);
        }
        this.comparator = comparator;
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.size = 0;
    }

    /**
     * Inserts an item into the queue in priority order (sorted insertion).
     * @param item the element to insert (cannot be null)
     * @throws IllegalArgumentException if item is null
     * @throws IllegalStateException    if the queue is full
     */
    @Override
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size >= capacity) {
            throw new IllegalStateException("PriorityQueue is full");
        }
        // Find insertion point using sorted insertion (ascending by comparator)
        int i = size - 1;
        while (i >= 0 && comparator.compare((T) data[i], item) > 0) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = item;
        size++;
    }

    /**
     * Removes and returns the highest-priority item (index 0).
     * @return the dequeued element
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty");
        }
        T item = (T) data[0];
        // Shift remaining elements left
        System.arraycopy(data, 1, data, 0, size - 1);
        data[size - 1] = null;
        size--;
        return item;
    }

    /**
     * Returns (without removing) the highest-priority item.
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty");
        }
        return (T) data[0];
    }

    /**
     * Checks whether the queue has no elements.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current number of elements in the queue.
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an array containing all elements in their current internal order.
     * @return array of elements
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
}
