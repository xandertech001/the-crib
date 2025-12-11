import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircusDriverAppJUnitTest {
	private Circus circus;

	@BeforeEach
	void setUp() {
		circus = new Circus();
	}

	@Test
	void testAddDog() {
		Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
		circus.addAnimal(dog);
		List<Animal> animals = circus.getAnimals();
		assertEquals(1, animals.size());
		assertTrue(animals.get(0) instanceof Dog);
		assertEquals("Shila", animals.get(0).getName());
	}

	@Test
	void testAddBird() {
		Bird bird = new Bird("Tweety", 2, "Canary", "Yellow");
		circus.addAnimal(bird);
		List<Animal> animals = circus.getAnimals();
		assertEquals(1, animals.size());
		assertTrue(animals.get(0) instanceof Bird);
		assertEquals("Tweety", animals.get(0).getName());
		assertEquals(2, animals.get(0).getAge());
	}

	@Test
	void testDisplayAnimals() {
		// Redirect System.out to capture output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));

		// Add animals
		Dog dog = new Dog("Buddy", 5, "Labrador", "Black");
		Lion lion = new Lion("Simba", 7, "African Lion", "Golden");
		circus.addAnimal(dog);
		circus.addAnimal(lion);

		// Display animals
		circus.displayAllAnimals();

		// Restore System.out
		System.setOut(originalOut);

		// Verify output contains animal names
		String output = outputStream.toString();
		assertTrue(output.contains("Buddy"));
		assertTrue(output.contains("Simba"));
	}

	@Test
	void testSortAnimalsByAge() {
		// Add animals with different ages
		Dog dog = new Dog("Buddy", 5, "Labrador", "Black");
		Lion lion = new Lion("Simba", 3, "African Lion", "Golden");
		Horse horse = new Horse("Thunder", 8, "Mustang", "Brown");
		Bird bird = new Bird("Tweety", 1, "Canary", "Yellow");

		circus.addAnimal(dog);
		circus.addAnimal(lion);
		circus.addAnimal(horse);
		circus.addAnimal(bird);

		// Sort by age
		circus.sortAnimalsByAge();

		// Verify sorted order
		List<Animal> animals = circus.getAnimals();
		assertEquals(1, animals.get(0).getAge()); // Tweety
		assertEquals(3, animals.get(1).getAge()); // Simba
		assertEquals(5, animals.get(2).getAge()); // Buddy
		assertEquals(8, animals.get(3).getAge()); // Thunder
	}

	@Test
	void testSortAnimalsByName() {
		// Add animals with different names
		Dog dog = new Dog("Zeus", 5, "Labrador", "Black");
		Lion lion = new Lion("Alpha", 3, "African Lion", "Golden");
		Horse horse = new Horse("Thunder", 8, "Mustang", "Brown");
		Bird bird = new Bird("Tweety", 1, "Canary", "Yellow");

		circus.addAnimal(dog);
		circus.addAnimal(lion);
		circus.addAnimal(horse);
		circus.addAnimal(bird);

		// Sort by name
		circus.sortAnimalsByName();

		// Verify sorted order (alphabetically)
		List<Animal> animals = circus.getAnimals();
		assertEquals("Alpha", animals.get(0).getName());
		assertEquals("Thunder", animals.get(1).getName());
		assertEquals("Tweety", animals.get(2).getName());
		assertEquals("Zeus", animals.get(3).getName());
	}

	@Test
	void testSearchAnimalByName() {
		// Redirect System.out to capture output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));

		// Add animals
		Dog dog = new Dog("Buddy", 5, "Labrador", "Black");
		Lion lion = new Lion("Simba", 7, "African Lion", "Golden");
		circus.addAnimal(dog);
		circus.addAnimal(lion);

		// Search for existing animal
		circus.searchAnimalByName("Buddy");
		String output = outputStream.toString();
		assertTrue(output.contains("Animal found"));
		assertTrue(output.contains("Buddy"));

		// Clear output stream
		outputStream.reset();

		// Search for non-existing animal
		circus.searchAnimalByName("Rex");
		output = outputStream.toString();
		assertTrue(output.contains("not found"));

		// Restore System.out
		System.setOut(originalOut);
	}

	@Test
	void testAddAndDisplayTickets() {
		// Generate tickets
		Ticket ticket1 = circus.generateTicket("Monday", 50.0, 25);
		Ticket ticket2 = circus.generateTicket("Saturday", 50.0, 10);

		// Verify tickets were added
		List<Ticket> tickets = circus.getTickets();
		assertEquals(2, tickets.size());
		assertNotNull(ticket1);
		assertNotNull(ticket2);

		// Verify ticket details
		assertTrue(tickets.contains(ticket1));
		assertTrue(tickets.contains(ticket2));
	}
}