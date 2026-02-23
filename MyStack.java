import java.util.NoSuchElementException;

/**
 * A generic LIFO stack backed by a regular array.
 * Default capacity is 10; maximum capacity is 1000.
 *
 * @param <T> the type of elements stored in this stack
 */
public class MyStack<T> implements StackADT<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int top; // index of the next free slot (also == current size)
    private final int capacity;

    /**
     * Creates a stack with the default capacity of 10.
     */
    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates a stack with the given capacity.
     * @param capacity the maximum number of elements allowed
     * @throws IllegalArgumentException if capacity is less than 1 or exceeds MAX_CAPACITY
     */
    public MyStack(int capacity) {
        if (capacity < 1 || capacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Capacity must be between 1 and " + MAX_CAPACITY);
        }
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.top = 0;
    }

    /**
     * Pushes an item onto the top of the stack.
     * @param item the element to push (cannot be null)
     * @throws IllegalArgumentException if item is null
     * @throws IllegalStateException    if the stack is full
     */
    @Override
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (top >= capacity) {
            throw new IllegalStateException("Stack is full");
        }
        data[top++] = item;
    }

    /**
     * Removes and returns the top item from the stack.
     * @return the popped element
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = (T) data[--top];
        data[top] = null;
        return item;
    }

    /**
     * Returns the top item of the stack without removing it.
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return (T) data[top - 1];
    }

    /**
     * Checks whether the stack is empty.
     * @return true if the stack has no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns the current number of elements in the stack.
     * @return number of elements
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * Returns an array containing all elements.
     * Index 0 is the bottom of the stack; index size()-1 is the top.
     * @return array of elements
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[top];
        System.arraycopy(data, 0, result, 0, top);
        return result;
    }
}
