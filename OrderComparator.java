import java.util.Comparator;

/**
 * Comparator for Orders: sorts by earliest deadline first.
 * If deadlines are tied, sorts by earliest arrival time first.
 */
public class OrderComparator implements Comparator<Order> {

    /**
     * Compares two orders for priority ordering.
     * @param o1 first order
     * @param o2 second order
     * @return negative if o1 has higher priority, positive if o2 does, 0 if equal
     */
    @Override
    public int compare(Order o1, Order o2) {
        int deadlineCmp = Integer.compare(o1.getDeadlineMinute(), o2.getDeadlineMinute());
        if (deadlineCmp != 0) {
            return deadlineCmp;
        }
        return Integer.compare(o1.getArrivalMinute(), o2.getArrivalMinute());
    }
}
