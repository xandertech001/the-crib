import java.util.Set;
import java.util.HashSet;

/**
 * This class represents vertexes in the graph (towns)
 */
public class Town implements Comparable<Town> {

	private String name;

	/**
	 * Constructor
	 * 
	 * @param the name of the town
	 */
	public Town(String name) {
		this.name = name;
	}

	/**
	 * Copy constructor
	 * 
	 * @param the town to copy
	 */
	public Town(Town givenTown) {
		this.name = givenTown.getName();
	}

	/**
	 * Gets the name of the town
	 * 
	 * @return the town name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Comparison between towns by name
	 * 
	 * @param t - the town to compare to
	 * @return 0 if names are equal, positive or negative integer otherwise
	 */
	@Override
	public int compareTo(Town t) {
		return this.name.compareTo(t.getName());
	}

	/**
	 * String representation
	 * 
	 * @return the town name
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Hashcode based on name
	 * 
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Equality
	 * 
	 * @param obj - the object to compare
	 * @return true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Town other = (Town) obj;
		return this.name.equals(other.getName());
	}
}