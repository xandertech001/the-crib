import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    ManagementCompany mc;

    @Before
    public void setup() {
        mc = new ManagementCompany("Railey", "555555555", 10.0); // default plot 0,0,10,10
    }

    @Test
    public void testAddPropertySuccessAndCount() {
        int idx = mc.addProperty("Almost Aspen","Glendale", 4844.0, "Sammy Smith", 1,1,2,2);
        assertTrue(idx >= 0);
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    public void testAddPropertyNull() {
        int code = mc.addProperty((Property) null);
        assertEquals(-2, code);
    }

    @Test
    public void testAddPropertyNotEncompassed() {
        // property extends outside company plot (company plot default width=10, depth=10 at (0,0))
        int code = mc.addProperty("Out","City",1000,"Me", 9,9,5,5); // right/bottom exceed 10
        assertEquals(-3, code);
    }

    @Test
    public void testAddPropertyOverlap() {
        int a = mc.addProperty("P1","C",100,"O1",1,1,3,3);
        assertTrue(a >= 0);
        int b = mc.addProperty("P2","C",200,"O2",2,2,3,3); // overlaps the first
        assertEquals(-4, b);
    }

    @Test
    public void testIsPropertiesFullAndRemoveLast() {
        mc.addProperty("p1","c",1,"o",0,0,1,1);
        mc.addProperty("p2","c",2,"o",1,0,1,1);
        mc.addProperty("p3","c",3,"o",2,0,1,1);
        mc.addProperty("p4","c",4,"o",3,0,1,1);
        mc.addProperty("p5","c",5,"o",4,0,1,1);
        assertTrue(mc.isPropertiesFull());
        assertEquals(5, mc.getPropertiesCount());
        assertTrue(mc.removeLastProperty());
        assertFalse(mc.isPropertiesFull());
        assertEquals(4, mc.getPropertiesCount());
    }

    @Test
    public void testGetTotalAndHighest() {
        mc = new ManagementCompany("M","T",5.0); // reset
        mc.addProperty("A","c",100,"o",0,0,1,1);
        mc.addProperty("B","c",300,"o",1,0,1,1);
        mc.addProperty("C","c",200,"o",2,0,1,1);
        assertEquals(600.0, mc.getTotalRent(), 0.0001);
        Property highest = mc.getHighestRentProperty();
        assertNotNull(highest);
        assertEquals(300.0, highest.getRentAmount(), 0.0001);
    }

    @Test
    public void testIsManagementFeeValid() {
        mc.setMgmtFee(50.0);
        assertTrue(mc.isManagementFeeValid());
        mc.setMgmtFee(-1.0);
        assertFalse(mc.isManagementFeeValid());
    }

    @Test
    public void testToStringContainsHeader() {
        mc = new ManagementCompany("Railey", "555555555", 10.0);
        mc.addProperty("Mystic Cove","Lakepointe", 5327.0, "Joey BagODonuts", 1,1,1,1);
        String s = mc.toString();
        assertTrue(s.contains("List of the properties for Railey, taxID: 555555555"));
        assertTrue(s.contains("Mystic Cove,Lakepointe,Joey BagODonuts,5327.0"));
    }
}
