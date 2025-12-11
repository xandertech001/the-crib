import java.util.ArrayList;
import java.util.List;

public class Circus {
	private List<Animal> animals;
	private List<Person> persons;
	private List<Building> buildings;
	private List<Ticket> tickets;

	public Circus() {
		animals = new ArrayList<>();
		persons = new ArrayList<>();
		buildings = new ArrayList<>();
		tickets = new ArrayList<>();
	}

	// Getter methods for testing
	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	// Add building
	public void addBuilding(Building building) {
		buildings.add(building);
	}

	// Display building
	public void displayAllBuildings() {
		if (buildings.isEmpty()) {
			System.out.println("No buildings to display.");
			return;
		}
		for (Building building : buildings) {
			System.out.println(building.toString());
			System.out.println("------------------------");
		}
	}

	// Add person
	public void addPerson(Person person) {
		persons.add(person);
	}

	// Display person
	public void displayAllPersons() {
		if (persons.isEmpty()) {
			System.out.println("No persons to display.");
			return;
		}
		for (Person person : persons) {
			System.out.println(person.toString());
			System.out.println("----------------------");
		}
	}

	// Add animal
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	// Display animal using toString() method
	public void displayAllAnimals() {
		if (animals.isEmpty()) {
			System.out.println("No animals to display.");
			return;
		}
		for (Animal animal : animals) {
			System.out.println(animal.toString());
			System.out.println("----------------------");
		}
	}

	// Selection sort to sort animals by age
	public void sortAnimalsByAge() {
		int n = animals.size();
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
					minIndex = j;
				}
			}
			// Swap animals
			Animal temp = animals.get(minIndex);
			animals.set(minIndex, animals.get(i));
			animals.set(i, temp);
		}
	}

	// Selection sort to sort animals by name
	public void sortAnimalsByName() {
		int n = animals.size();
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (animals.get(j).getName().compareTo(animals.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}
			// Swap animals
			Animal temp = animals.get(minIndex);
			animals.set(minIndex, animals.get(i));
			animals.set(i, temp);
		}
	}

	// Search for an animal by name
	public void searchAnimalByName(String name) {
		boolean found = false;
		for (Animal animal : animals) {
			if (animal.getName().equalsIgnoreCase(name)) {
				System.out.println("Animal found:");
				System.out.println(animal.toString());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Animal with name '" + name + "' not found.");
		}
	}

	// Add ticket
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	// Generate ticket
	public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
		Ticket ticket = new Ticket(dayOfWeek, basePrice, age); // Pass dayOfWeek, basePrice, age to Ticket constructor
		addTicket(ticket);
		return ticket;
	}
}
