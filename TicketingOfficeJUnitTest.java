import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {

	private TicketingOffice office;

	@BeforeEach
	// setUp()
	void setUp() {
		office = new TicketingOffice("Black", 5, 10);
	}

	@Test
	// testConstructor()
	void testConstructor() {
		assertEquals("Black", office.getColor());
		assertEquals(5, office.getLength());
		assertEquals(10, office.getWidth());
		assertEquals("Ticketing Office", office.getBuildingType());
	}

	@Test
	// testSetSize()
	void testSetSize() {
		office.setSize(100, 200);
		assertEquals(100, office.getLength());
		assertEquals(200, office.getWidth());
	}

	@Test
	// testSetColor()
	void testSetColor() {
		office.setColor("Pink");
		assertEquals("Pink", office.getColor());
	}

	@Test
	// testSetBuildingType()
	void testSetBuildingType() {
		office.setBuildingType("Private Office");
		assertEquals("Private Office", office.getBuildingType());
	}

	@Test
	// testToString()
	void testToString() {
		assertEquals("Length: " + office.getLength() + "\nWidth: " + office.getWidth() + "\nColor: " + office.getColor()
				+ "\nBuilding Type: " + office.getBuildingType(), office.toString());
	}

}
