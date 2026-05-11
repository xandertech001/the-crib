import java.util.*;

/**
 * Undirected, weighted graph implementation utilizing Dijkstra's algorithm.
 */
public class Graph implements GraphInterface<Town, Road> {

    private Set<Town> vertices;
    private Set<Road> edges;
    private Map<Town, Town> backpointers;
    private Map<Town, Integer> shortestDistances;

    /**
     * Constructor initializing the graph structures.
     */
    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        if (sourceVertex == null || destinationVertex == null) {
            return null;
        }
        for (Road road : edges) {
            if (road.contains(sourceVertex) && road.contains(destinationVertex)) {
                return road;
            }
        }
        return null;
    }

    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        if (sourceVertex == null || destinationVertex == null) {
            throw new NullPointerException();
        }
        if (!vertices.contains(sourceVertex) || !vertices.contains(destinationVertex)) {
            throw new IllegalArgumentException();
        }
        Road road = new Road(sourceVertex, destinationVertex, weight, description);
        edges.add(road);
        return road;
    }

    @Override
    public boolean addVertex(Town v) {
        if (v == null) {
            throw new NullPointerException();
        }
        if (vertices.contains(v)) {
            return false;
        }
        vertices.add(v);
        return true;
    }

    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        return getEdge(sourceVertex, destinationVertex) != null;
    }

    @Override
    public boolean containsVertex(Town v) {
        return vertices.contains(v);
    }

    @Override
    public Set<Road> edgeSet() {
        return edges;
    }

    @Override
    public Set<Road> edgesOf(Town vertex) {
        if (vertex == null) {
            throw new NullPointerException();
        }
        if (!vertices.contains(vertex)) {
            throw new IllegalArgumentException();
        }
        Set<Road> localEdges = new HashSet<>();
        for (Road road : edges) {
            if (road.contains(vertex)) {
                localEdges.add(road);
            }
        }
        return localEdges;
    }

    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        Road target = null;
        for (Road road : edges) {
            if (road.contains(sourceVertex) && road.contains(destinationVertex) 
                    && road.getWeight() == weight && road.getName().equals(description)) {
                target = road;
                break;
            }
        }
        if (target != null) {
            edges.remove(target);
        }
        return target;
    }

    @Override
    public boolean removeVertex(Town v) {
        if (v == null || !vertices.contains(v)) {
            return false;
        }
        Set<Road> toRemove = new HashSet<>();
        for (Road road : edges) {
            if (road.contains(v)) {
                toRemove.add(road);
            }
        }
        edges.removeAll(toRemove);
        vertices.remove(v);
        return true;
    }

    @Override
    public Set<Town> vertexSet() {
        return vertices;
    }

    @Override
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        ArrayList<String> path = new ArrayList<>();
        dijkstraShortestPath(sourceVertex);
        
        if (!shortestDistances.containsKey(destinationVertex) || shortestDistances.get(destinationVertex) == Integer.MAX_VALUE) {
            return path;
        }

        Town current = destinationVertex;
        while (current != null && !current.equals(sourceVertex)) {
            Town previous = backpointers.get(current);
            if (previous == null) {
                break;
            }
            Road road = getEdge(previous, current);
            path.add(0, previous.getName() + " via " + road.getName() + " to " + current.getName() + " " + road.getWeight() + " mi");
            current = previous;
        }
        return path;
    }

    @Override
    public void dijkstraShortestPath(Town startVertex) {
        shortestDistances = new HashMap<>();
        backpointers = new HashMap<>();
        Set<Town> unvisited = new HashSet<>(vertices);

        for (Town vertex : vertices) {
            shortestDistances.put(vertex, Integer.MAX_VALUE);
        }
        shortestDistances.put(startVertex, 0);

        while (!unvisited.isEmpty()) {
            Town current = null;
            int minDistance = Integer.MAX_VALUE;

            for (Town vertex : unvisited) {
                int dist = shortestDistances.get(vertex);
                if (dist < minDistance) {
                    minDistance = dist;
                    current = vertex;
                }
            }

            if (current == null || minDistance == Integer.MAX_VALUE) {
                break;
            }

            unvisited.remove(current);

            for (Road road : edgesOf(current)) {
                Town neighbor = road.getSource().equals(current) ? road.getDestination() : road.getSource();
                if (unvisited.contains(neighbor)) {
                    int tentativeDistance = shortestDistances.get(current) + road.getWeight();
                    if (tentativeDistance < shortestDistances.get(neighbor)) {
                        shortestDistances.put(neighbor, tentativeDistance);
                        backpointers.put(neighbor, current);
                    }
                }
            }
        }
    }
}