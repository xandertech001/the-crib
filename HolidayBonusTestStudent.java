import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HolidayBonusTestStudent {

	// Test data: A complex ragged array to test all bonus conditions
	private double[][] data1 = {
			{ 10.0, 50.0, 30.0 },                   // Row 0
			{ 20.0, 10.0 },                         // Row 1 (Ragged)
			{ 30.0, 70.0, 60.0, 5.0 },              // Row 2 (Longest row)
			{ 40.0, 50.0, 30.0 }                    // Row 3 (Ragged)
	};

	// Test data with zero and negative values
	private double[][] data2 = {
			{ 10.0, 50.0, -1.0 },                   // Row 0: Negative sale at index 2
			{ 20.0, 0.0, 80.0 },                    // Row 1: Zero sale at index 1
			{ 30.0, 70.0, 50.0 }                    // Row 2
	};

	// Test data with only one positive value in a column (tests highest/lowest tie)
	private double[][] data3 = {
			{ 1.0 },
			{ 0.0, 2.0 },
			{ 0.0, 0.0, 3.0 }
	};

	private final double DELTA = 0.001;
	private final double HIGH_BONUS = 5000.0;
	private final double MEDIUM_BONUS = 2000.0;
	private final double LOW_BONUS = 1000.0;

	@BeforeEach
	void setUp() throws Exception {
		// No setup needed as data is hardcoded
	}

	@AfterEach
	void tearDown() throws Exception {
		// No cleanup needed
	}

	/**
	 * Test calculateHolidayBonus for data1 (Complex Ragged Array)
	 * * Expected breakdown (H=5000, M=2000, L=1000, 0=None):
	 * Col 0: {10, 20, 30, 40} -> H=40, L=10
	 * R0 (10): L (1000)
	 * R1 (20): M (2000)
	 * R2 (30): M (2000)
	 * R3 (40): H (5000)
	 * * Col 1: {50, 10, 70, 50} -> H=70, L=10
	 * R0 (50): M (2000)
	 * R1 (10): L (1000)
	 * R2 (70): H (5000)
	 * R3 (50): M (2000)
	 * * Col 2: {30, missing, 60, 30} -> H=60, L=30
	 * R0 (30): L (1000)
	 * R1 (missing): 0
	 * R2 (60): H (5000)
	 * R3 (30): L (1000)
	 * * Col 3: {missing, missing, 5, missing} -> H=5, L=5 (Only positive value, gets H)
	 * R0, R1, R3 (missing): 0
	 * R2 (5): H (5000)
	 * * Total Per Store:
	 * R0: 1000 + 2000 + 1000 + 0 = 4000.0
	 * R1: 2000 + 1000 + 0 + 0 = 3000.0
	 * R2: 2000 + 5000 + 5000 + 5000 = 17000.0
	 * R3: 5000 + 2000 + 1000 + 0 = 8000.0
	 */
	@Test
	void testCalculateHolidayBonus_data1() {
		double[] expectedBonuses = { 4000.0, 3000.0, 17000.0, 8000.0 };
		double[] result = HolidayBonus.calculateHolidayBonus(data1);
		
		assertEquals(expectedBonuses.length, result.length);
		for (int i = 0; i < expectedBonuses.length; i++) {
			assertEquals("Store " + i + " bonus incorrect", expectedBonuses[i], result[i], DELTA);
		}
	}

	/**
	 * Test calculateHolidayBonus for data2 (Negatives and Zeros)
	 * * Col 0: {10, 20, 30} -> H=30, L=10
	 * R0 (10): L (1000)
	 * R1 (20): M (2000)
	 * R2 (30): H (5000)
	 * * Col 1: {50, 0, 70} -> Positives={50, 70} -> H=70, L=50
	 * R0 (50): L (1000)
	 * R1 (0): 0 (Zero sale)
	 * R2 (70): H (5000)
	 * * Col 2: {-1, 80, 50} -> Positives={80, 50} -> H=80, L=50
	 * R0 (-1): 0 (Negative sale)
	 * R1 (80): H (5000)
	 * R2 (50): L (1000)
	 * * Total Per Store:
	 * R0: 1000 + 1000 + 0 = 2000.0
	 * R1: 2000 + 0 + 5000 = 7000.0
	 * R2: 5000 + 5000 + 1000 = 11000.0
	 */
	@Test
	void testCalculateHolidayBonus_data2() {
		double[] expectedBonuses = { 2000.0, 7000.0, 11000.0 };
		double[] result = HolidayBonus.calculateHolidayBonus(data2);

		assertEquals(expectedBonuses.length, result.length);
		assertEquals(2000.0, result[0], DELTA);
		assertEquals(7000.0, result[1], DELTA);
		assertEquals(11000.0, result[2], DELTA);
	}

	/**
	 * Test calculateHolidayBonus for data3 (Single positive value in a column)
	 * * Col 0: {1, 0, 0} -> Positives={1} -> H=1, L=1
	 * R0 (1): H (5000)
	 * R1 (0): 0
	 * R2 (0): 0
	 * * Col 1: {missing, 2, 0} -> Positives={2} -> H=2, L=2
	 * R0 (missing): 0
	 * R1 (2): H (5000)
	 * R2 (0): 0
	 * * Col 2: {missing, missing, 3} -> Positives={3} -> H=3, L=3
	 * R0, R1 (missing): 0
	 * R2 (3): H (5000)
	 * * Total Per Store:
	 * R0: 5000 + 0 + 0 = 5000.0
	 * R1: 0 + 5000 + 0 = 5000.0
	 * R2: 0 + 0 + 5000 = 5000.0
	 */
	@Test
	void testCalculateHolidayBonus_data3_SingleValueInColumn() {
		double[] expectedBonuses = { 5000.0, 5000.0, 5000.0 };
		double[] result = HolidayBonus.calculateHolidayBonus(data3);

		assertEquals(expectedBonuses.length, result.length);
		assertEquals(5000.0, result[0], DELTA);
		assertEquals(5000.0, result[1], DELTA);
		assertEquals(5000.0, result[2], DELTA);
	}

	/**
	 * Test calculateTotalHolidayBonus for data1
	 * Expected Total: 4000.0 + 3000.0 + 17000.0 + 8000.0 = 32000.0
	 */
	@Test
	void testCalculateTotalHolidayBonus_data1() {
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(data1), DELTA);
	}

	/**
	 * Test calculateTotalHolidayBonus for data2
	 * Expected Total: 2000.0 + 7000.0 + 11000.0 = 20000.0
	 */
	@Test
	void testCalculateTotalHolidayBonus_data2() {
		assertEquals(20000.0, HolidayBonus.calculateTotalHolidayBonus(data2), DELTA);
	}

	/**
	 * Test calculateTotalHolidayBonus for a simple 1x1 array
	 */
	@Test
	void testCalculateTotalHolidayBonus_simple() {
		double[][] simpleData = { { 100.0 } }; // Only one value, gets HIGH_BONUS
		// Expected: 5000.0
		assertEquals(5000.0, HolidayBonus.calculateTotalHolidayBonus(simpleData), DELTA);
	}
}