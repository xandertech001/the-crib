/**
 * Class representing the edge (road) between two towns
 */
public class Road implements Comparable<Road> {

	private int weight;
	private String name;
	private Town source;
	private Town destination;

	/**
	 * Constructor
	 * 
	 * @param source - the source town
	 * @param destination - the destination town
	 * @param degrees - the distance weight
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;
	}

	/**
	 * Constructor with default weight of 1
	 * 
	 * @param source - the source town
	 * @param destination - the destination town
	 * @param name - the name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this(source, destination, 1, name);
	}

	/**
	 * Checks if this road connects to the specified town
	 * 
	 * @param town - the town to check
	 * @return true if connected, otherwise false
	 */
	public boolean contains(Town town) {
		return source.equals(town) || destination.equals(town);
	}

	/**
	 * Get name of the road
	 * 
	 * @return the road name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets destination
	 * 
	 * @return the destination town
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 * Gets source town
	 * 
	 * @return the source town
	 */
	public Town getSource() {
		return source;
	}

	/**
	 * Gets the distance weight
	 * 
	 * @return the distance
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Comparison for two roads
	 * 
	 * @param r - the road to compare to
	 * @return comparison value
	 */
	@Override
	public int compareTo(Road r) {
		return this.name.compareTo(r.getName());
	}

	/**
	 * String representation
	 * 
	 * @return road string details
	 */
	@Override
	public String toString() {
		return name + " connects " + source + " and " + destination + " (" + weight + " mi)";
	}

	/**
	 * Equality of two roads regardless of direction
	 * 
	 * @param obj - the object to compare
	 * @return true if same endpoints, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Road other = (Road) obj;
		return (this.source.equals(other.source) && this.destination.equals(other.destination))
				|| (this.source.equals(other.destination) && this.destination.equals(other.source));
	}
}