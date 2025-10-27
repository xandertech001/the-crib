import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testConstructorsAndGetters() {
        Property p = new Property("House", "Town", 1500.0, "Owner", 1, 2, 3, 4);
        assertEquals("House", p.getPropertyName());
        assertEquals("Town", p.getCity());
        assertEquals("Owner", p.getOwner());
        assertEquals(1500.0, p.getRentAmount(), 0.0001);
        assertEquals("1,2,3,4", p.getPlot().toString());
    }

    @Test
    public void testToStringFormat() {
        Property p = new Property("A", "B", 100, "C");
        assertEquals("A,B,C,100.0", p.toString());
    }

    @Test
    public void testCopyConstructorIndependence() {
        Property a = new Property("X","Y",500,"Z", 2,2,2,2);
        Property b = new Property(a);
        b.setPropertyName("Changed");
        assertEquals("X", a.getPropertyName());
        assertEquals("Changed", b.getPropertyName());
    }
}
