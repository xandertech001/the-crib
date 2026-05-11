import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Custom student unit test suite validating Edge-Cases.
 */
public class StudentTest {

    private TownGraphManager manager;

    @BeforeEach
    public void setUp() {
        manager = new TownGraphManager();
    }

    @Test
    public void testDisconnectedGraphPath() {
        manager.addTown("IsolatedTownA");
        manager.addTown("IsolatedTownB");
        ArrayList<String> path = manager.getPath("IsolatedTownA", "IsolatedTownB");
        assertTrue(path.isEmpty());
    }

    @Test
    public void testDeleteTownClearsConnectedEdges() {
        manager.addTown("TownA");
        manager.addTown("TownB");
        manager.addRoad("TownA", "TownB", 5, "Highway1");
        assertTrue(manager.containsRoadConnection("TownA", "TownB"));

        manager.deleteTown("TownA");
        assertFalse(manager.containsRoadConnection("TownA", "TownB"));
        assertNull(manager.getRoad("TownA", "TownB"));
    }

    @Test
    public void testRoadCompareToSymmetric() {
        Town t1 = new Town("A");
        Town t2 = new Town("B");
        Road r1 = new Road(t1, t2, 10, "Route66");
        Road r2 = new Road(t2, t1, 10, "Route66");
        assertEquals(0, r1.compareTo(r2));
    }

    @Test
    public void testGraphReconstructionIntegrity() {
        manager.addTown("TownA");
        manager.addTown("TownB");
        manager.addTown("TownC");
        manager.addRoad("TownA", "TownB", 10, "Road1");
        manager.addRoad("TownB", "TownC", 5, "Road2");

        ArrayList<String> originalPath = manager.getPath("TownA", "TownC");
        assertEquals(2, originalPath.size());

        manager.deleteRoadConnection("TownB", "TownC", "Road2");
        ArrayList<String> brokenPath = manager.getPath("TownA", "TownC");
        assertTrue(brokenPath.isEmpty());
    }

    @Test
    public void testEdgesOfNonexistentTownThrowsException() {
        Graph graph = new Graph();
        Town realTown = new Town("Real");
        graph.addVertex(realTown);
        Town fakeTown = new Town("Fake");

        assertThrows(IllegalArgumentException.class, () -> {
            graph.edgesOf(fakeTown);
        });
    }

    @Test
    public void testGetEdgeWithNullVerticesReturnsNull() {
        Graph graph = new Graph();
        Town t = new Town("A");
        graph.addVertex(t);
        assertNull(graph.getEdge(t, null));
        assertNull(graph.getEdge(null, t));
    }

    @Test
    public void testRoadSymmetricEquivalence() {
        Town t1 = new Town("Frederick");
        Town t2 = new Town("Germantown");
        Road r1 = new Road(t1, t2, 15, "I-270");
        Road r2 = new Road(t2, t1, 15, "I-270");
        assertTrue(r1.equals(r2));
    }

    @Test
    public void testFileParsingRobustness() throws FileNotFoundException {
        File tempFile = new File("test_map.txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("I-95,12;Baltimore;Columbia");
            writer.println("Route-29,8;Columbia;Ellicott City");
        }

        manager.populateTownGraph(tempFile);
        assertTrue(manager.containsTown("Baltimore"));
        assertTrue(manager.containsTown("Columbia"));
        assertTrue(manager.containsTown("Ellicott City"));
        assertTrue(manager.containsRoadConnection("Baltimore", "Columbia"));
        
        tempFile.delete();
    }
}