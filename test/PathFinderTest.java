import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.andersenlab.graph.*;
import java.util.ArrayList;

public class PathFinderTest {
    @Test
    public void getOptiomalPathOneStep() {
        try {
            Graph graph = new Graph.Builder()
                    .edge(1, 2, 1)
                    .edge(1, 3, 1)
                    .edge(4, 1, 1)
                    .edge(1, 4, 2)
                    .edge(2, 3, 2)
                    .edge(1, 5, 5)
                    .edge(3, 4, 1)
                    .edge(4, 5, 1)
                    .edge(2, 4, 5.1)
                    .build();
            ArrayList<Edge> edges = new PathFinder(graph, 1, 4).getOptiomalPath();
            assertEquals(2, edges.get(0).getWeight(), 0.1);
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }

    @Test
    public void getOptiomalPathTwoSteps1() {
        try {
            Graph graph = new Graph.Builder()
                    .edge(1, 2, 1)
                    .edge(1, 3, 1)
                    .edge(4, 1, 1)
                    .edge(1, 4, 2)
                    .edge(2, 3, 2)
                    .edge(1, 5, 5)
                    .edge(3, 4, 1)
                    .edge(4, 5, 1)
                    .edge(2, 4, 5.1)
                    .build();
            ArrayList<Edge> edges = new PathFinder(graph, 1, 5).getOptiomalPath();
            assertEquals(4, edges.get(1).getStartPoint());
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }

    @Test
    public void getOptiomalPathTwoSteps2() {
        try {
            Graph graph = new Graph.Builder()
                    .edge(1, 2, 1)
                    .edge(1, 3, 6)
                    .edge(4, 1, 1)
                    .edge(1, 4, 2)
                    .edge(2, 3, 2)
                    .edge(1, 5, 5)
                    .edge(3, 4, 1)
                    .edge(4, 5, 1)
                    .edge(2, 4, 5.1)
                    .build();
            ArrayList<Edge> edges = new PathFinder(graph, 1, 3).getOptiomalPath();
            assertEquals(2, edges.get(0).getEndPoint());
        } catch (Exception exception) {
            assertEquals(Edge.CREATE_EXCEPTION_TEXT, exception.getMessage());
        }
    }

    @Test
    public void getOptiomalPathFail() {
        try {
            Graph graph = new Graph.Builder()
                    .edge(1, 2, 1)
                    .edge(4, 5, 1)
                    .build();
            ArrayList<Edge> edges = new PathFinder(graph, 2, 3).getOptiomalPath();
        } catch (Exception exception) {
            assertEquals(PathFinder.CANT_FIND_EXCEPTION_TEXT, exception.getMessage());
        }
    }
}
