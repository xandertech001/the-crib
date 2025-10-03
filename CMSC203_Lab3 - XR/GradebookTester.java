
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;

class GradebookTester {

	GradeBook g1;
	GradeBook g2;
	GradeBook g3;
	
	String test1 = "100.0 72.0"; 
	String test2 = "22.0 98.0"; 
	
	double sum1 = 100.0 + 72.0; 
	double sum2 = 22.0 + 98.0; 
	
	double small1 = 72.0; 
	double small2 = 22.0; 

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);

		g1.addScore(100.0);
		g1.addScore(72.0);

		g2.addScore(22.0);
		g2.addScore(98.0);

	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testGradeBook() {
		g3 =  new GradeBook(3); 
		
		g3.addScore(100.0);
		g3.addScore(72.0);
		g3.addScore(22.0);
	
		
		assertEquals(3, g3.getScoreSize());
		
		
		assertFalse(g3.addScore(100));
		}

	@Test
	void testAddScore() {
	
	assertTrue(test1.equals(g1.toString())); 
	assertTrue(test2.equals(g2.toString()));
	
	assertEquals(2,(g1.getScoreSize()));
	assertEquals(2,(g2.getScoreSize()));
	}

	@Test
	void testSum() {
		
		
		assertEquals(sum1, g1.sum(), 0.001); 
		assertEquals(sum2, g2.sum(), 0.001); 
		
	}

	@Test
	void testMinimum() {
		
		assertEquals(small1, g1.minimum(), 0.001); 
		assertEquals(small2, g2.minimum(), 0.001); 
	}

	@Test
	void testFinalScore() {
		assertEquals((sum1 - small1), g1.finalScore(), 0.001); 
		assertEquals((sum2 - small2), g2.finalScore(), 0.001); 
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize()); 
		assertEquals(2, g2.getScoreSize()); 
	}

	@Test
	void testToString() {
		assertTrue(test1.equals(g1.toString())); 
		assertTrue(test2.equals(g2.toString()));
	}

}
