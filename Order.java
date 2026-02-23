/**
 * Represents a warehouse order with an order ID, arrival time, and deadline.
 */
public class Order {
    private String id;
    private int deadlineMinute;
    private int arrivalMinute;

    /**
     * Constructs an Order with the given ID and deadline.
     * @param id the order identifier
     * @param deadlineMinute the minute by which this order must ship
     */
    public Order(String id, int deadlineMinute) {
        this.id = id;
        this.deadlineMinute = deadlineMinute;
        this.arrivalMinute = -1; // not yet set
    }

    /**
     * Sets the arrival minute for this order.
     * @param arrivalMinute the minute this order arrived
     */
    public void setArrivalMinute(int arrivalMinute) {
        this.arrivalMinute = arrivalMinute;
    }

    /**
     * Returns the arrival minute of this order.
     * @return arrival minute
     */
    public int getArrivalMinute() {
        return arrivalMinute;
    }

    /**
     * Returns the deadline minute of this order.
     * @return deadline minute
     */
    public int getDeadlineMinute() {
        return deadlineMinute;
    }

    /**
     * Returns the order ID.
     * @return order ID
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order[id=" + id + ", deadline=" + deadlineMinute + ", arrival=" + arrivalMinute + "]";
    }
}
