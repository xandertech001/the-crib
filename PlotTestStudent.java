import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testConstructorsAndToString() {
        Plot p = new Plot(2, 3, 4, 5);
        assertEquals("2,3,4,5", p.toString());

        Plot copy = new Plot(p);
        assertEquals("2,3,4,5", copy.toString());
    }

    @Test
    public void testEncompassTrue() {
        Plot outer = new Plot(0,0,10,10);
        Plot inner = new Plot(1,1,2,2);
        assertTrue(outer.encompasses(inner));
    }

    @Test
    public void testEncompassEdgeInclusive() {
        Plot outer = new Plot(0,0,10,10);
        Plot edge = new Plot(0,0,10,10);
        assertTrue(outer.encompasses(edge));
    }

    @Test
    public void testOverlapTrue() {
        Plot a = new Plot(2,2,6,6);
        Plot b = new Plot(3,4,4,3);
        assertTrue(a.overlaps(b));
    }

    @Test
    public void testOverlapFalseEdgeTouch() {
        Plot a = new Plot(6,2,3,4);
        Plot b = new Plot(9,2,1,4); // shares vertical edge at x=9
        assertFalse(a.overlaps(b));
    }

    @Test
    public void testOverlapFalseSeparate() {
        Plot a = new Plot(0,0,2,2);
        Plot b = new Plot(3,3,2,2);
        assertFalse(a.overlaps(b));
    }
}
