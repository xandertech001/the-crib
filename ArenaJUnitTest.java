import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaJUnitTest {

	private Arena arena;

	@BeforeEach
	void setUp() {
		arena = new Arena("Blue", 100.0, 50.0);
	}

	@Test
	void testConstructorAndInitialValues() {
		assertEquals("Blue", arena.getColor(), "Initial color is incorrect.");
		assertEquals(100.0, arena.getLength(), 0.001, "Initial length is incorrect.");
		assertEquals(50.0, arena.getWidth(), 0.001, "Initial width is incorrect.");
		assertEquals("Arena", arena.getBuildingType(), "Initial building type is incorrect.");
	}

	@Test
	// testSetSize()
	void testSetSize() {
		arena.setSize(10.0, 10.0);
		assertEquals(10.0, arena.getWidth());
		assertEquals(10.0, arena.getLength());
	}

	@Test
	// testSetColor()
	void testSetColor() {
		arena.setColor("Pink");
		assertEquals("Pink", arena.getColor());
	}

	@Test
	// testSetBuildingType()
	void testSetBuildingType() {
		arena.setBuildingType("Stadium");
		assertEquals("Stadium", arena.getBuildingType());
	}

	@Test
	// testToString()
	void testToString() {
		Arena stadium = new Arena("White", 100.0, 50.0);
		String expected = "Arena color: White\nLength: 100.0\nWidth: 50.0";
		assertEquals(expected, stadium.toString());
	}

}
