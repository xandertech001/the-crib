import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Manager class connecting town operations and the underlying town graph.
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph;

	/**
	 * Constructor initializing the underlying town graph.
	 */
	public TownGraphManager() {
		graph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		if (t1 == null || t2 == null) {
			return false;
		}
		graph.addEdge(t1, t2, weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		Road road = graph.getEdge(t1, t2);
		return road != null ? road.getName() : null;
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	public Town getTown(String name) {
		for (Town town : graph.vertexSet()) {
			if (town.getName().equals(name)) {
				return town;
			}
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(getTown(town1), getTown(town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();
		for (Road road : graph.edgeSet()) {
			roads.add(road.getName());
		}
		Collections.sort(roads);
		return roads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		Road targetRoad = graph.getEdge(t1, t2);
		if (targetRoad == null || !targetRoad.getName().equals(road)) {
			return false;
		}
		graph.removeEdge(t1, t2, targetRoad.getWeight(), road);
		return true;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(getTown(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		for (Town town : graph.vertexSet()) {
			towns.add(town.getName());
		}
		Collections.sort(towns);
		return towns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(getTown(town1), getTown(town2));
	}

	/**
	 * Reads a plain text file containing routing information to generate the graph.
	 * 
	 * @param file the source data file
	 * @throws FileNotFoundException if file doesn't exist
	 */
	public void populateTownGraph(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(";");
			if (parts.length == 3) {
				String[] roadDetails = parts[0].split(",");
				String roadName = roadDetails[0];
				int weight = Integer.parseInt(roadDetails[1]);
				String town1Name = parts[1];
				String town2Name = parts[2];

				addTown(town1Name);
				addTown(town2Name);
				addRoad(town1Name, town2Name, weight, roadName);
			}
		}
		scanner.close();
	}
}