/**
 * Simulates a warehouse order processing system.
 *
 * Each minute (tick):
 *  1. One order is released into the priority queue and stamped with the current minute.
 *  2. The highest-priority order (earliest deadline; ties broken by earliest arrival) is shipped.
 *  3. If the order shipped after its deadline, it is pushed onto the returns stack.
 *
 * The simulation ends when all orders have been released and the queue is empty.
 */
public class WarehouseSimulation implements SimulationInterface {

    private final Order[] orders;
    private final MyPriorityQueue<Order> queue;
    private final MyStack<Order> returnsStack;
    private final OrderComparator comparator;

    private int currentMinute;
    private int nextOrderIndex; // index of the next order to release
    private int totalArrived;
    private int totalShipped;
    private int totalLate;

    /**
     * Creates a new simulation with the given array of orders.
     * Orders are released one per minute in the array order, starting at minute 0.
     *
     * @param orders the orders to process
     */
    public WarehouseSimulation(Order[] orders) {
        this.orders = orders;
        this.comparator = new OrderComparator();
        // Use MAX_CAPACITY so the queue can hold all orders
        this.queue = new MyPriorityQueue<>(comparator, PriorityQueueADT.MAX_CAPACITY);
        this.returnsStack = new MyStack<>(StackADT.MAX_CAPACITY);
        this.currentMinute = 0;
        this.nextOrderIndex = 0;
        this.totalArrived = 0;
        this.totalShipped = 0;
        this.totalLate = 0;
    }

    /**
     * Advances the simulation by exactly one minute:
     * - Releases the next order (if any) into the queue, stamped with the current minute.
     * - Ships the highest-priority order (if the queue is non-empty).
     * - If the shipped order is late, pushes it onto the returns stack.
     * - Increments the current minute.
     */
    @Override
    public void tick() {
        // 1. Release one order if available
        if (nextOrderIndex < orders.length) {
            Order arriving = orders[nextOrderIndex++];
            arriving.setArrivalMinute(currentMinute);
            queue.enqueue(arriving);
            totalArrived++;
        }

        // 2. Ship the highest-priority order
        if (!queue.isEmpty()) {
            Order shipping = queue.dequeue();
            totalShipped++;
            // Late if shipped AFTER the deadline (current minute > deadline)
            if (currentMinute > shipping.getDeadlineMinute()) {
                totalLate++;
                returnsStack.push(shipping);
            }
        }

        // 3. Advance time
        currentMinute++;
    }

    /**
     * Returns true when all orders have been released and the queue is empty.
     * @return true if simulation is finished
     */
    @Override
    public boolean isFinished() {
        return nextOrderIndex >= orders.length && queue.isEmpty();
    }

    /**
     * Returns the current simulation time in minutes.
     * @return current minute
     */
    @Override
    public int getCurrentMinute() {
        return currentMinute;
    }

    /**
     * Returns the total number of orders that have arrived (been released).
     * @return total arrived
     */
    @Override
    public int getTotalArrived() {
        return totalArrived;
    }

    /**
     * Returns the total number of orders that have been shipped.
     * @return total shipped
     */
    @Override
    public int getTotalShipped() {
        return totalShipped;
    }

    /**
     * Returns the total number of orders that shipped late.
     * @return total late
     */
    @Override
    public int getTotalLate() {
        return totalLate;
    }

    /**
     * Returns the returns stack (orders that shipped late).
     * @return the returns stack
     */
    public MyStack<Order> getReturnsStack() {
        return returnsStack;
    }

    /**
     * Returns the current priority queue of pending orders.
     * @return the order queue
     */
    public MyPriorityQueue<Order> getQueue() {
        return queue;
    }
}
