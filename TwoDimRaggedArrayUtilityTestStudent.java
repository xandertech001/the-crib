import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtilityTestStudent {

	// A sample ragged array for testing
	private double[][] data1 = {
			{ 1.0, 2.0, 3.0 },
			{ 4.0, 5.0, 6.0, 7.0 },
			{ 8.0, 9.0 },
			{ 10.0, 11.0, 12.0, 13.0, 14.0 } // Longest row/max columns
	};
	private double[][] data2 = {
			{ 10.0, 20.0 },
			{ -5.0, 0.0, 5.0 }
	};
	private File inputFile, outputFile;
	private final double DELTA = 0.001; // Tolerance for double comparisons

	@BeforeEach
	void setUp() throws Exception {
		// Create a temporary input file for file testing
		inputFile = new File("testInput.txt");
		PrintWriter fileWriter = new PrintWriter(inputFile);
		// Write data1 content to the file
		fileWriter.println("1.0 2.0 3.0");
		fileWriter.println("4.0 5.0 6.0 7.0");
		fileWriter.println("8.0 9.0");
		fileWriter.println("10.0 11.0 12.0 13.0 14.0");
		fileWriter.close();

		// Set up output file name
		outputFile = new File("testOutput.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
		// Clean up files after each test
		if (inputFile.exists()) {
			inputFile.delete();
		}
		if (outputFile.exists()) {
			outputFile.delete();
		}
	}

	/**
	 * Test the readFile method
	 */
	@Test
	void testReadFile() {
		try {
			double[][] result = TwoDimRaggedArrayUtility.readFile(inputFile);

			// Check array dimensions
			assertEquals(4, result.length); // 4 rows
			assertEquals(3, result[0].length); // Row 0 has 3 elements
			assertEquals(4, result[1].length); // Row 1 has 4 elements
			assertEquals(2, result[2].length); // Row 2 has 2 elements
			assertEquals(5, result[3].length); // Row 3 has 5 elements

			// Check content
			assertEquals(1.0, result[0][0], DELTA);
			assertEquals(14.0, result[3][4], DELTA);

		} catch (FileNotFoundException e) {
			fail("FileNotFoundException should not be thrown");
		}
	}
	
	/**
	 * Test readFile for FileNotFoundException
	 */
	@Test
	void testReadFile_FileNotFound() {
	    try {
	        TwoDimRaggedArrayUtility.readFile(new File("nonExistentFile.txt"));
	        fail("Should have thrown FileNotFoundException");
	    } catch (FileNotFoundException e) {
	        assertTrue(true); // Success
	    }
	}

	/**
	 * Test the writeToFile method
	 */
	@Test
	void testWriteToFile() {
		try {
			TwoDimRaggedArrayUtility.writeToFile(data1, outputFile);
			// Now read the file back to verify content
			double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);

			// Verify the read-back array matches the original data1
			assertEquals(data1.length, result.length);
			for (int r = 0; r < data1.length; r++) {
				assertEquals(data1[r].length, result[r].length);
				for (int c = 0; c < data1[r].length; c++) {
					assertEquals(data1[r][c], result[r][c], DELTA);
				}
			}

		} catch (FileNotFoundException e) {
			fail("FileNotFoundException should not be thrown");
		}
	}

	/**
	 * Test getTotal method
	 */
	@Test
	void testGetTotal() {
		// Total for data1: 1+2+3 + 4+5+6+7 + 8+9 + 10+11+12+13+14 = 105.0
		assertEquals(105.0, TwoDimRaggedArrayUtility.getTotal(data1), DELTA);

		// Total for data2: 10+20 + -5+0+5 = 30.0
		assertEquals(30.0, TwoDimRaggedArrayUtility.getTotal(data2), DELTA);
	}

	/**
	 * Test getAverage method
	 */
	@Test
	void testGetAverage() {
		// Total for data1 is 105.0, count is 14. Average = 105.0 / 14 = 7.5
		assertEquals(7.5, TwoDimRaggedArrayUtility.getAverage(data1), DELTA);

		// Total for data2 is 30.0, count is 5. Average = 30.0 / 5 = 6.0
		assertEquals(6.0, TwoDimRaggedArrayUtility.getAverage(data2), DELTA);
	}

	/**
	 * Test getRowTotal method
	 */
	@Test
	void testGetRowTotal() {
		// Row 0: 1.0 + 2.0 + 3.0 = 6.0
		assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(data1, 0), DELTA);
		// Row 1: 4.0 + 5.0 + 6.0 + 7.0 = 22.0
		assertEquals(22.0, TwoDimRaggedArrayUtility.getRowTotal(data1, 1), DELTA);
		// Row 3: 10.0 + 11.0 + 12.0 + 13.0 + 14.0 = 60.0
		assertEquals(60.0, TwoDimRaggedArrayUtility.getRowTotal(data1, 3), DELTA);
		
		// Test boundary: attempting to access a non-existent row should throw an ArrayIndexOutOfBoundsException
	    try {
	    	TwoDimRaggedArrayUtility.getRowTotal(data1, 5); // data1 has 4 rows (0-3)
	        fail("Should have thrown ArrayIndexOutOfBoundsException for invalid row index");
	    } catch (ArrayIndexOutOfBoundsException e) {
	        assertTrue(true); // Success
	    }
	}

	/**
	 * Test getColumnTotal method
	 */
	@Test
	void testGetColumnTotal() {
		// Col 0: 1.0 + 4.0 + 8.0 + 10.0 = 23.0 (All rows have Col 0)
		assertEquals(23.0, TwoDimRaggedArrayUtility.getColumnTotal(data1, 0), DELTA);
		// Col 2: 3.0 + 6.0 + 12.0 = 21.0 (Row 2 is ragged, missing Col 2)
		assertEquals(21.0, TwoDimRaggedArrayUtility.getColumnTotal(data1, 2), DELTA);
		// Col 4: 14.0 (Only Row 3 has Col 4)
		assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(data1, 4), DELTA);
		// Col 5: 0.0 (No row has Col 5)
		assertEquals(0.0, TwoDimRaggedArrayUtility.getColumnTotal(data1, 5), DELTA);
	}

	/**
	 * Test getHighestInRow method
	 */
	@Test
	void testGetHighestInRow() {
		// Row 0: {1.0, 2.0, 3.0}. Highest is 3.0
		assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(data1, 0), DELTA);
		// Row 1: {4.0, 5.0, 6.0, 7.0}. Highest is 7.0
		assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInRow(data1, 1), DELTA);
		// Row 3: {10.0, 11.0, 12.0, 13.0, 14.0}. Highest is 14.0
		assertEquals(14.0, TwoDimRaggedArrayUtility.getHighestInRow(data1, 3), DELTA);
	}

	/**
	 * Test getHighestInRowIndex method
	 */
	@Test
	void testGetHighestInRowIndex() {
		// Row 0: {1.0, 2.0, 3.0}. Highest (3.0) is at index 2
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 0));
		// Row 1: {4.0, 5.0, 6.0, 7.0}. Highest (7.0) is at index 3
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(data1, 1));
	}

	/**
	 * Test getLowestInRow method
	 */
	@Test
	void testGetLowestInRow() {
		// Row 0: {1.0, 2.0, 3.0}. Lowest is 1.0
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(data1, 0), DELTA);
		// Row 2: {8.0, 9.0}. Lowest is 8.0
		assertEquals(8.0, TwoDimRaggedArrayUtility.getLowestInRow(data1, 2), DELTA);
		// Data 2, Row 1: {-5.0, 0.0, 5.0}. Lowest is -5.0
		assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInRow(data2, 1), DELTA);
	}

	/**
	 * Test getLowestInRowIndex method
	 */
	@Test
	void testGetLowestInRowIndex() {
		// Row 0: {1.0, 2.0, 3.0}. Lowest (1.0) is at index 0
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 0));
		// Data 2, Row 1: {-5.0, 0.0, 5.0}. Lowest (-5.0) is at index 0
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data2, 1));
	}

	/**
	 * Test getHighestInColumn method
	 */
	@Test
	void testGetHighestInColumn() {
		// Col 0: {1.0, 4.0, 8.0, 10.0}. Highest is 10.0
		assertEquals(10.0, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 0), DELTA);
		// Col 2: {3.0, 6.0, (ragged), 12.0}. Highest is 12.0
		assertEquals(12.0, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 2), DELTA);
		// Col 4: {(ragged), (ragged), (ragged), 14.0}. Highest is 14.0
		assertEquals(14.0, TwoDimRaggedArrayUtility.getHighestInColumn(data1, 4), DELTA);
		// Data 2, Col 0: {10.0, -5.0}. Highest is 10.0
		assertEquals(10.0, TwoDimRaggedArrayUtility.getHighestInColumn(data2, 0), DELTA);
	}

	/**
	 * Test getHighestInColumnIndex method
	 */
	@Test
	void testGetHighestInColumnIndex() {
		// Col 0: {1.0, 4.0, 8.0, 10.0}. Highest (10.0) is at Row 3
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 0));
		// Col 2: {3.0, 6.0, (ragged), 12.0}. Highest (12.0) is at Row 3
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1, 2));
		// Data 2, Col 0: {10.0, -5.0}. Highest (10.0) is at Row 0
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data2, 0));
	}

	/**
	 * Test getLowestInColumn method
	 */
	@Test
	void testGetLowestInColumn() {
		// Col 0: {1.0, 4.0, 8.0, 10.0}. Lowest is 1.0
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 0), DELTA);
		// Col 1: {2.0, 5.0, 9.0, 11.0}. Lowest is 2.0
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 1), DELTA);
		// Data 2, Col 0: {10.0, -5.0}. Lowest is -5.0
		assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInColumn(data2, 0), DELTA);
	}

	/**
	 * Test getLowestInColumnIndex method
	 */
	@Test
	void testGetLowestInColumnIndex() {
		// Col 0: {1.0, 4.0, 8.0, 10.0}. Lowest (1.0) is at Row 0
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 0));
		// Col 2: {3.0, 6.0, (ragged), 12.0}. Lowest (3.0) is at Row 0
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1, 2));
		// Data 2, Col 0: {10.0, -5.0}. Lowest (-5.0) is at Row 1
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data2, 0));
	}

	/**
	 * Test getHighestInArray method
	 */
	@Test
	void testGetHighestInArray() {
		// Highest in data1 is 14.0
		assertEquals(14.0, TwoDimRaggedArrayUtility.getHighestInArray(data1), DELTA);
		// Highest in data2 is 20.0
		assertEquals(20.0, TwoDimRaggedArrayUtility.getHighestInArray(data2), DELTA);
	}

	/**
	 * Test getLowestInArray method
	 */
	@Test
	void testGetLowestInArray() {
		// Lowest in data1 is 1.0
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data1), DELTA);
		// Lowest in data2 is -5.0
		assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInArray(data2), DELTA);
	}
}