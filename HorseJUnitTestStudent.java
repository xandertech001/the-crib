import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


class HorseJUnitTestStudent {

	private Horse horse;
	private Horse horse2;
	private Horse horse3;
	@BeforeEach
	void setUp() {
		horse = new Horse("Unicorn", 5, "Pegasus", "White"); 
		horse2 = new Horse("Pumkin", 5, "Pegasus", "Brown");
		horse3 = new Horse("Unicorn", 5, "Pegasus", "White");
	}
	
	@Test
	void equals() { 
		assertFalse(horse.equals(horse2)); 
		assertTrue(horse.equals(horse3)); 
		assertFalse(horse2.equals(horse3));
	}
	
	

}
