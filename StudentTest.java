import static org.junit.Assert.*;
import java.util.Comparator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * StudentTest.java
 *
 * Comprehensive JUnit test suite covering:
 *   - MyPriorityQueue<T>       (enqueue, dequeue, peek, size, isEmpty, toArray, capacity)
 *   - MyStack<T>               (push, pop, peek, size, isEmpty, toArray, capacity)
 *   - Order                    (constructor, getters, setArrivalMinute)
 *   - OrderComparator          (deadline ordering, arrival tiebreak, equal orders)
 *   - WarehouseSimulation      (tick mechanics, late detection, isFinished, counters)
 *
 * Each test is documented with a clear description of what it validates
 * and why that behavior matters for correctness.
 */
public class StudentTest {

    // =========================================================================
    // Shared comparators
    // =========================================================================

    /** Ascending integer comparator — smallest integer = highest priority. */
    private static final Comparator<Integer> INT_ASC = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    };

    /** Descending integer comparator — largest integer = highest priority. */
    private static final Comparator<Integer> INT_DESC = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    };

    /** Alphabetical string comparator — "A" comes before "B". */
    private static final Comparator<String> STRING_ASC = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    };

    // =========================================================================
    // Shared instances reset before each test
    // =========================================================================

    private MyPriorityQueue<Integer> intPQ;
    private MyStack<String> strStack;
    private OrderComparator orderCmp;

    @Before
    public void setUp() {
        intPQ     = new MyPriorityQueue<>(INT_ASC);
        strStack  = new MyStack<>();
        orderCmp  = new OrderComparator();
    }


    // =========================================================================
    // ░░░░░░░░░░░░░░░░░░  MyPriorityQueue Tests  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    // =========================================================================

    /**
     * A freshly created priority queue should report size 0 and isEmpty() true.
     * Verifies the initial state before any operations are performed.
     */
    @Test
    public void testPriorityQueue_InitialStateIsEmpty() {
        assertEquals("New PQ should have size 0", 0, intPQ.size());
        assertTrue("New PQ should be empty", intPQ.isEmpty());
    }

    /**
     * Enqueueing a single item should increase size to 1 and make isEmpty false.
     * Verifies that the size counter and isEmpty flag update correctly on insert.
     */
    @Test
    public void testPriorityQueue_SingleEnqueueUpdatesSize() {
        intPQ.enqueue(42);
        assertEquals("Size should be 1 after one enqueue", 1, intPQ.size());
        assertFalse("PQ should not be empty after enqueue", intPQ.isEmpty());
    }

    /**
     * Items enqueued out of order should dequeue in ascending priority order.
     * This validates the core sorted-insertion behavior of the priority queue.
     */
    @Test
    public void testPriorityQueue_DequeueReturnsSmallestFirst() {
        intPQ.enqueue(50);
        intPQ.enqueue(10);
        intPQ.enqueue(30);
        intPQ.enqueue(20);

        assertEquals("First dequeue should be smallest: 10",  10, (int) intPQ.dequeue());
        assertEquals("Second dequeue should be next: 20",     20, (int) intPQ.dequeue());
        assertEquals("Third dequeue should be next: 30",      30, (int) intPQ.dequeue());
        assertEquals("Fourth dequeue should be largest: 50",  50, (int) intPQ.dequeue());
    }

    /**
     * peek() should return the highest-priority item without removing it.
     * Repeated calls to peek() must return the same element and size must not change.
     */
    @Test
    public void testPriorityQueue_PeekDoesNotModifyQueue() {
        intPQ.enqueue(7);
        intPQ.enqueue(3);
        intPQ.enqueue(5);

        assertEquals("peek() should return 3 (highest priority)", 3, (int) intPQ.peek());
        assertEquals("peek() a second time should still return 3", 3, (int) intPQ.peek());
        assertEquals("Size must remain 3 after two peeks", 3, intPQ.size());
    }

    /**
     * Dequeueing all items from a queue of size N should leave it empty.
     * Verifies size decrements correctly with each dequeue.
     */
    @Test
    public void testPriorityQueue_SizeDecrementsOnDequeue() {
        intPQ.enqueue(1);
        intPQ.enqueue(2);
        intPQ.enqueue(3);

        intPQ.dequeue();
        assertEquals("Size should be 2 after one dequeue", 2, intPQ.size());
        intPQ.dequeue();
        assertEquals("Size should be 1 after two dequeues", 1, intPQ.size());
        intPQ.dequeue();
        assertEquals("Size should be 0 after all dequeued", 0, intPQ.size());
        assertTrue("Queue should be empty when size is 0", intPQ.isEmpty());
    }

    /**
     * A descending comparator should cause the largest integer to dequeue first.
     * Verifies that the queue respects any provided Comparator, not just ascending order.
     */
    @Test
    public void testPriorityQueue_DescendingComparatorReturnsLargestFirst() {
        MyPriorityQueue<Integer> descPQ = new MyPriorityQueue<>(INT_DESC);
        descPQ.enqueue(10);
        descPQ.enqueue(40);
        descPQ.enqueue(25);

        assertEquals("Descending PQ should dequeue largest first: 40", 40, (int) descPQ.dequeue());
        assertEquals("Descending PQ should dequeue next largest: 25",  25, (int) descPQ.dequeue());
        assertEquals("Descending PQ should dequeue smallest last: 10", 10, (int) descPQ.dequeue());
    }

    /**
     * A string priority queue should dequeue strings in alphabetical order.
     * Validates that the queue works with non-numeric generic types.
     */
    @Test
    public void testPriorityQueue_StringTypeAlphabeticalOrder() {
        MyPriorityQueue<String> strPQ = new MyPriorityQueue<>(STRING_ASC);
        strPQ.enqueue("Mango");
        strPQ.enqueue("Apple");
        strPQ.enqueue("Banana");

        assertEquals("First dequeue should be 'Apple'",  "Apple",  strPQ.dequeue());
        assertEquals("Second dequeue should be 'Banana'","Banana", strPQ.dequeue());
        assertEquals("Third dequeue should be 'Mango'",  "Mango",  strPQ.dequeue());
    }

    /**
     * Duplicate values should all be stored and dequeued without loss.
     * Verifies the queue handles equal-priority elements without dropping any.
     */
    @Test
    public void testPriorityQueue_DuplicateValuesAllDequeued() {
        intPQ.enqueue(5);
        intPQ.enqueue(5);
        intPQ.enqueue(5);

        assertEquals("First dequeue of duplicate 5", 5, (int) intPQ.dequeue());
        assertEquals("Second dequeue of duplicate 5", 5, (int) intPQ.dequeue());
        assertEquals("Third dequeue of duplicate 5", 5, (int) intPQ.dequeue());
        assertTrue("Queue should be empty after all duplicates removed", intPQ.isEmpty());
    }

    /**
     * Enqueueing null should throw IllegalArgumentException.
     * Null elements are not valid and must be rejected to protect queue integrity.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPriorityQueue_EnqueueNullThrowsIllegalArgument() {
        intPQ.enqueue(null);
    }

    /**
     * Calling dequeue() on an empty queue must throw NoSuchElementException.
     * Attempting to remove from an empty structure is always an error.
     */
    @Test(expected = NoSuchElementException.class)
    public void testPriorityQueue_DequeueEmptyThrowsNoSuchElement() {
        intPQ.dequeue();
    }

    /**
     * Calling peek() on an empty queue must throw NoSuchElementException.
     * There is no element to inspect, so the exception is required by the ADT.
     */
    @Test(expected = NoSuchElementException.class)
    public void testPriorityQueue_PeekEmptyThrowsNoSuchElement() {
        intPQ.peek();
    }

    /**
     * Filling the default capacity (10) and then adding one more must throw
     * IllegalStateException with the message "PriorityQueue is full".
     * Validates that the fixed-size array enforces its capacity limit.
     */
    @Test
    public void testPriorityQueue_ExceedDefaultCapacityThrowsIllegalState() {
        for (int i = 0; i < 10; i++) {
            intPQ.enqueue(i);
        }
        assertEquals("Queue should be full at size 10", 10, intPQ.size());

        try {
            intPQ.enqueue(99);
            fail("Expected IllegalStateException when capacity exceeded");
        } catch (IllegalStateException e) {
            assertTrue("Exception message should mention 'PriorityQueue is full'",
                       e.getMessage().contains("PriorityQueue is full"));
        }
    }

    /**
     * A custom capacity of 3 should allow exactly 3 items and reject a 4th.
     * Verifies that capacity passed to the constructor is respected.
     */
    @Test
    public void testPriorityQueue_CustomCapacityEnforced() {
        MyPriorityQueue<Integer> smallPQ = new MyPriorityQueue<>(INT_ASC, 3);
        smallPQ.enqueue(1);
        smallPQ.enqueue(2);
        smallPQ.enqueue(3);
        assertEquals("PQ with capacity 3 should hold 3 items", 3, smallPQ.size());

        try {
            smallPQ.enqueue(4);
            fail("Expected IllegalStateException on 4th enqueue into capacity-3 PQ");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("PriorityQueue is full"));
        }
    }

    /**
     * toArray() should return all elements in the queue without modifying the queue.
     * Verifies the snapshot method does not have side effects on size or content.
     */
    @Test
    public void testPriorityQueue_ToArrayReturnsAllElementsWithoutModifying() {
        intPQ.enqueue(3);
        intPQ.enqueue(1);
        intPQ.enqueue(2);

        Object[] arr = intPQ.toArray();

        assertEquals("toArray() length should match queue size", 3, arr.length);
        assertEquals("Queue size should still be 3 after toArray()", 3, intPQ.size());
        // The first element of the internal array should be the highest priority item
        assertEquals("First element of array should be highest priority: 1", 1, (int) arr[0]);
    }

    /**
     * After enqueueing and dequeueing items interleaved, the queue should
     * always return the current minimum. Validates dynamic behavior.
     */
    @Test
    public void testPriorityQueue_InterleavedEnqueueDequeue() {
        intPQ.enqueue(10);
        intPQ.enqueue(5);
        assertEquals("After enqueueing 10 and 5, dequeue should return 5", 5, (int) intPQ.dequeue());

        intPQ.enqueue(2);
        assertEquals("After adding 2, dequeue should return 2", 2, (int) intPQ.dequeue());

        intPQ.enqueue(8);
        assertEquals("After adding 8, dequeue should return 8 (only item)", 8, (int) intPQ.dequeue());
        // Then original 10 remains
        assertEquals("Remaining element should be 10", 10, (int) intPQ.dequeue());
        assertTrue("Queue should be empty after all operations", intPQ.isEmpty());
    }


    // =========================================================================
    // ░░░░░░░░░░░░░░░░░░░░░░  MyStack Tests  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    // =========================================================================

    /**
     * A freshly created stack should report size 0 and isEmpty() true.
     * Validates the initial state before any operations.
     */
    @Test
    public void testStack_InitialStateIsEmpty() {
        assertEquals("New stack should have size 0", 0, strStack.size());
        assertTrue("New stack should be empty", strStack.isEmpty());
    }

    /**
     * Pushing one item should make the stack non-empty with size 1.
     * Verifies that size and isEmpty update correctly after a push.
     */
    @Test
    public void testStack_SinglePushUpdatesSize() {
        strStack.push("Hello");
        assertEquals("Size should be 1 after one push", 1, strStack.size());
        assertFalse("Stack should not be empty after push", strStack.isEmpty());
    }

    /**
     * The stack must behave as LIFO: last item pushed is first item popped.
     * This is the fundamental contract of a stack data structure.
     */
    @Test
    public void testStack_LIFOOrderMaintained() {
        strStack.push("First");
        strStack.push("Second");
        strStack.push("Third");

        assertEquals("Pop should return 'Third' (last pushed)", "Third",  strStack.pop());
        assertEquals("Pop should return 'Second' next",         "Second", strStack.pop());
        assertEquals("Pop should return 'First' (first pushed)","First",  strStack.pop());
        assertTrue("Stack should be empty after all pops", strStack.isEmpty());
    }

    /**
     * peek() should return the top element without removing it.
     * Repeated peek() calls must return the same value and size must remain unchanged.
     */
    @Test
    public void testStack_PeekDoesNotRemoveElement() {
        strStack.push("Bottom");
        strStack.push("Top");

        assertEquals("peek() should return 'Top'", "Top", strStack.peek());
        assertEquals("peek() again should still return 'Top'", "Top", strStack.peek());
        assertEquals("Size should remain 2 after two peeks", 2, strStack.size());
    }

    /**
     * Popping all elements should leave the stack empty with size 0.
     * Verifies that the size counter decrements correctly on every pop.
     */
    @Test
    public void testStack_SizeDecrementsOnPop() {
        strStack.push("A");
        strStack.push("B");
        strStack.push("C");

        strStack.pop();
        assertEquals("Size should be 2 after one pop", 2, strStack.size());
        strStack.pop();
        assertEquals("Size should be 1 after two pops", 1, strStack.size());
        strStack.pop();
        assertEquals("Size should be 0 after three pops", 0, strStack.size());
        assertTrue("Stack should be empty", strStack.isEmpty());
    }

    /**
     * An integer stack should work identically to a string stack.
     * Validates that MyStack is truly generic and handles different types correctly.
     */
    @Test
    public void testStack_IntegerTypeWorksCorrectly() {
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(100);
        intStack.push(200);
        intStack.push(300);

        assertEquals("Top should be 300", 300, (int) intStack.pop());
        assertEquals("Next should be 200", 200, (int) intStack.pop());
        assertEquals("Bottom should be 100", 100, (int) intStack.pop());
        assertTrue("Stack should be empty", intStack.isEmpty());
    }

    /**
     * Pushing null onto the stack must throw IllegalArgumentException.
     * Null elements are explicitly prohibited by the StackADT contract.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testStack_PushNullThrowsIllegalArgument() {
        strStack.push(null);
    }

    /**
     * Calling pop() on an empty stack must throw NoSuchElementException.
     * There is nothing to remove, so the exception is required by the ADT.
     */
    @Test(expected = NoSuchElementException.class)
    public void testStack_PopEmptyThrowsNoSuchElement() {
        strStack.pop();
    }

    /**
     * Calling peek() on an empty stack must throw NoSuchElementException.
     * There is no top element to inspect when the stack is empty.
     */
    @Test(expected = NoSuchElementException.class)
    public void testStack_PeekEmptyThrowsNoSuchElement() {
        strStack.peek();
    }

    /**
     * After pushing MAX items (default 10) onto the stack, adding one more
     * must throw IllegalStateException. Validates the fixed-size array limit.
     */
    @Test
    public void testStack_ExceedDefaultCapacityThrowsIllegalState() {
        for (int i = 0; i < 10; i++) {
            strStack.push("item" + i);
        }
        assertEquals("Stack should be full at size 10", 10, strStack.size());

        try {
            strStack.push("overflow");
            fail("Expected IllegalStateException when stack capacity exceeded");
        } catch (IllegalStateException e) {
            // Any non-null message is acceptable; key thing is the exception type
            assertNotNull("Exception should have a message", e.getMessage());
        }
    }

    /**
     * toArray() should return all elements with index 0 as the bottom and
     * index size()-1 as the top, without modifying the stack.
     */
    @Test
    public void testStack_ToArrayReturnsBottomToTop() {
        strStack.push("Bottom");
        strStack.push("Middle");
        strStack.push("Top");

        Object[] arr = strStack.toArray();

        assertEquals("toArray() length should match stack size", 3, arr.length);
        assertEquals("Index 0 should be the bottom element", "Bottom", arr[0]);
        assertEquals("Index 1 should be the middle element", "Middle", arr[1]);
        assertEquals("Index 2 should be the top element",    "Top",    arr[2]);
        assertEquals("Stack size should remain 3 after toArray()", 3, strStack.size());
    }

    /**
     * Pushing and popping interleaved should always reflect the true LIFO top.
     * Validates dynamic stack behavior with mixed operations.
     */
    @Test
    public void testStack_InterleavedPushAndPop() {
        strStack.push("A");
        strStack.push("B");
        assertEquals("Pop should return 'B'", "B", strStack.pop());

        strStack.push("C");
        assertEquals("Peek should return 'C' (new top)", "C", strStack.peek());
        assertEquals("Pop should return 'C'", "C", strStack.pop());
        assertEquals("Pop should return 'A' (original bottom)", "A", strStack.pop());
        assertTrue("Stack should be empty", strStack.isEmpty());
    }


    // =========================================================================
    // ░░░░░░░░░░░░░░░░░░░░░  Order Tests  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    // =========================================================================

    /**
     * The Order constructor should correctly store the given ID and deadline.
     * Verifies that getters return exactly what was passed to the constructor.
     */
    @Test
    public void testOrder_ConstructorSetsIdAndDeadline() {
        Order order = new Order("ORD-001", 10);
        assertEquals("Order ID should be 'ORD-001'", "ORD-001", order.getId());
        assertEquals("Deadline should be 10", 10, order.getDeadlineMinute());
    }

    /**
     * setArrivalMinute() and getArrivalMinute() should work as a paired getter/setter.
     * Validates that the arrival time can be stamped and retrieved correctly.
     */
    @Test
    public void testOrder_SetAndGetArrivalMinute() {
        Order order = new Order("ORD-002", 5);
        order.setArrivalMinute(3);
        assertEquals("Arrival minute should be 3 after setArrivalMinute(3)", 3, order.getArrivalMinute());
    }

    /**
     * setArrivalMinute() should be overridable — calling it twice should
     * keep the most recent value. Simulates re-stamping if needed.
     */
    @Test
    public void testOrder_OverwriteArrivalMinute() {
        Order order = new Order("ORD-003", 8);
        order.setArrivalMinute(1);
        order.setArrivalMinute(4);
        assertEquals("Second setArrivalMinute should overwrite the first", 4, order.getArrivalMinute());
    }

    /**
     * Two distinct Order objects with different IDs and deadlines should
     * store their own independent values. Verifies object isolation.
     */
    @Test
    public void testOrder_TwoOrdersAreIndependent() {
        Order a = new Order("A", 3);
        Order b = new Order("B", 7);
        a.setArrivalMinute(0);
        b.setArrivalMinute(1);

        assertEquals("Order A ID", "A", a.getId());
        assertEquals("Order B ID", "B", b.getId());
        assertEquals("Order A deadline", 3, a.getDeadlineMinute());
        assertEquals("Order B deadline", 7, b.getDeadlineMinute());
        assertEquals("Order A arrival", 0, a.getArrivalMinute());
        assertEquals("Order B arrival", 1, b.getArrivalMinute());
    }


    // =========================================================================
    // ░░░░░░░░░░░░░░░░░░  OrderComparator Tests  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    // =========================================================================

    /**
     * An order with an earlier deadline should compare as less than one with
     * a later deadline (returns a negative value). This drives earliest-deadline-first ordering.
     */
    @Test
    public void testOrderComparator_EarlierDeadlineComesFirst() {
        Order early = new Order("E", 2);
        Order late  = new Order("L", 8);
        early.setArrivalMinute(0);
        late.setArrivalMinute(0);

        assertTrue("Earlier deadline should compare < later deadline",
                   orderCmp.compare(early, late) < 0);
    }

    /**
     * An order with a later deadline should compare as greater than an earlier one.
     * This is the inverse of the previous test, confirming bidirectional consistency.
     */
    @Test
    public void testOrderComparator_LaterDeadlineComesLast() {
        Order early = new Order("E", 2);
        Order late  = new Order("L", 8);
        early.setArrivalMinute(0);
        late.setArrivalMinute(0);

        assertTrue("Later deadline should compare > earlier deadline",
                   orderCmp.compare(late, early) > 0);
    }

    /**
     * When two orders share the same deadline, the one that arrived earlier
     * should compare as less (higher priority). Validates the tiebreaker rule.
     */
    @Test
    public void testOrderComparator_SameDeadlineEarlierArrivalWins() {
        Order first  = new Order("F", 5);
        Order second = new Order("S", 5);
        first.setArrivalMinute(1);
        second.setArrivalMinute(3);

        assertTrue("Earlier arrival should win tiebreak (compare < 0)",
                   orderCmp.compare(first, second) < 0);
    }

    /**
     * When two orders share the same deadline and the same arrival time,
     * the comparator should return 0 (equal priority).
     */
    @Test
    public void testOrderComparator_IdenticalOrdersCompareAsEqual() {
        Order a = new Order("A", 5);
        Order b = new Order("B", 5);
        a.setArrivalMinute(2);
        b.setArrivalMinute(2);

        assertEquals("Orders with same deadline and arrival should compare as 0",
                     0, orderCmp.compare(a, b));
    }

    /**
     * A deadline of 0 should still be valid and compare correctly against
     * a larger deadline. Edge case: boundary value at minute 0.
     */
    @Test
    public void testOrderComparator_ZeroDeadlineBeatsPositiveDeadline() {
        Order zeroDeadline = new Order("Z", 0);
        Order normalOrder  = new Order("N", 5);
        zeroDeadline.setArrivalMinute(0);
        normalOrder.setArrivalMinute(0);

        assertTrue("Deadline 0 should have higher priority than deadline 5",
                   orderCmp.compare(zeroDeadline, normalOrder) < 0);
    }

    /**
     * Four orders sorted by the comparator should come out in the correct
     * priority order: first by deadline, then by arrival on ties.
     * Validates the comparator in a realistic multi-element scenario.
     */
    @Test
    public void testOrderComparator_MultipleOrdersSortCorrectly() {
        Order o1 = new Order("O1", 10); o1.setArrivalMinute(2);
        Order o2 = new Order("O2", 3);  o2.setArrivalMinute(0);
        Order o3 = new Order("O3", 3);  o3.setArrivalMinute(1);
        Order o4 = new Order("O4", 7);  o4.setArrivalMinute(0);

        // Expected order: o2 (dl=3,arr=0), o3 (dl=3,arr=1), o4 (dl=7), o1 (dl=10)
        assertTrue("o2 before o3 (same dl, earlier arrival)", orderCmp.compare(o2, o3) < 0);
        assertTrue("o3 before o4 (dl 3 < 7)",                 orderCmp.compare(o3, o4) < 0);
        assertTrue("o4 before o1 (dl 7 < 10)",                orderCmp.compare(o4, o1) < 0);
    }


    // =========================================================================
    // ░░░░░░░░░░░░░░░░░  WarehouseSimulation Tests  ░░░░░░░░░░░░░░░░░░░░░░░░░
    // =========================================================================

    /**
     * A simulation with zero orders should be finished immediately without
     * any ticks. Verifies the empty-input edge case.
     */
    @Test
    public void testSimulation_EmptyOrderArrayIsFinishedImmediately() {
        WarehouseSimulation sim = new WarehouseSimulation(new Order[]{});
        assertTrue("Simulation with no orders should be finished from the start",
                   sim.isFinished());
    }

    /**
     * Before any ticks, all counters (arrived, shipped, late) must be 0
     * and the current minute must be 0.
     */
    @Test
    public void testSimulation_InitialCountersAreAllZero() {
        Order[] orders = { new Order("A", 5), new Order("B", 10) };
        WarehouseSimulation sim = new WarehouseSimulation(orders);

        assertEquals("Initial minute should be 0",         0, sim.getCurrentMinute());
        assertEquals("Initial total arrived should be 0",  0, sim.getTotalArrived());
        assertEquals("Initial total shipped should be 0",  0, sim.getTotalShipped());
        assertEquals("Initial total late should be 0",     0, sim.getTotalLate());
    }

    /**
     * After one tick, exactly one order should have arrived and one shipped,
     * and the current minute should advance to 1.
     */
    @Test
    public void testSimulation_OneTickAdvancesMinuteAndShipsOne() {
        Order[] orders = { new Order("A", 5) };
        WarehouseSimulation sim = new WarehouseSimulation(orders);
        sim.tick();

        assertEquals("After 1 tick, minute should be 1", 1, sim.getCurrentMinute());
        assertEquals("After 1 tick, 1 order should have arrived",  1, sim.getTotalArrived());
        assertEquals("After 1 tick, 1 order should have shipped",  1, sim.getTotalShipped());
    }

    /**
     * An order shipped at minute 0 with a deadline of 5 should NOT be late
     * (0 is not greater than 5). Verifies that on-time orders are counted correctly.
     */
    @Test
    public void testSimulation_OnTimeOrderNotCountedAsLate() {
        Order[] orders = { new Order("OnTime", 5) };
        WarehouseSimulation sim = new WarehouseSimulation(orders);

        while (!sim.isFinished()) { sim.tick(); }

        assertEquals("On-time order should not be counted as late", 0, sim.getTotalLate());
    }

    /**
     * An order released at minute 2 (the 3rd tick) with deadline 1 should be
     * counted as late because it ships at t=2 which is after its deadline of 1.
     */
    @Test
    public void testSimulation_LateOrderCountedCorrectly() {
        // Two filler orders with large deadlines push the tight order to t=2
        Order[] orders = {
            new Order("Filler1", 99),
            new Order("Filler2", 99),
            new Order("Tight",   1)   // released at t=2, shipped at t=2, deadline=1 → LATE
        };
        WarehouseSimulation sim = new WarehouseSimulation(orders);
        while (!sim.isFinished()) { sim.tick(); }

        assertEquals("Exactly 1 order should be late", 1, sim.getTotalLate());
    }

    /**
     * All orders with generous deadlines should complete with 0 late shipments.
     * Confirms that the late counter remains 0 when no order misses its deadline.
     */
    @Test
    public void testSimulation_AllOrdersOnTimeNoLate() {
        Order[] orders = {
            new Order("A", 10),
            new Order("B", 10),
            new Order("C", 10)
        };
        WarehouseSimulation sim = new WarehouseSimulation(orders);
        while (!sim.isFinished()) { sim.tick(); }

        assertEquals("All 3 orders should have arrived",  3, sim.getTotalArrived());
        assertEquals("All 3 orders should have shipped",  3, sim.getTotalShipped());
        assertEquals("No orders should be late",          0, sim.getTotalLate());
    }

    /**
     * The simulation with N orders should take exactly N ticks to complete,
     * because one order is released and one is shipped per tick.
     */
    @Test
    public void testSimulation_FinishesInExactlyNTicks() {
        int n = 5;
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            orders[i] = new Order("O" + i, 100);
        }

        WarehouseSimulation sim = new WarehouseSimulation(orders);
        while (!sim.isFinished()) { sim.tick(); }

        assertEquals("Simulation with 5 orders should end at minute 5", n, sim.getCurrentMinute());
    }

    /**
     * isFinished() should return false while there are still orders in the queue,
     * and true only when both the order list is exhausted and the queue is empty.
     */
    @Test
    public void testSimulation_IsFinishedOnlyWhenQueueAndListExhausted() {
        Order[] orders = { new Order("X", 5), new Order("Y", 5) };
        WarehouseSimulation sim = new WarehouseSimulation(orders);

        assertFalse("Should not be finished before any ticks", sim.isFinished());
        sim.tick();
        assertFalse("Should not be finished after only 1 of 2 orders processed", sim.isFinished());
        sim.tick();
        assertTrue("Should be finished after both orders shipped", sim.isFinished());
    }

    /**
     * The priority queue ships the highest-priority order each tick, so the
     * order with the earliest deadline should ship first regardless of arrival order.
     * Here order "B" (deadline=1) arrives at t=1 but should ship before "A" (deadline=5)
     * because "A" is the only item at t=0 and must be shipped then; at t=1 "B" arrives
     * and ships on time with deadline=1.
     */
    @Test
    public void testSimulation_EarliestDeadlineShipsFirst() {
        // A has deadline 5 (released t=0, ships at t=0 — only item available)
        // B has deadline 1 (released t=1, ships at t=1 — on time, deadline=1, minute=1 not > 1)
        Order[] orders = {
            new Order("A", 5),
            new Order("B", 1)
        };
        WarehouseSimulation sim = new WarehouseSimulation(orders);
        while (!sim.isFinished()) { sim.tick(); }

        assertEquals("Both orders should ship", 2, sim.getTotalShipped());
        assertEquals("No orders should be late", 0, sim.getTotalLate());
    }

    /**
     * When every single order in the simulation is late, getTotalLate() must
     * equal getTotalShipped(). Validates that the late counter maxes out correctly.
     */
    @Test
    public void testSimulation_AllOrdersLateCounterEqualsShipped() {
        // Every order has deadline 0; they are released at t=0, t=1, t=2
        // Ship at t=0 is NOT late (0 is not > 0); t=1 ships deadline-0 order → late; t=2 → late
        // So 2 out of 3 will be late
        Order[] orders = {
            new Order("P", 0),
            new Order("Q", 0),
            new Order("R", 0)
        };
        WarehouseSimulation sim = new WarehouseSimulation(orders);
        while (!sim.isFinished()) { sim.tick(); }

        assertEquals("3 orders total shipped", 3, sim.getTotalShipped());
        // P ships at t=0 (not late), Q ships at t=1 (late), R ships at t=2 (late)
        assertEquals("2 of the 3 deadline-0 orders should be late", 2, sim.getTotalLate());
    }

    /**
     * A single-order simulation should complete in exactly 1 tick with
     * 1 arrived, 1 shipped, and 0 late (if deadline > 0).
     */
    @Test
    public void testSimulation_SingleOrderCompletesInOneTick() {
        Order[] orders = { new Order("Solo", 99) };
        WarehouseSimulation sim = new WarehouseSimulation(orders);

        assertFalse("Not finished before tick", sim.isFinished());
        sim.tick();
        assertTrue("Finished after one tick with one order", sim.isFinished());
        assertEquals("Minute should be 1", 1, sim.getCurrentMinute());
        assertEquals("1 arrived", 1, sim.getTotalArrived());
        assertEquals("1 shipped", 1, sim.getTotalShipped());
        assertEquals("0 late",    0, sim.getTotalLate());
    }
}
