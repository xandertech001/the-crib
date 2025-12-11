import java.util.Objects;

public class Lion implements Animal {
	// instance variables
	private String name;
	private int age;
	private String species;
	private String color;

	// constructor
	public Lion(String name, int age, String species, String color) {
		this.name = name;
		this.age = age;
		this.species = species;
		this.color = color;
	}

	@Override
	// move()
	public void move() {
		System.out.println("The lion is walking");
	}

	@Override
	// makeSound()
	public void makeSound() {
		System.out.println("The lion roars");
	}

	@Override
	// getName()
	public String getName() {
		return name;
	}

	@Override
	// getAge()
	public int getAge() {
		return age;
	}

	// equals()
	// Check for reference equality
	// Check for null or different class
	// Compare fields for logical equality
	@Override
	public boolean equals(Object obj) {
		// Check for reference equality
		if (this == obj) {
			return true;
		}

		// Check for null or different class
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		// Cast and compare fields
		Lion other = (Lion) obj;
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(species, other.species)
				&& Objects.equals(color, other.color);
	}

	@Override
	// toString()
	public String toString() {
		return "Name: " + getName() + "\nAge: " + getAge() + "\nSpecies: " + species + "\nColor: " + color;
	}

}
